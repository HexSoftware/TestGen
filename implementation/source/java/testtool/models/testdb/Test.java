package testtool.models.testdb;
import java.util.Collection;

import testtool.models.courses.Course;
import testtool.models.questiondb.Question;

public class Test {
	public int uniqueId;
	public boolean published;
	public boolean opened;
	public boolean graded;
	public Collection<Question> questions;
	public String testTitle;
	public String author;
	public String lastUsed;
	public int totalQuestions;
	public int totalPoints;
	public int totalTime;
	public int avgDifficulty;
	public Course course;
}
