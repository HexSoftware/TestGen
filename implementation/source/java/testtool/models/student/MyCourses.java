package testtool.models.student;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import testtool.models.userdb.*;
import testtool.models.courses.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 20apr14
 * 
 * MyCourses is the repository of courses for a student and their homepage. It is 
 * derived from Section 2.1.3 of the requirements.
 */
 public class MyCourses {
   /**
    * The current student user
   */
   Student user;
   
   public ArrayList<Course> getAllCourses (Student username) throws FileNotFoundException {
	   
	   ArrayList<Course> courseList = new ArrayList<Course>();
	   Course c = new Course();
	   
	   File file = new File("CourseDB.txt");
	   Scanner inFile = new Scanner(file);
	   
	   while (inFile.hasNext()) {
		   c.setCourseName(inFile.nextLine());
		   c.setCourseInstructor(inFile.nextLine());
		   courseList.add(c);
	   }
	   
	   return courseList;
   }
   
   /**
    * Checks username and password to login student
    * @param username - user's calpoly username
    * @param password - user's password
   */
   /*@
    requires
    //
    // The username must exist in the user database. Password must match the user in database.
    //
    (\exists String username; userdb.calpolyID.equals(username))

    ensures
    //
    // A boolean is in the output, true if the inputted password matches the password of the user
    // false otherwise. Sets Student user to equal username
    //
    result password.equals(user.password) && user = username
  @*/
   public boolean login (String username, String password) {
      System.out.println("In MyCourses.login.");
      return true;
   }
   
   /**
    * Displays the list of courses for a student
    * @param student - the student for which the list of courses is to be displayed
    * @return boolean - true on success, otherwise false
   */
   /*@
    requires
    //
    // Student must be in the courses. Must be logged in first
    //
    (login(user, password) == true && viewCourses(student) == true)
      (\exists Course course; coursedb.contains(course); coursedb.students.contains(student))

    ensures
    //
    // A boolean is in the output
    // A list of courses the student is in is displayed.
    //
  @*/
   public void viewCourses (Student student) {
      System.out.println("In MyCourses.viewCourses.");
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
