package testtool.models.questiondb;

import org.testng.annotations.*;

/****
 * 
 * Class QuestionPopupTEST is the companion testing class for <a href=
 * QuestionPopup.html> QuestionPopup </a>. It implements the following module
 * test plan:
 * 																		 <ul>
 * 																	  <p><li>
 * 		Phase 1: Unit test the constructor
 * 																	  <p><li>
 * 		Phase 2: Unit test DisplayQuestion method
 * 																	  <p><li>
 * 		Phase 3: Unit test Close method
 * 																	  <p><li>
 * 		Phase 4: Repeat 1-3
 * 																		</ul> 
 * 
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 28apr14
 *
 */

@Test
public class QuestionPopupTEST extends QuestionPopup {

	/**
	 * Empty constructor, needed to placate the compiler, since parent QuestionPopup
	 * constructor takes one argument
	 */
	protected QuestionPopupTEST() {
		super(null);
	}
	
	@Test
	protected void testQuestionPopup() {
		
	}
	
	@Test(dependsOnMethods = {"testQuestionPopup"})
	protected void testDisplayQuestion() {
		
	}
	
	@Test(dependsOnMethods = {"testQuestionPopup", "testDisplayQuestion"})
	protected void Close() {
		
	}
}
