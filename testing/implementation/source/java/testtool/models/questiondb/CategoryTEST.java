package testtool.models.questiondb;

import junit.framework.TestCase;

/**
 * 
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 12jun14
 */

public class CategoryTEST extends TestCase {
	Category cat;
	
	public CategoryTEST(String name) {
		super(name);
		cat = new Category("MyCategory");
	}
	
	public void testSettersAndGetters() {
		cat.setTitle("NewMyCategory");
		cat.setSortState(1);
		
		assertEquals(cat.title, "NewMyCategory");
		assertEquals(cat.sortState, 1);
		
		assertEquals(cat.getTitle(), "NewMyCategory");
		assertEquals(cat.getSortState(), 1);
	}
}