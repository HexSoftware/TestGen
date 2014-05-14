package testtool.models.student;
import testtool.models.testdb.*;
import testtool.models.courses.*;

import java.util.Collection;
import java.util.ArrayList;

import testtool.models.userdb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
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
  
  public String getSmallestCategoryNum(ArrayList<Test> tests) {
	  String smallest = tests.get(0).getTestParam("testCategoryNum");
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
   
  /**
    * Displays a status of a test in a course.
    * @param test - Test to view overview of
    * @param student - The student viewing the test
    */
  /*@
    requires
    //
    // Test must exist in the test database.
    // Student must be in the course the test is assigned to.
    //
    (\exists Test test; testdb.contains(test); course.students.contains(user);
      test.course.equals(course))

    ensures
    //
    // The test overview to be shown of the test. 
    //
  @*/
   public void viewTestOverview(Test test, Student student) {
      System.out.println("In MyTests.viewTestOverview.");
   }
}
