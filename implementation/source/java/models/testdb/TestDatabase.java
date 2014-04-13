package testdb;
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
	/*@
		ensures
		//
		// The generation dialouge will appear
		//
	 */
	void createTest(){
	  System.out.println("in TestDatabase.createTest);
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
	void editTest(Test t){
	  System.out.println("in TestDatabase.editTest);
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
	void removeTest(Test t){
	  System.out.println("in TestDatabase.removeTest);
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
	void takeTest(Test t){
	  System.out.println("in TestDatabase.takeTest);
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
	void publishTest(Test t){
	  System.out.println("in TestDatabase.publishTest);
	}
}
