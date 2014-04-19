package implementation.source.java.testtool.models.userdb;

/*@author Yuliya Levitskaya*/

import java.util.Date;

import implementation.source.java.testtool.models.testdb.Test;


/**
 * This class displays the settings for a particular test.
 */
public  class TestSettings {
	String type;
	Date start;
	Date end;
	String password;
	String notes;
	String gradingType;
	Test test;
	public TestSettings(){
		
	}
    	/**
     	* Method used in publishing the test.
	* @param t - test to publish
	* test must be already in thes userdb
     	*/
	 public boolean publish(Test t){
      System.out.println("In TestSettings.publish.");
      return true;
	}
}
