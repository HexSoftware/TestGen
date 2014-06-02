package testtool.views.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.StyledDocument;

import testtool.models.userdb.Student;
import testtool.models.questiondb.Question;
import testtool.models.testdb.Test;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 31may14
 * 
 * GUI of the test taking view allowing students to view
 * and answer questions for a given test
 */
public class TakeTestUI {
	private int curYposition = 25;
	
	public TakeTestUI(Student student, Test test) {
		JFrame frame = new JFrame(test.getTestParam("testTitle"));
		frame.setSize(1000, 700);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(null);
      JPanel paneltop = new JPanel();
      JPanel panel = new JPanel();
      
      frame.setVisible(true);
      paneltop.setLayout(null);
      panel.setLayout(null);
      panel.setBounds(0, 100, 1000, 600);
      
      Font font = new Font("Calibri", Font.BOLD, 24);
      Font font1 = new Font("Calibri", Font.PLAIN, 18);
      
      paneltop.setPreferredSize(new Dimension(1000,100));
      JLabel tempTimer = new JLabel("Temp timer");
      tempTimer.setBounds(900, 25, 150, 25);
      tempTimer.setFont(font1);
      tempTimer.setForeground(Color.RED);
      mainPanel.add(tempTimer);
      frame.add(mainPanel);
      
      JLabel description = new JLabel(test.getTestParam("testTitle"));
      description.setBounds(0, 25, 1000, 25);
      description.setHorizontalAlignment(SwingConstants.CENTER);
      description.setFont(font);
      mainPanel.add(description); 
      //mainPanel.add(panel);
      
      drawQuestions(frame, panel, student, test);
      
      panel.setPreferredSize(new Dimension(500,curYposition));
      JScrollPane scrollPane = new JScrollPane(panel);
      scrollPane.setPreferredSize(new Dimension(900, 600));
      scrollPane.getVerticalScrollBar().setUnitIncrement(16);
      scrollPane.setBounds(75, 75, 900, 575);
      //scrollPane.setBorder(null);
      mainPanel.add(scrollPane);
	}
	
	public void drawQuestions(JFrame mainFrame, JPanel panel, Student student, Test test) {
		Font font = new Font("Calibri", Font.BOLD, 24);
      Font font1 = new Font("Calibri", Font.PLAIN, 18);
		
		ArrayList<Question> questionList= new ArrayList<Question>();
		ArrayList<JTextArea> textAnswerList = new ArrayList<JTextArea>();
		ArrayList<JCheckBox> TFAnswerList = new ArrayList<JCheckBox>();
		
		questionList = test.getQuestionList();
		System.out.println("number of questions: " + questionList.size());
		
		for (int i = 0; i < questionList.size(); i++) {
			curYposition += 50;
			JLabel questionNumLabel = new JLabel("Question " + Integer.toString(i + 1));
			questionNumLabel.setBounds(100, curYposition, 900, 25);
			questionNumLabel.setFont(font);
			panel.add(questionNumLabel);
			
			curYposition += 50;
			//JLabel questionTextLabel = new JLabel(questionList.get(i).questionText);
			//questionTextLabel.setBounds(100, curYposition, 900, 25);
			//questionTextLabel.setFont(font1);
			//panel.add(questionTextLabel);
			
			JTextArea questionText = new JTextArea(questionList.get(i).questionText);
			questionText.setBounds(100, curYposition, 700, 100);
			questionText.setFont(font1);
			questionText.setEditable(false);
			questionText.setOpaque(false);
			questionText.setLineWrap(true);
			questionText.setWrapStyleWord(true);
			panel.add(questionText);
			curYposition += 100;
			if (questionList.get(i).type.equals("MC")) {
				//MC check boxes
			}
			else if (questionList.get(i).type.equals("TF")) {
				TFAnswerList.add(new JCheckBox("true"));
				JCheckBox trueChoice = TFAnswerList.get(TFAnswerList.size() - 1);
				trueChoice.setBounds(150, curYposition, 100, 25);
				trueChoice.setFont(font1);
				panel.add(trueChoice);
				curYposition += 25;
			}
			else if (questionList.get(i).type.equals("SA")) {
				textAnswerList.add(new JTextArea());
				JTextArea myAnswerText = textAnswerList.get(textAnswerList.size() - 1);
				myAnswerText.setBounds(150, curYposition, 600, 25);
				myAnswerText.setLineWrap(true);
				myAnswerText.setWrapStyleWord(true);
				myAnswerText.setFont(font1);
				panel.add(myAnswerText);
				curYposition += 25;
			} else if (questionList.get(i).type.equals("Essay") || questionList.get(i).type.equals("Code")) {
				textAnswerList.add(new JTextArea());
				JTextArea myAnswerText = textAnswerList.get(textAnswerList.size() - 1);
				myAnswerText.setBounds(150, curYposition, 600, 100);
				myAnswerText.setLineWrap(true);
				myAnswerText.setWrapStyleWord(true);
				myAnswerText.setFont(font1);
				panel.add(myAnswerText);
				curYposition += 150;
			}
		}
	}
}