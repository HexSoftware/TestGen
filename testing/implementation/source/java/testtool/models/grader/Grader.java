package testtool.models.grader;
import testtool.models.testdb.Test;
import testtool.models.userdb.Student;

/**
 * @author Kevin Pham (kpham11@calpoly.edu)
 * @version 26apr14
 * 
 * Class defines a grader
 */


public class Grader {
	static int permission = 3;
	
	//Constructs a grader 
	public Grader() {
		//System.out.println("In grader.Constructor.");
	}	
	
	
	/**
	 * Releases a test with specified options
	 * @param test - the test the grader wants to release
	 * @param options - the options the grader wants to release the test with
	 */
	/*@
	requires
		(*
		 * The test is ready for release
		 * There's atleast one release option
		 *);
	ensures
		(*
		 * Students will be able to see their test results/
		 *);
 */
    public void releaseTest(Test test, ReleaseOptions options) {
		System.out.println("In graer.releaseTest.");
	}
	

    /**
	 * Releases a test with specified options
	 * @param test - the test the grader wants to release
	 * @param options - the options the grader wants to release the test with
	 */
    /*@
	requires
		(*
		 * The student exists
		 *);
	ensures
		(*
		 * Student will be selected
		 *);
 */
	public void selectStudent(Student student){
		System.out.println("In grader.selectStudent.");
	}
	
	
	
	/**
	 * Saves the progress of grading of a test
	 * @param test - the test the grader wants to save
	 * 
	 */
	/*@
	requires
		(*
		 * The Test hasn't already been released
		 *);
	ensures
		(*
		 * Progress of grading will be saved onto computer
		 *);
 */
	public void saveProgress(Test test) {
		System.out.println("In grader.saveProgress.");
	}
	
	
	/**
	 * Finalizes grading for a test by setting flag for test completion to true
	 * @param test - the test the grader wants to finalize
	 * 
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
	public void finishGrading(Test test) {
		System.out.println("In grader.finishGrading.");
	}
}

