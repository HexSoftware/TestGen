package testtool.views.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import testtool.models.testdb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 31may14
 * 
 * GUI of the test overview displaying the information of a test.
 * A test overview may prompt the user for a password if required.
 * If opened, a test may be taken by the student.
 */
public class TestOverviewUI {

    public TestOverviewUI(Test curTest) {
        JFrame frame = new JFrame("Midterm 1");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, curTest);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, final Test test) {

        panel.setLayout(new BorderLayout());
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes > CPE101-01A > " + test.getTestParam("testTitle"));
        directoryPath.setBounds(20, 20, 300, 15);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        panel.add(directoryPath);
        
        JLabel refreshLabel = new JLabel("Refresh");
        refreshLabel.setBounds(700, 20, 70, 15);
        refreshLabel.setFont(font1);
        refreshLabel.setForeground(Color.BLUE);
        refreshLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(refreshLabel);

        JLabel description = new JLabel(test.getTestParam("testTitle"));
        description.setBounds(325, 125, 150, 25);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setFont(font);
        panel.add(description); 
   
        //create the Notes Pane
        SimpleAttributeSet bSet = new SimpleAttributeSet();  
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);

        JTextPane notes = new JTextPane();  
        notes.setText(test.getTestParam("notes"));  
        StyledDocument doc = notes.getStyledDocument();  
        doc.setParagraphAttributes(0, 104, bSet, false);
        notes.setBounds(150, 175, 500, 50);
        notes.setFont(font1);
        notes.setEditable(false);
        notes.setOpaque(false);
        
        panel.add(notes);

        JLabel properties = new JLabel();
        JLabel properties2 = new JLabel();
        JLabel state = new JLabel();
        
        //if scheduled but not opened
        if (test.getTestParam("state").equals("scheduled")) {
      	  properties.setText(properties.getText() + "The test will open on " + test.getTestParam("startDate") + 
      			  " at " + test.getTestParam("startTime") + ".");
      	  state.setText("Scheduled");
        }
        else if (test.getTestParam("state").equals("opened")){
      	  properties.setText(properties.getText() + "The test opened on " + test.getTestParam("startDate") + 
      			  " at " + test.getTestParam("startTime") + ".");
      	  properties2.setText(properties2.getText() + "The test will close on " + 
      			  test.getTestParam("endDate") + " at " + test.getTestParam("endTime") + ".");
      	  state.setText("Opened");
      	  
      	  final JPasswordField passwordText = new JPasswordField(20);
      	  if (test.getTestParam("password") != null) {
         	  JLabel passwordLabel = new JLabel("Password:");
              passwordLabel.setBounds(250, 450, 100, 25);
              passwordLabel.setFont(font1);
              passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
              panel.add(passwordLabel);

              passwordText.setBounds(350, 450, 200, 25);
              passwordText.setFont(font1);
              panel.add(passwordText);
           }
      	  
      	  JLabel startTest = new JLabel("Begin Test");
           startTest.setBounds(325, 500, 150, 15);
           startTest.setFont(font1);
           startTest.setHorizontalAlignment(SwingConstants.CENTER);
           startTest.setForeground(Color.BLUE);
           startTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           startTest.addMouseListener(new MouseAdapter() {
           	public void mouseClicked(MouseEvent e) {
           		testtool.models.student.TestOverview overview = new testtool.models.student.TestOverview();
           		
           		int count = e.getClickCount();
           		if (count == 1) {
           			if (test.getTestParam("password") != null) {
           				if (overview.checkPassword(test, passwordText.getPassword())) {
           					overview.beginTest(null);
   	           			System.out.println("Correct Password");
           				}
           				else {
           					System.out.println("Incorrect Password!");
           				}
           			}
           			else {
	           			overview.beginTest(null);
	           			System.out.println("Start the Test");
           			}
           			//check state upon action to ensure test is still open
           			//new Midterm1();
           		}
           	}
           });
           panel.add(startTest);
        }
        else if (test.getTestParam("state").equals("closed")) {
      	  properties.setText(properties.getText() + "The test closed on " + test.getTestParam("endDate") +
      			  " at " + test.getTestParam("endTime") + ".");
      	  state.setText("Closed");
        }
	    properties.setBounds(150, 275, 500, 25);
	    properties.setFont(font1);
	    properties.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(properties);
	    
	    properties2.setBounds(150, 305, 500, 25);
	    properties2.setFont(font1);
	    properties2.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(properties2);
	    
	    state.setBounds(325, 410, 150, 25);
	    state.setFont(font1);
	    state.setHorizontalAlignment(SwingConstants.CENTER);
       panel.add(state);
	        
        JLabel category2 = new JLabel("Status");
        category2.setBounds(325, 375, 150, 25);
        category2.setFont(font);
        category2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(category2);
        
        
        /*
        JLabel incorrect = new JLabel("Incorrect Password");
        incorrect.setBounds(325, 425, 175, 25);
        incorrect.setForeground(Color.RED);
        incorrect.setFont(font1);
        panel.add(incorrect);
        */
        

        JLabel empty = new JLabel("");
        panel.add(empty);
        
    }
}

