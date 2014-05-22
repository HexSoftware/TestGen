

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
