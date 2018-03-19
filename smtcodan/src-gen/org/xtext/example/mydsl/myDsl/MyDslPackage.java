/**
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslFactory
 * @model kind="package"
 * @generated
 */
public interface MyDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "myDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/example/mydsl/MyDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "myDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MyDslPackage eINSTANCE = org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AnnotationLanguageImpl <em>Annotation Language</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AnnotationLanguageImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotationLanguage()
   * @generated
   */
  int ANNOTATION_LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_LANGUAGE__ELEMENT = 0;

  /**
   * The number of structural features of the '<em>Annotation Language</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_LANGUAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.HeaderModelImpl <em>Header Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.HeaderModelImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getHeaderModel()
   * @generated
   */
  int HEADER_MODEL = 1;

  /**
   * The feature id for the '<em><b>Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADER_MODEL__HEADERS = 0;

  /**
   * The number of structural features of the '<em>Header Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEADER_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAttributeDefinition()
   * @generated
   */
  int ATTRIBUTE_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_DEFINITION__HEADERS = HEADER_MODEL__HEADERS;

  /**
   * The feature id for the '<em><b>Attribute def</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF = HEADER_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extension</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_DEFINITION__EXTENSION = HEADER_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Extension 2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_DEFINITION__EXTENSION_2 = HEADER_MODEL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attribute Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_DEFINITION_FEATURE_COUNT = HEADER_MODEL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.IDSpaceImpl <em>ID Space</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.IDSpaceImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIDSpace()
   * @generated
   */
  int ID_SPACE = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SPACE__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SPACE__RIGHT = 1;

  /**
   * The number of structural features of the '<em>ID Space</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_SPACE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.RefImpl <em>Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.RefImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getRef()
   * @generated
   */
  int REF = 3;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF__LEFT = ID_SPACE__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF__RIGHT = ID_SPACE__RIGHT;

  /**
   * The number of structural features of the '<em>Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_FEATURE_COUNT = ID_SPACE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.MethodHeaderImpl <em>Method Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.MethodHeaderImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMethodHeader()
   * @generated
   */
  int METHOD_HEADER = 4;

  /**
   * The feature id for the '<em><b>Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__HEADERS = HEADER_MODEL__HEADERS;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME0 = HEADER_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME1 = HEADER_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__EXP = HEADER_MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME2 = HEADER_MODEL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Name3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME3 = HEADER_MODEL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Name4</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME4 = HEADER_MODEL_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Name5</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME5 = HEADER_MODEL_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Name6</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER__NAME6 = HEADER_MODEL_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Method Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_HEADER_FEATURE_COUNT = HEADER_MODEL_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.SpecialExpressionImpl <em>Special Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.SpecialExpressionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSpecialExpression()
   * @generated
   */
  int SPECIAL_EXPRESSION = 6;

  /**
   * The number of structural features of the '<em>Special Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.SpaceIDImpl <em>Space ID</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.SpaceIDImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSpaceID()
   * @generated
   */
  int SPACE_ID = 7;

  /**
   * The feature id for the '<em><b>Expr</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPACE_ID__EXPR = 0;

  /**
   * The number of structural features of the '<em>Space ID</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPACE_ID_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl <em>Multiline Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultilineAnnotation()
   * @generated
   */
  int MULTILINE_ANNOTATION = 8;

  /**
   * The feature id for the '<em><b>Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION__HEADERS = HEADER_MODEL__HEADERS;

  /**
   * The feature id for the '<em><b>Rule</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION__RULE = HEADER_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Function Annotation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION__FUNCTION_ANNOTATION = HEADER_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION__NAME0 = HEADER_MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION__NAME1 = HEADER_MODEL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Multiline Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_ANNOTATION_FEATURE_COUNT = HEADER_MODEL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionAnnotationImpl <em>Function Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.FunctionAnnotationImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionAnnotation()
   * @generated
   */
  int FUNCTION_ANNOTATION = 9;

  /**
   * The feature id for the '<em><b>Result</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__RESULT = 0;

  /**
   * The feature id for the '<em><b>Function Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__FUNCTION_TYPE = 1;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__LEVEL = 2;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__NAME0 = 3;

  /**
   * The feature id for the '<em><b>Name Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__NAME_COMMENT = 4;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__PARAMETER = 5;

  /**
   * The feature id for the '<em><b>Security Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__SECURITY_TYPE = 6;

  /**
   * The feature id for the '<em><b>Name1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__NAME1 = 7;

  /**
   * The feature id for the '<em><b>Pre Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__PRE_STEP = 8;

  /**
   * The feature id for the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__NAME2 = 9;

  /**
   * The feature id for the '<em><b>Post Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__POST_STEP = 10;

  /**
   * The feature id for the '<em><b>Name3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION__NAME3 = 11;

  /**
   * The number of structural features of the '<em>Function Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ANNOTATION_FEATURE_COUNT = 12;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl <em>Single Line Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSingleLineAnnotation()
   * @generated
   */
  int SINGLE_LINE_ANNOTATION = 10;

  /**
   * The feature id for the '<em><b>Result</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__RESULT = 0;

  /**
   * The feature id for the '<em><b>Function Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__FUNCTION_TYPE = 1;

  /**
   * The feature id for the '<em><b>Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__LEVEL = 2;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__NAME0 = 3;

  /**
   * The feature id for the '<em><b>Name Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__NAME_COMMENT = 4;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__PARAMETER = 5;

  /**
   * The feature id for the '<em><b>Security Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__SECURITY_TYPE = 6;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__VARIABLE = 7;

  /**
   * The feature id for the '<em><b>Pre Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__PRE_STEP = 8;

  /**
   * The feature id for the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__NAME2 = 9;

  /**
   * The feature id for the '<em><b>Post Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__POST_STEP = 10;

  /**
   * The feature id for the '<em><b>Name3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION__NAME3 = 11;

  /**
   * The number of structural features of the '<em>Single Line Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_LINE_ANNOTATION_FEATURE_COUNT = 12;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.KeyWordImpl <em>Key Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.KeyWordImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getKeyWord()
   * @generated
   */
  int KEY_WORD = 11;

  /**
   * The feature id for the '<em><b>Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_WORD__RULE = 0;

  /**
   * The number of structural features of the '<em>Key Word</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_WORD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl <em>SYMBOLS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSYMBOLS()
   * @generated
   */
  int SYMBOLS = 12;

  /**
   * The feature id for the '<em><b>Symbols</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOLS__SYMBOLS = 0;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOLS__NAME0 = 1;

  /**
   * The number of structural features of the '<em>SYMBOLS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOLS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.StructDefinitionImpl <em>Struct Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.StructDefinitionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getStructDefinition()
   * @generated
   */
  int STRUCT_DEFINITION = 13;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__NAME0 = 0;

  /**
   * The feature id for the '<em><b>Name1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__NAME1 = 1;

  /**
   * The feature id for the '<em><b>Attr</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__ATTR = 2;

  /**
   * The feature id for the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__NAME2 = 3;

  /**
   * The feature id for the '<em><b>Name3</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__NAME3 = 4;

  /**
   * The feature id for the '<em><b>Name4</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION__NAME4 = 5;

  /**
   * The number of structural features of the '<em>Struct Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_DEFINITION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ExpressionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__LEFT = REF__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__RIGHT = REF__RIGHT;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__REF = REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Symbols attr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__SYMBOLS_ATTR = REF_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TAIL = REF_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Symbols</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__SYMBOLS = REF_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = REF_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.EntityRefImpl <em>Entity Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.EntityRefImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEntityRef()
   * @generated
   */
  int ENTITY_REF = 15;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_REF__LEFT = REF__LEFT;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_REF__RIGHT = REF__RIGHT;

  /**
   * The feature id for the '<em><b>Entity</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_REF__ENTITY = REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entity Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_REF_FEATURE_COUNT = REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.EntityImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 16;

  /**
   * The feature id for the '<em><b>Rules</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__RULES = SPECIAL_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name0</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME0 = SPECIAL_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME1 = SPECIAL_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME2 = SPECIAL_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Name3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME3 = SPECIAL_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Name4</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME4 = SPECIAL_EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = SPECIAL_EXPRESSION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.AnnotationType <em>Annotation Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.AnnotationType
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotationType()
   * @generated
   */
  int ANNOTATION_TYPE = 17;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.FunctionType <em>Function Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.FunctionType
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionType()
   * @generated
   */
  int FUNCTION_TYPE = 18;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.SecurityType <em>Security Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.SecurityType
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSecurityType()
   * @generated
   */
  int SECURITY_TYPE = 19;


  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.AnnotationLanguage <em>Annotation Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation Language</em>'.
   * @see org.xtext.example.mydsl.myDsl.AnnotationLanguage
   * @generated
   */
  EClass getAnnotationLanguage();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.AnnotationLanguage#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Element</em>'.
   * @see org.xtext.example.mydsl.myDsl.AnnotationLanguage#getElement()
   * @see #getAnnotationLanguage()
   * @generated
   */
  EReference getAnnotationLanguage_Element();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.HeaderModel <em>Header Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Header Model</em>'.
   * @see org.xtext.example.mydsl.myDsl.HeaderModel
   * @generated
   */
  EClass getHeaderModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.HeaderModel#getHeaders <em>Headers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Headers</em>'.
   * @see org.xtext.example.mydsl.myDsl.HeaderModel#getHeaders()
   * @see #getHeaderModel()
   * @generated
   */
  EReference getHeaderModel_Headers();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.AttributeDefinition <em>Attribute Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Definition</em>'.
   * @see org.xtext.example.mydsl.myDsl.AttributeDefinition
   * @generated
   */
  EClass getAttributeDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getAttribute_def <em>Attribute def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute def</em>'.
   * @see org.xtext.example.mydsl.myDsl.AttributeDefinition#getAttribute_def()
   * @see #getAttributeDefinition()
   * @generated
   */
  EReference getAttributeDefinition_Attribute_def();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extension</em>'.
   * @see org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension()
   * @see #getAttributeDefinition()
   * @generated
   */
  EReference getAttributeDefinition_Extension();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension_2 <em>Extension 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extension 2</em>'.
   * @see org.xtext.example.mydsl.myDsl.AttributeDefinition#getExtension_2()
   * @see #getAttributeDefinition()
   * @generated
   */
  EReference getAttributeDefinition_Extension_2();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Ref <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref</em>'.
   * @see org.xtext.example.mydsl.myDsl.Ref
   * @generated
   */
  EClass getRef();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.MethodHeader <em>Method Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Header</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader
   * @generated
   */
  EClass getMethodHeader();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName0()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name0();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name1</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName1()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name1();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exp</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getExp()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Exp();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name2</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName2()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name2();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName3 <em>Name3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name3</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName3()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name3();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName4 <em>Name4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name4</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName4()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name4();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName5 <em>Name5</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name5</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName5()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name5();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MethodHeader#getName6 <em>Name6</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name6</em>'.
   * @see org.xtext.example.mydsl.myDsl.MethodHeader#getName6()
   * @see #getMethodHeader()
   * @generated
   */
  EReference getMethodHeader_Name6();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.IDSpace <em>ID Space</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ID Space</em>'.
   * @see org.xtext.example.mydsl.myDsl.IDSpace
   * @generated
   */
  EClass getIDSpace();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.IDSpace#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.example.mydsl.myDsl.IDSpace#getLeft()
   * @see #getIDSpace()
   * @generated
   */
  EReference getIDSpace_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.IDSpace#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.example.mydsl.myDsl.IDSpace#getRight()
   * @see #getIDSpace()
   * @generated
   */
  EReference getIDSpace_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.SpecialExpression <em>Special Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Special Expression</em>'.
   * @see org.xtext.example.mydsl.myDsl.SpecialExpression
   * @generated
   */
  EClass getSpecialExpression();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.SpaceID <em>Space ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Space ID</em>'.
   * @see org.xtext.example.mydsl.myDsl.SpaceID
   * @generated
   */
  EClass getSpaceID();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.SpaceID#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Expr</em>'.
   * @see org.xtext.example.mydsl.myDsl.SpaceID#getExpr()
   * @see #getSpaceID()
   * @generated
   */
  EAttribute getSpaceID_Expr();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation <em>Multiline Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiline Annotation</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultilineAnnotation
   * @generated
   */
  EClass getMultilineAnnotation();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Rule</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultilineAnnotation#getRule()
   * @see #getMultilineAnnotation()
   * @generated
   */
  EAttribute getMultilineAnnotation_Rule();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getFunctionAnnotation <em>Function Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Annotation</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultilineAnnotation#getFunctionAnnotation()
   * @see #getMultilineAnnotation()
   * @generated
   */
  EReference getMultilineAnnotation_FunctionAnnotation();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName0()
   * @see #getMultilineAnnotation()
   * @generated
   */
  EReference getMultilineAnnotation_Name0();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name1</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultilineAnnotation#getName1()
   * @see #getMultilineAnnotation()
   * @generated
   */
  EReference getMultilineAnnotation_Name1();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation <em>Function Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Annotation</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation
   * @generated
   */
  EClass getFunctionAnnotation();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Result</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getResult()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_Result();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getFunctionType <em>Function Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getFunctionType()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_FunctionType();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getLevel()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_Level();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName0()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EReference getFunctionAnnotation_Name0();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getNameComment <em>Name Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name Comment</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getNameComment()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_NameComment();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getParameter()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_Parameter();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getSecurityType <em>Security Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Security Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getSecurityType()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_SecurityType();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name1</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName1()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EReference getFunctionAnnotation_Name1();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getPreStep <em>Pre Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pre Step</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getPreStep()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_PreStep();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name2</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName2()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EReference getFunctionAnnotation_Name2();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getPostStep <em>Post Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Post Step</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getPostStep()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EAttribute getFunctionAnnotation_PostStep();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName3 <em>Name3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name3</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionAnnotation#getName3()
   * @see #getFunctionAnnotation()
   * @generated
   */
  EReference getFunctionAnnotation_Name3();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation <em>Single Line Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Line Annotation</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation
   * @generated
   */
  EClass getSingleLineAnnotation();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Result</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getResult()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_Result();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getFunctionType <em>Function Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getFunctionType()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_FunctionType();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getLevel <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getLevel()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_Level();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName0()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EReference getSingleLineAnnotation_Name0();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getNameComment <em>Name Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name Comment</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getNameComment()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_NameComment();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getParameter()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_Parameter();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getSecurityType <em>Security Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Security Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getSecurityType()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_SecurityType();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getVariable()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_Variable();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPreStep <em>Pre Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pre Step</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPreStep()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_PreStep();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name2</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName2()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EReference getSingleLineAnnotation_Name2();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPostStep <em>Post Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Post Step</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getPostStep()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EAttribute getSingleLineAnnotation_PostStep();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName3 <em>Name3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name3</em>'.
   * @see org.xtext.example.mydsl.myDsl.SingleLineAnnotation#getName3()
   * @see #getSingleLineAnnotation()
   * @generated
   */
  EReference getSingleLineAnnotation_Name3();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.KeyWord <em>Key Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Word</em>'.
   * @see org.xtext.example.mydsl.myDsl.KeyWord
   * @generated
   */
  EClass getKeyWord();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.KeyWord#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rule</em>'.
   * @see org.xtext.example.mydsl.myDsl.KeyWord#getRule()
   * @see #getKeyWord()
   * @generated
   */
  EAttribute getKeyWord_Rule();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.SYMBOLS <em>SYMBOLS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SYMBOLS</em>'.
   * @see org.xtext.example.mydsl.myDsl.SYMBOLS
   * @generated
   */
  EClass getSYMBOLS();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.SYMBOLS#getSymbols <em>Symbols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Symbols</em>'.
   * @see org.xtext.example.mydsl.myDsl.SYMBOLS#getSymbols()
   * @see #getSYMBOLS()
   * @generated
   */
  EAttribute getSYMBOLS_Symbols();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.SYMBOLS#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.SYMBOLS#getName0()
   * @see #getSYMBOLS()
   * @generated
   */
  EReference getSYMBOLS_Name0();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.StructDefinition <em>Struct Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Definition</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition
   * @generated
   */
  EClass getStructDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getName0()
   * @see #getStructDefinition()
   * @generated
   */
  EReference getStructDefinition_Name0();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name1</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getName1()
   * @see #getStructDefinition()
   * @generated
   */
  EAttribute getStructDefinition_Name1();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attr</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getAttr()
   * @see #getStructDefinition()
   * @generated
   */
  EAttribute getStructDefinition_Attr();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name2</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getName2()
   * @see #getStructDefinition()
   * @generated
   */
  EReference getStructDefinition_Name2();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName3 <em>Name3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name3</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getName3()
   * @see #getStructDefinition()
   * @generated
   */
  EAttribute getStructDefinition_Name3();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.StructDefinition#getName4 <em>Name4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name4</em>'.
   * @see org.xtext.example.mydsl.myDsl.StructDefinition#getName4()
   * @see #getStructDefinition()
   * @generated
   */
  EReference getStructDefinition_Name4();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Expression#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression#getRef()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Expression#getSymbols_attr <em>Symbols attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Symbols attr</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression#getSymbols_attr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Symbols_attr();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Expression#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression#getTail()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Tail();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Expression#getSymbols <em>Symbols</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Symbols</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression#getSymbols()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Symbols();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.EntityRef <em>Entity Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity Ref</em>'.
   * @see org.xtext.example.mydsl.myDsl.EntityRef
   * @generated
   */
  EClass getEntityRef();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.EntityRef#getEntity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entity</em>'.
   * @see org.xtext.example.mydsl.myDsl.EntityRef#getEntity()
   * @see #getEntityRef()
   * @generated
   */
  EReference getEntityRef_Entity();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute list '{@link org.xtext.example.mydsl.myDsl.Entity#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Rules</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getRules()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Rules();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Entity#getName0 <em>Name0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name0</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getName0()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Name0();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Entity#getName1 <em>Name1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name1</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getName1()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Name1();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Entity#getName2 <em>Name2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name2</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getName2()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Name2();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Entity#getName3 <em>Name3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name3</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getName3()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Name3();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Entity#getName4 <em>Name4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name4</em>'.
   * @see org.xtext.example.mydsl.myDsl.Entity#getName4()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Name4();

  /**
   * Returns the meta object for enum '{@link org.xtext.example.mydsl.myDsl.AnnotationType <em>Annotation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Annotation Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.AnnotationType
   * @generated
   */
  EEnum getAnnotationType();

  /**
   * Returns the meta object for enum '{@link org.xtext.example.mydsl.myDsl.FunctionType <em>Function Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Function Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionType
   * @generated
   */
  EEnum getFunctionType();

  /**
   * Returns the meta object for enum '{@link org.xtext.example.mydsl.myDsl.SecurityType <em>Security Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Security Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.SecurityType
   * @generated
   */
  EEnum getSecurityType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MyDslFactory getMyDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AnnotationLanguageImpl <em>Annotation Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AnnotationLanguageImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotationLanguage()
     * @generated
     */
    EClass ANNOTATION_LANGUAGE = eINSTANCE.getAnnotationLanguage();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION_LANGUAGE__ELEMENT = eINSTANCE.getAnnotationLanguage_Element();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.HeaderModelImpl <em>Header Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.HeaderModelImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getHeaderModel()
     * @generated
     */
    EClass HEADER_MODEL = eINSTANCE.getHeaderModel();

    /**
     * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HEADER_MODEL__HEADERS = eINSTANCE.getHeaderModel_Headers();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AttributeDefinitionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAttributeDefinition()
     * @generated
     */
    EClass ATTRIBUTE_DEFINITION = eINSTANCE.getAttributeDefinition();

    /**
     * The meta object literal for the '<em><b>Attribute def</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_DEFINITION__ATTRIBUTE_DEF = eINSTANCE.getAttributeDefinition_Attribute_def();

    /**
     * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_DEFINITION__EXTENSION = eINSTANCE.getAttributeDefinition_Extension();

    /**
     * The meta object literal for the '<em><b>Extension 2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_DEFINITION__EXTENSION_2 = eINSTANCE.getAttributeDefinition_Extension_2();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.RefImpl <em>Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.RefImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getRef()
     * @generated
     */
    EClass REF = eINSTANCE.getRef();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.MethodHeaderImpl <em>Method Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.MethodHeaderImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMethodHeader()
     * @generated
     */
    EClass METHOD_HEADER = eINSTANCE.getMethodHeader();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME0 = eINSTANCE.getMethodHeader_Name0();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME1 = eINSTANCE.getMethodHeader_Name1();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__EXP = eINSTANCE.getMethodHeader_Exp();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME2 = eINSTANCE.getMethodHeader_Name2();

    /**
     * The meta object literal for the '<em><b>Name3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME3 = eINSTANCE.getMethodHeader_Name3();

    /**
     * The meta object literal for the '<em><b>Name4</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME4 = eINSTANCE.getMethodHeader_Name4();

    /**
     * The meta object literal for the '<em><b>Name5</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME5 = eINSTANCE.getMethodHeader_Name5();

    /**
     * The meta object literal for the '<em><b>Name6</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_HEADER__NAME6 = eINSTANCE.getMethodHeader_Name6();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.IDSpaceImpl <em>ID Space</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.IDSpaceImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIDSpace()
     * @generated
     */
    EClass ID_SPACE = eINSTANCE.getIDSpace();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_SPACE__LEFT = eINSTANCE.getIDSpace_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_SPACE__RIGHT = eINSTANCE.getIDSpace_Right();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.SpecialExpressionImpl <em>Special Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.SpecialExpressionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSpecialExpression()
     * @generated
     */
    EClass SPECIAL_EXPRESSION = eINSTANCE.getSpecialExpression();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.SpaceIDImpl <em>Space ID</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.SpaceIDImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSpaceID()
     * @generated
     */
    EClass SPACE_ID = eINSTANCE.getSpaceID();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPACE_ID__EXPR = eINSTANCE.getSpaceID_Expr();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl <em>Multiline Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.MultilineAnnotationImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultilineAnnotation()
     * @generated
     */
    EClass MULTILINE_ANNOTATION = eINSTANCE.getMultilineAnnotation();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTILINE_ANNOTATION__RULE = eINSTANCE.getMultilineAnnotation_Rule();

    /**
     * The meta object literal for the '<em><b>Function Annotation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTILINE_ANNOTATION__FUNCTION_ANNOTATION = eINSTANCE.getMultilineAnnotation_FunctionAnnotation();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTILINE_ANNOTATION__NAME0 = eINSTANCE.getMultilineAnnotation_Name0();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTILINE_ANNOTATION__NAME1 = eINSTANCE.getMultilineAnnotation_Name1();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionAnnotationImpl <em>Function Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.FunctionAnnotationImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionAnnotation()
     * @generated
     */
    EClass FUNCTION_ANNOTATION = eINSTANCE.getFunctionAnnotation();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__RESULT = eINSTANCE.getFunctionAnnotation_Result();

    /**
     * The meta object literal for the '<em><b>Function Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__FUNCTION_TYPE = eINSTANCE.getFunctionAnnotation_FunctionType();

    /**
     * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__LEVEL = eINSTANCE.getFunctionAnnotation_Level();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ANNOTATION__NAME0 = eINSTANCE.getFunctionAnnotation_Name0();

    /**
     * The meta object literal for the '<em><b>Name Comment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__NAME_COMMENT = eINSTANCE.getFunctionAnnotation_NameComment();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__PARAMETER = eINSTANCE.getFunctionAnnotation_Parameter();

    /**
     * The meta object literal for the '<em><b>Security Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__SECURITY_TYPE = eINSTANCE.getFunctionAnnotation_SecurityType();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ANNOTATION__NAME1 = eINSTANCE.getFunctionAnnotation_Name1();

    /**
     * The meta object literal for the '<em><b>Pre Step</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__PRE_STEP = eINSTANCE.getFunctionAnnotation_PreStep();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ANNOTATION__NAME2 = eINSTANCE.getFunctionAnnotation_Name2();

    /**
     * The meta object literal for the '<em><b>Post Step</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_ANNOTATION__POST_STEP = eINSTANCE.getFunctionAnnotation_PostStep();

    /**
     * The meta object literal for the '<em><b>Name3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ANNOTATION__NAME3 = eINSTANCE.getFunctionAnnotation_Name3();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl <em>Single Line Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.SingleLineAnnotationImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSingleLineAnnotation()
     * @generated
     */
    EClass SINGLE_LINE_ANNOTATION = eINSTANCE.getSingleLineAnnotation();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__RESULT = eINSTANCE.getSingleLineAnnotation_Result();

    /**
     * The meta object literal for the '<em><b>Function Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__FUNCTION_TYPE = eINSTANCE.getSingleLineAnnotation_FunctionType();

    /**
     * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__LEVEL = eINSTANCE.getSingleLineAnnotation_Level();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_LINE_ANNOTATION__NAME0 = eINSTANCE.getSingleLineAnnotation_Name0();

    /**
     * The meta object literal for the '<em><b>Name Comment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__NAME_COMMENT = eINSTANCE.getSingleLineAnnotation_NameComment();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__PARAMETER = eINSTANCE.getSingleLineAnnotation_Parameter();

    /**
     * The meta object literal for the '<em><b>Security Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__SECURITY_TYPE = eINSTANCE.getSingleLineAnnotation_SecurityType();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__VARIABLE = eINSTANCE.getSingleLineAnnotation_Variable();

    /**
     * The meta object literal for the '<em><b>Pre Step</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__PRE_STEP = eINSTANCE.getSingleLineAnnotation_PreStep();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_LINE_ANNOTATION__NAME2 = eINSTANCE.getSingleLineAnnotation_Name2();

    /**
     * The meta object literal for the '<em><b>Post Step</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_LINE_ANNOTATION__POST_STEP = eINSTANCE.getSingleLineAnnotation_PostStep();

    /**
     * The meta object literal for the '<em><b>Name3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_LINE_ANNOTATION__NAME3 = eINSTANCE.getSingleLineAnnotation_Name3();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.KeyWordImpl <em>Key Word</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.KeyWordImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getKeyWord()
     * @generated
     */
    EClass KEY_WORD = eINSTANCE.getKeyWord();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_WORD__RULE = eINSTANCE.getKeyWord_Rule();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl <em>SYMBOLS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.SYMBOLSImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSYMBOLS()
     * @generated
     */
    EClass SYMBOLS = eINSTANCE.getSYMBOLS();

    /**
     * The meta object literal for the '<em><b>Symbols</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYMBOLS__SYMBOLS = eINSTANCE.getSYMBOLS_Symbols();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYMBOLS__NAME0 = eINSTANCE.getSYMBOLS_Name0();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.StructDefinitionImpl <em>Struct Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.StructDefinitionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getStructDefinition()
     * @generated
     */
    EClass STRUCT_DEFINITION = eINSTANCE.getStructDefinition();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DEFINITION__NAME0 = eINSTANCE.getStructDefinition_Name0();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_DEFINITION__NAME1 = eINSTANCE.getStructDefinition_Name1();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_DEFINITION__ATTR = eINSTANCE.getStructDefinition_Attr();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DEFINITION__NAME2 = eINSTANCE.getStructDefinition_Name2();

    /**
     * The meta object literal for the '<em><b>Name3</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRUCT_DEFINITION__NAME3 = eINSTANCE.getStructDefinition_Name3();

    /**
     * The meta object literal for the '<em><b>Name4</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_DEFINITION__NAME4 = eINSTANCE.getStructDefinition_Name4();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ExpressionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__REF = eINSTANCE.getExpression_Ref();

    /**
     * The meta object literal for the '<em><b>Symbols attr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__SYMBOLS_ATTR = eINSTANCE.getExpression_Symbols_attr();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__TAIL = eINSTANCE.getExpression_Tail();

    /**
     * The meta object literal for the '<em><b>Symbols</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__SYMBOLS = eINSTANCE.getExpression_Symbols();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.EntityRefImpl <em>Entity Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.EntityRefImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEntityRef()
     * @generated
     */
    EClass ENTITY_REF = eINSTANCE.getEntityRef();

    /**
     * The meta object literal for the '<em><b>Entity</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY_REF__ENTITY = eINSTANCE.getEntityRef_Entity();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.EntityImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__RULES = eINSTANCE.getEntity_Rules();

    /**
     * The meta object literal for the '<em><b>Name0</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__NAME0 = eINSTANCE.getEntity_Name0();

    /**
     * The meta object literal for the '<em><b>Name1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__NAME1 = eINSTANCE.getEntity_Name1();

    /**
     * The meta object literal for the '<em><b>Name2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__NAME2 = eINSTANCE.getEntity_Name2();

    /**
     * The meta object literal for the '<em><b>Name3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__NAME3 = eINSTANCE.getEntity_Name3();

    /**
     * The meta object literal for the '<em><b>Name4</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__NAME4 = eINSTANCE.getEntity_Name4();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.AnnotationType <em>Annotation Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.AnnotationType
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotationType()
     * @generated
     */
    EEnum ANNOTATION_TYPE = eINSTANCE.getAnnotationType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.FunctionType <em>Function Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.FunctionType
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionType()
     * @generated
     */
    EEnum FUNCTION_TYPE = eINSTANCE.getFunctionType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.SecurityType <em>Security Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.SecurityType
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSecurityType()
     * @generated
     */
    EEnum SECURITY_TYPE = eINSTANCE.getSecurityType();

  }

} //MyDslPackage
