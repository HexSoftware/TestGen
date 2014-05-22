package testtool.models.grader;
import testtool.models.testdb.Test;

import java.util.ArrayList;
import java.util.Collection;
/**
 * The ReleaseOptions class is meant to be a dialogue to
 * allow the Instructor or Proctor to decide what sorts of
 * options to release a graded test with.
 * Options could include: Just show grade, only show missed
 * questions, show all questions, etc.
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @author Kevin Pham (kpham11@calpoly.edu)
 * @version 27apr14
 *
 */

public class ReleaseOptions {
	/**
	 * The test that the options belong to
	 */
	Test gradedTest;
	/**
	 * The collection of options chosen by the Instructor
	 * or Proctor
	 */
	private ArrayList<String> options;
	
	
	public ReleaseOptions() {
		options = new ArrayList<String>();
	}
	
	/**
	 * This method will add any options to the
	 * collection of options that the Instructor
	 * or Proctor specify
	 */
	/*@
		requires
			(*
			 * The specified Test is finished being graded
			 *);
		ensures
			(*
			 * An option is added to the collection of options
			 *);
	 */
	public void addOption(String option) {
		options.add(option);
	}
	/**
	 * This method will remove any options from
	 * the collection of options that the Instructor
	 * or Proctor Specifies
	 */
	/*@
		requires
			(*
			 * The specified Test is finished being graded
			 *);
		ensures
			(*
			 * An option was removed from the collection of options
			 *);
	 */
	void removeOption(String option) {
		options.remove(option);
	}
	
	/**
	 * Finalizes the chosen options to release a test.
	 */
	/*@
	requires
		(*
		 * Atleast one option has been selected
		 *);
	ensures
		(*
		 * Test will be given list of selected options
		 *);
 */
	public void submitOptions() {
		for(int i = 0; i<options.size(); i++) {
			System.out.println(options.get(i));
		}
	}
	
	/**
	 * @return  An ArrayList of all the options
	 */
	public ArrayList<String> getOptions() {
		return options;
	}
}
