package uk.ac.kcl.mdeoptimise.rulegen.generator.commands

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.henshin.model.HenshinFactory
import org.eclipse.emf.henshin.model.Rule
import org.sidiff.common.emf.extensions.impl.EClassifierInfoManagement
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx
import org.sidiff.serge.configuration.Configuration.OperationType
import org.sidiff.serge.core.Common
import org.sidiff.serge.filter.ElementFilter
import org.sidiff.serge.generators.conditions.LowerBoundCheckGenerator
import org.sidiff.serge.generators.conditions.UpperBoundCheckGenerator
import uk.ac.kcl.mdeoptimise.rulegen.generator.IRuleGenerationCommand
import uk.ac.kcl.mdeoptimise.rulegen.metamodel.Multiplicity
import org.sidiff.serge.configuration.GlobalConstants
import org.eclipse.emf.ecore.EClass

/**
 * Takes the n lb required repair nodes from N preserve nodes
 */
class CreateNodeLBRepairManyRuleCommand implements IRuleGenerationCommand {
	
	Multiplicity multiplicity;
	EPackage refinedMetamodelWrapper;
	EClassifierInfoManagement metamodelAnalyser;
	
	new(Multiplicity multiplicity, EPackage refinedMetamodelWrapper, EClassifierInfoManagement metamodelAnalyser){
		this.multiplicity = multiplicity;
		this.refinedMetamodelWrapper = refinedMetamodelWrapper;
		this.metamodelAnalyser = metamodelAnalyser;
	}
	
	override generate() {
		
		//Create module
		val module = HenshinFactory.eINSTANCE.createModule();
		
		//Set module name
		module.setName("CREATE_Node_" + multiplicity.sourceNode.name + "_Rules")
		module.setDescription("Creates a Node in all allowed metamodel contexts")

		//Set module metamodels
		module.getImports().add(refinedMetamodelWrapper)
		
		//TODO Test this case with a metamodel variant that has more than one container for the same 
		//classifier
		val classifierInfo = metamodelAnalyser.getAllParentContext(multiplicity.sourceNode, true);
		
		for(var contextReferenceId = 0; contextReferenceId < classifierInfo.keySet.size; contextReferenceId++) {
			
			val context = classifierInfo.get(classifierInfo.keySet.get(contextReferenceId));
			
			//Create a new rule in the module for each context container of the refined multiplicity node	
			for(var contextId = 0; contextId < context.size; contextId++){
				
				val rule = Common.createBasicRule(module, classifierInfo.keySet.get(contextReferenceId),
					multiplicity.sourceNode, context.get(contextId), null, null, OperationType.CREATE
				);
				
				val newNode = HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(rule).get(0);
		
				//Add mandatory children for the new node created
				
				//TODO Perhaps should be moved somewhere else to make only one call
				//This loads the info about mandatories in the respective classes
				val childInfo = this.metamodelAnalyser.getEClassifierInfo(multiplicity.sourceNode);
				childInfo.mandatoryNeighbours
				childInfo.mandatoryChildren
				
				val elementFilter = new ElementFilter(metamodelAnalyser);
				
				// create mandatories if any
				if(childInfo.hasMandatories()) {
					Common.createMandatoryChildren(rule, childInfo, newNode, OperationType.CREATE, true, metamodelAnalyser, elementFilter);			
					Common.createMandatoryNeighbours(rule, childInfo, newNode, OperationType.CREATE, true, elementFilter);
				}
				
				applyRepairOperations(rule)
				
					
				applyRuleNacConditions(rule);
				//Add rule to module for this context classifier
				module.getUnits().add(rule);
			}
		}
		
		return module;
	}
	
	//Fix the LB requirement for the created node by taking one node required for the LB from lb nodes of the same type
	private def void applyRepairOperations(Rule rule){
		
		
		rule.name = rule.name + "_lb_repair_many"
		
		//Get the created node from the rule graphs
		var createdNode = HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(rule).get(0);
		
		
		createdNode.getOutgoing(multiplicity.EReference).forEach[ outgoingEdge |
			
			//Find existing target node
			var existingTargetNode =  HenshinRuleAnalysisUtilEx.findCorrespondingNodeInLHS(outgoingEdge.getTarget())
		
			//Create existing node A from which to take the existing target node
			val existingsourceNodeName = Common.getFreeNodeName(GlobalConstants.NEWTGT, rule);
			val existingSourceNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, existingsourceNodeName, multiplicity.sourceNode as EClass);
	
			//Create a delete edge between existing node A and an existing node B
			HenshinRuleAnalysisUtilEx.createDeleteEdge(existingSourceNode.lhsNode, existingTargetNode, multiplicity.EReference, rule);
		]
	}
	
	//Apply the NACs
	private def void applyRuleNacConditions(Rule rule){
	
		new LowerBoundCheckGenerator(rule).generate();
		new UpperBoundCheckGenerator(rule).generate();
	}
	
}