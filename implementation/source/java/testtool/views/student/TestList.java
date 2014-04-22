package testtool.views.student;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;

import testtool.models.student.MyTests;
import testtool.models.userdb.Student;

import java.awt.event.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 20apr14
 * 
 * GUI of the list of tests for a course. The constructor builds the GUI
 * to display. A test can be selected to view its test overview.
 */
public class TestList {
	
	public TestList() {
		JFrame frame = new JFrame("Tests");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
	}

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes > CPE101-01A");
        directoryPath.setBounds(20, 20, 500, 25);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        directoryPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(directoryPath);

        JLabel category1 = new JLabel("Chapter 1");
        category1.setBounds(50, 75, 150, 25);
        category1.setFont(font);
        panel.add(category1);

        JLabel Test1 = new JLabel("Practice Quiz");
        Test1.setBounds(75, 100, 150, 25);
        Test1.setFont(font1);
        Test1.setForeground(Color.BLUE);
        Test1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(Test1);
        
        JLabel Test2 = new JLabel("Midterm 1");
        Test2.setBounds(75, 125, 150, 25);
        Test2.setFont(font1);
        Test2.setForeground(Color.BLUE);
        Test2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Test2.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		MyTests myTests = new MyTests();
        		
        		Student student = new Student();
        		
        		
        		int count = e.getClickCount();
        		if (count == 1) {
                    System.out.println("In TestList.mouseClicked.");
                    myTests.viewTestOverview(null, student);
        			new TestOverview();
        		}
        	}
        });
        panel.add(Test2);

        
        JLabel Test3 = new JLabel("Take Home Test");
        Test3.setBounds(75, 150, 150, 25);
        Test3.setFont(font1);
        Test3.setForeground(Color.BLUE);
        Test3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(Test3);
        
        JLabel category2 = new JLabel("Chapter 2");
        category2.setBounds(50, 225, 150, 25);
        category2.setFont(font);
        panel.add(category2);

        JLabel Test4 = new JLabel("Quiz 1");
        Test4.setBounds(75, 250, 150, 25);
        Test4.setFont(font1);
        Test4.setForeground(Color.BLUE);
        Test4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(Test4);
    }
}

