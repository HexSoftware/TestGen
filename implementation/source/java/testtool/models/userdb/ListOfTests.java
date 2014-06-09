package testtool.models.userdb;
/**/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import testtool.models.testdb.Test;

/**
 * This class displays the list of tests that the instructor had generated.
 * @author Yuliya Levitskaya, Alvin Lam
 * @version 31may14
 */
public class ListOfTests {
	Collection<Test> tests;
	public ListOfTests(){
		
	}
	
	public boolean checkStatus(Test t) throws ParseException{
		String startDate = t.getTestParam("startDate");
		String endDate = t.getTestParam("endDate");
		String startTime = t.getTestParam("startTime");
		String endTime = t.getTestParam("endTime");
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mma");
				
		String date = dateFormat.format(cal.getTime());
		String time = timeFormat.format(cal.getTime());
		
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		
		Date currentDate = dateFormat.parse(date);
		Date currentTime = timeFormat.parse(time);
		
		Date sDate = dateFormat.parse(startDate);
		Date eDate = dateFormat.parse(endDate);

		Date sTime = timeFormat.parse(startTime);
		Date eTime = timeFormat.parse(endTime);
		
		if(currentDate.after(sDate)){
			if(currentDate.before(eDate))
				return true;
			else if(currentDate.after(eDate))
				return false;
		}
		else if(currentDate.before(sDate))
			return false;
		else{
			if(currentTime.after(sTime) || (currentTime.equals(sTime))){
				if(currentTime.before(eTime))
					return true;
				else if(currentTime.after(eTime))
					return false;
				else
					return true;
			}
			else if(currentTime.before(eTime))
				return false;
		}
		return false;
	}

	/**
     	* Method used in adding a new test.
	* @param t - Test to add
	* The test must not be the same as a test already in the userdb
     	*/
	/*@
		requires
			(*
			 * The specified Test is not already in the db
			 *);
		ensures
			(*
			 * The test is added to the db.
			 *);
	 */
	public boolean add(Test t){
		System.out.println("In ListOfTest.add.");
		return true;
	}

	/**
     	* Method used in removing a new test.
     	* @param t - Test to remove
	* The given test must already be in the userdb
     	*/
	/*@
		requires
			(*
			 * The specified Test to exist in the db
			 *);
		ensures
			(*
			 * The test is removed from the database
			 *);
	 */
	public boolean remove(Test t){
		System.out.println("In ListOfTest.remove.");
		return true;
	}

    	/**
    	* Method used in opening the test.
     	* @param t - Test to open
	*The given test must already be in the userdb
     	*/
	/*@
		requires
			(*
			 * The test to be in the db and not be open
			 *);
		ensures
			(*
			 * The test is available to the students
			 *);
	 */
	public boolean open(Test t){
		System.out.println("In ListOfTest.open.");
		t.setTestParam("state", "Open");
		return true;
	}

	/**
     	* Method used in closing a given test.
     	* @param t - Test to close
	*The given test must already be in the userdb
     	*/
	/**
	 * This method will add any options to the
	 * collection of options that the Instructor
	 * or Proctor specify
	 */
	/*@
		requires
			(*
			 * The specified Test is in the db and is not closed already
			 *);
		ensures
			(*
			 * Test will be closed and not available to students
			 *);
	 */
	public boolean close(Test t){
		System.out.println("In ListOfTest.close.");
		t.setTestParam("state", "Closed");
		return true;
	}
	/**
 	* Method used grading a given test.
 	* @param t - Test to close
*The given test must already be in the userdb
 	*/
	/*@
		requires
			(*
			 * The specified Test is in the database
			 *);
		ensures
			(*
			 * The test will be graded
			 *);
	 */
	public boolean grade(Test t){
		t.setTestParam("state", "Graded");
		System.out.println("In ListOfTest.grade.");
		return true;
	}
	public ArrayList<Test> getListOfTests(TestDatabase tdb) {	
		return tdb.tests;
	}
}