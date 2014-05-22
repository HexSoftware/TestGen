package testtool.models.userdb;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Yuliya Levitskaya
 * @version 21may14
 * Tests the ListofTest methods
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
public class ListOfTestsTEST extends ListOfTests {
	testtool.models.testdb.Test t = new testtool.models.testdb.Test();
	public ListOfTestsTEST(){
		super();
	}
	@Test
	public void testAdd(){
		assertTrue(add(t));
	}
	@Test
	public void testInvallidAdd(){
		assertFalse(add(null));
	}
	@Test
	public void testRemove(){
		assertTrue(remove(t));
	}
	@Test
	public void testInvallidRemove(){
		assertFalse(remove(null));
	}
	@Test
	public void testOpen(){
		assertTrue(open(t));
	}
	@Test
	public void testInvalidOpen(){
		assertFalse(open(null));
	}
	@Test
	public void testClose(){
		assertTrue(close(t));
	}
	@Test
	public void testInvallidClose(){
		assertFalse(close(null));
	}
}