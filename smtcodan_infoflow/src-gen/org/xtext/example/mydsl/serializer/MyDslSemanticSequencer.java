package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.myDsl.AnnotationLanguage;
import org.xtext.example.mydsl.myDsl.AttributeDefinition;
import org.xtext.example.mydsl.myDsl.Entity;
import org.xtext.example.mydsl.myDsl.EntityRef;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.FunctionAnnotation;
import org.xtext.example.mydsl.myDsl.HeaderModel;
import org.xtext.example.mydsl.myDsl.IDSpace;
import org.xtext.example.mydsl.myDsl.KeyWord;
import org.xtext.example.mydsl.myDsl.MethodHeader;
import org.xtext.example.mydsl.myDsl.MultilineAnnotation;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.SYMBOLS;
import org.xtext.example.mydsl.myDsl.SingleLineAnnotation;
import org.xtext.example.mydsl.myDsl.SpaceID;
import org.xtext.example.mydsl.myDsl.StructDefinition;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MyDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MyDslPackage.ANNOTATION_LANGUAGE:
				if(context == grammarAccess.getAnnotationLanguageRule()) {
					sequence_AnnotationLanguage(context, (AnnotationLanguage) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ATTRIBUTE_DEFINITION:
				if(context == grammarAccess.getAttributeDefinitionRule() ||
				   context == grammarAccess.getHeaderModelRule()) {
					sequence_AttributeDefinition(context, (AttributeDefinition) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ENTITY:
				if(context == grammarAccess.getSpecialExpressionRule()) {
					sequence_SpecialExpression(context, (Entity) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ENTITY_REF:
				if(context == grammarAccess.getEntityRefRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAttributeRule() ||
				   context == grammarAccess.getExpressionAttributeAccess().getExpressionRefAction_1_0() ||
				   context == grammarAccess.getExpressionAccess().getExpressionRefAction_1_0() ||
				   context == grammarAccess.getIDSpaceRule() ||
				   context == grammarAccess.getIDSpaceAccess().getIDSpaceLeftAction_1_0()) {
					sequence_EntityRef(context, (EntityRef) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionAttributeRule() ||
				   context == grammarAccess.getExpressionAttributeAccess().getExpressionRefAction_1_0()) {
					sequence_ExpressionAttribute(context, (Expression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getExpressionAccess().getExpressionRefAction_1_0()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FUNCTION_ANNOTATION:
				if(context == grammarAccess.getFunctionAnnotationRule()) {
					sequence_FunctionAnnotation(context, (FunctionAnnotation) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.HEADER_MODEL:
				if(context == grammarAccess.getHeaderModelRule()) {
					sequence_HeaderModel(context, (HeaderModel) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ID_SPACE:
				if(context == grammarAccess.getIDSpaceRule() ||
				   context == grammarAccess.getIDSpaceAccess().getIDSpaceLeftAction_1_0()) {
					sequence_IDSpace(context, (IDSpace) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.KEY_WORD:
				if(context == grammarAccess.getKeyWordRule()) {
					sequence_KeyWord(context, (KeyWord) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.METHOD_HEADER:
				if(context == grammarAccess.getHeaderModelRule() ||
				   context == grammarAccess.getMethodHeaderRule()) {
					sequence_MethodHeader(context, (MethodHeader) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.MULTILINE_ANNOTATION:
				if(context == grammarAccess.getHeaderModelRule() ||
				   context == grammarAccess.getMultilineAnnotationRule()) {
					sequence_MultilineAnnotation(context, (MultilineAnnotation) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.SYMBOLS:
				if(context == grammarAccess.getSYMBOLSRule()) {
					sequence_SYMBOLS(context, (SYMBOLS) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.SINGLE_LINE_ANNOTATION:
				if(context == grammarAccess.getSingleLineAnnotationRule()) {
					sequence_SingleLineAnnotation(context, (SingleLineAnnotation) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.SPACE_ID:
				if(context == grammarAccess.getSpaceIDRule()) {
					sequence_SpaceID(context, (SpaceID) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.STRUCT_DEFINITION:
				if(context == grammarAccess.getStructDefinitionRule()) {
					sequence_StructDefinition(context, (StructDefinition) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     element+=HeaderModel*
	 */
	protected void sequence_AnnotationLanguage(EObject context, AnnotationLanguage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attribute_def+=SYMBOLS? extension+=KeyWord extension_2+=ExpressionAttribute)
	 */
	protected void sequence_AttributeDefinition(EObject context, AttributeDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (entity+=SpecialExpression*)
	 */
	protected void sequence_EntityRef(EObject context, EntityRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=ExpressionAttribute_Expression_1_0 symbols_attr+=SYMBOLS tail=EntityRef)
	 */
	protected void sequence_ExpressionAttribute(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=Expression_Expression_1_0 symbols+=SYMBOLS tail=EntityRef)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (result+='@function ' functionType=FunctionType (level='H' | level='L')? name0=SYMBOLS? nameComment=ID?) | 
	 *         (
	 *             parameter=ID 
	 *             name0=SYMBOLS? 
	 *             securityType=SecurityType? 
	 *             (level='H' | level='L')? 
	 *             name1=SYMBOLS? 
	 *             nameComment=ID?
	 *         ) | 
	 *         (preStep=ID name0=SYMBOLS? (level='H' | level='L')? name2=SYMBOLS? nameComment=ID?) | 
	 *         (postStep=ID name0=SYMBOLS? (level='H' | level='L')? name3=SYMBOLS? nameComment=ID?)
	 *     )
	 */
	protected void sequence_FunctionAnnotation(EObject context, FunctionAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     headers+=SingleLineAnnotation
	 */
	protected void sequence_HeaderModel(EObject context, HeaderModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=IDSpace_IDSpace_1_0 right=SpecialExpression)
	 */
	protected void sequence_IDSpace(EObject context, IDSpace semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ID_SPACE__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ID_SPACE__LEFT));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ID_SPACE__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ID_SPACE__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIDSpaceAccess().getIDSpaceLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getIDSpaceAccess().getRightSpecialExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (rule='__BEGIN_DECLS'?)
	 */
	protected void sequence_KeyWord(EObject context, KeyWord semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name0=SYMBOLS? 
	 *         name1=SYMBOLS 
	 *         exp+=Expression 
	 *         name2=SYMBOLS 
	 *         name3=SYMBOLS? 
	 *         name4=SYMBOLS? 
	 *         name5=SYMBOLS? 
	 *         name6=SYMBOLS?
	 *     )
	 */
	protected void sequence_MethodHeader(EObject context, MethodHeader semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((rule+='/*@ '? functionAnnotation=FunctionAnnotation name0=SYMBOLS?) | name1=SYMBOLS?)
	 */
	protected void sequence_MultilineAnnotation(EObject context, MultilineAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((symbols+=',' | name0=KeyWord)?)
	 */
	protected void sequence_SYMBOLS(EObject context, SYMBOLS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (result+='//@ @function ' functionType=FunctionType (level='H' | level='L')? name0=SYMBOLS? nameComment=ID?) | 
	 *         (parameter=ID securityType=SecurityType? (level='H' | level='L')? nameComment=ID?) | 
	 *         (variable=ID securityType=SecurityType? (level='H' | level='L')? nameComment=ID?) | 
	 *         (preStep=ID (level='H' | level='L')? name2=SYMBOLS? nameComment=ID?) | 
	 *         (postStep=ID (level='H' | level='L')? name3=SYMBOLS? nameComment=ID?)
	 *     )
	 */
	protected void sequence_SingleLineAnnotation(EObject context, SingleLineAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr+=' '*)
	 */
	protected void sequence_SpaceID(EObject context, SpaceID semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((rules+=ID | name0=SYMBOLS? | (name1=SYMBOLS name2=SYMBOLS? name3=SYMBOLS? name4=SYMBOLS?))?)
	 */
	protected void sequence_SpecialExpression(EObject context, Entity semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name0=SYMBOLS 
	 *         name1=ID 
	 *         attr+=ID* 
	 *         name2=SYMBOLS 
	 *         name3=ID 
	 *         name4=SYMBOLS?
	 *     )
	 */
	protected void sequence_StructDefinition(EObject context, StructDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
