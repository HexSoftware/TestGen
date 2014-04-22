/*
*@author Grant Pickett
*/

package testtool.models.testdb;
import java.lang.reflect.Field;
import java.util.ArrayList;
/**
*   This class manages and stores Tests. The test parameter is a selected test.
*/
public abstract class TestDatabase {
   /**
	 * The collection of Test Objects
	 */
   ArrayList<Test> tests;
/*@
  ensures
  //
  // test will be added
  //
  (Test test = null)
  @*/
public static Test addTest(Test t){
   tests.add(t);
}
  /*@
  requires
  //
  // A test to be in the database
  //
  (\exists Test test && tests.length > 0)
  ensures
  //
  // tests will be found that match given
  //
  (Test test = null)
  @*/
  public static Test getTest(String column, String data){
    /*for (int i = 0; i < tests.length; i++)
      if(tests.get(i).field == data) {
       Test t = tests.get(i);
      }
    }*/
    Test t = new Test();
    StringBuilder result = new StringBuilder();
    String newLine = System.getProperty("line.separator");

    result.append( t.getClass().getName() );
    result.append( " Object {" );
    result.append(newLine);

    //determine fields declared in this class only (no fields of superclass)
    Field[] fields = t.getClass().getDeclaredFields();

    //print field names paired with their values
    for ( Field field : fields  ) {
      result.append("  ");
      try {
        result.append( field.getName() );
        result.append(": ");
        //requires access to private field:
        result.append( field.get(t) );
      } catch ( IllegalAccessException ex ) {
        System.out.println(ex);
      }
      result.append(newLine);
    }
    result.append("}");
    System.out.println(result);
    return t;
  }
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
