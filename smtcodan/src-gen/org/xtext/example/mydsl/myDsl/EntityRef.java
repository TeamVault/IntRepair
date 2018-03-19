/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.EntityRef#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntityRef()
 * @model
 * @generated
 */
public interface EntityRef extends Ref
{
  /**
   * Returns the value of the '<em><b>Entity</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SpecialExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entity</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entity</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getEntityRef_Entity()
   * @model containment="true"
   * @generated
   */
  EList<SpecialExpression> getEntity();

} // EntityRef
