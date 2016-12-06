/**
 * generated by Xtext 2.10.0
 */
package uk.ac.kcl.mdeoptimise.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uk.ac.kcl.mdeoptimise.EvolverSpec;
import uk.ac.kcl.mdeoptimise.MdeoptimisePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evolver Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.EvolverSpecImpl#getRule_location <em>Rule location</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.EvolverSpecImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EvolverSpecImpl extends MinimalEObjectImpl.Container implements EvolverSpec
{
  /**
   * The default value of the '{@link #getRule_location() <em>Rule location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule_location()
   * @generated
   * @ordered
   */
  protected static final String RULE_LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRule_location() <em>Rule location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRule_location()
   * @generated
   * @ordered
   */
  protected String rule_location = RULE_LOCATION_EDEFAULT;

  /**
   * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected static final String UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected String unit = UNIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EvolverSpecImpl()
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
    return MdeoptimisePackage.Literals.EVOLVER_SPEC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRule_location()
  {
    return rule_location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRule_location(String newRule_location)
  {
    String oldRule_location = rule_location;
    rule_location = newRule_location;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.EVOLVER_SPEC__RULE_LOCATION, oldRule_location, rule_location));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(String newUnit)
  {
    String oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.EVOLVER_SPEC__UNIT, oldUnit, unit));
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
      case MdeoptimisePackage.EVOLVER_SPEC__RULE_LOCATION:
        return getRule_location();
      case MdeoptimisePackage.EVOLVER_SPEC__UNIT:
        return getUnit();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.EVOLVER_SPEC__RULE_LOCATION:
        setRule_location((String)newValue);
        return;
      case MdeoptimisePackage.EVOLVER_SPEC__UNIT:
        setUnit((String)newValue);
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
      case MdeoptimisePackage.EVOLVER_SPEC__RULE_LOCATION:
        setRule_location(RULE_LOCATION_EDEFAULT);
        return;
      case MdeoptimisePackage.EVOLVER_SPEC__UNIT:
        setUnit(UNIT_EDEFAULT);
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
      case MdeoptimisePackage.EVOLVER_SPEC__RULE_LOCATION:
        return RULE_LOCATION_EDEFAULT == null ? rule_location != null : !RULE_LOCATION_EDEFAULT.equals(rule_location);
      case MdeoptimisePackage.EVOLVER_SPEC__UNIT:
        return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
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
    result.append(" (rule_location: ");
    result.append(rule_location);
    result.append(", unit: ");
    result.append(unit);
    result.append(')');
    return result.toString();
  }

} //EvolverSpecImpl
