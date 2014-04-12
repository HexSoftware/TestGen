package questiondb;

/**
 * This class is for the popup dialogue that will show up
 * when an Instructor hovers their mouse over a question
 * while viewing a Test. It will reveal more data than the
 * table view will be able to display.
 */

public abstract class QuestionPopup {
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
	abstract void displayQuestion();
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
	abstract void close();
}
