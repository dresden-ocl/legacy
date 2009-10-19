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
package tudresden.ocl20.pivot.ocl2parser.test.uml2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import tudresden.ocl20.pivot.modelbus.ModelAccessException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.BuildingASTException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.LexException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.ParsingException;
import tudresden.ocl20.pivot.ocl2parser.parser.exceptions.SemanticException;
import tudresden.ocl20.pivot.ocl2parser.test.AllUML2Tests;
import tudresden.ocl20.pivot.ocl2parser.test.MetaModelNotFoundException;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;

public class AtPreTest {

	@Test
	public void testAtPre() {

		String fileName = "oclTestFiles/atPreTest.ocl";

		TestPerformer test;
		try {
			test =
					TestPerformer.getInstance(AllUML2Tests.META_MODEL_NAME,
							AllUML2Tests.MODEL_BUNDLE, AllUML2Tests.MODEL_BUNDLE_PATH);
			test.setModel("royalsandloyals.uml");

			try {
				test.parseFile(fileName);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			} catch (ParsingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			} catch (LexException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			} catch (BuildingASTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			} catch (SemanticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Failes to parse File");
			}

		} catch (MetaModelNotFoundException e) {
			e.printStackTrace();
			fail("Unable to get TestPerformer");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Lacking file resources");
		} catch (ModelAccessException e) {
			e.printStackTrace();
			fail("Couldn't set Model");
		}

		assertTrue(true);
	}
}
