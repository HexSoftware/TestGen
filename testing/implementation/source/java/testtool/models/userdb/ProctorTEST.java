package testtool.models.userdb;

import static org.junit.Assert.*;

import org.junit.Test;
/**
* @author Yuliya Levitskaya
* @version 21may14
* Tests the Proctor methods
*/
/****
*
* Class ProctorTEST is the companion testing class for 
* class <a href=Proctor.html> Proctor</a>. 
*  It implements the following module
* test plan:
*									  <pre>
*    Phase 1: Unit test the constructor.
*
*    Phase 2: Unit test listOfTests method
*
*    Phase 3: Unit test grade method.
*
*    Phase 4: Unit test options method.
*
*    Phase 5: Stress test by constructing and destructing items collection of 
*             100000 elements.
*									 </pre>
*/
public class ProctorTEST extends Proctor {
	/**
	 * Empty constructor, needed to placate the compiler, since
	 * parent Proctor constructor takes no argument
	 */

	public ProctorTEST(){
		super();
	}
	@Test
	public void testOptions(){
		assertTrue(options());
	}
	@Test
	public void testListOfTests(){
		assertTrue(listOfTests());
	}
	@Test
	public void testGrade(){
		assertTrue(grade());
	}
}