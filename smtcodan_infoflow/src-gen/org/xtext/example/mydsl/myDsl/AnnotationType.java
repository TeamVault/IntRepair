/**
 */
package org.xtext.example.mydsl.myDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getAnnotationType()
 * @model
 * @generated
 */
public enum AnnotationType implements Enumerator
{
  /**
   * The '<em><b>Function</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FUNCTION_VALUE
   * @generated
   * @ordered
   */
  FUNCTION(0, "function", "function"),

  /**
   * The '<em><b>Parameter</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PARAMETER_VALUE
   * @generated
   * @ordered
   */
  PARAMETER(1, "parameter", "parameter"),

  /**
   * The '<em><b>Pre Step</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PRE_STEP_VALUE
   * @generated
   * @ordered
   */
  PRE_STEP(2, "preStep", "preStep"),

  /**
   * The '<em><b>Post Step</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #POST_STEP_VALUE
   * @generated
   * @ordered
   */
  POST_STEP(3, "postStep", "postStep");

  /**
   * The '<em><b>Function</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Function</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FUNCTION
   * @model name="function"
   * @generated
   * @ordered
   */
  public static final int FUNCTION_VALUE = 0;

  /**
   * The '<em><b>Parameter</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Parameter</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PARAMETER
   * @model name="parameter"
   * @generated
   * @ordered
   */
  public static final int PARAMETER_VALUE = 1;

  /**
   * The '<em><b>Pre Step</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Pre Step</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PRE_STEP
   * @model name="preStep"
   * @generated
   * @ordered
   */
  public static final int PRE_STEP_VALUE = 2;

  /**
   * The '<em><b>Post Step</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Post Step</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #POST_STEP
   * @model name="postStep"
   * @generated
   * @ordered
   */
  public static final int POST_STEP_VALUE = 3;

  /**
   * An array of all the '<em><b>Annotation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AnnotationType[] VALUES_ARRAY =
    new AnnotationType[]
    {
      FUNCTION,
      PARAMETER,
      PRE_STEP,
      POST_STEP,
    };

  /**
   * A public read-only list of all the '<em><b>Annotation Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AnnotationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Annotation Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AnnotationType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Annotation Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AnnotationType get(int value)
  {
    switch (value)
    {
      case FUNCTION_VALUE: return FUNCTION;
      case PARAMETER_VALUE: return PARAMETER;
      case PRE_STEP_VALUE: return PRE_STEP;
      case POST_STEP_VALUE: return POST_STEP;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AnnotationType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AnnotationType
