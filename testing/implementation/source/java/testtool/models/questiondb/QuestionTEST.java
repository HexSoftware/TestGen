package testtool.models.questiondb;

import java.util.ArrayList;

import junit.framework.TestCase;
import testtool.models.questiondb.Question;
/**
 * The Question class is the superclass of all question types
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 10jun14
 * 
 */
public class QuestionTEST extends TestCase {
	Question q = new Question();
	ArrayList<String> s = new ArrayList<String>();
	
	public QuestionTEST(String name) {
		super(name);
		q.setAuthor("Robert Almada");
		q.setCourse("CPE309");
		q.setDifficulty(3);
		q.setLastUsed("never");
		q.setPoints(100);
		q.setQuestionText("Hello, world!");
		q.setTime(10);
		s.add("hello");
		s.add("world!");
		q.setTopics(s);
		q.setType("MC");
	}
	
	public void testSettersandGetters() {
		assertEquals(q.getAuthor(), "Robert Almada");
		assertEquals(q.getCourse(), "CPE309");
		assertEquals(q.getDifficulty(), 3);
		assertEquals(q.getLastUsed(), "never");
		assertEquals(q.getPoints(), 100);
		assertEquals(q.getQuestionText(), "Hello, world!");
		assertEquals(q.getTime(), 10);
		assertTrue(q.getTopics().equals(s));
		assertEquals(q.getType(), "MC");
	}
	
	public void testGetStrings() {
		assertEquals(q.get(0), "CPE309");
		assertEquals(q.get(1), "hello, world!");
		assertEquals(q.get(2), "MC");
		assertEquals(q.get(3), "Hello, world!");
		assertEquals(q.get(4), "3");
		assertEquals(q.get(5), "10");
		assertEquals(q.get(6), "never");
		assertEquals(q.get(7), "Robert Almada");
		assertEquals(q.get(8), "100");
		assertEquals(q.get(100), "error: invalid field");
	}
	
	public void testToString() {
		String g = "questionText=Hello, world!, author=Robert Almada, lastUsed=never, course=CPE309, topics=[hello, world!], time=10, difficulty=3, type=MC, points=100";
		assertEquals(q.toString(), g);
	}
}
