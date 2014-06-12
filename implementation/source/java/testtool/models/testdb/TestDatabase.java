package testtool.models.testdb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import testtool.models.questiondb.Question;
import testtool.models.questiondb.QuestionDatabank;
import testtool.views.questiondb.QuestionDBFrame;

/**
 * This class manages and stores Tests. The test parameter is a selected test.
 * Used by many classes but directly paired with TestDatabaseGUI view.
 * Uses a QuestionDatabank for accessing questions.
 * 
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/8/14
 */
public class TestDatabase {
	/**
	 * important data fields
	 */
	public Integer idPos = 0;
	public ArrayList<Test> tests = new ArrayList<Test>();
	public QuestionDatabank qdb = new QuestionDatabank(null);

	/**
	 * The Test database constructor attempts to load an existing database from the correct location
	 * and creates a new one if it does not find one.
	 */
	public TestDatabase() {
		File file = new File("database.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(
				file.getAbsoluteFile()))) {
			String line = null;
			ArrayList<Question> questions = new ArrayList<Question>();
			HashMap<String, String> params = new HashMap<String, String>();
			String[] parts = new String[4];
			while ((line = reader.readLine()) != null) {
				if (line.contains("begintest")) {
					System.out.println("found new test");
					questions = new ArrayList<Question>();
					params = new HashMap<String, String>();
				} else {
					if (line.contains("endtest")) {
						System.out.println("end of test");
						if (params.get("uniqueId") == null) {
							params.put("uniqueId", idPos.toString());
						}
						idPos += 1;
						Test newTest = new Test(params, questions);
						tests.add(newTest);
						continue;
					}
					parts = line.split(" ");
					if (parts[0] != null) {
						if (parts[0].equals("key:")) {
							String val = "";
							for (int i = 3; i < parts.length; i++) {
								val += parts[i];
								val += " ";
							}
							val = val.substring(0, val.length() - 1);
							params.put(parts[1], val);
							System.out.println("new param " + parts[1] + " "
									+ val);
						} else {
							System.out
									.println("found new question " + parts[0]);
							questions.add(qdb.parseString(line));
						}
					}
				}
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	/**
	 * The collection of Test Objects /** This method will begin the process of
	 * creating a new test
	 *
	 *
	 * @ ensures // // The generation dialogue will appear //
	 */
	public Test createTest(HashMap<String, String> data,
			ArrayList<Question> questionL) {
		if (data.get("uniqueId") == null) {
			data.put("uniqueId", idPos.toString());
		}
		idPos += 1;
		Test newTest = new Test(data, questionL);
		tests.add(newTest);
		System.out.println("in TestDatabase.createTest");
		save();
		return newTest;
	}

	/**
	 * This method will begin the process of editing a test
	 * 
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be put into edit mode //
	 * 
	 */
	public void editTest(Test test) {
		System.out.println("in TestDatabase.editTest");

		save();
	}

	/**
	 * getIdPos is used internally to keep track of the location in database.
	 * 
	 * @return current UniqueID post: correct id position returned
	 */
	public Integer getIdPos() {
		return idPos;
	}

	/**
	 * GetTestComplex is used to filter the database by multiple searchses.
	 * 
	 * @param pairs
	 *            (HashMap of search criterion)
	 * @return the filtered tests pre: HashMap param is initialized post:
	 *         returns correct tests with no duplicates
	 */
	public ArrayList<Test> getTestComplex(HashMap<String, String> pairs) {
		Object[] a = pairs.keySet().toArray();
		Object[] b = pairs.values().toArray();
		ArrayList<Test> filteredTests = new ArrayList<Test>();
		for (int i = 0; i < a.length; i++) {
			filteredTests.addAll(getTest((String) a[i], (String) b[i]));
		}
		/** Following three lines removes duplicates by hashing the elements */
		HashSet<Test> set = new HashSet<Test>(filteredTests);
		filteredTests.clear();
		filteredTests.addAll(set);
		return filteredTests;
	}

	/**
	 * getTest is a filtering method
	 * 
	 * @param column
	 * @param data
	 * @return ArrayList of matching tests
	 * 
	 *         @ requires // // column && data strings when null will return bad
	 *         data. undefined behavior. don't do it. // ensures // // Tests
	 *         returns will be valid for column and data given. Returned list
	 *         may be of length 0. //
	 * 
	 *         @
	 */
	public ArrayList<Test> getTest(String column, String data) {
		ArrayList<Test> match = new ArrayList<Test>();

		/** list of valid params */
		ArrayList<String> column_names = new ArrayList<String>(Arrays.asList(
				"uniqueId", "state", "testTitle", "author", "lastUsed",
				"totalQuestions", "totalPoints", "totalTime", "avgDifficulty",
				"notes", "course", "gradeType", "password", "startDate",
				"endDate", "startTime", "endTime", "testType", "testCategory",
				"testCategoryNum"));

		/** defensive check that column name is valid to save computation time */
		if (column_names.contains(column)) {
			System.out.println("Number of tests in database: " + tests.size());
			/** for each test check if the tests param matches the desired value */
			for (Test t : tests) {
				String val = t.getTestParam(column).toString();
				if (val != null) {
					/** defensive check for null cases if param was unset */
					if (val.equals(data)) {
						/** add it to list */
						match.add(t);
						System.out.println("Match: " + val + " = " + data
								+ " in " + column + ". total matches "
								+ match.size());
					}
				}
			}
		}
		return match;
	}

	/**
	 * This method will begin the process of publishing a test
	 * 
	 * 
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be published //
	 */
	public void publishTest(Test test) {
		System.out.println("in TestDatabase.publishTest");
	}

	/**
	 * This method will begin the process of removing a test
	 * 
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be removed // (Test test =
	 * null)
	 * 
	 * @
	 */
	public Test removeTest(int[] is) {
		Test removed = tests.get(is[0]);
		for (int i = is.length - 1; i >= 0; i--) {
			tests.remove(is[i]);
		}
		save();
		return removed;
	}

	/**
	 * This method will begin the process of taking a test
	 * 
	 * 
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be taken //
	 * 
	 * @
	 */
	public void takeTest(Test t) {
		System.out.println("in TestDatabase.takeTest");
	}

	/**
	 * The save method converts the existing testdatabase into a file for
	 * external saving.
	 * 
	 * Uses Test.toString() which uses Question.toString() for serializing.
	 * 
	 * @return saved file for unit testing post: data save correctly
	 */
	public File save() {
		/** new String Builder use to construct save file */
		StringBuilder sb = new StringBuilder();
		/** add each test to the sb */
		for (Test t : tests) {
			sb.append(t.toString());
			System.out.println(sb.toString());
		}
		/** create the save file */
		File file = new File("database.txt");
		/** try to write out as a file */
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				file.getAbsoluteFile()))) {
			writer.write(sb.toString(), 0, sb.length());
		} catch (IOException x) {/**alert of error*/
			System.err.format("IOException: %s%n", x);
		}
		return file;
	}
}
