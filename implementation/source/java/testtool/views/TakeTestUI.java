package testtool.views.student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;


import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import testtool.models.userdb.Student;
import testtool.models.questiondb.MCQuestion;
import testtool.models.questiondb.Question;
import testtool.models.testdb.Test;
import testtool.models.student.TakeTest;

/**
 * @author Alvin Lam (aqlam@calpoly.edu)
 * @version 08jun14
 * 
 * GUI of the test taking view allowing students to view
 * and answer questions for a given test
 */
public class TakeTestUI {
	private int curYposition = 25;
	
	public TakeTestUI(final Student student, final Test test) {
		final TakeTest TakeTestModel = new TakeTest();
		
		final ArrayList<Question> questionList= new ArrayList<Question>();
		final ArrayList<JTextArea> textAnswerList = new ArrayList<JTextArea>();
		final ArrayList<ButtonGroup> TFAnswerList = new ArrayList<ButtonGroup>();
		final ArrayList<JCheckBox> MCAnswerList = new ArrayList<JCheckBox>();
		
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
		
      if (!test.getTestParam("state").equals("Open")) {
	      try {
				if (TakeTestModel.DateEquals(test.getTestParam("endDate"))) {
					final JLabel timing = new JLabel();
					timing.setBounds(865, 25, 150, 25);
					timing.setFont(font1);
					timing.setForeground(Color.RED);
					final Timer t = new Timer(1000, new ActionListener() {
					    private long time = TakeTestModel.GetTimeDifferenceInSec(test.getTestParam("endTime")) * 1000; //10 seconds, for example
					
					    public void actionPerformed(ActionEvent e) {
					        if (time >= 0) {
					            long s = ((time / 1000) % 60);
					            long m = (((time / 1000) / 60) % 60);
					            long h = ((((time / 1000) / 60) / 60) % 60);
					            timing.setText(h + "h : " + m + "m : " + s + "s");
					            timing.repaint();
					            time -= 1000;
					        }
					        else {
					      	  TakeTestModel.submitAnswers(test, student, questionList, textAnswerList, TFAnswerList, MCAnswerList);
					      	  System.out.println("Answers submitted due to time limit");
					        }
					    }
					});
					t.setInitialDelay(0);
					t.start();
					mainPanel.add(timing);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
      }
      frame.add(mainPanel);
      
      JLabel description = new JLabel(test.getTestParam("testTitle"));
      description.setBounds(0, 25, 1000, 25);
      description.setHorizontalAlignment(SwingConstants.CENTER);
      description.setFont(font);
      mainPanel.add(description); 
      //mainPanel.add(panel);
      
      drawQuestions(frame, panel, student, test, questionList, textAnswerList, TFAnswerList, MCAnswerList);
      
      panel.setPreferredSize(new Dimension(500,curYposition));
      final JScrollPane scrollPane = new JScrollPane(panel);
      scrollPane.setPreferredSize(new Dimension(900, 600));
      scrollPane.getVerticalScrollBar().setUnitIncrement(16);
      scrollPane.setBounds(75, 75, 900, 575);
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() { 
             scrollPane.getVerticalScrollBar().setValue(0);
         }
      });
      //scrollPane.setBorder(null);
      mainPanel.add(scrollPane);
	}
	
	public void drawQuestions(final JFrame mainFrame, JPanel panel, Student student, Test test, 
			ArrayList<Question> questions, ArrayList<JTextArea> textAnswers, ArrayList<ButtonGroup> TFAnswers, ArrayList<JCheckBox> MCAnswers) {
		Font font = new Font("Calibri", Font.BOLD, 24);
      Font font1 = new Font("Calibri", Font.PLAIN, 18);
		
		ArrayList<Question> questionList = questions;
		ArrayList<JTextArea> textAnswerList = textAnswers;
		ArrayList<ButtonGroup> TFAnswerList = TFAnswers;
		ArrayList<JCheckBox> MCAnswerList = MCAnswers;
		
		questionList = test.getQuestionList();
		System.out.println("number of questions: " + questionList.size());
		
		for (int i = 0; i < questionList.size(); i++) {
			curYposition += 50;
			
			JLabel questionNumLabel = new JLabel("Question " + Integer.toString(i + 1));
			questionNumLabel.setBounds(100, curYposition, 900, 25);
			questionNumLabel.setFont(font);
			panel.add(questionNumLabel);
			
			curYposition += 50;
			
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
				ArrayList<String> answerChoiceList = ((MCQuestion)questionList.get(i)).possibleAnswers;
				
				for (int j = 0; j < answerChoiceList.size(); j++) {
					JCheckBox answerChoice = new JCheckBox(answerChoiceList.get(j));
					answerChoice.setBounds(150, curYposition, 700, 25);
					panel.add(answerChoice);
					MCAnswerList.add(answerChoice);
					curYposition += 25;
				}
			}
			else if (questionList.get(i).type.equals("TF")) {
				ButtonGroup group = new ButtonGroup();
				JRadioButton trueButton = new JRadioButton("true");
				JRadioButton falseButton = new JRadioButton("false");
				group.add(trueButton);
				group.add(falseButton);
				trueButton.setBounds(150, curYposition, 100, 25);
				falseButton.setBounds(150, curYposition + 25, 100, 25);
				panel.add(trueButton);
				panel.add(falseButton);
				TFAnswerList.add(group);
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
			curYposition += 100;
		}
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(0, curYposition, 900, 40);
		submitButton.setFont(font);
		submitButton.addActionListener(new SubmitButtonAction(mainFrame, student, test, questionList, textAnswerList, TFAnswerList, MCAnswerList));
		curYposition += 50;
		panel.add(submitButton);
	}
	
	private static class SubmitButtonAction implements ActionListener {
		
		JFrame mainframe;
		Student curStudent;
		Test curTest;
		ArrayList<Question> questionList;
		ArrayList<JTextArea> textAnswersList;
		ArrayList<ButtonGroup> tfAnswersList;
		ArrayList<JCheckBox> mcAnswersList;
		
		public SubmitButtonAction(JFrame frame, Student student, Test test, ArrayList<Question> questions, 
				ArrayList<JTextArea> textAnswers, ArrayList<ButtonGroup> tfAnswers, ArrayList<JCheckBox> mcAnswers) {
			mainframe = frame;
			curStudent = student;
			curTest = test;
			questionList = questions;
			textAnswersList = textAnswers;
			tfAnswersList = tfAnswers;
			mcAnswersList = mcAnswers;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			TakeTest takeTestMethods = new TakeTest();
			int choice = JOptionPane.showConfirmDialog(
			    mainframe,
			    "Make sure you have answered all questions before submitting.\n" +
			    "Are you sure you would like to submit your answers?",
			    "Submit Confirmation",
			    JOptionPane.YES_NO_OPTION);
			if (choice == 1) {
				System.out.println("Cancel Submit");
			} else {
				takeTestMethods.submitAnswers(curTest, curStudent, questionList, textAnswersList, tfAnswersList, mcAnswersList);
				mainframe.dispose();
			}
		}
	}
}