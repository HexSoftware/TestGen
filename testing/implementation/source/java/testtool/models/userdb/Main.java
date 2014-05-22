package testtool.models.userdb;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
	public static void main(String[] args){
	Result result = JUnitCore.runClasses(ProctorTEST.class);
    for (Failure failure : result.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result.wasSuccessful());
    
    Result result1 = JUnitCore.runClasses(ListOfTestsTEST.class);
    for (Failure failure : result1.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result1.wasSuccessful());
    
    Result result2 = JUnitCore.runClasses(TestSettingsTEST.class);
    for (Failure failure : result2.getFailures()) {
       System.out.println(failure.toString());
    }
    System.out.println(result2.wasSuccessful());
	}
}
