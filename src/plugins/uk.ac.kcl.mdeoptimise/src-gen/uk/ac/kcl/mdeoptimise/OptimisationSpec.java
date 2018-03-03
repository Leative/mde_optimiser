/**
 * generated by Xtext 2.12.0
 */
package uk.ac.kcl.mdeoptimise;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmFactory <em>Algorithm Factory</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmName <em>Algorithm Name</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmVariation <em>Algorithm Variation</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmEvolutions <em>Algorithm Evolutions</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmPopulation <em>Algorithm Population</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmBatches <em>Algorithm Batches</em>}</li>
 * </ul>
 *
 * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec()
 * @model
 * @generated
 */
public interface OptimisationSpec extends EObject
{
  /**
   * Returns the value of the '<em><b>Algorithm Factory</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Factory</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Factory</em>' attribute.
   * @see #setAlgorithmFactory(String)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmFactory()
   * @model
   * @generated
   */
  String getAlgorithmFactory();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmFactory <em>Algorithm Factory</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Factory</em>' attribute.
   * @see #getAlgorithmFactory()
   * @generated
   */
  void setAlgorithmFactory(String value);

  /**
   * Returns the value of the '<em><b>Algorithm Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Name</em>' attribute.
   * @see #setAlgorithmName(String)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmName()
   * @model
   * @generated
   */
  String getAlgorithmName();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmName <em>Algorithm Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Name</em>' attribute.
   * @see #getAlgorithmName()
   * @generated
   */
  void setAlgorithmName(String value);

  /**
   * Returns the value of the '<em><b>Algorithm Variation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Variation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Variation</em>' containment reference.
   * @see #setAlgorithmVariation(AlgorithmVariation)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmVariation()
   * @model containment="true"
   * @generated
   */
  AlgorithmVariation getAlgorithmVariation();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmVariation <em>Algorithm Variation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Variation</em>' containment reference.
   * @see #getAlgorithmVariation()
   * @generated
   */
  void setAlgorithmVariation(AlgorithmVariation value);

  /**
   * Returns the value of the '<em><b>Algorithm Evolutions</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Evolutions</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Evolutions</em>' attribute.
   * @see #setAlgorithmEvolutions(int)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmEvolutions()
   * @model
   * @generated
   */
  int getAlgorithmEvolutions();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmEvolutions <em>Algorithm Evolutions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Evolutions</em>' attribute.
   * @see #getAlgorithmEvolutions()
   * @generated
   */
  void setAlgorithmEvolutions(int value);

  /**
   * Returns the value of the '<em><b>Algorithm Population</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Population</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Population</em>' attribute.
   * @see #setAlgorithmPopulation(int)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmPopulation()
   * @model
   * @generated
   */
  int getAlgorithmPopulation();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmPopulation <em>Algorithm Population</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Population</em>' attribute.
   * @see #getAlgorithmPopulation()
   * @generated
   */
  void setAlgorithmPopulation(int value);

  /**
   * Returns the value of the '<em><b>Algorithm Batches</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Algorithm Batches</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Algorithm Batches</em>' attribute.
   * @see #setAlgorithmBatches(int)
   * @see uk.ac.kcl.mdeoptimise.MdeoptimisePackage#getOptimisationSpec_AlgorithmBatches()
   * @model
   * @generated
   */
  int getAlgorithmBatches();

  /**
   * Sets the value of the '{@link uk.ac.kcl.mdeoptimise.OptimisationSpec#getAlgorithmBatches <em>Algorithm Batches</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Algorithm Batches</em>' attribute.
   * @see #getAlgorithmBatches()
   * @generated
   */
  void setAlgorithmBatches(int value);

} // OptimisationSpec
