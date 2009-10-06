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
package tudresden.ocl20.pivot.xocl.provider;

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

import tudresden.ocl20.pivot.xocl.util.XOCLAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class XOCLItemProviderAdapterFactory extends XOCLAdapterFactory
    implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {

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
  public XOCLItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.ConstraintXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintXSItemProvider constraintXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.ConstraintXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createConstraintXSAdapter() {
    if (constraintXSItemProvider == null) {
      constraintXSItemProvider = new ConstraintXSItemProvider(this);
    }

    return constraintXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.ExpressionInOclXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionInOclXSItemProvider expressionInOclXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.ExpressionInOclXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExpressionInOclXSAdapter() {
    if (expressionInOclXSItemProvider == null) {
      expressionInOclXSItemProvider = new ExpressionInOclXSItemProvider(this);
    }

    return expressionInOclXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.VariableXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableXSItemProvider variableXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.VariableXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createVariableXSAdapter() {
    if (variableXSItemProvider == null) {
      variableXSItemProvider = new VariableXSItemProvider(this);
    }

    return variableXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.PropertyCallExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyCallExpXSItemProvider propertyCallExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.PropertyCallExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPropertyCallExpXSAdapter() {
    if (propertyCallExpXSItemProvider == null) {
      propertyCallExpXSItemProvider = new PropertyCallExpXSItemProvider(this);
    }

    return propertyCallExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.BooleanLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanLiteralExpXSItemProvider booleanLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.BooleanLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createBooleanLiteralExpXSAdapter() {
    if (booleanLiteralExpXSItemProvider == null) {
      booleanLiteralExpXSItemProvider = new BooleanLiteralExpXSItemProvider(
          this);
    }

    return booleanLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.CollectionItemXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionItemXSItemProvider collectionItemXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.CollectionItemXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionItemXSAdapter() {
    if (collectionItemXSItemProvider == null) {
      collectionItemXSItemProvider = new CollectionItemXSItemProvider(this);
    }

    return collectionItemXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.CollectionLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralExpXSItemProvider collectionLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.CollectionLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionLiteralExpXSAdapter() {
    if (collectionLiteralExpXSItemProvider == null) {
      collectionLiteralExpXSItemProvider = new CollectionLiteralExpXSItemProvider(
          this);
    }

    return collectionLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.CollectionRangeXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionRangeXSItemProvider collectionRangeXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.CollectionRangeXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionRangeXSAdapter() {
    if (collectionRangeXSItemProvider == null) {
      collectionRangeXSItemProvider = new CollectionRangeXSItemProvider(this);
    }

    return collectionRangeXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.EnumLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumLiteralExpXSItemProvider enumLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.EnumLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEnumLiteralExpXSAdapter() {
    if (enumLiteralExpXSItemProvider == null) {
      enumLiteralExpXSItemProvider = new EnumLiteralExpXSItemProvider(this);
    }

    return enumLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.IfExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfExpXSItemProvider ifExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.IfExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIfExpXSAdapter() {
    if (ifExpXSItemProvider == null) {
      ifExpXSItemProvider = new IfExpXSItemProvider(this);
    }

    return ifExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.IntegerLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegerLiteralExpXSItemProvider integerLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.IntegerLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIntegerLiteralExpXSAdapter() {
    if (integerLiteralExpXSItemProvider == null) {
      integerLiteralExpXSItemProvider = new IntegerLiteralExpXSItemProvider(
          this);
    }

    return integerLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.IterateExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IterateExpXSItemProvider iterateExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.IterateExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIterateExpXSAdapter() {
    if (iterateExpXSItemProvider == null) {
      iterateExpXSItemProvider = new IterateExpXSItemProvider(this);
    }

    return iterateExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.InvalidLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvalidLiteralExpXSItemProvider invalidLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.InvalidLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createInvalidLiteralExpXSAdapter() {
    if (invalidLiteralExpXSItemProvider == null) {
      invalidLiteralExpXSItemProvider = new InvalidLiteralExpXSItemProvider(
          this);
    }

    return invalidLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.IteratorExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IteratorExpXSItemProvider iteratorExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.IteratorExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createIteratorExpXSAdapter() {
    if (iteratorExpXSItemProvider == null) {
      iteratorExpXSItemProvider = new IteratorExpXSItemProvider(this);
    }

    return iteratorExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.LetExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LetExpXSItemProvider letExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.LetExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLetExpXSAdapter() {
    if (letExpXSItemProvider == null) {
      letExpXSItemProvider = new LetExpXSItemProvider(this);
    }

    return letExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.RealLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RealLiteralExpXSItemProvider realLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.RealLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createRealLiteralExpXSAdapter() {
    if (realLiteralExpXSItemProvider == null) {
      realLiteralExpXSItemProvider = new RealLiteralExpXSItemProvider(this);
    }

    return realLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.StringLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringLiteralExpXSItemProvider stringLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.StringLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createStringLiteralExpXSAdapter() {
    if (stringLiteralExpXSItemProvider == null) {
      stringLiteralExpXSItemProvider = new StringLiteralExpXSItemProvider(this);
    }

    return stringLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.TupleLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleLiteralExpXSItemProvider tupleLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.TupleLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTupleLiteralExpXSAdapter() {
    if (tupleLiteralExpXSItemProvider == null) {
      tupleLiteralExpXSItemProvider = new TupleLiteralExpXSItemProvider(this);
    }

    return tupleLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.TupleLiteralPartXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TupleLiteralPartXSItemProvider tupleLiteralPartXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.TupleLiteralPartXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTupleLiteralPartXSAdapter() {
    if (tupleLiteralPartXSItemProvider == null) {
      tupleLiteralPartXSItemProvider = new TupleLiteralPartXSItemProvider(this);
    }

    return tupleLiteralPartXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.TypeLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeLiteralExpXSItemProvider typeLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.TypeLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTypeLiteralExpXSAdapter() {
    if (typeLiteralExpXSItemProvider == null) {
      typeLiteralExpXSItemProvider = new TypeLiteralExpXSItemProvider(this);
    }

    return typeLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.UndefinedLiteralExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UndefinedLiteralExpXSItemProvider undefinedLiteralExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.UndefinedLiteralExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createUndefinedLiteralExpXSAdapter() {
    if (undefinedLiteralExpXSItemProvider == null) {
      undefinedLiteralExpXSItemProvider = new UndefinedLiteralExpXSItemProvider(
          this);
    }

    return undefinedLiteralExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.UnlimitedNaturalExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnlimitedNaturalExpXSItemProvider unlimitedNaturalExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.UnlimitedNaturalExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createUnlimitedNaturalExpXSAdapter() {
    if (unlimitedNaturalExpXSItemProvider == null) {
      unlimitedNaturalExpXSItemProvider = new UnlimitedNaturalExpXSItemProvider(
          this);
    }

    return unlimitedNaturalExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.VariableExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableExpXSItemProvider variableExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.VariableExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createVariableExpXSAdapter() {
    if (variableExpXSItemProvider == null) {
      variableExpXSItemProvider = new VariableExpXSItemProvider(this);
    }

    return variableExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.StaticPropertyCallExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StaticPropertyCallExpXSItemProvider staticPropertyCallExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.StaticPropertyCallExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createStaticPropertyCallExpXSAdapter() {
    if (staticPropertyCallExpXSItemProvider == null) {
      staticPropertyCallExpXSItemProvider = new StaticPropertyCallExpXSItemProvider(
          this);
    }

    return staticPropertyCallExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.StaticOperationCallExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StaticOperationCallExpXSItemProvider staticOperationCallExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.StaticOperationCallExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createStaticOperationCallExpXSAdapter() {
    if (staticOperationCallExpXSItemProvider == null) {
      staticOperationCallExpXSItemProvider = new StaticOperationCallExpXSItemProvider(
          this);
    }

    return staticOperationCallExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.NamespaceXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamespaceXSItemProvider namespaceXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.NamespaceXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createNamespaceXSAdapter() {
    if (namespaceXSItemProvider == null) {
      namespaceXSItemProvider = new NamespaceXSItemProvider(this);
    }

    return namespaceXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.ModelOperationCallExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelOperationCallExpXSItemProvider modelOperationCallExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.ModelOperationCallExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createModelOperationCallExpXSAdapter() {
    if (modelOperationCallExpXSItemProvider == null) {
      modelOperationCallExpXSItemProvider = new ModelOperationCallExpXSItemProvider(
          this);
    }

    return modelOperationCallExpXSItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link tudresden.ocl20.pivot.xocl.CollectionOperationCallExpXS} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionOperationCallExpXSItemProvider collectionOperationCallExpXSItemProvider;

  /**
   * This creates an adapter for a {@link tudresden.ocl20.pivot.xocl.CollectionOperationCallExpXS}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCollectionOperationCallExpXSAdapter() {
    if (collectionOperationCallExpXSItemProvider == null) {
      collectionOperationCallExpXSItemProvider = new CollectionOperationCallExpXSItemProvider(
          this);
    }

    return collectionOperationCallExpXSItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory
        .getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(
      ComposedAdapterFactory parentAdapterFactory) {
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
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type) {
    if (isFactoryForType(type)) {
      Object adapter = super.adapt(object, type);
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
    if (constraintXSItemProvider != null) constraintXSItemProvider.dispose();
    if (expressionInOclXSItemProvider != null)
      expressionInOclXSItemProvider.dispose();
    if (variableXSItemProvider != null) variableXSItemProvider.dispose();
    if (propertyCallExpXSItemProvider != null)
      propertyCallExpXSItemProvider.dispose();
    if (booleanLiteralExpXSItemProvider != null)
      booleanLiteralExpXSItemProvider.dispose();
    if (collectionItemXSItemProvider != null)
      collectionItemXSItemProvider.dispose();
    if (collectionLiteralExpXSItemProvider != null)
      collectionLiteralExpXSItemProvider.dispose();
    if (collectionOperationCallExpXSItemProvider != null)
      collectionOperationCallExpXSItemProvider.dispose();
    if (collectionRangeXSItemProvider != null)
      collectionRangeXSItemProvider.dispose();
    if (enumLiteralExpXSItemProvider != null)
      enumLiteralExpXSItemProvider.dispose();
    if (ifExpXSItemProvider != null) ifExpXSItemProvider.dispose();
    if (integerLiteralExpXSItemProvider != null)
      integerLiteralExpXSItemProvider.dispose();
    if (iterateExpXSItemProvider != null) iterateExpXSItemProvider.dispose();
    if (invalidLiteralExpXSItemProvider != null)
      invalidLiteralExpXSItemProvider.dispose();
    if (iteratorExpXSItemProvider != null) iteratorExpXSItemProvider.dispose();
    if (letExpXSItemProvider != null) letExpXSItemProvider.dispose();
    if (modelOperationCallExpXSItemProvider != null)
      modelOperationCallExpXSItemProvider.dispose();
    if (namespaceXSItemProvider != null) namespaceXSItemProvider.dispose();
    if (realLiteralExpXSItemProvider != null)
      realLiteralExpXSItemProvider.dispose();
    if (staticOperationCallExpXSItemProvider != null)
      staticOperationCallExpXSItemProvider.dispose();
    if (staticPropertyCallExpXSItemProvider != null)
      staticPropertyCallExpXSItemProvider.dispose();
    if (stringLiteralExpXSItemProvider != null)
      stringLiteralExpXSItemProvider.dispose();
    if (tupleLiteralExpXSItemProvider != null)
      tupleLiteralExpXSItemProvider.dispose();
    if (tupleLiteralPartXSItemProvider != null)
      tupleLiteralPartXSItemProvider.dispose();
    if (typeLiteralExpXSItemProvider != null)
      typeLiteralExpXSItemProvider.dispose();
    if (undefinedLiteralExpXSItemProvider != null)
      undefinedLiteralExpXSItemProvider.dispose();
    if (unlimitedNaturalExpXSItemProvider != null)
      unlimitedNaturalExpXSItemProvider.dispose();
    if (variableExpXSItemProvider != null) variableExpXSItemProvider.dispose();
  }

}