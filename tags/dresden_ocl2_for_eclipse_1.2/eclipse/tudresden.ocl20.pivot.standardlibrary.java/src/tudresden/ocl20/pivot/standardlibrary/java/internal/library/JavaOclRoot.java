/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Ronny Brandt (Ronny_Brandt@web.de).                    *
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
 */
package tudresden.ocl20.pivot.standardlibrary.java.internal.library;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Platform;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBag;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclEnumLiteral;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclEnumType;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclInteger;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclOrderedSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclReal;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSequence;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclString;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclVoid;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.base.AbstractOclAdapter;

/**
 * <p>
 * Represents any OclType in the Java standard library.
 * </p>
 * 
 * @author Ronny Brandt
 */
public class JavaOclRoot extends AbstractOclAdapter implements OclRoot {

	/** The reason why this Object is undefined - if it is. */
	protected String undefinedreason = null;

	/**
	 * <p>
	 * Instantiates a new {@link JavaOclRoot}.
	 * </p>
	 * 
	 * @param adaptee
	 *            The adapted model instance object of this {@link JavaOclRoot}.
	 */
	public JavaOclRoot(Object adaptee) {
		super(adaptee);
	}

	/**
	 * <p>
	 * Returns allInstances() of this type of {@link JavaOclRoot}.
	 * </p>
	 * 
	 * <p>
	 * <strong>Must be implemented by sub types or will return null!</strong>
	 * </p>
	 * 
	 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#allInstances()
	 */
	public <T extends OclRoot> OclSet<T> allInstances() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#asSet()
	 */
	@SuppressWarnings("unchecked")
	public <T extends OclRoot> OclSet<T> asSet() {

		OclSet<T> result;
		Set<T> adaptedSet;

		adaptedSet = new HashSet<T>(Arrays.asList((T) this));
		result = new JavaOclSet<T>(adaptedSet);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#getType()
	 */
	public OclType getType() {
		/* Must be implemented by concrete sub classes. */
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#getPropertyValue
	 * (java.lang.String)
	 */
	public OclRoot getPropertyValue(String propertyName)
			throws NoSuchFieldException, IllegalAccessException {

		OclRoot result;
		Field field;

		Class<?> adaptedClass;
		Object adaptedObject;

		field = null;

		adaptedClass = null;
		adaptedObject = null;

		/* Static fields do not have an adapted class. */
		if (this.getAdaptee() instanceof Class) {
			adaptedClass = (Class<?>) this.getAdaptee();
			adaptedObject = null;
		}

		else {
			adaptedClass = this.getAdapteeClass();
			adaptedObject = this.getAdaptee();
		}

		/*
		 * Iterate through the class and its super classes and try to the the
		 * referred property.
		 */
		while (adaptedClass != null && field == null) {

			try {
				field = adaptedClass.getDeclaredField(propertyName);
			}

			catch (NoSuchFieldException e) {
				try {
					/* Special treatment for ArgoUML generated code. */
					field = adaptedClass.getDeclaredField("my"
							+ StringUtils.capitalize(propertyName));
				} catch (NoSuchFieldException e2) {
					// Do nothing.
				}
			}

			finally {
				/* Try to find the field again in super class. */
				adaptedClass = adaptedClass.getSuperclass();
			}
		}
		// end while.

		/* Else try to read the property from the standard library. */
		if (field == null) {
			adaptedClass = this.getClass();
			adaptedObject = this;

			while (adaptedClass != null && field == null) {
				try {
					field = adaptedClass.getDeclaredField(propertyName);
				} catch (NoSuchFieldException e) {
					// Do nothing
				} finally {
					adaptedClass = adaptedClass.getSuperclass();
				}
			}
		}
		// no else.

		/* Else try a special treatment for EMF generated code. */
		if (field == null) {
			try {
				result = invokeOperation("get"
						+ StringUtils.capitalize(propertyName), new OclRoot[0]);
			}

			catch (NoSuchMethodException e) {
				// Do nothing.
			}
		}
		// no else.

		if (field == null) {
			String msg;

			msg = "The field " + propertyName + " could not be found.";

			throw new NoSuchFieldException(msg);
		}
		// no else.

		else {
			Object property;

			property = null;
			field.setAccessible(true);

			/* Try to get the field's value. */
			try {
				property = field.get(adaptedObject);
			}

			catch (IllegalArgumentException e) {
				e.printStackTrace();
			}

			result = this.adaptProperty(property);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#getPropertyValue
	 * (java.lang.String,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot[])
	 */
	public OclRoot getPropertyValue(String propertyName, OclRoot... qualifier) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#
	 * getPropertyValueAsBag(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public OclBag<OclRoot> getPropertyValueAsBag(String propertyName)
			throws NoSuchFieldException, IllegalAccessException {

		OclBag<OclRoot> result;

		OclRoot property;
		Object adaptedPropery;

		/* Get the property as OclRoot. */
		property = getPropertyValue(propertyName);
		adaptedPropery = property.getAdaptee();

		/* Adapt to an OclOrderedSet. */
		List<OclRoot> internalList;

		if (adaptedPropery instanceof Collection) {
			internalList = new ArrayList<OclRoot>(
					(Collection<OclRoot>) adaptedPropery);
		}

		else {
			internalList = new ArrayList<OclRoot>();

			if (!(property instanceof OclVoid)) {
				internalList.add(property);
			}
			// no else
		}

		result = new JavaOclBag<OclRoot>(internalList);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#
	 * getPropertyValueAsOrderedSet(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public OclOrderedSet<OclRoot> getPropertyValueAsOrderedSet(
			String propertyName) throws NoSuchFieldException,
			IllegalAccessException {

		OclOrderedSet<OclRoot> result;

		OclRoot property;
		Object adaptedPropery;

		/* Get the property as OclRoot. */
		property = getPropertyValue(propertyName);
		adaptedPropery = property.getAdaptee();

		/* Adapt to an OclOrderedSet. */
		List<OclRoot> internalList;

		if (adaptedPropery instanceof Collection) {
			internalList = new ArrayList<OclRoot>(
					(Collection<OclRoot>) adaptedPropery);
		}

		else {
			internalList = new ArrayList<OclRoot>();

			if (!(property instanceof OclVoid)) {
				internalList.add(property);
			}
			// no else
		}

		result = new JavaOclOrderedSet<OclRoot>(internalList);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#
	 * getPropertyValueAsSequence(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public OclSequence<OclRoot> getPropertyValueAsSequence(String propertyName)
			throws NoSuchFieldException, IllegalAccessException {

		OclSequence<OclRoot> result;

		OclRoot property;
		Object adaptedPropery;

		/* Get the property as OclRoot. */
		property = getPropertyValue(propertyName);
		adaptedPropery = property.getAdaptee();

		/* Adapt to an OclOrderedSet. */
		List<OclRoot> internalList;

		if (adaptedPropery instanceof Collection) {
			internalList = new ArrayList<OclRoot>(
					(Collection<OclRoot>) adaptedPropery);
		}

		else {
			internalList = new ArrayList<OclRoot>();

			if (!(property instanceof OclVoid)) {
				internalList.add(property);
			}
			// no else
		}

		result = new JavaOclSequence<OclRoot>(internalList);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#
	 * getPropertyValueAsSet(java.lang.String)
	 */
	public OclSet<OclRoot> getPropertyValueAsSet(String propertyName)
			throws NoSuchFieldException, IllegalAccessException {

		OclSet<OclRoot> result;

		OclRoot property;

		property = getPropertyValue(propertyName);
		result = property.asSet();

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#getUndefinedreason
	 * ()
	 */
	public String getUndefinedreason() {
		return undefinedreason;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#invokeOperation
	 * (java.lang.String,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot[])
	 */
	public OclRoot invokeOperation(String operationName, OclRoot... parameters)
			throws NoSuchMethodException {

		OclRoot result;

		try {
			/* Try to invoke a model operation. */
			result = invokeModelOperation(operationName, parameters);
		}

		catch (NoSuchMethodException e) {
			/* Else try to invoke a library operation. */
			result = invokeLibraryOperation(operationName, parameters);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#isEqualTo(
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public OclBoolean isEqualTo(OclRoot anOclRoot) {

		OclBoolean result;

		/* Check if this OclRoot is undefined. */
		if (isOclUndefined().isTrue()) {
			result = JavaOclBoolean.getInstance(null);
			result.setUndefinedreason(getUndefinedreason());
		}

		/* Else check if the given oclRoot is undefined. */
		else if (anOclRoot.isOclUndefined().isTrue()) {
			result = JavaOclBoolean.getInstance(null);
			result.setUndefinedreason(anOclRoot.getUndefinedreason());
		}

		/* Else compute the result. */
		else {
			Object thisAdaptee;
			Object anAdaptee;

			thisAdaptee = this.getAdaptee();
			anAdaptee = anOclRoot.getAdaptee();

			result = JavaOclBoolean.getInstance(thisAdaptee.equals(anAdaptee));
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#isNotEqualTo
	 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public OclBoolean isNotEqualTo(OclRoot object2) {
		return isEqualTo(object2).not();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#isOclUndefined
	 * ()
	 */
	public OclBoolean isOclUndefined() {
		return JavaOclBoolean.getInstance(this.undefinedreason != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#oclAsType(
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType)
	 */
	@SuppressWarnings("unchecked")
	public OclRoot oclAsType(OclType typespec) {
		return typespec.createInstance(this);
	}

	// has to be overwritten in OclInvalid
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#oclIsInvalid()
	 */
	public OclBoolean oclIsInvalid() {
		return JavaOclBoolean.getInstance(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#oclIsNew()
	 */
	public OclBoolean oclIsNew() {
		/*
		 * The interpretation is done via interpreter. Thus this method returns
		 * null.
		 */

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#oclIsKindOf
	 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType)
	 */
	public OclBoolean oclIsKindOf(OclType typespec) {

		OclBoolean result;

		/* Check if this oclRoot is undefined. */
		if (isOclUndefined().isTrue()) {
			result = JavaOclBoolean.getInstance(null);
			result.setUndefinedreason(getUndefinedreason());

		}

		/* Else compute the result. */
		else {
			result = JavaOclBoolean.getInstance(typespec.isOfKind(this)
					.isTrue());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#oclIsTypeOf
	 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclType)
	 */
	public OclBoolean oclIsTypeOf(OclType aType) {

		OclBoolean result;

		/* Check if this oclRoot is undefined. */
		if (this.isOclUndefined().isTrue()) {
			result = JavaOclBoolean.getInstance(null);
			result.setUndefinedreason(getUndefinedreason());
		}

		/* Else check if the given type is the expected type. */
		else {
			result = aType.isOfType(this);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot#setUndefinedreason
	 * (java.lang.String)
	 */
	public void setUndefinedreason(String undefinedreason) {
		this.undefinedreason = undefinedreason;
	}

	/**
	 * <p>
	 * Adapts a given model instance property (as {@link Object}) to an
	 * {@link OclRoot}.
	 * </p>
	 * 
	 * @param property
	 *            The property which shall be adapted.
	 * @return The adapted property.
	 */
	protected OclRoot adaptProperty(Object property) {

		OclRoot result;

		if (property == null) {
			result = JavaOclVoid.getInstance();
		}

		else if (property instanceof Integer) {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					property, OclInteger.class);
		}

		else if (property instanceof Float) {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					property, OclReal.class);
		}

		else if (property instanceof Boolean) {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					property, OclBoolean.class);
		}

		else if (property instanceof String) {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					property, OclString.class);
		}

		else if (property.getClass().isEnum()) {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					property, OclEnumLiteral.class);
		}

		/*
		 * If the property is a collection, each element must be adapted for
		 * itself.
		 */
		else if (property instanceof Collection) {

			Collection<?> aCollection;
			List<OclRoot> propertyList;

			aCollection = (Collection<?>) property;
			propertyList = new ArrayList<OclRoot>();

			for (Object anElement : aCollection) {

				OclRoot adaptedElement;

				/* Adapt anElement to OclRoot. */
				adaptedElement = this.adaptProperty(anElement);

				propertyList.add(adaptedElement);
			}

			result = new JavaOclBag<OclRoot>(propertyList);
		}

		else if (property instanceof OclRoot) {
			result = (OclRoot) property;
		}

		else {
			result = new JavaOclObject(property);
		}

		return result;
	}

	/**
	 * <p>
	 * Tries to find a method with a given name and a given array of
	 * parameterTypes.
	 * </p>
	 * 
	 * @param methodName
	 *            The name of the method to search for.
	 * @param sourceType
	 *            The source type on which the operation shall be invoked.
	 * @param parameterTypes
	 *            An Array representing the number and types of parameters to
	 *            look for in the method's signature. A null array is treated as
	 *            a zero-length array.
	 * @param isModelMethod
	 *            Specifies whether or not the method which shall be found is an
	 *            OCL defined method or a model defined method.
	 * @return Method object satisfying the given conditions.
	 * @throws NoSuchMethodException
	 *             Thrown if no methods match the criteria, or if the reflective
	 *             call is ambiguous based on the parameter types, or if
	 *             methodName is null.
	 */
	protected Method findMethod(String methodName, Class<?> sourceType,
			Class<?>[] parameterTypes, boolean isModelMethod)
			throws NoSuchMethodException {

		Method result;
		Method[] allMethods;

		try {

			if (isModelMethod) {
				allMethods = sourceType.getMethods();
			}

			else {
				allMethods = sourceType.getMethods();
			}
		}

		catch (SecurityException e) {
			e.printStackTrace();

			throw new NoSuchMethodException(e.getMessage());
		}

		result = null;

		if (parameterTypes == null) {
			parameterTypes = new Class<?>[0];
		}
		// no else.

		/* Iterate through all methods. */
		for (int index = 0; index < allMethods.length; index++) {

			/* Check if the name match. */
			if (allMethods[index].getName().equals(methodName)) {

				/* Check if the parameters match. */
				Class<?>[] aMethodsParams;
				aMethodsParams = allMethods[index].getParameterTypes();

				/* Check the count of parameters. */
				if (aMethodsParams.length == parameterTypes.length) {

					boolean isConform;

					isConform = true;

					/* Check the conformance of all parameters. */
					for (int index2 = 0; index2 < aMethodsParams.length; index2++) {

						if (!aMethodsParams[index2]
								.isAssignableFrom(parameterTypes[index2])) {
							isConform = false;
							break;
						}
						// no else.
					}

					if (isConform) {
						result = allMethods[index];
						break;
					}
				}
				// no else.
			}
			// no else.
		}

		if (result == null) {
			String msg;

			msg = "No method " + methodName + "(";

			for (int index = 0; index < parameterTypes.length; index++) {
				msg += parameterTypes[index];

				if (index > 0) {
					msg += ", ";
				}
				// no else.
			}

			msg += ") found.";

			throw new NoSuchMethodException(msg);
		}

		return result;
	}

	/**
	 * <p>
	 * Tries to invoke a library operation of a given operationName and an array
	 * of parameters.
	 * </p>
	 * 
	 * @param operationName
	 *            The operation name which shall be invoked.
	 * @param parameters
	 *            The {@link OclRoot} parameters of the operation which shall be
	 *            invoked.
	 * 
	 * @return The result of the invoked operations as an {@link OclRoot}.
	 * 
	 * @throws NoSuchMethodException
	 *             Thrown if the method can not be found.
	 */
	public OclRoot invokeLibraryOperation(String operationName,
			OclRoot... parameters) throws NoSuchMethodException {

		OclRoot result;
		Method method = null;

		Class<?> paramTypes[];
		Object paramValues[];

		Class<?> sourceType;
		Object operationInstance;

		Object invokedOperation;

		result = null;
		method = null;

		sourceType = null;
		operationInstance = null;

		/* Eventually initialize the parameter arrays. */
		if (parameters.length == 0) {
			paramTypes = new Class[0];
			paramValues = new Object[0];
		}

		else {
			paramTypes = new Class[parameters.length];
			paramValues = new Object[parameters.length];
		}

		/* Try to find the operation. */
		try {

			List<OclRoot> parameterList;

			int index;

			sourceType = this.getClass();

			parameterList = Arrays.asList(parameters);
			index = 0;

			/* Iterate over the parameters and initialize the arrays. */
			for (OclRoot aParameter : parameterList) {
				paramTypes[index] = aParameter.getClass();
				paramValues[index] = aParameter;
				index++;
			}

			method = this.findMethod(operationName, sourceType, paramTypes,
					false);

			operationInstance = this;
		}

		catch (SecurityException e) {
			e.printStackTrace();
		}

		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		invokedOperation = null;

		/* Enable access to the found method. */
		method.setAccessible(true);

		/* Try to invoke the operation. */
		try {
			Object castedSource;

			castedSource = sourceType.cast(operationInstance);

			invokedOperation = method.invoke(castedSource, paramValues);
		}

		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		/* Eventually cast result to OclRoot. */
		if (invokedOperation instanceof OclRoot) {
			result = (OclRoot) invokedOperation;
		}

		/* Eventually return void. */
		else if (invokedOperation == null) {
			result = JavaOclVoid.getInstance();
		}

		/* Eventually adapt the result to OclRoot. */
		else {
			result = (OclRoot) Platform.getAdapterManager().getAdapter(
					invokedOperation, OclRoot.class);
		}

		return result;
	}

	/**
	 * <p>
	 * Invokes an operation defined in the model.
	 * </p>
	 * 
	 * @param operationName
	 *            The name of the operation which shall be invoked.
	 * @param parameters
	 *            The parameters of the operation which shall be invoked.
	 * @return The result of the operation call as an {@link OclRoot}.
	 * 
	 * @throws NoSuchMethodException
	 *             Thrown if the given method can not be found.
	 */
	protected OclRoot invokeModelOperation(String operationName,
			OclRoot... parameters) throws NoSuchMethodException {

		OclRoot result;
		Method method;

		Class<?> paramTypes[];
		Object paramValues[];

		Class<?> sourceType;
		Object sourceInstance;

		Object adaptedResult;

		method = null;

		/* Eventually initialize the parameter arrays. */
		if (parameters.length == 0) {
			paramTypes = null;
			paramValues = null;
		}

		else {
			paramTypes = new Class[parameters.length];
			paramValues = new Object[parameters.length];
		}

		result = null;

		sourceType = null;
		sourceInstance = null;

		/* Try to find a method to invoke. */
		try {

			List<OclRoot> parameterList;

			int index;

			/* Handle static operations. */
			if (getAdaptee() instanceof Class) {
				sourceType = (Class<?>) getAdaptee();
				sourceInstance = null;
			}

			else {
				sourceType = getAdapteeClass();
				sourceInstance = getAdaptee();
			}

			parameterList = Arrays.asList(parameters);
			index = 0;

			/* Iterate over the parameters and initialize the arrays. */
			for (OclRoot aParameter : parameterList) {

				paramTypes[index] = aParameter.getAdapteeClass();
				paramValues[index] = aParameter.getAdaptee();
				index++;
			}

			method = this.findMethod(operationName, sourceType, paramTypes,
					true);
		}

		catch (SecurityException e) {
			e.printStackTrace();
		}

		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		method.setAccessible(true);

		adaptedResult = null;

		/* Try to invoke the found method. */
		try {
			adaptedResult = method.invoke(sourceType.cast(sourceInstance),
					paramValues);
		}

		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		/* Eventually cast result to OclRoot. */
		if (adaptedResult instanceof OclRoot) {
			result = (OclRoot) adaptedResult;
		}

		/* Eventually return void. */
		else if (adaptedResult == null) {
			result = JavaOclVoid.getInstance();
		}

		/* Eventually adapt the result to OclRoot. */
		else {

			/* Eventually adapt the result to all possible OCL types. */

			if (adaptedResult instanceof Boolean) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclBoolean.class);
			}

			else if (adaptedResult instanceof Integer) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclInteger.class);
			}

			else if (adaptedResult instanceof Float) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclReal.class);
			}

			else if (adaptedResult instanceof String) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclString.class);
			}

			else if (adaptedResult instanceof Enum) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclEnumType.class);
			}

			else if (adaptedResult instanceof List) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclBag.class);
			}

			else if (adaptedResult instanceof Set) {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclSet.class);
			}

			else {
				result = (OclRoot) Platform.getAdapterManager().getAdapter(
						adaptedResult, OclRoot.class);
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String result;

		result = this.getClass().getSimpleName() + "(";

		if (this.getAdaptee() != null) {
			result += this.getAdaptee().toString();
		}

		else if (this.undefinedreason != null) {
			result += "undefined: " + this.undefinedreason;
		}
		// no else.

		result += ")";

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {

		boolean result;

		/* Check if the given Object is an OclRoot. */
		if (anObject instanceof OclRoot) {

			OclRoot anOclRoot;

			anOclRoot = (OclRoot) anObject;

			result = this.isEqualTo(anOclRoot).isTrue();
		}

		else {
			result = false;
		}

		return result;
	}
}