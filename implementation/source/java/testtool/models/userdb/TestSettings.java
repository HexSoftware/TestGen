package userdb;

@author Yuliya Levitskaya

import java.util.Date;

import testdb.Test;


/**
 * This class displays the settings for a particular test.
 */
public abstract class TestSettings {
	String type;
	Date start;
	Date end;
	String password;
	String notes;
	String gradingType;
	Test test;
    	/**
     	* Method used in publishing the test.
	* @param t - test to publish
	* test must be already in thes userdb
     	*/
	abstract boolean publish(Test t){
      System.out.println("In Settings.publish.");
	}
}
