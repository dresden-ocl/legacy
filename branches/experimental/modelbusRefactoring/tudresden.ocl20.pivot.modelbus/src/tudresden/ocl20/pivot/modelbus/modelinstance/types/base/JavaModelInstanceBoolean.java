/*
Copyright (C) 2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Java Model Instance implementation of Dresden OCL2
for Eclipse.

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

import tudresden.ocl20.pivot.modelbus.IModel;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceBoolean;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.pivotmodel.PivotModelFactory;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveType;
import tudresden.ocl20.pivot.pivotmodel.PrimitiveTypeKind;
import tudresden.ocl20.pivot.pivotmodel.Type;

/**
 * <p>
 * Represents an adaptation for {@link Boolean}s of a {@link JavaModelInstance}.
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
public class JavaModelInstanceBoolean extends AbstractModelInstanceElement
		implements IModelInstanceBoolean {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER =
			ModelBusPlugin.getLogger(JavaModelInstanceBoolean.class);

	/**
	 * The {@link Type} of this {@link Type} implementation. Because
	 * {@link PrimitiveType}s are not part of the {@link IModel}, their
	 * {@link Type} must be created externally. This field represents the
	 * {@link PrimitiveType} instance that is the only {@link Type} of all
	 * {@link JavaModelInstanceBoolean}s.
	 */
	private static final PrimitiveType MODEL_TYPE =
			PivotModelFactory.INSTANCE.createPrimitiveType();
	{
		MODEL_TYPE.setKind(PrimitiveTypeKind.BOOLEAN);
	}

	/** The adapted {@link Boolean} of this {@link JavaModelInstanceBoolean}. */
	private Boolean myBoolean;

	/**
	 * <p>
	 * Creates a new {@link JavaModelInstanceBoolean}.
	 * </p>
	 * 
	 * @param aBoolean
	 *          The adapted {@link Boolean} of this
	 *          {@link JavaModelInstanceBoolean}.
	 */
	protected JavaModelInstanceBoolean(Boolean aBoolean) {

		/* Probably debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceBoolean("; //$NON-NLS-1$
			msg += "aBoolean = " + aBoolean; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.myBoolean = aBoolean;

		/* Initialize the type. */
		this.myTypes = new HashSet<Type>();
		this.myTypes.add(JavaModelInstanceBoolean.MODEL_TYPE);

		/* Probably debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceBoolean(Boolean) - exit"; //$NON-NLS-1$

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

		resultBuffer.append(this.getClass().getSimpleName());
		resultBuffer.append("[");
		resultBuffer.append(this.myBoolean.toString());
		resultBuffer.append("]");

		return resultBuffer.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #asType(tudresden.ocl20.pivot.pivotmodel.Type)
	 */
	public IModelInstanceElement asType(Type type) {

		IModelInstanceElement result;

		/*
		 * FIXME Claas: Ask Micha how the undefined problem can be solved. By
		 * default the result is null.
		 */
		result = null;

		/* Booleans can only be casted to primitive types. */
		if (type instanceof PrimitiveType) {
			PrimitiveType primitiveType;
			primitiveType = (PrimitiveType) type;

			/* Check the given PrimitiveTypeKind. */
			if (primitiveType.getKind().equals(PrimitiveTypeKind.BOOLEAN)) {

				/* Create a new boolean to avoid side effects. */
				result = new JavaModelInstanceBoolean(this.myBoolean);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.INTEGER)) {

				/* A boolean cannot be casted to an integer. The result is undefined. */
				result = new JavaModelInstanceInteger(null);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.REAL)) {

				/* A boolean cannot be casted to a real. The result is undefined. */
				result = new JavaModelInstanceReal(null);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.STRING)) {

				if (this.myBoolean == null) {
					result = new JavaModelInstanceString(null);
				}

				else {
					result = new JavaModelInstanceString(this.myBoolean.toString());
				}
			}

		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement
	 * #deepCopy()
	 */
	public Object copyForAtPre() {

		return new JavaModelInstanceBoolean(this.myBoolean);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceBoolean#getBoolean
	 * ()
	 */
	public Boolean getBoolean() {

		return this.myBoolean;
	}

	/*
	 * (non-Javadoc)
	 * @see tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement#isUndefined()
	 */
	public boolean isUndefined() {

		return (this.myBoolean == null);
	}
}