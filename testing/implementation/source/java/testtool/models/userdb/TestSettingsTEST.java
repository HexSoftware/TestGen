package testtool.models.userdb;

import testtool.models.testdb.Test;
import testtool.models.testdb.TestDatabase;
import junit.framework.TestCase;
/*
* Yuliya Levitskaya
*/

/****
 *
 * Class TestSettingsTEST is the companion testing class for 
 * class <a href=TestSettings.html> TestSetting</a>. It 
 * implements the following module
 * test plan:
 *									  <pre>
 *    Phase 1: Unit test the constructor.
 *
 *    Phase 2: Unit test the simple get/set methods:
 *          getType, getsTime, getStartDate, geteTime, getEndDate,
 *	       getPass, getNotes, setsTime, seteTime, setGradeType,
 *	       setNotes, setPass, setType, setStartDate, setEndDate.
 *
 *    Phase 3: Unit test publish, saving the constructed results
 * 		   for subsequent tests.
 *
 *    Phase 4: Unit test getType, getsTime, getStartDate, geteTime,
 *		 getEndDate, getPass, getNotes, using items added in
 *		Phase 3.
 *    Phase 5: Repeat phases 1 through 4.
 * 
 *    Phase 8: Stress test by constructing and destructing items collection of 
 *             100000 elements.
 *									 </pre>
 */

public class TestSettingsTEST extends TestCase {
	Test t;
	TestSettings ts;
	public TestSettingsTEST() {
		super();
		t = new Test();
		ts = new TestSettings(t);
	}
	public void testGetType(){
		t.setTestParam("testType", "type");
		assertEquals("type", ts.getType());
	}
	public void testGetStartDate(){
		t.setTestParam("startDate", "06/02/2014");
		assertEquals("06/02/2014", ts.getStartDate());
	}
	public void testGetsTime(){
		t.setTestParam("startTime", "10:10am");
		assertEquals("10:10am", ts.getsTime());
	}
	public void testGeteTime(){
		t.setTestParam("endTime", "11:10am");
		assertEquals("11:10am", ts.geteTime());
	}
	public void testGetEndDate(){
		t.setTestParam("endDate", "06/03/2014");
		assertEquals("06/03/2014", ts.getEndDate());
	}
	public void testGetPass(){
		t.setTestParam("password", "pass");
		assertEquals("pass", ts.getPass());
	}
	public void testGetNotes(){
		t.setTestParam("notes", "Notes");
		assertEquals("Notes", ts.getNotes());
	}
	public void testGetGradeType(){
		t.setTestParam("gradeType", "grade type");
		assertEquals("grade type", ts.getGradeType());
	}
	public void testSetsTime(){
		ts.setsTime("10:10am");
		assertEquals("10:10am", t.getTestParam("startTime"));
	}
	public void testSeteTime(){
		ts.seteTime("10:10am");
		assertEquals("10:10am", t.getTestParam("endTime"));
	}
	public void testSetGradeType(){
		ts.setGradeType("grade type");
		assertEquals("grade type", t.getTestParam("gradeType"));
	}
	public void testSetNotes(){
		ts.setNotes("Notes");
		assertEquals("Notes", t.getTestParam("notes"));
	}
	public void testSetPass(){
		ts.setPass("pass");
		assertEquals("pass", t.getTestParam("password"));
	}
	public void testSetType(){
		ts.setType("type");
		assertEquals("type", t.getTestParam("testType"));
	}
	public void testSetStartDate(){
		ts.setStartDate("06/02/2014");
		assertEquals("06/02/2014", t.getTestParam("startDate"));
	}
	public void testSetEndDate(){
		ts.setEndDate("06/03/2014");
		assertEquals("06/03/2014", t.getTestParam("endDate"));
	}
	 public void testPublish(){
		t.setTestParam("testType", "type");
		t.setTestParam("startDate", "06/02/2014");
		t.setTestParam("startTime", "10:10am");
		t.setTestParam("endTime", "11:10am");
		t.setTestParam("endDate", "06/03/2014");
		t.setTestParam("password", "pass");
		t.setTestParam("notes", "Notes");
		t.setTestParam("gradeType", "grade type");
		
		assertEquals("type", t.getTestParam("testType"));
		assertEquals("06/02/2014", t.getTestParam("startDate"));
		assertEquals("10:10am", t.getTestParam("startTime"));
		assertEquals("11:10am", t.getTestParam("endTime"));
		assertEquals("06/03/2014", t.getTestParam("endDate"));
		assertEquals("pass", t.getTestParam("password"));
		assertEquals("Notes", t.getTestParam("notes"));
		assertEquals("grade type", t.getTestParam("gradeType"));	
	}
}