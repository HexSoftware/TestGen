package testtool.models.questiondb;
import java.util.Collection;

/**
 * Question type corresponding with a short answer question
 * The student's answer will be compared with a list of
 * correct keywords, the order of the keywords does not
 * matter for this question.
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
 *
 */
public class SAQuestion extends Question {
	/**
	 * The collection of keywords that the automatic
	 * grader should be looking for, in any order.
	 */
	Collection<String> correctKWs;
}