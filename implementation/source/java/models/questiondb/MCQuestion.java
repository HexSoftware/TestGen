package questiondb;
import java.util.Collection;

/**
 * Question type corresponding to a multiple choice question
 * The user will choose 0-n answers that they believe to be correct
 * and will then simply compare the answers that they put with the
 * instructor defined correct answers
 */
public abstract class MCQuestion extends Question {
	/**
	 * The collection of answers that are defined by the
	 * Instructor as options
	 */
	Collection<String> possibleAnswers;
	/**
	 * The collection of answers that are considered the
	 * right answer by the Instructor
	 */
	Collection<String> correctAnswerIndexes;
}