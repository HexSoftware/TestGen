package testtool.views.testdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
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

import testtool.models.questiondb.Question;
import testtool.models.testdb.AutomaticGeneration;
import testtool.models.testdb.TestDatabase;
/**
 * GeneratingGUI is used in AutomaticGeneration using an existing testdatabase
 * it has an algorithm to generate tests using questions in the question databank
 * @author Grant Pickett (gpickett@calpoly.edu)
 * @version 6/8/14
 */
public class GeneratingGUI {
   JButton	generateButton = new JButton("Generate");;

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String className = (String) cb.getSelectedItem();
	}
	/**data fields*/
	AutomaticGeneration ag = null;
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
	JLabel passlabel = new JLabel("Password:");
	JLabel additionallabel = new JLabel("Extra Information:");
	JLabel pointslabel = new JLabel("Points:");
	JLabel catLabel = new JLabel("Category:");
	JLabel catNumLabel = new JLabel("Category Number:");
	JPanel fields = new JPanel(new BorderLayout());
	JTextField pointsField = new JTextField(20);
	JTextField passField = new JTextField(20);
	JTextField diffField = new JTextField(20);
	JTextField keyField = new JTextField(20);
	JTextField type1Field = new JTextField(5);
	JTextField type2Field = new JTextField(5);
	JTextField type3Field = new JTextField(5);
	JTextField type4Field = new JTextField(5);
	JTextField type5Field = new JTextField(5);
	JTextField type6Field = new JTextField(5);
	JTextField amnt1Field = new JTextField(5);
	JTextField amnt2Field = new JTextField(5);
	JTextField amnt3Field = new JTextField(5);
	JTextField amnt4Field = new JTextField(5);
	JTextField amnt5Field = new JTextField(5);
	JTextField amnt6Field = new JTextField(5);
	JTextField startField = new JTextField(20);
	JTextField totalField = new JTextField(20);
	JTextField lastUsedField = new JTextField(20);
	JTextField additField = new JTextField(20);
	JTextField titleField = new JTextField(20);
	JTextField testCategory = new JTextField(20);
	JTextField testCategoryNum = new JTextField(20);
	JComboBox classList = null;
	JFrame guiFrame;

	public GeneratingGUI(TestDatabase td) {
		/**initialization*/
		ag = new AutomaticGeneration(td);
		tdb = td;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}
				guiFrame = new JFrame();
				JPanel guiPanel = new JPanel(new GridBagLayout());
				JPanel guiPanel2 = new JPanel(new GridBagLayout());
				String[] classStrings = { "CSC101", "CSC102", "CSC103","CPE308", "CPE309" };
				String[] authorStrings = { "G. Fisher" };
				classList = new JComboBox(classStrings);
				JComboBox authorList = new JComboBox(authorStrings);
				guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guiFrame.setTitle("Generating A Test");
				guiFrame.setSize(400, 400);
				guiFrame.setLocationRelativeTo(null);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;

				type1Field.setText("MC");type2Field.setText("TF");type3Field.setText("essay");
				type4Field.setText("short");type5Field.setText("code");type6Field.setText("image");
				amnt1Field.setText("0");amnt2Field.setText("0");amnt3Field.setText("0");
				amnt4Field.setText("0");amnt5Field.setText("0");amnt6Field.setText("0");
				guiPanel.add(classlabel);
				guiPanel.add(classList, gbc);
				guiPanel.add(authorlabel);
				guiPanel.add(authorList, gbc);
				guiPanel.add(titlelabel);
				guiPanel.add(titleField, gbc);
				guiPanel.add(timeTlabel);
				guiPanel.add(totalField, gbc);
				guiPanel.add(typelabel);
				guiPanel.add(type1Field);
				guiPanel.add(type2Field);
				guiPanel.add(type3Field);
				guiPanel.add(type4Field);
				guiPanel.add(type5Field);
				guiPanel.add(type6Field, gbc);
				guiPanel.add(amntlabel);
				guiPanel.add(amnt1Field);
				guiPanel.add(amnt2Field);
				guiPanel.add(amnt3Field);
				guiPanel.add(amnt4Field);
				guiPanel.add(amnt5Field);
				guiPanel.add(amnt6Field, gbc);
				guiPanel.add(difficultylabel);
				guiPanel.add(diffField, gbc);
				guiPanel.add(passlabel);
				guiPanel.add(passField, gbc);
				guiPanel.add(pointslabel);
				guiPanel.add(pointsField, gbc);
				guiPanel.add(lastUsedlabel);
				guiPanel.add(lastUsedField, gbc);
				guiPanel.add(keylabel);
				guiPanel.add(keyField, gbc);
				guiPanel.add(additionallabel);
				guiPanel.add(additField, gbc);
				guiPanel.add(catLabel);
				guiPanel.add(testCategory, gbc);
				guiPanel.add(catNumLabel);
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
			/** set test params as specified*/
			HashMap<String, String> params = new HashMap<String, String>();
			if (pointsField.getText() != null
					&& !pointsField.getText().equals(""))
				params.put("totalPoints", pointsField.getText());
			if (titleField.getText() != null
					&& !titleField.getText().equals(""))
				params.put("testTitle", titleField.getText());
			params.put("author", "gfisher");
			if (lastUsedField.getText() != null
					&& !lastUsedField.getText().equals(""))
				params.put("lastUsed", lastUsedField.getText());
			if (totalField.getText() != null
					&& !totalField.getText().equals(""))
				params.put("totalTime", totalField.getText());
			if (diffField.getText() != null && !diffField.getText().equals(""))
				params.put("avgDifficulty", diffField.getText());
			params.put("course", classList.getSelectedItem().toString());
			HashMap<String, String> qparams = new HashMap<String, String>();
			qparams.put(type1Field.getText(), amnt1Field.getText());
			qparams.put(type2Field.getText(), amnt2Field.getText());
			qparams.put(type3Field.getText(), amnt3Field.getText());
			qparams.put(type4Field.getText(), amnt4Field.getText());
			qparams.put(type5Field.getText(), amnt5Field.getText());
			qparams.put(type6Field.getText(), amnt6Field.getText());
			if (passField.getText() != null && !passField.getText().equals(""))
				params.put("password", passField.getText());
			if (additField.getText() != null
					&& !additField.getText().equals(""))
				params.put("notes", additField.getText());
			if (totalField.getText() != null
					&& !totalField.getText().equals(""))
				params.put("endTime", totalField.getText());
			if (testCategory.getText() != null
					&& !testCategory.getText().equals(""))
				params.put("testCategory", testCategoryNum.getText());
			if (testCategoryNum.getText() != null
					&& !testCategoryNum.getText().equals(""))
				params.put("testCategoryNumber", testCategoryNum.getText());
			new TestCreationResultGUI(tdb, ag.makeQuestionList(qparams, params));
			guiFrame.dispose();
		}
	}
}
