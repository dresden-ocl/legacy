/**
 * 
 */
package tudresden.ocl20.pivot.ocl2parser.test.uml2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.ocl2parser.test.AllUML2Tests;
import tudresden.ocl20.pivot.ocl2parser.test.TestPerformer;

/**
 * @author uni
 * 
 */
public class CollectionRangeTest {

	private static TestPerformer testPerformer;
	static final String OCL_TEST_FILE_DIRECTORY =
			"oclTestFiles/CollectionRangeTest/";

	/**
	 * @throws Exception
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		testPerformer =
				TestPerformer.getInstance(AllUML2Tests.META_MODEL_NAME,
						AllUML2Tests.MODEL_BUNDLE, AllUML2Tests.MODEL_BUNDLE_PATH);
		testPerformer.setModel("royalsandloyals.uml");
	}

	@Test
	public void testCollectionRangeSucceed() {

		String fileName =
				CollectionRangeTest.OCL_TEST_FILE_DIRECTORY
						+ "CollectionRangeTest_notFail.ocl";
		try {
			testPerformer.parseFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Unable to open ocl file:" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Collection which should be parseable failed to parse in "
					+ fileName);
		}
	}

	@Test
	public void testCollectionRangeFailFloat() {

		String fileName =
				CollectionRangeTest.OCL_TEST_FILE_DIRECTORY
						+ "CollectionRangeTest_Fail_Float.ocl";
		try {
			testPerformer.parseFile(fileName);
			fail("Collection which should not be parseable succeed to parse in "
					+ fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Unable to open ocl file:" + fileName);
		} catch (Exception e) {
		}
	}

	@Test
	public void testCollectionRangeFailString() {

		String fileName =
				CollectionRangeTest.OCL_TEST_FILE_DIRECTORY
						+ "CollectionRangeTest_Fail_String.ocl";
		try {
			testPerformer.parseFile(fileName);
			fail("Collection which should not be parseable succeed to parse in "
					+ fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Unable to open ocl file:" + fileName);
		} catch (Exception e) {
		}
	}

	@Test
	public void testCollectionRange_UpperBoundFail() {

		String filename =
				CollectionRangeTest.OCL_TEST_FILE_DIRECTORY
						+ "CollectionRangeTest_Fail_upperBoundFail.ocl";
		try {
			testPerformer.parseFile(filename);
			fail("Collection which should not be parseable succeed to parse in "
					+ filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Unable to open ocl file:" + filename);
		} catch (Exception e) {
		}
	}
}
