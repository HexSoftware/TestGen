package testtool.models.questiondb;

/**
 * Question type corresponding with a True/False question
 * the student will simply specify whether or not a statement was true
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
 *
 */
public class TFQuestion extends Question {
	/**
	 * The correct answer : Either True or False
	 */
	boolean correctAnswer;
}