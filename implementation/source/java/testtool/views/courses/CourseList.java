package testtool.views.courses;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;

import testtool.models.userdb.Student;
import testtool.models.courses.Course;
import testtool.views.student.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 12May14
 * 
 * GUI of the list of courses. The constructor builds the text to display
 * A course can be selected to list the list of tests in that course.
 */
public class CourseList {
	private int curXposition = 50;
	private int curYposition = 75;
	
	public CourseList(Student student, ArrayList<Course> myCourses) {
		
		JFrame frame = new JFrame("My Courses");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        //frame.add(panel);
        
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
        
        drawCourses(student, myCourses, panel, font, font1);
        
        panel.setPreferredSize(new Dimension(500,curYposition));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        frame.add(scrollPane);
	}
	
	public void drawCourses(final Student curStudent, ArrayList<Course> courses, JPanel panel, Font font, Font font1) {
		ArrayList<JLabel> courseLinks = new ArrayList<JLabel>();
		
		int length = courses.size();
		System.out.println("drawing courses, size is " + length);
		   
		for (int i = 0; i < length; i++) {
			curXposition = 50;
		   final Course course = courses.get(i);
		   courseLinks.add(new JLabel(course.getCourseName()));
		   courseLinks.get(i).setBounds(curXposition, curYposition, 150, 25);
		   courseLinks.get(i).setFont(font);
		   courseLinks.get(i).setForeground(Color.BLUE);
		   courseLinks.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		   courseLinks.get(i).addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {

				   int count = e.getClickCount();
				   if (count == 1) {
					   System.out.println("In CourseList.mouseClicked.");
					   new TestList(curStudent, course.getCourseName());
				   }
			   }
		   });
		   panel.add(courseLinks.get(i));
		   
		   drawInstructor(courses, course, panel, font1);
	   
		   System.out.println("Course " + i + " is " + course.getCourseName());
		   System.out.println("Instructor " + i + " is " + course.getCourseInstructor());
	   }
	}
	
	public void drawInstructor (ArrayList<Course> courses, Course curCourse, 
			JPanel panel, Font font) {
		
		curXposition = 75;
		curYposition += 25;
		
		JLabel instructorLabel = new JLabel(curCourse.getCourseInstructor());
		instructorLabel.setBounds(curXposition, curYposition, 250, 25);
		instructorLabel.setFont(font);
      panel.add(instructorLabel);
      
      curYposition += 75;
	}
}
