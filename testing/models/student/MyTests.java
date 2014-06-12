package testtool.models.student;
import testtool.models.testdb.*;
import testtool.models.courses.*;

import java.util.Collection;
import java.util.ArrayList;

import testtool.models.userdb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 27may14
 * 
 * MyTests is a list of tests for a course. It is 
 * derived from Section 2.4 of the requirements.
 */
  public class MyTests {
  
  /**
   * Removes unscheduled tests from the list of tests
   * @param tests - the ArrayList of tests
   * @return ArrayList<Test> - the updated arraylist after removals
  */
  /*@
   ensures
   //
   // An ArrayList of Tests are returned without any unscheduled tests left
   //
 @*/
  public ArrayList<Test> removeUnscheduled(ArrayList<Test> tests) {
	  for (int i = 0; i < tests.size(); i++) {
		  if (tests.get(i).getTestParam("state").equals("unscheduled")) {
			  tests.remove(i);
		  }
	  }
	  return tests;
  }
  
  /**
   * Finds the lowest category number from the list of tests
   * @param tests - the ArrayList of tests
   * @return String - return the string value number of the category number
  */
  /*@
   requires
   //
   // All tests to have a category number
   //
   (for all tests.getTestParam("testCategoryNum") != null)
 @*/
  public String getSmallestCategoryNum(ArrayList<Test> tests) {
	  String smallest = tests.get(0).getTestParam("testCategoryNum");
	  System.out.println("smallest is " + smallest);
	  for (int i = 0; i < tests.size(); i++) {
		  if (tests.get(i).getTestParam("testCategoryNum").compareTo(smallest) < 0) {
			  smallest = tests.get(i).getTestParam("testCategoryNum");
		  }
	  }
	  return smallest;
  }
}
