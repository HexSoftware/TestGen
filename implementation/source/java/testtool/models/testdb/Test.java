package testtool.models.testdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import testtool.models.questiondb.Question;

/**
 * The Test class represents a test that lives in the test database It has a
 * list of questions and other needed data.
 * 
 * @author Grant Pickett (gpickett@calpoly.edu) 90%, Yuliya Levitskaya
 * @version 6/8/2014
 */
public class Test {
	/**
	 * A Test can have the following parameters. Parameters are not limited to
	 * these keywords due to expanding functionality. All parameters are
	 * strings. uniqueId; state course; testTitle; author; courseNumber
	 * lastUsed; totalQuestions; totalPoints; totalTime; avgDifficulty;
	 * startDate endDate; password; notes; testType; startTime; endTime;
	 */
	/** The parameters (settings) of a test. Used by the program. */
	public HashMap<String, String> testParams = new HashMap<String, String>();

	/** The questions a student takes */
	public ArrayList<Question> questionList = new ArrayList<Question>();

	/**
	 * 
	 * @param testP
	 * @param questionL
	 */
	public Test(HashMap<String, String> testP, ArrayList<Question> questionL) {
		testParams = testP;
		if (testParams.get("password") == null) {
			testParams.put("password", null);
		}
		questionList = questionL;
	}

	/** empty constructor for testing purposes */
	public Test() {

	}

	/**
	 * getTestParam returns the data in a given column, represented by the
	 * string parameter of this method pre: column is valid test param post:
	 * Desired data returned
	 */
	public String getTestParam(String column) {
		return testParams.get(column);
	}

	/**
	 * setTestParam changes the data in a given column, represented by the first
	 * string parameter of this method and the second string parameter is the
	 * data. Functions as a table lookup by using a mutable HashMap.
	 * 
	 * @param column
	 *            (column name)
	 * @param data
	 *            (column data)
	 * @return result of put pre: column and data valid post: data is added to
	 *         testParams
	 */
	public String setTestParam(String column, String data) {
		return testParams.put(column, data);
	}

	/**
	 * getQuestionList returns the questions of this test post: The tests
	 * questionList returned.
	 */
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	/**
	 * toString is overloaded to serialize the test information so that it can
	 * be stored in a readable format and saved.
	 * 
	 * @return well-formed string form of this test object returned. post:
	 *         well-formed string form of this test object returned.
	 */
	public String toString() {
		/** String Builder for creating string to be returned */
		StringBuilder sb = new StringBuilder();

		/** begintest is a keyword for loading the database */
		sb.append("begintest \n");

		/** The testParams map is printed as key value pairs */
		for (Entry<String, String> entry : testParams.entrySet()) {
			sb.append("key: " + entry.getKey() + " value: " + entry.getValue());
			sb.append(" \n");
			System.out.println(sb.toString());
		}

		/** Uses the Question objects toString method */
		for (Question entry : questionList) {
			sb.append(entry.toString());
			sb.append("\n");
		}

		/** endtest is a keyword for loading the database */
		sb.append("endtest \n");
		return sb.toString();
	}
}
