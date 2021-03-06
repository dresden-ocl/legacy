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
package tudresden.ocl20.benchmark.testdata.b2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import tudresden.ocl20.benchmark.testdata.b2.Person;
import tudresden.ocl20.benchmark.testdata.b2.Gender;
import tudresden.ocl20.benchmark.testdata.b2.CivilStatus;

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
		return getFinalStateModelInstance().getModelObjects();
	}
	
	/**
	 * 
	 * 
	 * @return A simple model instance of the simple UML model.
	 */
	protected static PersonMap getFinalStateModelInstance() {
		
		Person ada;
		Person bob;
		Person cyd;
		Person dan;
		
		ada = new Person("Ada", CivilStatus.single, Gender.female, true);

		bob = new Person("Bob", CivilStatus.single,  Gender.male, true);
	
		ada.marry(bob);
		
		cyd = new Person("Cyd", CivilStatus.single, Gender.male, true);
		
		ada.divorce();
		
		ada.marry(cyd);

		dan = new Person("Dan", CivilStatus.single, Gender.male, true);
		
		cyd.death();
		ada.civstat = CivilStatus.widowed;
		
		PersonMap result = new PersonMap(5);
		
		result.add(ada);
		result.add(bob);
		result.add(cyd);
		result.add(dan);
			
		return result;
	}
	
	
	
	static protected class PersonMap extends HashMap<String, Person>
	{
		private final static long serialVersionUID=1L;
		
		/**
		 * Instantiates a new person map.
		 * 
		 * @param size 
		 */
		public PersonMap(int size)
		{
			super(size);
		}
		
		/**
		 * Adds the.
		 * 
		 * @param p 
		 */
		public void add(Person p)
		{
			this.put(p.name, p);			
		}
		
		/**
		 * Gets the model objects.
		 * 
		 * @return the model objects
		 */
		public List<Object> getModelObjects()
		{
			Collection<Person> values = this.values();
			
			return new ArrayList<Object>(values);
		}
	}
	
	
	
}
