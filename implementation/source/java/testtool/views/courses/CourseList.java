package testtool.views.courses;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import testtool.models.student.MyCourses;
import testtool.models.userdb.Student;
import testtool.models.courses.Course;
import testtool.views.student.TestList;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * GUI of the list of courses. The constructor builds the text to display
 * A course can be selected to list the list of tests in that course.
 */
public class CourseList {
	public CourseList() {
		
		JFrame frame = new JFrame("My Courses");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        
        frame.setVisible(true);
        
        panel.setLayout(null);
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes");
        directoryPath.setBounds(20, 20, 500, 25);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        directoryPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(directoryPath);

        JLabel category1 = new JLabel("CPE101-01");
        category1.setBounds(50, 75, 150, 25);
        category1.setFont(font);
        category1.setForeground(Color.BLUE);
        category1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        category1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		MyCourses myCourses = new MyCourses();
        		
        		Student exStudent = new Student();
        		Course exCourse = new Course();
        		
        		int count = e.getClickCount();
        		if (count == 1) {
        			myCourses.viewTests(exCourse, exStudent);
                    System.out.println("In CourseList.mouseClicked.");
        			new TestList();
        		}
        	}
        });
        panel.add(category1);

        JLabel course1 = new JLabel("Instructor: Gene Fisher");
        course1.setBounds(75, 100, 250, 25);
        course1.setFont(font1);
        panel.add(course1);
        
        JLabel category2 = new JLabel("CPE308-01");
        category2.setBounds(50, 175, 150, 25);
        category2.setFont(font);
        category2.setForeground(Color.BLUE);
        category2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(category2);

        JLabel course2 = new JLabel("Instructor: Gene Fisher");
        course2.setBounds(75, 200, 250, 25);
        course2.setFont(font1);
        panel.add(course2);
	}
}
