/*
Copyright (C) 2008-2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the OCL2 Parser Test Suite of Dresden OCL2 for Eclipse.

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

package tudresden.ocl20.pivot.ocl2parser.test.constrainttypes;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import tudresden.ocl20.pivot.modelbus.ModelAccessException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.BuildingASTException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.LexException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.ParsingException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.SemanticException;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;
import tudresden.ocl20.pivot.ocl2parser.test.exception.MetaModelNotFoundException;

/**
 * <p>
 * Contains test cases that check that the context of definitions is parsed
 * correctly.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestDefinition {

	/**
	 * <p>
	 * A test case to parse a definition that should be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionPositive01() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defPositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse a definition that should be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionPositive02() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defPositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse a definition that should be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionPositive03() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defPositive03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse a definition that should be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionPositive04() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defPositive04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse an definition that should not be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionNegative01() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defNegative01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);

				fail("Expected ParsingException was not thrown.");
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				/* Expected Exception. */
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse an definition that should not be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionNegative02() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defNegative02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);

				fail("Expected ParsingException was not thrown.");
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				/* Expected Exception. */
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse an definition that should not be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionNegative03() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defNegative03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);

				fail("Expected ParsingException was not thrown.");
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				/* Expected Exception. */
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse an definition that should not be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionNegative04() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defNegative04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);

				fail("Expected ParsingException was not thrown.");
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				/* Expected Exception. */
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}

	/**
	 * <p>
	 * A test case to parse an definition that should not be parsed appropriately.
	 * </p>
	 */
	@Test
	public void testDefinitionNegative05() {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "constrainttypes/defNegative05.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		try {

			testPerformer =
					TestPerformer.getInstance(AllConstraintTypeTests.META_MODEL_ID,
							AllConstraintTypeTests.MODEL_BUNDLE,
							AllConstraintTypeTests.MODEL_DIRECTORY);
			testPerformer.setModel(modelFileName);

			/* Try to parse the constraint file. */
			try {
				testPerformer.parseFile(oclFileName);

				fail("Expected ParsingException was not thrown.");
			}

			catch (FileNotFoundException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (ParsingException e) {
				/* Expected Exception. */
			}

			catch (LexException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (IOException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (BuildingASTException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}

			catch (SemanticException e) {
				fail("Failed to parse File. Reason: " + e.getMessage());
			}
			// end catch.
		}
		// end try.

		catch (MetaModelNotFoundException e) {
			fail("Unable to get TestPerformer. Reason: " + e.getMessage());
		}

		catch (FileNotFoundException e) {
			fail("Lacking file resources. Reason: " + e.getMessage());
		}

		catch (ModelAccessException e) {
			fail("Couldn't set Model. Reason: " + e.getMessage());
		}
		// end catch.
	}
}