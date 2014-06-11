package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding to a Coding question
 * Students will be asked to fill in some code which will then
 * be taken and fed through STDIN to the instructor defined script
 * which will run and output a number from 0-100
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 10jun14
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
	public CodeQuestion(String qt, String auth, String course,
			ArrayList<String> topics, int time, int diff, String path, int points) throws EmptyBoxException {
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
		this.difficulty = diff;
		
		if (path.equals("")) {
			throw new EmptyBoxException("Path must be filled in.");
		} else {
			this.scriptPath = path;
		}
		
		this.type = "Code";
		this.points = points;
	}

	
	
	public String getScriptPath() {
		return scriptPath;
	}



	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}



	@Override
	public String toString() {
		return super.toString() + ", scriptPath=" + scriptPath;
	}
	
	
}
