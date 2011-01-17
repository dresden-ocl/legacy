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
package tudresden.ocl20.benchmark.testdata.b4;

import java.lang.reflect.Field;

// TODO: Auto-generated Javadoc
public class Dummy {

		
	public String name;
	
	
	/**
	 * Instantiates a new dummy.
	 * 
	 * @param name 
	 */
	public Dummy(String name)
	{
		this.name = name;
	}
	

	/**
	 * Prints the.
	 */
	public void print()
	{
		try{
			String buf = "";
			Field[] fields = this.getClass().getDeclaredFields();
			buf+= this.getClass().getName()+"(\n";
			for(Field field : fields){
				buf += "\t"+field.getName()+": "+field.get(this)+"\n";
			}
			buf += ")";
			
			System.out.println(buf);
		}catch(IllegalAccessException e){
			System.out.println("cannot print due to protected visiblity issues");
		}
	}
}
