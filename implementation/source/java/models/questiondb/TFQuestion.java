package questiondb;

/**
 * Question type corresponding with a True/False question
 * the student will simply specify whether or not a statement was true
 */
public abstract class TFQuestion extends Question {
	/**
	 * The correct answer : Either True or False
	 */
	boolean correctAnswer;
}