/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
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
 *
 * $Id$
 */
package tudresden.ocl20.pivot.modelbus;

import tudresden.ocl20.pivot.modelbus.event.IModelRegistryListener;


/**
 * An <code>IModelRegistry</code> manages a list of {@link IModel} references.
 *
 * @author Matthias Braeuer
 * @version 1.0 30.03.2007
 */
public interface IModelRegistry {

  /**
   * Returns all {@link IModel models} registered with this <code>IModelRegistry</code>.
   * 
   * @return an array of <code>IModel</code> instances
   */
  IModel[] getModels();
  
  /**
   * Adds a {@link IModel model} to this <code>IModelRegistry</code>. If the model registry was
   * empty, this becomes the active model.
   * 
   * @param model the model
   * 
   * @see #setActiveModel(IModel)
   */
  void addModel(IModel model);
  
  /**
   * Sets the given model as the active model in the <code>IModelRegistry</code>. This allows
   * to update visual representations of the registry to be updated independently.
   * 
   * @param model the new active model
   */
  void setActiveModel(IModel model);
  
  /**
   * Returns the currently active model in the model registry. If there are no models in the
   * model registry, <code>null</code> is returned.
   * 
   * @return a <code>IModel</code> instance or <code>null</code>
   */
  IModel getActiveModel();
  
  /**
   * Disposes the registry.
   */
  void dispose();
  
  /**
   * Adds an {@link IModelRegistryListener} to this model registry.
   * 
   * @param listener the listener
   */
  void addModelRegistryListener(IModelRegistryListener listener);
  
  /**
   * Removes an {@link IModelRegistryListener} from this model registry.
   * 
   * @param listener the listener
   */
  void removeModelRegistryListener(IModelRegistryListener listener);
  
}
