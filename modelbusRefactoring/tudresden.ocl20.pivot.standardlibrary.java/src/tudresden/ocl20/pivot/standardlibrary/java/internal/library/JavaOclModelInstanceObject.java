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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.OperationNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyAccessException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.PropertyNotFoundException;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.standardlibrary.java.exceptions.InvalidException;
import tudresden.ocl20.pivot.standardlibrary.java.factory.JavaStandardLibraryFactory;

/**
 * <p>
 * This class implements the OCL type {@link OclModelInstanceObject} in Java.
 * </p>
 * 
 * @author Ronny Brandt
 * @author Michael Thiele
 */
public class JavaOclModelInstanceObject extends JavaOclAny implements
		OclModelInstanceObject {

	private IModelInstanceObject imiObject;

	/**
	 * <p>
	 * Instantiates a new {@link JavaOclObject}.
	 * </p>
	 * 
	 * @param adaptee
	 *          The adapted model instance object.
	 */
	public JavaOclModelInstanceObject(IModelInstanceObject imiObject) {

		super(imiObject);
		this.imiObject = imiObject;
	}
	
	public JavaOclModelInstanceObject(String undefinedReason) {
		super(undefinedReason);
	}
	
	public JavaOclModelInstanceObject(Throwable invalidReason) {
		super(invalidReason);
	}

	public OclAny getProperty(Property property) {

		OclAny result;

		checkUndefinedAndInvalid(this);

		IModelInstanceElement imiResult;
		try {
			imiResult = imiObject.getProperty(property);
		} catch (PropertyNotFoundException e) {

			throw new InvalidException(e);
		} catch (PropertyAccessException e) {

			throw new InvalidException(e);
		}

		result = JavaStandardLibraryFactory.INSTANCE.createOclAny(imiResult);

		return result;
	}

	public OclAny invokeOperation(Operation operation, OclAny... args) {

		OclAny result;

		checkUndefinedAndInvalid(this);
		checkUndefinedAndInvalid(args);

		List<IModelInstanceElement> imiArgs =
				new LinkedList<IModelInstanceElement>();
		for (OclAny arg : args) {
			imiArgs.add(arg.getModelInstanceElement());
		}

		IModelInstanceElement imiResult;
		try {
			imiResult = imiObject.invokeOperation(operation, imiArgs);
		} catch (OperationNotFoundException e) {

			throw new InvalidException(e);
		} catch (OperationAccessException e) {

			throw new InvalidException(e);
		}

		result = JavaStandardLibraryFactory.INSTANCE.createOclAny(imiResult);

		return result;
	}

	@SuppressWarnings("unchecked")
	public OclSet<OclModelInstanceObject> asSet() {

		OclSet<OclModelInstanceObject> result;

		checkUndefinedAndInvalid(this);

		Set<IModelInstanceObject> resultSet = new HashSet<IModelInstanceObject>();
		resultSet.add(this.imiObject);

		try {
			result = JavaStandardLibraryFactory.INSTANCE.createOclSet(resultSet);
		} catch (TypeNotFoundInModelException e) {
			// TODO Michael: can this happen?
			throw new InvalidException(e);
		}

		return result;

	}

	public OclBoolean isEqualTo(OclAny that) {

		OclBoolean result;

		checkUndefinedAndInvalid(this, that);

		if (!(that instanceof OclModelInstanceObject)) {
			result = JavaOclBoolean.getInstance(false);
		}

		else {
			Object thatObject =
					((IModelInstanceObject) that.getModelInstanceElement()).getObject();

			if (imiObject.getObject().equals(thatObject)) {
				result = JavaOclBoolean.getInstance(true);
			}
			else {
				result = JavaOclBoolean.getInstance(false);
			}
		}

		return result;
	}

}