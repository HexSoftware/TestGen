package testtool.views.questiondb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import testtool.models.questiondb.*;
import testtool.views.commandmenu.CMBuilder;
//import testtool.views.testdb.GenerateTypeGUI;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu), RJ Almada (rjalmada@calpoly.edu)
 * @version 28apr14
 * 
 * The main view class for the Question Databank. 
 */

@SuppressWarnings("serial")
public class QuestionDBFrame {

	private QuestionDatabank qdb;
	
	final private JFrame frame;
	final private JTable table;
	final private JButton editButton, removeButton, generateButton;
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public QuestionDBFrame() {
		qdb = new QuestionDatabank();
		// Create and set up the window.
		frame = new JFrame("QuestionDB");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(CMBuilder.createMenuBar(new JMenuBar()));
		frame.setLayout(new BorderLayout());

		JPanel qdbpanel = new JPanel();
		// qdbpanel.setPreferredSize(new Dimension(800, 600));

		// Add a table
		final AbstractTableModel dataModel = new AbstractTableModel() {

			public int getColumnCount() {
				return 8;
			}

			public int getRowCount() {
				return qdb.questions.size();
			}

			public Object getValueAt(int row, int col) {
				return qdb.questions.get(row).question.get(col);
			}
		};
		//dataModel.addTableModelListener(new DatabankDataListener());
		table = new JTable(dataModel);
		table.setPreferredSize(new Dimension(700, 400));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(320);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(70);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);

		table.getColumnModel().getColumn(0).setHeaderValue(new String("Class"));
		table.getColumnModel().getColumn(1).setHeaderValue(new String("Topic"));
		table.getColumnModel().getColumn(2).setHeaderValue(new String("Type"));
		table.getColumnModel().getColumn(3).setHeaderValue(new String("Question Text"));
		table.getColumnModel().getColumn(4).setHeaderValue(new String("Difficulty"));
		table.getColumnModel().getColumn(5).setHeaderValue(new String("Time"));
		table.getColumnModel().getColumn(6).setHeaderValue(new String("Last"));
		table.getColumnModel().getColumn(7).setHeaderValue(new String("Author"));
		
		DefaultListSelectionModel selector = new DefaultListSelectionModel();
		selector.addListSelectionListener(new DatabankListener());
		table.setSelectionModel(selector);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(750, 400));
		qdbpanel.add(scrollpane);

		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		final JTextField searchField = new JTextField(20);
		searchPanel.add(searchField, BorderLayout.EAST);
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.search(searchField.getText());
			}
		});
		searchPanel.add(searchButton, BorderLayout.EAST);

		JPanel buttonPanel = new JPanel(new GridLayout());
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddQuestion(qdb, dataModel);
				//while (!qdb.qAdded);
				//qdb.qAdded = false;
				//dataModel.getTableModelListeners()[0].tableChanged(new TableModelEvent(dataModel, qdb.questions.size()));;
				//dataModel.fireTableDataChanged();
				//table.revalidate();
				//TODO: find a way to listen for add question frame to be finished.
			}
		});
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new EditQuestion(qdb, table.getSelectedRow());
				qdb.edit(null);
			}
		});
		editButton.setEnabled(false);
		buttonPanel.add(editButton);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] i = table.getSelectedRows();
				new RemoveFrame(qdb, i, dataModel);
				System.out.println("136");
				//dataModel.fireTableRowsDeleted(i[0], i[i.length-1]);
			}
		});
		removeButton.setEnabled(false);
		buttonPanel.add(removeButton);
		
		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FilterFrame(qdb);
			}
		});
		buttonPanel.add(filterButton);
		
		generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new GenerateTypeGUI();
				//TODO: Send selected questions to test generator.
				System.out.println("Generate Pressed");
			}
		});
		generateButton.setEnabled(false);
		buttonPanel.add(generateButton);

		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		frame.getContentPane().add(qdbpanel, BorderLayout.CENTER);
		// frame.setMinimumSize(new Dimension(800, 600));
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	@SuppressWarnings("unused")
	private class DatabankDataListener implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent e) {
			int frow = e.getFirstRow();
			int lrow = e.getLastRow();
			AbstractTableModel model = (AbstractTableModel)e.getSource();
			if (e.getType() == TableModelEvent.INSERT) {
				model.fireTableRowsInserted(frow, lrow);
			}
			else if (e.getType() == TableModelEvent.DELETE) {
				model.fireTableRowsDeleted(frow, lrow);
			}
			else {
				model.fireTableRowsUpdated(frow, lrow);
			}
			System.out.println("Listen!");
		}
	}
	
	
	private class DatabankListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (table.getSelectedRowCount() == 1) {
				removeButton.setEnabled(true);
				editButton.setEnabled(true);
				generateButton.setEnabled(true);
			}
			else if (table.getSelectedRowCount() > 1) {
				removeButton.setEnabled(true);
				editButton.setEnabled(false);
				generateButton.setEnabled(true);
			}
			else {
				removeButton.setEnabled(false);
				editButton.setEnabled(false);
				generateButton.setEnabled(false);
			}
			table.revalidate();
		}
	}
}