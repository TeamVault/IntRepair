/**
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.xtext.example.mydsl.myDsl.AnnotationLanguage;
import org.xtext.example.mydsl.myDsl.AnnotationType;
import org.xtext.example.mydsl.myDsl.AttributeDefinition;
import org.xtext.example.mydsl.myDsl.Entity;
import org.xtext.example.mydsl.myDsl.EntityRef;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.FunctionAnnotation;
import org.xtext.example.mydsl.myDsl.FunctionType;
import org.xtext.example.mydsl.myDsl.HeaderModel;
import org.xtext.example.mydsl.myDsl.IDSpace;
import org.xtext.example.mydsl.myDsl.KeyWord;
import org.xtext.example.mydsl.myDsl.MethodHeader;
import org.xtext.example.mydsl.myDsl.MultilineAnnotation;
import org.xtext.example.mydsl.myDsl.MyDslFactory;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.Ref;
import org.xtext.example.mydsl.myDsl.SecurityType;
import org.xtext.example.mydsl.myDsl.SingleLineAnnotation;
import org.xtext.example.mydsl.myDsl.SpaceID;
import org.xtext.example.mydsl.myDsl.SpecialExpression;
import org.xtext.example.mydsl.myDsl.StructDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyDslPackageImpl extends EPackageImpl implements MyDslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass annotationLanguageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass headerModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodHeaderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idSpaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specialExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spaceIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multilineAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleLineAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keyWordEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symbolsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entityRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum annotationTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum functionTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum securityTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MyDslPackageImpl()
  {
    super(eNS_URI, MyDslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MyDslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MyDslPackage init()
  {
    if (isInited) return (MyDslPackage)EPackage.Registry.INSTANCE.getEPackage(MyDslPackage.eNS_URI);

    // Obtain or create and register package
    MyDslPackageImpl theMyDslPackage = (MyDslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MyDslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MyDslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMyDslPackage.createPackageContents();

    // Initialize created meta-data
    theMyDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMyDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MyDslPackage.eNS_URI, theMyDslPackage);
    return theMyDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnnotationLanguage()
  {
    return annotationLanguageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnnotationLanguage_Element()
  {
    return (EReference)annotationLanguageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHeaderModel()
  {
    return headerModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHeaderModel_Headers()
  {
    return (EReference)headerModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeDefinition()
  {
    return attributeDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDefinition_Attribute_def()
  {
    return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDefinition_Extension()
  {
    return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDefinition_Extension_2()
  {
    return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRef()
  {
    return refEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodHeader()
  {
    return methodHeaderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name0()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name1()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Exp()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name2()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name3()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name4()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name5()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodHeader_Name6()
  {
    return (EReference)methodHeaderEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIDSpace()
  {
    return idSpaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIDSpace_Left()
  {
    return (EReference)idSpaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIDSpace_Right()
  {
    return (EReference)idSpaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecialExpression()
  {
    return specialExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpaceID()
  {
    return spaceIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpaceID_Expr()
  {
    return (EAttribute)spaceIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultilineAnnotation()
  {
    return multilineAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultilineAnnotation_Rule()
  {
    return (EAttribute)multilineAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultilineAnnotation_FunctionAnnotation()
  {
    return (EReference)multilineAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultilineAnnotation_Name0()
  {
    return (EReference)multilineAnnotationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultilineAnnotation_Name1()
  {
    return (EReference)multilineAnnotationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionAnnotation()
  {
    return functionAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_Result()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_FunctionType()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_Level()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionAnnotation_Name0()
  {
    return (EReference)functionAnnotationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_NameComment()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_Parameter()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_SecurityType()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionAnnotation_Name1()
  {
    return (EReference)functionAnnotationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_PreStep()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionAnnotation_Name2()
  {
    return (EReference)functionAnnotationEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionAnnotation_PostStep()
  {
    return (EAttribute)functionAnnotationEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionAnnotation_Name3()
  {
    return (EReference)functionAnnotationEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleLineAnnotation()
  {
    return singleLineAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_Result()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_FunctionType()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_Level()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleLineAnnotation_Name0()
  {
    return (EReference)singleLineAnnotationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_NameComment()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_Parameter()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_SecurityType()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_Variable()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_PreStep()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleLineAnnotation_Name2()
  {
    return (EReference)singleLineAnnotationEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleLineAnnotation_PostStep()
  {
    return (EAttribute)singleLineAnnotationEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleLineAnnotation_Name3()
  {
    return (EReference)singleLineAnnotationEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyWord()
  {
    return keyWordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyWord_Rule()
  {
    return (EAttribute)keyWordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSYMBOLS()
  {
    return symbolsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSYMBOLS_Symbols()
  {
    return (EAttribute)symbolsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSYMBOLS_Name0()
  {
    return (EReference)symbolsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStructDefinition()
  {
    return structDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDefinition_Name0()
  {
    return (EReference)structDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructDefinition_Name1()
  {
    return (EAttribute)structDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructDefinition_Attr()
  {
    return (EAttribute)structDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDefinition_Name2()
  {
    return (EReference)structDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStructDefinition_Name3()
  {
    return (EAttribute)structDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStructDefinition_Name4()
  {
    return (EReference)structDefinitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Ref()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Symbols_attr()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Tail()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Symbols()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntityRef()
  {
    return entityRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntityRef_Entity()
  {
    return (EReference)entityRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntity()
  {
    return entityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntity_Rules()
  {
    return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Name0()
  {
    return (EReference)entityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Name1()
  {
    return (EReference)entityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Name2()
  {
    return (EReference)entityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Name3()
  {
    return (EReference)entityEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity_Name4()
  {
    return (EReference)entityEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAnnotationType()
  {
    return annotationTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFunctionType()
  {
    return functionTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSecurityType()
  {
    return securityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslFactory getMyDslFactory()
  {
    return (MyDslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    annotationLanguageEClass = createEClass(ANNOTATION_LANGUAGE);
    createEReference(annotationLanguageEClass, ANNOTATION_LANGUAGE__ELEMENT);

    headerModelEClass = createEClass(HEADER_MODEL);
    createEReference(headerModelEClass, HEADER_MODEL__HEADERS);

    attributeDefinitionEClass = createEClass(ATTRIBUTE_DEFINITION);
    createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF);
    createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__EXTENSION);
    createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__EXTENSION_2);

    refEClass = createEClass(REF);

    methodHeaderEClass = createEClass(METHOD_HEADER);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME0);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME1);
    createEReference(methodHeaderEClass, METHOD_HEADER__EXP);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME2);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME3);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME4);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME5);
    createEReference(methodHeaderEClass, METHOD_HEADER__NAME6);

    idSpaceEClass = createEClass(ID_SPACE);
    createEReference(idSpaceEClass, ID_SPACE__LEFT);
    createEReference(idSpaceEClass, ID_SPACE__RIGHT);

    specialExpressionEClass = createEClass(SPECIAL_EXPRESSION);

    spaceIDEClass = createEClass(SPACE_ID);
    createEAttribute(spaceIDEClass, SPACE_ID__EXPR);

    multilineAnnotationEClass = createEClass(MULTILINE_ANNOTATION);
    createEAttribute(multilineAnnotationEClass, MULTILINE_ANNOTATION__RULE);
    createEReference(multilineAnnotationEClass, MULTILINE_ANNOTATION__FUNCTION_ANNOTATION);
    createEReference(multilineAnnotationEClass, MULTILINE_ANNOTATION__NAME0);
    createEReference(multilineAnnotationEClass, MULTILINE_ANNOTATION__NAME1);

    functionAnnotationEClass = createEClass(FUNCTION_ANNOTATION);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__RESULT);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__FUNCTION_TYPE);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__LEVEL);
    createEReference(functionAnnotationEClass, FUNCTION_ANNOTATION__NAME0);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__NAME_COMMENT);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__PARAMETER);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__SECURITY_TYPE);
    createEReference(functionAnnotationEClass, FUNCTION_ANNOTATION__NAME1);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__PRE_STEP);
    createEReference(functionAnnotationEClass, FUNCTION_ANNOTATION__NAME2);
    createEAttribute(functionAnnotationEClass, FUNCTION_ANNOTATION__POST_STEP);
    createEReference(functionAnnotationEClass, FUNCTION_ANNOTATION__NAME3);

    singleLineAnnotationEClass = createEClass(SINGLE_LINE_ANNOTATION);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__RESULT);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__FUNCTION_TYPE);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__LEVEL);
    createEReference(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__NAME0);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__NAME_COMMENT);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__PARAMETER);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__SECURITY_TYPE);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__VARIABLE);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__PRE_STEP);
    createEReference(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__NAME2);
    createEAttribute(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__POST_STEP);
    createEReference(singleLineAnnotationEClass, SINGLE_LINE_ANNOTATION__NAME3);

    keyWordEClass = createEClass(KEY_WORD);
    createEAttribute(keyWordEClass, KEY_WORD__RULE);

    symbolsEClass = createEClass(SYMBOLS);
    createEAttribute(symbolsEClass, SYMBOLS__SYMBOLS);
    createEReference(symbolsEClass, SYMBOLS__NAME0);

    structDefinitionEClass = createEClass(STRUCT_DEFINITION);
    createEReference(structDefinitionEClass, STRUCT_DEFINITION__NAME0);
    createEAttribute(structDefinitionEClass, STRUCT_DEFINITION__NAME1);
    createEAttribute(structDefinitionEClass, STRUCT_DEFINITION__ATTR);
    createEReference(structDefinitionEClass, STRUCT_DEFINITION__NAME2);
    createEAttribute(structDefinitionEClass, STRUCT_DEFINITION__NAME3);
    createEReference(structDefinitionEClass, STRUCT_DEFINITION__NAME4);

    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__REF);
    createEReference(expressionEClass, EXPRESSION__SYMBOLS_ATTR);
    createEReference(expressionEClass, EXPRESSION__TAIL);
    createEReference(expressionEClass, EXPRESSION__SYMBOLS);

    entityRefEClass = createEClass(ENTITY_REF);
    createEReference(entityRefEClass, ENTITY_REF__ENTITY);

    entityEClass = createEClass(ENTITY);
    createEAttribute(entityEClass, ENTITY__RULES);
    createEReference(entityEClass, ENTITY__NAME0);
    createEReference(entityEClass, ENTITY__NAME1);
    createEReference(entityEClass, ENTITY__NAME2);
    createEReference(entityEClass, ENTITY__NAME3);
    createEReference(entityEClass, ENTITY__NAME4);

    // Create enums
    annotationTypeEEnum = createEEnum(ANNOTATION_TYPE);
    functionTypeEEnum = createEEnum(FUNCTION_TYPE);
    securityTypeEEnum = createEEnum(SECURITY_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    attributeDefinitionEClass.getESuperTypes().add(this.getHeaderModel());
    refEClass.getESuperTypes().add(this.getIDSpace());
    methodHeaderEClass.getESuperTypes().add(this.getHeaderModel());
    multilineAnnotationEClass.getESuperTypes().add(this.getHeaderModel());
    expressionEClass.getESuperTypes().add(this.getRef());
    entityRefEClass.getESuperTypes().add(this.getRef());
    entityEClass.getESuperTypes().add(this.getSpecialExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(annotationLanguageEClass, AnnotationLanguage.class, "AnnotationLanguage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnnotationLanguage_Element(), this.getHeaderModel(), null, "element", null, 0, -1, AnnotationLanguage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(headerModelEClass, HeaderModel.class, "HeaderModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHeaderModel_Headers(), this.getSingleLineAnnotation(), null, "headers", null, 0, -1, HeaderModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeDefinitionEClass, AttributeDefinition.class, "AttributeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeDefinition_Attribute_def(), this.getSYMBOLS(), null, "attribute_def", null, 0, -1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeDefinition_Extension(), this.getKeyWord(), null, "extension", null, 0, -1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeDefinition_Extension_2(), this.getRef(), null, "extension_2", null, 0, -1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refEClass, Ref.class, "Ref", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(methodHeaderEClass, MethodHeader.class, "MethodHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMethodHeader_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name1(), this.getSYMBOLS(), null, "name1", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Exp(), this.getRef(), null, "exp", null, 0, -1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name2(), this.getSYMBOLS(), null, "name2", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name3(), this.getSYMBOLS(), null, "name3", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name4(), this.getSYMBOLS(), null, "name4", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name5(), this.getSYMBOLS(), null, "name5", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodHeader_Name6(), this.getSYMBOLS(), null, "name6", null, 0, 1, MethodHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idSpaceEClass, IDSpace.class, "IDSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIDSpace_Left(), this.getRef(), null, "left", null, 0, 1, IDSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIDSpace_Right(), this.getSpecialExpression(), null, "right", null, 0, 1, IDSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specialExpressionEClass, SpecialExpression.class, "SpecialExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(spaceIDEClass, SpaceID.class, "SpaceID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpaceID_Expr(), ecorePackage.getEString(), "expr", null, 0, -1, SpaceID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multilineAnnotationEClass, MultilineAnnotation.class, "MultilineAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultilineAnnotation_Rule(), ecorePackage.getEString(), "rule", null, 0, -1, MultilineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultilineAnnotation_FunctionAnnotation(), this.getFunctionAnnotation(), null, "functionAnnotation", null, 0, 1, MultilineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultilineAnnotation_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, MultilineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultilineAnnotation_Name1(), this.getSYMBOLS(), null, "name1", null, 0, 1, MultilineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionAnnotationEClass, FunctionAnnotation.class, "FunctionAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionAnnotation_Result(), ecorePackage.getEString(), "result", null, 0, -1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_FunctionType(), this.getFunctionType(), "functionType", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_Level(), ecorePackage.getEString(), "level", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionAnnotation_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_NameComment(), ecorePackage.getEString(), "nameComment", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_SecurityType(), this.getSecurityType(), "securityType", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionAnnotation_Name1(), this.getSYMBOLS(), null, "name1", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_PreStep(), ecorePackage.getEString(), "preStep", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionAnnotation_Name2(), this.getSYMBOLS(), null, "name2", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionAnnotation_PostStep(), ecorePackage.getEString(), "postStep", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionAnnotation_Name3(), this.getSYMBOLS(), null, "name3", null, 0, 1, FunctionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleLineAnnotationEClass, SingleLineAnnotation.class, "SingleLineAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleLineAnnotation_Result(), ecorePackage.getEString(), "result", null, 0, -1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_FunctionType(), this.getFunctionType(), "functionType", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_Level(), ecorePackage.getEString(), "level", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleLineAnnotation_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_NameComment(), ecorePackage.getEString(), "nameComment", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_SecurityType(), this.getSecurityType(), "securityType", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_PreStep(), ecorePackage.getEString(), "preStep", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleLineAnnotation_Name2(), this.getSYMBOLS(), null, "name2", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSingleLineAnnotation_PostStep(), ecorePackage.getEString(), "postStep", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleLineAnnotation_Name3(), this.getSYMBOLS(), null, "name3", null, 0, 1, SingleLineAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keyWordEClass, KeyWord.class, "KeyWord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyWord_Rule(), ecorePackage.getEString(), "rule", null, 0, 1, KeyWord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(symbolsEClass, org.xtext.example.mydsl.myDsl.SYMBOLS.class, "SYMBOLS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSYMBOLS_Symbols(), ecorePackage.getEString(), "symbols", null, 0, -1, org.xtext.example.mydsl.myDsl.SYMBOLS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSYMBOLS_Name0(), this.getKeyWord(), null, "name0", null, 0, 1, org.xtext.example.mydsl.myDsl.SYMBOLS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structDefinitionEClass, StructDefinition.class, "StructDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructDefinition_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStructDefinition_Name1(), ecorePackage.getEString(), "name1", null, 0, 1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStructDefinition_Attr(), ecorePackage.getEString(), "attr", null, 0, -1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructDefinition_Name2(), this.getSYMBOLS(), null, "name2", null, 0, 1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStructDefinition_Name3(), ecorePackage.getEString(), "name3", null, 0, 1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStructDefinition_Name4(), this.getSYMBOLS(), null, "name4", null, 0, 1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_Ref(), this.getRef(), null, "ref", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Symbols_attr(), this.getSYMBOLS(), null, "symbols_attr", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Tail(), this.getRef(), null, "tail", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Symbols(), this.getSYMBOLS(), null, "symbols", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entityRefEClass, EntityRef.class, "EntityRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEntityRef_Entity(), this.getSpecialExpression(), null, "entity", null, 0, -1, EntityRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEntity_Rules(), ecorePackage.getEString(), "rules", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntity_Name0(), this.getSYMBOLS(), null, "name0", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntity_Name1(), this.getSYMBOLS(), null, "name1", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntity_Name2(), this.getSYMBOLS(), null, "name2", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntity_Name3(), this.getSYMBOLS(), null, "name3", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEntity_Name4(), this.getSYMBOLS(), null, "name4", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(annotationTypeEEnum, AnnotationType.class, "AnnotationType");
    addEEnumLiteral(annotationTypeEEnum, AnnotationType.FUNCTION);
    addEEnumLiteral(annotationTypeEEnum, AnnotationType.PARAMETER);
    addEEnumLiteral(annotationTypeEEnum, AnnotationType.PRE_STEP);
    addEEnumLiteral(annotationTypeEEnum, AnnotationType.POST_STEP);

    initEEnum(functionTypeEEnum, FunctionType.class, "FunctionType");
    addEEnumLiteral(functionTypeEEnum, FunctionType.DECLASSIFICATION);
    addEEnumLiteral(functionTypeEEnum, FunctionType.SANITIZATION);
    addEEnumLiteral(functionTypeEEnum, FunctionType.SINK);
    addEEnumLiteral(functionTypeEEnum, FunctionType.SOURCE);
    addEEnumLiteral(functionTypeEEnum, FunctionType.TRUST_BOUNDARY);

    initEEnum(securityTypeEEnum, SecurityType.class, "SecurityType");
    addEEnumLiteral(securityTypeEEnum, SecurityType.CONFIDENTIAL);
    addEEnumLiteral(securityTypeEEnum, SecurityType.SENSITIVE);

    // Create resource
    createResource(eNS_URI);
  }

} //MyDslPackageImpl
