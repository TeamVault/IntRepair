/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getAttribute_def <em>Attribute def</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension_2 <em>Extension 2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAttributeDefinition()
 * @model
 * @generated
 */
public interface AttributeDefinition extends HeaderModel
{
  /**
   * Returns the value of the '<em><b>Attribute def</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SYMBOLS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute def</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute def</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAttributeDefinition_Attribute_def()
   * @model containment="true"
   * @generated
   */
  EList<SYMBOLS> getAttribute_def();

  /**
   * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.KeyWord}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAttributeDefinition_Extension()
   * @model containment="true"
   * @generated
   */
  EList<KeyWord> getExtension();

  /**
   * Returns the value of the '<em><b>Extension 2</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Ref}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension 2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension 2</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAttributeDefinition_Extension_2()
   * @model containment="true"
   * @generated
   */
  EList<Ref> getExtension_2();

} // AttributeDefinition
