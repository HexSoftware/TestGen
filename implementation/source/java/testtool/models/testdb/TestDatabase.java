/*
*@author Grant Pickett
*/

package testtool.models.testdb;
import java.util.Collection;
/**
*   This class manages and stores Tests. The test parameter is a selected test.
*/
public abstract class TestDatabase {
   /**
	 * The collection of Test Objects
	 */
   Collection<Test> tests;

	/**
	 * This method will begin the process of creating a new test
	 */
	public /*@
		ensures
		//
		// The generation dialouge will appear
		//
	 */
	void createTest(){
	  System.out.println("in TestDatabase.createTest");
	}
	/**
	 * This method will begin the process of editting a test
	 */
	 /*@
   requires
    //
    // A test to be in the database
    //
    (\exists Test test && tests.length > 0)
   ensures
    //
    // test will be put into edit mode
    //
    @*/
	public void editTest(Test t){
	  System.out.println("in TestDatabase.editTest");
	}
	/**
	 * This method will begin the process of removing a test
	 */
	 /*@
   requires
    //
    // A test to be in the database
    //
    (\exists Test test && tests.length > 0)
   ensures
    //
    // test will be removed
    //
    (Test test = null)
  @*/
	public void removeTest(Test t){
	  System.out.println("in TestDatabase.removeTest");
	}
	/**
	 * This method will begin the process of taking a test
	 */
	 /*@
   requires
    //
    // A test to be in the database
    //
    (\exists Test test && tests.length > 0)
   ensures
    //
    // test will be taken
    //
  @*/
	public void takeTest(Test t){
	  System.out.println("in TestDatabase.takeTest");
	}
	/**
	 * This method will begin the process of publishing a test
	 */
	 /*@
   requires
    //
    // A test to be in the database
    //
    (\exists Test test && tests.length > 0)
   ensures
    //
    // test will be published
    //
  @*/
	public void publishTest(Test t){
	  System.out.println("in TestDatabase.publishTest");
	}
}
