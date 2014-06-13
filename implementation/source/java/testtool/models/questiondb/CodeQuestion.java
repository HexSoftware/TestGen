package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding to a Coding question
 * Students will be asked to fill in some code which will then
 * be taken and fed through STDIN to the instructor defined script
 * which will run and output a number from 0-100
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 11jun14
 *
 */
public class CodeQuestion extends Question {
	/**
	 * The path to where the script to check student answers
	 * against is stored
	 */
	public String scriptPath;
	
	/**
	 * The constructor will do data validation when creating a new Code
	 * Question
	 * 
	 * @param qt - Question Text
	 * @param auth - Question Author
	 * @param course - Course
	 * @param topics - Topics
	 * @param time - Estimated Completion Time
	 * @param diff - Difficulty
	 * @param path - Path to Instructor's Grading Script
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
	public CodeQuestion() {
		
	}
	
	public CodeQuestion(String qt, String auth, String course,
			ArrayList<String> topics, int time, int diff, String path, int points) throws EmptyBoxException {
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
		if (topics.isEmpty() || topics.contains("Topic") || topics == null) {
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
		 * if path is empty then throw an error
		 * else set path to passed in path
		 */
		if (path.equals("")) {
			throw new EmptyBoxException("Path must be filled in.");
		} else {
			this.scriptPath = path;
		}
		
		/*
		 * hard-coded
		 */
		this.type = "Code";
		/*
		 * points error checking is done in view
		 */
		this.points = points;
	}

	
	/**
	 * 
	 * @return path to script
	 */
	public String getScriptPath() {
		return scriptPath;
	}


	/**
	 * sets path to script variable
	 * @param scriptPath
	 */
	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}



	@Override
	public String toString() {
		return super.toString() + ", scriptPath=" + scriptPath;
	}
	
	
}
