package testtool.models.questiondb;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Question type corresponding with an Essay question
 * A users answer will be compared with a list of ordered
 * keywords and a grade will be based on the correctness and
 * order of those words in the answer
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 21apr14
 *
 */
public class EssayQuestion extends Question {
	/**
	 * The collection of keywords that the automatic grader
	 * should be looking for in order.
	 */
	Collection<String> correctKWs;
	
	public EssayQuestion(String qt, String auth, String lu, String course,
			ArrayList<String> topics, int time, int diff, Collection<String> ckws) {
			this.questionText = qt;
			this.author = auth;
			this.lastUsed = lu;
			this.course = course;
			this.topics = topics;
			this.time = time;
			this.difficulty = diff;
			this.correctKWs = ckws;
		}
}