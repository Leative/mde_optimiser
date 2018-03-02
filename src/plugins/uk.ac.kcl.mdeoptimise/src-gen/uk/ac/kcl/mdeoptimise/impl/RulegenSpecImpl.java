/**
 * generated by Xtext 2.10.0
 */
package uk.ac.kcl.mdeoptimise.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uk.ac.kcl.mdeoptimise.MdeoptimisePackage;
import uk.ac.kcl.mdeoptimise.RulegenEdge;
import uk.ac.kcl.mdeoptimise.RulegenNode;
import uk.ac.kcl.mdeoptimise.RulegenSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rulegen Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.RulegenSpecImpl#getNodeSpec <em>Node Spec</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.RulegenSpecImpl#getEdgeSpec <em>Edge Spec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RulegenSpecImpl extends MinimalEObjectImpl.Container implements RulegenSpec
{
  /**
   * The cached value of the '{@link #getNodeSpec() <em>Node Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeSpec()
   * @generated
   * @ordered
   */
  protected RulegenNode nodeSpec;

  /**
   * The cached value of the '{@link #getEdgeSpec() <em>Edge Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEdgeSpec()
   * @generated
   * @ordered
   */
  protected RulegenEdge edgeSpec;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RulegenSpecImpl()
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
    return MdeoptimisePackage.Literals.RULEGEN_SPEC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RulegenNode getNodeSpec()
  {
    return nodeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNodeSpec(RulegenNode newNodeSpec, NotificationChain msgs)
  {
    RulegenNode oldNodeSpec = nodeSpec;
    nodeSpec = newNodeSpec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC, oldNodeSpec, newNodeSpec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeSpec(RulegenNode newNodeSpec)
  {
    if (newNodeSpec != nodeSpec)
    {
      NotificationChain msgs = null;
      if (nodeSpec != null)
        msgs = ((InternalEObject)nodeSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC, null, msgs);
      if (newNodeSpec != null)
        msgs = ((InternalEObject)newNodeSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC, null, msgs);
      msgs = basicSetNodeSpec(newNodeSpec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC, newNodeSpec, newNodeSpec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RulegenEdge getEdgeSpec()
  {
    return edgeSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEdgeSpec(RulegenEdge newEdgeSpec, NotificationChain msgs)
  {
    RulegenEdge oldEdgeSpec = edgeSpec;
    edgeSpec = newEdgeSpec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC, oldEdgeSpec, newEdgeSpec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEdgeSpec(RulegenEdge newEdgeSpec)
  {
    if (newEdgeSpec != edgeSpec)
    {
      NotificationChain msgs = null;
      if (edgeSpec != null)
        msgs = ((InternalEObject)edgeSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC, null, msgs);
      if (newEdgeSpec != null)
        msgs = ((InternalEObject)newEdgeSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC, null, msgs);
      msgs = basicSetEdgeSpec(newEdgeSpec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC, newEdgeSpec, newEdgeSpec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC:
        return basicSetNodeSpec(null, msgs);
      case MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC:
        return basicSetEdgeSpec(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC:
        return getNodeSpec();
      case MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC:
        return getEdgeSpec();
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
      case MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC:
        setNodeSpec((RulegenNode)newValue);
        return;
      case MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC:
        setEdgeSpec((RulegenEdge)newValue);
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
      case MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC:
        setNodeSpec((RulegenNode)null);
        return;
      case MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC:
        setEdgeSpec((RulegenEdge)null);
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
      case MdeoptimisePackage.RULEGEN_SPEC__NODE_SPEC:
        return nodeSpec != null;
      case MdeoptimisePackage.RULEGEN_SPEC__EDGE_SPEC:
        return edgeSpec != null;
    }
    return super.eIsSet(featureID);
  }

} //RulegenSpecImpl