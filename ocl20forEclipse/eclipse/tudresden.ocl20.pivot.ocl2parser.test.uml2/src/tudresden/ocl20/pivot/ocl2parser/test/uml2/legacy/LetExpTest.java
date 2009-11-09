/*
    Copyright (C) 2008  Nils (s0006383@inf.tu-dresden.de)

    This file is part of the OCL parser of the Dresden OCL2 for Eclipse.

    The OCL parser is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The OCL parser is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with the OCL parser.  If not, see <http://www.gnu.org/licenses/>.
.
 */
package tudresden.ocl20.pivot.ocl2parser.test.uml2.legacy;

import static org.junit.Assert.*;
import org.junit.Test;

import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;
import tudresden.ocl20.pivot.ocl2parser.test.context.AllContextTests;

public class LetExpTest {

	@Test
	public void testLetExp() {

		String fileName = "oclTestFiles/letExpTest.ocl";
		try {
			TestPerformer test =
					TestPerformer.getInstance(AllContextTests.META_MODEL_ID,
							AllContextTests.MODEL_BUNDLE, AllContextTests.MODEL_DIRECTORY);
			test.setModel("royalsandloyals.uml");
			test.parseFile(fileName);
		} catch (Throwable ex) {
			String message = " This error occured for file " + fileName + ".";
			System.err.println(message);
			ex.printStackTrace();

			fail();
			return;
		}

		assertTrue(true);
	}
}
