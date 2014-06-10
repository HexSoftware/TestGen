package testtool.models.userdb;
import java.text.ParseException;

import testtool.models.testdb.Test;

import junit.framework.TestCase;

/*Yuliya Levitskaya*/
/****
 *
 * Class ProctorTEST is the companion testing class for 
 * class <a href=Proctor.html> Proctor</a>. 
 *  It implements the following module
 * test plan:
 *									  <pre>
 *    Phase 1: Unit test the constructor.
 *
 *    Phase 2: Unit test checkStatus
 *
 *    Phase 3: Stress test by constructing and destructing items collection of 
 *             100000 elements.
 *									 </pre>
 */
public class ProctorTEST extends TestCase {
	ListOfTests lt;
	Test t;
	public ProctorTEST(){
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

}
