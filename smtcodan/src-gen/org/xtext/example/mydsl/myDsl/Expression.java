/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Expression#getRef <em>Ref</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Expression#getSymbols_attr <em>Symbols attr</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Expression#getTail <em>Tail</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Expression#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends Ref
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' containment reference.
   * @see #setRef(Ref)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getExpression_Ref()
   * @model containment="true"
   * @generated
   */
  Ref getRef();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Expression#getRef <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' containment reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Ref value);

  /**
   * Returns the value of the '<em><b>Symbols attr</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SYMBOLS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbols attr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbols attr</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getExpression_Symbols_attr()
   * @model containment="true"
   * @generated
   */
  EList<SYMBOLS> getSymbols_attr();

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(Ref)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getExpression_Tail()
   * @model containment="true"
   * @generated
   */
  Ref getTail();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Expression#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(Ref value);

  /**
   * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SYMBOLS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbols</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getExpression_Symbols()
   * @model containment="true"
   * @generated
   */
  EList<SYMBOLS> getSymbols();

} // Expression
