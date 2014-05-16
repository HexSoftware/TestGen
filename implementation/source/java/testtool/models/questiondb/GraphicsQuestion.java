package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * Question type corresponding to a graphics question
 * A student will be asked to create an image in a different
 * program and then upload it to this program
 * This type of question must be graded manually
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 12may14
 *
 */
public class GraphicsQuestion extends Question {
	
	/**
	 * The constructor will do data validation when creating a new Graphic
	 * Question
	 * 
	 * @param qt - Question Text
	 * @param auth - Question Author
	 * @param course - Course
	 * @param topics - Topics
	 * @param time - Estimated Completion Time
	 * @param diff - Difficulty
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
	public GraphicsQuestion(String qt, String auth, String course,
			ArrayList<String> topics, int time, int diff) throws EmptyBoxException {
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
		
		this.type = "Graphic";
	}

	@Override
	public String toString() {
		return super.toString() + ",";
	}
	
	
}