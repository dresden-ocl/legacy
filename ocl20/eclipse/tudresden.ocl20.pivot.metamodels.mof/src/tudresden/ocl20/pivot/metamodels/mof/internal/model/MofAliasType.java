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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tudresden.ocl20.core.jmi.mof14.model.AliasType;
import tudresden.ocl20.core.jmi.mof14.model.Classifier;
import tudresden.ocl20.core.jmi.mof14.model.ModelElement;
import tudresden.ocl20.core.jmi.mof14.model.MofPackage;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.base.AbstractType;

/**
 * An implementation of the Pivot Model {@link Type} concept for
 * AliasType of MOF metamodel in MDR.
 * 
 * @author Ronny Brandt
 * @version 1.0 09.05.2007
 */
public class MofAliasType extends AbstractType implements Type {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MofAliasType.class);

	// the adapted MOF alias type
	private AliasType aliasType;
	
	/**
	 * Creates a new <code>MofAliasType</code> instance.
	 * 
	 * @param aliasType the MOF {@link AliasType} adapted by this class
	 */
	public MofAliasType(AliasType aliasType) {
		if (logger.isDebugEnabled()) {
			logger.debug("MofAliasType(AliasType aliasType=" + aliasType
					+ ") - enter");
		}

		this.aliasType = aliasType;

		if (logger.isDebugEnabled()) {
			logger.debug("MofAliasType(AliasType) - exit");
		}
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractType#getName()
	 */
	@Override
	public String getName() {
		if (logger.isDebugEnabled()) {
			logger.debug("getName() - enter");
		}

		String returnString = aliasType.getName();
		if (logger.isDebugEnabled()) {
			logger.debug("getName() - exit - return value=" + returnString);
		}
		return returnString;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractType#getNamespace()
	 */
	@Override
	public Namespace getNamespace() {
		if (logger.isDebugEnabled()) {
			logger.debug("getNamespace() - enter");
		}

		Namespace returnNamespace = MofAdapterFactory.INSTANCE
				.createNamespace((MofPackage) aliasType.getContainer());
		if (logger.isDebugEnabled()) {
			logger.debug("getNamespace() - exit - return value=" + returnNamespace);
		}
		return returnNamespace;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractType#getOwnedOperationImpl()
	 */
	@Override
	protected List<Operation> getOwnedOperationImpl() {
		if (logger.isDebugEnabled()) {
			logger.debug("getOwnedOperationImpl() - enter");
		}

		List<Operation> returnList = new ArrayList<Operation>();
		if (logger.isDebugEnabled()) {
			logger.debug("getOwnedOperationImpl() - exit - return value="
					+ returnList);
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractType#getOwnedPropertyImpl()
	 */
	@Override
	protected List<Property> getOwnedPropertyImpl() {
		if (logger.isDebugEnabled()) {
			logger.debug("getOwnedPropertyImpl() - enter");
		}

		List<Property> returnList = new ArrayList<Property>();
		if (logger.isDebugEnabled()) {
			logger
					.debug("getOwnedPropertyImpl() - exit - return value=" + returnList);
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see tudresden.ocl20.pivot.pivotmodel.base.AbstractType#getSuperTypeImpl()
	 */
	@Override
	protected List<Type> getSuperTypeImpl() {
		if (logger.isDebugEnabled()) {
			logger.debug("getSuperTypeImpl() - enter");
		}

		List<Type> superType = new ArrayList<Type>();
		
		Iterator<ModelElement> it = aliasType.allSupertypes().iterator();
		
		while(it.hasNext()) {
			ModelElement me = it.next();
			if (me instanceof Classifier)
				superType.add(MofAdapterFactory.INSTANCE.createType((Classifier)me));
		}
		

		if (logger.isDebugEnabled()) {
			logger.debug("getSuperTypeImpl() - exit - return value=" + superType);
		}
		return superType;
	}

}
