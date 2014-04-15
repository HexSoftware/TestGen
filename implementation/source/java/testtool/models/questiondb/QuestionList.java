package questiondb;
import java.util.Collection;

/**
 * QuestionList allows more detailed interactions with the graphical list of
 * Questions. This includes selecting questions for editing, removal, or
 * generation of a test, along with bringing up the question popup. The 
 * questions element is a list of Questions that keep track of being selected 
 * popup status information.
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 14apr14
 */
public class QuestionList {
	Collection<QuestionEntry> questions;

	/**
	 * question popup will bring up the question popup dialogue when a 
	 * QuestionEntry q moused over for a long enough amount of time. This will 
	 * show more detailed information of the question, such as the full 
	 * question text and answers, along with previews of any images.
	 * @param q - question to show more detail of
	 */
	/*@
		requires
			(*
			 * That q is a QuestionEntry that is in the databank, and that q is
			 * a valid QuestionEntry.
			 *);
		ensures
			(*
			 * That a valid QuestionEntry with a question from the databank is
			 * displayed.
			 *);
	@*/
	public void questionPopup(QuestionEntry q) {
		System.out.println("In QuestionList.questionPopup");
	}

	/**
	 * toggleQuestionSelect will toggle the QuestionEntry q as (un)marked, 
	 * either for editing/removal or for being added to a test. 
	 * @param q - question to select or deselect
	 */
	/*@
		requires
			(*
			 * That QuestionEntry q is a valid QuestionEntry and is in the 
			 * databank.
			 *);
		ensures
			(*
			 * That a valid questionEntry in the databank has its selction 
			 * toggled.
			 *);
	@*/
	public void toggleQuestionSelect(QuestionEntry q) {
		System.out.println("In QuestionList.toggleQuestionSelect");
	}
}
