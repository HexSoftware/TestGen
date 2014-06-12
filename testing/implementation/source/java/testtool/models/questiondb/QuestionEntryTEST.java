package testtool.models.questiondb;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * 
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 12jun14
 */

public class QuestionEntryTEST extends TestCase {
	QuestionEntry qe;
	ArrayList<Filter> fils;
	Filter fil1, fil2;
	Question q;
	 
	public QuestionEntryTEST(String name) {
		super(name);

		fil1 = new Filter("MyFilter1", "MyCategory");
		fil2 = new Filter("MyFilter2", "MyCatergoy");
		fils = new ArrayList<Filter>();
		fils.add(fil1);
		q = new Question();
		qe = new QuestionEntry(q, fils);
	}
	
	public void testSettersandGetters() {
		q.author = "Neil Nordhof";
		qe.question = q;
		
		assertEquals(qe.question, q);
		assertEquals(qe.filters, fils);
		
		assertEquals(qe.getFilter(0), fil1);
		assertEquals(qe.getFilters(), fils);
		assertEquals(qe.getQuestion(), q);
	}
	public void testAddingFilters() {
		qe.addFilter(fil2);
		fils.add(fil2);
		
		assertEquals(qe.getFilter(1), fil2);
		assertEquals(qe.getFilters(), fils);
	}
	
	public void testRemovingFilters() {
		qe.removeFilter(fil2);
		fils.remove(fil2);
		
		assertEquals(qe.getFilters(), fils);
	}
}