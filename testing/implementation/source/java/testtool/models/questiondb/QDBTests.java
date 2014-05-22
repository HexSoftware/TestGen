import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import testtool.models.questiondb.*;

public class QDBTests {
	@Test
	public void testName() {
		QuestionDatabank qdb = new QuestionDatabank(null);
		assertNotNull("QuestionDatabank Created", qdb);
		
		
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("Testing");
		TFQuestion q;
		try {
			q = new TFQuestion("Question Text", "gFisher", "CPE309", topics, 1, 1, true);
			qdb.add(q);
			assertEquals(q, qdb.questions.get(0).question);
		} catch (EmptyBoxException e) {
			e.printStackTrace();
			q = null;
		}
		
		
		Category cat = new Category("fake");
		cat.setTitle("Author");
		assertEquals("Title Changed", "Author", cat.getTitle());
		
		cat.setSortState(1);
		assertEquals("Sort State Change", 1, cat.getSortState());
		
		
		Filter fil = new Filter("gfisher", "fake");
		
		fil.setCategory(cat);
		assertEquals("Category Change", cat, fil.getCategory());
		
		fil.setKeyword("nnordhof");
		assertEquals("Keyword Change", "nnordhof", fil.getKeyword());
		
		qdb.filter(fil);
		assertEquals("Question Filtered", 1, qdb.filteredQs.size());
		
		qdb.unfilter(fil);
		assertEquals("Question Unfiltered", 1, qdb.questions.size());
		
		qdb.remove(new int[]{0});
	}
}
