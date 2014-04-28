package testtool.models.userdb;

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
	public void options(){
		System.out.println("In Proctor.options.");
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
	public void listOfTests(){
		System.out.println("In Proctor.ListOfTests.");
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
		 * accesses student grades
		 *);
 */
	public void grades(){
		System.out.println("In Proctor.grades.");
	}
}
