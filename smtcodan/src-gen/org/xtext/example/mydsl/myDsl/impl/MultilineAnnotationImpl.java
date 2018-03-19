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

import org.xtext.example.mydsl.myDsl.FunctionAnnotation;
import org.xtext.example.mydsl.myDsl.MultilineAnnotation;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.SYMBOLS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiline Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl#getFunctionAnnotation <em>Function Annotation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl#getName1 <em>Name1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultilineAnnotationImpl extends HeaderModelImpl implements MultilineAnnotation
{
  /**
   * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule()
   * @generated
   * @ordered
   */
  protected EList<String> rule;

  /**
   * The cached value of the '{@link #getFunctionAnnotation() <em>Function Annotation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionAnnotation()
   * @generated
   * @ordered
   */
  protected FunctionAnnotation functionAnnotation;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultilineAnnotationImpl()
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
    return MyDslPackage.Literals.MULTILINE_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRule()
  {
    if (rule == null)
    {
      rule = new EDataTypeEList<String>(String.class, this, MyDslPackage.MULTILINE_ANNOTATION__RULE);
    }
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionAnnotation getFunctionAnnotation()
  {
    return functionAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunctionAnnotation(FunctionAnnotation newFunctionAnnotation, NotificationChain msgs)
  {
    FunctionAnnotation oldFunctionAnnotation = functionAnnotation;
    functionAnnotation = newFunctionAnnotation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION, oldFunctionAnnotation, newFunctionAnnotation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionAnnotation(FunctionAnnotation newFunctionAnnotation)
  {
    if (newFunctionAnnotation != functionAnnotation)
    {
      NotificationChain msgs = null;
      if (functionAnnotation != null)
        msgs = ((InternalEObject)functionAnnotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION, null, msgs);
      if (newFunctionAnnotation != null)
        msgs = ((InternalEObject)newFunctionAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION, null, msgs);
      msgs = basicSetFunctionAnnotation(newFunctionAnnotation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION, newFunctionAnnotation, newFunctionAnnotation));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__NAME0, oldName0, newName0);
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
        msgs = ((InternalEObject)name0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__NAME0, null, msgs);
      if (newName0 != null)
        msgs = ((InternalEObject)newName0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__NAME0, null, msgs);
      msgs = basicSetName0(newName0, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__NAME0, newName0, newName0));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__NAME1, oldName1, newName1);
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
        msgs = ((InternalEObject)name1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__NAME1, null, msgs);
      if (newName1 != null)
        msgs = ((InternalEObject)newName1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.MULTILINE_ANNOTATION__NAME1, null, msgs);
      msgs = basicSetName1(newName1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.MULTILINE_ANNOTATION__NAME1, newName1, newName1));
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
      case MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION:
        return basicSetFunctionAnnotation(null, msgs);
      case MyDslPackage.MULTILINE_ANNOTATION__NAME0:
        return basicSetName0(null, msgs);
      case MyDslPackage.MULTILINE_ANNOTATION__NAME1:
        return basicSetName1(null, msgs);
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
      case MyDslPackage.MULTILINE_ANNOTATION__RULE:
        return getRule();
      case MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION:
        return getFunctionAnnotation();
      case MyDslPackage.MULTILINE_ANNOTATION__NAME0:
        return getName0();
      case MyDslPackage.MULTILINE_ANNOTATION__NAME1:
        return getName1();
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
      case MyDslPackage.MULTILINE_ANNOTATION__RULE:
        getRule().clear();
        getRule().addAll((Collection<? extends String>)newValue);
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION:
        setFunctionAnnotation((FunctionAnnotation)newValue);
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME0:
        setName0((SYMBOLS)newValue);
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME1:
        setName1((SYMBOLS)newValue);
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
      case MyDslPackage.MULTILINE_ANNOTATION__RULE:
        getRule().clear();
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION:
        setFunctionAnnotation((FunctionAnnotation)null);
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME0:
        setName0((SYMBOLS)null);
        return;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME1:
        setName1((SYMBOLS)null);
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
      case MyDslPackage.MULTILINE_ANNOTATION__RULE:
        return rule != null && !rule.isEmpty();
      case MyDslPackage.MULTILINE_ANNOTATION__FUNCTION_ANNOTATION:
        return functionAnnotation != null;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME0:
        return name0 != null;
      case MyDslPackage.MULTILINE_ANNOTATION__NAME1:
        return name1 != null;
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
    result.append(" (rule: ");
    result.append(rule);
    result.append(')');
    return result.toString();
  }

} //MultilineAnnotationImpl
