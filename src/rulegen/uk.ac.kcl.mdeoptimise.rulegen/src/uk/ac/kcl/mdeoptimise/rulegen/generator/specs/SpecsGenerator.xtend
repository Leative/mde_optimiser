package uk.ac.kcl.mdeoptimise.rulegen.generator.specs

import uk.ac.kcl.mdeoptimise.rulegen.metamodel.RuleSpec
import java.util.Map
import java.util.List
import java.util.HashMap
import uk.ac.kcl.mdeoptimise.rulegen.metamodel.RefinedMetamodelWrapper
import java.util.ArrayList
import com.google.common.collect.Sets
import java.util.Set
import org.eclipse.emf.ecore.EReference
import java.util.HashSet
import uk.ac.kcl.mdeoptimise.rulegen.metamodel.MetamodelWrapper

class SpecsGenerator {
	
	def void addRuleSpec(RuleSpec ruleSpec){
		
		//Generate the repair specs for this rule spec and add to list of repairs
		//this.repairCommands.put(ruleSpec, this.generateRepairs(ruleSpec));
	}
	
	def Map<String, Set<List<RepairSpec>>> getRepairsForRuleSpec(RuleSpec ruleSpec, MetamodelWrapper metamodelWrapper){
		
		var generatedRepairSpecs = new HashMap<String, Set<List<RepairSpec>>>();
		
		switch(ruleSpec.actions){
			case "ALL": 
				{	
					if(ruleSpec.isEdge){
						generatedRepairSpecs.put("ADD", generateNodeRepairCombinations(generateEdgeAddRules(ruleSpec, metamodelWrapper)))
						generatedRepairSpecs.put("REMOVE", generateNodeRepairCombinations(generateEdgeRemoveRules(ruleSpec, metamodelWrapper)))
					} else {
						generatedRepairSpecs.put("CREATE", generateNodeRepairCombinations(generateNodeCreateRules(ruleSpec, metamodelWrapper)))
						generatedRepairSpecs.put("DELETE", generateNodeRepairCombinations(generateNodeDeleteRules(ruleSpec, metamodelWrapper)))
						generatedRepairSpecs.put("ADD", generateNodeRepairCombinations(generateEdgeAddRules(ruleSpec, metamodelWrapper)))
						generatedRepairSpecs.put("REMOVE", generateNodeRepairCombinations(generateEdgeRemoveRules(ruleSpec, metamodelWrapper)))
					}		
					
				
				}
			case "CREATE":
				{
					generatedRepairSpecs.put("CREATE", generateNodeRepairCombinations(generateNodeCreateRules(ruleSpec, metamodelWrapper)))
				}
			case "DELETE":
				{						
					generatedRepairSpecs.put("DELETE", generateNodeRepairCombinations(generateNodeDeleteRules(ruleSpec, metamodelWrapper)))
				}
			
			case "ADD":
				{		
					generatedRepairSpecs.put("ADD", generateNodeRepairCombinations(generateEdgeAddRules(ruleSpec, metamodelWrapper)))			
				}
			case "REMOVE":
				{
					generatedRepairSpecs.put("REMOVE", generateNodeRepairCombinations(generateEdgeRemoveRules(ruleSpec, metamodelWrapper)))
				}
			
		}
		
		return generatedRepairSpecs;
	}
	
	def Set<List<RepairSpec>> generateNodeRepairCombinations(Map<EReference, Set<RepairSpec>> repairSpecs){
		
		val repairs = new ArrayList<Set<RepairSpec>>();
		
		repairSpecs.keySet.forEach[ key |	
			repairs.add(repairSpecs.get(key));
		]
		
		return Sets.cartesianProduct(repairs);
	}

	def Map<EReference, Set<RepairSpec>> generateNodeCreateRules(RuleSpec ruleSpec, MetamodelWrapper metamodelWrapper){
		
		val repairSpecs = new HashMap<EReference, Set<RepairSpec>>();
		
		val node = metamodelWrapper.getNode(ruleSpec.getNode);
		
		node.EReferences.forEach[edge |
			
			var repairs = new HashSet<RepairSpec>();
			
			if(edge.EOpposite == null || edge.EOpposite.lowerBound == 0){
				//Apply single edge repairs
				repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE));
			} else {
				
				if(edge.lowerBound == 0){
					
					//Create node only, no mandatory neighbours needed
					repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE));
						
				} else if(edge.lowerBound != edge.upperBound){
					
					if(edge.EOpposite.lowerBound > 0 && edge.EOpposite.lowerBound != edge.EOpposite.upperBound) {
						repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE));
					}
					
					if(edge.lowerBound > 0 && edge.EOpposite.upperBound != -1){
						repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE_LB_REPAIR));
					}
				
					if(edge.lowerBound > 1 && edge.EOpposite.upperBound != -1){
						repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE_LB_REPAIR_MANY));
					}
				
				} else if(edge.lowerBound == edge.upperBound){
					
					repairs.add(new RepairSpec(node, edge, RepairSpecType.CREATE));				
				}
			}
			
			repairSpecs.put(edge, repairs)
		]
		
		return repairSpecs
	
	}
	
	def Map<EReference, Set<RepairSpec>> generateNodeDeleteRules(RuleSpec ruleSpec, MetamodelWrapper metamodelWrapper){
		
		val repairSpecs = new HashMap<EReference, Set<RepairSpec>>();
		
		val node = metamodelWrapper.getNode(ruleSpec.getNode);
		
		node.EReferences.forEach[edge |
			
			var repairs = new HashSet<RepairSpec>();
			
			if(edge.EOpposite == null || edge.EOpposite.lowerBound == 0){
				//Apply single edge repairs
				//This is the basic scenario
				repairs.add(new RepairSpec(node, edge, RepairSpecType.DELETE));
			} else {
								
				if(edge.EOpposite.lowerBound == 1 && edge.EOpposite.upperBound == 1) {
					
					if(edge.lowerBound != edge.upperBound) {
						
						repairs.add(new RepairSpec(node, edge, RepairSpecType.DELETE_LB_REPAIR));
					}
				}
				
				if(edge.EOpposite.lowerBound > 0 
					&& (edge.EOpposite.upperBound > edge.EOpposite.lowerBound || edge.EOpposite.upperBound == -1)
				) {
					repairs.add(new RepairSpec(node, edge, RepairSpecType.DELETE));
				}
				
				if(edge.EOpposite.lowerBound == edge.EOpposite.upperBound && edge.EOpposite.lowerBound > 1) {
					
					if(edge.lowerBound != edge.upperBound){
						
						repairs.add(new RepairSpec(node, edge, RepairSpecType.DELETE_LB_REPAIR));
						repairs.add(new RepairSpec(node, edge, RepairSpecType.DELETE_LB_REPAIR_MANY));
					}
				}
			}
			
			repairSpecs.put(edge, repairs)
		]
		
		return repairSpecs
	}
	
	def Map<EReference, Set<RepairSpec>> generateEdgeAddRules(RuleSpec ruleSpec, MetamodelWrapper metamodelWrapper){
		
		val repairSpecs = new HashMap<EReference, Set<RepairSpec>>();
		
		val node = metamodelWrapper.getNode(ruleSpec.getNode);
		
		node.EReferences.forEach[edge |
			
			var repairs = new HashSet<RepairSpec>();
			
			if(edge.EOpposite == null || edge.EOpposite.lowerBound == 0){
				//Apply single edge repairs
				//This is the basic scenario
				repairs.add(new RepairSpec(node, edge, RepairSpecType.ADD));
			} else {
				
			
				if(edge.upperBound != -1) {
					if(edge.EOpposite.lowerBound == edge.EOpposite.upperBound) {
							repairs.add(new RepairSpec(node, edge, RepairSpecType.CHANGE));
					} else {
							repairs.add(new RepairSpec(node, edge, RepairSpecType.ADD));
					}
				}
				
				if(edge.upperBound == -1) {
					if(edge.EOpposite.lowerBound == edge.EOpposite.upperBound) {
							repairs.add(new RepairSpec(node, edge, RepairSpecType.CHANGE));
					} else {
							repairs.add(new RepairSpec(node, edge, RepairSpecType.ADD));
					}
				}
				
				if(edge.lowerBound == edge.upperBound) {
					repairs.add(new RepairSpec(node, edge, RepairSpecType.SWAP));
				}
							
			}
			
			repairSpecs.put(edge, repairs)
		]
		
		return repairSpecs
	}
	
	
	def Map<EReference, Set<RepairSpec>> generateEdgeRemoveRules(RuleSpec ruleSpec, MetamodelWrapper metamodelWrapper){
		
		val repairSpecs = new HashMap<EReference, Set<RepairSpec>>();
		
		val node = metamodelWrapper.getNode(ruleSpec.getNode);
		
		node.EReferences.forEach[edge |
			
			var repairs = new HashSet<RepairSpec>();
			
			if(edge.EOpposite == null || edge.EOpposite.lowerBound == 0){
				//Apply single edge repairs
				//This is the basic scenario
				repairs.add(new RepairSpec(node, edge, RepairSpecType.REMOVE));
			} else {
								
				if(edge.lowerBound != -1){
					
					if(edge.EOpposite.lowerBound == edge.EOpposite.upperBound){
						repairs.add(new RepairSpec(node, edge, RepairSpecType.CHANGE))
					} else {
						repairs.add(new RepairSpec(node, edge, RepairSpecType.REMOVE))
					}
					
				}
				
				if(edge.lowerBound == -1){
					if(edge.EOpposite.lowerBound == edge.EOpposite.upperBound){
						repairs.add(new RepairSpec(node, edge, RepairSpecType.CHANGE))
					} else {
						repairs.add(new RepairSpec(node, edge, RepairSpecType.REMOVE))
					}
				}
				
				if(edge.lowerBound == edge.upperBound){
					repairs.add(new RepairSpec(node, edge, RepairSpecType.SWAP))
				}
			}
			
			repairSpecs.put(edge, repairs)
		]
		
		return repairSpecs
	}
}

