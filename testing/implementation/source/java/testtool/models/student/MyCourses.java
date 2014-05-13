package testtool.models.student;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import testtool.models.userdb.*;
import testtool.models.courses.*;


/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 26apr14
 * 
 * MyCourses is the repository of courses for a student and their homepage. It is 
 * derived from Section 2.1.3 of the requirements.
 */
 public class MyCourses {
   /**
    * The current student user
   */
   Student user;
   
   /**
    * Scans the CourseDB.txt and returns an arraylist of all the courses
    * @return ArrayList<Course> - all the courses read in the CourseDB
    * @throws FileNotFoundException - the CourseDB.txt is not found in the root directory
    */
   public ArrayList<Course> getAllCourses() throws FileNotFoundException {
	   
	   ArrayList<Course> courseList = new ArrayList<Course>();
	   
	   File file = new File("CourseDB.txt");
	   Scanner inFile = new Scanner(file);
	   
	   for (int i = 0; inFile.hasNextLine(); i++) {
		   courseList.add(new Course());
		   courseList.get(i).setCourseName(inFile.nextLine());
		   courseList.get(i).setCourseInstructor(inFile.nextLine());
	   }
	   
	   inFile.close();
	   
	   return courseList;
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
    (login(user, password) == true)
      (\exists Student student; StudentDB.contains(student))

    ensures
    //
    // A boolean is in the output
    // A list of courses the student is in is displayed.
    //
  @*/
   public void viewCourses (Student student) {
   	ArrayList<String> courseNames = new ArrayList<String>();
   	courseNames = student.getStudentCourses();
   	ArrayList<Course> studentCourses = new ArrayList<Course>();

		try {
			ArrayList<Course> allCourses = getAllCourses();
			
			int numCourses = allCourses.size();
			for (int i = 0; i < numCourses; i++) {
	   		if (courseNames.contains(allCourses.get(i).getCourseName())) {
	   			studentCourses.add(allCourses.get(i));
	   		}
	   	}
	   } catch (FileNotFoundException e1) {
			System.out.println("No Course Database");
		}
		
      System.out.println("In MyCourses.viewCourses.");
   }
}
