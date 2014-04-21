package testtool.models.student;
import testtool.models.questiondb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * TestReview is the released information about a graded test. Test is the test
 * that is being shown an overview. Graded informs if the test is graded or
 * not.
 */
 public class TestReview {
   int currentQuestion;
   
   /**
  * Jumps to desired question to review
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
      System.out.println("In TestReview.getQuestion.");
      return null;
  }
 }