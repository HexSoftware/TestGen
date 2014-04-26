/*
 * AutomaticGeneration class is used to generate tests using given
 * inputs
 * @author Grant Pickett
 * @version 4/26/2014
 */

package testtool.models.testdb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import testtool.models.questiondb.Question;
/**
 * This class manages manual generation of a test.
 */
public class AutomaticGeneration {
   /**
    * The collection of questions in the test.
    */
   ArrayList<Question> questions;
   /**
    * The collection of other data for the test.
    */
   HashMap<String, String> settings = new HashMap<String, String>();
   TestDatabase        tdb;
   public AutomaticGeneration(TestDatabase td) {
      tdb = td;
   }
   /**
    * gets input from instructor and saves it to the settings variable
    */
   /*
    * @ ensures (* That settings are setup with the input information);
    * 
    * @
    */
   public void getParams() {
      System.out.println("in AutomaticGeneration.getParams");
   };
   /**
    * add takes a question from the add a question dialog, and adds it into the
    * question list.
    */
   /*
    * @ requires (* That question q is a vaild question.);
    * @ ensures (* That a valid question is added to the databank.);
    */
   void add(Question q) {
      System.out.println("in AutomaticGeneration.add");
      questions.add(q);
   }

   /**
    * remove takes a collection of Questions qs and removes them from the local
    * test.
    * 
    * @param qs
    *           - question(s) to remove
    */
   /*
    * @ requires (* That a one or more questions in the databank are selected.
    * Also that all questions in qs are valid questions and are in the databank
    * also.); ensures (* That some valid questions are removed.);
    * 
    * @
    */
   void remove(Question q) {
      System.out.println("in AutomaticGeneration.remove");
      questions.remove(q);
   }
   /**
    * Lets an instructor finish this step and add the test to the test database
    */
   /*
    * @ requires (* There is at least one question in the test); ensures (* The
    * test is stored in the test database and the user is sent there.);
    * 
    * @
    */
   public void generate() {
      System.out.println("in AutomaticGeneration.generate");
      HashMap<String, String> data = new HashMap<String, String>();
      data.put("state", "template");
      tdb.createTest(data, questions);
   }
}
