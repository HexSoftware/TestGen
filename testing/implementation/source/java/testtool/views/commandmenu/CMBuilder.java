package testtool.views.commandmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.KeyStroke;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * Tool to build a menu bar for any of the windows in the application. 
 * Usage : yourFrameHere.setJMenuBar(CMBuilder.createMenuBar(new JMenuBar()));
 * TODO: expand to adapt for different windows. 
 * TODO: add keyboard shortcuts
 **/

public class CMBuilder {

	static String[] fileItems = new String[] { 
		"New", "Open", "Close", 
		"Save", "Save As", 
		"Print", "Print Preview", 
		"Sign Out", "Exit" };
	//static char[] fileShortcuts = { 'N', 'O', 'Q', 'S', 'S', 'P', 'P', 'L', 'W'};
	
	static String[] editItems = new String[] { 
		"Undo", 
		"Cut", "Copy", "Paste", "Delete", 
		"Find...", "Find Next",  "Replace...", "Go To...",
		"Select All"};
	static String[] viewItems = new String[] {
		"Refresh",
		"Actual Size", "Zoom In", "Zoom Out", "Fullscreen",
		"Show Hints"};
	static String[] testsItems = new String[] {
		"Add", "Remove", "Edit", "Take",
		"Edit Flags"
	};
	static String[] questionsItems = new String[] {
		"Add", "Remove", "Edit", "Filter"
	};
	static String[] adminItems = new String[] {
		"Proctor",
		"Release Test", " Close Test", "Edit Test Options" 
	};
	static String[] optionsItems = new String[] {
		
	};
	
	//static char[] editShortcuts = { 'Z', 'X', 'C', 'V' };
	
	public static JMenuBar createMenuBar(JMenuBar menu) {
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu viewMenu = new JMenu("View");
		JMenu testsMenu = new JMenu("Tests");
		JMenu questionsMenu = new JMenu("Questions");
		JMenu adminMenu = new JMenu("Admin");
		JMenu optionsMenu = new JMenu("Options");

		// Assemble the File menu.
		ActionListener printListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Menu item [" + event.getActionCommand()
						+ "] was pressed.");
			}
		};
		for (int i = 0; i < fileItems.length; i++) {
			JMenuItem item = new JMenuItem(fileItems[i]/*, fileShortcuts[i]*/);
			item.addActionListener(printListener);
			fileMenu.add(item);
		}
		fileMenu.insertSeparator(3);
		fileMenu.insertSeparator(6);
		fileMenu.insertSeparator(9);

		// Assemble the Edit menu.
		for (int i = 0; i < editItems.length; i++) {
			JMenuItem item = new JMenuItem(editItems[i]);
			/*item.setAccelerator(KeyStroke
					.getKeyStroke(editShortcuts[i], Toolkit.getDefaultToolkit()
							.getMenuShortcutKeyMask(), false));*/
			item.addActionListener(printListener);
			editMenu.add(item);
		}
		editMenu.insertSeparator(1);
		editMenu.insertSeparator(6);
		editMenu.insertSeparator(11);

		// Assemble the View menu.
		for (int i = 0; i < viewItems.length; i++) {
			JMenuItem item = new JMenuItem(viewItems[i]);
			item.addActionListener(printListener);
			viewMenu.add(item);
		}
		viewMenu.insertSeparator(1);
		viewMenu.insertSeparator(6);

		// Assemble the View menu.
		for (int i = 0; i < testsItems.length; i++) {
			JMenuItem item = new JMenuItem(testsItems[i]);
			item.addActionListener(printListener);
			testsMenu.add(item);
		}
		testsMenu.insertSeparator(4);

		// Assemble the View menu.
		for (int i = 0; i < questionsItems.length; i++) {
			JMenuItem item = new JMenuItem(questionsItems[i]);
			item.addActionListener(printListener);
			questionsMenu.add(item);
		}

		// Assemble the View menu.
		for (int i = 0; i < adminItems.length; i++) {
			JMenuItem item = new JMenuItem(adminItems[i]);
			item.addActionListener(printListener);
			adminMenu.add(item);
		}
		adminMenu.insertSeparator(1);

		// Finally, add all the menus to the menu bar.
		menu.add(fileMenu);
		menu.add(editMenu);
		menu.add(viewMenu);
		menu.add(testsMenu);
		menu.add(questionsMenu);
		menu.add(adminMenu);
		menu.add(optionsMenu);

		return menu;
	}
}
