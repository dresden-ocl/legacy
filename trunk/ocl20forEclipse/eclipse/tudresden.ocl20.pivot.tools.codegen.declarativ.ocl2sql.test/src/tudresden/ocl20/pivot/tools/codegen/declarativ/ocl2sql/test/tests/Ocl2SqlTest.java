package tudresden.ocl20.pivot.tools.codegen.declarativ.ocl2sql.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Platform;
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
import tudresden.ocl20.pivot.tools.transformation.exception.TransformationException;

public class Ocl2SqlTest {

	private String sourcePath = System.getProperty("java.io.tmpdir")
			+ "/ocl2sqltest";

	private static List<String> expected;

	private IModel model;
	private static String filePath = Platform
			.getBundle(Ocl2SqlTestPlugin.PLUGIN_ID).getLocation()
			.replace("reference:file:", "");

	public List<Constraint> constraints = null;

	@BeforeClass
	public static void setUpClass() {

		expected = parseFile(filePath + "solution/view.sql");
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
	public void setUp() {

		try {
			model = ModelBusPlugin
					.getMetamodelRegistry()
					.getMetamodel(UML2MetamodelPlugin.ID)
					.getModelProvider()
					.getModel(
							new File(filePath + "model/university_complex.uml"));
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

	private void testStringList(List<String> actual, List<String> expected) {

		/* Required for OS-independent regression tests. */
		List<String> expectedCorrected = new ArrayList<String>(expected.size());
		List<String> actualCorrected = new ArrayList<String>(expected.size());

		for (String anExpected : expected) {
			expectedCorrected.add(anExpected.replaceAll("\r\n", "\n")
					.replaceAll("\r", "\n"));
		}

		for (String anActual : actual) {
			actualCorrected.add(anActual.replaceAll("\r\n", "\n").replaceAll(
					"\r", "\n"));
		}

		for (String s : actualCorrected) {
			if (s.equals(""))
				continue;
			assertTrue("A extra view is generated\n" + s,
					expectedCorrected.contains(s));
		}
		for (String s : expectedCorrected) {
			if (s.equals(""))
				continue;
			assertTrue("A view isn't generate\n" + s,
					actualCorrected.contains(s));
		}
	}

	private List<String> runCodeGenerator(IOcl2DeclSettings settings)
			throws Ocl2CodeException {

		settings.setModus(IOcl2DeclSettings.MODUS_TYPED);
		settings.setSourceDirectory(sourcePath);
		try {
			settings.setTemplateGroup(TemplatePlugin.getTemplateGroupRegistry()
					.getTemplateGroup("Standard(SQL)"));
		} catch (TemplateException e1) {
			fail("Can't load Standard SQL template.");
		}
		try {
			model.removeAllConstraints();
		} catch (IllegalArgumentException e2) {
			fail("Can't model reset.");
		} catch (ModelAccessException e2) {
			fail("Can't model reset.");
		}
		try {
			constraints = Ocl22Parser.INSTANCE.doParse(
					model,
					URI.createFileURI(filePath
							+ "constraints/university_complex.ocl"), true);
		} catch (ParseException e) {
			fail("Can't parse the constraints");
		}
		IOcl2Sql ocl2Sql = Ocl2SQLFactory.getInstance().createSQLCodeGenerator(
				settings);
		ocl2Sql.setInputModel(model);
		return ocl2Sql.transformFragmentCode(constraints);
	}

	/**
	 * check throw TransformationEception.
	 */
	@Test
	public void runExceptionTest() {

		IOcl2DeclSettings settings = Ocl2DeclCodeFactory.getInstance()
				.createOcl2DeclCodeSettings();
		try {
			runCodeGenerator(settings);
		} catch (Ocl2CodeException e1) {
			fail("A execption throw!");
		}
		settings.setSaveCode(true);
		settings.setModus(0);
		IOcl2Sql ocl2Sql = Ocl2SQLFactory.getInstance().createSQLCodeGenerator(
				settings);
		ocl2Sql.setInputModel(model);
		try {
			ocl2Sql.transformFragmentCode(constraints);
			fail("No TransformationException throw, because no modus are set.");
		} catch (Ocl2CodeException e) {
			if (!(e.getCause() instanceof TransformationException)) {
				fail("No TransformationException throw, because no modus are set.");
			}
		}
		settings.setModus(IOcl2DeclSettings.MODUS_TYPED);
		settings.setObjectViewPrefix("T_");
		try {
			ocl2Sql.transformFragmentCode(constraints);
			fail("No TransformationException throw, because set table prefix and object view prefix to same prefix");
		} catch (Ocl2CodeException e) {
			if (!(e.getCause() instanceof TransformationException)) {
				fail("No TransformationException throw, because "
						+ e.getCause().getMessage());
			}
		}
		settings.setObjectViewPrefix("OV_");
		settings.setPrimaryKeyPrefix("");
		try {
			ocl2Sql.transformFragmentCode(constraints);
			fail("No TransformationException throw, because primary key prefix is null");
		} catch (Ocl2CodeException e) {
			if (!(e.getCause() instanceof TransformationException)) {
				fail("No TransformationException throw, because "
						+ e.getCause().getMessage());
			}
		}
		settings.setPrimaryKeyPrefix("FK_");
		try {
			ocl2Sql.transformFragmentCode(constraints);
			fail("No TransformationException throw, because primary key and foreign key has the same prefix");
		} catch (Ocl2CodeException e) {
			if (!(e.getCause() instanceof TransformationException)) {
				fail("No TransformationException throw, because "
						+ e.getCause().getMessage());
			}
		}
	}

	/**
	 * Test if no schema created and check the created views.
	 */
	@Test
	public void runTestNotSave() {

		IOcl2DeclSettings settings = Ocl2DeclCodeFactory.getInstance()
				.createOcl2DeclCodeSettings();
		settings.setSaveCode(false);
		settings.setModus(IOcl2DeclSettings.MODUS_TYPED);
		List<String> result = null;
		try {
			result = runCodeGenerator(settings);
		} catch (Ocl2CodeException e) {
			fail("Can't generate sql code");
		}
		assertNotNull("No result", result);
		testStringList(removeComments(result), expected);
		String[] files = (new File(sourcePath)).list();
		assertEquals(1, files.length);
		testStringList(parseFile(sourcePath + "/" + files[0]),
				parseFile(filePath + "solution/view.sql"));
	}

	/**
	 * Test if check the created views and schema.
	 */
	@Test
	public void runTestWithSave() {

		IOcl2DeclSettings settings = Ocl2DeclCodeFactory.getInstance()
				.createOcl2DeclCodeSettings();
		settings.setSaveCode(true);
		List<String> result = null;
		try {
			result = runCodeGenerator(settings);
		} catch (Ocl2CodeException e) {
			fail("Can't generate sql code");
		}
		assertNotNull("No result", result);
		testStringList(removeComments(result), expected);
		String[] files = (new File(sourcePath)).list();
		assertEquals(2, files.length);
		testStringList(parseFile(sourcePath + "/" + files[0]),
				parseFile(filePath + "solution/schema.sql"));
		testStringList(parseFile(sourcePath + "/" + files[1]),
				parseFile(filePath + "solution/view.sql"));
	}

	@Test
	public void runTestWithSaveAndOtherParameter() {

		IOcl2DeclSettings settings = Ocl2DeclCodeFactory.getInstance()
				.createOcl2DeclCodeSettings();
		settings.setSaveCode(true);
		settings.setTablePrefix("TB_");
		settings.setObjectViewPrefix("O_");
		settings.setAssociationTablePrefix("AS_");
		settings.setPrimaryKeyPrefix("P_");
		settings.setForeignKeyPrefix("F_");
		try {
			runCodeGenerator(settings);
		} catch (Ocl2CodeException e) {
			fail("Can't generate sql code");
		}
		String[] files = (new File(sourcePath)).list();
		assertEquals(2, files.length);
		testStringList(parseFile(sourcePath + "/" + files[0]),
				parseFile(filePath + "solution/schema_para.sql"));
		testStringList(parseFile(sourcePath + "/" + files[1]),
				parseFile(filePath + "solution/view_para.sql"));
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

	private List<String> removeComments(List<String> views) {

		List<String> result = new ArrayList<String>();
		for (String s : views) {
			result.add(removeComment(s));
		}
		return result;
	}
}
