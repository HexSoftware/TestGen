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
  * The collection of tests of where the list is derived from.
  */
  Collection<Test> tests;
   
  /**
   * The current student user
   */
  Student user;

  /**
   * The course the student is currently viewing.
   */
  Course course;
  
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
  
  /**
   * Displays a list of tests in a course.
   * @param course - Course to view Tests of
   * @param student - Student of whose courses to display
  */
  /*@
   requires
   //
   // login to return true. Course must exist in the Collection of courses, 
   // Student must be in the selected course.
   //
   (login(user, password) == true && viewCourses(student) == true)

   ensures
   //
   // A list of tests is in the output.
   //
 @*/
  public void viewTests(Course course, Student student) {
     System.out.println("In MyCourses.viewTests.");
  }
}
