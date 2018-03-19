/**
 */
package org.xtext.example.mydsl.myDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.example.mydsl.myDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage
 * @generated
 */
public class MyDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MyDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MyDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MyDslPackage.ANNOTATION_LANGUAGE:
      {
        AnnotationLanguage annotationLanguage = (AnnotationLanguage)theEObject;
        T result = caseAnnotationLanguage(annotationLanguage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.HEADER_MODEL:
      {
        HeaderModel headerModel = (HeaderModel)theEObject;
        T result = caseHeaderModel(headerModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ATTRIBUTE_DEFINITION:
      {
        AttributeDefinition attributeDefinition = (AttributeDefinition)theEObject;
        T result = caseAttributeDefinition(attributeDefinition);
        if (result == null) result = caseHeaderModel(attributeDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.REF:
      {
        Ref ref = (Ref)theEObject;
        T result = caseRef(ref);
        if (result == null) result = caseIDSpace(ref);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.METHOD_HEADER:
      {
        MethodHeader methodHeader = (MethodHeader)theEObject;
        T result = caseMethodHeader(methodHeader);
        if (result == null) result = caseHeaderModel(methodHeader);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ID_SPACE:
      {
        IDSpace idSpace = (IDSpace)theEObject;
        T result = caseIDSpace(idSpace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SPECIAL_EXPRESSION:
      {
        SpecialExpression specialExpression = (SpecialExpression)theEObject;
        T result = caseSpecialExpression(specialExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SPACE_ID:
      {
        SpaceID spaceID = (SpaceID)theEObject;
        T result = caseSpaceID(spaceID);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.MULTILINE_ANNOTATION:
      {
        MultilineAnnotation multilineAnnotation = (MultilineAnnotation)theEObject;
        T result = caseMultilineAnnotation(multilineAnnotation);
        if (result == null) result = caseHeaderModel(multilineAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.FUNCTION_ANNOTATION:
      {
        FunctionAnnotation functionAnnotation = (FunctionAnnotation)theEObject;
        T result = caseFunctionAnnotation(functionAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SINGLE_LINE_ANNOTATION:
      {
        SingleLineAnnotation singleLineAnnotation = (SingleLineAnnotation)theEObject;
        T result = caseSingleLineAnnotation(singleLineAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.KEY_WORD:
      {
        KeyWord keyWord = (KeyWord)theEObject;
        T result = caseKeyWord(keyWord);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.SYMBOLS:
      {
        SYMBOLS symbols = (SYMBOLS)theEObject;
        T result = caseSYMBOLS(symbols);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.STRUCT_DEFINITION:
      {
        StructDefinition structDefinition = (StructDefinition)theEObject;
        T result = caseStructDefinition(structDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseRef(expression);
        if (result == null) result = caseIDSpace(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ENTITY_REF:
      {
        EntityRef entityRef = (EntityRef)theEObject;
        T result = caseEntityRef(entityRef);
        if (result == null) result = caseRef(entityRef);
        if (result == null) result = caseIDSpace(entityRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ENTITY:
      {
        Entity entity = (Entity)theEObject;
        T result = caseEntity(entity);
        if (result == null) result = caseSpecialExpression(entity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annotation Language</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annotation Language</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnotationLanguage(AnnotationLanguage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Header Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Header Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHeaderModel(HeaderModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeDefinition(AttributeDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRef(Ref object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Header</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Header</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodHeader(MethodHeader object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ID Space</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ID Space</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIDSpace(IDSpace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Special Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Special Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecialExpression(SpecialExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Space ID</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Space ID</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpaceID(SpaceID object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiline Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiline Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultilineAnnotation(MultilineAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionAnnotation(FunctionAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Line Annotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Line Annotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleLineAnnotation(SingleLineAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key Word</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key Word</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyWord(KeyWord object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SYMBOLS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SYMBOLS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSYMBOLS(SYMBOLS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructDefinition(StructDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntityRef(EntityRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntity(Entity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MyDslSwitch
