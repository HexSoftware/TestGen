package testtool.models.student;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import testtool.models.userdb.*;
import testtool.models.courses.*;
import testtool.views.courses.CourseList;

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
    * Checks username and password to login student
    * @param username - user's calpoly username
    * @param password - user's password
   */
   /*@
    requires
    //
    // The username must exist in the user database and cannot be null..
    //
    (\exists String username; userdb.calpolyID.contains(username))

    ensures
    //
    // A boolean is in the output, true if the inputted password matches the password of the user
    // false otherwise. Sets Student user to equal username
    //
    result password.equals(user.password)
  @*/
   public boolean login (String username, String password) {
   	if (username.equals("")) {
   		return false;
   	}
   	
   	Student curStudent = new Student();
	   
		try {
			File file = new File("StudentDB.txt");
		   Scanner inFile = new Scanner(file);
			
			while (inFile.hasNextLine()) {
			   curStudent.setStudentUsername(inFile.nextLine());
			   
			   if (curStudent.getStudentUsername().equals(username)) {
			   	System.out.println("User exists");
			   	curStudent.setStudentName(inFile.nextLine());
			   	inFile.next();
			   	int i = inFile.nextInt();
			   	System.out.println(i);
			   	for (inFile.nextLine(); i > 0; i--) {
			   		curStudent.addCourse(inFile.nextLine());
			   	}
			   	inFile.close();
			   	
			   	viewCourses(curStudent);
			   	return true;
			   }
			   else {
			   	System.out.println(inFile.nextLine());
			   	System.out.println(inFile.next());
			   	for (int i = inFile.nextInt(); i >= 0; i--) {
			   		System.out.println(inFile.nextLine());
			   	}
			   	System.out.println(inFile.nextLine());
			   }
		   }
			
			inFile.close();
			return false;
		} catch (FileNotFoundException e) {
			System.out.println("StudentDB not found");
		}
      return false;
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
		
   	new CourseList(studentCourses);
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
