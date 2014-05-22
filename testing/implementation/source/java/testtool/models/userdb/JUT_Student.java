package testtool.models.userdb;

import java.util.ArrayList;

import junit.framework.TestCase;
import testtool.models.userdb.Student;

/**
 * @author Alvin Lam
 * @version 21may14
 * Tests the Student methods
 */
public class JUT_Student extends TestCase {

	public JUT_Student(String name) {
		super(name);
	}
	
	public void testAddStudent() {
		Student student = new Student();
		ArrayList<String> testList = new ArrayList<String>();
		ArrayList<String> courseList = new ArrayList<String>();
		
		student.setStudentName("studentName");
		student.setStudentUsername("StudentUserName");
		student.addCourse("course1");
		student.addCourse("course2");
		
		testList.add("course1");
		testList.add("course2");
		
		assertTrue(student.getStudentName().equals("studentName"));
		assertTrue(student.getStudentUsername().equals("StudentUserName"));
		courseList = student.getStudentCourses();
		
		for (int i = 0; i < courseList.size(); i++) {
			assertTrue(courseList.get(i).equals(testList.get(i)));
		}
	}
}
