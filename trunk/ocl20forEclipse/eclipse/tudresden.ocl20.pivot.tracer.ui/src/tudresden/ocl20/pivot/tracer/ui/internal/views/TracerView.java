/*
Copyright (C) 2011 by Lars Schuetze (lschuetze@gmx.net)

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
package tudresden.ocl20.pivot.tracer.ui.internal.views;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import tudresden.ocl20.pivot.interpreter.OclInterpreterPlugin;
import tudresden.ocl20.pivot.interpreter.event.IInterpreterTraceListener;
import tudresden.ocl20.pivot.interpreter.event.internal.InterpreterTraceEvent;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceElement;
import tudresden.ocl20.pivot.tracer.tracermodel.TracerItem;
import tudresden.ocl20.pivot.tracer.tracermodel.TracerRoot;
import tudresden.ocl20.pivot.tracer.tracermodel.TracermodelFactory;
import tudresden.ocl20.pivot.tracer.tracermodel.impl.TracermodelPackageImpl;
import tudresden.ocl20.pivot.tracer.tracermodel.provider.TracermodelItemProviderAdapterFactory;
import tudresden.ocl20.pivot.tracer.ui.TracerUIPlugin;
import tudresden.ocl20.pivot.tracer.ui.actions.TracerViewMenuAction;
import tudresden.ocl20.pivot.tracer.ui.actions.TracerViewMenuActionType;
import tudresden.ocl20.pivot.tracer.ui.internal.msg.OclTracerUIMessages;
import tudresden.ocl20.pivot.tracer.ui.internal.views.util.TracerItemAdapterFactoryContentProvider;
import tudresden.ocl20.pivot.tracer.ui.internal.views.util.TracerItemAdapterFactoryLabelProvider;
import tudresden.ocl20.pivot.tracer.ui.internal.views.util.TracerItemViewerFilter;
import tudresden.ocl20.pivot.tracer.ui.internal.views.util.ViewerFilterType;

/**
 * @author Lars Schuetze
 * 
 */
public class TracerView extends ViewPart implements IInterpreterTraceListener {

	/** Icon to clear the view. */
	private static String CLEAR_IMAGE = "icons/clear.gif";

	/** The {@link TreeViewer} for this {@link TracerView}. */
	private TreeViewer myTreeViewer;

	/** The {@link TracerRoot} of the tree. */
	private TracerRoot tracerRoot;

	/** The {@link ComposedAdapterFactory} of the {@link tracer}. */
	private ComposedAdapterFactory myAdapterFactory;

	/** The {@link IMenuManager} of this {@link TracerView}. */
	private IToolBarManager myToolBarManager;

	/** The {@link IMenuManager} of this {@link TracerView}. */
	private IMenuManager myMenuManager;

	/** The {@link TracerItemViewerFilter} of this {@link TreeViewer} */
	private TracerItemViewerFilter myViewerFilter;

	/** Pointing to the current parent */
	private TracerItem currentParent;

	/** The factory to create new instances */
	private TracermodelFactory factory;

	/** This map holds the TracerItems in a cache for fast access */
	private WeakHashMap<UUID, TracerItem> cachedItems;

	/**
	 * <p>
	 * Instantiates this view.
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public TracerView() {

		super();

		TracermodelPackageImpl.init();
		factory = TracermodelFactory.eINSTANCE;

		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		Collections.addAll(factories, new TracermodelItemProviderAdapterFactory(),
				new ReflectiveItemProviderAdapterFactory(),
				new ResourceItemProviderAdapterFactory());

		myAdapterFactory = new ComposedAdapterFactory(factories);
		cachedItems = new WeakHashMap<UUID, TracerItem>();
		tracerRoot = factory.createTracerRoot();
		currentParent = null;

		// Add this listener to the InterpreterRegistry
		//
		OclInterpreterPlugin.getInterpreterRegistry().addInterpreterTraceListener(
				this);
	}

	@Override
	public void dispose() {

		try {
			OclInterpreterPlugin.getInterpreterRegistry()
					.removeInterpreterTraceListener(this);
			myAdapterFactory.dispose();
		} finally {
			super.dispose();
		}
	}

	@Override
	public void createPartControl(Composite parent) {

		// This tree defines the layout for the TreeView
		//
		Tree myTracerTree =
				new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		myTracerTree.setHeaderVisible(true);
		myTracerTree.setLinesVisible(true);

		TreeColumn column1 = new TreeColumn(myTracerTree, 0);
		column1.setText("Constraint");
		column1.setWidth(400);

		TreeColumn column2 = new TreeColumn(myTracerTree, 0);
		column2.setText("Result");
		column2.setWidth(200);

		myViewerFilter = new TracerItemViewerFilter();

		myTreeViewer = new TreeViewer(myTracerTree);
		// myTreeViewer.addFilter(myViewerFilter);
		myTreeViewer
				.setContentProvider(new TracerItemAdapterFactoryContentProvider(
						myAdapterFactory));
		myTreeViewer.setLabelProvider(new TracerItemAdapterFactoryLabelProvider(
				myAdapterFactory));

		myTreeViewer.setInput(tracerRoot);
		initMenu();
	}

	/**
	 * <p>
	 * Creates the menu of this {@link TracerView}.
	 * </p>
	 */
	private void initMenu() {

		TracerViewMenuAction clearAllTracedElements;
		TracerViewMenuAction filterFalseElements;
		TracerViewMenuAction filterTrueElements;
		TracerViewMenuAction filterNothing;

		/*
		 * --- TOOLBAR
		 */

		/* Add the clear all traced elements button to the tool bar. */
		{
			clearAllTracedElements =
					new TracerViewMenuAction(
							TracerViewMenuActionType.CLEAR_ALL_ELEMTENTS, this);

			clearAllTracedElements.setImageDescriptor(TracerUIPlugin
					.getImageDescriptor(CLEAR_IMAGE));

			this.getToolBarManager().add(clearAllTracedElements);
		}

		/*
		 * --- ACTION BAR
		 */

		/* Add all menu items to the drop down menu. */
		{
			filterNothing =
					new TracerViewMenuAction(TracerViewMenuActionType.FILTER_NOTHING,
							this);

			filterNothing
					.setText(OclTracerUIMessages.TracerView_Filter_Nothing_Title);

			this.getMenuManager().add(filterNothing);

			filterFalseElements =
					new TracerViewMenuAction(
							TracerViewMenuActionType.FILTER_FALSE_ELEMENTS, this);

			filterFalseElements
					.setText(OclTracerUIMessages.TracerView_Filter_False_Title);

			this.getMenuManager().add(filterFalseElements);

			filterTrueElements =
					new TracerViewMenuAction(
							TracerViewMenuActionType.FILTER_TRUE_ELEMENTS, this);

			filterTrueElements
					.setText(OclTracerUIMessages.TracerView_Filter_True_Title);

			this.getMenuManager().add(filterTrueElements);
		}

	}

	/**
	 * <p>
	 * This method encapsulate the call to the tool bar manager.
	 * </p>
	 * 
	 * @return The {@link IToolBarManager} of the
	 *         {@link org.eclipse.ui.part.ViewPart ViewPart}.
	 */
	private IToolBarManager getToolBarManager() {

		if (myToolBarManager == null) {
			myToolBarManager = this.getViewSite().getActionBars().getToolBarManager();
		}
		return myToolBarManager;
	}

	/**
	 * <p>
	 * This method encapsulate the call to the tool bar manager.
	 * </p>
	 * 
	 * @return The {@link IMenuManager} of the {@link ViewPart}.
	 */
	private IMenuManager getMenuManager() {

		if (myMenuManager == null) {
			myMenuManager = this.getViewSite().getActionBars().getMenuManager();
		}
		return myMenuManager;
	}

	@Override
	public void setFocus() {

		myTreeViewer.getControl().setFocus();
	}

	/**
	 * <p>
	 * Clears the view and all its content.
	 * </p>
	 */
	public synchronized void clearTracerView() {

		// TODO: check for memory leaks

		cachedItems.clear();
		if (tracerRoot.getRootItems() != null) {
			Deque<TracerItem> stack =
					new ArrayDeque<TracerItem>(tracerRoot.getRootItems());

			while (!stack.isEmpty()) {
				TracerItem item = stack.pop();
				if (item.getChildren() != null) {
					stack.addAll(item.getChildren());
					item.getChildren().clear();
				}
				// no else
			}
			tracerRoot.getRootItems().clear();
		}
		// no else
		
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {

				myTreeViewer.refresh();
			}
		});
	}

	/**
	 * <p>
	 * Sets the {@link TracerItemViewerFilter} to filter the given
	 * {@link ViewerFilterType}.
	 * </p>
	 * 
	 * @param filterType
	 *          the {@link ViewerFilterType} to be set
	 */
	public void setFilter(ViewerFilterType filterType) {

		if (filterType != null) {
			myViewerFilter.setFilterType(filterType);
			myTreeViewer.refresh();
		}
		// no else
	}

	@Override
	public synchronized void interpretationTreeDepthIncreased(UUID uuid) {

		TracerItem dummyItem = factory.createTracerItem();
		dummyItem.setUUID(uuid);

		if (currentParent == null) {
			tracerRoot.getRootItems().add(dummyItem);
		}
		else {
			currentParent.getChildren().add(dummyItem);
		}
		cachedItems.put(uuid, dummyItem);
		dummyItem.setParent(currentParent);
		currentParent = dummyItem;
	}

	@Override
	public synchronized void interpretationTreeDepthIncreased(UUID uuid,
			IModelInstanceElement modelInstanceElement) {

		interpretationTreeDepthIncreased(uuid);
		cachedItems.get(uuid).setModelInstanceElement(modelInstanceElement);
	}

	@Override
	public synchronized void interpretationTreeDepthDecreased() {

		if (currentParent != null) {
			currentParent = currentParent.getParent();

			if (currentParent == null) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {

						myTreeViewer.refresh(false);
					}
				});
			}
			// no else
		}
		// no else
	}

	@Override
	public synchronized void partialInterpretationFinished(
			InterpreterTraceEvent event) {

		if (event != null) {
			TracerItem item = cachedItems.get(event.getUUID());
			if (item != null) {
				item.setExpression(event.getExpression());
				item.setResult(event.getResult());
			}
			// no else
		}
		// no else
	}

	@Override
	public synchronized void interpretationCleared() {

		clearTracerView();
	}

	@Override
	public synchronized void traceSelectedConstraints(List<Object[]> constraints) {
		
	}

}
