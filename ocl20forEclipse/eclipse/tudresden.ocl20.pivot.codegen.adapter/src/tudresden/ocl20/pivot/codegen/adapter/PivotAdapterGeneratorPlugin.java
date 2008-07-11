package tudresden.ocl20.pivot.codegen.adapter;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The <b>Plugin</b> for the Validator Generator Extension plug-in.
 * 
 * @author Michael Thiele
 */
public final class PivotAdapterGeneratorPlugin extends EMFPlugin {
	/**
	 * The singleton instance of the plugin.
	 */
	public static final PivotAdapterGeneratorPlugin INSTANCE = new PivotAdapterGeneratorPlugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	public static final String ID = "tudresden.ocl20.pivot.codegen.adapter";

	/**
	 * Creates the singleton instance.
	 */
	private PivotAdapterGeneratorPlugin() {
		super(new ResourceLocator[] {});
	}

	/*
	 * Javadoc copied from base class.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
