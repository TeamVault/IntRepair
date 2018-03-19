/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.AttributeDefinition;
import org.xtext.example.mydsl.myDsl.KeyWord;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.Ref;
import org.xtext.example.mydsl.myDsl.SYMBOLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl#getAttribute_def <em>Attribute def</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl#getExtension_2 <em>Extension 2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeDefinitionImpl extends HeaderModelImpl implements AttributeDefinition
{
  /**
   * The cached value of the '{@link #getAttribute_def() <em>Attribute def</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute_def()
   * @generated
   * @ordered
   */
  protected EList<SYMBOLS> attribute_def;

  /**
   * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtension()
   * @generated
   * @ordered
   */
  protected EList<KeyWord> extension;

  /**
   * The cached value of the '{@link #getExtension_2() <em>Extension 2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtension_2()
   * @generated
   * @ordered
   */
  protected EList<Ref> extension_2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeDefinitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.ATTRIBUTE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SYMBOLS> getAttribute_def()
  {
    if (attribute_def == null)
    {
      attribute_def = new EObjectContainmentEList<SYMBOLS>(SYMBOLS.class, this, MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF);
    }
    return attribute_def;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<KeyWord> getExtension()
  {
    if (extension == null)
    {
      extension = new EObjectContainmentEList<KeyWord>(KeyWord.class, this, MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION);
    }
    return extension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Ref> getExtension_2()
  {
    if (extension_2 == null)
    {
      extension_2 = new EObjectContainmentEList<Ref>(Ref.class, this, MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2);
    }
    return extension_2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF:
        return ((InternalEList<?>)getAttribute_def()).basicRemove(otherEnd, msgs);
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION:
        return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2:
        return ((InternalEList<?>)getExtension_2()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF:
        return getAttribute_def();
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION:
        return getExtension();
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2:
        return getExtension_2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF:
        getAttribute_def().clear();
        getAttribute_def().addAll((Collection<? extends SYMBOLS>)newValue);
        return;
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION:
        getExtension().clear();
        getExtension().addAll((Collection<? extends KeyWord>)newValue);
        return;
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2:
        getExtension_2().clear();
        getExtension_2().addAll((Collection<? extends Ref>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF:
        getAttribute_def().clear();
        return;
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION:
        getExtension().clear();
        return;
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2:
        getExtension_2().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF:
        return attribute_def != null && !attribute_def.isEmpty();
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION:
        return extension != null && !extension.isEmpty();
      case MyDslPackage.ATTRIBUTE_DEFINITION__EXTENSION_2:
        return extension_2 != null && !extension_2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AttributeDefinitionImpl
