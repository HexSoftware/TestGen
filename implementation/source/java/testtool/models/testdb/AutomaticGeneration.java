/**
 * AutomaticGeneration class is used to generate tests using given
 * inputs
 * @author Grant Pickett
 * @version 5/31/2014
 */

package testtool.models.testdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import testtool.models.questiondb.Filter;
import testtool.models.questiondb.Question;
import testtool.models.questiondb.QuestionDatabank;

/**
 * AutomaticGeneration class is used to generate tests using given
 * inputs
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/8/2014
 */
public class AutomaticGeneration {
	/** simple constructor takes common testdatabase*/
	public AutomaticGeneration(TestDatabase td) {
		tdb = td;
	}

	/**
	 * The collection of questions in the test.
	 */
	ArrayList<Question> questions = new ArrayList<Question>();
	ArrayList<String> errors = new ArrayList<String>();
	/**
	 * The collection of other data for the test.
	 */
	public HashMap<String, String> settings = new HashMap<String, String>();
	/**
	 * The Test Database class used through the application.
	 */
	TestDatabase tdb;

	/**
	 * This constructor connects the local reference to a testdatabase to the
	 * application's testdatabase. public AutomaticGeneration(TestDatabase td) {
	 * tdb = td; } Gets input from instructor and saves it to the settings
	 * variable
	 * 
	 * 
	 * @ ensures (* That settings are setup with the input information);
	 * 
	 * @
	 */
	public void setParams(String col, String val) {
		settings.put(col, val);
	}

	/**
	 * add takes a question from the add a question dialog, and adds it into the
	 * question list.
	 * 
	 * 
	 * @ requires (* That question q is a vaild question.);
	 * 
	 * @ ensures (* That a valid question is added to the databank.);
	 */
	void add(Question q) {
		System.out.println("in AutomaticGeneration.add");
		questions.add(q);
	}

	/**
	 * remove takes a collection of Questions qs and removes them from the local
	 * test.
	 * 
	 * @param q
	 *            - question to remove
	 *
	 *
	 * @ requires (* That a one or more questions in the databank are selected.
	 * Also that all questions in qs are valid questions and are in the databank
	 * also.); ensures (* That some valid questions are removed.);
	 * 
	 * @
	 */
	void remove(Question q) {
		System.out.println("in AutomaticGeneration.remove");
		questions.remove(q);
	}

	/**
	 * Lets an instructor finish this step and add the test to the test database
	 * 
	 * @param questions
	 * @param params
	 *
	 *
	 * @ requires (* There is at least one question in the test); ensures (* The
	 * test is stored in the test database and the user is sent there.);
	 * 
	 * @ ensures (* A new test will be added to the testdatabase.
	 */
	public Test generate(HashMap<String, String> params,
			HashMap<String, String> qparams, ArrayList<Question> questions) {
		if(questions == null)
			questions = new ArrayList<Question>();
		
		System.out.println("in AutomaticGeneration.generate" +questions.size());
		Integer totalTime = 0;
		for(Question q : questions) {
			totalTime += q.time;
		}
		Integer totalPoints = 0;
		for(Question q : questions) {
			totalPoints += q.points;
		}
		Double avgDifficulty = 0.0;
		for(Question q : questions) {
			avgDifficulty += q.difficulty;
		}
		avgDifficulty/=questions.size();

		params.put("totalQuestions", ((Integer)questions.size()).toString());
		params.put("avgDifficulty", avgDifficulty.toString());
		params.put("totalTime", totalTime.toString());
		params.put("state", "unscheduled");
		params.put("uniqueId", tdb.getIdPos().toString());
		return tdb.createTest(params, questions);
	}

	public ArrayList<String> makeQuestionList(HashMap<String, String> qparams, HashMap<String, String> params) {
		ArrayList<Question> qs = new ArrayList<Question>();
		ArrayList<Question> qlist = new ArrayList<Question>();
		QuestionDatabank qd = new QuestionDatabank(null);
		Filter temp = new Filter("Type", "TF");
		qd.filter(new Filter("Course", params.get("course")));		
		//qlist = qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("TF"))) {
			errors.add("insufficent TF questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("TF"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		temp = new Filter("Type", "MC");
		qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("MC"))) {
			errors.add("insufficent MC questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("MC"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		temp = new Filter("Type", "code");
		//qlist = qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("code"))) {
			errors.add("insufficent code questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("code"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		temp = new Filter("Type", "short");
		//qlist = qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("short"))) {
			errors.add("insufficent short answer questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("short"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		temp = new Filter("Type", "essay");
		//qlist = qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("essay"))) {
			errors.add("insufficent essay questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("essay"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		temp = new Filter("Type", "image");
		//qlist = qd.filter(temp);
		if(qlist.size() < Integer.parseInt(qparams.get("image"))) {
			errors.add("insufficent image questions");
		}
		for(int i = 0; i < Integer.parseInt(qparams.get("image"));i++) {
			//get q from qd result and test if fits
		}
		qd.unfilter(temp);
		generate(params, qparams, qs);
		return errors;
	}
}
