/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Ronny Brandt (Ronny_Brandt@web.de).            *
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
package tudresden.ocl20.pivot.metamodels.mof.internal.model;

import org.apache.log4j.Logger;

import tudresden.ocl20.core.jmi.mof14.model.Attribute;
import tudresden.ocl20.core.jmi.mof14.model.Classifier;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty;

/**
 * An implementation of the Pivot Model {@link Property} concept for
 * MOF metamodel in MDR.
 * 
 * @author Ronny Brandt
 * @version 1.0 09.05.2007
 */
public class MofProperty extends AbstractProperty implements Property {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MofProperty.class);

	// the adapted MOF attribute
	private Attribute attribute;
	
	/**
	 * Creates a new <code>MofProperty</code> instance.
	 * 
	 * @param attribute the MOF {@link Attribute} adapted by this class
	 */
	public MofProperty(Attribute attribute) {
		if (logger.isDebugEnabled()) {
			logger
					.debug("MofProperty(Attribute attribute=" + attribute + ") - enter");
		}

		this.attribute = attribute;

		if (logger.isDebugEnabled()) {
			logger.debug("MofProperty(Attribute) - exit");
		}
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty#getName()
	 */
	@Override
	public String getName() {
		if (logger.isDebugEnabled()) {
			logger.debug("getName() - enter");
		}

		String returnString = attribute.getName();
		if (logger.isDebugEnabled()) {
			logger.debug("getName() - exit - return value=" + returnString);
		}
		return returnString;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty#getOwningType()
	 */
	@Override
	public Type getOwningType() {
		if (logger.isDebugEnabled()) {
			logger.debug("getOwningType() - enter");
		}

		Type returnType = MofAdapterFactory.INSTANCE
				.createType((Classifier) attribute.getContainer());
		if (logger.isDebugEnabled()) {
			logger.debug("getOwningType() - exit - return value=" + returnType);
		}
		return returnType;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractProperty#getType()
	 */
	@Override
	public Type getType() {
		if (logger.isDebugEnabled()) {
			logger.debug("getType() - enter");
		}

		Type returnType = MofAdapterFactory.INSTANCE
				.createType(attribute.getType());
		if (logger.isDebugEnabled()) {
			logger.debug("getType() - exit - return value=" + returnType);
		}
		return returnType;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.impl.FeatureImpl#isStatic()
	 */
	public boolean isStatic() {
		if (logger.isDebugEnabled()) {
			logger.debug("isStatic() - enter");
		}

		boolean returnboolean = !attribute.isInstanceLevelA();
		if (logger.isDebugEnabled()) {
			logger.debug("isStatic() - exit - return value=" + returnboolean);
		}
		return returnboolean;
	}
	
	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.impl.PropertyImpl#isUnique()
	 */
	public boolean isUnique() {
		if (logger.isDebugEnabled()) {
			logger.debug("isUnique() - enter");
		}

		boolean returnboolean = attribute.isUniqueA();
		if (logger.isDebugEnabled()) {
			logger.debug("isUnique() - exit - return value=" + returnboolean);
		}
		return returnboolean;
	}
	
	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.impl.PropertyImpl#isMultiple()
	 */
	public boolean isMultiple() {
		if (logger.isDebugEnabled()) {
			logger.debug("isMultiple() - enter");
		}

		boolean returnboolean = attribute.isMultipleA();
		if (logger.isDebugEnabled()) {
			logger.debug("isMultiple() - exit - return value=" + returnboolean);
		}
		return returnboolean;
	}
	
	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.impl.PropertyImpl#isOrdered()
	 */
	public boolean isOrdered() {
		if (logger.isDebugEnabled()) {
			logger.debug("isOrdered() - enter");
		}

		boolean returnboolean = attribute.isOrderedA();
		if (logger.isDebugEnabled()) {
			logger.debug("isOrdered() - exit - return value=" + returnboolean);
		}
		return returnboolean;
	}
}