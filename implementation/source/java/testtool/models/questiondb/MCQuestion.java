package testtool.models.questiondb;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Question type corresponding to a multiple choice question
 * The user will choose 0-n answers that they believe to be correct
 * and will then simply compare the answers that they put with the
 * instructor defined correct answers
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 21apr14
 *
 */
public class MCQuestion extends Question {
	/**
	 * The collection of answers that are defined by the
	 * Instructor as options
	 */
	Collection<String> possibleAnswers;
	/**
	 * The collection of answers that are considered the
	 * right answer by the Instructor
	 */
	Collection<Integer> correctAnswerIndexes;

	public MCQuestion(String qt, String auth, String lu, String course,
		ArrayList<String> topics, int time, int diff, Collection<String> pa,
		Collection<Integer> cai) {
		this.questionText = qt;
		this.author = auth;
		this.lastUsed = lu;
		this.course = course;
		this.topics = topics;
		this.time = time;
		this.difficulty = diff;
		this.possibleAnswers = pa;
		this.correctAnswerIndexes = cai;
	}
}