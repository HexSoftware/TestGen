package testtool.views.questiondb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

import testtool.models.questiondb.*;
import testtool.views.commandmenu.CMBuilder;
import testtool.views.testdb.GenerateTypeGUI;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * The main view class for the Question Databank. 
 */

@SuppressWarnings("serial")
public class QuestionDBFrame {

	private QuestionDatabank qdb;

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public QuestionDBFrame() {
		qdb = new QuestionDatabank();
		// Create and set up the window.
		JFrame frame = new JFrame("QuestionDB");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(CMBuilder.createMenuBar(new JMenuBar()));
		frame.setLayout(new BorderLayout());

		JPanel qdbpanel = new JPanel();
		// qdbpanel.setPreferredSize(new Dimension(800, 600));

		// Add a table
		final TableModel dataModel = new AbstractTableModel() {

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
		final JTable table = new JTable(dataModel);
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
		table.getColumnModel().getColumn(3)
				.setHeaderValue(new String("Question Text"));
		table.getColumnModel().getColumn(4)
				.setHeaderValue(new String("Difficulty"));
		table.getColumnModel().getColumn(5).setHeaderValue(new String("Time"));
		table.getColumnModel().getColumn(6)
				.setHeaderValue(new String("Last Used"));
		table.getColumnModel().getColumn(7)
				.setHeaderValue(new String("Author"));

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
				new AddQuestion(qdb);
				table.setModel(dataModel);
			}
		});
		buttonPanel.add(addButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qdb.edit(null);
			}
		});
		buttonPanel.add(editButton);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RemoveFrame(qdb);
			}
		});
		buttonPanel.add(removeButton);
		
		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FilterFrame(qdb);
			}
		});
		buttonPanel.add(filterButton);
		
		JButton generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new GenerateTypeGUI();
			}
		});
		buttonPanel.add(generateButton);

		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		frame.getContentPane().add(qdbpanel, BorderLayout.CENTER);
		// frame.setMinimumSize(new Dimension(800, 600));
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}