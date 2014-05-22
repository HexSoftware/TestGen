/****
 *
 * Class TestDatabase is the database for tests. 
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

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import testtool.models.questiondb.Question;
import testtool.models.testdb.TestDatabase;

public class TestDatabaseTest {

	@Test
	public final void testTestDatabase() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		assert (tdb instanceof TestDatabase);
	}

	@Test 
	public final void testCreateTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		ArrayList<Question> questionL = new ArrayList<Question>();
		HashMap<String, String> data = new HashMap<String, String>();
		assert (tdb.createTest(data, questionL).equals(tdb.tests.get(tdb.tests
				.size())));
	}

	@Test
	public final void testEditTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		assert (false);// unimplemented
	}

	@Test
	public final void testGetIdPos() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		tdb.idPos = 0;
		assert (tdb.getIdPos() == 0);
	}

	@Test
	public final void testGetIdPos2() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		tdb.idPos = 0;
		ArrayList<Question> questionL = new ArrayList<Question>();
		HashMap<String, String> data = new HashMap<String, String>();
		tdb.createTest(data, questionL);
		assert (tdb.getIdPos() == 1);
	}

	@Test
	public final void testGetTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		assert (tdb.getTest("uniqueId", "0").equals(tdb.tests.get(0)));
	}

	@Test
	public final void testPublishTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		assert (false);// unimplemented
	}

	@Test
	public final void testRemoveTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		ArrayList<Question> questionL = new ArrayList<Question>();
		HashMap<String, String> data = new HashMap<String, String>();
		testtool.models.testdb.Test r = tdb.createTest(data, questionL);
		tdb.createTest(data, questionL);
		assert (tdb.removeTest(r).equals(r));
	}

	@Test
	public final void testTakeTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		assert (false);// unimplemented
	}

	@Test
	public final void testSave() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		File f = new File("empty.txt");
		ArrayList<Question> questionL = new ArrayList<Question>();
		HashMap<String, String> data = new HashMap<String, String>();
		testtool.models.testdb.Test r = tdb.createTest(data, questionL);
		tdb.removeTest(r);
		assert (tdb.save().getName().equals("database.txt"));
	}

}
