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
package tudresden.ocl20.pivot.modelbus.ui.internal.views.util;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceElement;
import tudresden.ocl20.pivot.modelbus.ui.ModelBusUIPlugin;
import tudresden.ocl20.pivot.modelbus.ui.internal.views.ModelInstancesView;

/**
 * <p>
 * The {@link ModelObjectLabelProvider} is used by the
 * {@link ModelInstancesView} to display {@link IModelInstanceElement}s.
 * </p>
 * 
 * @author Claas Wilke
 */
public class ModelObjectLabelProvider extends LabelProvider {

	private final static String ICON_TYPE = "icons/type.gif";
	private final static String ICON_OBJECT = "icons/object.gif";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public String getText(Object anObject) {

		String result;

		if (anObject instanceof IModelInstance) {
			result = ((IModelInstance) anObject).getDisplayName();
		}

		else if (anObject instanceof IModelInstanceElement) {
			result = ((IModelInstanceElement) anObject).toString();
		}

		else if (anObject instanceof List) {

			List<String> aList;
			String label;

			aList = (List<String>) anObject;
			label = null;

			/* Compute the label from the given package path. */
			for (String anElement : aList) {

				if (label == null) {
					label = anElement;
				}

				else {
					label = label + "::" + anElement;
				}
			}
			result = label;
		}

		else {
			result = null;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object anObject) {

		Image result;

		/* Types are represented by a list of their name. */
		if (anObject instanceof List) {
			result = ModelBusUIPlugin.getImageDescriptor(ICON_TYPE)
					.createImage();
		}

		else if (anObject instanceof IModelInstanceElement) {
			result = ModelBusUIPlugin.getImageDescriptor(ICON_OBJECT)
					.createImage();
		}

		else {
			result = null;
		}

		return result;
	}
}