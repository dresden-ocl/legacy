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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl;
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.Operation;

/**
 * <p>
 * Contains test cases that check that InvalidLiteralExpressions are parsed
 * appropriately.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestInvalidLiterals {

	/**
	 * <p>
	 * A test case to check that the InvalidLiteralExpression is parsed
	 * appropriately.
	 * </p>
	 */
	@Test
	public void testInvalidPositive01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/literals/invalidPositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer = TestPerformer.getInstance(
				AllExpressionTests.META_MODEL_ID,
				AllExpressionTests.MODEL_BUNDLE,
				AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case to check that the InvalidLiteralExpression is parsed
	 * appropriately.
	 * </p>
	 */
	@Test
	public void testInvalidPositive02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "expressions/literals/invalidPositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer = TestPerformer.getInstance(
				AllExpressionTests.META_MODEL_ID,
				AllExpressionTests.MODEL_BUNDLE,
				AllExpressionTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		/* Try to parse the constraint file. */
		List<Constraint> constraints = testPerformer.parseFile(oclFileName);
		assertNotNull(constraints);
		assertEquals(1, constraints.size());

		Constraint constraint = constraints.get(0);
		assertTrue(constraint.getSpecification() instanceof ExpressionInOcl);
		OclExpression exp = ((ExpressionInOcl) constraint.getSpecification())
				.getBodyExpression();

		assertTrue(exp instanceof OperationCallExp);
		OperationCallExp opCallExp = (OperationCallExp) exp;

		Operation op = opCallExp.getReferredOperation();
		assertNotNull(op);

		/*
		 * Operation should be owned by OclInteger althoug invoked on
		 * OclInvalid.
		 */
		assertEquals("+", op.getName());
		assertEquals(EssentialOclPlugin.getOclLibraryProvider().getOclLibrary()
				.getOclInteger(), op.getOwner());
	}
}