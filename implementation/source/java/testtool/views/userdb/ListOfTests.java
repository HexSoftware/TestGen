package testtool.views.userdb;

/**
 * author Yuliya Levitskaya
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import testtool.models.testdb.Test;



public class ListOfTests {
	static JButton CloseButton;
	Dialog d;
	static public Test t;
	static  testtool.models.userdb.ListOfTests listTests;
	static String[] columnNames = {"Test",
            "Topic",
            "Difficulty",
            "Time",
            "Last Used",
            "Points",
            "Status"};
    
   static Object[][] data = {
    	    {"Midterm 1", "CPE 101", "Easy", "60 min", "January 29, 2014", new Integer(100), "Closed"},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	     {"", "", "", " ", "", "", ""},
    	  	};


    public ListOfTests() {
    	listTests = new testtool.models.userdb.ListOfTests();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                       
                JFrame guiFrame = new JFrame();
              
                JPanel guiPanel = new JPanel(new GridBagLayout());
                 
                JTable table = new JTable(data, columnNames);
                             
                
                //guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setTitle("Tests");
                guiFrame.setSize(700, 700);

                guiFrame.setLocationRelativeTo(null);

                JPanel fields = new JPanel(new BorderLayout());
                                
                JButton gradeButton = new JButton("Grade");
                gradeButton.setSize(30, 10);
                gradeButton.addActionListener(new gradeListener());
                
                CloseButton = new JButton("Open");
                CloseButton.addActionListener(new closeListener());
                
                JButton OptionsButton = new JButton("Options");
                OptionsButton.addActionListener(new optionsListener());
                
                fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
                fields.add(table);
                //fields.add(gradeButton);
                
                JPanel fields2 = new JPanel( new GridBagLayout());
                fields2.add(gradeButton);
                
                JPanel fields3 = new JPanel( new GridBagLayout());
                fields3.add(CloseButton);
                fields3.add(OptionsButton);
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                
                
                guiPanel.add(fields);
                guiPanel.add(fields2, gbc);
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
          menuBar.add(fileMenu);
          menuBar.add(editMenu);
          menuBar.add(viewMenu);
          return menuBar;     
    }
    static class gradeListener implements ActionListener {
   		
   		public gradeListener(){
   		}
   		public void actionPerformed(ActionEvent e){
			listTests.grade(t);  			
   		}
   	}
    static class optionsListener implements ActionListener {
   		
   		public optionsListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			listTests.options(t);
   			
   			new TestSettings();
   		}
   	}
    static class closeListener implements ActionListener {
    	Dialog d;
    	int b;
   		public closeListener(){
   		}
   		public void actionPerformed(ActionEvent e){	
   			if(CloseButton.getText().equalsIgnoreCase("Open")){
   				d = new Dialog("Open");	
   				b = d.getButton();
   				
   				if(b == 1){
   					CloseButton.setText("Close");
   					data[0][6] = "Open";
   					listTests.close(t);

   				}
   			}
   			else{
   				Dialog d = new Dialog("Close");
   				int b = d.getButton();
   				if(b == 1){
   					data[0][6] = "Closed";
   					CloseButton.setText("Open");
					listTests.open(t);
   				}
   			}
   		}
   	}
}
