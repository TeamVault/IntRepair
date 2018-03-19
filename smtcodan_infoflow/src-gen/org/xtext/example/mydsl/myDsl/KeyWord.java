/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.KeyWord#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyWord()
 * @model
 * @generated
 */
public interface KeyWord extends EObject
{
  /**
   * Returns the value of the '<em><b>Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' attribute.
   * @see #setRule(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getKeyWord_Rule()
   * @model
   * @generated
   */
  String getRule();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.KeyWord#getRule <em>Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' attribute.
   * @see #getRule()
   * @generated
   */
  void setRule(String value);

} // KeyWord
