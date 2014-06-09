package testtool.models.student;

import java.util.ArrayList;

import junit.framework.TestCase;
import testtool.models.student.MyTests;
import testtool.models.testdb.Test;

/**
 * @author Alvin Lam
 * @version 09jun14
 * Tests the mycourses methods
 * First Checks for CourseDB file and runs viewCourses that would return true if file is found
 * Second checks viewAllCourses method by comparing the arraylist obtained with expected output
 */
public class JUT_MyTests extends TestCase {
	MyTests TestsModel = new MyTests();

	public JUT_MyTests(String name) {
		super(name);
	}
	
	public void testRemoveUnscheduled() {
		Test test1 = new Test();
		test1.setTestParam("testTitle", "test1");
		test1.setTestParam("state", "scheduled");
		test1.setTestParam("testCategoryNum", "3");
		
		Test test2 = new Test();
		test2.setTestParam("testTitle", "test2");
		test2.setTestParam("state", "unscheduled");
		test2.setTestParam("testCategoryNum", "4");
		
		Test test3 = new Test();
		test3.setTestParam("testTitle", "test3");
		test3.setTestParam("state", "closed");
		test3.setTestParam("testCategoryNum", "2");
		
		ArrayList<Test> testList = new ArrayList<Test>();
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		
		ArrayList<Test> expectedTestList = new ArrayList<Test>();
		testList = TestsModel.removeUnscheduled(testList);
		expectedTestList.add(test1);
		expectedTestList.add(test3);
		
		for (int i = 0; i < expectedTestList.size(); i++) {
			assertTrue(testList.get(i).getTestParam("testTitle").equals(
					expectedTestList.get(i).getTestParam("testTitle")));
			assertTrue(testList.get(i).getTestParam("state").equals(
					expectedTestList.get(i).getTestParam("state")));
		}
	}
	
	public void testGetSmallestCatNum() {
		Test test1 = new Test();
		test1.setTestParam("testTitle", "test1");
		test1.setTestParam("state", "scheduled");
		test1.setTestParam("testCategoryNum", "3");
		
		Test test2 = new Test();
		test2.setTestParam("testTitle", "test2");
		test2.setTestParam("state", "unscheduled");
		test2.setTestParam("testCategoryNum", "4");
		
		Test test3 = new Test();
		test3.setTestParam("testTitle", "test3");
		test3.setTestParam("state", "closed");
		test3.setTestParam("testCategoryNum", "2");
		
		ArrayList<Test> testList = new ArrayList<Test>();
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		
		assertTrue(TestsModel.getSmallestCategoryNum(testList).equals("2"));
	}
}