/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.xtext.example.mydsl.myDsl.KeyWord;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.SYMBOLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SYMBOLS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl#getName0 <em>Name0</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SYMBOLSImpl extends MinimalEObjectImpl.Container implements SYMBOLS
{
  /**
   * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbols()
   * @generated
   * @ordered
   */
  protected EList<String> symbols;

  /**
   * The cached value of the '{@link #getName0() <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName0()
   * @generated
   * @ordered
   */
  protected KeyWord name0;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SYMBOLSImpl()
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
    return MyDslPackage.Literals.SYMBOLS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSymbols()
  {
    if (symbols == null)
    {
      symbols = new EDataTypeEList<String>(String.class, this, MyDslPackage.SYMBOLS__SYMBOLS);
    }
    return symbols;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyWord getName0()
  {
    return name0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName0(KeyWord newName0, NotificationChain msgs)
  {
    KeyWord oldName0 = name0;
    name0 = newName0;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SYMBOLS__NAME0, oldName0, newName0);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName0(KeyWord newName0)
  {
    if (newName0 != name0)
    {
      NotificationChain msgs = null;
      if (name0 != null)
        msgs = ((InternalEObject)name0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYMBOLS__NAME0, null, msgs);
      if (newName0 != null)
        msgs = ((InternalEObject)newName0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYMBOLS__NAME0, null, msgs);
      msgs = basicSetName0(newName0, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SYMBOLS__NAME0, newName0, newName0));
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
      case MyDslPackage.SYMBOLS__NAME0:
        return basicSetName0(null, msgs);
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
      case MyDslPackage.SYMBOLS__SYMBOLS:
        return getSymbols();
      case MyDslPackage.SYMBOLS__NAME0:
        return getName0();
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
      case MyDslPackage.SYMBOLS__SYMBOLS:
        getSymbols().clear();
        getSymbols().addAll((Collection<? extends String>)newValue);
        return;
      case MyDslPackage.SYMBOLS__NAME0:
        setName0((KeyWord)newValue);
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
      case MyDslPackage.SYMBOLS__SYMBOLS:
        getSymbols().clear();
        return;
      case MyDslPackage.SYMBOLS__NAME0:
        setName0((KeyWord)null);
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
      case MyDslPackage.SYMBOLS__SYMBOLS:
        return symbols != null && !symbols.isEmpty();
      case MyDslPackage.SYMBOLS__NAME0:
        return name0 != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (symbols: ");
    result.append(symbols);
    result.append(')');
    return result.toString();
  }

} //SYMBOLSImpl
