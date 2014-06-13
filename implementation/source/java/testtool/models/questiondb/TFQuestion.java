package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding with a True/False question
 * the student will simply specify whether or not a statement was true
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 10jun14
 *
 */
public class TFQuestion extends Question {
	/**
	 * The correct answer : Either True or False
	 */
	public boolean correctAnswer;
	
	/**
	 * The constructor will do data validation when creating a new True/False
	 * Question
	 * 
	 * @param qt - Question Text
	 * @param auth - Question Author
	 * @param course - Course
	 * @param topics - Topics
	 * @param time - Estimated Completion Time
	 * @param diff - Difficulty
	 * @param corAns - Correct Boolean Answer
	 * @param points - Number of points the question is worth
	 * @throws EmptyBoxException
	 */
	/*@
	 	requires 
	 		(* all parameters to be passed in as non-empty
	 		 * 0 <= diff <= 4
	 		 * time >= 0
	 		 *); 
	 	ensures 
	 		(* a new question is made and that all fields are non-empty
	 		 *);	  
	 @*/
	public TFQuestion(String qt, String auth, String course,
		ArrayList<String> topics, int time, int diff, boolean corAns, int points) throws EmptyBoxException {
		/*
		 * If question text is empty throw an error
		 * else set questionText to qt
		 */
		if (qt.equals("")) {
			throw new EmptyBoxException("Question Text must be filled in.");
		} else {
			this.questionText = qt;
		}
		
		/*
		 * Author is generated based on logged in user
		 * so will never be empty
		 */
		this.author = auth;
		
		/*
		 * right when a question is created or edited
		 * it will be reset to never been used before
		 */
		this.lastUsed = "Never";
		
		/*
		 * if course is empty or equal to the default text
		 * throw an error
		 * else set course to passed in course
		 */
		if (course.equals("") || course.equals("Course")) {
			throw new EmptyBoxException("Course must be filled in.");
		} else {
			this.course = course;
		}
		
		/*
		 * if topics has nothing in the arraylist has only the default text
		 * throw an error
		 * else set topics to passed in topics
		 */
		if (topics.isEmpty() || topics.equals("Topic")) {
			throw new EmptyBoxException("Topic must be filled in.");
		} else {
			this.topics = topics;
		}
		
		/*
		 * time error checking is done in the view
		 */
		this.time = time;
		
		/*
		 * difficulty is on a 1-5 scale that is dealt with by a combobox and the view
		 */
		this.difficulty = diff;
		
		/*
		 * either true or false
		 */
		this.correctAnswer = corAns;
		
		/*
		 * hard-coded
		 */
		this.type = "TF";
		
		/*
		 * points error checking is done in view
		 */
		this.points = points;
	}

	
	/**
	 * 
	 * @return boolean of correct answer
	 */
	public boolean isCorrectAnswer() {
		return correctAnswer;
	}


	/**
	 * sets correct answer to passed in boolean
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}



	@Override
	public String toString() {
		return super.toString() + ", correctAnswer=" + correctAnswer;
	}
	
	
}
