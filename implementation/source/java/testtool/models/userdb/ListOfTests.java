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
	public boolean add(Test t){
		System.out.println("In ListOfTest.add.");
		return true;
	}

	/**
     	* Method used in removing a new test.
     	* @param t - Test to remove
	* The given test must already be in the userdb
     	*/
	public boolean remove(Test t){
		System.out.println("In ListOfTest.remove.");
		return true;
	}

    	/**
    	* Method used in opening the test.
     	* @param t - Test to open
	*The given test must already be in the userdb
     	*/
	public boolean open(Test t){
		System.out.println("In ListOfTest.open.");
		return true;
	}

	/**
     	* Method used in closing a given test.
     	* @param t - Test to close
	*The given test must already be in the userdb
     	*/
	public boolean close(Test t){
		System.out.println("In ListOfTest.close.");
		return true;
	}
	/**
 	* Method used grading a given test.
 	* @param t - Test to close
*The given test must already be in the userdb
 	*/
	public boolean grade(Test t){
		System.out.println("In ListOfTest.grade.");
		return true;
	}

    	/**
     	* Method used in opening the options menu for the test.
     	* @param t - Test to open options for
	* The given test must already be in the userdb
     	*/
	 public boolean options(Test t){
		System.out.println("In ListOfTest.options.");
		return true;
	}
}
