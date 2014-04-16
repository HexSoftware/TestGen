package testtool.models.questiondb;

/**
 * Filter is the filter that is applied to the question list. The keyword 
 * component is the word that is being filtered in the category component.
 * More details to come later.
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 14apr14
 */
public class Filter {
	String keyword;
	Category category;

	public Filter(String k, String cat) {
		keyword = k;
		category = new Category(cat);
	}
}