package testtool.models.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.TestCase;
import testtool.models.student.MyCourses;
import testtool.models.userdb.Student;
import testtool.models.courses.Course;

/**
 * @author Alvin Lam
 * @version 09jun14
 * Tests the mycourses methods
 * First Checks for CourseDB file and runs viewCourses that would return true if file is found
 * Second checks viewAllCourses method by comparing the arraylist obtained with expected output
 */
public class JUT_MyCourses extends TestCase {
	MyCourses CoursesModel = new MyCourses();

	public JUT_MyCourses(String name) {
		super(name);
	}
	
	public void testCourseDBFileCheck() {
		try {
			File file = new File("CourseDB.txt");
		    Scanner inFile = new Scanner(file);
		    assertTrue(CoursesModel.viewCourses(new Student()));
		    inFile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("no file found");
		}
	}
	
	public void testReadCourseDB() {
		try {
			ArrayList<Course> courseList = new ArrayList<Course>();
			Course course1 = new Course();
			course1.setCourseName("CPE101-01");
			course1.setCourseInstructor("Gene Fisher");
			
			Course course2 = new Course();
			course2.setCourseName("CPE308-01");
			course2.setCourseInstructor("Gene Fisher");
			
			Course course3 = new Course();
			course3.setCourseName("CPE102-03");
			course3.setCourseInstructor("Gene Fisher");
			
			courseList.add(course1);
			courseList.add(course2);
			courseList.add(course3);
			
			ArrayList<Course> courseList2 = CoursesModel.getAllCourses();
			
			for (int i = 0; i < 3; i++) {
				assertTrue(courseList.get(i).getCourseInstructor().equals(courseList2.get(i).getCourseInstructor()));
				assertTrue(courseList.get(i).getCourseName().equals(courseList2.get(i).getCourseName()));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("no file found Read CourseDB");
		}
	}
}