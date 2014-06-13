package testtool.models.grader;

import junit.framework.TestCase;

/****
 *
 * Class GraderTest is the companion testing class for class <a href=
 * Grader.html> Grader </a>.  It implements the following module test plan:
 *                                                                         <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test the selectStudent and releaseTest methods
 *                                                                      <p><li>
 *     Phase 3: Unit test the saveProgress and finishGrading methods
 *                                                                      <p><li>
 *     Phase 4: Repeat phases 1 through 5.
 *                                                                      <p><li>
 *     Phase 5: Stress test by releasing 1000 tests.
 *                                                                        </ul>
 */


public class GraderTEST extends TestCase {


	protected GraderTEST() {
		Grader grader = new Grader();
	}
	
	

}
