/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tudresden.ocl20.pivot.language.ocl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import tudresden.ocl20.pivot.language.ocl.InitOrDeriveValueCS;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.language.ocl.OclPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Or Derive Value CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.language.ocl.impl.InitOrDeriveValueCSImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InitOrDeriveValueCSImpl extends EObjectImpl implements InitOrDeriveValueCS {
	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionCS oclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitOrDeriveValueCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclPackage.Literals.INIT_OR_DERIVE_VALUE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionCS getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(OclExpressionCS newOclExpression, NotificationChain msgs) {
		OclExpressionCS oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(OclExpressionCS newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
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
		switch (featureID) {
			case OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION:
				return getOclExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION:
				setOclExpression((OclExpressionCS)newValue);
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
		switch (featureID) {
			case OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION:
				setOclExpression((OclExpressionCS)null);
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
		switch (featureID) {
			case OclPackage.INIT_OR_DERIVE_VALUE_CS__OCL_EXPRESSION:
				return oclExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //InitOrDeriveValueCSImpl
