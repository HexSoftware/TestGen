package testtool.models.grader;
import testtool.models.testdb.Test;
import java.util.Collection;
/**
 * The ReleaseOptions class is meant to be a dialogue to
 * allow the Instructor or Proctor to decide what sorts of
 * options to release a graded test with.
 * Options could include: Just show grade, only show missed
 * questions, show all questions, etc.
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
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
	Collection<String> options;
	
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
	void addOption(String option) {
		System.out.println("In ReleaseOptions.addOption.");
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
		System.out.println("In ReleaseOptions.removeOption.");
	}
}