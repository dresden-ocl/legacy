/*
Copyright (C) 2009 by Franz Eichhorn (franz.eichhorn@gmx.de)

This file is part of the OCL Interpreter Test Suite of Dresden OCL2 for
Eclipse.

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
package tudresden.ocl20.benchmark.testdata.common;


import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
public class ModelInstance {

	
	/**
	 * required method be a dummy --> try to provide models as requested by each test method
	 * This hack is done to reuse testperformer from interpreter test, hope it works :).
	 * 
	 * @return 
	 */
	public static List<Object> getModelObjects()
	{
		return getFinalStateModelInstance();
		//return getFinalStateModelInstance().getModelObjects();
	}
	
	/**
	 * 
	 * 
	 * @return A simple model instance of the simple UML model.
	 */
	protected static List<Object> getFinalStateModelInstance() {
		
		Dummy test;
		
		test = new Dummy("Test");
				
		List<Object> result = new ArrayList<Object>();
		
		result.add(test);
		
		return result;
	}
		
}
