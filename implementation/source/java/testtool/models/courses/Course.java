package testtool.models.courses;
import java.util.Collection;

import testtool.models.userdb.Student;

/**
 * @author Alvin
 * A Course is the information stored about a course. 
 * The name field is a unique course name and section of any length.
 * instructor is a string of any length containing a name. 
 * students is the list of students enrolled in the course.
 */
public class Course {
	String name;
	String instructor;
	Collection<Student> students;
}