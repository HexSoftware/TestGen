package questiondb;
import java.util.Collection;

/**
 * The Question Bank is the main focus of the question database, and is the 
 * view from section 2.3. 
 * It displays the list of questions, which is represented by the questions 
 * component. It also handles the management of these questions, which 
 * involves adding, editing, removing, search and filter. 
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 14apr14
 */
public class QuestionDatabank {
	QuestionList questions;
	Collection<Filter> filters;

	/**
	 * add takes a question from the add a question dialog, and adds it into
	 * the question list.
	 */
	/*@
		requires
			(*
			 * That question q is a vaild question.
			 *);
		ensures
			(*
			 * That a valid question is added to the databank.
			 *);
	@*/
	public void add(Question q) {
		System.out.println("in QuestionDatabank.add");
	}

	/**
	 * edit allows changes to be applied to an existing Question q in the 
	 * question list.
	 * @param q - question to edit
	 */
	/*@
		requires
			(*
			 * That a single question in the databank is selected, and that 
			 * Question q is a valid question that is in the databank.
			 *);
		ensures
			(*
			 * That only one valid question is edited.
			 *);
	@*/
	public void edit(Question q) {
		System.out.println("in QuestionDatabank.edit");
	}

	/**
	 * remove takes a collection of Questions qs and removes them from the 
	 * question database. If the question are in one or more tests, it will be
	 * replaced with a dummy question letting the instructor know that the
	 * question had been removed from the database
	 */
	/*@
		requires
			(*
			 * That a one or more questions in the databank are selected. Also
			 * that all questions in  qs are valid questions and are in the 
			 * databank also.
			 *);
		ensures
			(*
			 * That some valid questions are removed.
			 *);
	@*/
	public void remove() {
		System.out.println("in QuestionDatabank.remove");
	}

	/**
	 * search uses the String keyword to find any questions that match keyword.
	 * This match can be in any category, and only searches through questions 
	 * that have not been filtered out. search differs from filter due to 
	 * filter only being able to filter by a full categorical symbol, while 
	 * search can use partial words on any category. A blank search shows all 
	 * questions (clears the search)
	 * @param keyword - keyword to search for
	 */
	/*@
		requires
			(*
			 * That keyword has no whitespace characters aside from space.
		ensures
			(*
			 * That the seacrh won't be searching for newlines or tabs.
			 *);
	@*/
	public void search(String keyword) {
		System.out.println("in QuestionDatabank.search");
	}

	/**
	 * filter applies a Filter fil to the databank. This will only show 
	 * questions who match the full keyword in the filtered category. Multiple 
	 * filters can be applied, and are removed using unfilter. filter differs 
	 * from search due to filter only being able to filter by a full 
	 * categorical symbol, while search can use partial words on any category.
	 * @param fil - filter to search databank with
	 */
	/*@
		requires
			(*
			 * That fil is a valid filter.
			 *);
		ensures
			(*
			 * That a valid filter is applied to the databank.
			 *);
	@*/
	public void filter(Filter fil) {
		System.out.println("in QuestionDatabank.filter");
	}

	/**
	 * unfilter removes a Filter fil from the databank. This will show any
	 * any questions that were being filtered by fil, and don't have any other 
	 * filters on them.
	 * @param fil - filter to remove from databank search
	 */
	/*@
		requires
			(*
			 * That one or more Filters is currently in place, and that Filter
			 * fil is a valid Filter in the databank.
			 *);
		ensures
			(*
			 * That a valid Filter is actually removed from the databank.
			 *);
	@*/
	public void unfilter(Filter fil) {
		System.out.printlm("in QuestionDatabank.unfilter");
	}
}
