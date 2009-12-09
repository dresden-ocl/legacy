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

package tudresden.ocl20.pivot.ocl2parser.test.expressions;

import org.junit.Test;

import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.ParsingException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.SemanticException;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;
import tudresden.ocl20.pivot.essentialocl.expressions.WellformednessException;

/**
 * <p>
 * Contains test cases that check that IterateExpressions are parsed
 * appropriately.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestIterateExpressions {

	/**
	 * <p>
	 * A test case to check that a IterateExpression is parsed appropriately.
	 * </p>
	 */
	@Test
	public void testIterateExpressionPositive01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/iterators/iteratePositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer
						.getInstance(AllExpressionTests.META_MODEL_ID,
								AllExpressionTests.MODEL_BUNDLE,
								AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case to check that a IterateExpression is parsed appropriately.
	 * </p>
	 */
	@Test
	public void testIterateExpressionPositive02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/iterators/iteratePositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer
						.getInstance(AllExpressionTests.META_MODEL_ID,
								AllExpressionTests.MODEL_BUNDLE,
								AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case to check that a IterateExpression is not parsed appropriately.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testIterateExpressionNegative01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/iterators/iterateNegative01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer
						.getInstance(AllExpressionTests.META_MODEL_ID,
								AllExpressionTests.MODEL_BUNDLE,
								AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case to check that a IterateExpression is not parsed appropriately.
	 * </p>
	 */
	@Test(expected = WellformednessException.class)
	public void testIterateExpressionNegative02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/iterators/iterateNegative02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer
						.getInstance(AllExpressionTests.META_MODEL_ID,
								AllExpressionTests.MODEL_BUNDLE,
								AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case to check that a IterateExpression is not parsed appropriately.
	 * </p>
	 */
	@Test(expected = ParsingException.class)
	public void testIterateExpressionNegative03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/iterators/iterateNegative03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer
						.getInstance(AllExpressionTests.META_MODEL_ID,
								AllExpressionTests.MODEL_BUNDLE,
								AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}
}