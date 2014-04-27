package testtool.models.courses;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 26apr14
 * 
 * A Course is the information stored about a course. 
 * The name field is a unique course name and section of any length.
 * instructor is a string of any length containing a name. 
 * students is the list of students enrolled in the course.
 */
public class Course {
	private String name;
	private String instructor;
	
	/**
	 * retrieves the course name
	 * @return Course.name
	 */
	public String getCourseName() {
		return name;
	}
	
	/**
	 * retrieves the course instructor's name
	 * @return Course.instructor
	 */
	public String getCourseInstructor() {
		return instructor;
	}
	
	/**
	 * sets the name for the course
	 * @param name - the course name to set
	 */
	public void setCourseName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the instructor for the course
	 * @param instructor - the instructor to set
	 */
	public void setCourseInstructor(String instructor) {
		this.instructor = instructor;
	}
}