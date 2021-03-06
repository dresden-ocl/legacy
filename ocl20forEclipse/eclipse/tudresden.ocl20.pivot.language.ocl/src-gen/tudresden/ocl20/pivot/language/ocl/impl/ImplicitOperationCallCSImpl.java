/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tudresden.ocl20.pivot.language.ocl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tudresden.ocl20.pivot.language.ocl.ImplicitOperationCallCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclPackage;
import tudresden.ocl20.pivot.language.ocl.OperationCallBaseExpCS;
import tudresden.ocl20.pivot.pivotmodel.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implicit Operation Call CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.impl.ImplicitOperationCallCSImpl#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.impl.ImplicitOperationCallCSImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.impl.ImplicitOperationCallCSImpl#isIsMarkedPre <em>Is Marked Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplicitOperationCallCSImpl extends ImplicitFeatureCallCSImpl implements ImplicitOperationCallCS {
	/**
   * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOperationName()
   * @generated
   * @ordered
   */
	protected Operation operationName;

	/**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
	protected EList<OclExpressionCS> arguments;

	/**
   * The default value of the '{@link #isIsMarkedPre() <em>Is Marked Pre</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isIsMarkedPre()
   * @generated
   * @ordered
   */
	protected static final boolean IS_MARKED_PRE_EDEFAULT = false;

	/**
   * The cached value of the '{@link #isIsMarkedPre() <em>Is Marked Pre</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isIsMarkedPre()
   * @generated
   * @ordered
   */
	protected boolean isMarkedPre = IS_MARKED_PRE_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ImplicitOperationCallCSImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return OclPackage.Literals.IMPLICIT_OPERATION_CALL_CS;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Operation getOperationName() {
    if (operationName != null && operationName.eIsProxy())
    {
      InternalEObject oldOperationName = (InternalEObject)operationName;
      operationName = (Operation)eResolveProxy(oldOperationName);
      if (operationName != oldOperationName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME, oldOperationName, operationName));
      }
    }
    return operationName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Operation basicGetOperationName() {
    return operationName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOperationName(Operation newOperationName) {
    Operation oldOperationName = operationName;
    operationName = newOperationName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME, oldOperationName, operationName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<OclExpressionCS> getArguments() {
    if (arguments == null)
    {
      arguments = new EObjectContainmentEList<OclExpressionCS>(OclExpressionCS.class, this, OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS);
    }
    return arguments;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isIsMarkedPre() {
    return isMarkedPre;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setIsMarkedPre(boolean newIsMarkedPre) {
    boolean oldIsMarkedPre = isMarkedPre;
    isMarkedPre = newIsMarkedPre;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE, oldIsMarkedPre, isMarkedPre));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME:
        if (resolve) return getOperationName();
        return basicGetOperationName();
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS:
        return getArguments();
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE:
        return isIsMarkedPre();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME:
        setOperationName((Operation)newValue);
        return;
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends OclExpressionCS>)newValue);
        return;
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE:
        setIsMarkedPre((Boolean)newValue);
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
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME:
        setOperationName((Operation)null);
        return;
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS:
        getArguments().clear();
        return;
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE:
        setIsMarkedPre(IS_MARKED_PRE_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME:
        return operationName != null;
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
      case OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE:
        return isMarkedPre != IS_MARKED_PRE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == OperationCallBaseExpCS.class)
    {
      switch (derivedFeatureID)
      {
        case OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME: return OclPackage.OPERATION_CALL_BASE_EXP_CS__OPERATION_NAME;
        case OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS: return OclPackage.OPERATION_CALL_BASE_EXP_CS__ARGUMENTS;
        case OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE: return OclPackage.OPERATION_CALL_BASE_EXP_CS__IS_MARKED_PRE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == OperationCallBaseExpCS.class)
    {
      switch (baseFeatureID)
      {
        case OclPackage.OPERATION_CALL_BASE_EXP_CS__OPERATION_NAME: return OclPackage.IMPLICIT_OPERATION_CALL_CS__OPERATION_NAME;
        case OclPackage.OPERATION_CALL_BASE_EXP_CS__ARGUMENTS: return OclPackage.IMPLICIT_OPERATION_CALL_CS__ARGUMENTS;
        case OclPackage.OPERATION_CALL_BASE_EXP_CS__IS_MARKED_PRE: return OclPackage.IMPLICIT_OPERATION_CALL_CS__IS_MARKED_PRE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (isMarkedPre: ");
    result.append(isMarkedPre);
    result.append(')');
    return result.toString();
  }

} //ImplicitOperationCallCSImpl
