/*
Copyright (C) 2009 by Claas Wilke (info@claaswilke.de)

This file is part of the Java Model Instance Type Test Suite of Dresden 
OCL2 for Eclipse.

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
package tudresden.ocl20.pivot.modelinstancetype.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;

import tudresden.ocl20.pivot.modelbus.model.IModel;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceFactory;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceObject;
import tudresden.ocl20.pivot.modelinstancetype.test.ModelInstanceTypeTestPlugin;
import tudresden.ocl20.pivot.modelinstancetype.test.ModelInstanceTypeTestServices;
import tudresden.ocl20.pivot.modelinstancetype.test.msg.ModelInstanceTypeTestSuiteMessages;
import tudresden.ocl20.pivot.modelinstancetype.test.testmodel.TestModelTypesNames;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * Contains test cases to test the implementation of {@link IModelInstance}.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestModelInstance {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER =
			ModelInstanceTypeTestPlugin.getLogger(TestModelInstance.class);

	/** A String used to display messages during the tests. */
	private static String msg;

	/** The {@link IModelInstance} tested by this test suite. */
	private static IModelInstance modelInstanceUnderTest;

	/** The type {@link Class1} used in this test class. */
	private static Type type_Class1;

	/** The type {@link StaticPropertyAndOperationClass} used in this test class. */
	private static Type type_StaticPropertyAndOperationClass;

	/**
	 * <p>
	 * Loads the {@link IModelInstance} and some other fields required for the
	 * tests of this Class.
	 * </p>
	 */
	@BeforeClass
	public static void setUp() {

		/* Try to load the model instance. */
		modelInstanceUnderTest =
				ModelInstanceTypeTestServices.getInstance().getModelInstance();

		if (modelInstanceUnderTest == null) {
			msg =
					ModelInstanceTypeTestSuiteMessages.TestModelInstance_LoadModelInstanceWrong;

			LOGGER.error(msg);
		}
		// no else.

		/* Find the type in the Model. */
		type_Class1 =
				ModelInstanceTypeTestServices.getInstance().getModelType(
						TestModelTypesNames.TYPE_NAME_CLASS1);

		/* Find the type in the Model. */
		type_StaticPropertyAndOperationClass =
				ModelInstanceTypeTestServices.getInstance().getModelType(
						TestModelTypesNames.TYPE_NAME_STATIC_PROPERTY_AND_OPERATION_CLASS);
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#addModelInstanceElement(Object)} .
	 * </p>
	 */
	@org.junit.Test
	public void testAddModelInstanceElement() {

		IModelInstanceObject anAdaptedObject;
		IModelInstanceElement anAddedObject;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_AddModelInstanceElementIsWrong;

		/* Get an adapted Object from the model. */
		anAdaptedObject =
				ModelInstanceTypeTestServices.getInstance()
						.getModelInstanceObjectsOfType(type_Class1).iterator().next();

		if (anAdaptedObject != null) {

			/* Try to re-adapt the given object. */
			try {
				anAddedObject =
						modelInstanceUnderTest.addModelInstanceElement(anAdaptedObject
								.getObject());

				/* The added object should not be null. */
				assertNotNull(msg, anAddedObject);

				/* The added object should be an IModelInstanceObject. */
				assertTrue(msg, anAddedObject instanceof IModelInstanceObject);

				/* The added object should be the same as the found object. */
				assertEquals(msg, anAdaptedObject, anAddedObject);
			}

			catch (TypeNotFoundInModelException e) {
				fail(msg);
			}
		}

		else {
			msg =
					ModelInstanceTypeTestSuiteMessages.TestModelInstance_AddModelInstanceElementIsWrong2;

			fail(msg);
		}
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getAllImplementedTypes()}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetAllImplementedTypes() {

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetAllImplementedTypesIsWrong;

		/* The method should return a result. */
		assertNotNull(msg, modelInstanceUnderTest.getAllImplementedTypes());

		/* The result should contain the type Class1. */
		assertTrue(msg, modelInstanceUnderTest.getAllImplementedTypes().contains(
				type_Class1));
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getAllInstances(Type))}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetAllInstances() {

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetAllInstancesIsWrong;

		/* The method should return a result. */
		assertNotNull(msg, modelInstanceUnderTest.getAllInstances(type_Class1));

		/* The result should only contain instances of Class1. */
		for (IModelInstanceObject object : modelInstanceUnderTest
				.getAllInstances(type_Class1)) {

			assertTrue(msg, object.getTypes().contains(type_Class1));
		}
		// end for.
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getAllModelInstanceObjects())}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetModelInstanceObjects() {

		List<IModelInstanceObject> allObjects;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetAllModelInstanceObjectsIsWrong;

		allObjects = modelInstanceUnderTest.getAllModelInstanceObjects();

		/* The method should return a model. */
		assertNotNull(msg, allObjects);

		/* The result contain all instances of all implemented types. */
		for (Type type : modelInstanceUnderTest.getAllImplementedTypes()) {

			assertTrue(msg, allObjects.containsAll(modelInstanceUnderTest
					.getAllInstances(type)));
		}
		// end for.
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getModel()}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetModel() {

		IModel model;

		msg = ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetModelWrong;

		/* Get the model from the test environment. */
		model = ModelInstanceTypeTestServices.getInstance().getModelUnderTest();

		/* The model instances should return a model. */
		assertNotNull(msg, modelInstanceUnderTest.getModel());

		/* The model instances should return the same model. */
		assertEquals(msg, model, modelInstanceUnderTest.getModel());
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getModelInstanceFactory()}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetModelInstanceFactory() {

		IModelInstanceFactory factory;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetModelInstanceFactoryIsWrong;

		/* Get the model instance factory. */
		factory = modelInstanceUnderTest.getModelInstanceFactory();

		/* The model instances should return a model instance factory. */
		assertNotNull(msg, factory);
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#getStaticProperty(Property)}.
	 * </p>
	 */
	@org.junit.Test
	public void testGetStaticProperty() {

		Property property;
		IModelInstanceElement propertyValue;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_GetStaticPropertyIsWrong;

		property = null;

		/* Load the Property required for testing. */
		for (Property aProperty : type_StaticPropertyAndOperationClass
				.allProperties()) {

			if (aProperty.getName().equals("staticProperty")) {
				property = aProperty;
				break;
			}
			// no else.
		}

		if (property != null) {

			/* Try to get the property. */
			try {
				propertyValue =
						modelInstanceUnderTest.getStaticProperty(property);

				/* The value should not be null. */
				assertNotNull(msg, propertyValue);

				/* The value should have exactly one type. */
				assertEquals(msg, 1, propertyValue.getTypes().size());

				/* The value should be of the right type. */
				assertTrue(msg, propertyValue.getTypes().contains(property.getType()));
			}

			catch (PropertyNotFoundException e) {

				if (LOGGER.isDebugEnabled()) {
					LOGGER.warn(msg);
				}
				// no else.
			}

			catch (PropertyAccessException e) {

				if (LOGGER.isDebugEnabled()) {
					LOGGER.warn(msg);
				}
				// no else.
			}
		}

		/* Else fail. */
		else {
			fail(msg);
		}
	}

	/**
	 * <p>
	 * Tests the method
	 * {@link IModelInstance#invokeStaticOperation(Operation, List)}.
	 * </p>
	 */
	@org.junit.Test
	public void testInvokeStaticOperation() {

		Operation operation;

		List<IModelInstanceElement> arguments;
		IModelInstanceElement operationResult;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_InvokeStaticOperationIsWrong;

		operation = null;

		/* Load the Operation required for testing. */
		for (Operation anOperation : type_StaticPropertyAndOperationClass
				.allOperations()) {

			if (anOperation.getName().equals("staticOperation")) {
				operation = anOperation;
				break;
			}
			// no else.
		}

		/* Initialize the List of arguments. */
		arguments = new ArrayList<IModelInstanceElement>();

		if (operation != null) {

			/* Try to invoke the operation. */
			try {
				operationResult =
						modelInstanceUnderTest.invokeStaticOperation(operation, arguments);

				/* The result should not be null. */
				assertNotNull(msg, operationResult);

				/* The result should have exactly one type. */
				assertEquals(msg, 1, operationResult.getTypes().size());

				/* The result should be of the right type. */
				assertTrue(msg, operationResult.getTypes()
						.contains(operation.getType()));
			}

			catch (OperationNotFoundException e) {

				if (LOGGER.isDebugEnabled()) {
					LOGGER.warn(msg);
				}
				// no else.
			}

			catch (OperationAccessException e) {

				if (LOGGER.isDebugEnabled()) {
					LOGGER.warn(msg);
				}
				// no else.
			}
		}

		/* Else fail. */
		else {
			fail(msg);
		}
	}

	/**
	 * <p>
	 * Tests the method {@link IModelInstance#isInstanceOf(IModel)}.
	 * </p>
	 */
	@org.junit.Test
	public void testIsInstanceOf() {

		IModel model;

		msg =
				ModelInstanceTypeTestSuiteMessages.TestModelInstance_IsInstanceOfIsWrong;

		/* Get the model from the test environment. */
		model = ModelInstanceTypeTestServices.getInstance().getModelUnderTest();

		/* The method isInstanceOf should return true. */
		assertTrue(msg, modelInstanceUnderTest.isInstanceOf(model));
	}
}