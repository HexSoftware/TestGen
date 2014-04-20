package testtool.models.questiondb;
import java.util.Collection;

/**
 * Question type corresponding with an Essay question
 * A users answer will be compared with a list of ordered
 * keywords and a grade will be based on the correctness and
 * order of those words in the answer
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
 *
 */
public class EssayQuestion extends Question {
	/**
	 * The collection of keywords that the automatic grader
	 * should be looking for in order.
	 */
	Collection<String> correctKWs;
}