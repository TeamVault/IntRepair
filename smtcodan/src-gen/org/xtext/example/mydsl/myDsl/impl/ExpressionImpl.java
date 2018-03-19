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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.Ref;
import org.xtext.example.mydsl.myDsl.SYMBOLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl#getSymbols_attr <em>Symbols attr</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl#getTail <em>Tail</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends RefImpl implements Expression
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Ref ref;

  /**
   * The cached value of the '{@link #getSymbols_attr() <em>Symbols attr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbols_attr()
   * @generated
   * @ordered
   */
  protected EList<SYMBOLS> symbols_attr;

  /**
   * The cached value of the '{@link #getTail() <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTail()
   * @generated
   * @ordered
   */
  protected Ref tail;

  /**
   * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbols()
   * @generated
   * @ordered
   */
  protected EList<SYMBOLS> symbols;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionImpl()
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
    return MyDslPackage.Literals.EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ref getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRef(Ref newRef, NotificationChain msgs)
  {
    Ref oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.EXPRESSION__REF, oldRef, newRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Ref newRef)
  {
    if (newRef != ref)
    {
      NotificationChain msgs = null;
      if (ref != null)
        msgs = ((InternalEObject)ref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.EXPRESSION__REF, null, msgs);
      if (newRef != null)
        msgs = ((InternalEObject)newRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.EXPRESSION__REF, null, msgs);
      msgs = basicSetRef(newRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.EXPRESSION__REF, newRef, newRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SYMBOLS> getSymbols_attr()
  {
    if (symbols_attr == null)
    {
      symbols_attr = new EObjectContainmentEList<SYMBOLS>(SYMBOLS.class, this, MyDslPackage.EXPRESSION__SYMBOLS_ATTR);
    }
    return symbols_attr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ref getTail()
  {
    return tail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTail(Ref newTail, NotificationChain msgs)
  {
    Ref oldTail = tail;
    tail = newTail;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.EXPRESSION__TAIL, oldTail, newTail);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTail(Ref newTail)
  {
    if (newTail != tail)
    {
      NotificationChain msgs = null;
      if (tail != null)
        msgs = ((InternalEObject)tail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.EXPRESSION__TAIL, null, msgs);
      if (newTail != null)
        msgs = ((InternalEObject)newTail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.EXPRESSION__TAIL, null, msgs);
      msgs = basicSetTail(newTail, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.EXPRESSION__TAIL, newTail, newTail));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SYMBOLS> getSymbols()
  {
    if (symbols == null)
    {
      symbols = new EObjectContainmentEList<SYMBOLS>(SYMBOLS.class, this, MyDslPackage.EXPRESSION__SYMBOLS);
    }
    return symbols;
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
      case MyDslPackage.EXPRESSION__REF:
        return basicSetRef(null, msgs);
      case MyDslPackage.EXPRESSION__SYMBOLS_ATTR:
        return ((InternalEList<?>)getSymbols_attr()).basicRemove(otherEnd, msgs);
      case MyDslPackage.EXPRESSION__TAIL:
        return basicSetTail(null, msgs);
      case MyDslPackage.EXPRESSION__SYMBOLS:
        return ((InternalEList<?>)getSymbols()).basicRemove(otherEnd, msgs);
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
      case MyDslPackage.EXPRESSION__REF:
        return getRef();
      case MyDslPackage.EXPRESSION__SYMBOLS_ATTR:
        return getSymbols_attr();
      case MyDslPackage.EXPRESSION__TAIL:
        return getTail();
      case MyDslPackage.EXPRESSION__SYMBOLS:
        return getSymbols();
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
      case MyDslPackage.EXPRESSION__REF:
        setRef((Ref)newValue);
        return;
      case MyDslPackage.EXPRESSION__SYMBOLS_ATTR:
        getSymbols_attr().clear();
        getSymbols_attr().addAll((Collection<? extends SYMBOLS>)newValue);
        return;
      case MyDslPackage.EXPRESSION__TAIL:
        setTail((Ref)newValue);
        return;
      case MyDslPackage.EXPRESSION__SYMBOLS:
        getSymbols().clear();
        getSymbols().addAll((Collection<? extends SYMBOLS>)newValue);
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
      case MyDslPackage.EXPRESSION__REF:
        setRef((Ref)null);
        return;
      case MyDslPackage.EXPRESSION__SYMBOLS_ATTR:
        getSymbols_attr().clear();
        return;
      case MyDslPackage.EXPRESSION__TAIL:
        setTail((Ref)null);
        return;
      case MyDslPackage.EXPRESSION__SYMBOLS:
        getSymbols().clear();
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
      case MyDslPackage.EXPRESSION__REF:
        return ref != null;
      case MyDslPackage.EXPRESSION__SYMBOLS_ATTR:
        return symbols_attr != null && !symbols_attr.isEmpty();
      case MyDslPackage.EXPRESSION__TAIL:
        return tail != null;
      case MyDslPackage.EXPRESSION__SYMBOLS:
        return symbols != null && !symbols.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExpressionImpl
