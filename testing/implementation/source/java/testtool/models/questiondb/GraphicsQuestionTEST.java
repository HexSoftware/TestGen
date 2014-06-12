package testtool.models.questiondb;

import java.util.ArrayList;

import junit.framework.TestCase;
import testtool.models.questiondb.GraphicsQuestion;

/****
 * Class EssayQuestionTEST is the companion testing class for <a href=
 * EssayQuestion.html> EssayQuestion </a>. It implements the following module
 * test plan:
 * 																		 <ul>
 * 																	  <p><li>
 * 		Phase 1: Unit test the constructor
 * 																	  <p><li>
 * 		Phase 2: Stress test by creating 10000 CodeQuestions
 * 																		</ul>
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 11jun14
 * 
 */

public class GraphicsQuestionTEST extends TestCase {
	GraphicsQuestion q = new GraphicsQuestion();
	ArrayList<String> s = new ArrayList<String>();
	
	public GraphicsQuestionTEST(String name) {
		super(name);
		q.setAuthor("Robert Almada");
		q.setCourse("CPE309");
		q.setDifficulty(3);
		q.setLastUsed("Never");
		q.setPoints(100);
		q.setQuestionText("Hello, world!");
		q.setTime(10);
		s.add("hello");
		s.add("world!");
		q.setTopics(s);
		q.setType("Graphic");
	}
	
	public void testConstructor() {
		try {
			GraphicsQuestion q2 = new GraphicsQuestion("question", "Robert", "cpe309",
					s, 11, 2, 13);
			assertEquals(q2.getAuthor(), "Robert");
			assertEquals(q2.getCourse(), "cpe309");
			assertEquals(q2.getDifficulty(), 2);
			assertEquals(q2.getLastUsed(), "Never");
			assertEquals(q2.getPoints(), 13);
			assertEquals(q2.getQuestionText(), "question");
			assertEquals(q2.getTime(), 11);
			assertTrue(q2.getTopics().equals(s));
			assertEquals(q2.getType(), "Graphic");
		} catch (EmptyBoxException e) {
		}
		try {
			GraphicsQuestion q2 = new GraphicsQuestion("", "Robert", "cpe309",
					s, 11, 2, 13);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Question Text must be filled in.").toString());
		}
		try {
			GraphicsQuestion q2 = new GraphicsQuestion("question", "Robert", "cpe309",
					new ArrayList<String>(), 11, 2, 13);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Topic must be filled in.").toString());
		}
		try {
			GraphicsQuestion q2 = new GraphicsQuestion("question", "Robert", "Course",
					s, 11, 2, 13);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Course must be filled in.").toString());
		}
	}
	
	public void testSettersandGetters() {
		assertEquals(q.getAuthor(), "Robert Almada");
		assertEquals(q.getCourse(), "CPE309");
		assertEquals(q.getDifficulty(), 3);
		assertEquals(q.getLastUsed(), "Never");
		assertEquals(q.getPoints(), 100);
		assertEquals(q.getQuestionText(), "Hello, world!");
		assertEquals(q.getTime(), 10);
		assertTrue(q.getTopics().equals(s));
		assertEquals(q.getType(), "Graphic");
	}
	
	public void testToString() {
		String g = "questionText=Hello, world!, author=Robert Almada, lastUsed=Never, course=CPE309, topics=[hello, world!], time=10, difficulty=3, type=Graphic, points=100,";
		assertEquals(q.toString(), g);
	}
}