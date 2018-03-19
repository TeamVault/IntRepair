/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.SpaceID#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSpaceID()
 * @model
 * @generated
 */
public interface SpaceID extends EObject
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' attribute list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getSpaceID_Expr()
   * @model unique="false"
   * @generated
   */
  EList<String> getExpr();

} // SpaceID
