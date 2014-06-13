package testtool.models.student;
import java.util.ArrayList;
import java.util.Collection;

import testtool.models.testdb.Test;
import testtool.models.userdb.Student;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @author Kevin Pham
 * 
 * @version 20apr14
 * 
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * answers is the collection of answers submitted by the student
 * student is the student who submitted the answers
 * test is the test for which the answers are for
 */
public class StudentAnswers {
   ArrayList<Answer> answers;
   Student student;
   Test test;

   
   public StudentAnswers() {
	   answers = new ArrayList<Answer>();
   }
   
   
   /**
    * adds an answer to the Collection of answers
    * @param answer - the answer to add to the collection
    */
   public void addAnswer(Answer answer) {
	   answer.index = answers.size();
	   answers.add(answer);
	   
   }

   /**
    * removes an answer from the Collection of answers
    * @param answer - the answer to remove from the collection
    */
   public void removeAnswer(Answer answer) {
	   answers.remove(answer);
   }

   /**
    * updates the existing answer from the collection of answers
    * @param answer - the answer to update
    */
   public void updateAnswer(Answer answer, Answer newAnswer) {
	   int old = answers.indexOf(answer);
	   answers.set(old, newAnswer);
   }
   
   
   /**
    * 
    * @return the ArrayList of answers
    */
   public ArrayList<Answer> getAnswers() {
	   return answers;
   }
   
   
}
