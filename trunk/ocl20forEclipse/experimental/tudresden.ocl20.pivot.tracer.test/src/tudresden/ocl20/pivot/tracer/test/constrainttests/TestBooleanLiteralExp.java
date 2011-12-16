package tudresden.ocl20.pivot.tracer.test.constrainttests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.language.ocl.resource.ocl.Ocl22Parser;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.modelinstance.IModelInstance;
import tudresden.ocl20.pivot.modelinstancetype.types.IModelInstanceObject;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.tracer.TracerPlugin;
import tudresden.ocl20.pivot.tracer.test.AbstractTracerTest;
import tudresden.ocl20.pivot.tracer.test.TracerTestPlugin;
import tudresden.ocl20.pivot.tracer.tracermodel.TracerRoot;


public class TestBooleanLiteralExp extends AbstractTracerTest {

	@BeforeClass
	public static void setUp() throws Exception {
		AbstractTracerTest.setUp();
	}
	
	@AfterClass
	public static void tearDown() {
		AbstractTracerTest.tearDown();
	}
	
	@Test
	public void testConstraintTracer01() throws Exception {
		/* Load the model */
		File modelFile;
		try {
			modelFile = AbstractTracerTest.getFile("bin/package1/Model1.class",
					TracerTestPlugin.PLUGIN_ID);
		} catch(IOException e) {
			throw new ModelAccessException(e.getMessage(), e);
		}
		
		IModel model;
		model = Ocl2ForEclipseFacade.getModel(modelFile,
				Ocl2ForEclipseFacade.JAVA_META_MODEL);
		
		assertNotNull(model);
		
		/* Find the type for the IMIObjects to test. */
		Type objectType;
		objectType = model.findType(Arrays
				.asList(new String[] { "Class1" }));

		assertNotNull(objectType);
		
		File constraintFile;
		try {
			constraintFile = AbstractTracerTest.getFile("resources/constraints.ocl",
					TracerTestPlugin.PLUGIN_ID);
		} catch(IOException e) {
			throw new ModelAccessException(e.getMessage(), e);
		}
		
		assertNotNull(constraintFile);
		assertTrue(constraintFile.canRead());
		
		List<Constraint> constraints;
		constraints = Ocl2ForEclipseFacade.parseConstraints(constraintFile,
				model, true);
		/*
		constraints = Ocl22Parser.INSTANCE.parseOclString(
				"package package1 context Class1 inv: self.intProperty = 0 endpackage", model);
		*/
		
		assertNotNull(constraints);
		assertTrue(constraints.size() >= 1);
		
		/* Load or get the instance. */
		File instanceFile;
		try {
			instanceFile = AbstractTracerTest.getFile("bin/package1/Instance1.class",
					TracerTestPlugin.PLUGIN_ID);
		} catch (IOException e) {
			throw new ModelAccessException(e.getMessage(), e);
		}
		
		IModelInstance modelInstance;
		modelInstance = Ocl2ForEclipseFacade.getModelInstance(instanceFile,
				model, Ocl2ForEclipseFacade.JAVA_MODEL_INSTANCE_TYPE);
		
		assertNotNull(modelInstance);
		
		/* Find the IMIObject(s) to test. */
		Set<IModelInstanceObject> imiObjects;
		imiObjects = modelInstance.getAllInstances(objectType);

		assertNotNull(imiObjects);
		
		/* Send the constraints to the interpreter */
		for(IModelInstanceObject imiObject : imiObjects) {
			Ocl2ForEclipseFacade.interpretConstraints(
					constraints, modelInstance, imiObject);
		}
		// end for.
		
		model.removeConstraints(constraints);
		
		TracerRoot tracedRoot;
		tracedRoot = TracerPlugin.getInterpreterTraceListener().getTree();
		
		assertNotNull(tracedRoot);
		assertTrue(tracedRoot.getRootItems().size() >= 1);
	}
}
