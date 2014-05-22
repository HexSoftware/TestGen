/****
 *
 * Class ManualGenerationis the class that generates tests based on parameters. 
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
import org.junit.Test;

import testtool.models.testdb.ManualGeneration;
import testtool.models.testdb.TestDatabase;

public class ManualGenerationTest {

	@Test
	public final void testAutomaticGeneration() {
		ManualGeneration ag = new ManualGeneration(new TestDatabase());
		assert (ag instanceof ManualGeneration);
	}

	@Test
	public final void testSetParams() {
		ManualGeneration ag = new ManualGeneration(new TestDatabase());
		ag.setParams("author", "gpickett");
		assert (ag.settings.get("author").equals("gpickett"));
	}

	@Test
	public final void testAdd() {
		ManualGeneration ag = new ManualGeneration(new TestDatabase());
		assert (false); //not implemented
	}

	@Test
	public final void testRemove() {
		ManualGeneration ag = new ManualGeneration(new TestDatabase());
		assert (false); //not implemented
	}

	@Test
	public final void testGenerate() {
		ManualGeneration ag = new ManualGeneration(new TestDatabase());
		assert(ag.generate() instanceof testtool.models.testdb.Test);
	}
}
