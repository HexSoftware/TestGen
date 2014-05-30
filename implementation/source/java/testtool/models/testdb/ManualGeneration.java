/*
 * ManualGeneration is used to a create a test by manually 
 * selecting questions from a database
 * @author Grant Pickett
 * @version 5/30/2014
 */

package testtool.models.testdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import testtool.models.questiondb.Question;

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
	 */
	/*
	 * @ requires (* That a single question in the databank is selected, and
	 * that Question q is a valid question that is in the databank.); ensures (*
	 * That only one valid question is edited.);
	 * 
	 * @
	 */
	void edit(ArrayList<Question> qs) {
		System.out.println("in ManualGeneration.edit");
	}

	/**
	 * Lets an instructor finish this step and add the test to the test database
	 */
	/*
	 * @ requires (* There is at least one question in the test); ensures (* The
	 * test is stored in the test database and the user is sent there.);
	 * 
	 * @
	 */
	public Test generate() {
		System.out.println("in ManualGeneration.generate");
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("state", "unscheduled");
		data.put("uniqueId", tdb.getIdPos().toString());
		return tdb.createTest(data, questions);
	}

	public void setParams(String string, String string2) {
		settings.put(string, string2);
	}
}
