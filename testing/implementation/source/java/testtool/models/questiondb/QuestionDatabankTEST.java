package testtool.models.questiondb;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * 
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 12jun14
 */

public class QuestionDatabankTEST extends TestCase {
	QuestionDatabank qdb;
	Question q1, q2, q3;
	Filter fil;
	ArrayList<String> topics;
	
	public QuestionDatabankTEST(String name) {
		super(name);
		
		topics = new ArrayList<String>();
		topics.add("MyTopic");
		qdb = new QuestionDatabank(null, true, null);
		q1 = new Question();
		q2 = new Question();
		q3 = new Question();
		try {
			q1 = new TFQuestion("My T/F Question", "nnordhof", "CPE309", topics, 1, 1, true, 5);
			q2 = new CodeQuestion("My Code Question", "nnordhof", "CPE309", topics, 10, 3, "MyScriptPath", 10);
			q3 = new GraphicsQuestion("My Graphics Question", "nnordhof", "CPE309", topics, 5, 2, 5);
		} catch (EmptyBoxException e) {
			e.printStackTrace();
		}
		fil = new Filter("TF", "Type");
		
	}
	
	public void testAddingQuestions() {
		qdb.add(q1);
		qdb.add(q2);
		qdb.add(q3);
		
		assertEquals(qdb.questions.get(0).question, q1);
		assertEquals(qdb.questions.get(1).question, q2);
		assertEquals(qdb.questions.get(2).question, q3);
	}
	
	public void testFilteringQuestions() {
		qdb.add(q1);
		qdb.add(q2);
		qdb.add(q3);
		ArrayList<Question> filteredqs = qdb.filter(fil);
		assertEquals(filteredqs.contains(q1), true);
		assertEquals(filteredqs.contains(q2), false);
		assertEquals(filteredqs.contains(q3), false);
	}
	
	public void testUnfilteringQuestions() {
		qdb.add(q1);
		qdb.add(q2);
		qdb.add(q3);
		
		ArrayList<Question> filteredqs = qdb.filter(fil);
		
		qdb.unfilter(fil);
		
		assertEquals(qdb.questions.get(0).question, q1);
		assertEquals(qdb.questions.get(1).question, q2);
		assertEquals(qdb.questions.get(2).question, q3);
	}
	
	public void testRemovingQuestions() {
		qdb.add(q1);
		qdb.add(q2);
		qdb.add(q3);
		
		int[] indices = {0, 1};
		qdb.remove(indices);
		
		assertEquals(qdb.questions.contains(new QuestionEntry(q1, new ArrayList<Filter>())), false);
		assertEquals(qdb.questions.contains(new QuestionEntry(q2, new ArrayList<Filter>())), false);
		assertEquals(qdb.questions.get(0).question, q3);
	}
}









