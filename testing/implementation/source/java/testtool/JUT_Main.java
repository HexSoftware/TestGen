package testtool;

import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testtool.models.student.*;
import testtool.models.courses.*;
import testtool.models.userdb.*;
 
public class JUT_Main{
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JUT_Login.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
      
      Result result1 = JUnitCore.runClasses(JUT_Course.class);
      for (Failure failure : result1.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result1.wasSuccessful());
      
      Result result2 = JUnitCore.runClasses(JUT_Student.class);
      for (Failure failure : result2.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result2.wasSuccessful());
      
      Result result3 = JUnitCore.runClasses(JUT_MyCourses.class);
      for (Failure failure : result3.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result3.wasSuccessful());
      
      Result result4 = JUnitCore.runClasses(JUT_MyTests.class);
      for (Failure failure : result4.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result4.wasSuccessful());
   }
}