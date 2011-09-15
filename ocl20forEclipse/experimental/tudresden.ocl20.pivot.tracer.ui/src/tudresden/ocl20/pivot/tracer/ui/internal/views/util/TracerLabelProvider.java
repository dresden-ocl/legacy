package tudresden.ocl20.pivot.tracer.ui.internal.views.util;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.tracer.model.TracerItem;
import tudresden.ocl20.pivot.tracer.model.TracerNode;

public class TracerLabelProvider implements ILabelProvider {

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getText(Object element) {
		if(element instanceof TracerNode) {
			try {
				TracerItem item = ((TracerNode) element).getTracerItem();
				
				String result;
				
				result = item.getExpression().toString();
				result += "\n\n";
				result += item.getResult().toString();
				
				return result;
				
				//return ((TracerNode) element).getTracerItem().toString();
			} catch (NullPointerException e) {
				/* TODO Lars: FIXME */
				return "NULLPOINTEREXCEPTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!";
			}
		}
		return "narf";
	}

}
