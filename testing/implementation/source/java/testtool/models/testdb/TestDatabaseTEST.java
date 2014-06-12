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

import static org.junit.Assert.*;

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
		assertTrue(tdb instanceof TestDatabase);
	}

	@Test 
	public final void testCreateTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		ArrayList<Question> questionL = new ArrayList<Question>();
		//questionL.add(new Question());
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("author", "gpickett");
		tdb.createTest(data, questionL);
		assertTrue (tdb.tests.size() > 0);
	}

	@Test
	public final void testGetIdPos() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		tdb.save();
		tdb.idPos = 0;
		assertTrue (tdb.getIdPos() == 0);
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
		assertTrue (tdb.getIdPos() == 1);
	}

	@Test
	public final void testGetTest() {
		TestDatabase tdb = new TestDatabase();
		tdb.tests.clear();
		ArrayList<Question> questionL = new ArrayList<Question>();
		HashMap<String, String> data = new HashMap<String, String>();
		testtool.models.testdb.Test r = tdb.createTest(data, questionL);
		tdb.save();
		assertTrue (tdb.getTest("uniqueId", "0").contains(tdb.tests.get(0)));
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
		int[] a = {0};
		assertTrue(tdb.removeTest(a).equals(r));
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
		int[] a = {0};
		tdb.removeTest(a);
		tdb.save();
		assertTrue(tdb.tests.size() == 0);
	}

}
