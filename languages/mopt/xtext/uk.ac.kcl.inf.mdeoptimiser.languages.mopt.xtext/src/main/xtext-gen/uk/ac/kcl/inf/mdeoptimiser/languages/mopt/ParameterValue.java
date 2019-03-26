/**
 * generated by Xtext 2.16.0
 */
package uk.ac.kcl.inf.mdeoptimiser.languages.mopt;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getNumeric <em>Numeric</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getFunctional <em>Functional</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getParametric <em>Parametric</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getParameterValue()
 * @model
 * @generated
 */
public interface ParameterValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Numeric</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Numeric</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Numeric</em>' attribute.
   * @see #setNumeric(String)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getParameterValue_Numeric()
   * @model
   * @generated
   */
  String getNumeric();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getNumeric <em>Numeric</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Numeric</em>' attribute.
   * @see #getNumeric()
   * @generated
   */
  void setNumeric(String value);

  /**
   * Returns the value of the '<em><b>Functional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functional</em>' attribute.
   * @see #setFunctional(String)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getParameterValue_Functional()
   * @model
   * @generated
   */
  String getFunctional();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getFunctional <em>Functional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Functional</em>' attribute.
   * @see #getFunctional()
   * @generated
   */
  void setFunctional(String value);

  /**
   * Returns the value of the '<em><b>Parametric</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parametric</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parametric</em>' attribute.
   * @see #setParametric(String)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getParameterValue_Parametric()
   * @model
   * @generated
   */
  String getParametric();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.ParameterValue#getParametric <em>Parametric</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parametric</em>' attribute.
   * @see #getParametric()
   * @generated
   */
  void setParametric(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getParameterValue_Params()
   * @model containment="true"
   * @generated
   */
  EList<XExpression> getParams();

} // ParameterValue