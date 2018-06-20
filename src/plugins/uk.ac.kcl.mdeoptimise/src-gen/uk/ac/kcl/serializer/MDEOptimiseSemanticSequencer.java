/*
 * generated by Xtext 2.12.0
 */
package uk.ac.kcl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.serializer.XbaseSemanticSequencer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import uk.ac.kcl.mdeoptimise.AlgorithmVariation;
import uk.ac.kcl.mdeoptimise.BasePathSpec;
import uk.ac.kcl.mdeoptimise.ConstraintInterpreterSpec;
import uk.ac.kcl.mdeoptimise.EvolverParameter;
import uk.ac.kcl.mdeoptimise.EvolverSpec;
import uk.ac.kcl.mdeoptimise.MdeoptimisePackage;
import uk.ac.kcl.mdeoptimise.MetaModelSpec;
import uk.ac.kcl.mdeoptimise.ModelInitialiserSpec;
import uk.ac.kcl.mdeoptimise.ModelPathSpec;
import uk.ac.kcl.mdeoptimise.MultiplicityRefinementSpec;
import uk.ac.kcl.mdeoptimise.ObjectiveInterpreterSpec;
import uk.ac.kcl.mdeoptimise.Optimisation;
import uk.ac.kcl.mdeoptimise.OptimisationSpec;
import uk.ac.kcl.mdeoptimise.ParameterFunction;
import uk.ac.kcl.mdeoptimise.ProbabilityVariation;
import uk.ac.kcl.mdeoptimise.ReportInterpreterSpec;
import uk.ac.kcl.mdeoptimise.RulegenEdge;
import uk.ac.kcl.mdeoptimise.RulegenNode;
import uk.ac.kcl.mdeoptimise.RulegenSpec;
import uk.ac.kcl.services.MDEOptimiseGrammarAccess;

@SuppressWarnings("all")
public class MDEOptimiseSemanticSequencer extends XbaseSemanticSequencer {

	@Inject
	private MDEOptimiseGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MdeoptimisePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MdeoptimisePackage.ALGORITHM_VARIATION:
				sequence_AlgorithmVariation(context, (AlgorithmVariation) semanticObject); 
				return; 
			case MdeoptimisePackage.BASE_PATH_SPEC:
				sequence_BasePathSpec(context, (BasePathSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.CONSTRAINT_INTERPRETER_SPEC:
				sequence_ConstraintInterpreterSpec(context, (ConstraintInterpreterSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.EVOLVER_PARAMETER:
				sequence_EvolverParameter(context, (EvolverParameter) semanticObject); 
				return; 
			case MdeoptimisePackage.EVOLVER_SPEC:
				sequence_EvolverSpec(context, (EvolverSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.META_MODEL_SPEC:
				sequence_MetaModelSpec(context, (MetaModelSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.MODEL_INITIALISER_SPEC:
				sequence_ModelInitialiserSpec(context, (ModelInitialiserSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.MODEL_PATH_SPEC:
				sequence_ModelPathSpec(context, (ModelPathSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.MULTIPLICITY_REFINEMENT_SPEC:
				sequence_MultiplicityRefinementSpec(context, (MultiplicityRefinementSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.OBJECTIVE_INTERPRETER_SPEC:
				sequence_ObjectiveInterpreterSpec(context, (ObjectiveInterpreterSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.OPTIMISATION:
				sequence_Optimisation(context, (Optimisation) semanticObject); 
				return; 
			case MdeoptimisePackage.OPTIMISATION_SPEC:
				sequence_OptimisationSpec(context, (OptimisationSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.PARAMETER_FUNCTION:
				sequence_ParameterFunction(context, (ParameterFunction) semanticObject); 
				return; 
			case MdeoptimisePackage.PROBABILITY_VARIATION:
				sequence_ProbabilityVariation(context, (ProbabilityVariation) semanticObject); 
				return; 
			case MdeoptimisePackage.REPORT_INTERPRETER_SPEC:
				sequence_ReportInterpreterSpec(context, (ReportInterpreterSpec) semanticObject); 
				return; 
			case MdeoptimisePackage.RULEGEN_EDGE:
				sequence_RulegenEdge(context, (RulegenEdge) semanticObject); 
				return; 
			case MdeoptimisePackage.RULEGEN_NODE:
				sequence_RulegenNode(context, (RulegenNode) semanticObject); 
				return; 
			case MdeoptimisePackage.RULEGEN_SPEC:
				sequence_RulegenSpec(context, (RulegenSpec) semanticObject); 
				return; 
			}
		else if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if (rule == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XbasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
				return; 
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XBINARY_OPERATION:
				sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
				return; 
			case XbasePackage.XBLOCK_EXPRESSION:
				if (rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXBlockExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
				return; 
			case XbasePackage.XCASE_PART:
				sequence_XCasePart(context, (XCasePart) semanticObject); 
				return; 
			case XbasePackage.XCASTED_EXPRESSION:
				sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
				return; 
			case XbasePackage.XCATCH_CLAUSE:
				sequence_XCatchClause(context, (XCatchClause) semanticObject); 
				return; 
			case XbasePackage.XCLOSURE:
				if (rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXClosureRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
				return; 
			case XbasePackage.XDO_WHILE_EXPRESSION:
				sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
				return; 
			case XbasePackage.XFEATURE_CALL:
				sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XIF_EXPRESSION:
				sequence_XIfExpression(context, (XIfExpression) semanticObject); 
				return; 
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
				return; 
			case XbasePackage.XLIST_LITERAL:
				sequence_XListLiteral(context, (XListLiteral) semanticObject); 
				return; 
			case XbasePackage.XMEMBER_FEATURE_CALL:
				sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XNULL_LITERAL:
				sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
				return; 
			case XbasePackage.XNUMBER_LITERAL:
				sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
				return; 
			case XbasePackage.XPOSTFIX_OPERATION:
				sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
				return; 
			case XbasePackage.XRETURN_EXPRESSION:
				sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
				return; 
			case XbasePackage.XSET_LITERAL:
				sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
				return; 
			case XbasePackage.XSTRING_LITERAL:
				sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
				return; 
			case XbasePackage.XSWITCH_EXPRESSION:
				sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
				return; 
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
				return; 
			case XbasePackage.XTHROW_EXPRESSION:
				sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
				return; 
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
				return; 
			case XbasePackage.XTYPE_LITERAL:
				sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
				return; 
			case XbasePackage.XUNARY_OPERATION:
				sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
				return; 
			case XbasePackage.XVARIABLE_DECLARATION:
				sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
				return; 
			case XbasePackage.XWHILE_EXPRESSION:
				sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AlgorithmVariation returns AlgorithmVariation
	 *
	 * Constraint:
	 *     (probabilityVariation=ProbabilityVariation | simpleVariation=MUTATION_VARIATION | simpleVariation=CROSSOVER_VARIATION)
	 */
	protected void sequence_AlgorithmVariation(ISerializationContext context, AlgorithmVariation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     BasePathSpec returns BasePathSpec
	 *
	 * Constraint:
	 *     location=URL
	 */
	protected void sequence_BasePathSpec(ISerializationContext context, BasePathSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.BASE_PATH_SPEC__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.BASE_PATH_SPEC__LOCATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBasePathSpecAccess().getLocationURLTerminalRuleCall_1_0(), semanticObject.getLocation());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ConstraintInterpreterSpec returns ConstraintInterpreterSpec
	 *
	 * Constraint:
	 *     (constraintName=ValidID constraintType=ENTITY_TYPE constraintSpec=STRING)
	 */
	protected void sequence_ConstraintInterpreterSpec(ISerializationContext context, ConstraintInterpreterSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_NAME));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_TYPE));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_SPEC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.CONSTRAINT_INTERPRETER_SPEC__CONSTRAINT_SPEC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstraintInterpreterSpecAccess().getConstraintNameValidIDParserRuleCall_1_0(), semanticObject.getConstraintName());
		feeder.accept(grammarAccess.getConstraintInterpreterSpecAccess().getConstraintTypeENTITY_TYPETerminalRuleCall_2_0(), semanticObject.getConstraintType());
		feeder.accept(grammarAccess.getConstraintInterpreterSpecAccess().getConstraintSpecSTRINGTerminalRuleCall_4_0(), semanticObject.getConstraintSpec());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     EvolverParameter returns EvolverParameter
	 *
	 * Constraint:
	 *     (name=ValidID (function=ParameterFunction | customFunction=STRING))
	 */
	protected void sequence_EvolverParameter(ISerializationContext context, EvolverParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EvolverSpec returns EvolverSpec
	 *
	 * Constraint:
	 *     (evolverType=EvolverType rule_location=URL unit=STRING (parameters+=EvolverParameter parameters+=EvolverParameter*)?)
	 */
	protected void sequence_EvolverSpec(ISerializationContext context, EvolverSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MetaModelSpec returns MetaModelSpec
	 *
	 * Constraint:
	 *     location=URL
	 */
	protected void sequence_MetaModelSpec(ISerializationContext context, MetaModelSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.META_MODEL_SPEC__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.META_MODEL_SPEC__LOCATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMetaModelSpecAccess().getLocationURLTerminalRuleCall_1_0(), semanticObject.getLocation());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ModelInitialiserSpec returns ModelInitialiserSpec
	 *
	 * Constraint:
	 *     initialiser=URL
	 */
	protected void sequence_ModelInitialiserSpec(ISerializationContext context, ModelInitialiserSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MODEL_INITIALISER_SPEC__INITIALISER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MODEL_INITIALISER_SPEC__INITIALISER));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getModelInitialiserSpecAccess().getInitialiserURLTerminalRuleCall_3_0(), semanticObject.getInitialiser());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ModelPathSpec returns ModelPathSpec
	 *
	 * Constraint:
	 *     location=URL
	 */
	protected void sequence_ModelPathSpec(ISerializationContext context, ModelPathSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MODEL_PATH_SPEC__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MODEL_PATH_SPEC__LOCATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getModelPathSpecAccess().getLocationURLTerminalRuleCall_1_0(), semanticObject.getLocation());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MultiplicityRefinementSpec returns MultiplicityRefinementSpec
	 *
	 * Constraint:
	 *     (node=STRING edge=STRING lowerBound=INT upperBound=SignedInteger)
	 */
	protected void sequence_MultiplicityRefinementSpec(ISerializationContext context, MultiplicityRefinementSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__NODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__NODE));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__EDGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__EDGE));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__LOWER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__LOWER_BOUND));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__UPPER_BOUND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.MULTIPLICITY_REFINEMENT_SPEC__UPPER_BOUND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicityRefinementSpecAccess().getNodeSTRINGTerminalRuleCall_3_0(), semanticObject.getNode());
		feeder.accept(grammarAccess.getMultiplicityRefinementSpecAccess().getEdgeSTRINGTerminalRuleCall_5_0(), semanticObject.getEdge());
		feeder.accept(grammarAccess.getMultiplicityRefinementSpecAccess().getLowerBoundINTTerminalRuleCall_7_0(), semanticObject.getLowerBound());
		feeder.accept(grammarAccess.getMultiplicityRefinementSpecAccess().getUpperBoundSignedIntegerParserRuleCall_9_0(), semanticObject.getUpperBound());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ObjectiveInterpreterSpec returns ObjectiveInterpreterSpec
	 *
	 * Constraint:
	 *     (objectiveName=ValidID objectiveTendency=OBJECTIVE_TENDENCY objectiveType=ENTITY_TYPE objectiveSpec=STRING)
	 */
	protected void sequence_ObjectiveInterpreterSpec(ISerializationContext context, ObjectiveInterpreterSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_NAME));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_TENDENCY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_TENDENCY));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_TYPE));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_SPEC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.OBJECTIVE_INTERPRETER_SPEC__OBJECTIVE_SPEC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getObjectiveInterpreterSpecAccess().getObjectiveNameValidIDParserRuleCall_1_0(), semanticObject.getObjectiveName());
		feeder.accept(grammarAccess.getObjectiveInterpreterSpecAccess().getObjectiveTendencyOBJECTIVE_TENDENCYTerminalRuleCall_2_0(), semanticObject.getObjectiveTendency());
		feeder.accept(grammarAccess.getObjectiveInterpreterSpecAccess().getObjectiveTypeENTITY_TYPETerminalRuleCall_3_0(), semanticObject.getObjectiveType());
		feeder.accept(grammarAccess.getObjectiveInterpreterSpecAccess().getObjectiveSpecSTRINGTerminalRuleCall_5_0(), semanticObject.getObjectiveSpec());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OptimisationSpec returns OptimisationSpec
	 *
	 * Constraint:
	 *     (
	 *         algorithmFactory=ALGORITHM_FACTORY 
	 *         algorithmName=ALGORITHM_NAME 
	 *         algorithmVariation=AlgorithmVariation 
	 *         algorithmEvolutions=INT 
	 *         algorithmPopulation=INT 
	 *         algorithmBatches=INT?
	 *     )
	 */
	protected void sequence_OptimisationSpec(ISerializationContext context, OptimisationSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Optimisation returns Optimisation
	 *
	 * Constraint:
	 *     (
	 *         basepath=BasePathSpec 
	 *         metamodel=MetaModelSpec 
	 *         model=ModelPathSpec 
	 *         modelInitialiser=ModelInitialiserSpec? 
	 *         refinements+=MultiplicityRefinementSpec* 
	 *         objectives+=ObjectiveInterpreterSpec+ 
	 *         constraints+=ConstraintInterpreterSpec* 
	 *         reports+=ReportInterpreterSpec* 
	 *         evolvers+=EvolverSpec* 
	 *         rulegen+=RulegenSpec* 
	 *         optimisation=OptimisationSpec
	 *     )
	 */
	protected void sequence_Optimisation(ISerializationContext context, Optimisation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ParameterFunction returns ParameterFunction
	 *
	 * Constraint:
	 *     (name=ValidID parameter=STRING?)
	 */
	protected void sequence_ParameterFunction(ISerializationContext context, ParameterFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ProbabilityVariation returns ProbabilityVariation
	 *
	 * Constraint:
	 *     (type=GENETIC_VARIATION (crossover_rate=Number mutation_rate=Number)?)
	 */
	protected void sequence_ProbabilityVariation(ISerializationContext context, ProbabilityVariation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ReportInterpreterSpec returns ReportInterpreterSpec
	 *
	 * Constraint:
	 *     (reportName=ValidID reportSpec=STRING)
	 */
	protected void sequence_ReportInterpreterSpec(ISerializationContext context, ReportInterpreterSpec semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.REPORT_INTERPRETER_SPEC__REPORT_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.REPORT_INTERPRETER_SPEC__REPORT_NAME));
			if (transientValues.isValueTransient(semanticObject, MdeoptimisePackage.Literals.REPORT_INTERPRETER_SPEC__REPORT_SPEC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdeoptimisePackage.Literals.REPORT_INTERPRETER_SPEC__REPORT_SPEC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReportInterpreterSpecAccess().getReportNameValidIDParserRuleCall_1_0(), semanticObject.getReportName());
		feeder.accept(grammarAccess.getReportInterpreterSpecAccess().getReportSpecSTRINGTerminalRuleCall_3_0(), semanticObject.getReportSpec());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     RulegenEdge returns RulegenEdge
	 *
	 * Constraint:
	 *     (node=STRING edge=STRING (generationRestriction=ADD_EDGE | generationRestriction=REMOVE_EDGE)?)
	 */
	protected void sequence_RulegenEdge(ISerializationContext context, RulegenEdge semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RulegenNode returns RulegenNode
	 *
	 * Constraint:
	 *     (node=STRING (generationRestriction=CREATE_NODE | generationRestriction=DELETE_NODE)?)
	 */
	protected void sequence_RulegenNode(ISerializationContext context, RulegenNode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     RulegenSpec returns RulegenSpec
	 *
	 * Constraint:
	 *     (nodeSpec=RulegenNode | edgeSpec=RulegenEdge)
	 */
	protected void sequence_RulegenSpec(ISerializationContext context, RulegenSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
