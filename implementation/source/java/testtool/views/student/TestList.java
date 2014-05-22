package testtool.views.student;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import testtool.models.student.MyTests;
import testtool.models.userdb.Student;
import testtool.models.testdb.*;

import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 20apr14
 * 
 * GUI of the list of tests for a course. The constructor builds the GUI
 * to display. A test can be selected to view its test overview.
 */
public class TestList {
	private int curYposition = 0;
	
	public TestList(Student student, String courseName) {
		JFrame frame = new JFrame("Tests");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        frame.setVisible(true);
        panel.setLayout(null);
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes > " + courseName);
        directoryPath.setBounds(20, 20, 500, 25);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        directoryPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(directoryPath);
        
        drawList(student, courseName, panel, font, font1);
        
        panel.setPreferredSize(new Dimension(500,curYposition + 50));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        frame.add(scrollPane);
	}
	
	public void drawList(final Student curStudent, String curCourse, JPanel panel, Font font, Font font1) {
		ArrayList<Test> courseTests = new ArrayList<Test>();
		
		TestDatabase TestDB = new TestDatabase();
		MyTests testMethods = new MyTests();
		
		courseTests = TestDB.getTest("course", curCourse);
		
		courseTests = testMethods.removeUnscheduled(courseTests);
		int length = courseTests.size();
		System.out.println("drawing tests, size is " + length);
		   
		for (int i = 0; i < length; ) {

			String categoryNum = testMethods.getSmallestCategoryNum(courseTests);
			
			boolean first = true;
			
			for (int j = 0; j < length; ) {
				if (courseTests.get(j).getTestParam("testCategoryNum").equals(categoryNum)) {
					if (first) {
						curYposition += 75;
						JLabel testCategory = new JLabel(courseTests.get(j).getTestParam("testCategory"));
						testCategory.setBounds(50, curYposition, 150, 25);
						testCategory.setFont(font);
						panel.add(testCategory);
						curYposition += 10;
						first = false;
					}
					
					System.out.println("Drew category 1");
					
					drawTestLink(courseTests.get(j), categoryNum, panel, font1);
					courseTests.remove(j);
					length--;
				}
				else {
					j++;
				}
			}
		}
	}
			
	public void drawTestLink(final Test test, String categoryNum, JPanel panel, Font font) {
		
		curYposition += 35;
		
		JLabel testLabel = new JLabel(test.getTestParam("testTitle"));
		testLabel.setBounds(75, curYposition, 250, 25);
		testLabel.setFont(font);
		testLabel.setForeground(Color.BLUE);
		testLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		testLabel.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {

			   int count = e.getClickCount();
			   if (count == 1) {
				   System.out.println("In TestList.mouseClicked.");
				   new TestOverviewUI(test);
			   }
		   }
	   });
      panel.add(testLabel);
	}
}

