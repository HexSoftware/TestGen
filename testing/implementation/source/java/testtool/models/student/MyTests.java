package testtool.models.student;
import testtool.models.testdb.*;
import testtool.models.courses.*;

import java.util.Collection;

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
