package testtool.models.student;
import java.util.Collection;

import testtool.models.testdb.Test;
import testtool.models.userdb.Student;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * answers is the collection of answers submitted by the student
 * student is the student who submitted the answers
 * test is the test for which the answers are for
 */
public class StudentAnswers {
   Collection<Answer> answers;
   Student student;
   Test test;

   /**
    * adds an answer to the Collection of answers
    * @param answer - the answer to add to the collection
    */
   public void addAnswer(Answer answer) {
	   System.out.println("In StudentAnswers.addAnswer");
   }

   /**
    * removes an answer from the Collection of answers
    * @param answer - the answer to remove from the collection
    */
   public void removeAnswer(Answer answer) {
	   System.out.println("In StudentAnswers.removeAnswer");
   }

   /**
    * updates the existing answer from the collection of answers
    * @param answer - the answer to update
    */
   public void updateAnswer(Answer answer) {
	   System.out.println("In StudentAnswers.updateAnswer");
   }
}