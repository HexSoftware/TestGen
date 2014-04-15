package testtool.models.testdb;
import java.util.Collection;

import testtool.models.courses.Course;
import testtool.models.questiondb.Question;

public abstract class Test {
	boolean published;
	boolean opened;
	boolean graded;
	Collection<Question> questions;
	String testTitle;
	String author;
	String lastUsed;
	int totalQuestions;
	int totalPoints;
	int totalTime;
	int avgDifficulty;
	Course course;
}
