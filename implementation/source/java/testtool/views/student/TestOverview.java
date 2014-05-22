package testtool.views.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import testtool.models.testdb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 20apr14
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

    private static void placeComponents(JPanel panel, Test test) {

        panel.setLayout(new BorderLayout());
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes > CPE101-01A > " + test.getTestParam("testTitle"));
        directoryPath.setBounds(20, 20, 300, 15);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        directoryPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(directoryPath);

        JLabel description = new JLabel(test.getTestParam("testTitle"));
        description.setBounds(325, 150, 150, 25);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setFont(font);
        panel.add(description);
        
        JLabel notes = new JLabel(test.getTestParam("notes"));
        notes.setBounds(150, 200, 500, 30);
        notes.setHorizontalAlignment(SwingConstants.CENTER);
        notes.setFont(font1);
        panel.add(notes);
        
//        JLabel properties0 = new JLabel("This test will open on Wednesday, January 29, 2014, 9:00 am");
//        properties0.setBounds(175, 275, 500, 25);
//        properties0.setFont(font1);
//        panel.add(properties0);
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));

        
   	  JLabel properties = new JLabel("This test will open on " + test.getTestParam("startDate") + " " + test.getTestParam("endTime"));
        properties.setBounds(150, 300, 500, 25);
        properties.setFont(font1);
        properties.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(properties);
        
      	  /*
        JLabel properties = new JLabel("This test will close on Wednesday, January 29, 2014, " + test.getTestParam("endTime"));
        properties.setBounds(150, 300, 500, 25);
        properties.setFont(font1);
        properties.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(properties);
        */
      	  
        JLabel category2 = new JLabel("Status");
        category2.setBounds(325, 400, 150, 25);
        category2.setFont(font);
        category2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(category2);
        
        
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
        			overview.checkPassword("password");
        			overview.beginTest(null);
        			//new Midterm1();
        		}
        	}
        });
        panel.add(startTest);
        
        
        /*
        JLabel incorrect = new JLabel("Incorrect Password");
        incorrect.setBounds(325, 425, 175, 25);
        incorrect.setForeground(Color.RED);
        incorrect.setFont(font1);
        panel.add(incorrect);
        */
        
        
        if (test.getTestParam("Password") != null) {
      	  JLabel passwordLabel = new JLabel("Password:");
           passwordLabel.setBounds(250, 450, 100, 25);
           passwordLabel.setFont(font1);
           passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
           panel.add(passwordLabel);

           JPasswordField passwordText = new JPasswordField(20);
           passwordText.setBounds(350, 450, 200, 25);
           passwordText.setFont(font1);
           passwordText.setHorizontalAlignment(SwingConstants.CENTER);
           panel.add(passwordText);
        }
        
        
//        JLabel curStatus = new JLabel("Closed");
//        curStatus.setBounds(355, 475, 100, 25);
//        curStatus.setFont(font1);
//        curStatus.setForeground(Color.RED);
//        panel.add(curStatus);

        JLabel empty = new JLabel("");
        panel.add(empty);
        
    }
}

