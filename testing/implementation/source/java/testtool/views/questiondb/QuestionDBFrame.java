package testtool.views.questiondb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import testtool.models.questiondb.Filter;
import testtool.models.questiondb.Question;
import testtool.models.questiondb.QuestionDatabank;
import testtool.models.questiondb.QuestionEntry;
import testtool.views.commandmenu.CMBuilder;
import testtool.views.testdb.ManualGenerateGUI;
//import testtool.views.testdb.GenerateTypeGUI;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu), RJ Almada (rjalmada@calpoly.edu)
 * @version 1jun14
 * 
 * The main view class for the Question Databank. 
 */

@SuppressWarnings("serial")
public class QuestionDBFrame {

	final private QuestionDatabank qdb;
	
	final private JFrame frame;
	final private JTable table;
	final private JButton editButton, removeButton, generateButton;
	final private JPanel filterPanel;
	final private AbstractTableModel dataModel;
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
		dataModel = new AbstractTableModel() {

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

		table.getColumnModel().getColumn(0).setHeaderValue(new String("Course"));
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

		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		final JTextField searchField = new JTextField(20);
		searchPanel.add(searchField);
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.search(searchField.getText());
			}
		});
		searchPanel.add(searchButton);
		
		filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		filterPanel.setMaximumSize(new Dimension(400,30));
		
		topPanel.add(filterPanel, BorderLayout.WEST);
		topPanel.add(searchPanel, BorderLayout.EAST);

		JPanel buttonPanel = new JPanel(new GridLayout());
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddQuestion(qdb, dataModel);
				//frame.setEnabled(false);
			}
		});
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditQuestion(qdb, table.getSelectedRow(), dataModel);
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
			}
		});
		removeButton.setEnabled(false);
		buttonPanel.add(removeButton);
		
		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FilterFrame(qdb);
			}
		});
		buttonPanel.add(filterButton);
		
		generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new GenerateTypeGUI();
				System.out.println("Generate Pressed");
				ArrayList<Question> s = parseSelected();
				new ManualGenerateGUI(null, s);
				try {
					qdb.writeDatabase();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		generateButton.setEnabled(false);
		buttonPanel.add(generateButton);

		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(qdbpanel, BorderLayout.CENTER);
		
		frame.addWindowListener(new qdbWindowListener());
		// frame.setMinimumSize(new Dimension(800, 600));
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public QuestionDBFrame(ArrayList<Question> q) {
		qdb = new QuestionDatabank();
		// Create and set up the window.
		frame = new JFrame("QuestionDB");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(CMBuilder.createMenuBar(new JMenuBar()));
		frame.setLayout(new BorderLayout());

		JPanel qdbpanel = new JPanel();
		// qdbpanel.setPreferredSize(new Dimension(800, 600));

		// Add a table
		dataModel = new AbstractTableModel() {

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

		table.getColumnModel().getColumn(0).setHeaderValue(new String("Course"));
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

		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		final JTextField searchField = new JTextField(20);
		searchPanel.add(searchField);
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.search(searchField.getText());
			}
		});
		searchPanel.add(searchButton);
		
		filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		filterPanel.setMaximumSize(new Dimension(400,30));
		
		topPanel.add(filterPanel, BorderLayout.WEST);
		topPanel.add(searchPanel, BorderLayout.EAST);

		JPanel buttonPanel = new JPanel(new GridLayout());
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddQuestion(qdb, dataModel);
				//frame.setEnabled(false);
			}
		});
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditQuestion(qdb, table.getSelectedRow(), dataModel);
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
			}
		});
		removeButton.setEnabled(false);
		buttonPanel.add(removeButton);
		
		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FilterFrame(qdb);
			}
		});
		buttonPanel.add(filterButton);
		
		generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new GenerateTypeGUI();
				//TODO: Send selected questions to test generator.
				System.out.println("Generate Pressed");
				ArrayList<Question> s = parseSelected();
				new ManualGenerateGUI(null, s);
				try {
					qdb.writeDatabase();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		generateButton.setEnabled(false);
		buttonPanel.add(generateButton);

		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(qdbpanel, BorderLayout.CENTER);
		
		frame.addWindowListener(new qdbWindowListener());
		
		setSelectedTestQuestions(qdb.questions, q);

		// frame.setMinimumSize(new Dimension(800, 600));
		// Display the window.		
		frame.pack();
		frame.setVisible(true);
	}
	
	public ArrayList<Question> parseSelected() {
		ArrayList<Question> s = new ArrayList<Question>();
		int[] i = table.getSelectedRows();
		
		for (int j = 0; j < i.length; j++)
			s.add(qdb.questions.get(i[j]).question);
		
		return s;
	}
	
	private void setSelectedTestQuestions(ArrayList<QuestionEntry> dbq, ArrayList<Question> tq) {
		ArrayList<String> dbquestions = new ArrayList<String>();
		int ndx;
		
		for(int i = 0; i < dbq.size(); i++) {
			dbquestions.add(dbq.get(i).question.toString());
		}
		
		for(int i = 0; i < tq.size(); i++) {
			ndx = dbquestions.indexOf(tq.get(i).toString());
			table.addRowSelectionInterval(ndx, ndx);
		}
	}
	
	
	
	public void addFilterButton() {
		final FilterButton tempButton = new FilterButton(qdb.newestF);
		System.out.println("adding a filter button");
		tempButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qdb.unfilter(tempButton.filter);
				filterPanel.remove(tempButton);
				dataModel.fireTableDataChanged();
				frame.pack();
			}
		});
		filterPanel.add(tempButton);
		frame.pack();
	}
	
	private class FilterButton extends JButton {
		public Filter filter;
		
		public FilterButton(Filter fil) {
			super(fil.category.title + ": " + fil.keyword);
			filter = fil;			
		}
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
	
	private class qdbWindowListener implements WindowListener, WindowFocusListener {

		@Override
		public void windowGainedFocus(WindowEvent arg0) {
			System.out.println("Focus Gained");
			frame.setEnabled(true);
		}

		@Override
		public void windowLostFocus(WindowEvent arg0) {
			System.out.println("Focus Lost");
			frame.setEnabled(false);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			try {
				System.out.println("Saving QDB...");
				qdb.writeDatabase();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}