package testtool.models.questiondb;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 21may14	
 * 
 * The Category class allows more functionality with sorting, applying 
 * filters, and searching through the Question list. It also allows adding
 * and hiding of Categories in the the graphical view of the databank. The 
 * title component is the name of the category. The int sortState dictates if 
 * the category column in the databank is sorted (either ascending or 
 * descending) or not. The hidden field states if the category is hidden from
 * being shown in the databank or not.
 * More details to come later.
 */
public class Category{
	public String title;
	public int sortState;	
	
	public Category(String t) {
		title = t;
		sortState = 0;
	}
	
	public int getSortState() {
		return sortState;
	}
	
	public void setSortState(int ss) {
		sortState = ss;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String t) {
		title = t;
	}
}
