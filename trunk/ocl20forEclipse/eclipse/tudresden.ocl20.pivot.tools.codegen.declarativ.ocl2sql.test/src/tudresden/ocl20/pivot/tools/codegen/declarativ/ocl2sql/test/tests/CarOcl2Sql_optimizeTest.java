package tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.dresdenocl.testsuite._abstract.AbstractDresdenOclTest;
import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.Ocl22Parser;
import tudresden.ocl20.pivot.metamodels.uml2.UML2MetamodelPlugin;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.tools.codegen.declarativ.IOcl2DeclSettings;
import tudresden.ocl20.pivot.tools.codegen.declarativ.Ocl2DeclCodeFactory;
import tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.IOcl2Sql;
import tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.Ocl2SQLFactory;
import tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.test.Ocl2SqlTestPlugin;
import tudresden.ocl20.pivot.tools.codegen.exception.Ocl2CodeException;
import tudresden.ocl20.pivot.tools.template.TemplatePlugin;
import tudresden.ocl20.pivot.tools.template.exception.TemplateException;

public class CarOcl2Sql_optimizeTest {

	private String sourcePath = System.getProperty("java.io.tmpdir")
			+ "/ocl2sqltest";

	private static List<String> expected;

	private IModel model;

	public List<Constraint> constraints = null;

	@BeforeClass
	public static void setUpClass() throws IOException {

		expected = parseFile(AbstractDresdenOclTest.getFile("solution/car.sql",
				Ocl2SqlTestPlugin.PLUGIN_ID).getAbsolutePath());
	}

	private boolean deleteDir(File dir) {

		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		return dir.delete();
	}

	@Before
	public void setUp() throws IOException {

		try {
			model = ModelBusPlugin
					.getMetamodelRegistry()
					.getMetamodel(UML2MetamodelPlugin.ID)
					.getModelProvider()
					.getModel(
							AbstractDresdenOclTest.getFile("model/car.uml",
									Ocl2SqlTestPlugin.PLUGIN_ID));
		} catch (IllegalArgumentException e) {
			fail("Wrong parameter");
		} catch (ModelAccessException e) {
			fail("The model can't generate");
		}

		boolean exists = (new File(sourcePath)).exists();
		if (!exists) {
			new File(sourcePath).mkdir();
		}
		// else {
		// fail("Path " + sourcePath + " already exits");
		// }
	}

	@After
	public void tear_down() {

		if (model != null) {
			ModelBusPlugin.getModelRegistry().removeModel(model);
		}

		boolean exists = (new File(sourcePath)).exists();
		if (exists) {
			deleteDir(new File(sourcePath));
		} else {
			fail("Path " + sourcePath + " already exits");
		}
	}

	private void testString(String actual, String expected) {

		/* Required replacements for OS independent regression tests */
		actual = actual.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
		expected = expected.replaceAll("\r\n", "\n").replaceAll("\r", "\n");

		assertEquals(expected, actual);
	}

	private List<String> runCodeGenerator(IOcl2DeclSettings settings, int index)
			throws Ocl2CodeException, IOException {

		settings.setModus(IOcl2DeclSettings.MODUS_TYPED);
		settings.setSourceDirectory(sourcePath);
		try {
			model.removeAllConstraints();
		} catch (IllegalArgumentException e2) {
			fail("Can't model reset.");
		} catch (ModelAccessException e2) {
			fail("Can't model reset.");
		}
		try {
			settings.setTemplateGroup(TemplatePlugin.getTemplateGroupRegistry()
					.getTemplateGroup("MySQL(SQL)"));
		} catch (TemplateException e1) {
			fail("Can't load Standard SQL template.");
		}
		try {
			constraints = new LinkedList<Constraint>();
			constraints.add(Ocl22Parser.INSTANCE.doParse(
					model,
					URI.createFileURI(AbstractDresdenOclTest.getFile(
							"constraints/car.ocl", Ocl2SqlTestPlugin.PLUGIN_ID)
							.getAbsolutePath())).get(index));
		} catch (ParseException e) {
			fail("Can't parse the constraints");
		}
		IOcl2Sql ocl2Sql = Ocl2SQLFactory.getInstance().createSQLCodeGenerator(
				settings);
		ocl2Sql.setInputModel(model);
		return ocl2Sql.transformFragmentCode(constraints);
	}

	/**
	 * Test if no schema created and check the created views.
	 * 
	 * @throws IOException
	 */
	@Test
	public void runConstraint1() throws IOException {

		this.runConstraint(0);
	}

	@Test
	public void runConstraint2() throws IOException {

		this.runConstraint(1);
	}

	@Test
	public void runConstraint3() throws IOException {
		// TODO: optimize collect statement
		this.runConstraint(2);
	}

	@Test
	public void runConstraint4() throws IOException {

		this.runConstraint(3);
	}

	@Test
	public void runConstraint5() throws IOException {

		this.runConstraint(4);
	}

	@Test
	public void runConstraint6() throws IOException {

		this.runConstraint(5);
	}

	@Test
	public void runConstraint7() throws IOException {

		this.runConstraint(6);
	}

	@Test
	public void runConstraint8() throws IOException {

		this.runConstraint(7);
	}

	@Test
	public void runConstraint9() throws IOException {

		this.runConstraint(8);
	}

	@Test
	public void runConstraint10() throws IOException {

		this.runConstraint(9);
	}

	private void runConstraint(int index) throws IOException {

		IOcl2DeclSettings settings = Ocl2DeclCodeFactory.getInstance()
				.createOcl2DeclCodeSettings();
		settings.setSaveCode(false);
		settings.setModus(IOcl2DeclSettings.MODUS_TYPED);
		List<String> result = null;
		try {
			result = runCodeGenerator(settings, index);
		} catch (Ocl2CodeException e) {
			fail("Can't generate sql code. Reason: " + e.getMessage());
		}
		assertNotNull("No result", result);
		testString(removeComment(result.get(0)), expected.get(index));
	}

	private static List<String> parseFile(String file) {

		List<String> retValue = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String zeile = null;
			String temp = null;
			while ((zeile = in.readLine()) != null) {
				if (zeile.startsWith("--"))
					continue;
				if (temp == null) {
					temp = zeile;
				} else if (zeile.equals("")) {
					retValue.add(temp);
					temp = null;
				} else {
					temp += "\n" + zeile;
				}

			}
			retValue.add(temp);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return retValue;
	}

	private String removeComment(String view) {

		String result = "";
		for (String s : Arrays.asList(view.split("\n"))) {
			if (s.startsWith("--"))
				continue;
			result += s + "\n";
		}
		return result.trim();
	}

}
