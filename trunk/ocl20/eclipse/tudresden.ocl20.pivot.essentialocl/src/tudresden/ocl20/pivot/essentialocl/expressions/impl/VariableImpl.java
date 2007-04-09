/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology      *
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.expressions.Variable;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.ParameterDirectionKind;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.impl.TypedElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link tudresden.ocl20.pivot.essentialocl.expressions.impl.VariableImpl#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * <li>{@link tudresden.ocl20.pivot.essentialocl.expressions.impl.VariableImpl#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariableImpl extends TypedElementImpl implements Variable {

  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(VariableImpl.class);

  /**
   * The cached value of the '{@link #getRepresentedParameter() <em>Represented Parameter</em>}'
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getRepresentedParameter()
   * @generated
   * @ordered
   */
  protected Parameter representedParameter = null;

  /**
   * The cached value of the '{@link #getInitExpression() <em>Init Expression</em>}' containment
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getInitExpression()
   * @generated
   * @ordered
   */
  protected OclExpression initExpression = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected VariableImpl() {
    super();
  }

  /**
   * Overridden to return the name of the {@link #getRepresentedParameter() represented parameter}
   * if this <code>Variable</code> represents a {@link Parameter}.
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.NamedElementImpl#getName()
   */
  @Override
  public String getName() {
    return representedParameter != null ? representedParameter.getName() : super.getName();
  }

  /**
   * Overridden to return the type of the {@link #getRepresentedParameter() represented parameter}
   * if this <code>Variable</code> represents a {@link Parameter}.
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.TypedElementImpl#getType()
   */
  @Override
  public Type getType() {
    return representedParameter != null ? representedParameter.getType() : super.getType();
  }

  /**
   * Returns <code>null</code> as a <code>Variable</code> does not have an owner.
   * 
   * @see tudresden.ocl20.pivot.pivotmodel.impl.NamedElementImpl#getOwner()
   */
  @Override
  public NamedElement getOwner() {
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Parameter getRepresentedParameter() {
    return representedParameter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setRepresentedParameter(Parameter newRepresentedParameter) {
    Parameter oldRepresentedParameter = representedParameter;
    representedParameter = newRepresentedParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this,Notification.SET,
          ExpressionsPackageImpl.VARIABLE__REPRESENTED_PARAMETER,oldRepresentedParameter,
          representedParameter));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public OclExpression getInitExpression() {
    return initExpression;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public NotificationChain basicSetInitExpression(OclExpression newInitExpression,
      NotificationChain msgs) {
    OclExpression oldInitExpression = initExpression;
    initExpression = newInitExpression;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this,Notification.SET,
          ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION,oldInitExpression,newInitExpression);
      if (msgs == null) msgs = notification;
      else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setInitExpression(OclExpression newInitExpression) {
    if (newInitExpression != initExpression) {
      NotificationChain msgs = null;
      if (initExpression != null)
        msgs = ((InternalEObject) initExpression).eInverseRemove(this,EOPPOSITE_FEATURE_BASE
            - ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION,null,msgs);
      if (newInitExpression != null)
        msgs = ((InternalEObject) newInitExpression).eInverseAdd(this,EOPPOSITE_FEATURE_BASE
            - ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION,null,msgs);
      msgs = basicSetInitExpression(newInitExpression,msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this,Notification.SET,
          ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION,newInitExpression,newInitExpression));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Parameter asParameter() {
    if (logger.isDebugEnabled()) {
      logger.debug("asParameter() - enter"); //$NON-NLS-1$
    }

    Parameter parameter;

    parameter = PivotModelFactory.INSTANCE.createParameter();
    parameter.setName(getName());
    parameter.setType(getType());
    parameter.setKind(ParameterDirectionKind.IN);

    if (logger.isDebugEnabled()) {
      logger.debug("asParameter() - exit - return value=" + parameter); //$NON-NLS-1$
    }

    return parameter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Property asProperty() {
    if (logger.isDebugEnabled()) {
      logger.debug("asProperty() - enter"); //$NON-NLS-1$
    }

    Property property = PivotModelFactory.INSTANCE.createProperty();

    property.setName(getName());
    property.setType(getType());

    if (logger.isDebugEnabled()) {
      logger.debug("asProperty() - exit - return value=" + property); //$NON-NLS-1$
    }

    return property;
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
      case ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION:
        return basicSetInitExpression(null,msgs);
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
      case ExpressionsPackageImpl.VARIABLE__REPRESENTED_PARAMETER:
        return getRepresentedParameter();
      case ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION:
        return getInitExpression();
    }
    return super.eGet(featureID,resolve,coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ExpressionsPackageImpl.VARIABLE__REPRESENTED_PARAMETER:
        setRepresentedParameter((Parameter) newValue);
        return;
      case ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION:
        setInitExpression((OclExpression) newValue);
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
      case ExpressionsPackageImpl.VARIABLE__REPRESENTED_PARAMETER:
        setRepresentedParameter((Parameter) null);
        return;
      case ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION:
        setInitExpression((OclExpression) null);
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
      case ExpressionsPackageImpl.VARIABLE__REPRESENTED_PARAMETER:
        return representedParameter != null;
      case ExpressionsPackageImpl.VARIABLE__INIT_EXPRESSION:
        return initExpression != null;
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
    return ExpressionsPackageImpl.Literals.VARIABLE;
  }

} // VariableImpl
