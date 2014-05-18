package testtool.models.userdb;

/****
 *
 * Class TestSettingsTEST is the companion testing class for 
 * class <a href=TestSettings.html> TestSetting</a>. It 
 * implements the following module
 * test plan:
 *									  <pre>
 *    Phase 1: Unit test the constructor.
 *
 *    Phase 2: Unit test the simple get/set methods:
 *          getType, getsTime, getStartDate, geteTime, getEndDate,
 *	       getPass, getNotes, setsTime, seteTime, setGradeType,
 *	       setNotes, setPass, setType, setStartDate, setEndDate.
 *
 *    Phase 3: Unit test publish, saving the constructed results
 * 		   for subsequent tests.
 *
 *    Phase 4: Unit test getType, getsTime, getStartDate, geteTime,
 *		 getEndDate, getPass, getNotes, using items added in
 *		Phase 3.
 *    Phase 5: Repeat phases 1 through 4.
 * 
 *    Phase 8: Stress test by constructing and destructing items collection of 
 *             100000 elements.
 *									 </pre>
 */
public class TestSettingsTEST extends TestSettings {
	/**
	 * Empty constructor, needed to placate the compiler, since 	 * parent constructor takes no argument
	 */
	protected void TestSettingsTEST(){
		super();
	}


}