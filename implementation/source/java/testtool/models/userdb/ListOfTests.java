package testtool.models.userdb;
/**/
import java.util.Collection;

import testtool.models.testdb.Test;

/**
 * This class displays the list of tests that the instructor had generated.
 * @author Yuliya Levitskaya
 */
public class ListOfTests {
	Collection<Test> tests;
	public ListOfTests(){
		
	}

	/**
     	* Method used in adding a new test.
	* @param t - Test to add
	* The test must not be the same as a test already in the userdb
     	*/
	/*@
		requires
			(*
			 * The specified Test is not already in the db
			 *);
		ensures
			(*
			 * The test is added to the db.
			 *);
	 */
	public boolean add(Test t){
		System.out.println("In ListOfTest.add.");
		if(t == null)
			return false;
		return true;
	}

	/**
     	* Method used in removing a new test.
     	* @param t - Test to remove
	* The given test must already be in the userdb
     	*/
	/*@
		requires
			(*
			 * The specified Test to exist in the db
			 *);
		ensures
			(*
			 * The test is removed from the database
			 *);
	 */
	public boolean remove(Test t){
		System.out.println("In ListOfTest.remove.");
		if(t == null)
			return false;
		return true;
	}

    	/**
    	* Method used in opening the test.
     	* @param t - Test to open
	*The given test must already be in the userdb
     	*/
	/*@
		requires
			(*
			 * The test to be in the db and not be open
			 *);
		ensures
			(*
			 * The test is available to the students
			 *);
	 */
	public boolean open(Test t){
		System.out.println("In ListOfTest.open.");
		if(t == null)
			return false;
		t.setTestParam("state", "Open");
		return true;
	}

	/**
     	* Method used in closing a given test.
     	* @param t - Test to close
	*The given test must already be in the userdb
     	*/
	/**
	 * This method will add any options to the
	 * collection of options that the Instructor
	 * or Proctor specify
	 */
	/*@
		requires
			(*
			 * The specified Test is in the db and is not closed already
			 *);
		ensures
			(*
			 * Test will be closed and not available to students
			 *);
	 */
	public boolean close(Test t){
		System.out.println("In ListOfTest.close.");
		if(t == null)
			return false;
		t.setTestParam("state", "Closed");
		return true;
	}
	/**
 	* Method used grading a given test.
 	* @param t - Test to close
*The given test must already be in the userdb
 	*/
	/*@
		requires
			(*
			 * The specified Test is in the database
			 *);
		ensures
			(*
			 * The test will be graded
			 *);
	 */
	public boolean grade(Test t){
		System.out.println("In ListOfTest.grade.");
		if(t == null)
			return false;
		t.setTestParam("state", "Graded");
		return true;
	}
}