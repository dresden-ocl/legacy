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
package tudresden.ocl20.pivot.essentialocl.expressions.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import tudresden.ocl20.pivot.essentialocl.expressions.util.ExpressionsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsItemProviderAdapterFactory extends ExpressionsAdapterFactory implements
    ComposeableAdapterFactory, IChangeNotifier, IDisposable {

  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.VariableExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableExpItemProvider variableExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.VariableExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createVariableExpAdapter() {
    if (variableExpItemProvider == null) {
      variableExpItemProvider = new VariableExpItemProvider(this);
    }

    return variableExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.Variable} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableItemProvider variableItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.Variable}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createVariableAdapter() {
    if (variableItemProvider == null) {
      variableItemProvider = new VariableItemProvider(this);
    }

    return variableItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.UnlimitedNaturalExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnlimitedNaturalExpItemProvider unlimitedNaturalExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.UnlimitedNaturalExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createUnlimitedNaturalExpAdapter() {
    if (unlimitedNaturalExpItemProvider == null) {
      unlimitedNaturalExpItemProvider = new UnlimitedNaturalExpItemProvider(this);
    }

    return unlimitedNaturalExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.TypeLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeLiteralExpItemProvider typeLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.TypeLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTypeLiteralExpAdapter() {
    if (typeLiteralExpItemProvider == null) {
      typeLiteralExpItemProvider = new TypeLiteralExpItemProvider(this);
    }

    return typeLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralPart} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleLiteralPartItemProvider tupleLiteralPartItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralPart}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTupleLiteralPartAdapter() {
    if (tupleLiteralPartItemProvider == null) {
      tupleLiteralPartItemProvider = new TupleLiteralPartItemProvider(this);
    }

    return tupleLiteralPartItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleLiteralExpItemProvider tupleLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTupleLiteralExpAdapter() {
    if (tupleLiteralExpItemProvider == null) {
      tupleLiteralExpItemProvider = new TupleLiteralExpItemProvider(this);
    }

    return tupleLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.StringLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringLiteralExpItemProvider stringLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.StringLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createStringLiteralExpAdapter() {
    if (stringLiteralExpItemProvider == null) {
      stringLiteralExpItemProvider = new StringLiteralExpItemProvider(this);
    }

    return stringLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.RealLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RealLiteralExpItemProvider realLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.RealLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createRealLiteralExpAdapter() {
    if (realLiteralExpItemProvider == null) {
      realLiteralExpItemProvider = new RealLiteralExpItemProvider(this);
    }

    return realLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.PropertyCallExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyCallExpItemProvider propertyCallExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.PropertyCallExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPropertyCallExpAdapter() {
    if (propertyCallExpItemProvider == null) {
      propertyCallExpItemProvider = new PropertyCallExpItemProvider(this);
    }

    return propertyCallExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationCallExpItemProvider operationCallExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createOperationCallExpAdapter() {
    if (operationCallExpItemProvider == null) {
      operationCallExpItemProvider = new OperationCallExpItemProvider(this);
    }

    return operationCallExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.UndefinedLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UndefinedLiteralExpItemProvider undefinedLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.UndefinedLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createUndefinedLiteralExpAdapter() {
    if (undefinedLiteralExpItemProvider == null) {
      undefinedLiteralExpItemProvider = new UndefinedLiteralExpItemProvider(this);
    }

    return undefinedLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.LetExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LetExpItemProvider letExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.LetExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLetExpAdapter() {
    if (letExpItemProvider == null) {
      letExpItemProvider = new LetExpItemProvider(this);
    }

    return letExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.IteratorExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IteratorExpItemProvider iteratorExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.IteratorExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIteratorExpAdapter() {
    if (iteratorExpItemProvider == null) {
      iteratorExpItemProvider = new IteratorExpItemProvider(this);
    }

    return iteratorExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.IterateExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IterateExpItemProvider iterateExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.IterateExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIterateExpAdapter() {
    if (iterateExpItemProvider == null) {
      iterateExpItemProvider = new IterateExpItemProvider(this);
    }

    return iterateExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.InvalidLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvalidLiteralExpItemProvider invalidLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.InvalidLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createInvalidLiteralExpAdapter() {
    if (invalidLiteralExpItemProvider == null) {
      invalidLiteralExpItemProvider = new InvalidLiteralExpItemProvider(this);
    }

    return invalidLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.IntegerLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegerLiteralExpItemProvider integerLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.IntegerLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIntegerLiteralExpAdapter() {
    if (integerLiteralExpItemProvider == null) {
      integerLiteralExpItemProvider = new IntegerLiteralExpItemProvider(this);
    }

    return integerLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.IfExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfExpItemProvider ifExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.IfExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIfExpAdapter() {
    if (ifExpItemProvider == null) {
      ifExpItemProvider = new IfExpItemProvider(this);
    }

    return ifExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.BooleanLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanLiteralExpItemProvider booleanLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.BooleanLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createBooleanLiteralExpAdapter() {
    if (booleanLiteralExpItemProvider == null) {
      booleanLiteralExpItemProvider = new BooleanLiteralExpItemProvider(this);
    }

    return booleanLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionItem} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionItemItemProvider collectionItemItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionItem}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionItemAdapter() {
    if (collectionItemItemProvider == null) {
      collectionItemItemProvider = new CollectionItemItemProvider(this);
    }

    return collectionItemItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralExpItemProvider collectionLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionLiteralExpAdapter() {
    if (collectionLiteralExpItemProvider == null) {
      collectionLiteralExpItemProvider = new CollectionLiteralExpItemProvider(this);
    }

    return collectionLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionRange} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionRangeItemProvider collectionRangeItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.CollectionRange}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionRangeAdapter() {
    if (collectionRangeItemProvider == null) {
      collectionRangeItemProvider = new CollectionRangeItemProvider(this);
    }

    return collectionRangeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.EnumLiteralExp} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumLiteralExpItemProvider enumLiteralExpItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.EnumLiteralExp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEnumLiteralExpAdapter() {
    if (enumLiteralExpItemProvider == null) {
      enumLiteralExpItemProvider = new EnumLiteralExpItemProvider(this);
    }

    return enumLiteralExpItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionInOclItemProvider expressionInOclItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExpressionInOclAdapter() {
    if (expressionInOclItemProvider == null) {
      expressionInOclItemProvider = new ExpressionInOclItemProvider(this);
    }

    return expressionInOclItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type) {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type) {
    return super.adapt(notifier,this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type) {
    if (isFactoryForType(type)) {
      Object adapter = super.adapt(object,type);
      if (!(type instanceof Class) || (((Class<?>) type).isInstance(adapter))) {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fireNotifyChanged(Notification notification) {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null) {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose() {
    if (variableExpItemProvider != null) variableExpItemProvider.dispose();
    if (variableItemProvider != null) variableItemProvider.dispose();
    if (unlimitedNaturalExpItemProvider != null) unlimitedNaturalExpItemProvider.dispose();
    if (typeLiteralExpItemProvider != null) typeLiteralExpItemProvider.dispose();
    if (tupleLiteralPartItemProvider != null) tupleLiteralPartItemProvider.dispose();
    if (tupleLiteralExpItemProvider != null) tupleLiteralExpItemProvider.dispose();
    if (stringLiteralExpItemProvider != null) stringLiteralExpItemProvider.dispose();
    if (realLiteralExpItemProvider != null) realLiteralExpItemProvider.dispose();
    if (propertyCallExpItemProvider != null) propertyCallExpItemProvider.dispose();
    if (operationCallExpItemProvider != null) operationCallExpItemProvider.dispose();
    if (undefinedLiteralExpItemProvider != null) undefinedLiteralExpItemProvider.dispose();
    if (letExpItemProvider != null) letExpItemProvider.dispose();
    if (iteratorExpItemProvider != null) iteratorExpItemProvider.dispose();
    if (iterateExpItemProvider != null) iterateExpItemProvider.dispose();
    if (invalidLiteralExpItemProvider != null) invalidLiteralExpItemProvider.dispose();
    if (integerLiteralExpItemProvider != null) integerLiteralExpItemProvider.dispose();
    if (ifExpItemProvider != null) ifExpItemProvider.dispose();
    if (booleanLiteralExpItemProvider != null) booleanLiteralExpItemProvider.dispose();
    if (collectionItemItemProvider != null) collectionItemItemProvider.dispose();
    if (collectionLiteralExpItemProvider != null) collectionLiteralExpItemProvider.dispose();
    if (collectionRangeItemProvider != null) collectionRangeItemProvider.dispose();
    if (enumLiteralExpItemProvider != null) enumLiteralExpItemProvider.dispose();
    if (expressionInOclItemProvider != null) expressionInOclItemProvider.dispose();
  }

}
