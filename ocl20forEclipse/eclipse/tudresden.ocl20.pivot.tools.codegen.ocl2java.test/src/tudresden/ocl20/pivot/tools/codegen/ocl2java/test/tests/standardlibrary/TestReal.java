/*
Copyright (C) 2008-2010 by Claas Wilke (claaswilke@gmx.net)

This file is part of the OCL 2 Java Code Generator of Dresden OCL2 for Eclipse.

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

package tudresden.ocl20.pivot.tools.codegen.ocl2java.test.tests.standardlibrary;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.tools.codegen.ocl2java.test.tests.AbstractDiffTest;

/**
 * <p>
 * Contains some test cases to test the code generation for standard library
 * operations.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestReal extends AbstractDiffTest {

	/**
	 * <p>
	 * Initializes the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	@BeforeClass
	public static void setUp() throws IllegalArgumentException,
			ModelAccessException {

		AbstractDiffTest.setUp();
	}

	/**
	 * <p>
	 * Tears down the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	@AfterClass
	public static void tearDown() throws IllegalArgumentException,
			ModelAccessException {

		AbstractDiffTest.tearDown();
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAbs01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "abs01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDivision01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "division01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFloor01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "floor01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGreaterThan01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "greaterThan01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGreaterThanEqual01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "greaterThanEqual01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLessThan01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "lessThan01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLessThanEqual01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "lessThanEqual01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMax01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "max01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMin01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "min01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMinus01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "minus01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMultiply01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "multiply01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNegation01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "negation01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlus01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "plus01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRound01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "round01");
	}

	/**
	 * <p>
	 * Tests the code generation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString01() throws Exception {

		this.compareFragmentCodeGeneration("sltest/real", "toString01");
	}
}