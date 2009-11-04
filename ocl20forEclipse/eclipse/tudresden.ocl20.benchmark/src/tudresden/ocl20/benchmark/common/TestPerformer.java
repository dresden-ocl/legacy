/*
Copyright (C) 2009 by Franz Eichhorn (franz.eichhorn@gmx.de)

This file is part of the OCL Interpreter Test Suite of Dresden OCL2 for
Eclipse.

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
package tudresden.ocl20.benchmark.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;

import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclBoolean;
import tudresden.ocl20.pivot.interpreter.IInterpretationEnvironment;
import tudresden.ocl20.pivot.interpreter.IOclInterpreter;
import tudresden.ocl20.pivot.interpreter.OclInterpreterPlugin;
import tudresden.ocl20.pivot.modelbus.ModelAccessException;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.modelbus.metamodel.IMetamodel;
import tudresden.ocl20.pivot.modelbus.model.IModel;
import tudresden.ocl20.pivot.modelbus.model.IModelRegistry;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceProvider;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceRegistry;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceType;
import tudresden.ocl20.pivot.modelbus.modelinstance.IModelInstanceTypeRegistry;
import tudresden.ocl20.pivot.modelbus.modelinstance.exception.TypeNotFoundInModelException;
import tudresden.ocl20.pivot.modelbus.modelinstance.types.IModelInstanceObject;
import tudresden.ocl20.pivot.ocl2parser.parser.OCL2Parser;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.standardlibrary.java.JavaStandardlibraryPlugin;

/**
 * <p>
 * This class loads a given model file, a given model instance and given OCL
 * files. Then it can be used to perform some interpreter tests.
 * </p>
 * 
 * @author Franz Eichhorn
 */
public class TestPerformer {

	/**
	 * used to specify the content of an ocl-file so that the performer knows how
	 * to pre-parse the files correctly. However QUERY is not used yet and the
	 * other two have exactly the same behavior.
	 */
	public static enum constraintFileType {
		STATEMENT, // complete statement containing context
		QUERY, // only query
		PREPOST
		// only pre/post, context will be attached
	};

	/**
	 * The global {@link IEnvironment} used during interpretation and preparation.
	 */
	private IInterpretationEnvironment myGlobalEnvironment;

	// @ The {@link IOclInterpreter} used by this {@link TestPerformer}.
	private IOclInterpreter myInterpreter = null;

	// @ Model which is worked on
	private IModel myModel = null;

	// @ Metamodel of the Model
	private IMetamodel metaModel = null;

	// @ Logging engine to document success and failure of parsing and
	// @ interpretation
	private BenchmarkLogger bLogger;

	// @ Environment that holds common variables which
	// @ are used by both the TestPerformer and the Logger.
	private TestEnvironment testEnv;

	// @ Regex-Pattern to get a constraint's name
	private Pattern patternConstraintName;

	// @ name of model instance (mostly java)
	private String modelInstanceType;

	/**
	 * 
	 * @param testName
	 *          The name of the test being executed. Used for the Logger
	 */
	public TestPerformer(String testName) {

		super();

		this.testEnv = new TestEnvironment();

		this.testEnv.testName = testName;

		this.bLogger = new BenchmarkLogger(this.testEnv);

		// examine a constraint's name
		this.patternConstraintName =
				Pattern.compile("(.*?)(inv|pre|post|def)\\s*([\\(\\)\\w]*?)\\s*:(.*)");

	}

	// FIXME: does use old funtionality of the IModelInstance; commented out,
	// since it is not used anyway�
	// /**
	// * @param pathList
	// * The {@link Type} which instances shall be returned.
	// *
	// * @return All {@link IModelObject}s of the active {@link IModelInstance}
	// * which are of the {@link Type} described by the given pathList.
	// */
	// public List<IModelInstanceObject> getObjectsOfKind(List<String> pathList)
	// {
	//
	// List<IModelInstanceObject> result;
	//
	// result = ModelBusPlugin.getModelInstanceRegistry()
	// .getActiveModelInstance(this.myModel)
	// .getObjectsOfType(pathList);
	//
	// return result;
	//
	// }

	/**
	 * <p>
	 * Initializes the {@link TestPerformer} after all required parameters are
	 * set.
	 * </p>
	 * 
	 * @throws RuntimeException
	 *           Is thrown if any error occurred while loading the model or the
	 *           meta model.
	 */
	public void init(String metaModelName, String modelBundleName,
			String modelFilePath) throws RuntimeException {

		/* Try to load model and meta model. */
		try {

			this.metaModel =
					ModelBusPlugin.getMetamodelRegistry().getMetamodel(metaModelName);

			if (metaModel == null) {
				throw new RuntimeException(
						"Unable to load UML2 meta model during test.");
			}

			// Get the bundle location for the model files.
			this.testEnv.fileDirectory =
					Platform.getBundle(modelBundleName).getLocation();

			// Remove the 'reference:file:' from the beginning.
			this.testEnv.fileDirectory = this.testEnv.fileDirectory.substring(15);

			// Load the model.
			this.loadModel(modelFilePath);

			// Initialize the interpreter.
			this.myInterpreter = OclInterpreterPlugin.createInterpreter(null);
			this.myInterpreter.setCachingEnabled(false);

			this.myGlobalEnvironment = this.myInterpreter.getEnvironment();
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Cleans everything...
	 */
	public void deInit() throws IOException {

		this.bLogger.close();
	}

	/**
	 * loads an Ocl file by loading each statement separately to avoid abort due
	 * to parser exceptions Statements that could not be loaded, will be stored as
	 * well as the error messages.
	 * 
	 * @param oclFileName
	 * 
	 * @throws RuntimeException
	 */
	public void safeLoadStatementFile(String oclFileName) throws RuntimeException {

		this.safeLoadConstraintFile(oclFileName, constraintFileType.STATEMENT);
	}

	/**
	 * Parses the ocl statement.
	 * 
	 * @param oclStatement
	 * @param packageInformation
	 * 
	 * @return true, if successful
	 */
	private boolean parseOclStatement(String oclStatement,
			String packageInformation) {

		oclStatement = oclStatement.replaceAll("\n", "\n\t");

		OCL2Parser anOCLparser;
		String completeStatement =
				"package " + packageInformation + " \n" + oclStatement
						+ " \nendpackage";
		StringReader reader = new StringReader(completeStatement);
		anOCLparser = new OCL2Parser(myModel, reader);

		// try to parse the ocl statement
		try {
			anOCLparser.parse();

			// Save the constraint's definition under it's name to refer to it
			// later
			// when logging results
			this.testEnv.storeConstraintDefinition(packageInformation, oclStatement);

			this.bLogger.oclParseSuccess(oclStatement);
		} catch (Exception e) {
			this.bLogger.oclParseError(oclStatement, e);
			return false;
		}

		return true;
	}

	/**
	 * Returns the package (is expected to be the first line) of a BufferedReader.
	 * 
	 * @param reader
	 *          Input reader that contains package statement
	 * 
	 * @return
	 * 
	 * @throws RuntimeException
	 */
	private String getPackageFromReader(BufferedReader reader)
			throws RuntimeException {

		String line = "";
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				// empty line or comment at the beginning
				if (line.equals("") || line.startsWith("--")) {
					continue;
				}

				if (line.startsWith("package")) {
					return line.substring(7).trim();
				}

				throw new RuntimeException(
						"Cannot find the package-statement in the reader. This has to be the first statement!");
			}

			throw new RuntimeException(
					"Unexpected End of Reader, did not find a package");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Safe load query file.
	 * 
	 * @param queryFile
	 */
	public void safeLoadQueryFile(String queryFile) {

		this.safeLoadConstraintFile(queryFile, constraintFileType.QUERY);
	}

	/**
	 * Safe load of OCL-File which contains Pre/Post values
	 */
	public void safeLoadPrePostFile(String oclFile) {

		this.safeLoadConstraintFile(oclFile, constraintFileType.PREPOST);
	}

	/**
	 * Loads an ocl file either as query or normal invariant file...
	 * 
	 * @param fileName
	 * @param type
	 */
	private void safeLoadConstraintFile(String fileName, constraintFileType type) {

		// check if the file has been loaded already
		if (this.testEnv.loadedOclFiles.contains(fileName)) {
			return;
		}

		// start the curConstraintID at 1 for each file
		this.testEnv.curConstraintId = 1;
		FileReader oclFileReader = this.safeOpenFileReader(fileName);
		BufferedReader bufReader = new BufferedReader(oclFileReader);

		// package information to be copied
		// at the beginning of each statement
		String packageInformation = this.getPackageFromReader(bufReader);

		bLogger.outHead2("Start Parsing File: " + fileName);
		switch (type) {
		case STATEMENT:
			this.handleStatements(bufReader, packageInformation, fileName);
			break;

		case QUERY:
			this.handleQueries(bufReader, packageInformation);
			break;

		case PREPOST:
			this.handleStatements(bufReader, packageInformation, fileName);
			break;
		}

		this.bLogger.printParseStats();

		// register for being loaded
		this.testEnv.loadedOclFiles.add(fileName);
	}

	/**
	 * Handle statements.
	 * 
	 * @param source
	 * @param packageInfo
	 */
	private void handleStatements(BufferedReader source, String packageInfo,
			String fileName) {

		fileName = Helper.getFileNameFromPath(fileName);

		String strLine;
		StringBuilder oclStatementString = new StringBuilder();

		while ((strLine = this.nextLine(source)) != null) {

			// if line starts with context or endpackage
			// --> parse the LAST statement
			if ((strLine.startsWith("endpackage") || strLine.startsWith("context"))
					&& oclStatementString.length() > 0) {

				// try to parse ocl statement
				this.parseOclStatement(oclStatementString.toString(), packageInfo);
				// empty ocl string
				oclStatementString.setLength(0);
			}

			// EOF
			if (strLine.startsWith("endpackage")) {
				break;
			}

			// try to extract the constraint's name
			strLine = this.getOrSetConstraintName(strLine, fileName);

			oclStatementString.append(strLine);
			oclStatementString.append("\n");

		}
	}

	/**
	 * analyzes a linen from the input and extracts the constraint's name, if
	 * specified. If no name is given, a new name is generated and integrated inh
	 * the line
	 * 
	 * @param line
	 *          Line to be analyzed
	 * @param fileName
	 *          current scanned filename that is used to generate the new
	 *          constraint name
	 */
	private String getOrSetConstraintName(String line, String fileName) {

		// try to capture the invariant's name
		Matcher match = this.patternConstraintName.matcher(line);

		if (match.matches()) {
			// if pre or post add it to the name
			String prefix;
			if (match.group(2).equals("pre") || match.group(2).equals("post")) {
				prefix = "_" + match.group(2) + "_";
			}
			else {
				prefix = "";
			}
			// create or modify the testname to get a unique name
			// specially identify pre and posts to test them separately
			if (match.group(3).length() > 0) {
				this.testEnv.curConstraintName =
						this.testEnv.testName + prefix + fileName + "_" + match.group(3);
			}
			else {
				this.testEnv.curConstraintName =
						this.testEnv.testName + prefix + fileName + "_"
								+ (this.testEnv.curConstraintId++);
			}

			return match.group(1) + " " + match.group(2) + " "
					+ this.testEnv.curConstraintName + ":" + match.group(4);

		}
		else {
			return line;
		}
	}

	/**
	 * Handles a source which contains queries. The source is expected to be in
	 * the USE-Format, queries start with `?�. All queries are encapsulated into
	 * OCL-statements which are then parsed. Expected Results start with `!�.
	 * They're mostly encapsulated into invariants
	 * 
	 * @param source
	 *          reader supplying source
	 * @param packageInfo
	 *          namespace (must conform to current model)
	 */
	private void handleQueries(BufferedReader source, String packageInfo) {

		String strLine;
		StringBuilder statementBuilder = new StringBuilder();

		while ((strLine = this.nextLine(source)) != null
				|| statementBuilder.length() > 0) {

			// reset ocl statement
			statementBuilder.setLength(0);

			if (strLine.startsWith("?")) {
				String methodName = "query_" + (this.testEnv.curConstraintId++);

				statementBuilder.append("context Person\n");
				statementBuilder.append("def: ");
				statementBuilder.append(methodName);
				statementBuilder.append(": "); // String =

				statementBuilder.append(strLine.substring(1));

				// parse statement
				this.parseOclStatement(statementBuilder.toString(), packageInfo);

				// the next ! is considered to be the expected result
			}
			else if (strLine.startsWith("!")) {
				String methodName = "query_" + (this.testEnv.curConstraintId);
				statementBuilder.setLength(0);
				statementBuilder.append("context Person\n");
				statementBuilder.append("inv: self.");
				statementBuilder.append(methodName);
				statementBuilder.append(" = " + strLine.substring(1));

				// parse Statement
				this.parseOclStatement(statementBuilder.toString(), packageInfo);
			}
		}
	}

	/**
	 * returns the next line of the reader by omitting comments, empty lines etc.
	 * It's throwing RuntimeException when the file seems corrupt.
	 * 
	 * @param source
	 * 
	 * @return next line or null in case of end
	 */
	private String nextLine(BufferedReader source) {

		String line;
		try {
			// as long as there are lines to read
			while ((line = source.readLine()) != null) {
				line = line.trim();
				if (line.length() == 0 || line.startsWith("--")) {
					continue;
				}

				if (line.startsWith("package")) {
					throw new RuntimeException(
							"Package information should be only once in an Ocl File");
				}

				return line;
			}

		} catch (IOException e) {
			throw new RuntimeException("Error Reading Source File.", e);
		}

		// file empty or EOF
		return null;
	}

	/**
	 * Loads all constraints and checks them with all model instance objects of
	 * the current instance. Failure and Success are documented via the
	 * benchmarkLogger.
	 */
	public void checkActiveInvariants() {

		bLogger
				.outHead1("Checking current model instance against loaded invariants");
		List<IModelInstanceObject> testObjects =
				this.getActiveModelInstance().getAllModelInstanceObjects();
		List<Constraint> constraints = this.getAllActiveConstraints();

		bLogger.printf("invariants  : %d", constraints.size());
		bLogger.printf("test objects: %d", testObjects.size());
		bLogger.printf("total tests : %d", constraints.size() * testObjects.size());

		NamedElement conElement = null;

		for (IModelInstanceObject obj : testObjects) {
			bLogger.outHead3("test object: " + obj.getName());
			for (Constraint con : constraints) {

				bLogger.outLine("\nConstraint: " + con.getQualifiedName());

				conElement = (NamedElement) con.getConstrainedElement().get(0);
				if (conElement instanceof Property || conElement instanceof Operation) {
					conElement = conElement.getOwner();
				}
				// if they equal
				if (obj.getTypes().contains(conElement)) {

					// Interpret and log result
					this.interpretConstraint(obj, con);

				}
				else {
					bLogger.skipInterpretation();
				}
			}
		}

		this.bLogger.printInterpretationStats();

	}

	/**
	 * checks pre and post conditions one after another.
	 * 
	 * @param guineaPig
	 *          model instance object where constraints are tested
	 * @param method
	 *          name of method to be executed
	 * @param params
	 *          list of parameter names that are expected to be stored in the
	 *          interpretation environment. They're extracted and passed as method
	 *          arguments
	 */
	public void checkPreAndPostConditions(IModelInstanceObject guineaPig,
			String method, String... params) {

		this.checkPreConditions(guineaPig, method);

		// clean statistics between both
		this.bLogger.cleanStatistics();

		this.checkPostConditions(guineaPig, method, params);

	}

	/**
	 * Check pre conditions.
	 * 
	 * @param guineaPig
	 *          model instance object to test the constraints on
	 * @param method
	 *          Method name just for logging
	 */
	public void checkPreConditions(IModelInstanceObject guineaPig, String method) {

		bLogger.outHead1("Checking Pre Conditions");

		bLogger.outHead3("Test Object:");
		bLogger.outLine(guineaPig.getName());
		bLogger.outLine("Method: " + method + "(...)");

		// load all remaining constraints
		List<Constraint> constraints = this.getAllActiveConstraints();

		for (Constraint con : constraints) {

			// doesnt check post conditions
			if (con.getName().contains("_post_")) {
				continue;
			}

			bLogger.outLine("\nConstraint: " + con.getQualifiedName());

			// must be pre then
			assert (con.getName().contains("_pre_"));

			// interpret condition
			this.interpretConstraint(guineaPig, con);

		}

		this.bLogger.printInterpretationStats();

	}

	/**
	 * Check post conditions.
	 * 
	 * @param imiObject
	 *          model instance object to test the constraints on
	 * @param method
	 *          This is invoked when a condition is being tested.
	 * @param params
	 *          variable arguments to specify arguments for the method being
	 *          invoked
	 */
	public void checkPostConditions(IModelInstanceObject imiObject,
			String method, String... params) {

		bLogger.outHead1("Checking Post Conditions");

		bLogger.outHead3("Test Object:");
		bLogger.outLine(imiObject.getName());
		bLogger.outLine("Method: " + method + "(...)");

		// load all remaining constraints
		List<Constraint> constraints = this.getAllActiveConstraints();

		// collect method parameters
		OclAny[] oclParams = this.collectMethodParams(params);

		// execute that method only once!
		boolean methodExecuted = false;

		for (Constraint con : constraints) {

			// ignore pre-conditions
			if (con.getName().contains("_pre_")) {
				continue;
			}

			bLogger.outLine("\nConstraint: " + con.getQualifiedName());

			// constraint must be post then
			assert (con.getName().contains("_post_"));

			// execute method only once
			if (!methodExecuted) {
				OclAny imiObjectInOcl;

				imiObjectInOcl =
						this.myInterpreter.getStandardLibraryFactory().createOclAny(
								imiObject);

				/* Get the parameter types. */
				List<Type> parameterTypes;
				parameterTypes = new ArrayList<Type>();

				for (OclAny oclParam : oclParams) {
					parameterTypes.add(oclParam.getModelInstanceElement().getTypes()
							.iterator().next());
				}
				// end for.

				/* Find the operation. */
				Operation operation;
				operation = null;

				for (Type type : imiObject.getTypes()) {

					operation = type.lookupOperation(method, parameterTypes);
					if (operation != null) {
						break;
					}
					// no else.
				}
				// end for.

				/* Invoke the operation. */
				if (operation != null) {
					imiObjectInOcl.invokeOperation(operation, oclParams);
				}

				else {
					throw new RuntimeException("Operation " + method + " not found.");
				}
				// end else.
			}

			// interpret condition
			this.interpretConstraint(imiObject, con);
		}

		this.bLogger.printInterpretationStats();

	}

	/**
	 * Collect an array of OclAny-Objects registered in the environment.
	 * 
	 * @params params String-Array identifying all Variables that are being
	 *         fetched
	 */
	private OclAny[] collectMethodParams(String... params) {

		OclAny[] oclParams = new OclAny[params.length];
		int counter = 0;
		for (String name : params) {
			oclParams[counter++] = this.myGlobalEnvironment.getVar(name);
		}

		return oclParams;

	}

	/**
	 * Interprets a model instance object with a constraint.
	 * 
	 * @param obj
	 *          model object instance
	 * @param con
	 *          Constraint to be checked.
	 * @pre obj and con are expected to "belong together"
	 */
	private void interpretConstraint(IModelInstanceObject obj, Constraint con) {

		OclAny result = null;

		assert (this.testEnv.loadedConstraints.containsKey(con.getQualifiedName()));
		try {

			result = this.myInterpreter.interpretConstraint(con, obj).getResult();
		} catch (Throwable e) { // catch EVERYTHING
			bLogger.interpretationError(con, obj, e);
			return;
		}

		if (result == null) {
			bLogger.interpretationError(con, obj, null);
			return;
		}

		if (result.oclIsUndefined().isTrue()) {
			bLogger.interpretationError(con, obj, result);
			return;
		}

		try {
			OclBoolean res = (OclBoolean) result;

			if (res != null && res.isTrue()) {
				bLogger.interpretationSuccess(con, obj);
			}
			else {
				bLogger.interpretationError(con, obj, res);
			}
		} catch (ClassCastException e) {
			bLogger.interpretationError(con, obj,
					"Result was not JavaOclBoolean, as expected");

			return;
		} catch (Exception e) {
			bLogger.interpretationError(con, obj, e);
		}
	}

	/**
	 * returns all active constraints starting at the root node
	 */
	private List<Constraint> getAllActiveConstraints() {

		Namespace root = null;
		List<Constraint> constraints = new LinkedList<Constraint>();
		try {
			root = this.myModel.getRootNamespace();
		} catch (ModelAccessException e) {
			throw new RuntimeException(e);
		}

		return this.getAllActiveConstraints(root, constraints);
	}

	/**
	 * Returns all active constraints that are owned by the passed namespace
	 */
	private List<Constraint> getAllActiveConstraints(Namespace ns,
			List<Constraint> constraints) {

		for (Namespace nested : ns.getNestedNamespace()) {
			this.getAllActiveConstraints(nested, constraints);
		}

		// test whether constraint has been loaded this time
		for (Constraint con : ns.getOwnedRule()) {
			if (this.testEnv.loadedConstraints.containsKey(con.getQualifiedName())) {
				constraints.add(con);
			}
		}

		return constraints;
	}

	/**
	 * <p>
	 * Sets the model instance of this {@link TestPerformer}.
	 * </p>
	 * 
	 * @param modelInstance
	 *          The model instance for which the test shall be performed.
	 */
	public void setModelInstanceType(String modelInstance) {

		this.modelInstanceType = modelInstance;
	}

	/**
	 * <p>
	 * Loads a given fileName as an {@link IModelInstance} of the actual selected
	 * {@link IModel}.
	 * </p>
	 * 
	 * @param modelInstanceFileName
	 *          The file of the provider class of the {@link IModelInstance}.
	 * 
	 * @throws RuntimeException
	 *           Thrown, if the given file can not be found.
	 */
	public void loadModelInstance(String modelInstanceFileName)
			throws RuntimeException {

		assert (this.myModel != null);

		// if it was loaded,
		// reactivate it.
		if (this.testEnv.loadedInstances.containsKey(modelInstanceFileName)) {
			this.setActiveModelInstance(this.testEnv.loadedInstances
					.get(modelInstanceFileName));
			return;
		}

		File modelInstanceFile =
				this.safeOpenFile(this.testEnv.fileDirectory + modelInstanceFileName);

		IModelInstanceProvider modelInstanceProvider =
				this.getModelInstanceProvider();

		IModelInstance loadedInstance = null;

		// Load the model instance.
		try {
			loadedInstance =
					modelInstanceProvider.getModelInstance(modelInstanceFile,
							this.myModel);
		} catch (ModelAccessException e) {
			throw new RuntimeException(e);
		}

		assert (loadedInstance != null);

		this.testEnv.loadedInstances.put(modelInstanceFileName, loadedInstance);

		this.setActiveModelInstance(loadedInstance);
	}

	/**
	 * cleans up. This is mostly done when a new TestCase starts.
	 */
	public void clean() {

		// clean loaded constraints map
		this.testEnv.loadedConstraints.clear();

		// clear logger statistics
		this.bLogger.cleanStatistics();
	}

	/**
	 * Sets the active model instance.
	 * 
	 * @param instance
	 * @param add
	 *          set true if the instance should be added as well
	 */
	private void setActiveModelInstance(IModelInstance instance) {

		IModelInstanceRegistry modelInstanceRegistry;
		modelInstanceRegistry = ModelBusPlugin.getModelInstanceRegistry();
		IModelInstance[] instances =
				modelInstanceRegistry.getModelInstances(this.myModel);
		for (IModelInstance inst : instances) {
			// instance already loaded
			if (inst.equals(instance)) {
				// activate and return
				modelInstanceRegistry.setActiveModelInstance(this.myModel, instance);
				return;
			}
		}
		// else add and activate
		modelInstanceRegistry.addModelInstance(this.myModel, instance);
		modelInstanceRegistry.setActiveModelInstance(this.myModel, instance);

		this.myGlobalEnvironment.setModelInstance(instance);
	}

	/**
	 * Gets the active model instance.
	 * 
	 * @return the active model instance
	 */
	private IModelInstance getActiveModelInstance() {

		IModelInstanceRegistry modelInstanceRegistry;
		modelInstanceRegistry = ModelBusPlugin.getModelInstanceRegistry();

		return modelInstanceRegistry.getActiveModelInstance(this.myModel);
	}

	/**
	 * retrieves model instance provider for the current model instance type.
	 * (It's assumed that the modelInstanceType doesn't change during
	 * TestPerformer lifecycle.)
	 * 
	 * @return current model instanceprovider
	 */
	private IModelInstanceProvider getModelInstanceProvider() {

		IModelInstanceTypeRegistry tMTypeReg =
				ModelBusPlugin.getModelInstanceTypeRegistry();
		IModelInstanceType tMInstanceType =
				tMTypeReg.getModelInstanceType(this.modelInstanceType);
		return tMInstanceType.getModelInstanceProvider();
	}

	/**
	 * <p>
	 * Loads an {@link IModel} which uses the corresponding meta model.
	 * </p>
	 * 
	 * @param modelName
	 *          Filename of the model
	 * 
	 * @throws RuntimeException
	 */
	private void loadModel(String modelName) throws RuntimeException {

		/* Check if the model has not already been loaded yet. */
		if (!(this.myModel != null && this.myModel.getDisplayName().equals(
				modelName))) {

			File modelFile;

			modelFile = this.safeOpenFile(this.testEnv.fileDirectory + modelName);

			/* Try to load the model. */
			try {
				IModelRegistry modelRegistry;

				this.myModel = this.metaModel.getModelProvider().getModel(modelFile);

				modelRegistry = ModelBusPlugin.getModelRegistry();

				boolean loaded = false;
				for (IModel model : modelRegistry.getModels()) {
					// model already loaded
					if (myModel.equals(model)) {
						loaded = true;
						break;
					}
				}
				if (!loaded) {
					modelRegistry.addModel(this.myModel);
				}
				modelRegistry.setActiveModel(this.myModel);
			} catch (ModelAccessException e) {
				throw new RuntimeException(e);
			}
		}
		// no else.
	}

	// ************************************
	// * Some Helper Functions
	// ************************************

	/**
	 * Safe open file.
	 * 
	 * @param fileName
	 * 
	 * @return the file
	 * 
	 * @throws RuntimeException
	 */
	private File safeOpenFile(String fileName) throws RuntimeException {

		File tmpFile = new File(fileName);

		// error reporting if it doesnt exists
		if (!tmpFile.exists()) {
			String msg;

			msg = "The requested file ";
			msg += fileName;
			msg += " doesn't exists.";

			throw new RuntimeException(msg);
		}

		return tmpFile;
	}

	/**
	 * Safe open file reader.
	 * 
	 * @param fileName
	 * 
	 * @return the file reader
	 * 
	 * @throws RuntimeException
	 */
	private FileReader safeOpenFileReader(String fileName)
			throws RuntimeException {

		File tmpFile = this.safeOpenFile(fileName);

		try {
			FileReader tmpReader = new FileReader(tmpFile);
			return tmpReader;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error opening file " + fileName
					+ " (it exists, though)");
		}
	}

	/**
	 * creates an object adapting the passed model instance object
	 * 
	 * @param object
	 *          Object to be adapteds
	 */
	public IModelInstanceObject createModelInstanceAdapter(Object object) {

		IModelInstanceObject result = null;
		try {
			result =
					(IModelInstanceObject) this.getActiveModelInstance()
							.addModelInstanceElement(object);
		}

		catch (TypeNotFoundInModelException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * <p>
	 * Add a given {@link Object} as a variable to the
	 * {@link IInterpretationEnvironment} used for preparation and interpretation.
	 * </p>
	 * 
	 * @param path
	 *          The path and name of the variable which shall be set.
	 * @param value
	 *          The {@link IModelInstanceObject} value of the set variable as an
	 *          Object.
	 * @return <code>true</code>, if the given value has been set as a value
	 *         successfully.
	 */
	public boolean setEnvironmentVariable(String path, Object value) {

		boolean result;

		/* Convert the object into an OclAny. */
		OclAny adaptedObject;

		try {
			adaptedObject =
					JavaStandardlibraryPlugin.getStandardLibraryFactory().createOclAny(
							this.myGlobalEnvironment.getModelInstance()
									.getModelInstanceFactory().createModelInstanceElement(value));

			/* Add the variable to the environment. */
			this.myInterpreter.setEnviromentVariable(path, adaptedObject);

			result = true;
		}

		catch (TypeNotFoundInModelException e) {
			result = false;
		}

		return result;
	}

	/**
	 * creates an ocl root adapter from a model instance adapter in order to being
	 * able to execute a method on the model level
	 */
	public OclAny createOclRootAdapterByMIObject(IModelInstanceObject obj) {

		return JavaStandardlibraryPlugin.getStandardLibraryFactory().createOclAny(
				obj);
	}
}