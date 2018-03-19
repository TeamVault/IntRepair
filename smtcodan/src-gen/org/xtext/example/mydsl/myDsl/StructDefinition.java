/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getAttr <em>Attr</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName3 <em>Name3</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName4 <em>Name4</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition()
 * @model
 * @generated
 */
public interface StructDefinition extends EObject
{
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
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Name0()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName0();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName0 <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name0</em>' containment reference.
   * @see #getName0()
   * @generated
   */
  void setName0(SYMBOLS value);

  /**
   * Returns the value of the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name1</em>' attribute.
   * @see #setName1(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Name1()
   * @model
   * @generated
   */
  String getName1();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName1 <em>Name1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name1</em>' attribute.
   * @see #getName1()
   * @generated
   */
  void setName1(String value);

  /**
   * Returns the value of the '<em><b>Attr</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' attribute list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Attr()
   * @model unique="false"
   * @generated
   */
  EList<String> getAttr();

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
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Name2()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName2();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName2 <em>Name2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name2</em>' containment reference.
   * @see #getName2()
   * @generated
   */
  void setName2(SYMBOLS value);

  /**
   * Returns the value of the '<em><b>Name3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name3</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name3</em>' attribute.
   * @see #setName3(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Name3()
   * @model
   * @generated
   */
  String getName3();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName3 <em>Name3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name3</em>' attribute.
   * @see #getName3()
   * @generated
   */
  void setName3(String value);

  /**
   * Returns the value of the '<em><b>Name4</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name4</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name4</em>' containment reference.
   * @see #setName4(SYMBOLS)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getStructDefinition_Name4()
   * @model containment="true"
   * @generated
   */
  SYMBOLS getName4();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName4 <em>Name4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name4</em>' containment reference.
   * @see #getName4()
   * @generated
   */
  void setName4(SYMBOLS value);

} // StructDefinition
