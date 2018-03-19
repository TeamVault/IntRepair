/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiline Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getRule <em>Rule</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getFunctionAnnotation <em>Function Annotation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getMultilineAnnotation()
 * @model
 * @generated
 */
public interface MultilineAnnotation extends HeaderModel
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' attribute list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getMultilineAnnotation_Rule()
   * @model unique="false"
   * @generated
   */
  EList<String> getRule();

  /**
   * Returns the value of the '<em><b>Function Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Annotation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Annotation</em>' containment reference.
   * @see #setFunctionAnnotation(FunctionAnnotation)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getMultilineAnnotation_FunctionAnnotation()
   * @model containment="true"
   * @generated
   */
  FunctionAnnotation getFunctionAnnotation();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getFunctionAnnotation <em>Function Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Annotation</em>' containment reference.
   * @see #getFunctionAnnotation()
   * @generated
   */
  void setFunctionAnnotation(FunctionAnnotation value);

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
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getMultilineAnnotation_Name0()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName0();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName0 <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name0</em>' containment reference.
   * @see #getName0()
   * @generated
   */
  void setName0(SYMBOLS value);

  /**
   * Returns the value of the '<em><b>Name1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name1</em>' containment reference.
   * @see #setName1(SYMBOLS)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getMultilineAnnotation_Name1()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName1();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName1 <em>Name1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name1</em>' containment reference.
   * @see #getName1()
   * @generated
   */
  void setName1(SYMBOLS value);

} // MultilineAnnotation
