package testtool.models.userdb;
import java.util.ArrayList;

import testtool.models.testdb.*;

/**
 * Class defines a Proctor user
 * @author Yuliya Levitskaya
 */
public class Proctor {
	static int permission = 2;
	public Proctor(){
		
	}

	/**
 	* Method used in opening the account settings for that user.
 	*/
/*@
	requires
		(*
		 * the user is a proctor
		 *);
	ensures
		(*
		 * accesses the options of that user
		 *);
 */
	public boolean options(){
		System.out.println("In Proctor.options.");
		return true;
	}
	/**
 	* Method used in retrieving all the tests of that user.
 	*/
/*@
	requires
		(*
		 * the user is a proctor
		 *);
	ensures
		(*
		 * accesses the tests of that user
		 *);
 */
	public boolean listOfTests(){
		System.out.println("In Proctor.ListOfTests.");
		TestDatabase td = new TestDatabase();
		ArrayList<Test> t = td.getTest("author", "gpickett");
		return true;
	}
	/**
 	* Method used in accessing student grades.
 	*/
/*@
	requires
		(*
		 * the user is a proctor
		 *);
	ensures
		(*
		 * retrieves test that need to be graded.
		 *);
 */
	public boolean grade(){
		System.out.println("In Proctor.grades.");
		return true;
	}
}