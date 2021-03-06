/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tudresden.ocl20.pivot.language.ocl.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tudresden.ocl20.pivot.language.ocl.DefinitionExpOperationCS;
import tudresden.ocl20.pivot.language.ocl.OclFactory;
import tudresden.ocl20.pivot.language.ocl.OclPackage;

/**
 * This is the item provider adapter for a {@link tudresden.ocl20.pivot.language.ocl.DefinitionExpOperationCS} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DefinitionExpOperationCSItemProvider extends
		DefinitionExpPartCSItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinitionExpOperationCSItemProvider(AdapterFactory adapterFactory) {
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

			addEqualPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Equal feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addEqualPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DefinitionExpOperationCS_equal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DefinitionExpOperationCS_equal_feature", "_UI_DefinitionExpOperationCS_type"),
				 OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__EQUAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OPERATION);
			childrenFeatures.add(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DefinitionExpOperationCS.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DefinitionExpOperationCS"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DefinitionExpOperationCS) object).getOperation()
				.getOperation().getName();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DefinitionExpOperationCS.class)) {
			case OclPackage.DEFINITION_EXP_OPERATION_CS__EQUAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OclPackage.DEFINITION_EXP_OPERATION_CS__OPERATION:
			case OclPackage.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OPERATION,
				 OclFactory.eINSTANCE.createOperationDefinitionInDefCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createBracketExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createNamedLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createCollectionTypeLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createTupleTypeLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createEnumLiteralOrStaticPropertyExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createCollectionLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createIteratorExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createIterateExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createNavigationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createPropertyCallOnSelfExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createPropertyCallExplicitPathExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createOperationCallOnSelfExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createStaticOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createUnaryOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLogicalNotOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createOperationCallWithSourceExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createAdditiveOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createMultOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createRelationalOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createEqualityOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLogicalAndOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLogicalOrOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLogicalXorOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLogicalImpliesOperationCallExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createOperationCallWithImlicitSourceExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createTupleLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createIntegerLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createRealLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createBooleanLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createStringLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createInvalidLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createNullLiteralExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createLetExpCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.DEFINITION_EXP_OPERATION_CS__OCL_EXPRESSION,
				 OclFactory.eINSTANCE.createIfExpCS()));
	}

}
