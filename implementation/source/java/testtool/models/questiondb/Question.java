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
	String course;
	/**
	 * topics is a collection of strings that are tags to easily
	 * filter through the question databank for
	 */
	ArrayList<String> topics;
	/**
	 * The time is the amount of the author believes this question should take
	 */
	int time;
	/**
	 * The difficulty is in a range of 1-5;
	 * 1 being easy and 5 being hard
	 */
	int difficulty;
	
}
