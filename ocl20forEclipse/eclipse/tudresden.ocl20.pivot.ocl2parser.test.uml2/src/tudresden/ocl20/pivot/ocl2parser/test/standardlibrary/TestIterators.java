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

package tudresden.ocl20.pivot.ocl2parser.test.standardlibrary;

import org.junit.Test;

import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.SemanticException;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;

/**
 * <p>
 * Contains test cases that check that the predefined iterators are parsed
 * appropriately.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestIterators {

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyPositive01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyPositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyPositive02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyPositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyPositive03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyPositive03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyPositive04() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyPositive04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyPositive05() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyPositive05.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testAnyNegative01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyNegative01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testAnyNegative02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyNegative02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testAnyNegative03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyNegative03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->any(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testAnyNegative04() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/anyNegative04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyCollect01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectPositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyCollect02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectPositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyCollect03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectPositive03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyCollect04() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectPositive04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test
	public void testAnyCollect05() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectPositive05.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testCollectNegative01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectNegative01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testCollectNegative02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectNegative02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testCollectNegative03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectNegative03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->collect(..)</code>.
	 * </p>
	 */
	@Test(expected = SemanticException.class)
	public void testCollectNegative04() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/collectNegative04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive01() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive01.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive02() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive02.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive03() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive03.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive04() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive04.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive05() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive05.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive06() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive06.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive07() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive07.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive08() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive08.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}

	/**
	 * <p>
	 * A test case testing the iterator <code>Collection->exists(..)</code>.
	 * </p>
	 */
	@Test
	public void testExistsPositive09() throws Exception {

		TestPerformer testPerformer;

		String modelFileName;
		String oclFileName;

		oclFileName = "standardlibrary/iterators/existsPositive09.ocl";
		modelFileName = "testmodel.uml";

		/* Try to get the TestPerformer. */
		testPerformer =
				TestPerformer.getInstance(AllStandardLibraryTests.META_MODEL_ID,
						AllStandardLibraryTests.MODEL_BUNDLE,
						AllStandardLibraryTests.MODEL_DIRECTORY);
		testPerformer.setModel(modelFileName);

		testPerformer.parseFile(oclFileName);
	}
}