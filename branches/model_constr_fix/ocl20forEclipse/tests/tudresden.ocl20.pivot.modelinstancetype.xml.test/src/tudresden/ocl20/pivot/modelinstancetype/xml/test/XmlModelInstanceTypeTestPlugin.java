/*
Copyright (C) 2010 by Claas Wilke (claaswilke@gmx.net)

This file is part of the XML Model Instance Plug-in Test Suite of Dresden OCL2
for Eclipse.

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

package tudresden.ocl20.pivot.modelinstancetype.xml.test;

/**
 * <p>Plug-in implementation of IModelInstanceType test suite for XML.</p>
 */
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * <p>
 * The activator class controls the plug-in life cycle.
 * </p>
 */
public class XmlModelInstanceTypeTestPlugin extends Plugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID =
			"tudresden.ocl20.pivot.modelinstancetype.xml.test";

	/** The shared instance. */
	private static XmlModelInstanceTypeTestPlugin plugin;

	/**
	 * <p>
	 * The constructor.
	 * </p>
	 */
	public XmlModelInstanceTypeTestPlugin() {

		/* Remains empty. */
	}

	/**
	 * <p>
	 * Returns the shared instance.
	 * </p>
	 * 
	 * @return The shared instance.
	 */
	public static XmlModelInstanceTypeTestPlugin getDefault() {
	
		return plugin;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {

		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {

		plugin = null;
		super.stop(context);
	}
}