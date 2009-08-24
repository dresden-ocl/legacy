/* Generated by Together */

package com.togethersoft.modules.ocl;

import com.togethersoft.openapi.ide.IdeStartup;
import com.togethersoft.openapi.ide.command.IdeCommandGroup;
import com.togethersoft.openapi.ide.command.IdeCommandItem;
import com.togethersoft.openapi.ide.command.IdeCommandManager;
import com.togethersoft.openapi.ide.command.IdeCommandManagerAccess;
import com.togethersoft.openapi.ide.command.IdeCommandConstraints;
import com.togethersoft.openapi.ide.command.IdeCommandAdapter;
import com.togethersoft.openapi.ide.command.IdeCommandEvent;
import com.togethersoft.openapi.ide.message.IdeMessageType;
import com.togethersoft.openapi.ide.message.IdeMessageManagerAccess;
import com.togethersoft.openapi.ide.inspector.IdeInspectorManager;
import com.togethersoft.openapi.ide.inspector.IdeInspectorManagerAccess;
import com.togethersoft.openapi.ide.inspector.IdeInspector;
import com.togethersoft.openapi.ide.inspector.IdeInspectorBuilder;
import com.togethersoft.openapi.ide.IdeContext;
import com.togethersoft.openapi.util.RwiElementsUtil;
import com.togethersoft.openapi.rwi.RwiProperty;
import com.togethersoft.openapi.rwi.RwiShapeType;
import com.togethersoft.openapi.rwi.RwiElement;
import com.togethersoft.openapi.ide.inspector.IdeInspectorComponent;
import com.togethersoft.openapi.ide.inspector.IdeInspectorPropertySetComponent;
import com.togethersoft.openapi.ide.inspector.IdeInspectorProperty;
import com.togethersoft.openapi.ide.inspector.util.property.RwiInspectorBooleanProperty;
import com.togethersoft.openapi.ide.inspector.Condition;

/**
 * Controls the visibility of the "OCL constraints" inspector tab.
 * Used by {@link IdeInspectorBuilder IdeInspectorBuilder}.
 * @author Christian Nill 
 */
class OCLConstraintVisibilityCondition implements Condition {
    /**
     * @return <code>true</code>if exactly <b>one</b> class or operation is selected on the diagram pane 
     */
	public boolean execute(IdeContext context) {
    //checks for number and shape type of "selected" element, should be only classes or operations?
        RwiElement[] rwiElements = RwiElementsUtil.getRwiElements(context);
        if (! (rwiElements.length == 1)) {
            return false;
        }
   	    if (! "model".equals(rwiElements[0].getProperty(RwiProperty.MODEL_PART)) ||
       	    (! rwiElements[0].getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.CLASS) &&
           	! rwiElements[0].getProperty(RwiProperty.SHAPE_TYPE).equals(RwiShapeType.OPERATION)) ) {
   	        return false;
    	}
		return true;
    }
}

