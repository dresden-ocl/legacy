/* Generated by Together */package com.togethersoft.modules.ocl;import com.togethersoft.openapi.ide.IdeContext;import com.togethersoft.openapi.ide.command.IdeCommandEvent;import com.togethersoft.openapi.ide.command.IdeCommandItem;import com.togethersoft.openapi.ide.command.IdeCommandListener;import com.togethersoft.openapi.rwi.RwiElement;import com.togethersoft.openapi.rwi.RwiProperty;import com.togethersoft.openapi.rwi.RwiShapeType;import com.togethersoft.openapi.sci.SciClass;import com.togethersoft.openapi.sci.SciLanguage;import com.togethersoft.openapi.sci.SciModelAccess;import com.togethersoft.openapi.sci.SciOperation;import com.togethersoft.openapi.sci.SciTag;import com.togethersoft.openapi.sci.enum.SciOperationEnumeration;import com.togethersoft.openapi.util.RwiElementsUtil;/** * Handles all events, that are caused by menu groups and menu items that are part of the Injector's GUI components. * @author Christian Nill */public class OCLInjectorCommandListener implements IdeCommandListener {	private OCLInjectorRunner oclInjectorRunner;	/**	 * Called when a menu item is selected. Invokes the sensible command (usually calls a method in {@link OCLInjectorRunner OCLInjectorRunner}. 	 */	public void actionPerformed(IdeCommandEvent event) {		String itemId = event.getCommandItem().getId();		IdeCommandItem currentCommandItem = event.getCommandItem();		// (de-)select classes for instrumentation from MAIN MENU		if (itemId.equals("_menuItemInstrumentationMarker")) {			// should logically be "!currentCommandItem.isChecked()", but check-status behaves strangely			markRwiElementsForInstrumentation(				event.getElementContext(),				currentCommandItem.isChecked());		}		// (de-)select classes for instrumentation from MAIN MENU		else if (itemId.equals("_popupMenuItemInstrumentationMarker")) {			markRwiElementsForInstrumentation(				event.getElementContext(),				!currentCommandItem.isChecked());		}		// clean selected classes		else if (			itemId.equals("_menuItemCleanClass")				|| itemId.equals("_popupMenuItemCleanClass")) {			(new OCLInjectorRunner(event.getElementContext())).cleanSelectedRwiElements();		}		// instrument selected class		else if (			itemId.equals("_menuItemInstrumentClass")				|| itemId.equals("_popupMenuItemInstrumentClass")) {			(new OCLInjectorRunner(event.getElementContext())).instrumentSelectedRwiElements();		}		// instrument all classes in project		else if (itemId.equals("_menuItemInstrumentMarkedClasses")) {			(new OCLInjectorRunner(event.getElementContext())).instrumentMarkedRwiElements();		}		// instrument all classes in project		else if (itemId.equals("_menuItemCleanAllClasses")) {			(new OCLInjectorRunner(event.getElementContext())).cleanAllRwiElements();		}	}	/**	 * Invoked to check, whether menu items have to be adjusted, before they are displayed. Checks on the current selection to sensibly deactivate some items for functions that cannot be performed on the current selection. 	 */	public void checkStatus(IdeCommandEvent event) {		final int MARKED = 0;		final int UNCLEAR = 1;		final int UNMARKED = 2;		boolean validSelection = true;		boolean selectionInstrumented = false;		int status = UNMARKED;		String itemId = event.getCommandItem().getId();		IdeCommandItem currentCommandItem = event.getCommandItem();		// gather information about current selection		RwiElement[] rwiElements =			RwiElementsUtil.getRwiElements(event.getElementContext());		currentCommandItem.setVisible(true);		for (int i = 0; i < rwiElements.length; i++) {			// only show checkbox item for classes (not interfaces, nor operations)			if (rwiElements[i].hasProperty(RwiProperty.INTERFACE)				|| !(rwiElements[i]					.getProperty(RwiProperty.SHAPE_TYPE)					.equals(RwiShapeType.CLASS))) {				validSelection = false;				break;			}			// determine whether selected classes are marked			if (rwiElements[i].hasProperty("selectedForInstrumentation")) {				if (status == UNMARKED) {					status = MARKED;				}			} else {				if (status == MARKED) {					status = UNCLEAR;					// okay to stop here, will remain unclear					break;				}			}			// determine whether at least some selected classes are instrumented			SciClass sciClass =				SciModelAccess.getModel().findClass(					SciLanguage.JAVA,					rwiElements[i].getProperty(RwiProperty.FULL_NAME));			SciOperationEnumeration opEnum = sciClass.operations();			while (opEnum.hasMoreElements()) {				SciOperation sciConstructor = opEnum.nextSciOperation();				SciTag author = sciConstructor.getTagList().getTag("author");				if (author != null					&& author.getValue().equals("ocl_injector")) {					selectionInstrumented = true;					break;				}			}		}		// all relevant checkboxes that inform about marked/unmarked		if (itemId.equals("_popupMenuItemInstrumentationMarker")			|| itemId.equals("_menuItemInstrumentationMarker")) {			if (validSelection) {				if (status == UNCLEAR) {					currentCommandItem.setIndeterminate(true);					currentCommandItem.setChecked(false);				} else {					currentCommandItem.setIndeterminate(false);					if (status == MARKED) {						event.getCommandItem().setChecked(true);					} else {						event.getCommandItem().setChecked(false);					}				}				currentCommandItem.setEnabled(true);			} else { // no valid selection				currentCommandItem.setEnabled(false);			}		}		// the popup menu's group item		else if (itemId.equals("_popupMenuGroupInstrumentation")) {			if (validSelection) {				currentCommandItem.setVisible(true);			} else {				currentCommandItem.setVisible(false);			}		}		// both menu's instrument class item		else if (			itemId.equals("_popupMenuItemInstrumentClass")				|| itemId.equals("_menuItemInstrumentClass")) {			if (validSelection) {				if (selectionInstrumented) {					currentCommandItem.setText("Reinstrument class file(s)");				} else {					currentCommandItem.setText("Instrument class file(s)");				}				currentCommandItem.setEnabled(true);			} else {				currentCommandItem.setEnabled(false);			}		}		// both menu's clean class item		else if (			itemId.equals("_popupMenuItemCleanClass")				|| itemId.equals("_menuItemCleanClass")) {			if (validSelection) {				//currentCommandItem.setVisible(true);				if (selectionInstrumented) {					currentCommandItem.setEnabled(true);				} else {					currentCommandItem.setEnabled(false);				}			} else {				currentCommandItem.setEnabled(false);			}		}	}	/**	 * (Un-)Marks selected classes by adding/removing the <code>@selectedForInstrumentation</code> Javadoc tag, if the respecitve checkbox is clicked in one of the menus.	 * 	 * Note:	 * If instead the checkbox in the inspector is used, this method does not need to be called, as the respective <code>RwiInspectorBooleanProperty</code> performs the insertion of the Javadoc tag automatically. 	 * @param select <code>true</code>to create the tag, <code>false</code> to delete it.	 */	private void markRwiElementsForInstrumentation(		IdeContext ideContext,		boolean select) {		RwiElement[] rwiElements = RwiElementsUtil.getRwiElements(ideContext);		for (int i = 0; i < rwiElements.length; i++) {			rwiElements[i].setProperty("selectedForInstrumentation", select);		}	}}