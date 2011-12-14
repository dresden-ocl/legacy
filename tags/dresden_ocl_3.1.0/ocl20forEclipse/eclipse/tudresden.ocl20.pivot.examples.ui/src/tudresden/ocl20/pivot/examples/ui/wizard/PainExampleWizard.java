package tudresden.ocl20.pivot.examples.ui.wizard;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Wizard used to create the simple example project within the current Eclipse
 * workspace.
 * 
 * @author Claas Wilke
 */
public class PainExampleWizard extends AbstractExampleWizard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see tudresden.ocl20.pivot.examples.ui.wizard.AbstractExampleWizard#
	 * getExamplePlugins()
	 */
	protected Collection<String[]> getExamplePlugins() {

		Collection<String[]> result = new ArrayList<String[]>(1);
		result.add(new String[] { "tudresden.ocl20.pivot.examples.pain",
				"Dresden OCL - SEPA/Pain XML Example" });
		
		return result;
	}
}