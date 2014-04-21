package testtool.models.student;
import java.util.Collection;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * studentAnswers is the collection of answers submitted by the students
 */
public class AnswerDB {
   Collection<StudentAnswers> studentAnswers;

   /**
    * adds a StudentAnswer to the Collections of StudentAsnwers
    * @param answer - the Student answer to add
    */
   public void addStudentAnswer(StudentAnswers answer) {
	   System.out.println("In AnswerDB.addStudentAnswer");
   }

   /**
    * removes a StudentAnswer from the Collections of StudentAsnwers
    * @param answer - the Student answer to remove
    */
   public void removeStudentAnswer(StudentAnswers answer) {
	   System.out.println("In AnswerDB.removeStudentAnswer");
   }

   /**
    * updates the existing StudentAnswer in the the Collections of StudentAsnwers
    * @param answer - the Student answer to update
    */
   public void updateStudentAnswer(StudentAnswers answer) {
	   System.out.println("In AnswerDB.updateStudentAnswer");
   }
}