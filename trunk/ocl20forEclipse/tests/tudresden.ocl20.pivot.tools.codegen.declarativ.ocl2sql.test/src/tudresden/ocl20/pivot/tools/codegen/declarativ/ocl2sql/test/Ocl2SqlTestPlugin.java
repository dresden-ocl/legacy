package tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.test;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Ocl2SqlTestPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID =
			"tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.test";

	// The shared instance
	private static Ocl2SqlTestPlugin plugin;

	/**
	 * The constructor
	 */
	public Ocl2SqlTestPlugin() {

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {

		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Ocl2SqlTestPlugin getDefault() {

		return plugin;
	}

}
