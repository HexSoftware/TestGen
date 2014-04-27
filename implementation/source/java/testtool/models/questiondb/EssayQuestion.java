package testtool.models.questiondb;
import java.util.ArrayList;

/**
 * Question type corresponding with an Essay question
 * A users answer will be compared with a list of ordered
 * keywords and a grade will be based on the correctness and
 * order of those words in the answer
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 27apr14
 *
 */
public class EssayQuestion extends Question {
	/**
	 * The collection of keywords that the automatic grader
	 * should be looking for in order.
	 */
	ArrayList<String> correctKWs;
	
	/**
	 * The constructor will do data validation when creating a new Essay
	 * @param qt
	 * @param auth
	 * @param course
	 * @param topics
	 * @param time
	 * @param diff
	 * @param ckws
	 * @throws EmptyBoxException
	 */
	/*@
	 * requires (* all parameters to be passed in as non-null.); ensures (* a new question
	 * is made and that all fields are non-null.);	  
	 @*/
	public EssayQuestion(String qt, String auth, String course,
		ArrayList<String> topics, int time, int diff, ArrayList<String> ckws) throws EmptyBoxException {
		if (qt.equals("")) {
			throw new EmptyBoxException("Question Text must be filled in.");
		} else {
			this.questionText = qt;
		}
		
		this.author = auth;
		this.lastUsed = "Never";
		
		if (course.equals("") || course.equals("Course")) {
			throw new EmptyBoxException("Course must be filled in.");
		} else {
			this.course = course;
		}
		
		if (topics.equals("") || topics.equals("Topic")) {
			throw new EmptyBoxException("Topic must be filled in.");
		} else {
			this.topics = topics;
		}
		
		this.time = time;
		this.difficulty = diff+1;
		
		if (ckws.isEmpty()) {
			throw new EmptyBoxException("Correct Keywords must be filled in.");
		} else {
			this.correctKWs = ckws;
		}
		this.type = "Essay";
	}
}