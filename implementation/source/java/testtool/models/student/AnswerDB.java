package testtool.models.student;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @author Kevin Pham 
 * @version 20apr14
 * 
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * studentAnswers is the collection of answers submitted by the students
 */
public class AnswerDB {
   ArrayList<StudentAnswers> studentAnswers;

   public AnswerDB() {
	   studentAnswers = new ArrayList<StudentAnswers>();
   }
   
   
   /**
    * adds a StudentAnswer to the Collections of StudentAsnwers
    * @param answer - the Student answer to add
    */
   public void addStudentAnswer(StudentAnswers answer) {
	  studentAnswers.add(answer);
   }

   /**
    * removes a StudentAnswer from the Collections of StudentAsnwers
    * @param answer - the Student answer to remove
    */
   public void removeStudentAnswer(StudentAnswers answer) {
	  studentAnswers.remove(answer);
   }

  
   /*
    * Returns the size of the Database
    */
   public int getSize() {
	   return studentAnswers.size();
   }
   
   public StudentAnswers getStudentAnswer(int index) {
	   return studentAnswers.get(index);
   }
}
