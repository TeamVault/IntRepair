/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Line Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getResult <em>Result</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getFunctionType <em>Function Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getLevel <em>Level</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getNameComment <em>Name Comment</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getSecurityType <em>Security Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPreStep <em>Pre Step</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPostStep <em>Post Step</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName3 <em>Name3</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation()
 * @model
 * @generated
 */
public interface SingleLineAnnotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Result</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' attribute list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Result()
   * @model unique="false"
   * @generated
   */
  EList<String> getResult();

  /**
   * Returns the value of the '<em><b>Function Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.xtext.example.mydsl.myDsl.FunctionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Type</em>' attribute.
   * @see org.xtext.example.mydsl.myDsl.FunctionType
   * @see #setFunctionType(FunctionType)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_FunctionType()
   * @model
   * @generated
   */
  FunctionType getFunctionType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getFunctionType <em>Function Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Type</em>' attribute.
   * @see org.xtext.example.mydsl.myDsl.FunctionType
   * @see #getFunctionType()
   * @generated
   */
  void setFunctionType(FunctionType value);

  /**
   * Returns the value of the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Level</em>' attribute.
   * @see #setLevel(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Level()
   * @model
   * @generated
   */
  String getLevel();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getLevel <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Level</em>' attribute.
   * @see #getLevel()
   * @generated
   */
  void setLevel(String value);

  /**
   * Returns the value of the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name0</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name0</em>' containment reference.
   * @see #setName0(SYMBOLS)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Name0()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName0();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName0 <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name0</em>' containment reference.
   * @see #getName0()
   * @generated
   */
  void setName0(SYMBOLS value);

  /**
   * Returns the value of the '<em><b>Name Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Comment</em>' attribute.
   * @see #setNameComment(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_NameComment()
   * @model
   * @generated
   */
  String getNameComment();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getNameComment <em>Name Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name Comment</em>' attribute.
   * @see #getNameComment()
   * @generated
   */
  void setNameComment(String value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute.
   * @see #setParameter(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Parameter()
   * @model
   * @generated
   */
  String getParameter();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getParameter <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' attribute.
   * @see #getParameter()
   * @generated
   */
  void setParameter(String value);

  /**
   * Returns the value of the '<em><b>Security Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.xtext.example.mydsl.myDsl.SecurityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Security Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Security Type</em>' attribute.
   * @see org.xtext.example.mydsl.myDsl.SecurityType
   * @see #setSecurityType(SecurityType)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_SecurityType()
   * @model
   * @generated
   */
  SecurityType getSecurityType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getSecurityType <em>Security Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Security Type</em>' attribute.
   * @see org.xtext.example.mydsl.myDsl.SecurityType
   * @see #getSecurityType()
   * @generated
   */
  void setSecurityType(SecurityType value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Pre Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pre Step</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pre Step</em>' attribute.
   * @see #setPreStep(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_PreStep()
   * @model
   * @generated
   */
  String getPreStep();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPreStep <em>Pre Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pre Step</em>' attribute.
   * @see #getPreStep()
   * @generated
   */
  void setPreStep(String value);

  /**
   * Returns the value of the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name2</em>' containment reference.
   * @see #setName2(SYMBOLS)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Name2()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName2();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName2 <em>Name2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name2</em>' containment reference.
   * @see #getName2()
   * @generated
   */
  void setName2(SYMBOLS value);

  /**
   * Returns the value of the '<em><b>Post Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Post Step</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Post Step</em>' attribute.
   * @see #setPostStep(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_PostStep()
   * @model
   * @generated
   */
  String getPostStep();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPostStep <em>Post Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Post Step</em>' attribute.
   * @see #getPostStep()
   * @generated
   */
  void setPostStep(String value);

  /**
   * Returns the value of the '<em><b>Name3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name3</em>' containment reference.
   * @see #setName3(SYMBOLS)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSingleLineAnnotation_Name3()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName3();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName3 <em>Name3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name3</em>' containment reference.
   * @see #getName3()
   * @generated
   */
  void setName3(SYMBOLS value);

} // SingleLineAnnotation
