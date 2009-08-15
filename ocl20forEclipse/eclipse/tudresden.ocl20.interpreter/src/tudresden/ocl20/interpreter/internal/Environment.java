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
package tudresden.ocl20.interpreter.internal;

import java.util.HashMap;

import tudresden.ocl20.interpreter.IEnvironment;
import tudresden.ocl20.interpreter.IOclInterpreter;
import tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot;
import tudresden.ocl20.pivot.modelbus.IModelInstance;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;

/**
 * <p>
 * This Environment is used to save data needed for interpretation.
 * </p>
 * 
 * @author Ronny Brandt.
 */
public class Environment implements IEnvironment {

	/** The global instance of the {@link Environment}. */
	private static IEnvironment GLOBAL;

	/** Cached results. */
	private HashMap<NamedElement, OclRoot> cachedResults;

	/** the actual model instance. */
	protected IModelInstance modelInstance;

	/** Special values for postcondition constraints. */
	protected HashMap<Object, HashMap<OperationCallExp, OclRoot>> postconditionValues;

	/** Saved constraints for body, def, initial and derive. */
	protected HashMap<String, Constraint> savedConstraints;

	/** Saved variables. */
	protected HashMap<String, OclRoot> savedVariables =
			new HashMap<String, OclRoot>();

	/**
	 * <p>
	 * Gets a new local {@link Environment} which is a copy of the global
	 * {@link Environment}.
	 * </p>
	 * 
	 * @return A new local {@link Environment} which is a copy of the global
	 *         {@link Environment}.
	 */
	public static IEnvironment getNewLocalEnvironment() {

		return GLOBAL.clone();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#addConstraint(java.lang.String,
	 * tudresden.ocl20.pivot.pivotmodel.Constraint)
	 */
	public void addConstraint(String path, Constraint aConstraint) {

		if (this.savedConstraints == null) {
			this.savedConstraints = new HashMap<String, Constraint>();
		}

		this.savedConstraints.put(path, aConstraint);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.interpreter.IEnvironment#addVar(java.lang.String,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public void addVar(String path, OclRoot oclRoot) {

		this.savedVariables.put(path, oclRoot);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.interpreter.IEnvironment#cacheResult(tudresden.ocl20.
	 * pivot.pivotmodel.NamedElement,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public void cacheResult(NamedElement aNamedElement, OclRoot aResult) {

		if (this.cachedResults == null) {
			this.cachedResults = new HashMap<NamedElement, OclRoot>();
		}
		// no else.

		this.cachedResults.put(aNamedElement, aResult);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.interpreter.IEnvironment#clearCache()
	 */
	public void clearCache() {

		if (this.cachedResults != null) {

			this.cachedResults.clear();
			this.cachedResults = null;
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#getCachedResult(tudresden.ocl20
	 * .pivot.pivotmodel.NamedElement)
	 */
	public OclRoot getCachedResult(NamedElement aNamedElement) {

		OclRoot result;

		if (this.cachedResults != null) {
			result = cachedResults.get(aNamedElement);
		}

		else {
			result = null;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#getConstraint(java.lang.String)
	 */
	public Constraint getConstraint(String path) {

		Constraint result;

		if (this.savedConstraints != null) {
			result = this.savedConstraints.get(path);
		}

		else {
			result = null;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.interpreter.IEnvironment#getModelInstance()
	 */
	public IModelInstance getModelInstance() {

		return this.modelInstance;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#getPostconditionValue(tudresden
	 * .ocl20.pivot.essentialocl.expressions.OperationCallExp)
	 */
	public OclRoot getPostconditionValue(OperationCallExp operationCallExp) {

		OclRoot result;
		Object selfObject;

		result = null;
		
		/* Try to get the postcondition values for the current 'self' object. */
		if (this.postconditionValues != null) {
			HashMap<OperationCallExp, OclRoot> objectSpecificValues;

			/* Get the object for which the value is stored. */
			selfObject = this.getVar(IOclInterpreter.SELF_VARIABLE_NAME).getAdaptee();

			/* If the adapted object is null, use the adaptation IModelObject instead. */
			if (selfObject == null) {
				this.getVar(IOclInterpreter.SELF_VARIABLE_NAME);
			}
			// no else.

			objectSpecificValues = this.postconditionValues.get(selfObject);

			if (objectSpecificValues != null) {
				/* Try to get the value for the given expression. */
				result = objectSpecificValues.get(operationCallExp);
			}
			// no else.
		}
		// no else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.interpreter.IEnvironment#getVar(java.lang.String)
	 */
	public OclRoot getVar(String path) {

		OclRoot result;

		result = savedVariables.get(path);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#savePostconditionValue(tudresden
	 * .ocl20.pivot.essentialocl.expressions.OperationCallExp,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclRoot)
	 */
	public void savePostconditionValue(OperationCallExp anOperationCallExp,
			OclRoot aSource) {

		HashMap<OperationCallExp, OclRoot> objectSpecificValues;
		Object selfObject;

		/* Check if the postcondition values have been initialized at all. */
		if (this.postconditionValues == null) {
			this.postconditionValues =
					new HashMap<Object, HashMap<OperationCallExp, OclRoot>>();
		}
		// no else.

		/* Get the object for which the value is stored. */
		selfObject = this.getVar(IOclInterpreter.SELF_VARIABLE_NAME).getAdaptee();

		/* If the adapted object is null, use the adaptation IModelObject instead. */
		if (selfObject == null) {
			this.getVar(IOclInterpreter.SELF_VARIABLE_NAME);
		}
		// no else.

		objectSpecificValues = this.postconditionValues.get(selfObject);

		/* Eventually initialize the specific values. */
		if (objectSpecificValues == null) {
			objectSpecificValues = new HashMap<OperationCallExp, OclRoot>();
		}
		// no else.

		/* Store the postcondition value. */
		objectSpecificValues.put(anOperationCallExp, aSource);

		/* Store the specific values. */
		this.postconditionValues.put(selfObject, objectSpecificValues);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.interpreter.IEnvironment#setModelInstance(tudresden.ocl20
	 * .pivot.modelbus.IModelInstance)
	 */
	public void setModelInstance(IModelInstance aModelInstance) {

		this.modelInstance = aModelInstance;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@SuppressWarnings("unchecked")
	public IEnvironment clone() {

		Environment result;

		result = new Environment();

		result.modelInstance = this.modelInstance;
		result.postconditionValues = this.postconditionValues;
		result.savedConstraints = this.savedConstraints;

		/*
		 * The Map of variables must be cloned. Otherwise new declared variables are
		 * visible global.
		 */
		result.savedVariables =
				(HashMap<String, OclRoot>) this.savedVariables.clone();

		result.cachedResults = this.cachedResults;

		return result;
	}
}
