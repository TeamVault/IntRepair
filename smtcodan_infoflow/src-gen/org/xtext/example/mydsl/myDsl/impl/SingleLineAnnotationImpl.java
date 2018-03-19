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

import org.xtext.example.mydsl.myDsl.FunctionType;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.SYMBOLS;
import org.xtext.example.mydsl.myDsl.SecurityType;
import org.xtext.example.mydsl.myDsl.SingleLineAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Line Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getFunctionType <em>Function Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getName0 <em>Name0</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getNameComment <em>Name Comment</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getSecurityType <em>Security Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getPreStep <em>Pre Step</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getName2 <em>Name2</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getPostStep <em>Post Step</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl#getName3 <em>Name3</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleLineAnnotationImpl extends MinimalEObjectImpl.Container implements SingleLineAnnotation
{
  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected EList<String> result;

  /**
   * The default value of the '{@link #getFunctionType() <em>Function Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionType()
   * @generated
   * @ordered
   */
  protected static final FunctionType FUNCTION_TYPE_EDEFAULT = FunctionType.DECLASSIFICATION;

  /**
   * The cached value of the '{@link #getFunctionType() <em>Function Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionType()
   * @generated
   * @ordered
   */
  protected FunctionType functionType = FUNCTION_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected static final String LEVEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLevel()
   * @generated
   * @ordered
   */
  protected String level = LEVEL_EDEFAULT;

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
   * The default value of the '{@link #getNameComment() <em>Name Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameComment()
   * @generated
   * @ordered
   */
  protected static final String NAME_COMMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNameComment() <em>Name Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNameComment()
   * @generated
   * @ordered
   */
  protected String nameComment = NAME_COMMENT_EDEFAULT;

  /**
   * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected String parameter = PARAMETER_EDEFAULT;

  /**
   * The default value of the '{@link #getSecurityType() <em>Security Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecurityType()
   * @generated
   * @ordered
   */
  protected static final SecurityType SECURITY_TYPE_EDEFAULT = SecurityType.CONFIDENTIAL;

  /**
   * The cached value of the '{@link #getSecurityType() <em>Security Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecurityType()
   * @generated
   * @ordered
   */
  protected SecurityType securityType = SECURITY_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected static final String VARIABLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected String variable = VARIABLE_EDEFAULT;

  /**
   * The default value of the '{@link #getPreStep() <em>Pre Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreStep()
   * @generated
   * @ordered
   */
  protected static final String PRE_STEP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPreStep() <em>Pre Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreStep()
   * @generated
   * @ordered
   */
  protected String preStep = PRE_STEP_EDEFAULT;

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
   * The default value of the '{@link #getPostStep() <em>Post Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostStep()
   * @generated
   * @ordered
   */
  protected static final String POST_STEP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPostStep() <em>Post Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostStep()
   * @generated
   * @ordered
   */
  protected String postStep = POST_STEP_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleLineAnnotationImpl()
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
    return MyDslPackage.Literals.SINGLE_LINE_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getResult()
  {
    if (result == null)
    {
      result = new EDataTypeEList<String>(String.class, this, MyDslPackage.SINGLE_LINE_ANNOTATION__RESULT);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionType getFunctionType()
  {
    return functionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionType(FunctionType newFunctionType)
  {
    FunctionType oldFunctionType = functionType;
    functionType = newFunctionType == null ? FUNCTION_TYPE_EDEFAULT : newFunctionType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__FUNCTION_TYPE, oldFunctionType, functionType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLevel()
  {
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLevel(String newLevel)
  {
    String oldLevel = level;
    level = newLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__LEVEL, oldLevel, level));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0, oldName0, newName0);
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
        msgs = ((InternalEObject)name0).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0, null, msgs);
      if (newName0 != null)
        msgs = ((InternalEObject)newName0).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0, null, msgs);
      msgs = basicSetName0(newName0, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0, newName0, newName0));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNameComment()
  {
    return nameComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNameComment(String newNameComment)
  {
    String oldNameComment = nameComment;
    nameComment = newNameComment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME_COMMENT, oldNameComment, nameComment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(String newParameter)
  {
    String oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecurityType getSecurityType()
  {
    return securityType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecurityType(SecurityType newSecurityType)
  {
    SecurityType oldSecurityType = securityType;
    securityType = newSecurityType == null ? SECURITY_TYPE_EDEFAULT : newSecurityType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__SECURITY_TYPE, oldSecurityType, securityType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(String newVariable)
  {
    String oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__VARIABLE, oldVariable, variable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPreStep()
  {
    return preStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreStep(String newPreStep)
  {
    String oldPreStep = preStep;
    preStep = newPreStep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__PRE_STEP, oldPreStep, preStep));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2, oldName2, newName2);
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
        msgs = ((InternalEObject)name2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2, null, msgs);
      if (newName2 != null)
        msgs = ((InternalEObject)newName2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2, null, msgs);
      msgs = basicSetName2(newName2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2, newName2, newName2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPostStep()
  {
    return postStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostStep(String newPostStep)
  {
    String oldPostStep = postStep;
    postStep = newPostStep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__POST_STEP, oldPostStep, postStep));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3, oldName3, newName3);
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
        msgs = ((InternalEObject)name3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3, null, msgs);
      if (newName3 != null)
        msgs = ((InternalEObject)newName3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3, null, msgs);
      msgs = basicSetName3(newName3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3, newName3, newName3));
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
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0:
        return basicSetName0(null, msgs);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2:
        return basicSetName2(null, msgs);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3:
        return basicSetName3(null, msgs);
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
      case MyDslPackage.SINGLE_LINE_ANNOTATION__RESULT:
        return getResult();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__FUNCTION_TYPE:
        return getFunctionType();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__LEVEL:
        return getLevel();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0:
        return getName0();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME_COMMENT:
        return getNameComment();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PARAMETER:
        return getParameter();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__SECURITY_TYPE:
        return getSecurityType();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__VARIABLE:
        return getVariable();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PRE_STEP:
        return getPreStep();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2:
        return getName2();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__POST_STEP:
        return getPostStep();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3:
        return getName3();
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
      case MyDslPackage.SINGLE_LINE_ANNOTATION__RESULT:
        getResult().clear();
        getResult().addAll((Collection<? extends String>)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__FUNCTION_TYPE:
        setFunctionType((FunctionType)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__LEVEL:
        setLevel((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0:
        setName0((SYMBOLS)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME_COMMENT:
        setNameComment((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PARAMETER:
        setParameter((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__SECURITY_TYPE:
        setSecurityType((SecurityType)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__VARIABLE:
        setVariable((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PRE_STEP:
        setPreStep((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2:
        setName2((SYMBOLS)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__POST_STEP:
        setPostStep((String)newValue);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3:
        setName3((SYMBOLS)newValue);
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
      case MyDslPackage.SINGLE_LINE_ANNOTATION__RESULT:
        getResult().clear();
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__FUNCTION_TYPE:
        setFunctionType(FUNCTION_TYPE_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__LEVEL:
        setLevel(LEVEL_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0:
        setName0((SYMBOLS)null);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME_COMMENT:
        setNameComment(NAME_COMMENT_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PARAMETER:
        setParameter(PARAMETER_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__SECURITY_TYPE:
        setSecurityType(SECURITY_TYPE_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__VARIABLE:
        setVariable(VARIABLE_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PRE_STEP:
        setPreStep(PRE_STEP_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2:
        setName2((SYMBOLS)null);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__POST_STEP:
        setPostStep(POST_STEP_EDEFAULT);
        return;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3:
        setName3((SYMBOLS)null);
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
      case MyDslPackage.SINGLE_LINE_ANNOTATION__RESULT:
        return result != null && !result.isEmpty();
      case MyDslPackage.SINGLE_LINE_ANNOTATION__FUNCTION_TYPE:
        return functionType != FUNCTION_TYPE_EDEFAULT;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__LEVEL:
        return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME0:
        return name0 != null;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME_COMMENT:
        return NAME_COMMENT_EDEFAULT == null ? nameComment != null : !NAME_COMMENT_EDEFAULT.equals(nameComment);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PARAMETER:
        return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__SECURITY_TYPE:
        return securityType != SECURITY_TYPE_EDEFAULT;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__VARIABLE:
        return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__PRE_STEP:
        return PRE_STEP_EDEFAULT == null ? preStep != null : !PRE_STEP_EDEFAULT.equals(preStep);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME2:
        return name2 != null;
      case MyDslPackage.SINGLE_LINE_ANNOTATION__POST_STEP:
        return POST_STEP_EDEFAULT == null ? postStep != null : !POST_STEP_EDEFAULT.equals(postStep);
      case MyDslPackage.SINGLE_LINE_ANNOTATION__NAME3:
        return name3 != null;
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
    result.append(" (result: ");
    result.append(result);
    result.append(", functionType: ");
    result.append(functionType);
    result.append(", level: ");
    result.append(level);
    result.append(", nameComment: ");
    result.append(nameComment);
    result.append(", parameter: ");
    result.append(parameter);
    result.append(", securityType: ");
    result.append(securityType);
    result.append(", variable: ");
    result.append(variable);
    result.append(", preStep: ");
    result.append(preStep);
    result.append(", postStep: ");
    result.append(postStep);
    result.append(')');
    return result.toString();
  }

} //SingleLineAnnotationImpl
