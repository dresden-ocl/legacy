/* Generated by Together */

package com.togethersoft.modules.ocl;

import com.togethersoft.openapi.ide.message.IdeMessageManagerAccess;
import com.togethersoft.openapi.ide.message.IdeMessageType;

/**
 * Just a helper class  that should help debugging within the Together IDE.
 */
public class DebugHelper {

    /**
     * Prints the given string in the Message Pane.
     */
	public void printInformation(String msg) {
	    IdeMessageManagerAccess.printMessage(IdeMessageType.INFORMATION, msg);
    }
}
