
package testtool.views.testdb;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import testtool.models.testdb.TestDatabase;
/**
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/1/14
 */
public class TestCreationResultGUI extends JMenuBar {
	/**
	 * data fields
	 */
	TestDatabase tdb;
	JFrame frame;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 400;
	private static final String TITLE = "Generation Results";
	static String[] columnNames = { "Severity", "Type", "Specifics",
			"Suggestion" };
	String[] fileItems = new String[] { "New", "Open", "Save", "Main Menu",
			"Exit" };
	String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'M', 'X' };
	char[] editShortcuts = { 'Z', 'X', 'C', 'V' };

	public TestCreationResultGUI(TestDatabase td, ArrayList<String> errors) {
		tdb = td;
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu viewMenu = new JMenu("View");
		JMenuItem item;
		frame = new JFrame("Test Creation Results");
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(Menu());
		String col[] = { "Error" };
		DefaultTableModel dataModel = new DefaultTableModel(col, 10);
		JTable table = new JTable(dataModel);
		table.setValueAt("Errors", 0, 0);
		for (int i = 1; i < errors.size(); i++) {
			table.setValueAt(errors.get(i), i, 0);
		}
		JPanel resultPanel = new JPanel();
		resultPanel.add(table);
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
		resultPanel.add(Box.createVerticalGlue());
		results(resultPanel);
		resultPanel.add(Box.createVerticalGlue());
		frame.add(resultPanel);

		viewMenu.addSeparator();
		// Finally, add all the menus to the menu bar.
		add(fileMenu);
		add(editMenu);
		add(viewMenu);
		frame.setVisible(true);

	}

	public JMenuBar Menu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu viewMenu = new JMenu("View");

		// Assemble the File menus with mnemonics.
		ActionListener printListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Menu item [" + event.getActionCommand()
						+ "] was pressed.");
			}
		};
		for (int i = 0; i < fileItems.length; i++) {
			JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
			item.addActionListener(printListener);
			fileMenu.add(item);
		}

		// Assemble the File menus with keyboard accelerators.
		for (int i = 0; i < editItems.length; i++) {
			JMenuItem item = new JMenuItem(editItems[i]);
			item.setAccelerator(KeyStroke
					.getKeyStroke(editShortcuts[i], Toolkit.getDefaultToolkit()
							.getMenuShortcutKeyMask(), false));
			item.addActionListener(printListener);
			editMenu.add(item);
		}

		// Insert a separator in the Edit menu in Position 1 after "Undo".
		editMenu.insertSeparator(1);

		// Assemble the submenus of the Other menu.
		JMenuItem item;

		// Finally, add all the menus to the menu bar.
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		return menuBar;
	}

	void results(JPanel panel) {
		JPanel guiPanel = new JPanel(new GridBagLayout());
		JButton nextButton = new JButton("Finish");

		nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		nextButton.setPreferredSize(new Dimension(100, 100));
		nextButton.addActionListener(new testsListener());

		guiPanel.add(nextButton);
		panel.add(guiPanel);
	}

	class testsListener implements ActionListener {

		public testsListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new TestDatabaseGUI(2, tdb);
			frame.dispose();
		}
	}
}
