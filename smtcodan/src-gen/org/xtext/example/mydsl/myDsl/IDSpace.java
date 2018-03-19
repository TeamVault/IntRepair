/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ID Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.IDSpace#getLeft <em>Left</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.IDSpace#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIDSpace()
 * @model
 * @generated
 */
public interface IDSpace extends EObject
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Ref)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIDSpace_Left()
   * @model containment="true"
   * @generated
   */
  Ref getLeft();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.IDSpace#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Ref value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(SpecialExpression)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIDSpace_Right()
   * @model containment="true"
   * @generated
   */
  SpecialExpression getRight();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.IDSpace#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(SpecialExpression value);

} // IDSpace
