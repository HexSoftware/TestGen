package testtool.models.userdb;
import java.util.ArrayList;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 26apr14
 * 
 * Class defines a student
 */
public class Student {
	String name;
	String username;
	String pass;
	ArrayList<String> courses = new ArrayList<String>();

	/**
	 * gets the student's name
	 * @return Student.name
	 */
	public String getStudentName() {
		return name;
	}
	
	/**
	 * gets the student's username
	 * @return Student.username
	 */
	public String getStudentUsername() {
		return username;
	}
	
	/**
	 * gets the student's password
	 * @return Student.pass
	 */
	public String getStudentPass() {
		return pass;
	}
	
	/**
	 * gets the student's courses
	 * @return Student.courses
	 */
	public ArrayList<String> getStudentCourses() {
		return courses;
	}
	
	/**
	 * sets the student's name
	 * @param name - the name of the student
	 */
	public void setStudentName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the student username
	 * @param username - the username of the student
	 */
	public void setStudentUsername(String username) {
		this.username = username;
	}
	
	/**
	 * adds a course to the student
	 * @param course - course the student is enrolled in
	 */
	public void addCourse(String course) {
		courses.add(course);
	}
}
