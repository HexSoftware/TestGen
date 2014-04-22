package testtool.models.userdb;

/**
 * @author Yuliya Levitskaya
 * 
 */


import java.util.Date;

import testtool.models.testdb.Test;


/**
 * This class displays the settings for a particular test.
 */
public  class TestSettings {
	String type;
	String start;
	String end;
	String startTime;
	String endTime;
	String password;
	String notes;
	String gradingType;
	public String getType(){
		return this.type;
	}
	public String getStartDate(){
		return this.start;
	}
	public String getsTime(){
		return this.startTime;
	}
	public String geteTime(){
		return this.endTime;
	}
	public String getEndDate(){
		return this.end;
	}
	public String getPass(){
		return this.password;
	}
	public String getNotes(){
		return this.notes;
	}
	public String getGradeType(){
		return this.gradingType;
	}
	public void setsTime(String t){
		this.startTime = t;
	}
	public void seteTime(String t){
		this.endTime= t;
	}
	public void setGradeType(String t){
		this.gradingType = t;
	}
	public void setNotes(String n){
		this.notes =n;
	}
	public void setPass(String p){
		this.password=p;
	}
	public void setType(String t){
		 this.type = t;
	}
	public void setStartDate(String d){
		 this.start = d;
	}
	public void setEndDate(String d){
		 this.end = d;
	}/**
     	* Method used in publishing the test.
	* @param t - test to publish
	* test must be already in thes userdb
     	*/
	 public void publish(Test t){
		 System.out.println("In TestSettings.publish.");
	}
}
