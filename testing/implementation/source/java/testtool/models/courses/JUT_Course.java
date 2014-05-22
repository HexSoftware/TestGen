package testtool.models.courses;

import junit.framework.TestCase;
import testtool.models.courses.Course;

/**
 * @author Alvin Lam
 * @version 21may14
 * Tests the course methods
 */
public class JUT_Course extends TestCase {

	public JUT_Course(String name) {
		super(name);
	}
	
	public void testAddCourse() {
		Course course1 = new Course();
		
		course1.setCourseName("Course 1");
		course1.setCourseInstructor("Instructor 1");
		
		assertTrue(course1.getCourseName().equals("Course 1"));
		assertTrue(course1.getCourseInstructor().equals("Instructor 1"));
	}
}
