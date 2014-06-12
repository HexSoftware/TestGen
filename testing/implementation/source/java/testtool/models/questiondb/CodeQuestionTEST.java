package testtool.models.questiondb;

import java.util.ArrayList;

import junit.framework.TestCase;
import testtool.models.questiondb.CodeQuestion;

/****
 * 
 * Class CodeQuestionTEST is the companion testing class for <a href=
 * CodeQuestion.html> CodeQuestion </a>. It implements the following module
 * test plan:
 * 																		 <ul>
 * 																	  <p><li>
 * 		Phase 1: Unit test the constructor
 * 																	  <p><li>
 * 		Phase 2: Stress test by creating 10000 CodeQuestions
 * 																		</ul>
 * 
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 11jun14
 *
 */

public class CodeQuestionTEST extends TestCase {
	CodeQuestion q = new CodeQuestion();
	ArrayList<String> s = new ArrayList<String>();
	
	public CodeQuestionTEST(String name) {
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
		q.setType("Code");
		q.setScriptPath("This\\is\\the\\path\\to\\the\\script");
		
	}
	
	public void testConstructor() {
		try {
			CodeQuestion q2 = new CodeQuestion("question", "Robert Almada", "cpe309",
						s, 3, 4, "here\\there", 12);
			assertEquals(q2.getAuthor(), "Robert Almada");
			assertEquals(q2.getCourse(), "cpe309");
			assertEquals(q2.getDifficulty(), 4);
			assertEquals(q2.getLastUsed(), "Never");
			assertEquals(q2.getPoints(), 12);
			assertEquals(q2.getQuestionText(), "question");
			assertEquals(q2.getTime(), 3);
			assertTrue(q2.getTopics().equals(s));
			assertEquals(q2.getType(), "Code");
			assertEquals(q2.getScriptPath(), "here\\there");
		} catch (EmptyBoxException e) {
		}
		try {
			CodeQuestion q2 = new CodeQuestion("", "Robert Almada", "cpe309",
						s, 3, 4, "here\\there", 12);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Question Text must be filled in.").toString());
		}
		try {
			CodeQuestion q2 = new CodeQuestion("question", "Robert Almada", "Course",
						s, 3, 4, "here\\there", 12);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Course must be filled in.").toString());
		}
		try {
			CodeQuestion q2 = new CodeQuestion("question", "Robert Almada", "cpe309",
						new ArrayList<String>(), 3, 4, "here\\there", 12);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Topic must be filled in.").toString());
		}
		try {
			CodeQuestion q2 = new CodeQuestion("question", "Robert Almada", "cpe309",
						s, 3, 4, "", 12);
		} catch (EmptyBoxException e) {
			assertEquals(e.toString(), new EmptyBoxException("Path must be filled in.").toString());
		}
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
		assertEquals(q.getType(), "Code");
		assertEquals(q.getScriptPath(), "This\\is\\the\\path\\to\\the\\script");
	}
	
	public void testToString() {
		String g = "questionText=Hello, world!, author=Robert Almada, lastUsed=never, course=CPE309, topics=[hello, world!], time=10, difficulty=3, type=Code, points=100, scriptPath=This\\is\\the\\path\\to\\the\\script";
		assertEquals(q.toString(), g);
	}
}
