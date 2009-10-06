/*
Copyright (C) 2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Model Bus Plug-in of Dresden OCL2 for Eclipse.

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
package tudresden.ocl20.pivot.modelbus.modelinstance.types.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.osgi.util.NLS;

import tudresden.ocl20.pivot.essentialocl.expressions.CollectionKind;
import tudresden.ocl20.pivot.essentialocl.types.CollectionType;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.modelbus.internal.ModelBusMessages;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.AsTypeCastException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * Implements the interface {@link IModelInstanceCollection} for
 * {@link JavaModelInstance} {@link Collection}s.
 * </p>
 * 
 * <p>
 * This type is located in the ModelBus plug-in because the standard library and
 * the Java model instance type plug-in both require such an implementation but
 * are not allowed to know each other.
 * </p>
 * 
 * @author Claas Wilke
 */
public class JavaModelInstanceCollection<T extends IModelInstanceElement>
		extends AbstractModelInstanceElement implements IModelInstanceCollection<T> {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER =
			ModelBusPlugin.getLogger(JavaModelInstanceCollection.class);

	/**
	 * The {@link Object}s contained in this {@link JavaModelInstanceCollection}.
	 */
	private Collection<T> myContainedObjects;

	/**
	 * <p>
	 * Creates a new {@link JavaModelInstanceCollection}.
	 * </p>
	 * 
	 * @param containedObjects
	 *          The {@link Object}s contained in this
	 *          {@link JavaModelInstanceCollection}.
	 */
	protected JavaModelInstanceCollection(Collection<T> containedObjects) {

		/* Eventually debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceCollection("; //$NON-NLS-1$
			msg += "containedObjects = " + containedObjects; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.initialize(containedObjects);

		/* Check if a List or set is given. */
		if (containedObjects instanceof Set<?>) {

			this.myTypes.add(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SET);
		}

		else {

			this.myTypes.add(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_BAG);
		}

		/* Eventually debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceCollection(Collection<?>) - exit"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.
	}

	/**
	 * <p>
	 * Creates a new {@link JavaModelInstanceCollection}.
	 * </p>
	 * 
	 * @param containedObjects
	 *          The {@link Object}s contained in this
	 *          {@link JavaModelInstanceCollection}.
	 * @param type
	 *          The {@link CollectionType} that the created
	 *          {@link JavaModelInstanceCollection} should have.
	 */
	protected JavaModelInstanceCollection(Collection<T> containedObjects,
			CollectionType type) {

		this.initialize(containedObjects);

		/* Check if sets have the right type of collection. */
		if (type.getKind().equals(CollectionKind.SET)
				&& !(this.myContainedObjects instanceof Set)) {
			this.myContainedObjects = new HashSet<T>(this.myContainedObjects);
		}

		else if (type.getKind().equals(CollectionKind.ORDERED_SET)
				&& !(this.myContainedObjects instanceof UniqueEList)) {
			this.myContainedObjects = new UniqueEList<T>(this.myContainedObjects);
		}
		// no else.

		this.myTypes.add(type);
	}

	/**
	 * <p>
	 * A helper method that contains the common initialization of all constructors
	 * of {@link JavaModelInstanceCollection}.
	 * </p>
	 * 
	 * @param containedObjects
	 *          The {@link Object}s contained in this
	 *          {@link JavaModelInstanceCollection}.
	 */
	private void initialize(Collection<T> containedObjects) {

		this.myContainedObjects = containedObjects;
		this.myTypes = new HashSet<Type>();
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.modelinstance.types.impl.
	 * AbstractModelInstanceElement#getName()
	 */
	public String getName() {

		StringBuffer resultBuffer;
		resultBuffer = new StringBuffer();

		/* Probably return the element's name. */
		if (this.myName != null) {
			resultBuffer.append(this.myName);
		}

		/* Else probably return the element's id. */
		else if (this.myId != null) {
			resultBuffer.append(this.myId);
		}

		/* Else construct a name of all implemented types. */
		else {
			resultBuffer.append(JavaModelInstanceCollection.class.getSimpleName());
			resultBuffer.append("[");
			resultBuffer.append("types = " + this.getTypes() + ", ");
			resultBuffer.append("content = " + this.myContainedObjects.toString());
			resultBuffer.append("]");
		}
		// end else.

		return resultBuffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #asType(tudresden.ocl20.pivot.pivotmodel.Type)
	 */
	public IModelInstanceElement asType(Type type) throws AsTypeCastException {

		IModelInstanceElement result;

		/* By default, the result is undefined. */
		result = null;

		/* Collections can only be casted to collections. */
		if (type instanceof CollectionType) {

			Collection<T> adaptedCollection;
			CollectionType collectionType;
			collectionType = (CollectionType) type;

			switch (collectionType.getKind()) {

			case BAG:

				/* Create a new List to avoid side effects. */
				adaptedCollection = new ArrayList<T>(this.myContainedObjects);

				result = new JavaModelInstanceCollection<T>(adaptedCollection,

				PrimitiveAndCollectionTypeConstants.MODEL_TYPE_BAG);
				break;

			case SEQUENCE:

				/* Create a new List to avoid side effects. */
				adaptedCollection = new ArrayList<T>(this.myContainedObjects);

				result = new JavaModelInstanceCollection<T>(adaptedCollection,

				PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SEQUENCE);
				break;

			case SET:

				/* Create a new Set to avoid side effects. */
				adaptedCollection = new HashSet<T>(this.myContainedObjects);

				result = new JavaModelInstanceCollection<T>(adaptedCollection,

				PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SET);
				break;

			case ORDERED_SET:

				/* Create a new List to avoid side effects. */
				adaptedCollection = new UniqueEList<T>(this.myContainedObjects);

				result = new JavaModelInstanceCollection<T>(adaptedCollection,

				PrimitiveAndCollectionTypeConstants.MODEL_TYPE_ORDERED_SET);
				break;

			default:

				/*
				 * Else create the most common type of collection that is possible
				 * (Decide on the given java collection).
				 */
				/* Create a new List to avoid side effects. */
				adaptedCollection = new ArrayList<T>(this.myContainedObjects);

				result = new JavaModelInstanceCollection<T>(adaptedCollection);
				break;
			}
			// end switch.
		}
		// no else.

		/* Probably throw an AsTypeCastException. */
		if (result == null) {
			String msg;

			msg = ModelBusMessages.IModelInstanceElement_CannotCast;
			msg = NLS.bind(msg, this.getName(), type.getName());

			throw new AsTypeCastException(msg);
		}
		// no else.

		return result;
	}

	/*
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #copyForAtPre()
	 */
	public IModelInstanceElement copyForAtPre() {

		/* For a collection, normally only the collection will be copied. */
		return new JavaModelInstanceCollection<T>(this.myContainedObjects, this
				.getTypes().toArray(new CollectionType[0])[0]);
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.modelinstance.types.base.
	 * AbstractModelInstanceElement#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
	
		boolean result;
	
		if (object == null) {
			result = false;
		}
	
		else if (this == object) {
			result = true;
		}
	
		if (object instanceof JavaModelInstanceCollection) {
	
			JavaModelInstanceCollection<?> other;
			other = (JavaModelInstanceCollection<?>) object;
	
			/* This should not happen. But anyway, null == null results in false. */
			if (this.isUndefined() || other.isUndefined()) {
				result = false;
			}
	
			else {
				result = true;
	
				/* Check if both collections are ordered. */
				result &= this.isOrdered() == other.isOrdered();
	
				/* Check if both collections are unique. */
				result &= this.isUnique() == other.isUnique();
	
				/* Check if both collections have the same type(s). */
				result &= this.getTypes().equals(other.getTypes());
	
				/* Check if both collections have the same elements. */
				result &= this.getCollection().equals(other.getCollection());
			}
		}
	
		else {
			result = false;
		}
	
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection
	 * #getCollection()
	 */
	public Collection<T> getCollection() {

		return this.myContainedObjects;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.modelinstance.types.base.
	 * AbstractModelInstanceElement#hashCode()
	 */
	@Override
	public int hashCode() {

		int result;
		int prime = 31;

		result = 0;

		if (this.isOrdered()) {
			result += 1231;
		}

		else {
			result += 1237;
		}

		if (this.isUnique()) {
			result = prime * result + 1231;
		}

		else {
			result = prime * result + 1237;
		}

		if (this.myContainedObjects == null) {
			result = prime * result;
		}

		else {
			result = prime * result + this.myContainedObjects.hashCode();
		}

		if (this.myTypes == null) {
			result = prime * result;
		}

		else {
			result = prime * result + this.myTypes.hashCode();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.modelinstance.types.base.
	 * AbstractModelInstanceElement#hashCode()
	 */
	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection
	 * #isOrdered()
	 */
	public boolean isOrdered() {

		boolean result;

		/* Only ordered sets and sequences are ordered. */
		if (this
				.isKindOf(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_ORDERED_SET)
				|| this
						.isKindOf(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SEQUENCE)) {
			result = true;
		}

		else {
			result = false;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #isUndefined()
	 */
	public boolean isUndefined() {

		return (this.myContainedObjects == null);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceCollection
	 * #isUnique()
	 */
	public boolean isUnique() {

		boolean result;

		/* Only ordered sets and sets are unique. */
		if (this
				.isKindOf(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_ORDERED_SET)
				|| this
						.isKindOf(PrimitiveAndCollectionTypeConstants.MODEL_TYPE_SET)) {
			result = true;
		}

		else {
			result = false;
		}

		return result;
	}
}