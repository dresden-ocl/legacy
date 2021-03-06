package tudresden.ocl20.pivot.examples.ocl22java.wizard;

import java.util.ArrayList;
import java.util.Collection;

import tudresden.ocl20.pivot.examples.ui.wizard.AbstractExampleWizard;

/**
 * Wizard used to create the simple example project within the current Eclipse
 * workspace.
 * 
 * @author Claas Wilke
 */
public class RoyalAndLoyalExampleWizard extends AbstractExampleWizard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.examples.ui.wizard.AbstractExampleWizard#
	 * getExamplePlugins()
	 */
	protected Collection<String[]> getExamplePlugins() {

		Collection<String[]> result = new ArrayList<String[]>(1);
		result.add(new String[] { "tudresden.ocl20.pivot.examples.royalandloyal",
				"Dresden OCL - Royal and Loyal UML Example" });
		result.add(new String[] {
				"tudresden.ocl20.pivot.examples.royalandloyal.ocl22javacode",
				"Dresden OCL - Royal and Loyal Ocl2Java Example" });

		return result;
	}
}
