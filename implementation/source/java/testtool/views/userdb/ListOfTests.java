package testtool.views.userdb;

/**
 * author Yuliya Levitskaya
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import testtool.models.testdb.Test;
import testtool.models.testdb.TestDatabase;
import testtool.views.grader.GraderUI;
import testtool.views.testdb.GenerateTypeGUI;
import testtool.models.userdb.ListOfTests;
import testtool.views.userdb.TestSettings;

public class ListOfTestsGUI {
	public Test t;
	public TestDatabase tdb;
	JButton takeButton;
	DefaultTableModel dataModel;
	JTable table;
	ListOfTests lt;
	JButton statusButton;
	ListSelectionModel listSelectionModel;
	JTextArea output;
	String newline = "\n";
	
	public ListOfTestsGUI(final int setting, TestDatabase td) {
		tdb = td;
		lt = new ListOfTests();
		
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

				JFrame guiFrame = new JFrame();

				JPanel guiPanel = new JPanel(new GridBagLayout());
				String[] col = { "Test", "Class", "Topics", "Difficulty",
						"Time", "Last Used", "Points", "Author", "Questions",
						"Status" };
				dataModel = new DefaultTableModel(col, 10);
				table = new JTable(dataModel);
				listSelectionModel = table.getSelectionModel();
				listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
				table.setSelectionModel(listSelectionModel);
		   
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

				guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				guiFrame.setTitle("Tests");
				guiFrame.setSize(1000, 600);

				guiFrame.setLocationRelativeTo(null);

				JPanel fields = new JPanel(new BorderLayout());

				JButton gradeButton = new JButton("Grade");
				gradeButton.setSize(30, 10);
				gradeButton.addActionListener(new gradeListener());
				JButton optionsButton = new JButton("Options");
				optionsButton.setSize(30, 10);
				optionsButton.addActionListener(new optionsListener());

				takeButton = new JButton("Take");
				takeButton.addActionListener(new takeListener());

				statusButton = new JButton("Open");
				statusButton.addActionListener(new statusListener());
				
				fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
				fields.add(table);
				JPanel buttonPanel = new JPanel();
				BoxLayout boxLayout1 = new BoxLayout(buttonPanel,
						BoxLayout.Y_AXIS);
				buttonPanel.setLayout(boxLayout1);
				buttonPanel.add(Box.createVerticalGlue());
				buttonPanel.add(gradeButton);
				buttonPanel.add(optionsButton);

				JPanel fields3 = new JPanel(new GridBagLayout());
				fields3.add(takeButton);
				fields3.add(statusButton);

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;

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
	class gradeListener implements ActionListener {

		public gradeListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			t = tdb.tests.get(table.getSelectedRow());
			lt.grade(t);  			
			GraderUI grader = new GraderUI();
			grader.createAndShowGUI();
		}
	}

	class optionsListener implements ActionListener {

		public optionsListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			t = tdb.tests.get(table.getSelectedRow());
			new TestSettings(t, tdb);
		}
	}

	class statusListener implements ActionListener {

		public statusListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			t = tdb.tests.get(table.getSelectedRow());
			String status = t.getTestParam("state");
			if(status.equalsIgnoreCase("Open")){
   				Dialog d = new Dialog("Close");	
   				int b = d.getButton();
   				
   				if(b == 1){
   					statusButton.setText("Open");
   					lt.close(t);
   					table.setValueAt(tdb.tests.get(table.getSelectedRow()).getTestParam("state"), table.getSelectedRow(),
							9);
   				}
   			}
   			else{
   				Dialog d = new Dialog("Open");
   				int b = d.getButton();
   				if(b == 1){
   					statusButton.setText("Close");
					lt.open(t);
					table.setValueAt(tdb.tests.get(table.getSelectedRow()).getTestParam("state"), table.getSelectedRow(),
							9);
   				}
   			}
			tdb.save();
		}
	}

	class takeListener implements ActionListener {

		public takeListener() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			tdb.takeTest(t);
		}
	}
	
	class SharedListSelectionHandler implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent e) {
	    	ListSelectionModel lsm = (ListSelectionModel) e.getSource();
	    	int firstIndex = e.getFirstIndex();
	    	int lastIndex = e.getLastIndex();
	    	String strSource= e.getSource().toString();
	        int start = strSource.indexOf("{")+1,
	            stop  = strSource.length()-1;
	        int currentIndex = Integer.parseInt(strSource.substring(start, stop));
	    	if (lsm.isSelectionEmpty()) {
	    	}
	    	else {
	    		t = tdb.tests.get(currentIndex);
	    		String status = t.getTestParam("state");
				if(!status.equalsIgnoreCase("Open")){
					statusButton.setText("Open");
				}
				else
					statusButton.setText("Close");
	    		}
	    }
	}
}
