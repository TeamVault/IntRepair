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

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.xtext.example.mydsl.myDsl.Entity;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.SYMBOLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getName3 <em>Name3</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl#getName4 <em>Name4</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends SpecialExpressionImpl implements Entity
{
  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<String> rules;

  /**
   * The cached value of the '{@link #getName0() <em>Name0</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName0()
   * @generated
   * @ordered
   */
  protected SYMBOLS name0;

  /**
   * The cached value of the '{@link #getName1() <em>Name1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName1()
   * @generated
   * @ordered
   */
  protected SYMBOLS name1;

  /**
   * The cached value of the '{@link #getName2() <em>Name2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName2()
   * @generated
   * @ordered
   */
  protected SYMBOLS name2;

  /**
   * The cached value of the '{@link #getName3() <em>Name3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName3()
   * @generated
   * @ordered
   */
  protected SYMBOLS name3;

  /**
   * The cached value of the '{@link #getName4() <em>Name4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName4()
   * @generated
   * @ordered
   */
  protected SYMBOLS name4;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityImpl()
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
    return MyDslPackage.Literals.ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRules()
  {
    if (rules == null)
    {
      rules = new EDataTypeEList<String>(String.class, this, MyDslPackage.ENTITY__RULES);
    }
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS getName0()
  {
    return name0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName0(SYMBOLS newName0, NotificationChain msgs)
  {
    SYMBOLS oldName0 = name0;
    name0 = newName0;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME0, oldName0, newName0);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName0(SYMBOLS newName0)
  {
    if (newName0 != name0)
    {
      NotificationChain msgs = null;
      if (name0 != null)
        msgs = ((InternalEObject)name0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME0, null, msgs);
      if (newName0 != null)
        msgs = ((InternalEObject)newName0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME0, null, msgs);
      msgs = basicSetName0(newName0, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME0, newName0, newName0));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS getName1()
  {
    return name1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName1(SYMBOLS newName1, NotificationChain msgs)
  {
    SYMBOLS oldName1 = name1;
    name1 = newName1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME1, oldName1, newName1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName1(SYMBOLS newName1)
  {
    if (newName1 != name1)
    {
      NotificationChain msgs = null;
      if (name1 != null)
        msgs = ((InternalEObject)name1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME1, null, msgs);
      if (newName1 != null)
        msgs = ((InternalEObject)newName1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME1, null, msgs);
      msgs = basicSetName1(newName1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME1, newName1, newName1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS getName2()
  {
    return name2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName2(SYMBOLS newName2, NotificationChain msgs)
  {
    SYMBOLS oldName2 = name2;
    name2 = newName2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME2, oldName2, newName2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName2(SYMBOLS newName2)
  {
    if (newName2 != name2)
    {
      NotificationChain msgs = null;
      if (name2 != null)
        msgs = ((InternalEObject)name2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME2, null, msgs);
      if (newName2 != null)
        msgs = ((InternalEObject)newName2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME2, null, msgs);
      msgs = basicSetName2(newName2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME2, newName2, newName2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS getName3()
  {
    return name3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName3(SYMBOLS newName3, NotificationChain msgs)
  {
    SYMBOLS oldName3 = name3;
    name3 = newName3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME3, oldName3, newName3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName3(SYMBOLS newName3)
  {
    if (newName3 != name3)
    {
      NotificationChain msgs = null;
      if (name3 != null)
        msgs = ((InternalEObject)name3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME3, null, msgs);
      if (newName3 != null)
        msgs = ((InternalEObject)newName3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME3, null, msgs);
      msgs = basicSetName3(newName3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME3, newName3, newName3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS getName4()
  {
    return name4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName4(SYMBOLS newName4, NotificationChain msgs)
  {
    SYMBOLS oldName4 = name4;
    name4 = newName4;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME4, oldName4, newName4);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName4(SYMBOLS newName4)
  {
    if (newName4 != name4)
    {
      NotificationChain msgs = null;
      if (name4 != null)
        msgs = ((InternalEObject)name4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME4, null, msgs);
      if (newName4 != null)
        msgs = ((InternalEObject)newName4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.ENTITY__NAME4, null, msgs);
      msgs = basicSetName4(newName4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.ENTITY__NAME4, newName4, newName4));
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
      case MyDslPackage.ENTITY__NAME0:
        return basicSetName0(null, msgs);
      case MyDslPackage.ENTITY__NAME1:
        return basicSetName1(null, msgs);
      case MyDslPackage.ENTITY__NAME2:
        return basicSetName2(null, msgs);
      case MyDslPackage.ENTITY__NAME3:
        return basicSetName3(null, msgs);
      case MyDslPackage.ENTITY__NAME4:
        return basicSetName4(null, msgs);
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
      case MyDslPackage.ENTITY__RULES:
        return getRules();
      case MyDslPackage.ENTITY__NAME0:
        return getName0();
      case MyDslPackage.ENTITY__NAME1:
        return getName1();
      case MyDslPackage.ENTITY__NAME2:
        return getName2();
      case MyDslPackage.ENTITY__NAME3:
        return getName3();
      case MyDslPackage.ENTITY__NAME4:
        return getName4();
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
      case MyDslPackage.ENTITY__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends String>)newValue);
        return;
      case MyDslPackage.ENTITY__NAME0:
        setName0((SYMBOLS)newValue);
        return;
      case MyDslPackage.ENTITY__NAME1:
        setName1((SYMBOLS)newValue);
        return;
      case MyDslPackage.ENTITY__NAME2:
        setName2((SYMBOLS)newValue);
        return;
      case MyDslPackage.ENTITY__NAME3:
        setName3((SYMBOLS)newValue);
        return;
      case MyDslPackage.ENTITY__NAME4:
        setName4((SYMBOLS)newValue);
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
      case MyDslPackage.ENTITY__RULES:
        getRules().clear();
        return;
      case MyDslPackage.ENTITY__NAME0:
        setName0((SYMBOLS)null);
        return;
      case MyDslPackage.ENTITY__NAME1:
        setName1((SYMBOLS)null);
        return;
      case MyDslPackage.ENTITY__NAME2:
        setName2((SYMBOLS)null);
        return;
      case MyDslPackage.ENTITY__NAME3:
        setName3((SYMBOLS)null);
        return;
      case MyDslPackage.ENTITY__NAME4:
        setName4((SYMBOLS)null);
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
      case MyDslPackage.ENTITY__RULES:
        return rules != null && !rules.isEmpty();
      case MyDslPackage.ENTITY__NAME0:
        return name0 != null;
      case MyDslPackage.ENTITY__NAME1:
        return name1 != null;
      case MyDslPackage.ENTITY__NAME2:
        return name2 != null;
      case MyDslPackage.ENTITY__NAME3:
        return name3 != null;
      case MyDslPackage.ENTITY__NAME4:
        return name4 != null;
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
    result.append(" (rules: ");
    result.append(rules);
    result.append(')');
    return result.toString();
  }

} //EntityImpl
