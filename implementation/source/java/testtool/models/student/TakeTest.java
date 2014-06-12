package testtool.models.student;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import testtool.models.questiondb.*;
import testtool.models.testdb.Test;
import testtool.models.userdb.Student;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 08jun14
 * 
 * TakeTest is the test the student is currently taking. 
 * TimeRemaining is the time before the test is closed. 
 * The List AnsweredQuestions keeps track of which questions were answered. 
 * currentQuestion is the currently selected question. 
 * StudentAnswers is the list of all answers the student submits as well as
 *  the student's information and test for which the answers are for
 */
public class TakeTest {
  double timeRemaining;
  List<Boolean> answeredQuestions;
  int currentQuestion;
  StudentAnswers studentAnswer;
 
  /**
  * Jumps to desired question
  * @param number - Question to retrieve
  * @return Question - the desired question
  */
  /*@
   requires
    //
    // the question index to be a valid question in the Test
    //
    (\exists Test test; number > 0 && number <= test.totalQuestions)
   ensures
    //
    // sets the currentQuestion to the inputted number
    //
    result currentQuestion = number
  @*/
  public Question getQuestion(int number) {
	  System.out.println("In TakeTest.getQuestion.");
	  return null;
  }
  
  /**
   * obtains the difference of two times in seconds
   * @param timeA
   * @param timeB
   * @return time difference in seconds
   */
  public long GetTimeDifferenceInSec(String testTime) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat Format = new SimpleDateFormat("hh:mm:ssa");

		String time = Format.format(cal.getTime());
		testTime = testTime.substring(0,5) + ":00" + testTime.substring(5, testTime.length());

	   long diffSeconds = -1;
		try {
			Date currentTime = Format.parse(time);
			Date endTime = Format.parse(testTime);
			long diff = endTime.getTime() - currentTime.getTime();
			diffSeconds = diff / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("current time is " + time);
		System.out.println("end time is " + testTime);
		return diffSeconds;
  }
  
  public boolean DateEquals (String testDate) throws ParseException {
	  Calendar cal = Calendar.getInstance();
     SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		  
     String date = dateFormat.format(cal.getTime());
	  Date currentDate = dateFormat.parse(date);
	  
	  Date endDate = dateFormat.parse(testDate);
	  
	  return (currentDate.equals(endDate));
  }

  /**
   * Submits the students answer for a test in a file "<testTitle>.<studentusername>.txt"
   * @param test - the test to submit the answers for
   * @param student - the student who is submitting the answers
   * @param questionList - the arraylist of questions
   * @param textAnswersList - the arraylist of code, shortanswer, and essay answers
   * @param tfAnswersList - the arraylist of of true/false answers
   */
  public void submitAnswers(Test test, Student student, ArrayList<Question> questionList,
			ArrayList<JTextArea> textAnswersList, ArrayList<ButtonGroup> tfAnswersList, ArrayList<JCheckBox> mcAnswersList) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(test.getTestParam("testTitle") + "." + student.getStudentUsername() + ".txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println(student.getStudentName());
		
		int textAnswerIdx = 0;
		int tfAnswersIdx = 0;
		int mcAnswersIdx = 0;
		for (int i = 0; i < questionList.size(); i++) {
			if (questionList.get(i).type.equals("TF")) {
				System.out.println(i + " is TF");
				ButtonGroup buttonGroup = tfAnswersList.get(tfAnswersIdx);
				Enumeration<AbstractButton> group = buttonGroup.getElements();
				int answer = 0;
				while (group.hasMoreElements()) {
					System.out.println("element " + answer);
					if (group.nextElement().isSelected()) {
						System.out.println("selected " + answer);
						if (answer == 0) {
							writer.println("true");
						} else if (answer == 1) {
							writer.println("false");
						}
						break;
					}
					answer++;
				}
				if (answer == 2) {
					writer.println("<NULL>");
				}
				tfAnswersIdx++;
			}
			else if (questionList.get(i).type.equals("SA") || 
					questionList.get(i).type.equals("Essay") || questionList.get(i).type.equals("Code")) {
				String answer = textAnswersList.get(textAnswerIdx).getText();
				if (answer.equals("")) {
					writer.println("<NULL>");
				} else {
					writer.println("<< " + answer + " >>");
				}
				textAnswerIdx++;
			}
			else if (questionList.get(i).type.equals("MC")) {
				String mcAnswer = "";
				System.out.println("mc question has this many answers:" + ((MCQuestion)questionList.get(i)).possibleAnswers.size());
				for (int j = 0; j < ((MCQuestion)questionList.get(i)).possibleAnswers.size(); j++) {
					
					if (mcAnswersList.get(mcAnswersIdx).isSelected()) {
						System.out.println("selected");
						mcAnswer = mcAnswer + j;
					}
					mcAnswersIdx++;
				}
				if (mcAnswer.equals("")) {
					writer.println("<NULL>");
				}
				else {
					writer.println(mcAnswer);
				}
			}
			else {
				writer.println("<< Unimplemented! >>");
			}
		}
		writer.close();
	}
}