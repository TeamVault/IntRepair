/**
 */
package org.xtext.example.mydsl.myDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Function Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionType()
 * @model
 * @generated
 */
public enum FunctionType implements Enumerator
{
  /**
   * The '<em><b>Declassification</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DECLASSIFICATION_VALUE
   * @generated
   * @ordered
   */
  DECLASSIFICATION(0, "declassification", "declassification"),

  /**
   * The '<em><b>Sanitization</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SANITIZATION_VALUE
   * @generated
   * @ordered
   */
  SANITIZATION(1, "sanitization", "sanitization"),

  /**
   * The '<em><b>Sink</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SINK_VALUE
   * @generated
   * @ordered
   */
  SINK(2, "sink", "sink"),

  /**
   * The '<em><b>Source</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SOURCE_VALUE
   * @generated
   * @ordered
   */
  SOURCE(3, "source", "source"),

  /**
   * The '<em><b>Trust boundary</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRUST_BOUNDARY_VALUE
   * @generated
   * @ordered
   */
  TRUST_BOUNDARY(4, "trust_boundary", "trust_boundary");

  /**
   * The '<em><b>Declassification</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Declassification</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DECLASSIFICATION
   * @model name="declassification"
   * @generated
   * @ordered
   */
  public static final int DECLASSIFICATION_VALUE = 0;

  /**
   * The '<em><b>Sanitization</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sanitization</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SANITIZATION
   * @model name="sanitization"
   * @generated
   * @ordered
   */
  public static final int SANITIZATION_VALUE = 1;

  /**
   * The '<em><b>Sink</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sink</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SINK
   * @model name="sink"
   * @generated
   * @ordered
   */
  public static final int SINK_VALUE = 2;

  /**
   * The '<em><b>Source</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Source</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SOURCE
   * @model name="source"
   * @generated
   * @ordered
   */
  public static final int SOURCE_VALUE = 3;

  /**
   * The '<em><b>Trust boundary</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Trust boundary</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRUST_BOUNDARY
   * @model name="trust_boundary"
   * @generated
   * @ordered
   */
  public static final int TRUST_BOUNDARY_VALUE = 4;

  /**
   * An array of all the '<em><b>Function Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final FunctionType[] VALUES_ARRAY =
    new FunctionType[]
    {
      DECLASSIFICATION,
      SANITIZATION,
      SINK,
      SOURCE,
      TRUST_BOUNDARY,
    };

  /**
   * A public read-only list of all the '<em><b>Function Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<FunctionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Function Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FunctionType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FunctionType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Function Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FunctionType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FunctionType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Function Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FunctionType get(int value)
  {
    switch (value)
    {
      case DECLASSIFICATION_VALUE: return DECLASSIFICATION;
      case SANITIZATION_VALUE: return SANITIZATION;
      case SINK_VALUE: return SINK;
      case SOURCE_VALUE: return SOURCE;
      case TRUST_BOUNDARY_VALUE: return TRUST_BOUNDARY;
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
  private FunctionType(int value, String name, String literal)
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
  
} //FunctionType
