import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;        
import javax.swing.table.*;

@SuppressWarnings("serial")
public class QuestionDBFrame extends JMenuBar {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	public QuestionDBFrame() {
        //Create and set up the window.
        JFrame frame = new JFrame("QuestionDB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        frame.setJMenuBar(this);
        frame.setLayout(new BorderLayout());
        
        JPanel qdbpanel = new JPanel();
        //qdbpanel.setPreferredSize(new Dimension(800, 600));
        
        //Add a table
        TableModel dataModel = new AbstractTableModel() {
        	private String[][] texts = new String[][]{
        			
        			{"CPE101", "Devlopment Flow", "M.C", "A ________ converts a source program into machine code.", "E", "1min", "Never", "gfisher"},
        			{"CPE101", "Types", "T/F", "Strings are a standard library type in C.", "E", "1min", "Never", "gfisher"},
        			{"CPE101", "I/O; Switch Statements", "S.A.", "Consider the following code: char input; {case '1': printf", "E", "2min", "Never", "gfisher"},
        			{"CPE101", "Structures; Stacks", "Essay", "In 2-4 paragraphs, describe the advantages and disadvantages of using", "E-M", "20min", "Never", "gfisher"},
        			{"CPE101", "UML", "Graphics", "Create a UML diagram for the following project: class Alpha{", "E-M", "10min", "Never", "gfisher"},
        			{"CPE101", "Variables", "Coding", "Write C code to accomplish the following things in the space provided: A)", "E", "5min", "Never", "gfisher"},
        			{"","","","","","","",""}
        	};
            public int getColumnCount() { return 8; }
            public int getRowCount() { return 7;}
            public Object getValueAt(int row, int col) { return texts[row][col];}
        };
        JTable table = new JTable(dataModel);
        table.setPreferredSize(new Dimension(700,400));
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
        table.getColumnModel().getColumn(6).setHeaderValue(new String("Last Used"));
        table.getColumnModel().getColumn(7).setHeaderValue(new String("Author"));
        
        
        
        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(750,400));
        qdbpanel.add(scrollpane);
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.add(new JTextField(20), BorderLayout.EAST);
        searchPanel.add(new JButton("Search"), BorderLayout.EAST);
        
        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(new JButton("Add"));
        buttonPanel.add(new JButton("Edit"));
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new RemoveFrame();
				
			}
        	
        });
        buttonPanel.add(removeButton);
        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FilterFrame();
				
			}
        	
        });
        buttonPanel.add(filterButton);
        buttonPanel.add(new JButton("Generate"));

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        frame.getContentPane().add(qdbpanel, BorderLayout.CENTER);
        //frame.setMinimumSize(new Dimension(800, 600));
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    String[ ] fileItems = new String[ ] { "New", "Open", "Save", "Exit" };
    String[ ] editItems = new String[ ] { "Undo", "Cut", "Copy", "Paste" };
    char[ ] fileShortcuts = { 'N','O','S','X' };
    char[ ] editShortcuts = { 'Z','X','C','V' };

    public void createMenu() {
 	  JMenu fileMenu = new JMenu("File");
       JMenu editMenu = new JMenu("Edit");
       JMenu viewMenu = new JMenu("View");
       JMenu subMenu = new JMenu("SubMenu");
       JMenu subMenu2 = new JMenu("SubMenu2");

       // Assemble the File menus with mnemonics.
       ActionListener printListener = new ActionListener(  ) {
          public void actionPerformed(ActionEvent event) {
             System.out.println("Menu item [" + event.getActionCommand(  ) +
                                "] was pressed.");
          }
       };
       for (int i=0; i < fileItems.length; i++) {
          JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
          item.addActionListener(printListener);
          fileMenu.add(item);
       }

       // Assemble the File menus with keyboard accelerators.
       for (int i=0; i < editItems.length; i++) {
          JMenuItem item = new JMenuItem(editItems[i]);
          item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i],
               Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
          item.addActionListener(printListener);
          editMenu.add(item);
       }

       // Insert a separator in the Edit menu in Position 1 after "Undo".
       editMenu.insertSeparator(1);

       // Assemble the submenus of the Other menu.
       JMenuItem item;
       subMenu2.add(item = new JMenuItem("Extra 2"));
       item.addActionListener(printListener);
       subMenu.add(item = new JMenuItem("Extra 1"));
       item.addActionListener(printListener);
       subMenu.add(subMenu2);

       // Assemble the Other menu itself.
       viewMenu.add(subMenu);
       viewMenu.add(item = new JCheckBoxMenuItem("Check Me"));
       item.addActionListener(printListener);
       viewMenu.addSeparator(  );
       ButtonGroup buttonGroup = new ButtonGroup(  );
       viewMenu.add(item = new JRadioButtonMenuItem("Radio 1"));
       item.addActionListener(printListener);
       buttonGroup.add(item);
       viewMenu.add(item = new JRadioButtonMenuItem("Radio 2"));
       item.addActionListener(printListener);
       buttonGroup.add(item);
       viewMenu.addSeparator(  );
       viewMenu.add(item = new JMenuItem("Potted Plant", 
                            new ImageIcon("image.gif")));
       item.addActionListener(printListener);

       // Finally, add all the menus to the menu bar.
       add(fileMenu);
       add(editMenu);
       add(viewMenu);
            
    }
}