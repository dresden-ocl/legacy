/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package tudresden.ocl20.pivot.essentialocl.expressions.impl;

import org.apache.log4j.Logger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tudresden.ocl20.pivot.essentialocl.expressions.RealLiteralExp;
import tudresden.ocl20.pivot.pivotmodel.Type;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Real Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tudresden.ocl20.pivot.essentialocl.expressions.impl.RealLiteralExpImpl#getRealSymbol <em>Real Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealLiteralExpImpl extends NumericLiteralExpImpl implements
		RealLiteralExp {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(RealLiteralExpImpl.class);

	/**
	 * The default value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final float REAL_SYMBOL_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealSymbol()
	 * @generated
	 * @ordered
	 */
	protected float realSymbol = REAL_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RealLiteralExpImpl() {
		super();
	}

	/**
	 * Overridden to determine the type of the <code>RealLiteralExp</code> according to the OCL
	 * specification (Section 8.3):
	 * 
	 * <p>
	 * The type of a real Literal expression is the type Real.
	 * 
	 * <pre>
	 *    context RealLiteralExp
	 *    inv: self.type.name = �Real�
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @see tudresden.ocl20.pivot.pivotmodel.impl.TypedElementImpl#getType()
	 */
	@Override
	protected Type evaluateType() {

		if (logger.isDebugEnabled()) {
			logger.debug("evaluateType() - enter"); //$NON-NLS-1$
		}

		Type type = getValidOclLibrary().getOclReal();

		if (logger.isDebugEnabled()) {
			logger.debug("evaluateType() - exit - return value=" + type); //$NON-NLS-1$
		}

		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public float getRealSymbol() {
		return realSymbol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealSymbol(float newRealSymbol) {
		float oldRealSymbol = realSymbol;
		realSymbol = newRealSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ExpressionsPackageImpl.REAL_LITERAL_EXP__REAL_SYMBOL,
					oldRealSymbol, realSymbol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExpressionsPackageImpl.REAL_LITERAL_EXP__REAL_SYMBOL:
			return getRealSymbol();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExpressionsPackageImpl.REAL_LITERAL_EXP__REAL_SYMBOL:
			setRealSymbol((Float) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ExpressionsPackageImpl.REAL_LITERAL_EXP__REAL_SYMBOL:
			setRealSymbol(REAL_SYMBOL_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ExpressionsPackageImpl.REAL_LITERAL_EXP__REAL_SYMBOL:
			return realSymbol != REAL_SYMBOL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackageImpl.Literals.REAL_LITERAL_EXP;
	}

	/**
	 * Adapted the EMF implementation for uniform rendering with Jakarta Commons Lang mechanism.
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append("realSymbol", realSymbol).toString(); //$NON-NLS-1$
	}

} // RealLiteralExpImpl
