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

import java.util.ArrayList;

import org.junit.Test;

import testtool.models.questiondb.Question;

public class TestTest { 

	@Test
	public final void testTest() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		assert (t instanceof testtool.models.testdb.Test);
	}

	@Test
	public final void testGetTestParam() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		t.testParams.put("author", "gpickett");
		assert (t.getTestParam("author").equals("gpickett"));
	}

	@Test
	public final void testSetTestParam() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();

		t.setTestParam("author", "gpickett");
		assert (t.getTestParam("author").equals("gpickett"));
	}

	@Test
	public final void testGetQuestionList() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		ArrayList<Question> qs = new ArrayList<Question>();
		assert ((t.getQuestionList()).getClass().equals(qs.getClass())); // TODO
	}

	@Test
	public final void testToString() {
		testtool.models.testdb.Test t = new testtool.models.testdb.Test();
		assert (t.toString().equals("test"));
	}

}
