/*
Copyright (C) 2009 by Claas Wilke (info@claaswilke.de)

This file is part of the Java OCL Standard Library of Dresden OCL2 for Eclipse.

Dresden OCL2 for Eclipse is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL2 for Eclipse is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL2 for Eclipse. If not, see <http://www.gnu.org/licenses/>.
 */
package tudresden.ocl20.pivot.standardlibrary.java.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.util.UniqueEList;

import tudresden.ocl20.pivot.essentialocl.expressions.CollectionKind;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBag;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclCollection;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclEnumLiteral;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclInteger;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclInvalid;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclOrderedSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclReal;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSequence;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclString;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclTuple;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.factory.IStandardLibraryFactory;
import tudresden.ocl20.pivot.essentialocl.types.AnyType;
import tudresden.ocl20.pivot.essentialocl.types.BagType;
import tudresden.ocl20.pivot.essentialocl.types.CollectionType;
import tudresden.ocl20.pivot.essentialocl.types.OrderedSetType;
import tudresden.ocl20.pivot.essentialocl.types.SequenceType;
import tudresden.ocl20.pivot.essentialocl.types.SetType;
import tudresden.ocl20.pivot.essentialocl.types.TypesFactory;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceBoolean;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceEnumerationLiteral;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceInteger;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceInvalid;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceObject;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceReal;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceString;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceTuple;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceVoid;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.base.BasisJavaModelInstanceFactory;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.base.TypeConstants;
import tudresden.ocl20.pivot.modelbus.util.OclCollectionTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Enumeration;
import tudresden.ocl20.pivot.pivotmodel.EnumerationLiteral;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclAny;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclBag;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclBoolean;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclEnumLiteral;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclInteger;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclInvalid;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclModelInstanceObject;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclOrderedSet;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclReal;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclSequence;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclSet;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclString;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclTuple;
import tudresden.ocl20.pivot.standardlibrary.java.internal.library.JavaOclVoid;

// FIXME Michael: remove factory methods that get an IMICollection as parameter

/**
 * <p>
 * The {@link JavaStandardLibraryFactory} provides methods to create
 * {@link OclAny} required during OCL interpretation.
 * </p>
 */
public class JavaStandardLibraryFactory implements IStandardLibraryFactory {

	private static JavaStandardLibraryFactory instance;

	private static JavaStandardLibraryFactory getInstance() {

		if (instance == null)
			instance = new JavaStandardLibraryFactory();
		return instance;
	}

	/** The singleton instance of the {@link JavaStandardLibraryFactory}. */
	public static JavaStandardLibraryFactory INSTANCE = getInstance();

	private BasisJavaModelInstanceFactory basisJavaModelInstanceFactory =
			new BasisJavaModelInstanceFactory();

	/**
	 * Contains the already adapted {@link OclAny} identified by their adapted
	 * {@link Object} (model element). <strong>This is a {@link WeakHashMap}! If
	 * an {@link Object} is disposed, its adapter can also be disposed.</strong>
	 */
	private Map<Object, OclAny> cachedAdaptedObjects =
			new WeakHashMap<Object, OclAny>();

	/**
	 * Contains the already adapted {@link OclAny} identified by their
	 * {@link IModelInstanceElement}. Is used to cache the undefined and invalid
	 * reasons for elements that are already adapted to {@link OclAny}.
	 */
	private Map<IModelInstanceElement, OclAny> cachedUndefinedOrInvalid =
			new WeakHashMap<IModelInstanceElement, OclAny>();

	/**
	 * Private Singleton constructor.
	 */
	private JavaStandardLibraryFactory() {

	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclAny(tudresden.ocl20.pivot.modelbus.modelinstance
	 * .types.IModelInstanceElement)
	 */
	@SuppressWarnings("unchecked")
	public OclAny createOclAny(final IModelInstanceElement modelInstanceElement) {

		OclAny result;

		if (modelInstanceElement == null) {
			throw new IllegalArgumentException(
					"Cannot create OclAny with \'null\' as given IModelInstanceElement.");
		}

		else if (modelInstanceElement instanceof IModelInstanceVoid) {
			if (cachedUndefinedOrInvalid.containsKey(modelInstanceElement))
				result = cachedUndefinedOrInvalid.get(modelInstanceElement);
			else {
				result = JavaOclVoid.INSTANCE;
				cachedUndefinedOrInvalid.put(modelInstanceElement, result);
			}
		}

		else if (modelInstanceElement instanceof IModelInstanceInvalid) {
			if (cachedUndefinedOrInvalid.containsKey(modelInstanceElement))
				result = cachedUndefinedOrInvalid.get(modelInstanceElement);
			else {
				result = JavaOclInvalid.INSTANCE;
				cachedUndefinedOrInvalid.put(modelInstanceElement, result);
			}
		}

		else if (modelInstanceElement instanceof IModelInstanceInteger) {
			result = new JavaOclInteger((IModelInstanceInteger) modelInstanceElement);
		}

		else if (modelInstanceElement instanceof IModelInstanceReal) {
			result = new JavaOclReal((IModelInstanceReal) modelInstanceElement);
		}

		else if (modelInstanceElement instanceof IModelInstanceBoolean) {
			result =
					JavaOclBoolean
							.getInstance(((IModelInstanceBoolean) modelInstanceElement)
									.getBoolean());
		}

		else if (modelInstanceElement instanceof IModelInstanceString) {
			result = new JavaOclString((IModelInstanceString) modelInstanceElement);
		}

		else if (modelInstanceElement instanceof IModelInstanceEnumerationLiteral) {
			result =
					new JavaOclEnumLiteral(
							(IModelInstanceEnumerationLiteral) modelInstanceElement);
		}

		else if (modelInstanceElement instanceof IModelInstanceCollection<?>) {

			IModelInstanceCollection<IModelInstanceElement> collection =
					(IModelInstanceCollection<IModelInstanceElement>) modelInstanceElement;

			// FIXME Michael: what if there are multiple Types?
			result =
					this.createOclCollection(collection, collection.getTypes().iterator()
							.next());
		}

		// FIXME Michael: what if there are multiple Types?
		else if (modelInstanceElement instanceof IModelInstanceObject) {
			IModelInstanceObject modelInstanceObject =
					(IModelInstanceObject) modelInstanceElement;
			result =
					new JavaOclModelInstanceObject(modelInstanceObject,
							modelInstanceObject.getTypes().iterator().next());
		}

		else {
			throw new IllegalArgumentException(
					"Cannot create an OclAny with the given IModelInstanceElement "
							+ modelInstanceElement.getName());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclBag(java.util.List)
	 */
	public <T extends OclAny> OclBag<T> createOclBag(final List<?> elements,
			Type genericType) {

		List<IModelInstanceElement> imiElements;
		imiElements = new ArrayList<IModelInstanceElement>();

		for (Object element : elements) {

			if (element instanceof IModelInstanceElement) {

				imiElements.add((IModelInstanceElement) element);
			}
			else if (element instanceof OclAny) {

				imiElements.add(((OclAny) element).getModelInstanceElement());
			}
			else {
				throw new IllegalArgumentException("Cannot create JavaOclBag for "
						+ elements);
			}
		}

		IModelInstanceCollection<IModelInstanceElement> imiCollection =
				basisJavaModelInstanceFactory.createModelInstanceCollection(
						imiElements, OclCollectionTypeKind.BAG);

		return new JavaOclBag<T>(imiCollection, genericType);
	}

	public <T extends OclAny> OclBag<T> createOclBag(
			IModelInstanceCollection<IModelInstanceElement> elements, Type genericType) {

		OclBag<T> result;

		if (elements.isOrdered() || elements.isUnique()) {
			Collection<IModelInstanceElement> bag =
					new UniqueEList<IModelInstanceElement>(elements.getCollection());

			IModelInstanceCollection<IModelInstanceElement> imiResult =
					basisJavaModelInstanceFactory.createModelInstanceCollection(bag,
							OclCollectionTypeKind.BAG);

			result = new JavaOclBag<T>(imiResult, genericType);
		}
		else {
			result = new JavaOclBag<T>(elements, genericType);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclBoolean(java.lang.Boolean)
	 */
	public OclBoolean createOclBoolean(final Boolean value) {

		return JavaOclBoolean.getInstance(value);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclBoolean(tudresden.ocl20.pivot.modelbus.modelinstance
	 * .types.IModelInstanceBoolean)
	 */
	public OclBoolean createOclBoolean(final IModelInstanceBoolean value) {

		return JavaOclBoolean.getInstance(value.getBoolean());
	}

	public OclCollection<OclAny> createOclCollection(
			CollectionType collectionType, Type genericType) {

		OclCollection<OclAny> result;

		IModelInstanceCollection<IModelInstanceElement> imiCollection;

		CollectionKind collectionKind = collectionType.getKind();

		if (collectionKind.equals(CollectionKind.BAG)) {
			imiCollection =
					basisJavaModelInstanceFactory
							.createModelInstanceCollection(
									new ArrayList<IModelInstanceElement>(),
									OclCollectionTypeKind.BAG);
			result = createOclBag(imiCollection, genericType);
		}
		else if (collectionKind.equals(CollectionKind.ORDERED_SET)) {
			imiCollection =
					basisJavaModelInstanceFactory.createModelInstanceCollection(
							new UniqueEList<IModelInstanceElement>(),
							OclCollectionTypeKind.ORDEREDSET);
			result = createOclOrderedSet(imiCollection, genericType);
		}
		else if (collectionKind.equals(CollectionKind.SEQUENCE)) {
			imiCollection =
					basisJavaModelInstanceFactory.createModelInstanceCollection(
							new ArrayList<IModelInstanceElement>(),
							OclCollectionTypeKind.SEQUENCE);
			result = createOclSequence(imiCollection, genericType);
		}
		else if (collectionKind.equals(CollectionKind.SET)) {
			imiCollection =
					basisJavaModelInstanceFactory.createModelInstanceCollection(
							new HashSet<IModelInstanceElement>(), OclCollectionTypeKind.SET);
			result = createOclSet(imiCollection, genericType);
		}
		else {
			throw new IllegalArgumentException(
					"Cannot create OclCollection with given type " + collectionType);
		}

		return result;
	}

	protected OclCollection<OclAny> createOclCollection(
			IModelInstanceCollection<IModelInstanceElement> imiCollection,
			Type genericType) {

		OclCollection<OclAny> result;

		if (imiCollection.isOrdered()) {
			if (imiCollection.isUnique()) {
				result = new JavaOclOrderedSet<OclAny>(imiCollection, genericType);
			}
			else {
				result = new JavaOclSequence<OclAny>(imiCollection, genericType);
			}
		}
		else { // not ordered
			if (imiCollection.isUnique()) {
				result = new JavaOclSet<OclAny>(imiCollection, genericType);
			}
			else {
				result = new JavaOclBag<OclAny>(imiCollection, genericType);
			}
		}

		return result;

	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclEnumLiteral(java.lang.Enum)
	 */
	public OclEnumLiteral createOclEnumLiteral(final EnumerationLiteral value) {

		IModelInstanceEnumerationLiteral imiEnumLiteral =
				BasisJavaModelInstanceFactory
						.createModelInstanceEnumerationLiteral(value);

		return new JavaOclEnumLiteral(imiEnumLiteral);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclEnumLiteral(tudresden.ocl20.pivot.modelbus.
	 * modelinstance.types.IModelInstanceEnumerationLiteral)
	 */
	public OclEnumLiteral createOclEnumLiteral(
			final IModelInstanceEnumerationLiteral value) {

		return new JavaOclEnumLiteral(value);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclInteger(java.lang.Long)
	 */
	public OclInteger createOclInteger(final Long value) {

		IModelInstanceInteger imiInteger =
				BasisJavaModelInstanceFactory.createModelInstanceInteger(value);

		return new JavaOclInteger(imiInteger);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclInteger(tudresden.ocl20.pivot.modelbus.modelinstance
	 * .types.IModelInstanceInteger)
	 */
	public OclInteger createOclInteger(final IModelInstanceInteger value) {

		return new JavaOclInteger(value);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclModelInstanceObject(tudresden.ocl20.pivot.modelbus
	 * .modelinstance.types.IModelInstanceObject)
	 */
	public OclModelInstanceObject createOclModelInstanceObject(
			IModelInstanceObject modelInstanceObject) {

		OclModelInstanceObject result;

		/* Probably use a cached result. */
		if (cachedAdaptedObjects.containsKey(modelInstanceObject)) {
			result =
					(OclModelInstanceObject) cachedAdaptedObjects
							.get(modelInstanceObject);
		}

		else {
			// FIXME Michael: What to do with multiple types?
			result =
					new JavaOclModelInstanceObject(modelInstanceObject,
							modelInstanceObject.getTypes().iterator().next());

			/* Cache the adapted result. */
			this.cachedAdaptedObjects.put(modelInstanceObject, result);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclOrderedSet(java.util.List)
	 */
	public <T extends OclAny> OclOrderedSet<T> createOclOrderedSet(
			final List<?> elements, Type genericType) {

		List<IModelInstanceElement> imiElements;
		imiElements = new UniqueEList<IModelInstanceElement>();

		for (Object element : elements) {

			if (element instanceof IModelInstanceElement) {

				imiElements.add((IModelInstanceElement) element);
			}
			else if (element instanceof OclAny) {

				imiElements.add(((OclAny) element).getModelInstanceElement());
			}
			else {
				throw new IllegalArgumentException("Cannot create JavaOclSet for "
						+ elements);
			}
		}

		IModelInstanceCollection<IModelInstanceElement> imiCollection =
				basisJavaModelInstanceFactory.createModelInstanceCollection(
						imiElements, OclCollectionTypeKind.ORDEREDSET);

		return new JavaOclOrderedSet<T>(imiCollection, genericType);
	}

	public <T extends OclAny> OclOrderedSet<T> createOclOrderedSet(
			IModelInstanceCollection<IModelInstanceElement> elements, Type genericType) {

		OclOrderedSet<T> result;

		if (!elements.isOrdered() || !elements.isUnique()) {
			Collection<IModelInstanceElement> orderedSet =
					new UniqueEList<IModelInstanceElement>(elements.getCollection());

			IModelInstanceCollection<IModelInstanceElement> imiResult =
					basisJavaModelInstanceFactory.createModelInstanceCollection(
							orderedSet, OclCollectionTypeKind.ORDEREDSET);

			result = new JavaOclOrderedSet<T>(imiResult, genericType);
		}
		else {
			result = new JavaOclOrderedSet<T>(elements, genericType);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclReal(java.lang.Number)
	 */
	public OclReal createOclReal(final Number value) {

		IModelInstanceReal imiReal =
				BasisJavaModelInstanceFactory.createModelInstanceReal(value);

		return new JavaOclReal(imiReal);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclReal(tudresden.ocl20.pivot.modelbus.modelinstance
	 * .types.IModelInstanceReal)
	 */
	public OclReal createOclReal(final IModelInstanceReal value) {

		return new JavaOclReal(value);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclSequence(java.util.List)
	 */
	public <T extends OclAny> OclSequence<T> createOclSequence(
			final List<?> elements, Type genericType) {

		List<IModelInstanceElement> imiElements;
		imiElements = new ArrayList<IModelInstanceElement>();

		for (Object element : elements) {

			if (element instanceof IModelInstanceElement) {

				imiElements.add((IModelInstanceElement) element);
			}
			else if (element instanceof OclAny) {

				imiElements.add(((OclAny) element).getModelInstanceElement());
			}
			else {
				throw new IllegalArgumentException("Cannot create JavaOclSet for "
						+ elements);
			}
		}

		IModelInstanceCollection<IModelInstanceElement> imiCollection =
				basisJavaModelInstanceFactory.createModelInstanceCollection(
						imiElements, OclCollectionTypeKind.SEQUENCE);

		return new JavaOclSequence<T>(imiCollection, genericType);
	}

	public <T extends OclAny> OclSequence<T> createOclSequence(
			IModelInstanceCollection<IModelInstanceElement> elements, Type genericType) {

		OclSequence<T> result;

		if (!elements.isOrdered() || elements.isUnique()) {
			Collection<IModelInstanceElement> orderedSet =
					new ArrayList<IModelInstanceElement>(elements.getCollection());

			IModelInstanceCollection<IModelInstanceElement> imiResult =
					basisJavaModelInstanceFactory.createModelInstanceCollection(
							orderedSet, OclCollectionTypeKind.SEQUENCE);

			result = new JavaOclSequence<T>(imiResult, genericType);
		}
		else {
			result = new JavaOclSequence<T>(elements, genericType);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclSet(java.util.List)
	 */
	public <T extends OclAny> OclSet<T> createOclSet(final Set<?> elements,
			Type genericType) {

		Set<IModelInstanceElement> imiElements;
		imiElements = new HashSet<IModelInstanceElement>();

		for (Object element : elements) {

			if (element instanceof IModelInstanceElement) {

				imiElements.add((IModelInstanceElement) element);
			}
			else if (element instanceof OclAny) {

				imiElements.add(((OclAny) element).getModelInstanceElement());
			}
			else {
				throw new IllegalArgumentException("Cannot create JavaOclSet for "
						+ elements);
			}
		}

		IModelInstanceCollection<IModelInstanceElement> imiCollection =
				basisJavaModelInstanceFactory.createModelInstanceCollection(
						imiElements, OclCollectionTypeKind.SET);

		return new JavaOclSet<T>(imiCollection, genericType);
	}

	public <T extends OclAny> OclSet<T> createOclSet(
			IModelInstanceCollection<IModelInstanceElement> elements, Type genericType) {

		OclSet<T> result;

		if (!elements.isUnique() || elements.isOrdered()) {
			Collection<IModelInstanceElement> set =
					new HashSet<IModelInstanceElement>(elements.getCollection());

			IModelInstanceCollection<IModelInstanceElement> imiResult =
					basisJavaModelInstanceFactory.createModelInstanceCollection(set,
							OclCollectionTypeKind.SET);

			result = new JavaOclSet<T>(imiResult, genericType);
		}
		else {
			result = new JavaOclSet<T>(elements, genericType);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclString(java.lang.String)
	 */
	public OclString createOclString(final String value) {

		IModelInstanceString imiString =
				BasisJavaModelInstanceFactory.createModelInstanceString(value);

		return new JavaOclString(imiString);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclString(tudresden.ocl20.pivot.modelbus.modelinstance
	 * .types.IModelInstanceString)
	 */
	public OclString createOclString(final IModelInstanceString value) {

		return new JavaOclString(value);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory#createOclTuple(java.util.List, java.util.List)
	 */
	public OclTuple createOclTuple(final List<IModelInstanceString> names,
			final List<IModelInstanceElement> values, Type type) {

		OclTuple result;

		IModelInstanceTuple imiTuple =
				basisJavaModelInstanceFactory.createModelInstanceTuple(names, values,
						type);

		result = new JavaOclTuple(imiTuple);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclType(tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public <T extends OclAny> OclType<T> createOclType(final Type type) {

		OclType<T> result;

		result = new BaseOclType<T>() {

			/*
			 * (non-Javadoc)
			 * @see
			 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType#getType()
			 */
			public Type getType() {

				return type;
			}
		};

		return result;
	}

	// /*
	// * (non-Javadoc)
	// * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	// * IStandardLibraryFactory#createOclUndefined(java.lang.Class,
	// * java.lang.String)
	// */
	// @SuppressWarnings("unchecked")
	// public <T extends OclAny> T createOclUndefined(Class<T> clazz, String
	// reason) {
	//
	// Type type = getTypeFromOclAny(clazz);
	//
	// return (T) createOclUndefined(type, reason);
	// }

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclUndefined(tudresden.ocl20.pivot.pivotmodel.Type)
	 */
	public OclAny createOclUndefined(final Type type, final String reason) {

		OclAny result;

		result = null;

		/* Check if the given Type is a primitive type. */
		if (type instanceof PrimitiveType) {
			PrimitiveType primitiveType;
			PrimitiveTypeKind primitiveTypeKind;
			primitiveType = (PrimitiveType) type;
			primitiveTypeKind = primitiveType.getKind();

			if (primitiveTypeKind.equals(PrimitiveTypeKind.BOOLEAN)) {
				result = new JavaOclBoolean(reason);
			}

			else if (primitiveTypeKind.equals(PrimitiveTypeKind.INTEGER)) {
				result = new JavaOclInteger(reason);
			}

			else if (primitiveTypeKind.equals(PrimitiveTypeKind.REAL)) {
				result = new JavaOclReal(reason);
			}

			else if (primitiveTypeKind.equals(PrimitiveTypeKind.STRING)) {
				result = new JavaOclString(reason);
			}

			else if (primitiveTypeKind.equals(PrimitiveTypeKind.VOID)) {
				result = JavaOclVoid.INSTANCE;
			}

			/* unknown primitive type */
			else {
				throw new IllegalArgumentException("Primitive type " + type
						+ " is unknown.");
			}
		}

		/* collection type */
		else if (type instanceof CollectionType) {

			if (type instanceof BagType) {
				result =
						new JavaOclBag<OclAny>(reason, ((BagType) type).getElementType());
			}

			else if (type instanceof OrderedSetType) {
				result =
						new JavaOclOrderedSet<OclAny>(reason, ((OrderedSetType) type)
								.getElementType());
			}

			else if (type instanceof SequenceType) {
				result =
						new JavaOclSequence<OclAny>(reason, ((SequenceType) type)
								.getElementType());
			}

			else if (type instanceof SetType) {
				result =
						new JavaOclSet<OclAny>(reason, ((SetType) type).getElementType());
			}
		}

		/* Check if the given Type is an enumeration. */
		else if (type instanceof Enumeration) {
			result = new JavaOclEnumLiteral(reason);
		}

		/* If no result has been created yet, create a JavaOclObject. */
		if (result == null) {
			result = new JavaOclModelInstanceObject(reason, type);
		}

		/*
		 * Cache the result, so that createOclAny() can obtain the correct OclAny
		 * for an IModelInstanceElement.
		 */
		cachedUndefinedOrInvalid.put(result.getModelInstanceElement(), result);

		return result;
	}

	// /*
	// * (non-Javadoc)
	// * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	// * IStandardLibraryFactory#createOclInvalid(java.lang.Class,
	// * java.lang.Throwable)
	// */
	// @SuppressWarnings("unchecked")
	// public <T extends OclAny> T createOclInvalid(Class<T> clazz,
	// Throwable invalidReason) {
	//
	// Type type = getTypeFromOclAny(clazz);
	//
	// return (T) createOclInvalid(type, invalidReason);
	// }

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.factory.
	 * IStandardLibraryFactory
	 * #createOclInvalid(tudresden.ocl20.pivot.pivotmodel.Type,
	 * java.lang.Throwable)
	 */
	@SuppressWarnings("unchecked")
	public <T extends OclAny> T createOclInvalid(final Type type,
			final Throwable invalidReason) {

		T result;

		result = null;

		if (type instanceof AnyType)
			result = (T) new JavaOclAny(invalidReason) {

				public OclBoolean isEqualTo(OclAny object2) {

					OclBoolean result = null;

					// same semantics as for OclInvalid
					if (object2 instanceof OclInvalid
							|| object2.getInvalidReason() != null)
						result = JavaOclBoolean.getInstance(true);
					else
						result = JavaOclBoolean.getInstance(false);

					return result;
				}

				public <T2 extends OclAny> OclSet<T2> asSet() {

					return createOclInvalid(TypeConstants.SET(type), invalidReason);
				}
			};

		// if (type == null)
		// result = (T) new JavaOclModelInstanceObject(invalidReason, type);

		else {

			/* Check if the given Type is a primitive type. */
			if (type instanceof PrimitiveType) {
				PrimitiveType primitiveType;
				PrimitiveTypeKind primitiveTypeKind;
				primitiveType = (PrimitiveType) type;
				primitiveTypeKind = primitiveType.getKind();

				if (primitiveTypeKind.equals(PrimitiveTypeKind.BOOLEAN)) {
					result = (T) new JavaOclBoolean(invalidReason);
				}

				else if (primitiveTypeKind.equals(PrimitiveTypeKind.INTEGER)) {
					result = (T) new JavaOclInteger(invalidReason);
				}

				else if (primitiveTypeKind.equals(PrimitiveTypeKind.REAL)) {
					result = (T) new JavaOclReal(invalidReason);
				}

				else if (primitiveTypeKind.equals(PrimitiveTypeKind.STRING)) {
					result = (T) new JavaOclString(invalidReason);
				}

				else if (primitiveTypeKind.equals(PrimitiveTypeKind.VOID)) {
					result = (T) new JavaOclVoid(invalidReason);
				}

				else {
					throw new IllegalArgumentException("Primitive type " + type
							+ " is unknown.");
				}
			}

			/* collection type */
			else if (type instanceof CollectionType) {

				CollectionType collectionType;
				collectionType = (CollectionType) type;

				switch (collectionType.getKind()) {
				case ORDERED_SET:
					result =
							(T) new JavaOclOrderedSet<OclAny>(invalidReason, collectionType
									.getElementType());
					break;

				case SEQUENCE:
					result =
							(T) new JavaOclSequence<OclAny>(invalidReason, collectionType
									.getElementType());
					break;

				case SET:
					result =
							(T) new JavaOclSet<OclAny>(invalidReason, collectionType
									.getElementType());
					break;

				/* Bag is the most general collection type. */
				case BAG:
				default:
					result =
							(T) new JavaOclBag<OclAny>(invalidReason, collectionType
									.getElementType());
					break;
				}
				// end switch.
			}

			/* Check if the given Type is an enumeration. */
			else if (type instanceof Enumeration) {
				result = (T) new JavaOclEnumLiteral(invalidReason);
			}

			/* If no result has been created yet, create a JavaOclObject. */
			if (result == null) {
				result = (T) new JavaOclModelInstanceObject(invalidReason, type);
			}
		}

		/*
		 * Cache the result, so that createOclAny() can obtain the correct OclAny
		 * for an IModelInstanceElement.
		 */
		cachedUndefinedOrInvalid.put(result.getModelInstanceElement(), result);

		return result;
	}

	/**
	 * TODO: Probably extract this type impl into its own class since today it has
	 * several methods.
	 */
	private abstract class BaseOclType<U extends OclAny> implements OclType<U> {

		/*
		 * (non-Javadoc)
		 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#asSet()
		 */
		public <T extends OclAny> OclSet<T> asSet() {

			return createOclInvalid(TypeConstants.SET(TypesFactory.INSTANCE
					.createTypeType()), new UnsupportedOperationException(
					"Cannot invoke operation asSet() on meta-type OclType."));
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#getUndefinedreason
		 * ()
		 */
		public String getUndefinedReason() {

			return null;
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#invokeOperation
		 * (tudresden.ocl20.pivot.pivotmodel.Operation,
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny[])
		 */
		public OclAny invokeOperation(Operation operation, OclAny... parameters) {

			return createOclInvalid(
					operation.getType(),
					new UnsupportedOperationException(
							"invokeOperation(Operation operation, OclAny... parameters) is not supported on meta-type OclType"));
		}

		/**
		 * Overridden to allow equality tests on OclTypes.
		 */
		public OclBoolean isEqualTo(OclType<OclAny> type2) {

			return createOclBoolean(this.getType().equals(type2.getType()));
		}

		/**
		 * Overridden to allow equality tests on OclTypes.
		 */
		public OclBoolean isNotEqualTo(OclType<OclAny> type2) {

			return isEqualTo(type2).not();
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#oclIsUndefined
		 * ()
		 */
		public OclBoolean oclIsUndefined() {

			return JavaOclBoolean.getInstance(false);
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#oclAsType(tudresden
		 * .ocl20.pivot.essentialocl.standardlibrary.OclType)
		 */
		public <T extends OclAny> T oclAsType(OclType<T> type) {

			return createOclInvalid(
					type.getType(),
					new UnsupportedOperationException(
							"oclAsType(OclType<T> type) is not supported on meta-type OclType"));
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#oclIsInvalid()
		 */
		public OclBoolean oclIsInvalid() {

			return JavaOclBoolean.getInstance(false);
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#oclIsKindOf
		 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType)
		 */
		public <T extends OclAny> OclBoolean oclIsKindOf(OclType<T> typespec) {

			return createOclInvalid(
					TypeConstants.BOOLEAN,
					new UnsupportedOperationException(
							"oclIsKindOf(OclType<T> typespec) is not supported on meta-type OclType"));
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#oclIsTypeOf
		 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType)
		 */
		public <T extends OclAny> OclBoolean oclIsTypeOf(OclType<T> typespec) {

			return createOclInvalid(
					TypeConstants.BOOLEAN,
					new UnsupportedOperationException(
							"oclIsTypeOf(OclType<T> typespec) is not supported on meta-type OclType"));
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#isEqualTo(tudresden
		 * .ocl20.pivot.essentialocl.standardlibrary.OclAny)
		 */
		public OclBoolean isEqualTo(OclAny object2) {

			return createOclInvalid(
					TypeConstants.BOOLEAN,
					new UnsupportedOperationException(
							"isEqualTo(OclAny object2) is not supported on meta-type OclType"));
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#isNotEqualTo
		 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
		 */
		public OclBoolean isNotEqualTo(OclAny object2) {

			return createOclInvalid(
					TypeConstants.BOOLEAN,
					new UnsupportedOperationException(
							"isNotEqualTo(OclAny object2) is not supported on meta-type OclType"));
		}

		/*
		 * (non-Javadoc)
		 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#
		 * getModelInstanceElement()
		 */
		public IModelInstanceElement getModelInstanceElement() {

			throw new UnsupportedOperationException(
					"getModelInstanceElement() is not supported on meta-type OclType");
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#getInvalidReason
		 * ()
		 */
		public Throwable getInvalidReason() {

			return null;
		}

		/*
		 * (non-Javadoc)
		 * @see
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType#getStaticProperty
		 * (tudresden.ocl20.pivot.pivotmodel.Property)
		 */
		public OclAny getStaticProperty(Property property,
				IModelInstance modelInstance) {

			OclAny result;
			IModelInstanceElement imiResult;

			try {
				imiResult = modelInstance.getStaticProperty(property);

				result = createOclAny(imiResult);
			}

			/* Probably result in invalid. */
			catch (PropertyAccessException e) {
				result = createOclInvalid(property.getType(), e);
			}

			catch (PropertyNotFoundException e) {
				result = createOclInvalid(property.getType(), e);
			}

			return result;
		}

		/*
		 * (non-Javadoc)
		 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclType#
		 * invokeStaticOperation(tudresden.ocl20.pivot.pivotmodel.Operation,
		 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny[])
		 */
		public OclAny invokeStaticOperation(Operation operation,
				OclAny[] oclAnyParameters, IModelInstance modelInstance) {

			OclAny result;
			IModelInstanceElement imiResult;

			/* Handle the special static operation allInstances. */
			if (operation.getName().equals("allInstances")) {

				imiResult =
						BasisJavaModelInstanceFactory.createModelInstanceCollection(
								modelInstance.getAllInstances(((CollectionType) operation
										.getType()).getElementType()), TypeConstants.SET);

				result = createOclAny(imiResult);
			}

			else {
				List<IModelInstanceElement> imiParameters;

				/* Adapt the parameters. */
				imiParameters =
						new ArrayList<IModelInstanceElement>(oclAnyParameters.length);

				for (int index = 0; index < oclAnyParameters.length; index++) {
					imiParameters.add(oclAnyParameters[index].getModelInstanceElement());
				}
				// end for.

				try {
					imiResult =
							modelInstance.invokeStaticOperation(operation, imiParameters);
					result = createOclAny(imiResult);
				}

				/* Probably result in invalid. */
				catch (OperationAccessException e) {

					result = createOclInvalid(operation.getType(), e);
				}

				catch (OperationNotFoundException e) {

					result = createOclInvalid(operation.getType(), e);
				}
				// end catch.
			}
			// end else.

			return result;
		}
	}
}