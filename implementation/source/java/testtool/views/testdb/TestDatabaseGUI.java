/**
 * @author Grant Picket
 * @version 5/31/14
 */
package testtool.views.testdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import testtool.models.testdb.Test;
import testtool.models.testdb.TestDatabase;
import testtool.views.testdb.GenerateTypeGUI.testsListener;

public class TestDatabaseGUI {
	public Test t;
	public TestDatabase tdb;
	JButton addButton;
	JButton editButton;
	JButton removeButton;
	JButton publishButton;
	JButton takeButton;
	DefaultTableModel dataModel;
	JTable table;

	JFrame guiFrame = new JFrame();

	public TestDatabaseGUI(final int setting, TestDatabase td) {
		tdb = td;
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

				JPanel guiPanel = new JPanel(new GridBagLayout());
				String[] col = { "Test", "Class", "Topics", "Difficulty",
						"Time", "Last Used", "Points", "Author", "Questions",
						"Status" };
				dataModel = new DefaultTableModel(col,(tdb.tests.size()<10)?10: tdb.tests.size());
				table = new JTable(dataModel);
				for (int i = 0; i < tdb.tests.size(); i++) {
					table.setValueAt(
							tdb.tests.get(i).getTestParam("testTitle"), i, 0);
					table.setValueAt(tdb.tests.get(i).getTestParam("course"),
							i, 1);
					table.setValueAt(tdb.tests.get(i).getTestParam("name"), i,
							2);
					table.setValueAt(
							tdb.tests.get(i).getTestParam("avgDifficulty"), i,
							3);
					table.setValueAt(
							tdb.tests.get(i).getTestParam("totalTime"), i, 4);
					table.setValueAt(tdb.tests.get(i).getTestParam("lastUsed"),
							i, 5);
					table.setValueAt(
							tdb.tests.get(i).getTestParam("totalPoints"), i, 6);
					table.setValueAt(tdb.tests.get(i).getTestParam("author"),
							i, 7);
					table.setValueAt(
							tdb.tests.get(i).getTestParam("totalQuestions"), i,
							8);
					table.setValueAt(tdb.tests.get(i).getTestParam("state"), i,
							9);
				}
				DefaultListSelectionModel selector = new DefaultListSelectionModel();
				selector.addListSelectionListener(new DatabankListener());
				table.setSelectionModel(selector);
				guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guiFrame.setTitle("Tests");
				guiFrame.setSize(1000, 600);

				guiFrame.setLocationRelativeTo(null);

				JPanel fields = new JPanel(new BorderLayout());

				addButton = new JButton("Add");
				addButton.setSize(30, 10);
				addButton.addActionListener(new addListener());
				editButton = new JButton("Edit");
				editButton.setSize(30, 10);
				editButton.addActionListener(new editListener());

				takeButton = new JButton("Take");
				takeButton.addActionListener(new takeListener());

				publishButton = new JButton("Publish");
				publishButton.addActionListener(new publishListener());
				removeButton = new JButton("Remove");
				removeButton.addActionListener(new removeListener());

				fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
				fields.add(table);
				JPanel buttonPanel = new JPanel();
				BoxLayout boxLayout1 = new BoxLayout(buttonPanel,
						BoxLayout.Y_AXIS);
				buttonPanel.setLayout(boxLayout1);
				buttonPanel.add(Box.createVerticalGlue());
				buttonPanel.add(addButton);
				buttonPanel.add(editButton);
				buttonPanel.add(removeButton);

				JPanel fields3 = new JPanel(new GridBagLayout());
				fields3.add(takeButton);
				fields3.add(publishButton);

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				removeButton.setEnabled(false);
				takeButton.setEnabled(false);
				publishButton.setEnabled(false);
				editButton.setEnabled(false);

				guiPanel.add(fields);
				guiPanel.add(buttonPanel, gbc);
				guiPanel.add(fields3, gbc);
				guiFrame.add(guiPanel, BorderLayout.NORTH);
				// guiFrame.setJMenuBar(Menu());
				guiFrame.setVisible(true);
			}
		});

	}

	String[] fileItems = new String[] { "New", "Open", "Save", "Exit" };
	String[] editItems = new String[] { "Undo", "Cut", "Copy", "Paste" };
	char[] fileShortcuts = { 'N', 'O', 'S', 'X' };
	char[] editShortcuts = { 'Z', 'X', 'C', 'V' };

	/*
	 * public JMenuBar Menu() { JMenuBar menuBar = new JMenuBar(); JMenu
	 * fileMenu = new JMenu("File"); JMenu editMenu = new JMenu("Edit"); JMenu
	 * viewMenu = new JMenu("View");
	 * 
	 * // Assemble the File menus with mnemonics. ActionListener printListener =
	 * new ActionListener( ) { public void actionPerformed(ActionEvent event) {
	 * System.out.println("Menu item [" + event.getActionCommand( ) +
	 * "] was pressed."); } }; for (int i=0; i < fileItems.length; i++) {
	 * JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
	 * item.addActionListener(printListener); fileMenu.add(item); }
	 * 
	 * // Assemble the File menus with keyboard accelerators. for (int i=0; i <
	 * editItems.length; i++) { JMenuItem item = new JMenuItem(editItems[i]);
	 * item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i],
	 * Toolkit.getDefaultToolkit( ).getMenuShortcutKeyMask( ), false));
	 * item.addActionListener(printListener); editMenu.add(item); }
	 * 
	 * // Insert a separator in the Edit menu in Position 1 after "Undo".
	 * editMenu.insertSeparator(1);
	 * 
	 * // Assemble the submenus of the Other menu. JMenuItem item;
	 * 
	 * 
	 * // Finally, add all the menus to the menu bar. menuBar.add(fileMenu);
	 * menuBar.add(editMenu); menuBar.add(viewMenu); return menuBar; }
	 */
	class addListener implements ActionListener {

		public addListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new GenerateTypeGUI(tdb);
		}
	}

	class removeListener implements ActionListener {

		public removeListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			tdb.removeTest(table.getSelectedRows());
		}
	}

	class editListener implements ActionListener {

		public editListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			tdb.editTest(tdb.tests.get(table.getSelectedRow()));
			guiFrame.dispose();
		}
	}

	class publishListener implements ActionListener {
		public publishListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			tdb.publishTest(tdb.tests.get(table.getSelectedRow()));
			guiFrame.dispose();
		}
	}
	private class DatabankListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (table.getSelectedRowCount() == 1) {
				removeButton.setEnabled(true);
				editButton.setEnabled(true);

				publishButton.setEnabled(true);
				takeButton.setEnabled(true);
			}
			else {
				removeButton.setEnabled(false);
				editButton.setEnabled(false);
				publishButton.setEnabled(false);
				takeButton.setEnabled(false);
			}
			table.revalidate();
		}
	}

	class takeListener implements ActionListener {

		public takeListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			tdb.takeTest(tdb.tests.get(table.getSelectedRow()));
			guiFrame.dispose();
		}
	}
}
