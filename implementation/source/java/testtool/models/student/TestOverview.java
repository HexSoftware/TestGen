package testtool.models.student;

import java.util.Collection;

import testtool.models.testdb.*;
import testtool.models.userdb.*;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * TestOverview is the limited information about a test. Test is the test
 * that is being shown an overview. Graded informs if the test is graded or
 * not.
 */
 public class TestOverview {
   boolean released;
   Collection<Test> completedtests;
   Test test;
   Student user;
   
   /** 
    * Checks if the entered password is correct. If so beginTest() is called;
    * @param password - password that was inputted by the user
    * @return true if the password matches the test password, otherwise false
   */
   /*@
     requires
      //
      // A String password if test.password is not null
      //
      (test.password != null)

     ensures
      //
      // A boolean is in the output, true if the inputted password matches the password of the test
      // false otherwise
      //
      result test.password.equals(password)
   @*/
   public boolean checkPassword(String password) {
      System.out.println("In TestOverview.checkPassword");
      return true;
   }
   
   /**
    * starts the given Test
    * @param t - Test to begin
    * @return True on success, false otherwise
    */
   /*@
     requires
      //
      // A blank Test template that is "opened" and exist in the testdatabase
      //
      (\exists testdb.contains(test); testdb.test.opened == true)
     ensures
      //
      // a boolean, true if test opens, false otherwise
      //
   @*/
   public boolean beginTest(Test test) {
      System.out.println("In TestOverview.beginTest.");
      return true;
   }
   
  /**
   * Reviews the graded test.
   * @param test - Test to review
   * @return true on success, false otherwise
   */
  /*@
   requires
    //
    // A closed test that is graded.
    // Test must exist in the Test database
    // Student must have submitted answers for the test
    //
    (\exists testdb.contains(test); testdb.tests.opened == false; && testdb.tests.graded == true)
      (Student student; StudentAnswers.student.equals(student))
        (\exists AnswerDB.contains(StudentAnswer))
   ensures
    //
    // true if review test window opens.
    //
  @*/
  public boolean reviewTest(Test test) {
    System.out.println("In TestOverview.reviewTest");
    return true;
  }
}