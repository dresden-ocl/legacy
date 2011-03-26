/*
Copyright (C) 2008-2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Model Bus Test Suite of Dresden OCL2 for Eclipse.

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

package tudresden.ocl20.pivot.modelbus.test.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.provider.IOclLibraryProvider;
import tudresden.ocl20.pivot.model.ModelAccessException;

/**
 * <p>
 * Test cases to test the default {@link IOclLibraryProvider} implementation.
 * </p>
 * 
 * @author Claas Wilke
 */
public class OclLibraryProviderTest {

	/**
	 * <p>
	 * Tests the method {@link IOclLibraryProvider#getOclLibrary())},
	 * </p>
	 * 
	 * @throws ModelAccessException
	 */
	@Test
	public void testGetOclLibrary01() throws ModelAccessException {

		assertNotNull(EssentialOclPlugin.getOclLibraryProvider().getOclLibrary());
	}
}