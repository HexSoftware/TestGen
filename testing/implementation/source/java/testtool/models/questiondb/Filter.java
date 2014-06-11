package testtool.models.questiondb;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version  21may14
 * 
 * Filter is the filter that is applied to the question list. The keyword 
 * component is the word that is being filtered in the category component.
 * More details to come later.
 */
public class Filter {
	public String keyword;
	public Category category;

	public Filter(String k, String cat) {
		keyword = k;
		category = new Category(cat);
	}
	
	public Filter(String k, Category cat) {
		keyword = k;
		category = cat;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category cat) {
		category = cat;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String k) {
		keyword = k;
	}
}