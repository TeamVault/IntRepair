/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SYMBOLS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SYMBOLS#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SYMBOLS#getName0 <em>Name0</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSYMBOLS()
 * @model
 * @generated
 */
public interface SYMBOLS extends EObject
{
  /**
   * Returns the value of the '<em><b>Symbols</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbols</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbols</em>' attribute list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSYMBOLS_Symbols()
   * @model unique="false"
   * @generated
   */
  EList<String> getSymbols();

  /**
   * Returns the value of the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name0</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name0</em>' containment reference.
   * @see #setName0(KeyWord)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSYMBOLS_Name0()
   * @model containment="true"
   * @generated
   */
  KeyWord getName0();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.SYMBOLS#getName0 <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name0</em>' containment reference.
   * @see #getName0()
   * @generated
   */
  void setName0(KeyWord value);

} // SYMBOLS
