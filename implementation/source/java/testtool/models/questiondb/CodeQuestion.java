package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding to a Coding question
 * Students will be asked to fill in some code which will then
 * be taken and fed through STDIN to the instructor defined script
 * which will run and output a number from 0-100
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 21apr14
 *
 */
public class CodeQuestion extends Question {
	/**
	 * The path to where the script to check student answers
	 * against is stored
	 */
	String scriptPath;
	
	public CodeQuestion(String qt, String auth, String lu, String course,
			ArrayList<String> topics, int time, int diff, String path) {
		this.questionText = qt;
		this.author = auth;
		this.lastUsed = lu;
		this.course = course;
		this.topics = topics;
		this.time = time;
		this.difficulty = diff;
		this.scriptPath = path;
	}
}