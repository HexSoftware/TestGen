package testtool.models.questiondb;

import java.util.ArrayList;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 30apr14
 * 
 * QuestionEntry is a modified version of a Question, that adds a boolean and
 * an int to help manage QuestionList interactions. The component selected is 
 * for determining if a Question is selected, and the filtered value keeps 
 * track of whether or not the entry has been filtered out by a filter.
 * More details to come later.
 */
public class QuestionEntry {
	public Question question;
	public ArrayList<Filter> filters;
	
	public QuestionEntry(Question q, ArrayList<Filter> f) {
		question = q;
		filters = f;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void addFilter(Filter fil) {
		filters.add(fil);
	}
	
	public ArrayList<Filter> getFilters() {
		return filters;
	}
	
	public Filter getFilter(int idx) {
		return filters.get(idx);
	}
	
	public void removeFilter(Filter fil) {
		filters.remove(fil);
	}
}
