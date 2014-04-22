package testtool.views.grader;

 
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.event.*;
	 
	import java.util.*;
	 
	public class Grading extends JFrame implements ListSelectionListener {
	    private JLabel label;
	    private JSplitPane splitPane;
	    private static JSplitPane splitPane2,splitPane3, splitPane4;
	    private JList list, list2, list3;
	    JButton SAVE, FINISH, EXIT;
	    private String[] students = {"Kevin Pham","RJ Almada","Alvin Lam","Neil Nordhof","Grant Pickett", "Yuliya Levitskaya","John Doe", "John Doe"};
	    private String[] questions = {"Question 1","Question 2","Question 3","Question 4","Question 5", "Question 6", "Question 7", "Question 8", "Question 9", "Question 10", "Question 11", "Question 12", "Question 13", "Question 14", "Question 15","Question 16"};
	    private String[] answers = {"False            3/3","False            3/3","False            3/3","False            3/3","False            3/3","True             0/3"};
	    
	    public Grading() {
	    	
	        list = new JList(questions);
	    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        list.setSelectedIndex(0);
	        list.addListSelectionListener(this);
		    JScrollPane listScrollPane2 = new JScrollPane(list);
	    	
	    	list2 = new JList(students);
	    	list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        //list2.setSelectedIndex(0);
	        list2.addListSelectionListener(this);
	        JScrollPane listScrollPane = new JScrollPane(list2);
	        	        
	        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, listScrollPane, listScrollPane2);
	        splitPane.setOneTouchExpandable(true);
	        splitPane.setDividerLocation(100);
	 
	        //Provide minimum sizes for the two components in the split pane.
	        Dimension minimumSize = new Dimension(100, 50);
	        listScrollPane.setMinimumSize(minimumSize);
	        listScrollPane2.setMinimumSize(minimumSize);
	 
	        //Provide a preferred size for the split pane.
	        splitPane.setPreferredSize(new Dimension(1000, 600));
	        
	        label = new JLabel("Question 2. True or False: Strings are a standard library type in C.",
                    JLabel.CENTER);
	        
	        list3 = new JList(answers);
	    	list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        list3.setSelectedIndex(0);
	        list3.addListSelectionListener(this);
	        JScrollPane listScrollPane3 = new JScrollPane(list3);

	        //Create a split pane and put "top" (a split pane)
	        //and JLabel instance in it.
	        splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                                       label, listScrollPane3);
	        splitPane2.setDividerLocation(100);
	       
	        
	        SAVE = new JButton("Save");
	        FINISH = new JButton("Finish");
	        EXIT = new JButton("Exit");
	        JPanel buttons = new JPanel();
	        buttons.add(SAVE);
	        buttons.add(FINISH);
	        buttons.add(EXIT);
	        SAVE.addActionListener(new saveListener());
	        splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                    splitPane2, buttons);
	        splitPane3.setDividerLocation(550);
	        
	        splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                    splitPane, splitPane3);
	        splitPane4.setDividerLocation(100);
	        
	        JOptionPane.showMessageDialog(null, "Your grading progress has been saved.");
	    }
		
		static class saveListener implements ActionListener {
		
			public saveListener(){
			}
			public void actionPerformed(ActionEvent e){
				System.out.println("In grader.SaveProgress.");
			}
		}
		
		static class finishListener implements ActionListener {
		
			public finishListener(){
			}
			public void actionPerformed(ActionEvent e){
				System.out.println("In grader.finishGrading.");
			}
		}
		
		static class exitListener implements ActionListener {
		
			public exitListener(){
			}
			public void actionPerformed(ActionEvent e){
				System.out.println("Exiting");
			}
		}
	    
	    private static void createAndShowGUI() {
	    	 
	        //Create and set up the window.
	        JFrame frame = new JFrame("SplitPaneDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Grading splitPaneDemo = new Grading();
	        frame.getContentPane().add(splitPaneDemo.getSplitPane());
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	    public JSplitPane getSplitPane() {
	        return splitPane4;
	    }
	    
	       
	    public void valueChanged(ListSelectionEvent e) {
	        JList list = (JList)e.getSource();
	       
	    }
	}

