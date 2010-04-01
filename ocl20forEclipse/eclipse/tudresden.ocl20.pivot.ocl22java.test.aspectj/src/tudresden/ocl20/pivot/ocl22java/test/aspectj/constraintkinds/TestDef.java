/*
Copyright (C) 2010 by Claas Wilke (claaswilke@gmx.net)

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

package tudresden.ocl20.pivot.ocl22java.test.aspectj.constraintkinds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testpackage.Class1;

/**
 * <p>
 * Tests the generated code for a <code>Constraint</code> of the
 * <code>ConstraintKind.DEF</code>.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestDef extends Class1 {

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.DEF</code>.
	 * </p>
	 */
	@Test
	public void testDef01() {

		assertEquals(new Integer(42), this.defProperty01);
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.DEF</code>.
	 * </p>
	 */
	@Test
	public void testDef02() {

		assertEquals(new Integer(42), this.defOperation01());
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.DEF</code>.
	 * </p>
	 */
	@Test
	public void testDef03() {

		assertEquals(new Integer(-42), this.defOperation02(new Integer(42)));
	}
}