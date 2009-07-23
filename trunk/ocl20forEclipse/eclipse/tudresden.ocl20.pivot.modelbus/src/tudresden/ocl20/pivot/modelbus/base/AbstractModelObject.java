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
package tudresden.ocl20.pivot.modelbus.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot;
import tudresden.ocl20.pivot.modelbus.IModel;
import tudresden.ocl20.pivot.modelbus.IModelObject;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * An abstract implementation of {@link IModelObject}.
 * </p>
 * 
 * @author Ronny Brandt: Built the first version.
 * @author Claas Wilke: Did refactoring and added Javadoc.
 */
public abstract class AbstractModelObject implements IModelObject {

	/** The name of this {@link IModelObject}. */
	protected String myName;

	/** The {@link OclRoot} object of this {@link IModelObject}. */
	protected OclRoot myOclObject;

	/** The results are mapped to constraints. */
	protected Map<Constraint, OclRoot> myResults =
			new HashMap<Constraint, OclRoot>();

	/**
	 * The {@link Type}s of the {@link IModel} of which this IModelObject is an
	 * instance.
	 */
	protected Type[] myTypes;

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#addResult(tudresden.ocl20
	 * .pivot.pivotmodel.Constraint,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public void addResult(Constraint aConstraint, OclRoot aResult) {

		this.myResults.put(aConstraint, aResult);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#clearResults()
	 */
	public boolean clearResults() {

		boolean result;

		/* Eventually clear the results map. */
		if (this.myResults != null) {

			this.myResults.clear();

			result = true;
		}

		else {
			result = false;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#getName()
	 */
	public String getName() {

		StringBuffer result;

		/* Construct a name of all implemented types. */
		result = new StringBuffer();
		result.append("[");

		for (Type aType : this.getTypes()) {

			if (result.length() == 1) {
				result.append(",");
			}
			// no else.

			result.append(aType.getName());
		}

		result.append("]");

		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#getQualifiedName()
	 */
	public String getQualifiedName() {

		StringBuffer result;

		/* Construct a name of all implemented types. */
		result = new StringBuffer();
		result.append("[");

		for (Type aType : this.getTypes()) {

			if (result.length() == 1) {
				result.append(",");
			}
			// no else.

			result.append(aType.getName());
		}

		result.append("]");

		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#getResults()
	 */
	public Map<Constraint, OclRoot> getResults() {

		return this.myResults;
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.IModelObject#getTypes()
	 */
	public Set<Type> getTypes() {

		List<Type> types;

		/* Get all types. */
		types = new ArrayList<Type>(Arrays.asList(this.myTypes));

		/* Sort the types. */
		Collections.sort(types, new Comparator<Type>() {

			public int compare(Type type1, Type type2) {

				return type1.getQualifiedName().compareTo(type2.getQualifiedName());
			}
		});

		return new HashSet<Type>(types);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.IModelObject#isInstanceOf(tudresden.ocl20
	 * .pivot.pivotmodel.Type)
	 */
	public boolean isInstanceOf(Type type) {

		boolean result;

		result = false;

		for (Type aType : this.myTypes) {

			if (aType.conformsTo(type)) {
				result = true;
				break;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.IModelObject#removeResult(tudresden.ocl20
	 * .pivot.pivotmodel.Constraint)
	 */
	public boolean removeResult(Constraint cs) {

		if (myResults != null) {
			myResults.remove(cs);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();
}