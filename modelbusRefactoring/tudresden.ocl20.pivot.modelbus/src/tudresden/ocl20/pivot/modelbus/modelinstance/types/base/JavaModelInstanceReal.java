/*
Copyright (C) 2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Model Bus Plug-in of Dresden OCL2 for Eclipse.

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
package tudresden.ocl20.pivot.modelbus.modelinstance.types.base;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.osgi.util.NLS;

import tudresden.ocl20.pivot.modelbus.IModel;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.modelbus.internal.ModelBusMessages;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.AsTypeCastException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceReal;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * Represents an adaptation for {@link Float}s of a {@link JavaModelInstance}.
 * </p>
 * 
 * <p>
 * This type is located in the ModelBus plug-in because the standard library and
 * the Java model instance type plug-in both require such an implementation but
 * are not allowed to know each other.
 * </p>
 * 
 * @author Claas Wilke
 */
public class JavaModelInstanceReal extends AbstractModelInstanceElement
		implements IModelInstanceReal {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER =
			ModelBusPlugin.getLogger(JavaModelInstanceReal.class);

	/**
	 * The {@link Type} of this {@link Type} implementation. Because
	 * {@link PrimitiveType}s are not part of the {@link IModel}, their
	 * {@link Type} must be created externally. This field represents the
	 * {@link PrimitiveType} instance that is the only {@link Type} of all
	 * {@link JavaModelInstanceReal}s.
	 */
	private static final PrimitiveType MODEL_TYPE =
			PivotModelFactory.INSTANCE.createPrimitiveType();
	{
		MODEL_TYPE.setKind(PrimitiveTypeKind.REAL);
		MODEL_TYPE.setName(PrimitiveTypeKind.REAL.toString());
	}

	/** The adapted {@link Number} of this {@link JavaModelInstanceReal}. */
	private Number myNumber;

	/**
	 * <p>
	 * Creates a new {@link JavaModelInstanceReal}.
	 * </p>
	 * 
	 * @param number
	 *          The {@link Number} that shall be adapted by this
	 *          {@link JavaModelInstanceReal}.
	 */
	protected JavaModelInstanceReal(Number number) {

		/* Eventually debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceReal("; //$NON-NLS-1$
			msg += "number = " + number; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.myNumber = number;

		/* Initialize the type. */
		this.myTypes = new HashSet<Type>();
		this.myTypes.add(JavaModelInstanceReal.MODEL_TYPE);

		/* Eventually debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceReal(Number) - exit"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * @seetudresden.ocl20.pivot.modelbus.modelinstance.types.impl.
	 * AbstractModelInstanceElement#getName()
	 */
	public String getName() {

		StringBuffer resultBuffer;
		resultBuffer = new StringBuffer();

		resultBuffer.append(JavaModelInstanceReal.class.getSimpleName());
		resultBuffer.append("[");
		resultBuffer.append(this.myNumber);
		resultBuffer.append("]");

		return resultBuffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #asType(tudresden.ocl20.pivot.pivotmodel.Type)
	 */
	public IModelInstanceElement asType(Type type) throws AsTypeCastException {

		IModelInstanceElement result;

		/* By default the result is null. */
		result = null;

		/* Reals can only be casted to primitive types. */
		if (type instanceof PrimitiveType) {
			PrimitiveType primitiveType;
			primitiveType = (PrimitiveType) type;

			/* Check the given PrimitiveTypeKind. */
			if (primitiveType.getKind().equals(PrimitiveTypeKind.INTEGER)) {

				/* Create a new integer to avoid side effects. */
				result = new JavaModelInstanceInteger(this.myNumber.longValue());
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.REAL)) {

				/* Each integer is also a real. */
				result = new JavaModelInstanceReal(this.myNumber);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.STRING)) {

				if (this.myNumber == null) {
					result = new JavaModelInstanceString(null);
				}

				else {
					result = new JavaModelInstanceString(this.myNumber.toString());
				}
			}
			// no else.
		}
		// no else.

		/* Probably throw an AsTypeCastException. */
		if (result == null) {
			String msg;

			msg = ModelBusMessages.IModelInstanceElement_CannotCast;
			msg = NLS.bind(msg, this.getName(), type.getName());

			throw new AsTypeCastException(msg);
		}
		// no else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #deepCopy()
	 */
	public Object copyForAtPre() {

		return new JavaModelInstanceReal(this.myNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceReal#getReal()
	 */
	public Double getDouble() {

		Double result;

		if (this.myNumber != null) {
			result = this.myNumber.doubleValue();
		}

		else {
			result = null;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #isUndefined()
	 */
	public boolean isUndefined() {

		return (this.myNumber == null);
	}
}