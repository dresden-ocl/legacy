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
package tudresden.ocl20.pivot.modelbus.event;

import java.util.EventObject;

import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceRegistry;
import tudresden.ocl20.pivot.modelbus.modelinstance.internal.ModelInstanceRegistry;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;

/**
 * <p>
 * Represents events fired by the {@link ModelInstanceRegistry} if a new
 * {@link IModelInstance} is added or removed.
 * </p>
 * 
 * @author Ronny Brandt
 */
public class ModelInstanceRegistryEvent extends EventObject {

	/** Generated serial id. */
	private static final long serialVersionUID = -2515705247138459585L;

	/** The affected {@link IModelInstance}. */
	private IModelInstance affectedModelInstance;

	/**
	 * <p>
	 * Instantiates a new {@link ModelInstanceRegistryEvent}.
	 * </p>
	 * 
	 * @param source
	 *          The {@link IModelInstanceRegistry} this event belongs to.
	 * @param affectedModelInstance
	 *          The affected {@link IModelInstance}.
	 */
	public ModelInstanceRegistryEvent(IModelInstanceRegistry source,
			IModelInstance affectedModelInstance) {

		super(source);
		this.affectedModelInstance = affectedModelInstance;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	public IModelInstanceRegistry getSource() {

		return (IModelInstanceRegistry) super.getSource();
	}

	/**
	 * <p>
	 * Gets the affected {@link IModelInstance}.
	 * </p>
	 * 
	 * @return The affected {@link IModelInstance}.
	 */
	public IModelInstance getAffectedModelInstance() {

		return this.affectedModelInstance;
	}

	/**
	 * <p>
	 * Gets the {@link IModelInstanceRegistry}.
	 * </p>
	 * 
	 * @return The {@link IModelInstanceRegistry}.
	 */
	public IModelInstanceRegistry getModelInstanceRegistry() {

		return this.getSource();
	}
}