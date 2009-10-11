/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Ronny Brandt (Ronny_Brandt@web.de).                    *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package tudresden.ocl20.pivot.standardlibrary.java.internal.library;

import java.util.HashSet;
import java.util.Set;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclEnumLiteral;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceEnumerationLiteral;
import tudresden.ocl20.pivot.standardlibrary.java.factory.JavaStandardLibraryFactory;

/**
 * <p>
 * This class implements the OCL type {@link OclEnumLiteral} in Java.
 * </p>
 * 
 * @author Ronny Brandt
 * @author Michael Thiele
 */
public class JavaOclEnumLiteral extends JavaOclLibraryObject implements OclEnumLiteral {

	private IModelInstanceEnumerationLiteral imiEnumerationLiteral;
	
	/**
	 * <p>
	 * Instantiates a new {@link JavaOclEnumLiteral}.
	 * </p>
	 * 
	 * @param adaptee
	 *          The adapted element of this {@link JavaOclEnumLiteral}.
	 */
	public JavaOclEnumLiteral(
			IModelInstanceEnumerationLiteral imiEnumerationLiteral) {

		super(imiEnumerationLiteral);
		this.imiEnumerationLiteral = imiEnumerationLiteral;
	}

	public JavaOclEnumLiteral(String undefinedReason) {

		super(undefinedReason);
	}

	public JavaOclEnumLiteral(Throwable invalidReason) {

		super(invalidReason);
	}

	public OclBoolean isEqualTo(OclAny that) {

		OclBoolean result;
		
		checkUndefinedAndInvalid(this, that);
		
		if (that instanceof JavaOclEnumLiteral) {
			JavaOclEnumLiteral enumLiteral = (JavaOclEnumLiteral) that;
			boolean boolResult = imiEnumerationLiteral.equals(enumLiteral.imiEnumerationLiteral);
			result = JavaOclBoolean.getInstance(boolResult);
		} else {
			result = JavaOclBoolean.getInstance(false);
		}
		
		return result;
	}

	public <T extends OclAny> OclSet<T> asSet() {
	
		checkUndefinedAndInvalid(this);
	
		OclSet<T> result;
	
		Set<IModelInstanceElement> imiSet = new HashSet<IModelInstanceElement>();
		imiSet.add(imiEnumerationLiteral);
	
		result = JavaStandardLibraryFactory.INSTANCE.createOclSet(imiSet);
	
		return result;
	}

}