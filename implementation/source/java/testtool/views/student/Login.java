package testtool.views.student;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

import testtool.models.student.*;
import testtool.models.userdb.*;
import testtool.views.courses.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * Login Window. The Login screen is the first to be shown when a student
 * runs the testtool applciation. It takes in a username and password
 */
public class Login {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Login");
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

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(250, 200, 80, 25);
        userLabel.setFont(font);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(350, 200, 200, 30);
        userText.setFont(font1);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(200, 250, 150, 25);
        passwordLabel.setFont(font);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(350, 250, 200, 30);
        passwordText.setFont(font1);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(375, 325, 80, 25);
        loginButton.setFont(font1);
        loginButton.addActionListener(new Action1(frame));
        loginButton.setActionCommand("Open");
        panel.add(loginButton);
        
        JLabel appNameLabel = new JLabel("Test-Gen");
        appNameLabel.setBounds(375, 20, 150, 25);
        appNameLabel.setFont(font1);
        panel.add(appNameLabel);
    }

    static class Action1 implements ActionListener {
    	MyCourses myCourses = new MyCourses();
    	Student exStudent = new Student();
    	
    	JFrame mainframe;
    	
    	public Action1 (JFrame frame) {
    		mainframe = frame;
    	}
    	
    	public void actionPerformed (ActionEvent e) {
    		myCourses.login ("username", "password");
    		myCourses.viewCourses(exStudent);
    		new CourseList();
    		mainframe.dispose();
            System.out.println("In Login.actionPerformed.");
    	}
    }
}

