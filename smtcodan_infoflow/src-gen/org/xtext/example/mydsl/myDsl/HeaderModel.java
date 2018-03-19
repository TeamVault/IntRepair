/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Header Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.HeaderModel#getHeaders <em>Headers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getHeaderModel()
 * @model
 * @generated
 */
public interface HeaderModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Headers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Headers</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getHeaderModel_Headers()
   * @model containment="true"
   * @generated
   */
  EList<SingleLineAnnotation> getHeaders();

} // HeaderModel
