package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding with a True/False question
 * the student will simply specify whether or not a statement was true
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 21apr14
 *
 */
public class TFQuestion extends Question {
	/**
	 * The correct answer : Either True or False
	 */
	boolean correctAnswer;
	
	public TFQuestion(String qt, String auth, String lu, String course,
		ArrayList<String> topics, int time, int diff, boolean corAns) {
		this.questionText = qt;
		this.author = auth;
		this.lastUsed = lu;
		this.course = course;
		this.topics = topics;
		this.time = time;
		this.difficulty = diff;
		this.correctAnswer = corAns;
	}
}