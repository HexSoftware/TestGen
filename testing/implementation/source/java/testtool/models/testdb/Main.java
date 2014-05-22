package test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
public static void main(String[] args) throws Exception {                    
	Result result = JUnitCore.runClasses(AutomaticGenerationTest.class);
    for (Failure failure : result.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result.wasSuccessful());
    
    Result result1 = JUnitCore.runClasses(ManualGenerationTest.class);
    for (Failure failure : result1.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result1.wasSuccessful());
    
    Result result2 = JUnitCore.runClasses(TestTest.class);
    for (Failure failure : result2.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result2.wasSuccessful());
    Result result3 = JUnitCore.runClasses(TestDatabaseTest.class);
    for (Failure failure : result3.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result3.wasSuccessful());     
}
}
