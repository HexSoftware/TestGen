/**
 * ManualGeneration is used to a create a test by manually 
 * selecting questions from a database
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/8/2014
 */

package testtool.models.testdb;

import java.util.ArrayList;
import java.util.HashMap;

import testtool.models.questiondb.Filter;
import testtool.models.questiondb.Question;
import testtool.models.questiondb.QuestionDatabank;
import testtool.views.questiondb.QuestionDBFrame;

/**
 * This class manages manual generation of a test.
 */
public class ManualGeneration {
	/**
	 * The collection of questions in the test.
	 */
	ArrayList<Question> questions = new ArrayList<Question>();
	public HashMap<String, String> settings = new HashMap<String, String>();
	TestDatabase tdb;

	public ManualGeneration(TestDatabase td) {
		tdb = td;
	}

	/**
	 * gets input from instructor and saves it to the settings variable
	 */
	/*
	 * @ ensures (* That settings are setup with the input information);
	 * 
	 * @
	 */
	public void getParams() {
		System.out.println("in AutomaticGeneration.getParams");
	};

	/**
	 * edit allows changes to be applied to an existing Question q in the
	 * question list.
	 * 
	 * @param q
	 *            - question to edit
	 * 
	 * 
	 *            @ requires (* That a single question in the databank is
	 *            selected, and that Question q is a valid question that is in
	 *            the databank.); ensures (* That only one valid question is
	 *            edited.);
	 * 
	 *            @
	 */
	void edit(ArrayList<Question> qs) {
		System.out.println("in ManualGeneration.edit");
		//new QuestionDBFrame(qs);
	}

	/**
	 * Lets an instructor finish this step and add the test to the test database
	 * 
	 * @param questions
	 * @param params
	 * 
	 * 
	 *            @ requires (* There is at least one question in the test);
	 *            ensures (* The test is stored in the test database and the
	 *            user is sent there.);
	 * 
	 */
	public Test generate(HashMap<String, String> params,
			ArrayList<Question> questions) {
			if(questions == null)
				questions = new ArrayList<Question>();
			QuestionDatabank qd = new QuestionDatabank(null);
			qd.filter(new Filter("Course", params.get("course")));		
			qd.filter(new Filter("Type", "TF"));
			qd.unfilter(null);
			System.out.println("in ManualGeneration.generate" +questions.size());
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

	public void setParams(String string, String string2) {
		settings.put(string, string2);
	}
}
