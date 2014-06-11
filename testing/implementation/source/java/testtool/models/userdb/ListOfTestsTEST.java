package testtool.models.userdb;

import java.text.ParseException;
import testtool.models.testdb.Test;
import junit.framework.TestCase;

/*
* Yuliya Levitskaya
*/

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
