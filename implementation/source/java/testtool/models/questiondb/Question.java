package testtool.models.questiondb;
import java.util.ArrayList;
/**
 * The Question class is the superclass of all question types
 *
 * @author RJ Almada (rjalmada@calpoly.edu), Neil Nordhof (nnordhof@calpoly.edu)
 * @version 21apr14
 */
public class Question {
	/**
	 * The question text is the actual question that is being asked in
	 * a question
	 */
	String questionText;
	/**
	 * The author is the instructor that wrote and added the question to the
	 * databank
	 */
	String author;
	/**
	 * lastUsed is the data / time of the last time a question was used on a test
	 */
	String lastUsed;
	/**
	 * The course is the class that a question was originally made for
	 */
	public String course;
	/**
	 * topics is a collection of strings that are tags to easily
	 * filter through the question databank for
	 */
<<<<<<< HEAD
	ArrayList<String> topics;
=======
	public Collection<String> topics;
>>>>>>> 4369c2b5e8caa37e99e93a4ec3e3c54ea3dd4240
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
	
	public String get(int i) {
		switch (i) {
		case 0: return course;
		case 1:
			String topic = "";
			for (String s : topics) {
				topic += s + "; ";
	 		}
	 		return topic; 
	 	case 2: return type;
	 	case 3: return questionText;
	 	case 4: return new Integer(difficulty).toString();
	 	case 5: return new Integer(time).toString();
	 	case 6: return lastUsed;
	 	case 7: return author;
	 	default: return "error: invalid field";
	 	}
	 }
	
}
