package testtool.models.testdb;
import java.util.ArrayList;
import java.util.HashMap;

import testtool.models.questiondb.Question;

public class Test {
   /*
    * public String uniqueId; public String state; public Collection<Question>
    * questions; public String testTitle; public String author; public String
    * lastUsed; public String totalQuestions; public String totalPoints; public
    * String totalTime; public String avgDifficulty; public String course;
    */
   HashMap<String, String> testParams   = new HashMap<String, String>();
   ArrayList<Question>     questionList = new ArrayList<Question>();

   public Test(HashMap<String, String> testP,
         ArrayList<Question> questionL) {
      testParams = testP;
      questionList = questionL;
   }
  public Test(){
	   
   }
   public String getTestParam(String column) {
      return testParams.get(column);
   }
   public String setTestParam(String column, String data) {
	      return testParams.put(column, data);
	   }
   public ArrayList<Question> getQuestionList() {
      return questionList;
   }
}
