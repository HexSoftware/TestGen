/****
 *
 * Class Test is the model for tests. 
 * It implements the following module test plan:
 *                                                                         <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test the simple access method.
 *                                                                      <p><li>
 *     Phase 3: Unit test the complex methods.
 *                                                                      <p><li>
 *     Phase 4: Repeat phases 1 through 3.
 *                                                                      <p><li>
 *     Phase 5: Stress test by adding, removing, editing and deleting 100000 items.
 *                                                                        </ul>
 */
package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import testtool.models.questiondb.Question;
import testtool.models.testdb.TestDatabase;

public class TestTest { 

	@Test
	public final void testTest() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		assertTrue (t instanceof testtool.models.testdb.Test);
	}

	@Test
	public final void testTest2() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test(new HashMap<String, String>(), new ArrayList<Question>());
		assertTrue (t instanceof testtool.models.testdb.Test);
	}

	@Test
	public final void testGetTestParam() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		t.testParams.put("author", "gpickett");
		assertTrue (t.getTestParam("author").equals("gpickett"));
	}

	@Test
	public final void testSetTestParam() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();

		t.setTestParam("author", "gpickett");
		assertTrue (t.getTestParam("author").equals("gpickett"));
	}

	@Test
	public final void testGetQuestionList() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		ArrayList<Question> qs = new ArrayList<Question>();
		assertTrue((t.getQuestionList()).getClass().equals(qs.getClass())); // TODO
	}

	@Test
	public final void testGetIdPos() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		assertTrue (tdb.getIdPos() == 1);
	}

	@Test
	public final void testToString() {
		/** The parameters (settings) of a test. Used by the program. */
		HashMap<String, String> testParams = new HashMap<String, String>();
		testParams.put("author", "gpickett");
		/** The questions a student takes */
		ArrayList<Question> questionList = new ArrayList<Question>();
		questionList.add(new Question());
		testtool.models.testdb.Test t = new testtool.models.testdb.Test(testParams, questionList);
		assertTrue(t.toString() instanceof String);
	}

}
