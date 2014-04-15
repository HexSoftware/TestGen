package student;
import java.util.Collection;

import testdb.Test;
import userdb.Student;

/**
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * answers is the collection of answers submitted by the student
 * student is the student who submitted the answers
 * test is the test for which the answers are for
 *
 * @author Kevin Pham (kpham11@calpoly.edu)
 * version 14apr14
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
      System.out.println("In Student.addAnswer."); 
   }

   /**
    * removes an answer from the Collection of answers
    * @param answer - the answer to remove from the collection
    */
   public void removeAnswer(Answer answer) {
      System.out.println("In Student.removeAnswer."); 
   }

   /**
    * updates the existing answer from the collection of answers
    * @param answer - the answer to update
    */
   public void updateAnswer(Answer answer){
      System.out.println("In Student.updateAnswer."); 
   }
}