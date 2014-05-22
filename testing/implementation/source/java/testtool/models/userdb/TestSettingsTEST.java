package testtool.models.userdb;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author Yuliya Levitskaya
 * @version 21may14
 * Tests the TestSettings methods
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
public class TestSettingsTEST extends TestSettings {
	/**
	 * Empty constructor, needed to placate the compiler, since
 	 * parent constructor takes no argument
	 */
	static testtool.models.testdb.Test t = new testtool.models.testdb.Test();
	public TestSettingsTEST(){
		super(t);
	}
	@Test
	public void testGetType(){
		t.setTestParam("testType", "type");
		assertEquals("type", t.getTestParam("testType"));	
	}
	@Test
	public void testGetStartDate(){
		t.setTestParam("startDate", "start date");
		assertEquals("start date", t.getTestParam("startDate"));		
	}
	@Test
	public void testGetsTime(){
		t.setTestParam("startTime", "start time");
		assertEquals("start time", t.getTestParam("startTime"));
	}
	@Test
	public void testGeteTime(){
		t.setTestParam("endTime", "end time");
		assertEquals("end time", t.getTestParam("endTime"));
	}
	@Test
	public void testGetEndDate(){
		t.setTestParam("endDate", "end date");
		assertEquals("end date", t.getTestParam("endDate"));
	}
	@Test
	public void testGetPass(){
		t.setTestParam("password", "password");
		assertEquals("password", t.getTestParam("password"));
	}
	@Test
	public void testGetNotes(){
		t.setTestParam("notes", "notes");
		assertEquals("notes", t.getTestParam("notes"));
	}
	@Test
	public void testGetGradeType(){
		t.setTestParam("gradeType", "grade type");
		assertEquals("grade type", t.getTestParam("gradeType"));
	}
	@Test
	public void testSetsTime(){
		setsTime("set start time");
		assertEquals("set start time", t.getTestParam("startTime"));
	}
	@Test
	public void testSeteTime(){
		seteTime("set end time");
		assertEquals("set end time", t.getTestParam("endTime"));
	}
	@Test
	public void testSetGradeType(){
		setGradeType("set grade type");
		assertEquals("set grade type", t.getTestParam("gradeType"));
	}
	@Test
	public void testSetNotes(){
		setNotes("set notes");
		assertEquals("set notes", t.getTestParam("notes"));
	}
	@Test
	public void testSetPass(){
		setPass("set password");
		assertEquals("set password", t.getTestParam("password"));
	}	
	@Test
	public void testSetType(){
		setType("set type");
		assertEquals("set type", t.getTestParam("testType"));
	}
	@Test
	public void testSetStartDate(){
		setStartDate("set start date");
		assertEquals("set start date", t.getTestParam("startDate"));
	}
	@Test
	public void testSetEndDate(){
		setEndDate("set end date");
		assertEquals("set end date", t.getTestParam("endDate"));
	}
	@Test
	public void testPublish(){
		assertTrue(publish(null, null, null, null, null, null, null, null));
	}
}