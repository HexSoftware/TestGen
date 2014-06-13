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
	 * @param points - Number of points the question is worth
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
		 * if possible answers is empty or <2 than throw an error
		 * else set possibleAnswers to passed in pa
		 */
		if (pa.isEmpty() || pa.size() < 2) {
			throw new EmptyBoxException("There must be at least two possible answers.");
		} else {
			this.possibleAnswers = pa;
		}
		
		/*
		 * if correct answer index is empty throw an error
		 * else set correctAnswerIndices to passed in cai
		 */
		if (cai.isEmpty()) {
			throw new EmptyBoxException("There must be at least one correct answer.");
		} else {
			this.correctAnswerIndices = cai;
		}
		
		/*
		 * hard-coded
		 */
		this.type = "MC";
		/*
		 * points error checking is done in view
		 */
		this.points = points;
	}

	
	/**
	 * 
	 * @return list of possible answers
	 */
	public ArrayList<String> getPossibleAnswers() {
		return possibleAnswers;
	}


	/**
	 * set possibleAnswers to passed in list
	 * @param possibleAnswers
	 */
	public void setPossibleAnswers(ArrayList<String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}


	/**
	 * 
	 * @return list of the indices of the correct answers
	 */
	public ArrayList<Integer> getCorrectAnswerIndices() {
		return correctAnswerIndices;
	}


	/**
	 * set correctAnswerIndices to passed in list
	 * @param correctAnswerIndices
	 */
	public void setCorrectAnswerIndices(ArrayList<Integer> correctAnswerIndices) {
		this.correctAnswerIndices = correctAnswerIndices;
	}



	@Override
	public String toString() {
		return super.toString() + ", possibleAnswers=" + possibleAnswers
				+ ", correctAnswerIndices=" + correctAnswerIndices;
	}
	
	
}
