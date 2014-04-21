package testtool.models.questiondb;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * Filter is the filter that is applied to the question list. The keyword 
 * component is the word that is being filtered in the category component.
 * More details to come later.
 */
public class Filter {
	String keyword;
	Category category;

	public Filter(String k, String cat) {
		keyword = k;
		category = new Category(cat);
	}
}