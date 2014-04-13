package student;
import java.util.Collection;

/**
 * StudentAnswers is a class designed to store a collection of answers
 * linked to the appropriate test and student
 * studentAnswers is the collection of answers submitted by the students
 */
public abstract class AnswerDB {
   Collection<StudentAnswers> studentAnswers;

   /**
    * adds a StudentAnswer to the Collections of StudentAsnwers
    * @param answer - the Student answer to add
    */
   abstract void addStudentAnswer(StudentAnswers answer);

   /**
    * removes a StudentAnswer from the Collections of StudentAsnwers
    * @param answer - the Student answer to remove
    */
   abstract void removeStudentAnswer(StudentAnswers answer);

   /**
    * updates the existing StudentAnswer in the the Collections of StudentAsnwers
    * @param answer - the Student answer to update
    */
   abstract void updateStudentAnswer(StudentAnswers answer);
}