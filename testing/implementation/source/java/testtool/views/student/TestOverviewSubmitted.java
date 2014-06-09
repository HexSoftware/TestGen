package testtool.views.student;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

public class TestOverviewSubmitted {

    public TestOverviewSubmitted() {
        JFrame frame = new JFrame("Midterm 1");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        
        Font font = new Font("Calibri", Font.BOLD, 24);
        Font font1 = new Font("Calibri", Font.PLAIN, 18);
        
        JLabel directoryPath = new JLabel("My Classes > CPE101-01A > Midterm 1");
        directoryPath.setBounds(20, 20, 500, 25);
        directoryPath.setFont(font1);
        directoryPath.setForeground(Color.BLUE);
        directoryPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(directoryPath);

        JLabel description = new JLabel("Midterm 1");
        description.setBounds(325, 150, 150, 25);
        description.setFont(font);
        panel.add(description);
        
        JLabel notes = new JLabel("This is Midterm 1");
        notes.setBounds(315, 225, 500, 25);
        notes.setFont(font1);
        panel.add(notes);
        
//        JLabel properties0 = new JLabel("This test will open on Wednesday, January 29, 2014, 9:00 am");
//        properties0.setBounds(175, 275, 500, 25);
//        properties0.setFont(font1);
//        panel.add(properties0);
        
        JLabel properties = new JLabel("This test closed on Wednesday, January 29, 2014, 10:00 am");
        properties.setBounds(180, 300, 500, 25);
        properties.setFont(font1);
        panel.add(properties);
        
        JLabel category2 = new JLabel("Status");
        category2.setBounds(350, 400, 150, 25);
        category2.setFont(font);
        panel.add(category2);
        
        /*
        JLabel incorrect = new JLabel("Incorrect Password");
        incorrect.setBounds(325, 425, 175, 25);
        incorrect.setForeground(Color.RED);
        incorrect.setFont(font1);
        panel.add(incorrect);
        */
        
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(250, 450, 100, 25);
//        passwordLabel.setFont(font1);
//        panel.add(passwordLabel);
//
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(350, 450, 200, 25);
//        passwordText.setFont(font1);
//        panel.add(passwordText);
        
        JLabel curStatus = new JLabel("Closed");
        curStatus.setBounds(355, 475, 100, 25);
        curStatus.setFont(font1);
        curStatus.setForeground(Color.RED);
        panel.add(curStatus);

        
        JLabel startTest = new JLabel("Review Test");
        startTest.setBounds(340, 500, 150, 25);
        startTest.setFont(font1);
        startTest.setForeground(Color.BLUE);
        startTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startTest.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int count = e.getClickCount();
        		if (count == 1) {
        			new StudentRev();
        		}
        	}
        });
        panel.add(startTest);
        
    }
}

