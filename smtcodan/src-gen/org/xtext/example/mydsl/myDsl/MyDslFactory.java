/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage
 * @generated
 */
public interface MyDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MyDslFactory eINSTANCE = org.xtext.example.mydsl.myDsl.impl.MyDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Annotation Language</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation Language</em>'.
   * @generated
   */
  AnnotationLanguage createAnnotationLanguage();

  /**
   * Returns a new object of class '<em>Header Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Header Model</em>'.
   * @generated
   */
  HeaderModel createHeaderModel();

  /**
   * Returns a new object of class '<em>Attribute Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Definition</em>'.
   * @generated
   */
  AttributeDefinition createAttributeDefinition();

  /**
   * Returns a new object of class '<em>Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ref</em>'.
   * @generated
   */
  Ref createRef();

  /**
   * Returns a new object of class '<em>Method Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Header</em>'.
   * @generated
   */
  MethodHeader createMethodHeader();

  /**
   * Returns a new object of class '<em>ID Space</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ID Space</em>'.
   * @generated
   */
  IDSpace createIDSpace();

  /**
   * Returns a new object of class '<em>Special Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Special Expression</em>'.
   * @generated
   */
  SpecialExpression createSpecialExpression();

  /**
   * Returns a new object of class '<em>Space ID</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Space ID</em>'.
   * @generated
   */
  SpaceID createSpaceID();

  /**
   * Returns a new object of class '<em>Multiline Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiline Annotation</em>'.
   * @generated
   */
  MultilineAnnotation createMultilineAnnotation();

  /**
   * Returns a new object of class '<em>Function Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Annotation</em>'.
   * @generated
   */
  FunctionAnnotation createFunctionAnnotation();

  /**
   * Returns a new object of class '<em>Single Line Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Line Annotation</em>'.
   * @generated
   */
  SingleLineAnnotation createSingleLineAnnotation();

  /**
   * Returns a new object of class '<em>Key Word</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Word</em>'.
   * @generated
   */
  KeyWord createKeyWord();

  /**
   * Returns a new object of class '<em>SYMBOLS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SYMBOLS</em>'.
   * @generated
   */
  SYMBOLS createSYMBOLS();

  /**
   * Returns a new object of class '<em>Struct Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Definition</em>'.
   * @generated
   */
  StructDefinition createStructDefinition();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Entity Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity Ref</em>'.
   * @generated
   */
  EntityRef createEntityRef();

  /**
   * Returns a new object of class '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity</em>'.
   * @generated
   */
  Entity createEntity();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MyDslPackage getMyDslPackage();

} //MyDslFactory
