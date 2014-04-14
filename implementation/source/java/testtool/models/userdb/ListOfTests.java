package userdb;
@author Yuliya Levitskaya
import java.util.Collection;

import testdb.Test;

/**
 * This class displays the list of tests that the instructor had generated.
 */
public abstract class ListOfTests {
	Collection<Test> tests;
	
	/**
     	* Method used in adding a new test.
	* @param t - Test to add
	* The test must not be the same as a test already in the userdb
     	*/
	abstract boolean add(Test t){
		System.out.println("In ListOfTest.add.");
	}

	/**
     	* Method used in removing a new test.
     	* @param t - Test to remove
	* The given test must already be in the userdb
     	*/
	abstract boolean remove(Test t){
		System.out.println("In ListOfTest.remove.");
	}

    	/**
    	* Method used in opening the test.
     	* @param t - Test to open
	*The given test must already be in the userdb
     	*/
	abstract boolean open(Test t){
		System.out.println("In ListOfTest.open.");
	}

	/**
     	* Method used in closing a given test.
     	* @param t - Test to close
	*The given test must already be in the userdb
     	*/
	abstract boolean close(Test t){
		System.out.println("In ListOfTest.close.");
	}

    	/**
     	* Method used in opening the options menu for the test.
     	* @param t - Test to open options for
	* The given test must already be in the userdb
     	*/
	abstract boolean options(Test t){
		System.out.println("In ListOfTest.options.");
	}
}
