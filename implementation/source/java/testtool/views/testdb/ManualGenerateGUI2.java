package testtool.views.testdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import testtool.models.courses.Course;
import testtool.models.questiondb.Question;
import testtool.models.student.MyCourses;
import testtool.models.testdb.ManualGeneration;
import testtool.models.testdb.TestDatabase;

/**
 * The ManualGenerateGUI2 is used to generate a test when the instructor chooses the details
 * and question parameters manually. This gui is used to set parameters of the test.
 * 
 * This class references the companion model class ManualGenerate as well as 
 * returning to the test database.
 * @author Grant Picket
 * @version 6/8/14
 */

public class ManualGenerateGUI2 {
    JButton generateButton = new JButton("Generate");
	/** updates the Class name held by the JcomboBox */
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String petName = (String) cb.getSelectedItem();
	}
    /** data fields*/
	ManualGeneration mg = null;
	TestDatabase tdb;
	JLabel classlabel = new JLabel("Class:");
	JLabel authorlabel = new JLabel("Author:");
	JLabel lastUsedlabel = new JLabel("Last Used Before:");
	JLabel difficultylabel = new JLabel("Difficulty:");
	JLabel typelabel = new JLabel("Question Types:");
	JLabel amntlabel = new JLabel("Question Amount:");
	JLabel timeSlabel = new JLabel("Start Time:");
	JLabel timeTlabel = new JLabel("Total Time:");
	JLabel titlelabel = new JLabel("Test Title:");
	JLabel keylabel = new JLabel("Keywords:");
	JLabel additionallabel = new JLabel("Extra Information:");
	JLabel pointslabel = new JLabel("Points:");
	JLabel catLabel = new JLabel("Category:");
	JLabel passLabel = new JLabel("Password:");
	JLabel catNumLabel = new JLabel("Category Number:");
	JPanel fields = new JPanel(new BorderLayout());
	JTextField pointsField = new JTextField(20);
	JTextField passField = new JTextField(20);
	JTextField diffField = new JTextField(20);
	JTextField keyField = new JTextField(20);
	JTextField typeField = new JTextField(20);
	JTextField amntField = new JTextField(20);
	JTextField startField = new JTextField(20);
	JTextField totalField = new JTextField(20);
	JTextField lastUsedField = new JTextField(20);
	JTextField additField = new JTextField(20);
	JTextField titleField = new JTextField(20);
	JTextField testCategory = new JTextField(20);
	JTextField testCategoryNum = new JTextField(20);

	JFrame guiFrame = new JFrame();
	JComboBox classList = null;

	public ManualGenerateGUI2(TestDatabase td, ArrayList<Question> qs) {
		questions = (qs == null) ? new ArrayList<Question>() : qs;
		tdb = (td == null) ? tdb = new TestDatabase() : td;
		mg = new ManualGeneration(tdb);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException| UnsupportedLookAndFeelException ex) {
				}
				JPanel guiPanel = new JPanel(new GridBagLayout());
				JPanel guiPanel2 = new JPanel(new GridBagLayout());
				MyCourses c = new MyCourses();
				ArrayList<String> clst = new ArrayList<String>();
				ArrayList<Course> crst = new ArrayList<Course>();
				try {
					crst.addAll(c.getAllCourses());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				for(Course x : crst) 
					clst.add(x.getCourseName());
				Object[] classStrings = clst.toArray();
				String[] authorStrings = { "G. Fisher" };
				classList = new JComboBox(classStrings);
				JComboBox authorList = new JComboBox(authorStrings);
				guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guiFrame.setTitle("Generating A Test");
				guiFrame.setSize(400, 400);
				guiFrame.setLocationRelativeTo(null);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				guiPanel.add(classlabel);
				guiPanel.add(classList, gbc);
				guiPanel.add(authorlabel);
				guiPanel.add(authorList, gbc);
				guiPanel.add(titlelabel);
				guiPanel.add(titleField, gbc);
				guiPanel.add(keylabel);
				guiPanel.add(keyField, gbc);
				guiPanel.add(passLabel);
				guiPanel.add(passField, gbc);
				guiPanel.add(additionallabel);
				guiPanel.add(additField, gbc);
				guiPanel.add(catLabel);
				guiPanel.add(testCategory, gbc);
				guiPanel.add(catNumLabel);
				guiPanel.add(testCategoryNum, gbc);
				generateButton.addActionListener(new genListener());
				guiPanel2.add(generateButton);
				guiPanel.add(fields);
				guiFrame.add(guiPanel, BorderLayout.NORTH);
				guiFrame.add(guiPanel2);
				guiFrame.setJMenuBar(Menu());
				guiFrame.setVisible(true);
			}
		});
	}

	String[] fileItems = new String[] { "New", "Open", "Save", "Exit" };
	String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'X' };
	char[] editShortcuts = { 'Z', 'X', 'C', 'V' };
	public ArrayList<Question> questions = new ArrayList<Question>();

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

	class genListener implements ActionListener {

		public genListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			HashMap<String, String> params = new HashMap<String, String>();
			if (pointsField.getText() != null
					&& !pointsField.getText().equals(""))
				params.put("totalPoints", pointsField.getText());
			if (titleField.getText() != null
					&& !titleField.getText().equals(""))
				params.put("testTitle", titleField.getText());
			params.put("author", "gfisher");
			if (typeField.getText() != null && !typeField.getText().equals(""))
				params.put("gradeType", typeField.getText());
			if (passField.getText() != null && !passField.getText().equals(""))
				params.put("password", passField.getText());
			if (additField.getText() != null
					&& !additField.getText().equals(""))
				params.put("notes", additField.getText());
			if (additField.getText() != null
					&& !additField.getText().equals(""))
				params.put("notes", additField.getText());
			params.put("course", classList.getSelectedItem().toString());
			if (totalField.getText() != null
					&& !totalField.getText().equals(""))
				params.put("endTime", totalField.getText());
			if (typeField.getText() != null && !typeField.getText().equals(""))
				params.put("testType", typeField.getText());
			if (testCategory.getText() != null
					&& !testCategory.getText().equals(""))
				params.put("testCategory", testCategory.getText());
			if (testCategoryNum.getText() != null
					&& !testCategoryNum.getText().equals(""))
				params.put("testCategoryNum", testCategoryNum.getText());
			mg.generate(params, questions);
			new TestDatabaseGUI(2, tdb);
			guiFrame.dispose();
		}
	}
}
