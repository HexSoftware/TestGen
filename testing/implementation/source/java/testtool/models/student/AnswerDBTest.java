package testtool.models.student;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import testtool.models.grader.ReleaseOptions;


/****
*
* Class AnswerDBTest is the companion testing class for class <a href=
* AnswerDB.html> ReleaseOptions </a>.  It implements the following module test plan:
*                                                                         <ul>
*                                                                      <p><li>
*     Phase 1: Unit test the constructor.
*                                                                      <p><li>
*     Phase 2: Unit test the addStudentAnswer and removeStudentAnswer methods
*                                                                      <p><li>
*     Phase 3: Unit test the updateStudentAnswer method
*                                                                      <p><li>
*     Phase 4: Repeat phases 1 through 3.
*                                                                      <p><li>
*     Phase 5: Stress test by adding and submitting 1000 studentAnswers to a DB.
*                                                                        </ul>
*/

public class AnswerDBTest extends TestCase {

	private AnswerDB db;
	
	
	
	 /**
     * Unit test Constructor 
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1      null					Proper init		only case
     *
     *                                                                  
     */
	

	public AnswerDBTest() {
		db = new AnswerDB();
	}
	
	
	 /**
     * Unit test the Adding of Options.
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1   {"Test1","Test2","Test3"}  List of 		Simple Add
     *   							    options correct		
     *
     *   2   A thousand options			Correctly added   Stress Test
     *                                                                  
     */
	public void testAdding() {
		ArrayList<StudentAnswers> ansList = new ArrayList<StudentAnswers>();
		
		for(int i = 0; i < 3; i++) {
			db.addStudentAnswer(new StudentAnswers());
		}
		
		assertEquals(db.getSize(), 3 );		
		//System.out.println()
	}
	
	public void stressTestAdd() {
		ArrayList<StudentAnswers> ansList = new ArrayList<StudentAnswers>();
		
		for(int i = 0; i < 1000; i++) {
			db.addStudentAnswer(new StudentAnswers());
		}
		
		assertEquals(db.getSize(), 1000 );		
		//System.out.println()
	}
	
	 /**
     * Unit test the Removing of Answers.
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1   {"Test1","Test2","Test3"}  List of 		Remove options one by one
     *   								options correct		in order							
     *
     *   2    {"Test1","Test3","Test2"} Correctly removed  removed out of order
     *                                                                  
     */
	
	public void testRemoving() {
		for(int i = 0; i < 3; i++) {
			db.addStudentAnswer(new StudentAnswers());
		}
		assertEquals(db.getSize(), 3);		
		db.removeStudentAnswer(db.getStudentAnswer(0));
		assertEquals(db.getSize(), 2 );		
		db.removeStudentAnswer(db.getStudentAnswer(0));
		assertEquals(db.getSize(), 1 );		
		db.removeStudentAnswer(db.getStudentAnswer(0));
		assertEquals(db.getSize(), 0 );		
		
	}
	

}
