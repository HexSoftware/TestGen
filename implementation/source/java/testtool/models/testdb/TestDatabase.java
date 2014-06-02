/**
 * The Testdatabase Class holds all instances of test objects
 * @author Grant Pickett, Yuliya Levitskaya
 * @version 6/1/14
 */

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

import testtool.models.questiondb.Question;
import testtool.models.questiondb.QuestionDatabank;
import testtool.views.questiondb.QuestionDBFrame;

/**
 * This class manages and stores Tests. The test parameter is a selected test.
 */
public class TestDatabase {
	public Integer idPos = 0;
	public ArrayList<Test> tests = new ArrayList<Test>();
	public QuestionDatabank qdb= new QuestionDatabank(null);
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
						// createTest(params, questions);
						if (params.get("uniqueId") == null) {
							params.put("uniqueId", idPos.toString());
						}
						idPos += 1;
						Test newTest = new Test(params, questions);
						tests.add(newTest);
						continue;
					}
					parts = line.split(" ");
					System.out.println(parts);
					if (parts[0] != null) {
						if (parts[0].equals("key:")) {
							System.out.println("found new param");
							String val = "";
							for(int i = 3; i < parts.length; i++){
								val += parts[i];
								val += " ";
							}
							val = val.substring(0, val.length()-1);
							params.put(parts[1], val);
						} else {
							System.out.println("found new question" + parts[0]);
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
	 */
	/*
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
	 */
	/*
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be put into edit mode //
	 * 
	 * @
	 */
	public void editTest(Test test) {
		System.out.println("in TestDatabase.editTest");
		new QuestionDBFrame(test.questionList);
		
		save();
	}

	public Integer getIdPos() {
		return idPos;
	}

	/*
	 * @ requires // // column && data strings when null will return bad data.
	 * undefined behavior. don't do it. // ensures // // Tests returns will be
	 * valid for column and data given. Returned list may be of lentgh 0. //
	 * 
	 * @
	 */
	public ArrayList<Test> getTest(String column, String data) {
		ArrayList<Test> match = new ArrayList<Test>();
		ArrayList<String> column_names = new ArrayList<String>(Arrays.asList(
				"uniqueId", "state", "testTitle", "author", "lastUsed",
				"totalQuestions", "totalPoints", "totalTime", "avgDifficulty",
				"notes", "course", "gradeType", "password", "startDate",
				"endDate", "startTime", "endTime", "testType", "testCategory",
				"testCategoryNum"));

		if (column_names.contains(column)) {
			System.out.println("Number of tests in database: " + tests.size());
			for (Test t : tests) {
				String val = t.getTestParam(column).toString();
				if (val != null) {
					if (val.equals(data)) {
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
	 */
	/*
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be published //
	 * 
	 * @
	 */
	public void publishTest(Test test) {
		System.out.println("in TestDatabase.publishTest");
		// TestTaking?
	}

	/**
	 * This method will begin the process of removing a test
	 */
	/*
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
	 */
	/*
	 * @ requires // // A test to be in the database // (\exists Test test &&
	 * tests.length > 0) ensures // // test will be taken //
	 * 
	 * @
	 */
	public void takeTest(Test t) {
		System.out.println("in TestDatabase.takeTest");
	}

	/*
	 * @ ensures // // A weird sample test will be in the database //
	 * 
	 * @
	 *//*
		 * public void ZerothTest() { final Test z = new Test(); z.uniqueId =
		 * "TESTGENTESTNUMBER0"; z.avgDifficulty = 99; z.lastUsed = "NEVER";
		 * z.opened = true; z.testTitle = "ZERO"; z.totalPoints = 9001; z.graded
		 * = true; z.published = true; z.avgDifficulty = -3; z.author =
		 * "Hex Software"; TestDatabase.tests.add(z); }
		 */
	public File save() {
		StringBuilder sb = new StringBuilder();
		for (Test t : tests) {
			sb.append(t.toString());
			System.out.println(sb.toString());
		}
		File file = new File("database.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				file.getAbsoluteFile()))) {
			writer.write(sb.toString(), 0, sb.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
		return file;
	}
}
