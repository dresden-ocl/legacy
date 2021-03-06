/*
Copyright (C) 2009 by Claas Wilke (claaswilke@gmx.net).

This file is part of the Model Bus GUI of Dresden OCL2 for Eclipse.

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
package tudresden.ocl20.pivot.modelbus.ui.internal.wizards.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import tudresden.ocl20.pivot.model.metamodel.IMetamodel;
import tudresden.ocl20.pivot.modelbus.metamodel.IMetamodelDescriptor;

/**
 * <p>
 * A {@link LabelProvider} to display {@link IMetamodel}s.
 * </p>
 */
public class MetaModelLabelProvider extends LabelProvider implements
		ILabelProvider {

	/** A helper object to manage associated icons. */
	private ResourceManager resources;

	/**
	 * <p>
	 * Creates a new {@link MetaModelLabelProvider}.
	 * </p>
	 */
	public MetaModelLabelProvider() {

		this.resources = new LocalResourceManager(JFaceResources.getResources());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		this.resources.dispose();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		Image result;

		/*
		 * Check if the meta model has been added and configured via the metamodels
		 * extension point.
		 */
		if (element instanceof IMetamodelDescriptor) {
			IMetamodelDescriptor metamodel;

			metamodel = (IMetamodelDescriptor) element;

			ImageDescriptor imageDescriptor;
			imageDescriptor =
					ImageDescriptor.createFromURL(((IMetamodelDescriptor) metamodel)
							.getIconURL());

			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			// no else.

			result = this.resources.createImage(imageDescriptor);
		}

		else {
			result = null;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		IMetamodel metamodel;

		metamodel = (IMetamodel) element;

		return metamodel.getName();
	}
}