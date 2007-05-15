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

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.expressions.PropertyCallExp;
import tudresden.ocl20.pivot.essentialocl.expressions.WellformednessException;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link tudresden.ocl20.pivot.essentialocl.expressions.impl.PropertyCallExpImpl#getReferredProperty <em>Referred Property</em>}</li>
 * <li>{@link tudresden.ocl20.pivot.essentialocl.expressions.impl.PropertyCallExpImpl#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PropertyCallExpImpl extends FeatureCallExpImpl implements PropertyCallExp {

  /**
   * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}'
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getReferredProperty()
   * @generated
   * @ordered
   */
  protected Property referredProperty = null;

  /**
   * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' containment reference
   * list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getQualifier()
   * @generated
   * @ordered
   */
  protected EList<OclExpression> qualifier = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected PropertyCallExpImpl() {
    super();
  }

  /**
   * Overridden to determine the type of the <code>PropertyCallExp</code> according to the OCL
   * specification (Section 8.3):
   * 
   * <p>
   * The type of the call expression is the type of the referred property
   * 
   * <pre>
   * context PropertyCallExp
   * inv: type = referredProperty.type
   * </pre>
   * 
   * If the {@link #getReferredProperty() referred property} of this <code>PropertyCallExp</code>
   * is <code>null</code>, a {@link WellformednessException} is thrown.
   * </p>
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.TypedElementImpl#getType()
   */
  @Override
  public Type getType() {

    if (referredProperty == null) {
      throw new WellformednessException(
          "The referred property of a PropertyCallExp must not be null."); //$NON-NLS-1$
    }

    return getOclType(referredProperty.getType());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Property getReferredProperty() {
    return referredProperty;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setReferredProperty(Property newReferredProperty) {
    Property oldReferredProperty = referredProperty;
    referredProperty = newReferredProperty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this,Notification.SET,
          ExpressionsPackageImpl.PROPERTY_CALL_EXP__REFERRED_PROPERTY,oldReferredProperty,
          referredProperty));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public List<OclExpression> getQualifier() {
    if (qualifier == null) {
      qualifier = new EObjectContainmentEList<OclExpression>(OclExpression.class,this,
          ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER);
    }
    return qualifier;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER:
        return ((InternalEList<?>) getQualifier()).basicRemove(otherEnd,msgs);
    }
    return super.eInverseRemove(otherEnd,featureID,msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
        return getReferredProperty();
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER:
        return getQualifier();
    }
    return super.eGet(featureID,resolve,coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
        setReferredProperty((Property) newValue);
        return;
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER:
        getQualifier().clear();
        getQualifier().addAll((Collection<? extends OclExpression>) newValue);
        return;
    }
    super.eSet(featureID,newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
        setReferredProperty((Property) null);
        return;
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER:
        getQualifier().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__REFERRED_PROPERTY:
        return referredProperty != null;
      case ExpressionsPackageImpl.PROPERTY_CALL_EXP__QUALIFIER:
        return qualifier != null && !qualifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ExpressionsPackageImpl.Literals.PROPERTY_CALL_EXP;
  }

} // PropertyCallExpImpl
