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
	
	/**
 	* Method used in constructing test settings for the test.
* @param t - test belonging to the test settings
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * The specified test exists.
		 *);
	ensures
		(*
		 * Creates the test settings for the test.
		 *);
 */
	public TestSettings(Test test){
		t = test;
	}
	/**
 	* Method used in getting the type of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getType(){
		return t.getTestParam("testType");
	}
	
	/**
 	* Method used in getting the start date of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getStartDate(){
		return t.getTestParam("startDate");
	}
	/**
 	* Method used in getting the start tiem of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getsTime(){
		return t.getTestParam("startTime");
	}
	/**
 	* Method used in getting the end time of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String geteTime(){
		return t.getTestParam("endTime");
	}
	
	/**
 	* Method used in getting the end date of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getEndDate(){
		return t.getTestParam("endDate");
	}
	
	/**
 	* Method used in getting the password for the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getPass(){
		return t.getTestParam("password");
	}
	/**
 	* Method used in getting the notes of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getNotes(){
		return t.getTestParam("notes");
	}
	
	/**
 	* Method used in getting the grade type of the test.
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will retrieve the information
		 *);
 */
	public String getGradeType(){
		return t.getTestParam("gradeType");
	}
	
	/**
 	* Method used in setting the start time of the test.
 	* @param s - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setsTime(String s){
		t.setTestParam("startTime", s);
	}
	/**
 	* Method used in setting the end time of the test.
 	* @param s - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void seteTime(String s){
		t.setTestParam("endTime", s);
	}
	
	/**
 	* Method used in setting the grade type of the test.
 	* @param s - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setGradeType(String s){
		t.setTestParam("gradeType", s);
	}
	
	/**
 	* Method used in setting the notes of the test.
 	* @param n - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setNotes(String n){
		t.setTestParam("notes", n);
	}
	/**
 	* Method used in setting the password for the test.
 	* @param p - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setPass(String p){
		t.setTestParam("password", p);
	}
	/**
 	* Method used in setting the test type of the test.
 	* @param s - the string representing the data to update
* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setType(String s){
		t.setTestParam("testType", s);
	}
	/**
 	* Method used in setting the start date of the test.
 	* @param d - the string representing the data to update
 	* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setStartDate(String d){
		t.setTestParam("startDate", d);
	}
	
	/**
 	* Method used in setting the end date of the test.
 	* @param d - the string representing the data to update
 	* test must be already in the userdb
 	*/
/*@
	requires
		(*
		 * Test must exist
		 *);
	ensures
		(*
		 * Database will update the database
		 *);
 */
	public void setEndDate(String d){
		t.setTestParam("endDate", d);
	}
	/**
     	* Method used in publishing the test.
	* @param startDateField - start date of the test
	* @param endDateField - end date of the test
	* @param startTimeField - start time of the test
	* @param endTimeField - end time of the test
	* @param notesTextField - notes of the test
	* @param passwordTextField - password for the test
	* @param testTypeLis - test type
	* @param gradingTypeList - grading type of the test
	* test must be already in the userdb
     	*/
	/*@
		requires
			(*
			 * Test must exist.
			 *);
		ensures
			(*
			 * Database will be updated with changes
			 *);
	 */
	 public boolean publish(String startDateField, String endDateField, String startTimeField, 
			 String endTimeField, String notesTextField,String passwordTextField,
			 String testTypeList, String gradingTypeList){
		 this.setStartDate(startDateField);
		 this.setEndDate(endDateField);
		 this.setsTime(startTimeField);
		 this.seteTime(endTimeField);
		 this.setNotes(notesTextField);
		 this.setPass(passwordTextField);
		 this.setType(testTypeList);
		 this.setGradeType(gradingTypeList);
		 System.out.println("In TestSettings.publish.");
		 return true;
	 }
}