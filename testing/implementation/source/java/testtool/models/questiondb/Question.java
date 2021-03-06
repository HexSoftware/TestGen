package testtool.models.questiondb;
import java.util.ArrayList;
/**
 * The Question class is the superclass of all question types
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 11jun14
 * 
 */
public class Question {
	/**
	 * The question text is the actual question that is being asked in
	 * a question
	 */
	public String questionText;

	/**
	 * The author is the instructor that wrote and added the question to the
	 * databank
	 */
	public String author;
	/**
	 * lastUsed is the data / time of the last time a question was used on a test
	 */
	public String lastUsed;
	/**
	 * The course is the class that a question was originally made for
	 */
	public String course;
	/**
	 * topics is a collection of strings that are tags to easily
	 * filter through the question databank for
	 */
	public ArrayList<String> topics;
	/**
	 * The time is the amount of the author believes this question should take
	 */
	public int time;
	/**
	 * The difficulty is in a range of 1-5;
	 * 1 being easy and 5 being hard
	 */
	public int difficulty;
	/**
	 * The type of the question. Used only for display purposes.
	 */
	public String type;
	
	public int points;
	
	/**
	 * This method is meant allow other classes to get the parameter information.
	 * 
	 * @param i - option for what information you want returned
	 * @return - the parameter you chose to get in String form
	 */
	/*@
	 	requires
	 		(*
	 		 * 0 <= i <= 7
	 		 *);
	 	ensures
	 		(*
	 		 * A string is returned
	 		 *);
	 @*/
	protected String get(int i) {
		switch (i) {
		case 0: return course;
		case 1:
			String topic = "";
			for (String s : topics) {
				topic += s + ", ";
	 		}
			topic = topic.substring(0, topic.length() - 2);
	 		return topic; 
	 	case 2: return type;
	 	case 3: return questionText;
	 	case 4: return new Integer(difficulty).toString();
	 	case 5: return new Integer(time).toString();
	 	case 6: return lastUsed;
	 	case 7: return author;
	 	case 8: return new Integer(points).toString();
	 	default: return "error: invalid field";
	 	}
	 }
	
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(String lastUsed) {
		this.lastUsed = lastUsed;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public ArrayList<String> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<String> topics) {
		this.topics = topics;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "questionText=" + questionText + ", author=" + author
				+ ", lastUsed=" + lastUsed + ", course=" + course + ", topics="
				+ topics + ", time=" + time + ", difficulty=" + difficulty
				+ ", type=" + type + ", points=" + points;
	}
	
	
	
}
