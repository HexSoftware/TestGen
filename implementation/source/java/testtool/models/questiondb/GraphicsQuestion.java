package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding to a graphics question
 * A student will be asked to create an image in a different
 * program and then upload it to this program
 * This type of question must be graded manually
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 21apr14
 *
 */
public class GraphicsQuestion extends Question {
	
	public GraphicsQuestion(String qt, String auth, String lu, String course,
			ArrayList<String> topics, int time, int diff) {
		this.questionText = qt;
		this.author = auth;
		this.lastUsed = lu;
		this.course = course;
		this.topics = topics;
		this.time = time;
		this.difficulty = diff;
	}
}