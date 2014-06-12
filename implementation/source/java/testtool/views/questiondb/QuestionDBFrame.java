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
 * @version 12jun14
 * 
 * The main view class for the Question Databank. 
 */

@SuppressWarnings("serial")
public class QuestionDBFrame {

	final private QuestionDatabank qdb;
	
	public final JFrame frame;
	private JTable questionTable, testQTable;
	final private JButton editButton, removeButton;

	public final JButton generateButton;

	private final JButton q2tButton;

	private final JButton t2qButton;
	final private JPanel filterPanel;
	public AbstractTableModel questionModel;

	public AbstractTableModel testQModel;
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public QuestionDBFrame(ArrayList<Question> testQs) {
		qdb = new QuestionDatabank(this, true, testQs);
		// Create and set up the window.
		frame = new JFrame("QuestionDB");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(CMBuilder.createMenuBar(new JMenuBar()));
		frame.setLayout(new BorderLayout());

		JPanel qdbpanel = new JPanel(new BorderLayout());
		// qdbpanel.setPreferredSize(new Dimension(800, 600));
		
		setUpQuestionTable();
		JScrollPane questionScrollpane = new JScrollPane(questionTable);
		questionScrollpane.setPreferredSize(new Dimension(750, 200));
		qdbpanel.add(questionScrollpane, BorderLayout.NORTH);		

		setUpTestQTable();
		JScrollPane testQScrollpane = new JScrollPane(testQTable);
		testQScrollpane.setPreferredSize(new Dimension(750, 200));
		qdbpanel.add(testQScrollpane, BorderLayout.SOUTH);
		
		JPanel listSwapPanel = new JPanel(new FlowLayout());
		q2tButton = new JButton("Add to test");
		q2tButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.shiftQuestions(questionTable.getSelectedRows(), 0);
			}
		});
		q2tButton.setEnabled(false);
		t2qButton = new JButton("Remove from test");
		t2qButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.shiftQuestions(testQTable.getSelectedRows(), 1);
			}
		});
		t2qButton.setEnabled(false);
		listSwapPanel.add(q2tButton);
		listSwapPanel.add(t2qButton);
		qdbpanel.add(listSwapPanel, BorderLayout.CENTER);

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
				new AddQuestion(qdb, questionModel);
				//frame.setEnabled(false);
			}
		});
		buttonPanel.add(addButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditQuestion(qdb, questionTable.getSelectedRow(), questionModel);
			}
		});
		editButton.setEnabled(false);
		buttonPanel.add(editButton);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] i = questionTable.getSelectedRows();
				new RemoveFrame(qdb, i, questionModel);
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
				ArrayList<Question> s = new ArrayList<Question>();
				for (QuestionEntry qe : qdb.testQs)
					s.add(qe.question);
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
	
	public void setUpQuestionTable() {
		// Add a table
		questionModel = new AbstractTableModel() {

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
		questionTable = new JTable(questionModel);
		questionTable.setPreferredSize(new Dimension(700, 400));
		
		questionTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		questionTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		questionTable.getColumnModel().getColumn(2).setPreferredWidth(65);
		questionTable.getColumnModel().getColumn(3).setPreferredWidth(320);
		questionTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		questionTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		questionTable.getColumnModel().getColumn(6).setPreferredWidth(70);
		questionTable.getColumnModel().getColumn(7).setPreferredWidth(60);

		questionTable.getColumnModel().getColumn(0).setHeaderValue(new String("Course"));
		questionTable.getColumnModel().getColumn(1).setHeaderValue(new String("Topic"));
		questionTable.getColumnModel().getColumn(2).setHeaderValue(new String("Type"));
		questionTable.getColumnModel().getColumn(3).setHeaderValue(new String("Question Text"));
		questionTable.getColumnModel().getColumn(4).setHeaderValue(new String("Difficulty"));
		questionTable.getColumnModel().getColumn(5).setHeaderValue(new String("Time"));
		questionTable.getColumnModel().getColumn(6).setHeaderValue(new String("Last"));
		questionTable.getColumnModel().getColumn(7).setHeaderValue(new String("Author"));
		
		DefaultListSelectionModel selector = new DefaultListSelectionModel();
		selector.addListSelectionListener(new DatabankListener());
		questionTable.setSelectionModel(selector);
	}
	
	public void setUpTestQTable() {
		// Add a table
		testQModel = new AbstractTableModel() {

			public int getColumnCount() {
				return 8;
			}

			public int getRowCount() {
				return qdb.testQs.size();
			}

			public Object getValueAt(int row, int col) {
				return qdb.testQs.get(row).question.get(col);
			}
		};
		//dataModel.addTableModelListener(new DatabankDataListener());
		testQTable = new JTable(testQModel);
		testQTable.setPreferredSize(new Dimension(700, 400));
		
		testQTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		testQTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		testQTable.getColumnModel().getColumn(2).setPreferredWidth(65);
		testQTable.getColumnModel().getColumn(3).setPreferredWidth(320);
		testQTable.getColumnModel().getColumn(4).setPreferredWidth(60);
		testQTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		testQTable.getColumnModel().getColumn(6).setPreferredWidth(70);
		testQTable.getColumnModel().getColumn(7).setPreferredWidth(60);

		testQTable.getColumnModel().getColumn(0).setHeaderValue(new String("Course"));
		testQTable.getColumnModel().getColumn(1).setHeaderValue(new String("Topic"));
		testQTable.getColumnModel().getColumn(2).setHeaderValue(new String("Type"));
		testQTable.getColumnModel().getColumn(3).setHeaderValue(new String("Question Text"));
		testQTable.getColumnModel().getColumn(4).setHeaderValue(new String("Difficulty"));
		testQTable.getColumnModel().getColumn(5).setHeaderValue(new String("Time"));
		testQTable.getColumnModel().getColumn(6).setHeaderValue(new String("Last"));
		testQTable.getColumnModel().getColumn(7).setHeaderValue(new String("Author"));
		
		DefaultListSelectionModel selector = new DefaultListSelectionModel();
		selector.addListSelectionListener(new DatabankListener());
		testQTable.setSelectionModel(selector);
	}
	
	public void addFilterButton() {
		final FilterButton tempButton = new FilterButton(qdb.newestF);
		System.out.println("adding a filter button");
		tempButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qdb.unfilter(tempButton.filter);
				filterPanel.remove(tempButton);
				questionModel.fireTableDataChanged();
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
			if (questionTable.getSelectedRowCount() + testQTable.getSelectedRowCount() == 1){
				removeButton.setEnabled(true);
				editButton.setEnabled(true);
			}
			else if (questionTable.getSelectedRowCount() > 1 || testQTable.getSelectedRowCount() > 1) {
				removeButton.setEnabled(true);
				editButton.setEnabled(false);
			}
			else {
				removeButton.setEnabled(false);
				editButton.setEnabled(false);
			}
			
			if (testQTable.getSelectedRowCount() > 0) 
				t2qButton.setEnabled(true);
			else
				t2qButton.setEnabled(false);
			
			if (questionTable.getSelectedRowCount() > 0)
				q2tButton.setEnabled(true);
			else
				q2tButton.setEnabled(false);
			
			
			questionTable.revalidate();
			testQTable.revalidate();
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