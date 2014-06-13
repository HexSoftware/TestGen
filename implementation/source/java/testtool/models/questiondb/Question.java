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
	public String get(int i) {
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
	
	/**
	 * 
	 * @return question text
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * sets question text to passed in string
	 * @param questionText
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * set author to passed in string
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 
	 * @return last time used
	 */
	public String getLastUsed() {
		return lastUsed;
	}

	/**
	 * set last used to passed in string
	 * @param lastUsed
	 */
	public void setLastUsed(String lastUsed) {
		this.lastUsed = lastUsed;
	}

	/**
	 * 
	 * @return course that the question belongs to
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * sets the course to the passed in string
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 
	 * @return topics that the question pertains to
	 */
	public ArrayList<String> getTopics() {
		return topics;
	}

	/**
	 * sets the topics to the passed in list
	 * @param topics
	 */
	public void setTopics(ArrayList<String> topics) {
		this.topics = topics;
	}

	/**
	 * 
	 * @return length of time to question
	 */
	public int getTime() {
		return time;
	}

	/**
	 * sets length of time of question to passed in int
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * 
	 * @return difficulty level of question
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * sets difficult level to the number passed in
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * 
	 * @return type of question
	 */
	public String getType() {
		return type;
	}

	/**
	 * sets type of question to string passed in
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return points that a question is worth
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * sets points a question is worth to the passed in int
	 * @param points
	 */
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
