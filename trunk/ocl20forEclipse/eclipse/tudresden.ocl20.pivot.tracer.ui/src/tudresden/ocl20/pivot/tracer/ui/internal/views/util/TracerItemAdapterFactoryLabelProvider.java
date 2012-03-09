/*
Copyright (C) 2011 by Lars Sch�tze (lschuetze@gmx.net)

This file is part of the OCL 2 Interpreter of Dresden OCL2 for Eclipse.

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
package tudresden.ocl20.pivot.tracer.ui.internal.views.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclInteger;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclInvalid;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclModelInstanceObject;
import tudresden.ocl20.pivot.interpreter.ui.InterpreterUIPlugin;
import tudresden.ocl20.pivot.tracer.tracermodel.TracerItem;

/**
 * 
 * @author Lars Sch�tze
 * 
 */
public class TracerItemAdapterFactoryLabelProvider extends
		AdapterFactoryLabelProvider {

	private static final String IMG_RESULT_UNDEFINED =
			"icons/result_undefined.gif";
	private static final String IMG_RESULT_INVALID = "icons/result_invalid.gif";
	private static final String IMG_RESULT_TRUE = "icons/result_true.gif";
	private static final String IMG_RESULT_FALSE = "icons/result_false.gif";

	private TracerExpressionsSwitch tracerExprSwitch;
	private Map<ImageDescriptor, Image> imageCache;

	public TracerItemAdapterFactoryLabelProvider(AdapterFactory adapterFactory) {

		super(adapterFactory);
		tracerExprSwitch = new TracerExpressionsSwitch();
		imageCache = new HashMap<ImageDescriptor, Image>();
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		TracerItem item;
		if (element instanceof TracerItem) {
			item = (TracerItem) element;
			// check if the item has been fully build
			//
			if ((item.getExpression() == null) && (item.getResult() == null)) {
				return null;
			}

			switch (columnIndex) {
			case 0:
				return tracerExprSwitch.doSwitch(item.getExpression());
			case 1:
				return resultText(item.getResult());
			default:
				return super.getColumnText(element, columnIndex);
			}
		}
		else
			return super.getColumnText(element, columnIndex);
	}

	@Override
	public Image getColumnImage(Object object, int columnIndex) {

		if (columnIndex != 0) {

			return super.getColumnImage(object, columnIndex);
		}

		if (object instanceof TracerItem) {

			OclAny result = ((TracerItem) object).getResult();

			ImageDescriptor imageDescriptor = null;

			if (result instanceof OclBoolean) {
				OclBoolean anOclBoolean = (OclBoolean) result;

				/* check the result of this OclBoolean */
				if (anOclBoolean.oclIsInvalid().isTrue()) {
					imageDescriptor =
							InterpreterUIPlugin.getImageDescriptor(IMG_RESULT_INVALID);
				}
				else if (anOclBoolean.oclIsUndefined().isTrue()) {
					imageDescriptor =
							InterpreterUIPlugin.getImageDescriptor(IMG_RESULT_UNDEFINED);
				}
				else if (anOclBoolean.isTrue()) {
					imageDescriptor =
							InterpreterUIPlugin.getImageDescriptor(IMG_RESULT_TRUE);
				}
				else {
					imageDescriptor =
							InterpreterUIPlugin.getImageDescriptor(IMG_RESULT_FALSE);
				}

				/* The icon could not be defined so use undefined icon */
				if (imageDescriptor == null) {
					imageDescriptor =
							InterpreterUIPlugin.getImageDescriptor(IMG_RESULT_UNDEFINED);
				}
			}

			Image image = null;
			if (imageDescriptor != null) {
				if (imageCache.containsKey(imageDescriptor)) {
					image = imageCache.get(imageDescriptor);
				}
				else {
					image = imageDescriptor.createImage();
					imageCache.put(imageDescriptor, image);
				}
			}

			return image;
		}

		return super.getImage(object);
	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	private String resultText(OclAny result) {

		if (result instanceof OclInteger) {
			OclInteger anOclInteger;
			tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement imiElement;
			
			anOclInteger = ((OclInteger) result);
			imiElement = anOclInteger.getModelInstanceElement();
			
			if(!imiElement.isUndefined()) {
				return anOclInteger.getModelInstanceInteger().getLong().toString();
			}
			else {
				return imiElement.toString();
			}
		}
		if (result instanceof OclBoolean) {
			return ((OclBoolean) result).getModelInstanceBoolean().getBoolean()
					.toString();
		}
		if (result instanceof OclModelInstanceObject) {
			OclModelInstanceObject obj = (OclModelInstanceObject) result;
			if (obj.oclIsInvalid().isTrue()) {
				return "invalid: " + obj.getInvalidReason().getMessage();
			}
			else if (obj.oclIsUndefined().isTrue()) {
				return "undefinied: " + obj.getUndefinedReason();
			}

			return obj.getModelInstanceObject().getObject().toString();
		}

		return result.toString();
	}

	@Override
	public void dispose() {

		/* Dispose all cached images */
		Iterator<Image> i = imageCache.values().iterator();
		while (i.hasNext()) {

			((Image) i.next()).dispose();
		}

		imageCache.clear();
		super.dispose();
	}
}
