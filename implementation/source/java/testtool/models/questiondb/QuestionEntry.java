package questiondb;

/**
 * QuestionEntry is a modified version of a Question, that adds a boolean and
 * an int to help manage QuestionList interactions. The component selected is 
 * for determining if a Question is selected, and the filtered value keeps 
 * track of wether or not the entry has been filtered out by a filter.
 * More details to come later.
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 14apr14
 */
public class QuestionEntry {
	Question question;
	boolean selected;
	boolean filtered;
}
