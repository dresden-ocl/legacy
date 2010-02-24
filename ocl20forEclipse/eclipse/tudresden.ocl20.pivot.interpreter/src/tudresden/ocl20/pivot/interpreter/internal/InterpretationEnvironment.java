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
package tudresden.ocl20.pivot.interpreter.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject;
import tudresden.ocl20.pivot.interpreter.IInterpretationEnvironment;
import tudresden.ocl20.pivot.interpreter.IOclInterpreter;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * This Environment is used to save data needed for interpretation.
 * </p>
 * 
 * @author Ronny Brandt.
 */
public class InterpretationEnvironment implements IInterpretationEnvironment {

	/** The global instance of the {@link InterpretationEnvironment}. */
	private static IInterpretationEnvironment GLOBAL;

	/** Cached results. */
	private HashMap<NamedElement, OclAny> cachedResults;

	/** the actual model instance. */
	protected IModelInstance modelInstance;

	/**
	 * Special values for postcondition constraints. Use
	 * {@link IModelInstanceElement}s as key instead of {@link OclAny}s to avoid
	 * 'Object schizophrenia'.
	 */
	protected HashMap<IModelInstanceElement, HashMap<OperationCallExp, OclAny>> postconditionValues;

	/** Saved constraints for body, def, initial and derive. */
	protected HashMap<String, Constraint> savedConstraints =
			new HashMap<String, Constraint>();;

	/**
	 * Saved instances of {@link Type}s existing before the current context's
	 * invocation (required for <code>oclIsNew()</code>).
	 */
	protected Map<Type, Set<IModelInstanceObject>> savedInstances =
			new WeakHashMap<Type, Set<IModelInstanceObject>>();

	/** Saved variables. */
	protected HashMap<String, OclAny> savedVariables =
			new HashMap<String, OclAny>();

	/**
	 * <p>
	 * Gets a new local {@link InterpretationEnvironment} which is a copy of the
	 * global {@link InterpretationEnvironment}.
	 * </p>
	 * 
	 * @return A new local {@link InterpretationEnvironment} which is a copy of
	 *         the global {@link InterpretationEnvironment}.
	 */
	public static IInterpretationEnvironment getNewLocalEnvironment() {

		return GLOBAL.clone();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#addConstraint(java.lang.
	 * String, tudresden.ocl20.pivot.pivotmodel.Constraint)
	 */
	public void addConstraint(String path, Constraint aConstraint) {

		this.savedConstraints.put(path, aConstraint);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#addVar(java.lang.String,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public void addVar(String path, OclAny oclRoot) {

		this.savedVariables.put(path, oclRoot);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#cacheResult(tudresden.ocl20.
	 * pivot.pivotmodel.NamedElement,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public void cacheResult(NamedElement aNamedElement, OclAny aResult) {

		if (this.cachedResults == null) {
			this.cachedResults = new HashMap<NamedElement, OclAny>();
		}
		// no else.

		this.cachedResults.put(aNamedElement, aResult);
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.interpreter.IEnvironment#clearCache()
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
	 * @seetudresden.ocl20.pivot.interpreter.IInterpretationEnvironment#
	 * clearPreparedConstraints ()
	 */
	public void clearPreparedConstraints() {

		this.savedConstraints.clear();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#getCachedResult(tudresden
	 * .ocl20 .pivot.pivotmodel.NamedElement)
	 */
	public OclAny getCachedResult(NamedElement aNamedElement) {

		OclAny result;

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
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#getConstraint(java.lang.
	 * String)
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
	 * @see tudresden.ocl20.pivot.interpreter.IEnvironment#getModelInstance()
	 */
	public IModelInstance getModelInstance() {

		return this.modelInstance;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#getPostconditionValue(tudresden
	 * .ocl20.pivot.essentialocl.expressions.OperationCallExp)
	 */
	public OclAny getPostconditionValue(OperationCallExp operationCallExp) {

		OclAny result;
		OclAny contextObject;

		result = null;

		/* Try to get the postcondition values for the current 'self' object. */
		if (this.postconditionValues != null) {
			HashMap<OperationCallExp, OclAny> objectSpecificValues;

			/* Get the object for which the value is stored. */
			contextObject = this.getVar(IOclInterpreter.SELF_VARIABLE_NAME);

			objectSpecificValues =
					this.postconditionValues.get(contextObject.getModelInstanceElement());

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
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#getVar(java.lang.String)
	 */
	public OclAny getVar(String path) {

		OclAny result;

		result = savedVariables.get(path);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IInterpretationEnvironment#isNewInstance
	 * (tudresden
	 * .ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject)
	 */
	public boolean isNewInstance(OclModelInstanceObject source) {

		boolean result;
		IModelInstanceObject imiObject;

		imiObject = (IModelInstanceObject) source.getModelInstanceElement();
		result = true;

		/*
		 * If any imiObject's type's instances contains the imiObject, return false.
		 * Else return true.
		 */
		if (this.savedInstances.containsKey(imiObject.getType())
				&& this.savedInstances.get(imiObject.getType()).contains(imiObject)) {
			result = false;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IInterpretationEnvironment#saveOldInstances
	 * (tudresden.ocl20.pivot.pivotmodel.Type)
	 */
	public void saveOldInstances(Type type) {

		this.savedInstances.put(type, this.modelInstance.getAllInstances(type));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#savePostconditionValue(tudresden
	 * .ocl20.pivot.essentialocl.expressions.OperationCallExp,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public void savePostconditionValue(OperationCallExp anOperationCallExp,
			OclAny aSource) {

		HashMap<OperationCallExp, OclAny> objectSpecificValues;
		OclAny contextObject;

		/* Check if the postcondition values have been initialized at all. */
		if (this.postconditionValues == null) {
			this.postconditionValues =
					new HashMap<IModelInstanceElement, HashMap<OperationCallExp, OclAny>>();
		}
		// no else.

		/* Get the object for which the value is stored. */
		contextObject = this.getVar(IOclInterpreter.SELF_VARIABLE_NAME);

		objectSpecificValues =
				this.postconditionValues.get(contextObject.getModelInstanceElement());

		/* Probably initialize the specific values. */
		if (objectSpecificValues == null) {
			objectSpecificValues = new HashMap<OperationCallExp, OclAny>();
		}
		// no else.

		/* Store the postcondition value. */
		objectSpecificValues.put(anOperationCallExp, aSource);

		/* Store the specific values. */
		this.postconditionValues.put(contextObject.getModelInstanceElement(),
				objectSpecificValues);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.interpreter.IEnvironment#setModelInstance(tudresden
	 * .ocl20 .pivot.modelbus.IModelInstance)
	 */
	public void setModelInstance(IModelInstance aModelInstance) {

		this.modelInstance = aModelInstance;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@SuppressWarnings("unchecked")
	public IInterpretationEnvironment clone() {

		InterpretationEnvironment result;

		result = new InterpretationEnvironment();

		result.modelInstance = this.modelInstance;
		result.postconditionValues = this.postconditionValues;
		result.savedConstraints = this.savedConstraints;

		/*
		 * The Map of variables must be cloned. Otherwise new declared variables are
		 * visible global.
		 */
		result.savedVariables =
				(HashMap<String, OclAny>) this.savedVariables.clone();

		result.cachedResults = this.cachedResults;

		result.savedInstances = this.savedInstances;

		return result;
	}
}