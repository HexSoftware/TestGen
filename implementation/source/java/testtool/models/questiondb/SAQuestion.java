package testtool.models.questiondb;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Question type corresponding with a short answer question
 * The student's answer will be compared with a list of
 * correct keywords, the order of the keywords does not
 * matter for this question.
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 27apr14
 *
 */
public class SAQuestion extends Question {
	/**
	 * The collection of keywords that the automatic
	 * grader should be looking for, in any order.
	 */
	Collection<String> correctKWs;
	
	/**
	 * The constructor will do data validation when creating a new Short Answer
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
	public SAQuestion(String qt, String auth, String course,
		ArrayList<String> topics, int time, int diff, Collection<String> ckws) throws EmptyBoxException {
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
		this.type = "SA";
	}
}