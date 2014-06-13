package testtool.models.student;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

import java.util.ArrayList;
import testtool.models.userdb.Student;


/* @author Kevin Pham
 * 
 */

public class StudentAnswersTEST extends TestCase {

	StudentAnswers sAnswers; 
	
	public StudentAnswersTEST() {}
	
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
	public void testConstructor() {
		StudentAnswers sAnswers = new StudentAnswers();
		assertNotNull(sAnswers);
	}
	
	 /**
     * Unit test Adding Answers to a StudentAnswer
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1      "A"					properly add	   simple add
     *
     *   2   A thousand Answers		properly added		stress test                                                         
     */
	public void testAddingAnswer() {
		StudentAnswers sAnswers = new StudentAnswers();
		Answer answer = new Answer();
		answer.setMC("A");
		sAnswers.addAnswer(answer);
		
		assertEquals(answer, sAnswers.getAnswers().get(0));
		
	}
	
	/**
     * Unit test removing answers from a StudentAnswer
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1      Different Answers	properly removed	removed first and last answers
     *                                                          
     */
	public void testRemoveAnswer() {
		ArrayList<Answer> testingList = new ArrayList<Answer>();
		StudentAnswers sAnswers = new StudentAnswers();
		
		Answer answer1 = new Answer();
		answer1.setMC("A");
		sAnswers.addAnswer(answer1);
		testingList.add(answer1);
		
		Answer answer2 = new Answer();
		answer2.setMC("A");
		sAnswers.addAnswer(answer2);
		testingList.add(answer2);
		
		Answer answer3 = new Answer();
		answer3.setMC("A");
		sAnswers.addAnswer(answer3);
		testingList.add(answer3);
		
		sAnswers.removeAnswer(answer1);
		testingList.remove(answer1);
		assertEquals(sAnswers.getAnswers(), testingList);
		
		sAnswers.removeAnswer(answer3);
		testingList.remove(answer3);
		assertEquals(sAnswers.getAnswers(), testingList);
		
	}
	
	
	/**
     * Unit test Updating Answers in a StudentAnswer
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1     Different Answers	properly updated  added answers then updated 1st
     *                                                          
     */
	public void testUpdate() {
		StudentAnswers sAnswers = new StudentAnswers();
		Answer answer = new Answer();
		answer.setMC("A");
		sAnswers.addAnswer(answer);
		
		assertEquals(answer, sAnswers.getAnswers().get(0));
		
		Answer newAnswer = new Answer();
		newAnswer.setMC("B");
		
		sAnswers.updateAnswer(answer,newAnswer);
		assertEquals(newAnswer, sAnswers.getAnswers().get(0));
	}
	
}
