/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.AnnotationLanguage#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAnnotationLanguage()
 * @model
 * @generated
 */
public interface AnnotationLanguage extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.HeaderModel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAnnotationLanguage_Element()
   * @model containment="true"
   * @generated
   */
  EList<HeaderModel> getElement();

} // AnnotationLanguage
