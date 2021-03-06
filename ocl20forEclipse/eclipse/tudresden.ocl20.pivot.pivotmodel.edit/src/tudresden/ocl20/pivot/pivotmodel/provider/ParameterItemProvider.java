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
package tudresden.ocl20.pivot.pivotmodel.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.ParameterDirectionKind;
import tudresden.ocl20.pivot.pivotmodel.PivotModelPackage;
import tudresden.ocl20.pivot.pivotmodel.impl.PivotModelPackageImpl;

/**
 * This is the item provider adapter for a
 * {@link tudresden.ocl20.pivot.pivotmodel.Parameter} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParameterItemProvider extends TypedElementItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterItemProvider(AdapterFactory adapterFactory) {

		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addKindPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Kind feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {

		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Parameter_kind_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_Parameter_kind_feature", "_UI_Parameter_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						PivotModelPackage.Literals.PARAMETER__KIND, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns the image for a {@link Parameter}.
	 * 
	 * <p>
	 * The EMF implementation is extended to return different images, depending on
	 * the {@link ParameterDirectionKind kind} of the parameter.
	 * </p>
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		switch (((Parameter) object).getKind()) {
		case RETURN:
			return overlayImage(object,
					getResourceLocator().getImage("full/obj16/ReturnParameter")); //$NON-NLS-1$
		default:
			return overlayImage(object,
					getResourceLocator().getImage("full/obj16/Parameter")); //$NON-NLS-1$
		}

	}

	/**
	 * Changed the EMF implementation to simply call the super implementation in
	 * {@link TypedElementItemProvider}.
	 * 
	 * @see TypedElementItemProvider#getText(Object)
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {

		return super.getText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which it
	 * passes to {@link #fireNotifyChanged}.
	 * 
	 * <p>
	 * Extended the EMF implementation to update the operation signature label
	 * when changing parameter attributes or changing the return parameter.
	 * </p>
	 * 
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {

		updateChildren(notification);

		// get a casted version of the parameter
		Parameter parameter = (Parameter) notification.getNotifier();

		switch (notification.getFeatureID(Parameter.class)) {
		case PivotModelPackageImpl.PARAMETER__KIND: {
			// the return parameter was changed, the operation signature must be
			// updated
			if (notification.getOldValue() == ParameterDirectionKind.RETURN
					|| notification.getNewValue() == ParameterDirectionKind.RETURN) {
				fireNotifyChanged(new ViewerNotification(notification,
						parameter.getOperation(), false, true));
			}

			return;
		}

		// any other change to the parameter's name, type or generic type needs to
		// be propagated
		case PivotModelPackageImpl.PARAMETER__NAME:
		case PivotModelPackageImpl.PARAMETER__TYPE:
		case PivotModelPackageImpl.PARAMETER__GENERIC_TYPE:
			fireNotifyChanged(new ViewerNotification(notification,
					parameter.getOperation(), false, true));
			return;
		}

		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing
	 * the children that can be created under this object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
