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

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclSet;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclString;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceBoolean;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelinstancetype.types.base.BasisJavaModelInstanceFactory;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.standardlibrary.java.factory.JavaStandardLibraryFactory;

/**
 * <p>
 * This class implements the OCL type {@link OclBoolean} in Java.
 * </p>
 * 
 * @author Ronny Brandt
 * @author Michael Thiele
 */
public class JavaOclBoolean extends JavaOclLibraryObject implements OclBoolean {

	/* The false instance. */
	protected final static OclBoolean FALSE = new JavaOclBoolean(
			BasisJavaModelInstanceFactory.createModelInstanceBoolean(false));

	/* The true instance. */
	protected final static OclBoolean TRUE = new JavaOclBoolean(
			BasisJavaModelInstanceFactory.createModelInstanceBoolean(true));

	protected final static OclString trueString = JavaStandardLibraryFactory.INSTANCE
			.createOclString("true");
	protected final static OclString falseString = JavaStandardLibraryFactory.INSTANCE
			.createOclString("false");

	/**
	 * <p>
	 * Instantiates a new {@link OclBoolean}.
	 * </p>
	 * 
	 * @param imiBoolean
	 *            the {@link IModelInstanceBoolean} to be adapted
	 */
	private JavaOclBoolean(IModelInstanceBoolean imiBoolean) {

		super(imiBoolean);
	}

	/**
	 * The constructors for invalid and undefined {@link OclBoolean}s have to
	 * create a new instance of {@link OclBoolean}, as they may have different
	 * invalid and undefined reasons.
	 */
	public JavaOclBoolean(String undefinedReason) {

		super(undefinedReason);
	}

	public JavaOclBoolean(Throwable invalidReason) {

		super(invalidReason);
	}

	/**
	 * <p>
	 * Gets the single instance of JavaOclBoolean which is true, or the other
	 * which is false depending on the given value.
	 * </p>
	 * 
	 * @param value
	 *            Specifies whether true or false shall be returned.
	 * 
	 * @return single instance of JavaOclBoolean
	 */
	public static OclBoolean getInstance(Boolean value) {

		OclBoolean result = null;

		if (value == null) {
			result = new JavaOclBoolean("The boolean value is undefined");
		}

		else if (value == true) {
			result = TRUE;
		}

		else {
			result = FALSE;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#and(tudresden
	 * .ocl20.pivot.essentialocl.standardlibrary.OclBoolean)
	 */
	public OclBoolean and(OclBoolean aBoolean) {

		OclBoolean result = null;

		// false AND anything is false!
		if (this.invalidReason == null && this.undefinedreason == null
				&& !this.isTrue())
			result = FALSE;

		// anything AND false is false!
		else if (aBoolean.getInvalidReason() == null
				&& aBoolean.getUndefinedReason() == null && !aBoolean.isTrue())
			result = FALSE;

		else {
			result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getOclBoolean(), this, aBoolean);

			if (result == null)
				result = checkUndefined("and", EssentialOclPlugin
						.getOclLibraryProvider().getOclLibrary()
						.getOclBoolean(), this, aBoolean);

			if (result == null) {
				result = getInstance(this.isTrue() && aBoolean.isTrue());
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#asSet()
	 */
	public <T extends OclAny> OclSet<T> asSet() {

		OclSet<T> result = null;

		result = checkInvalid(
				EssentialOclPlugin
						.getOclLibraryProvider()
						.getOclLibrary()
						.getSetType(
								EssentialOclPlugin.getOclLibraryProvider()
										.getOclLibrary().getOclBoolean()), this);

		if (result == null)
			result = checkAsSet(EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getOclBoolean());

		if (result == null) {

			Set<IModelInstanceElement> imiSet = new HashSet<IModelInstanceElement>();
			imiSet.add(getModelInstanceBoolean());
			result = JavaStandardLibraryFactory.INSTANCE.createOclSet(imiSet,
					EssentialOclPlugin.getOclLibraryProvider().getOclLibrary()
							.getOclBoolean());
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#convertToString
	 * ()
	 */
	public OclString convertToString() {

		OclString result;

		result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
				.getOclLibrary().getOclString(), this);

		if (result == null)
			result = checkUndefined("toString", EssentialOclPlugin
					.getOclLibraryProvider().getOclLibrary().getOclString(),
					this);

		if (result == null) {
			if (isTrue())
				result = trueString;
			else
				result = falseString;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seetudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#
	 * getModelInstanceBoolean()
	 */
	public IModelInstanceBoolean getModelInstanceBoolean() {

		return (IModelInstanceBoolean) imiElement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#ifThenElse
	 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny,
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public OclAny ifThenElse(OclAny thenStatement, OclAny elseStatement) {

		OclAny result = null;

		final Type type = thenStatement.getModelInstanceElement().getType();

		result = checkInvalid(type, this);

		if (result == null)
			result = checkUndefined("ifThenElse", type, this);

		if (result == null) {
			if (this.isTrue()) {
				result = thenStatement;
			}

			else {
				result = elseStatement;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#implies
	 * (tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean)
	 */
	public OclBoolean implies(OclBoolean that) {

		OclBoolean result = null;

		// see standard, p.16: False IMPLIES anything is True
		if (this.invalidReason == null && this.undefinedreason == null
				&& !this.isTrue())
			result = TRUE;

		// see standard, p.16: anything IMPLIES True is True
		else if (that.getInvalidReason() == null
				&& that.getUndefinedReason() == null && that.isTrue())
			result = TRUE;

		else {
			result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getOclBoolean(), this, that);

			if (result == null) {
				result = checkUndefined("implies", EssentialOclPlugin
						.getOclLibraryProvider().getOclLibrary()
						.getOclBoolean(), this, that);

				if (result == null) {
					if (this.isTrue() && !that.isTrue())
						result = FALSE;
					else
						result = TRUE;
				}
			}

		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny#isEqualTo(tudresden
	 * .ocl20.pivot.essentialocl.standardlibrary.OclAny)
	 */
	public OclBoolean isEqualTo(OclAny that) {

		OclBoolean result = null;

		result = checkIsEqualTo(that);

		if (result == null) {

			/* Check if the given Object is not a boolean. */
			if (!(that instanceof OclBoolean)) {
				result = FALSE;
			}

			else {
				OclBoolean aBoolean;

				aBoolean = (OclBoolean) that;

				if (this == aBoolean) {
					result = TRUE;
				}

				else {
					result = FALSE;
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#isTrue()
	 */
	public boolean isTrue() {

		if (undefinedreason != null)
			throw new UndefinedException(undefinedreason);

		else if (invalidReason != null)
			throw new InvalidException(invalidReason);

		else
			return getModelInstanceBoolean().getBoolean();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#not()
	 */
	public OclBoolean not() {

		OclBoolean result = null;

		result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
				.getOclLibrary().getOclBoolean(), this);

		if (result == null)
			result = checkUndefined("not", EssentialOclPlugin
					.getOclLibraryProvider().getOclLibrary().getOclBoolean(),
					this);

		if (result == null) {

			if (this.isTrue())
				result = FALSE;

			else
				result = TRUE;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#or(tudresden
	 * .ocl20.pivot.essentialocl.standardlibrary.OclBoolean)
	 */
	public OclBoolean or(OclBoolean that) {

		OclBoolean result = null;

		// see standard, p.16: True OR anything is True
		if (this.invalidReason == null && this.undefinedreason == null
				&& this.isTrue())
			result = TRUE;

		// anything OR True is True
		else if (that.getInvalidReason() == null
				&& that.getUndefinedReason() == null && that.isTrue())
			result = TRUE;

		else {

			result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
					.getOclLibrary().getOclBoolean(), this, that);

			if (result == null) {
				result = checkUndefined("or", EssentialOclPlugin
						.getOclLibraryProvider().getOclLibrary()
						.getOclBoolean(), this, that);

				if (result == null)
					result = getInstance(this.isTrue() || that.isTrue());
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean#xor(tudresden
	 * .ocl20.pivot.essentialocl.standardlibrary.OclBoolean)
	 */
	public OclBoolean xor(OclBoolean that) {

		OclBoolean result;

		result = checkInvalid(EssentialOclPlugin.getOclLibraryProvider()
				.getOclLibrary().getOclBoolean(), this, that);

		if (result == null)
			result = checkUndefined("xor", EssentialOclPlugin
					.getOclLibraryProvider().getOclLibrary().getOclBoolean(),
					this, that);

		if (result == null)
			result = this.isNotEqualTo(that);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
	
		StringBuilder result = new StringBuilder();
	
		result.append(this.getClass().getSimpleName());
		result.append("[");
	
		if (!toStringUndefinedOrInvalid(result))
			result.append(this.getModelInstanceBoolean().getBoolean()
					.toString());
	
		result.append("]");
	
		return result.toString();
	}
}