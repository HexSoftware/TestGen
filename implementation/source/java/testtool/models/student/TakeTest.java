package testtool.models.student;

import java.util.List;

import testtool.models.questiondb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
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
  * Submits the selected or inputed answer to the currently selected 
  * question.
  * @param answer - String to submit
  */
  /*@
   requires
    //
    // the currentquestion for which the answer is for must a valid index
    // 
    (\exists Test test; currentQuestion > 0 && currentQuestion <= test.totalQuestions)
   ensures
    //
    // the answer is submitted to the AnswerDB
    //
    (\exists AnswerDB.contains(answer))
  @*/
  public void submitAnswer(Answer answer) {
	  System.out.println("In TakeTest.submitAnswer.");
  }

  /**
  * Submits the StudentAnswers to be graded.
  * @param studentanswer - is the list of answers to be submitted
  */
  /*@
   requires
    //
    // at least one answer to be submitted
    //
    (StudentAnswers != null)
   ensures
    //
    // the StudentAnswer to be submitted to the Answer database
    //
    (\exists AnswerDB.studentAnswers.contains(studentanswer))
  @*/
  public void submitTest(StudentAnswers studentanswer) {
	  System.out.println("In TakeTest.submitTest.");
  }
}