package tudresden.ocl20.pivot.tools.transformation.pivot2sql.test.tests.util;

import java.io.File;
import static org.junit.Assert.fail;

import tudresden.ocl20.pivot.metamodels.uml2.UML2MetamodelPlugin;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.tools.codegen.declarativ.IOcl2DeclSettings;
import tudresden.ocl20.pivot.tools.codegen.declarativ.Ocl2DeclCodeFactory;
import tudresden.ocl20.pivot.tools.template.ITemplateGroup;
import tudresden.ocl20.pivot.tools.template.TemplatePlugin;
import tudresden.ocl20.pivot.tools.template.exception.TemplateException;

public class TestPerformer {

	private static String TEMPLATE_NAME = "Standard(SQL)";

	/**
	 * <p>
	 * Creates a new TestPerformer.
	 * </p>
	 */
	private TestPerformer() {

	}

	public static IModel addUMLModel(File file) throws IllegalArgumentException,
			ModelAccessException {

		return ModelBusPlugin.getMetamodelRegistry()
				.getMetamodel(UML2MetamodelPlugin.ID).getModelProvider().getModel(file);
	}

	public static boolean removeUMLModel(IModel model) {

		return ModelBusPlugin.getModelRegistry().removeModel(model);
	}

	public static ITemplateGroup getTemplateGroup() {

		try {
			return TemplatePlugin.getTemplateGroupRegistry().getTemplateGroup(
					TEMPLATE_NAME);
		} catch (TemplateException e) {
			fail("Can't load the template group.");
			return null;
		}
	}

	public static IOcl2DeclSettings getSettings() {

		IOcl2DeclSettings oclSettings =
				Ocl2DeclCodeFactory.getInstance().createOcl2DeclCodeSettings();
		try {
			oclSettings.setTemplateGroup(TemplatePlugin.getTemplateGroupRegistry()
					.getTemplateGroup(TEMPLATE_NAME));
		} catch (TemplateException e) {
			fail("Can't load the template group.");
		}
		return oclSettings;

	}
}
