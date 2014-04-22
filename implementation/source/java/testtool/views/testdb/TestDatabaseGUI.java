package testtool.views.testdb;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.table.*;

import testtool.models.testdb.*;


public class TestDatabaseGUI {
	public static Test t;
	static TestDatabase tdb;
	static JButton takeButton;
	static String[] columnNames = {"Test",
            "Class",
            "Difficulty",
            "Time",
            "Last Used",
            "Points",
            "Author"};
    
   static Object[][] data = {
    	    {"Quiz1", "CPE101", "Easy", "30 min", "January 22, 2014", new Integer(40), "G. Fisher"},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	  	};
   static Object[][] data2 = {
    	    {"Quiz1", "CPE101", "Easy", "30 min", "January 22, 2014", new Integer(40), "G. Fisher"},
    	     {"Midterm1", "CPE101", "Medium", "60 min", "January 29, 2014", new Integer(120), "G. Fisher"},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	  	};
    public TestDatabaseGUI(final int setting, TestDatabase Tdb) {
        tdb = Tdb;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                       
                JFrame guiFrame = new JFrame();
              
                JPanel guiPanel = new JPanel(new GridBagLayout());

                 JTable table = null;
                if(setting == 1){
                 table = new JTable(data, columnNames);
                } 
                else{ table = new JTable(data2, columnNames);
                }
               
                             
                
                guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setTitle("Tests");
                guiFrame.setSize(700, 400);

                guiFrame.setLocationRelativeTo(null);

                JPanel fields = new JPanel(new BorderLayout());
                                
                JButton addButton = new JButton("Add");
                addButton.setSize(30, 10);
                addButton.addActionListener(new addListener());
               JButton editButton = new JButton("Edit");
                editButton.setSize(30, 10);
                editButton.addActionListener(new editListener());

                
                takeButton = new JButton("Take");
                takeButton.addActionListener(new takeListener());
                
                JButton publishButton = new JButton("Publish");
                publishButton.addActionListener(new publishListener());
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new removeListener());
              
        
                fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
                fields.add(table);
                JPanel buttonPanel = new JPanel();
                BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(boxLayout1);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
                
                JPanel fields3 = new JPanel( new GridBagLayout());
                fields3.add(takeButton);
                fields3.add(publishButton);
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;

                
                guiPanel.add(fields);
                guiPanel.add(buttonPanel, gbc);
                guiPanel.add(fields3, gbc);
               

                guiFrame.add(guiPanel, BorderLayout.NORTH);
                guiFrame.setJMenuBar(Menu());
                guiFrame.setVisible(true);
            }
        });
        
        
    }
         String[ ] fileItems = new String[ ] { "New", "Open", "Save", "Exit" };
       String[ ] editItems = new String[ ] { "Undo", "Cut", "Copy", "Paste" };
       char[ ] fileShortcuts = { 'N','O','S','X' };
       char[ ] editShortcuts = { 'Z','X','C','V' };

       public JMenuBar Menu() {
    	   JMenuBar menuBar = new JMenuBar();
    	  JMenu fileMenu = new JMenu("File");
          JMenu editMenu = new JMenu("Edit");
          JMenu viewMenu = new JMenu("View");

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
        

          // Finally, add all the menus to the menu bar.
          menuBar.add(fileMenu);
          menuBar.add(editMenu);
          menuBar.add(viewMenu);
          return menuBar;     
    }
    static class addListener implements ActionListener {
   		
   		public addListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			new GenerateTypeGUI();
			tdb.createTest();
   		}
   	}
   	static class removeListener implements ActionListener {
   		
   		public removeListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			tdb.removeTest(t);
   		}
   	}
   	static class editListener implements ActionListener {
   		
   		public editListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			tdb.editTest(t);
   		}
   	}
    static class publishListener implements ActionListener {
   		
   		public publishListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			tdb.publishTest(t);
   		}
   	}
   static class takeListener implements ActionListener {
   		
   		public takeListener(){
   		}
   		public void actionPerformed(ActionEvent e){
			tdb.takeTest(t);
   		}
   	}
}


