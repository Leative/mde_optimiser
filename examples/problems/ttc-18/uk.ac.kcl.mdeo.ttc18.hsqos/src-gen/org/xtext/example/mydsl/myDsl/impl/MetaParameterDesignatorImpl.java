/**
 * generated by Xtext 2.12.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.myDsl.MetaParameter;
import org.xtext.example.mydsl.myDsl.MetaParameterDesignator;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Parameter Designator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.MetaParameterDesignatorImpl#getMetaParameter <em>Meta Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaParameterDesignatorImpl extends DesignatorImpl implements MetaParameterDesignator
{
  /**
   * The cached value of the '{@link #getMetaParameter() <em>Meta Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetaParameter()
   * @generated
   * @ordered
   */
  protected MetaParameter metaParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MetaParameterDesignatorImpl()
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
    return MyDslPackage.Literals.META_PARAMETER_DESIGNATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaParameter getMetaParameter()
  {
    if (metaParameter != null && metaParameter.eIsProxy())
    {
      InternalEObject oldMetaParameter = (InternalEObject)metaParameter;
      metaParameter = (MetaParameter)eResolveProxy(oldMetaParameter);
      if (metaParameter != oldMetaParameter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER, oldMetaParameter, metaParameter));
      }
    }
    return metaParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaParameter basicGetMetaParameter()
  {
    return metaParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetaParameter(MetaParameter newMetaParameter)
  {
    MetaParameter oldMetaParameter = metaParameter;
    metaParameter = newMetaParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER, oldMetaParameter, metaParameter));
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
      case MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER:
        if (resolve) return getMetaParameter();
        return basicGetMetaParameter();
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
      case MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER:
        setMetaParameter((MetaParameter)newValue);
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
      case MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER:
        setMetaParameter((MetaParameter)null);
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
      case MyDslPackage.META_PARAMETER_DESIGNATOR__META_PARAMETER:
        return metaParameter != null;
    }
    return super.eIsSet(featureID);
  }

} //MetaParameterDesignatorImpl