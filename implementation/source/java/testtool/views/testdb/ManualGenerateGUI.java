
package testtool.views.testdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import testtool.models.questiondb.Question;
import testtool.models.testdb.ManualGeneration;
import testtool.models.testdb.TestDatabase;
import testtool.views.questiondb.QuestionDBFrame;

/*****
 * Class ManualGenerateGUI1 is a top level view class used to manually
 * add questions to a test. Test paramaters will be set later.
 * This class references the Questiondatabank and Testdatabank model classes for information.
 * This class passes information on to the ManualGeneration model class 
 * and the next gui to construct a test.
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/8/14
 */
public class ManualGenerateGUI {
	/*-*
	 * The Data fields below are initialized by the constructor and used by 
	 * actionListener subclasses.
	 */
	
	TestDatabase tdb;
	ManualGeneration mg;
	DefaultTableModel dataModel;
	private ArrayList<Question> qList;
	JTable table;
	JFrame guiFrame;
	 /*
     * ManualGenerateGUI1 can be accessed from GenerateTypeGUI and QuestionDatabank.generate();
     * Constructor is defensive and generally one of the two parameters will come in as null.
     */
	public ManualGenerateGUI(TestDatabase td, ArrayList<Question> qs) {
		tdb = td;
		qList = qs;
		if (qs == null) {
			qList = new ArrayList<Question>();
		}
		if (td == null) {
			tdb = new TestDatabase();
		}
		mg = new ManualGeneration(tdb);
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}
				JMenuItem item;

				guiFrame = new JFrame();

				JPanel guiPanel = new JPanel(new GridBagLayout());
				String col[] = { "Course", "Topics", "Type", "Question Text",
						"Difficulty", "Time", "Last Used", "Author" };
				dataModel = new DefaultTableModel(col, 10);
				table = new JTable(dataModel);
				for (int i = 0; i < qList.size(); i++) {
					table.setValueAt(qList.get(i).course, i, 0);
					table.setValueAt(qList.get(i).topics, i, 1);
					table.setValueAt(qList.get(i).type, i, 2);
					table.setValueAt(qList.get(i).questionText, i, 3);
					table.setValueAt(qList.get(i).difficulty, i, 4);
					table.setValueAt(qList.get(i).time, i, 5);
					table.setValueAt(qList.get(i).lastUsed, i, 6);
					table.setValueAt(qList.get(i).author, i, 7);
				}

				guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guiFrame.setTitle("Manual Test Generation");
				guiFrame.setSize(700, 400);

				guiFrame.setLocationRelativeTo(null);

				JPanel fields = new JPanel(new BorderLayout());

				JButton editButton = new JButton("Edit");
				editButton.setSize(30, 10);
				editButton.addActionListener(new editListener());

				JButton finishButton = new JButton("Next");
				finishButton.addActionListener(new finishListener());
				fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
				fields.add(table);
				JPanel buttonPanel = new JPanel();
				BoxLayout boxLayout1 = new BoxLayout(buttonPanel,
						BoxLayout.Y_AXIS);
				buttonPanel.setLayout(boxLayout1);
				buttonPanel.add(Box.createVerticalGlue());
				buttonPanel.add(editButton);
				JPanel fields3 = new JPanel(new GridBagLayout());
				fields3.add(finishButton);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;

				guiPanel.add(fields);
				guiPanel.add(buttonPanel, gbc);
				guiPanel.add(fields3, gbc);

				guiFrame.add(guiPanel, BorderLayout.NORTH);
				guiFrame.setJMenuBar(Menu());
				guiFrame.setVisible(true);
			}
		});
	}

	String[] fileItems = new String[] { "New", "Open", "Save", "Main Menu",
			"Exit" };
	String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'M', 'X' };
	char[] editShortcuts = { 'Z', 'X', 'C', 'V' };

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

	class editListener implements ActionListener {

		public editListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new QuestionDBFrame(qList);
			guiFrame.dispose();
		}
	}

	class finishListener implements ActionListener {

		public finishListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new ManualGenerateGUI2(tdb, qList);
			guiFrame.dispose();
		}
	}
}
