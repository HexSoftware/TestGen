package testtool.models.grader;
import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import testtool.models.grader.*;
import testtool.models.student.*;



public class graderTestDriver  {

	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(ReleaseOptionsTEST.class);
	      System.out.println("Testing ReleaseOptions Methods");
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	      
	      Result result1 = JUnitCore.runClasses(StudentAnswersTEST.class);
	      System.out.println("Testing StudentAnswers Methods");
	      for (Failure failure : result1.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result1.wasSuccessful());
	}
	
}
