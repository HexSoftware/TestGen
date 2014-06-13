package testtool.models.grader;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;

import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;

/****
 *
 * Class ReleaseOptions is the companion testing class for class <a href=
 * ReleaseOptions.html> ReleaseOptions </a>.  It implements the following module test plan:
 *                                                                         <ul>
 *                                                                      <p><li>
 *     Phase 1: Unit test the constructor.
 *                                                                      <p><li>
 *     Phase 2: Unit test the addOption and removeOption methods
 *                                                                      <p><li>
 *     Phase 3: Unit test the submitOptions method
 *                                                                      <p><li>
 *     Phase 4: Repeat phases 1 through 3.
 *                                                                      <p><li>
 *     Phase 5: Stress test by adding and submitting 1000 options.
 *                                                                        </ul>
 */


public class ReleaseOptionsTEST extends TestCase {

	
	
	private ArrayList<String> optionList;
	private ReleaseOptions options;
	
	public ReleaseOptionsTEST() {
		options = new ReleaseOptions();
	}
	
	 /**
     * Unit test Constructor 
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1      null					Proper init		only case
     *
     *                                                                  
     */
	public void testZeroOptions() {
		options = new ReleaseOptions();
		optionList = new ArrayList<String>();
		assertSame(options.getOptions().size(), 0 );
	}
	
	 /**
     * Unit test the Adding of Options.
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1   {"Test1","Test2","Test3"}  List of 		Simple Add
     *   							    options correct		
     *
     *   2   A thousand options			Correctly added   Stress Test
     *                                                                  
     */
	public void testAdding() {
		options = new ReleaseOptions();
		optionList = new ArrayList<String>();
		
		options.addOption("Test1");
		options.addOption("Test2");
		options.addOption("Test3");
		
		optionList.add("Test1");
		optionList.add("Test2");
		optionList.add("Test3");
		assertEquals(options.getOptions(), optionList );		
		//System.out.println()
	}
	
	public void stressTestAdd() {
		options = new ReleaseOptions();
		optionList = new ArrayList<String>();
		for(int i = 0; i< 1000; i++) {
			options.addOption("Test"+i);
		}
		for(int i = 0; i< 1000; i++) {		
			optionList.add("Test"+i);
		}
		assertEquals(options.getOptions(), optionList );	
	}
	
	 /**
     * Unit test the Removing of Options.
     *                                                                   
     *  Test
     *  Case    Input                   Output          Remarks
     * ====================================================================
     *   1   {"Test1","Test2","Test3"}  List of 		Remove options one by one
     *   								options correct		in order							
     *
     *   2    {"Test1","Test3","Test2"} Correctly removed  removed out of order
     *                                                                  
     */
	
	public void testRemoving() {
		options = new ReleaseOptions();
		optionList = new ArrayList<String>();
		
		options.addOption("Test1");
		options.addOption("Test2");
		options.addOption("Test3");
		
		optionList.add("Test1");
		optionList.add("Test2");
		optionList.add("Test3");
		assertEquals(options.getOptions(), optionList );	
		
		//Now Remove
		options.removeOption("Test1");
		optionList.remove("Test1");
		assertEquals(options.getOptions(), optionList );	
		
		options.removeOption("Test2");
		optionList.remove("Test2");
		assertEquals(options.getOptions(), optionList );	
		
		options.removeOption("Test3");
		optionList.remove("Test3");
		assertEquals(options.getOptions(), optionList );	
		
	}
	
	
	
	

}
