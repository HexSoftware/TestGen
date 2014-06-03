package testtool.models.userdb;

import java.text.ParseException;
import testtool.models.testdb.Test;
import junit.framework.TestCase;


/****
 *
 * Class ListOfTestsTEST is the companion testing class  for 
 * class <a href=TestSettings.html> TestSetting</a>. It 
 * implements the following module
 * test plan:
 *									  <pre>
 *    Phase 1: Unit test the constructor.
 *
 *    Phase 2: Unit test open, close methods
 *          
 *    Phase 3: Unit test grade.
 * 
 *    Phase 4: Stress test by constructing and destructing items collection of 
 *             100000 elements.
 *									 </pre>
 */

public class ListOfTestsTEST extends TestCase {
	ListOfTests lt;
	Test t;
	public ListOfTestsTEST(){
		super();
		lt = new ListOfTests();
		t = new Test();
	}
	public void testCheckStatus() throws ParseException{
		t.setTestParam("startDate", "06/01/2013");
		t.setTestParam("endDate", "06/01/2015");
		t.setTestParam("startTime", "1:00am");
		t.setTestParam("endTime", "11:00pm");
		assertTrue(lt.checkStatus(t));
		
		t.setTestParam("startDate", "06/01/2013");
		t.setTestParam("endDate", "06/01/2014");
		assertFalse(lt.checkStatus(t));
		
		t.setTestParam("startDate", "06/01/2015");
		t.setTestParam("endDate", "06/01/2015");
		assertFalse(lt.checkStatus(t));
		
	}
	public void TestOpen(){
		lt.open(t);
		assertEquals("Open", t.getTestParam("state"));	
	}
	public void TestClose(){
		lt.grade(t);
		assertEquals("Closed", t.getTestParam("state"));
	}
	public void testGrade(){
		lt.grade(t);
		assertEquals("Graded", t.getTestParam("state"));
	}
}
