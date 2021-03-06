/*
 * Copyright (C) 2011 by Claas Wilke (claas.wilke@tu-dresden.de) This file is part of
 * the Meta Model Architecture of Dresden OCL. Dresden OCL
 * is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version. Dresden OCL is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details. You should have received a copy of
 * the GNU Lesser General Public License along with Dresden OCL. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package tudresden.ocl20.pivot.metamodels.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.metamodels.test.MetaModelTestPlugin;
import tudresden.ocl20.pivot.metamodels.test.MetaModelTestServices;
import tudresden.ocl20.pivot.metamodels.test.msg.MetaModelTestSuiteMessages;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.metamodel.IMetamodel;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Parameter;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * This class provides test cases to test the {@link PrimitiveType}
 * implementation/adaptation of a {@link IMetamodel}.
 * </p>
 * 
 * @author Claas Wilke
 * 
 */
public class TestOperation {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER = MetaModelTestPlugin
			.getLogger(TestOperation.class);

	/** A {@link Type} of the current {@link IModel} under test. */
	private static Type testTypeClass1;

	/** A {@link Type} of the current {@link IModel} under test. */
	private static Type testOperationAndParameterClass;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation operation1;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation operation2;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation outputParameterOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation staticOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation multipleOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation orderedMultipleOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation unorderedMultipleOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation uniqueMultipleOperation;

	/** An {@link Operation} of the current {@link IModel} under test. */
	private static Operation nonuniqueMultipleOperation;

	/**
	 * <p>
	 * Loads some elements from the current {@link IModel} under test required
	 * for the tests contained in this Class.
	 * </p>
	 */
	@BeforeClass
	public static void setUp() {

		if (!MetaModelTestServices.supportsNoOperations) {
			testTypeClass1 = MetaModelTestServices
					.getInstance()
					.getTypeUnderTest(
							MetaModelTestServices.TYPE_QUALIFIED_NAME_TESTTYPECLASS1);

			testOperationAndParameterClass = MetaModelTestServices
					.getInstance()
					.getTypeUnderTest(
							MetaModelTestServices.TYPE_QUALIFIED_NAME_TESTOPERATIONANDPARAMETERCLASS);

			/* Find some operations in the class. */
			for (Operation anOperation : testOperationAndParameterClass
					.getOwnedOperation()) {

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_OPERATIONWITHOUTPARAMETERS)) {
					operation1 = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_VOIDOPERATIONWITHPARAMETER)) {
					operation2 = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_OUTPUTPARAMETEROPERATION)) {
					outputParameterOperation = anOperation;
				}
				// no else.

				if (anOperation.getName().equals(
						MetaModelTestServices.OPERATION_NAME_STATICOPERATION)) {
					staticOperation = anOperation;
				}
				// no else.

				if (anOperation.getName().equals(
						MetaModelTestServices.OPERATION_NAME_MULTIPLEOPERATION)) {
					multipleOperation = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_ORDEREDMULTIPLEOPERATION)) {
					orderedMultipleOperation = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_UNORDEREDMULTIPLEOPERATION)) {
					unorderedMultipleOperation = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_UNIQUEMULTIPLEOPERATION)) {
					uniqueMultipleOperation = anOperation;
				}
				// no else.

				if (anOperation
						.getName()
						.equals(MetaModelTestServices.OPERATION_NAME_NONUNIQUEMULTIPLEOPERATION)) {
					nonuniqueMultipleOperation = anOperation;
				}
				// no else.
			}
			// end for.

			if (outputParameterOperation == null) {

				/* Eventually send a warning to the logger. */
				if (LOGGER.isInfoEnabled()) {
					String msg;

					msg = NLS
							.bind(MetaModelTestSuiteMessages.MetaModelTestSuite_OperationNotFoundInModel,
									MetaModelTestServices.OPERATION_NAME_OUTPUTPARAMETEROPERATION,
									"Operation.getOutputParameter()");
					msg += " "
							+ NLS.bind(
									MetaModelTestSuiteMessages.MetaModelTestSuite_CurrentlyTestedMetaModel,
									MetaModelTestServices.getInstance()
											.getMetaModelUnderTestID());

					LOGGER.warn(msg);
				}
			}
			// no else.

			if (staticOperation == null) {

				/* Eventually send a warning to the logger. */
				if (LOGGER.isInfoEnabled()) {
					String msg;

					msg = NLS
							.bind(MetaModelTestSuiteMessages.MetaModelTestSuite_OperationNotFoundInModel,
									MetaModelTestServices.OPERATION_NAME_STATICOPERATION,
									"Operation.isStatic()");
					msg += " "
							+ NLS.bind(
									MetaModelTestSuiteMessages.MetaModelTestSuite_CurrentlyTestedMetaModel,
									MetaModelTestServices.getInstance()
											.getMetaModelUnderTestID());

					LOGGER.warn(msg);
				}
				// no else.
			}
			// no else.
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getGenericType()}.
	 * </p>
	 */
	@Test
	public void testGetGenericType1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getGenericType() seems to be wrong. ";
			msg = "The Operation " + operation1.getQualifiedName();
			msg += " should not return a generic Type.";

			/* The operation must not have a generic type. */
			assertNull(msg, operation1.getGenericType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getInputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetInputParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getInputParameter() seems to be wrong.";

			/* The operation must have no input parameters. */
			assertEquals(msg, 0, operation1.getInputParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getInputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetInputParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getInputParameter() seems to be wrong.";

			/* The operation must have no input parameters. */
			assertEquals(msg, 1, operation2.getInputParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getInputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetInputParameter3() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg = "The adaptation of Operation.getInputParameter() seems to be wrong. Result should be an EList.";

			assertTrue(msg, operation1.getInputParameter() instanceof EList);
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getName()}.
	 * </p>
	 */
	@Test
	public void testGetName1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getName() seems to be wrong.";

			/* The operation must have been found by the given name. */
			assertEquals(
					msg,
					MetaModelTestServices.OPERATION_NAME_OPERATIONWITHOUTPARAMETERS,
					operation1.getName());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOutputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOutputParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOutputParameter() seems to be wrong.";

			/* The operation must have no output parameters. */
			assertEquals(msg, 0, operation1.getOutputParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOutputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOutputParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOutputParameter() seems to be wrong.";

			/* The operation must have no output parameters. */
			assertEquals(msg, 0, operation2.getOutputParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOutputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOutputParameter3() {

		/*
		 * Only execute this test, if the current IModel under test contains
		 * Operations with output parameters.
		 */
		if (outputParameterOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getOutputParameter() seems to be wrong.";

			/* The operation must have one output parameters. */
			assertEquals(msg, 1, outputParameterOperation.getOutputParameter()
					.size());
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOutputParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOutputParameter4() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg = "The adaptation of Operation.getOutputParameter() seems to be wrong. Result should be an EList.";

			assertTrue(msg, operation1.getOutputParameter() instanceof EList);
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwnedParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOwnedParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwnedParameter() seems to be wrong.";

			/* The operation must have one owned parameters. */
			assertEquals(msg, 1, operation1.getOwnedParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwnedParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOwnedParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwnedParameter() seems to be wrong.";

			/*
			 * The operation must have one or two owned parameters depending on
			 * the decision, whether or not the return parameter is null or
			 * void.
			 */
			if (operation2.getReturnParameter() == null) {
				assertEquals(msg, 1, operation2.getOwnedParameter().size());
			}

			else {
				assertEquals(msg, 2, operation2.getOwnedParameter().size());
			}
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwnedParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOwnedParameter3() {

		/*
		 * Only execute this test, if the current IModel under test contains
		 * Operations with output parameters.
		 */
		if (outputParameterOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getOwnedParameter() seems to be wrong.";

			/* The operation must have one owned parameters. */
			assertEquals(msg, 2, outputParameterOperation.getOwnedParameter()
					.size());
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwnedParameter()}.
	 * </p>
	 */
	@Test
	public void testGetOwnedParameter4() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg = "The adaptation of Operation.getOwnedParameter() seems to be wrong. Result should be an EList.";

			assertTrue(msg, operation1.getOwnedParameter() instanceof EList);
		}
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getOwnedTypeParameter()} .
	 * </p>
	 */
	@Test
	public void testGetOwnedTypeParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwnedTypeParameter() seems to be wrong. ";
			msg += "The Operation " + operation1.getQualifiedName();
			msg += " should not have Type Parameters.";

			/* The operation must have no type parameters. */
			assertEquals(msg, 0, operation1.getOwnedTypeParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getOwnedTypeParameter()} .
	 * </p>
	 */
	@Test
	public void testGetOwnedTypeParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwnedTypeParameter() seems to be wrong. ";
			msg += "Result should be an EList.";

			assertTrue(msg, operation1.getOwnedTypeParameter() instanceof EList);
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getReturnParameter()}.
	 * </p>
	 */
	@Test
	public void testGetReturnParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getReturnParameter() seems to be wrong.";

			assertNotNull(msg, operation1.getReturnParameter());

			/* The operation must have class1 as return parameter type. */
			assertEquals(msg, testTypeClass1, operation1.getReturnParameter()
					.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getReturnParameter()}.
	 * </p>
	 */
	@Test
	public void testGetReturnParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			Parameter returnParameter;
			Type returnType;

			msg = "The adaptation of Operation.getReturnParameter() seems to be wrong. ";
			msg += "The return type must be of the PrimitiveTypeKind.VOID.";

			returnParameter = operation2.getReturnParameter();

			/* The operation must have a return parameter. */
			assertNotNull(msg, returnParameter);

			returnType = returnParameter.getType();

			/* The return Type must be primitive. */
			assertEquals(msg, returnType, EssentialOclPlugin
					.getOclLibraryProvider().getOclLibrary().getOclVoid());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwner()}.
	 * </p>
	 */
	@Test
	public void testGetOwner1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwner() seems to be wrong.";

			/* The operation must be owned by the type its belongs to. */
			assertEquals(msg, testOperationAndParameterClass,
					operation1.getOwner());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getOwningType()}.
	 * </p>
	 */
	@Test
	public void testGetOwningType1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getOwningType() seems to be wrong.";

			/* The operation must be owned by the type its belongs to. */
			assertEquals(msg, testOperationAndParameterClass,
					operation1.getOwningType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getQualifiedName()}.
	 * </p>
	 */
	@Test
	public void testGetQualifiedName1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getQualifiedName() seems to be wrong.";

			/* The operation must have been found by the given name. */
			assertEquals(
					msg,
					MetaModelTestServices.OPERATION_QUALIFIED_NAME_OPERATIONWITHOUTPARAMETERS,
					operation1.getQualifiedName());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getQualifiedName()}.
	 * </p>
	 */
	@Test
	public void testGetQualifiedName2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getQualifiedName() seems to be wrong ";
			msg += "for Operations with input Parameters.";

			/* The operation must have been found by the given name. */
			assertEquals(
					msg,
					MetaModelTestServices.OPERATION_QUALIFIED_NAME_VOIDOPERATIONWITHPARAMETER,
					operation2.getQualifiedName());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getSignatureParameter()} .
	 * </p>
	 */
	@Test
	public void testGetSignatureParameter1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getSignatureParameter() seems to be wrong.";

			/* The operation must not have any signature parameters. */
			assertEquals(msg, 0, operation1.getSignatureParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getSignatureParameter()} .
	 * </p>
	 */
	@Test
	public void testGetSignatureParameter2() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getSignatureParameter() seems to be wrong.";

			/* The operation must have one signature parameters. */
			assertEquals(msg, 1, operation2.getSignatureParameter().size());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getSignatureParameter()} .
	 * </p>
	 */
	@Test
	public void testGetSignatureParameter3() {

		/*
		 * Only execute this test, if the current IModel under test contains
		 * Operations with output parameters.
		 */
		if (outputParameterOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getSignatureParameter() seems to be wrong.";

			/* The operation must have one signature parameters. */
			assertEquals(msg, 1, outputParameterOperation
					.getSignatureParameter().size());
		}
	}

	/**
	 * <p>
	 * A test case testing the operation
	 * {@link Operation#getSignatureParameter()} .
	 * </p>
	 */
	@Test
	public void testGetSignatureParameter4() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg = "The adaptation of Operation.getSignatureParameter() seems to be wrong. Result should be an EList.";

			assertTrue(msg, operation1.getSignatureParameter() instanceof EList);
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType01() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getType() seems to be wrong.";

			/* The operation must have the same type as in the model. */
			assertEquals(msg, testTypeClass1, operation1.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType02() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			Type type;

			msg = "The adaptation of Operation.getType() seems to be wrong.";
			msg += " Type must be OclVoid.";

			type = operation2.getType();

			/* The type must not be null. */
			assertNotNull(msg, type);

			assertEquals(msg, type, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getOclVoid());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType03() {

		/*
		 * Only execute this test case if the current model under test supports
		 * static operations.
		 */
		if (staticOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getType() seems to be wrong.";

			/* The operation must have the same type as in the model. */
			assertEquals(msg, testTypeClass1, staticOperation.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType04() {

		if (multipleOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getType() for "
					+ "'TestOperationAndParameterClass.multipleOperation(TestTypeClass1)' seems to be wrong.";

			/* The operation must be multiple. */
			assertEquals(msg, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getCollectionType(testTypeClass1),
					multipleOperation.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType05() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getType() for "
					+ "'TestOperationAndParameterClass.orderedMultipleOperation(TestTypeClass1)' seems to be wrong.";

			/* The operation must be multiple. */
			assertEquals(msg, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getSequenceType(testTypeClass1),
					orderedMultipleOperation.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#isOrdered()}.
	 * </p>
	 */
	@Test
	public void testGetType06() {

		if (unorderedMultipleOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getType() for "
					+ "'unorderedMultipleOperation(TestTypeClass1)' seems to be wrong.";

			/* The operation must be multiple. */
			assertEquals(msg, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getSetType(testTypeClass1),
					unorderedMultipleOperation.getType());
		}

		else {
			LOGGER.warn("Operation 'unorderedMultipleOperation' was not found. Probably, type adaptation of Operations has not been tested completely.");
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType07() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.getType() for "
					+ "'uniqueMultipleOperation(TestTypeClass1)' seems to be wrong.";

			/* The operation must be multiple. */
			assertEquals(msg, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getSetType(testTypeClass1),
					uniqueMultipleOperation.getType());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#getType()}.
	 * </p>
	 */
	@Test
	public void testGetType08() {

		if (unorderedMultipleOperation != null) {
			String msg;

			msg = "The adaptation of Operation.getType() for "
					+ "'nonuniqueMultipleOperation(TestTypeClass1)' seems to be wrong.";

			/* The operation must be multiple. */
			assertEquals(msg, EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getBagType(testTypeClass1),
					nonuniqueMultipleOperation.getType());
		}

		else {
			LOGGER.warn("Operation 'nonuniqueMultipleOperation' was not found. Probably, type adaptation of Operations has not been tested completely.");
		}
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#isStatic()}.
	 * </p>
	 */
	@Test
	public void testIsStatic1() {

		if (!MetaModelTestServices.supportsNoOperations) {
			String msg;

			msg = "The adaptation of Operation.isStatic() seems to be wrong.";

			/* The operation must not be static. */
			assertFalse(msg, operation1.isStatic());
		}
		// no else.
	}

	/**
	 * <p>
	 * A test case testing the operation {@link Operation#isStatic()}.
	 * </p>
	 */
	@Test
	public void testIsStatic2() {

		/*
		 * Only execute this test, if static Operations are in the current
		 * IModel under test.
		 */
		if (staticOperation != null) {
			String msg;

			msg = "The adaptation of Operation.isStatic() seems to be wrong.";

			/* The operation must not be static. */
			assertTrue(msg, staticOperation.isStatic());
		}
		// no else.
	}
}