package testtool.models.questiondb;


/**
 * This class is for the popup dialogue that will show up
 * when an Instructor hovers their mouse over a question
 * while viewing a Test. It will reveal more data than the
 * table view will be able to display.
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
 *
 */

public class QuestionPopup {
	/**
	 * The Question that the popup is referring to
	 */
	Question question;
	
	/**
	 * This method will open the popup dialogue for
	 * the specified question
	 */
	/*@
		requires
			(*
			 * That there is not a QuestionPopup already open
			 *);
		ensures
			(*
			 * A QuestionPopup is now open
			 *);
	 */
	public void displayQuestion() {
		System.out.println("In QuestionPopup.displayQuestion.");
	}
	/**
	 * This method will close the popup dialogue for
	 * the specified question
	 */
	/*@
		requires
			(*
			 * A QuestionPopup dialogue be open
			 *);
		ensures
			(*
			 * The QuestionPopup dialogue is closed
			 *);
	 */
	public void close() {
		System.out.println("In QuestionPopup.close.");
	}
}
