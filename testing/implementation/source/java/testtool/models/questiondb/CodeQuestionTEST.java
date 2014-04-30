package testtool.models.questiondb;

import org.testng.annotations.*;

/****
 * 
 * Class CodeQuestionTEST is the companion testing class for <a href=
 * CodeQuestion.html> CodeQuestion </a>. It implements the following module
 * test plan:
 * 																		 <ul>
 * 																	  <p><li>
 * 		Phase 1: Unit test the constructor
 * 																	  <p><li>
 * 		Phase 2: Stress test by creating 10000 CodeQuestions
 * 																		</ul>
 * 
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 28apr14
 *
 */

@Test
public class CodeQuestionTEST extends CodeQuestion {
	/**
	 * Empty Constructor, needed to placate the compiler, since parent
	 * CodeQuestion constructor takes 7 arguments.
	 */
	public CodeQuestionTEST() throws EmptyBoxException {
		super(null, null, null, null, -1, -1, null);
	}
}
