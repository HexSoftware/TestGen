package testtool.models.student;

/**
 * @author Alvin Lam (aqlam@calpoly.edu
 * @version 20apr14
 * 
 * Answer is a class that defines a question's answer.
 * mcAnswer is a String of numbers that defines the correct index answers.
 * tfAnswer is a boolean, true representing the correct answer as true, false otherwise
 * answerFill is a series of words that can be used for a short answer, essay, or code
 * fileAnswer is the name of the file submitted for graphics questions.
 * index is the Question number for which the answer corresponds to
 */
public class Answer {
   String mcAnswer;
   boolean tfAnswer;
   String answerFill;
   String fileAnswer;
   int index;
   
   public Answer() {}
   
   public void setMC(String mc) {
	   mcAnswer = mc;	   
   }
   
   public void setTF(boolean bool) {
	   tfAnswer = bool;
   }
   
   public void setFill(String fill) {
	   answerFill = fill;
   }
   
   public void setFile(String fileName) {
	   System.out.println("Setting File");
   }
   
   public void setAnswerNum(int num) {
	   index = num;
   }
   
}