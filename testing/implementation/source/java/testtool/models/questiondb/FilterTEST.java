package testtool.models.questiondb;

import junit.framework.TestCase;

/**
 * 
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 12jun14
 */

public class FilterTEST extends TestCase {
	Filter fil1, fil2;
	Category newCat;
	
	public FilterTEST(String name) {
		super(name);
		fil1 = new Filter("MyKeyword", "MyCategory");		
		fil2 = new Filter("MyKeyword", new Category("MyCategory"));
		newCat = new Category("NewMyCategory");
	}
	
	public void testSettersandGetters() {
		fil1.setCategory(newCat);
		fil1.setKeyword("NewMyKeyword");
		
		assertEquals(fil1.category, newCat);
		assertEquals(fil1.keyword, "NewMyKeyword");
		
		assertEquals(fil1.getCategory(), newCat);
		assertEquals(fil1.getKeyword(), "NewMyKeyword");
		
		
		fil2.setCategory(newCat);
		fil2.setKeyword("NewMyKeyword");
		
		assertEquals(fil2.category, newCat);
		assertEquals(fil2.keyword, "NewMyKeyword");
		
		assertEquals(fil2.getCategory(), newCat);
		assertEquals(fil2.getKeyword(), "NewMyKeyword");
	}
	
	
}