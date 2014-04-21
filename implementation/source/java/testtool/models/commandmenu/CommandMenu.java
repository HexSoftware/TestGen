package testtool.models.commandmenu;
import java.util.Collection;

/**
 * Represents the Command Menu for the application
 */
public class CommandMenu {
	
	Collection<CommandMenuOption> menu;
	/**
	 * Adds an Option to the command menu
	 * @param o - CommandMenuOption to add
	 */
	 /*@
	   requires
	      (*
		   * o to not already be in the menu
		   *);
	   ensures
	      (*
		   * menu.contains(o);
		   *);
	@*/
	public void addOption(CommandMenuOption o) {
		System.out.println("In file.addOption");
	}
	
	/**
	 * Removes an Option from the command menu
	 * @param o - CommandMenuOption to remove
	 */
	 /*@
	   requires
	      (*
           * menu.contains(o);
		   );
	   ensures
	      (*
		   * !menu.contains(o);
		   *);
	@*/
	public void removeOption(CommandMenuOption o){
		System.out.println("In file.removeOption");
	}
	
	/**
	 * Checks to see whether a CommandMenuOption is disabled or enabled.
	 * @param o - CommandMenuOption to check state of
	 */
	public boolean checkState(CommandMenuOption o){
		System.out.println("In file.checkState");
		return true;
	}
	
}
