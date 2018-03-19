/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.mydsl.myDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyDslFactoryImpl extends EFactoryImpl implements MyDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MyDslFactory init()
  {
    try
    {
      MyDslFactory theMyDslFactory = (MyDslFactory)EPackage.Registry.INSTANCE.getEFactory(MyDslPackage.eNS_URI);
      if (theMyDslFactory != null)
      {
        return theMyDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MyDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MyDslPackage.ANNOTATION_LANGUAGE: return createAnnotationLanguage();
      case MyDslPackage.HEADER_MODEL: return createHeaderModel();
      case MyDslPackage.ATTRIBUTE_DEFINITION: return createAttributeDefinition();
      case MyDslPackage.REF: return createRef();
      case MyDslPackage.METHOD_HEADER: return createMethodHeader();
      case MyDslPackage.ID_SPACE: return createIDSpace();
      case MyDslPackage.SPECIAL_EXPRESSION: return createSpecialExpression();
      case MyDslPackage.SPACE_ID: return createSpaceID();
      case MyDslPackage.MULTILINE_ANNOTATION: return createMultilineAnnotation();
      case MyDslPackage.FUNCTION_ANNOTATION: return createFunctionAnnotation();
      case MyDslPackage.SINGLE_LINE_ANNOTATION: return createSingleLineAnnotation();
      case MyDslPackage.KEY_WORD: return createKeyWord();
      case MyDslPackage.SYMBOLS: return createSYMBOLS();
      case MyDslPackage.STRUCT_DEFINITION: return createStructDefinition();
      case MyDslPackage.EXPRESSION: return createExpression();
      case MyDslPackage.ENTITY_REF: return createEntityRef();
      case MyDslPackage.ENTITY: return createEntity();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MyDslPackage.ANNOTATION_TYPE:
        return createAnnotationTypeFromString(eDataType, initialValue);
      case MyDslPackage.FUNCTION_TYPE:
        return createFunctionTypeFromString(eDataType, initialValue);
      case MyDslPackage.SECURITY_TYPE:
        return createSecurityTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case MyDslPackage.ANNOTATION_TYPE:
        return convertAnnotationTypeToString(eDataType, instanceValue);
      case MyDslPackage.FUNCTION_TYPE:
        return convertFunctionTypeToString(eDataType, instanceValue);
      case MyDslPackage.SECURITY_TYPE:
        return convertSecurityTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationLanguage createAnnotationLanguage()
  {
    AnnotationLanguageImpl annotationLanguage = new AnnotationLanguageImpl();
    return annotationLanguage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HeaderModel createHeaderModel()
  {
    HeaderModelImpl headerModel = new HeaderModelImpl();
    return headerModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeDefinition createAttributeDefinition()
  {
    AttributeDefinitionImpl attributeDefinition = new AttributeDefinitionImpl();
    return attributeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ref createRef()
  {
    RefImpl ref = new RefImpl();
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodHeader createMethodHeader()
  {
    MethodHeaderImpl methodHeader = new MethodHeaderImpl();
    return methodHeader;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IDSpace createIDSpace()
  {
    IDSpaceImpl idSpace = new IDSpaceImpl();
    return idSpace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialExpression createSpecialExpression()
  {
    SpecialExpressionImpl specialExpression = new SpecialExpressionImpl();
    return specialExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpaceID createSpaceID()
  {
    SpaceIDImpl spaceID = new SpaceIDImpl();
    return spaceID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultilineAnnotation createMultilineAnnotation()
  {
    MultilineAnnotationImpl multilineAnnotation = new MultilineAnnotationImpl();
    return multilineAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionAnnotation createFunctionAnnotation()
  {
    FunctionAnnotationImpl functionAnnotation = new FunctionAnnotationImpl();
    return functionAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleLineAnnotation createSingleLineAnnotation()
  {
    SingleLineAnnotationImpl singleLineAnnotation = new SingleLineAnnotationImpl();
    return singleLineAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyWord createKeyWord()
  {
    KeyWordImpl keyWord = new KeyWordImpl();
    return keyWord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SYMBOLS createSYMBOLS()
  {
    SYMBOLSImpl symbols = new SYMBOLSImpl();
    return symbols;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructDefinition createStructDefinition()
  {
    StructDefinitionImpl structDefinition = new StructDefinitionImpl();
    return structDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntityRef createEntityRef()
  {
    EntityRefImpl entityRef = new EntityRefImpl();
    return entityRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotationType createAnnotationTypeFromString(EDataType eDataType, String initialValue)
  {
    AnnotationType result = AnnotationType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAnnotationTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionType createFunctionTypeFromString(EDataType eDataType, String initialValue)
  {
    FunctionType result = FunctionType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFunctionTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecurityType createSecurityTypeFromString(EDataType eDataType, String initialValue)
  {
    SecurityType result = SecurityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSecurityTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslPackage getMyDslPackage()
  {
    return (MyDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MyDslPackage getPackage()
  {
    return MyDslPackage.eINSTANCE;
  }

} //MyDslFactoryImpl
