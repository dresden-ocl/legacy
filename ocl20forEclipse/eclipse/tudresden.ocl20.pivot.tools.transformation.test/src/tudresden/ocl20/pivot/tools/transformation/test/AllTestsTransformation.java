/*
 * AllTestsCodegen.java
 * 
 * Copyright (c) 2007 Claas Wilke
 * Contact: <claaswilke@gmx.net>
 *
 * This file is part of the Dresden OCL2.0 Toolkit
 * created at Technische Universitaet Dresden (TUD), Germany.
 * Visit http://dresden-ocl.sourceforge.net/ for details.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA  02111-1307  USA
 *
 */

package tudresden.ocl20.pivot.tools.transformation.test;

import org.dresdenocl.testsuite._abstract.AbstractDresdenOclTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tudresden.ocl20.pivot.tools.transformation.TransformationPlugin;
import tudresden.ocl20.pivot.tools.transformation.test.tests.TestTransformationFactory;
import tudresden.ocl20.pivot.tools.transformation.test.tests.TestTransformationRegistry;
import tudresden.ocl20.pivot.tools.transformation.test.util.TestParallelTrans;
import tudresden.ocl20.pivot.tools.transformation.test.util.TestTrans;

/**
 * This TestSuite runs all Tests testing the package
 * <code>tudresden.ocl20.pivot.tools.transformation</code> and its subpackages
 * of the Dresden OCL2 Toolkit
 * 
 * @author Bjoern Freitag
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestTransformationFactory.class,
		TestTransformationRegistry.class

})
public class AllTestsTransformation extends AbstractDresdenOclTest {

	@BeforeClass
	public static void setUp() throws Exception {

		AbstractDresdenOclTest.setUp();
		TransformationPlugin.getTransformationRegistry().addTransformation(
				new TestTrans("", ""));
		TransformationPlugin.getTransformationRegistry().addTransformation(
				new TestParallelTrans("", ""));
	}

	@AfterClass
	public static void tear_down() {

		TransformationPlugin.getTransformationRegistry().removeTransformation(
				"TestParallelTrans");
		TransformationPlugin.getTransformationRegistry().removeTransformation(
				"TestTrans");
		TransformationPlugin.getTransformationRegistry().removeTransformation(
				"TestFalseTrans");

	}

}
