package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding with a True/False question
 * the student will simply specify whether or not a statement was true
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 27apr14
 *
 */
public class TFQuestion extends Question {
	/**
	 * The correct answer : Either True or False
	 */
	boolean correctAnswer;
	
	/**
	 * The constructor will do data validation when creating a new True/False
	 * @param qt
	 * @param auth
	 * @param course
	 * @param topics
	 * @param time
	 * @param diff
	 * @param corAns
	 * @throws EmptyBoxException
	 */
	/*@
	 * requires (* all parameters to be passed in as non-null.); ensures (* a new question
	 * is made and that all fields are non-null.);	  
	 @*/
	public TFQuestion(String qt, String auth, String course,
		ArrayList<String> topics, int time, int diff, boolean corAns) throws EmptyBoxException {
		if (qt.equals("")) {
			throw new EmptyBoxException("Question Text must be filled in.");
		} else {
			this.questionText = qt;
		}
		
		this.author = auth;
		this.lastUsed = "Never";
		
		if (course.equals("") || course.equals("Course")) {
			throw new EmptyBoxException("Course must be filled in.");
		} else {
			this.course = course;
		}
		
		if (topics.equals("") || topics.equals("Topic")) {
			throw new EmptyBoxException("Topic must be filled in.");
		} else {
			this.topics = topics;
		}
		
		this.time = time;
		this.difficulty = diff+1;
		
		this.correctAnswer = corAns;
		this.type = "TF";
	}
}