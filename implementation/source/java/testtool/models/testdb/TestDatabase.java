/*
 * @author Grant Pickett
 */

package testtool.models.testdb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import testtool.models.questiondb.Question;
/**
 * This class manages and stores Tests. The test parameter is a selected test.
 */
public class TestDatabase {
   /**
    * The collection of Test Objects
    */
   static ArrayList<Test> tests = new ArrayList<Test>();
   static Integer         idPos = 0;
   /**
    * This method will begin the process of creating a new test
    */
   /*
    * @ ensures // // The generation dialogue will appear //
    */
   public void createTest(HashMap<String, String> data,
         ArrayList<Question> questionL) {
      idPos += 1;
      data.put("uniqueId", idPos.toString());
      final Test newTest = new Test(data, questionL);
      TestDatabase.tests.add(newTest);
      System.out.println("in TestDatabase.createTest");
   }
   /**
    * This method will begin the process of editing a test
    */
   /*
    * @ requires // // A test to be in the database // (\exists Test test &&
    * tests.length > 0) ensures // // test will be put into edit mode //
    * 
    * @
    */
   public void editTest(Test t) {
      System.out.println("in TestDatabase.editTest");
      //
   }
   /*
    * @ requires // // column && data strings when null will return bad data.
    * undefined behavior. don't do it. // ensures // // Tests returns will be
    * valid for column and data given. Returned list may be of lentgh 0. //
    * 
    * @
    */
   public ArrayList<Test> getTest(String column, String data) {
      final ArrayList<Test> match = new ArrayList<Test>();
      final ArrayList<String> column_names = new ArrayList<String>(
            Arrays.asList("uniqueId", "state", "testTitle"
                  , "author", "lastUsed", "totalQuestions",
                  "totalPoints", "totalTime", "avgDifficulty", "ts", "course"));

      if (column_names.contains(column)) {
         System.out.println("Number of tests in database: "
               + TestDatabase.tests.size());
         for (final Test t : TestDatabase.tests) {
            String val = t.getTestParam(column).toString();
            if (val.equals(data)) {
               match.add(t);
               System.out.println("Match: " + val + " = " + data + " in "
                     + column
                     + ". total matches " + match.size());
            }
         }
      }
      return match;
   }
   /**
    * This method will begin the process of publishing a test
    */
   /*
    * @ requires // // A test to be in the database // (\exists Test test &&
    * tests.length > 0) ensures // // test will be published //
    * 
    * @
    */
   public void publishTest(Test t) {
      System.out.println("in TestDatabase.publishTest");
   }
   /**
    * This method will begin the process of removing a test
    */
   /*
    * @ requires // // A test to be in the database // (\exists Test test &&
    * tests.length > 0) ensures // // test will be removed // (Test test = null)
    * 
    * @
    */
   public void removeTest(Test t) {
      System.out.println("in TestDatabase.removeTest");
   }
   /**
    * This method will begin the process of taking a test
    */
   /*
    * @ requires // // A test to be in the database // (\exists Test test &&
    * tests.length > 0) ensures // // test will be taken //
    * 
    * @
    */
   public void takeTest(Test t) {
      System.out.println("in TestDatabase.takeTest");
   }
   /*
    * @ ensures // // A weird sample test will be in the database //
    * 
    * @
    *//*
       * public void ZerothTest() { final Test z = new Test(); z.uniqueId =
       * "TESTGENTESTNUMBER0"; z.avgDifficulty = 99; z.lastUsed = "NEVER";
       * z.opened = true; z.testTitle = "ZERO"; z.totalPoints = 9001; z.graded =
       * true; z.published = true; z.avgDifficulty = -3; z.author =
       * "Hex Software"; TestDatabase.tests.add(z); }
       */
}
