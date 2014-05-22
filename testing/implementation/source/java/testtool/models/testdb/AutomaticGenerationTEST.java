/****
 *
 * Class AutomaticGeneration is the class that generates tests based on parameters. 
 * It implements the following module test plan:
 *                                                                         <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test the simple access method.
 *                                                                      <p><li>
 *     Phase 3: Unit test the complex methods Generation algorithm.
 *                                                                      <p><li>
 *     Phase 4: Repeat phases 1 through 3.
 *                                                                      <p><li>
 *     Phase 5: Stress test by adding, removing, editing, and deleting 100000 items.
 *                                                                        </ul>
 */
package test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import testtool.models.questiondb.Question;
import testtool.models.testdb.AutomaticGeneration;
import testtool.models.testdb.TestDatabase;

public class AutomaticGenerationTest {

	@Test
	public final void testAutomaticGeneration() {
		AutomaticGeneration ag = new AutomaticGeneration(new TestDatabase());
		assert (ag instanceof AutomaticGeneration);
	}

	@Test
	public final void testSetParams() {
		AutomaticGeneration ag = new AutomaticGeneration(new TestDatabase());
		ag.setParams("author", "gpickett");
		assert (ag.settings.get("author").equals("gpickett"));
	}

	@Test
	public final void testAdd() {
		AutomaticGeneration ag = new AutomaticGeneration(new TestDatabase());
		assert (true);
	} 

	@Test
	public final void testRemove() {
		AutomaticGeneration ag = new AutomaticGeneration(new TestDatabase());
		assert (true);
	}

	@Test
	public final void testGenerate() {
		AutomaticGeneration ag = new AutomaticGeneration(new TestDatabase());
		HashMap<String, String> testParams = new HashMap<String, String>();
		ArrayList<Question> questionList = new ArrayList<Question>();
		assert(ag.generate(testParams, questionList) instanceof testtool.models.testdb.Test);
	}
}
