package testtool.models.courses;
import java.util.Collection;

import testtool.models.userdb.Student;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 20apr14
 * 
 * A Course is the information stored about a course. 
 * The name field is a unique course name and section of any length.
 * instructor is a string of any length containing a name. 
 * students is the list of students enrolled in the course.
 */
public class Course {
	private String name;
	private String instructor;
	private Collection<Student> students;
	
	public String getCourseName() {
		return name;
	}
	
	public String getCourseInstructor() {
		return instructor;
	}
	
	public void setCourseName(String name) {
		this.name = name;
	}
	
	public void setCourseInstructor(String instructor) {
		this.instructor = instructor;
	}
}