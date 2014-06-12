package testtool.models.questiondb;
import java.util.ArrayList;

/**
 * Question type corresponding to a multiple choice question
 * The user will choose 0-n answers that they believe to be correct
 * and will then simply compare the answers that they put with the
 * instructor defined correct answers
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 10jun14
 *
 */
public class MCQuestion extends Question {
	/**
	 * The collection of answers that are defined by the
	 * Instructor as options
	 */
	public ArrayList<String> possibleAnswers;
	/**
	 * The collection of answers that are considered the
	 * right answer by the Instructor
	 */
	public ArrayList<Integer> correctAnswerIndices;

	/**
	 * The constructor will do data validation when creating a new Multiple Choice
	 * Question
	 * 
	 * @param qt - Question Text
	 * @param auth - Question Author
	 * @param course - Course
	 * @param topics - Topics
	 * @param time - Estimated Completion Time
	 * @param diff - Difficulty
	 * @param pa - List of Possible Answers
	 * @param cai - List of Indices
	 * @throws EmptyBoxException
	 */
	/*@
	 	requires 
	 		(* all parameters to be passed in as non-empty
	 		 * 0 <= diff <= 4
	 		 * time >= 0
	 		 * cai must have integers that are within the range of 0 -> pa.length-1
	 		 *); 
	 	ensures 
	 		(* a new question is made and that all fields are non-empty
	 		 *);	  
	 @*/
	public MCQuestion(String qt, String auth, String course,
		ArrayList<String> topics, int time, int diff, ArrayList<String> pa,
		ArrayList<Integer> cai, int points) throws EmptyBoxException {
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
		
		if (topics.isEmpty() || topics.equals("Topic")) {
			throw new EmptyBoxException("Topic must be filled in.");
		} else {
			this.topics = topics;
		}
		
		this.time = time;
		this.difficulty = diff;
		
		if (pa.isEmpty()) {
			throw new EmptyBoxException("There must be at least two possible answers.");
		} else {
			this.possibleAnswers = pa;
		}
		
		if (cai.isEmpty()) {
			throw new EmptyBoxException("There must be at least one correct answer.");
		} else {
			this.correctAnswerIndices = cai;
		}
		
		this.type = "MC";
		this.points = points;
	}

	
	
	public ArrayList<String> getPossibleAnswers() {
		return possibleAnswers;
	}



	public void setPossibleAnswers(ArrayList<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}



	public ArrayList<Integer> getCorrectAnswerIndices() {
		return correctAnswerIndices;
	}



	public void setCorrectAnswerIndices(ArrayList<Integer> correctAnswerIndices) {
		this.correctAnswerIndices = correctAnswerIndices;
	}



	@Override
	public String toString() {
		return super.toString() + ", possibleAnswers=" + possibleAnswers
				+ ", correctAnswerIndices=" + correctAnswerIndices;
	}
	
	
}
