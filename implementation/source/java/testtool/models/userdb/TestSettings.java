package testtool.models.userdb;

/**
 * @author Yuliya Levitskaya
 * 
 */


import java.util.Date;

import javax.swing.JComboBox;

import testtool.models.testdb.Test;


/**
 * This class displays the settings for a particular test.
 */
public  class TestSettings {
	public Test t;
	public TestSettings(Test test){
		t = test;
	}
	public String getType(){
		return t.getTestParam("testType");
	}
	public String getStartDate(){
		return t.getTestParam("startDate");
	}
	public String getsTime(){
		return t.getTestParam("startTime");
	}
	public String geteTime(){
		return t.getTestParam("endTime");
	}
	public String getEndDate(){
		return t.getTestParam("endDate");
	}
	public String getPass(){
		return t.getTestParam("password");
	}
	public String getNotes(){
		return t.getTestParam("notes");
	}
	public String getGradeType(){
		return t.getTestParam("gradeType");
	}
	public void setsTime(String s){
		t.setTestParam("startTime", s);
	}
	public void seteTime(String s){
		t.setTestParam("endTime", s);
	}
	public void setGradeType(String s){
		t.setTestParam("gradeType", s);
	}
	public void setNotes(String n){
		t.setTestParam("notes", n);
	}
	public void setPass(String p){
		t.setTestParam("password", p);
	}
	public void setType(String s){
		t.setTestParam("testType", s);
	}
	public void setStartDate(String d){
		t.setTestParam("startDate", d);
	}
	public void setEndDate(String d){
		t.setTestParam("endDate", d);
	}/**
     	* Method used in publishing the test.
	* @param t - test to publish
	* test must be already in the userdb
     	*/
	 public void publish(String startDateField, String endDateField, String startTimeField, 
			 String endTimeField, String notesTextField,String passwordTextField, String testTypeList, String gradingTypeList){
		 this.setStartDate(startDateField);
		 this.setEndDate(endDateField);
		 this.setsTime(startTimeField);
		 this.seteTime(endTimeField);
		 this.setNotes(notesTextField);
		 this.setPass(passwordTextField);
		 this.setType(testTypeList);
		 this.setGradeType(gradingTypeList);
		 System.out.println("In TestSettings.publish.");
	}
}