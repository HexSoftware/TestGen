package testtool.models.questiondb;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * QuestionEntry is a modified version of a Question, that adds a boolean and
 * an int to help manage QuestionList interactions. The component selected is 
 * for determining if a Question is selected, and the filtered value keeps 
 * track of whether or not the entry has been filtered out by a filter.
 * More details to come later.
 */
public class QuestionEntry {
	Question question;
	boolean selected;
	boolean filtered;
}
