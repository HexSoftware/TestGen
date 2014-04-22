package testtool.views.testdb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestCreationResultGUI extends JMenuBar {
   /*public static void main (String[] args){
   new TestCreationResultGUI().setVisible(true);
   }*/
   
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 400;
	private static final String TITLE = "Generation Results";
	static String[] columnNames = {"Severity",
            "Type",
            "Specifics",
            "Suggestion"
            };
 static Object[][] data = {
    	    {"Warning", "Question Type", "Not enough applicable MC questions ", "Add more MC questions, change parameters"},
    	     {"", "", "", ""},
    	     {"", "", "", ""},
    	     {"", "", "", ""},
    	     {"", "", "", ""},
    	     {"", "", "", ""},
    	  	};
   String[ ] fileItems = new String[ ] { "New", "Open", "Save", "Main Menu", "Exit" };
String[ ] editItems = new String[ ] { "Undo", "Cut", "Copy", "Paste" };
   char[ ] fileShortcuts = { 'N','O','S', 'M', 'X' };
   char[ ] editShortcuts = { 'Z','X','C','V' };

   public TestCreationResultGUI() {
	  JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu viewMenu = new JMenu("View");
JMenuItem item;   
      JFrame frame = new JFrame("Test Creation Results");
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle(TITLE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setJMenuBar(Menu());
      
      JPanel resultPanel = new JPanel();
      JTable table = new JTable(data, columnNames);
	    resultPanel.add(table);
      resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
      resultPanel.add(Box.createVerticalGlue());
      results(resultPanel);
      resultPanel.add(Box.createVerticalGlue());
      frame.add(resultPanel);
      
      viewMenu.addSeparator(  );
       // Finally, add all the menus to the menu bar.
      add(fileMenu);
      add(editMenu);
      add(viewMenu);
      frame.setVisible(true);
           
   }
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
   private static void results(JPanel panel) {
	 JPanel guiPanel = new JPanel(new GridBagLayout());
	    JButton nextButton = new JButton("Finish");
	   
	    nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    nextButton.setPreferredSize(new Dimension(100, 100));
	    nextButton.addActionListener(new testsListener());
	    
	    guiPanel.add(nextButton);
	    panel.add(guiPanel);
	 }
   static class testsListener implements ActionListener {
		
		public testsListener(){
		}
		public void actionPerformed(ActionEvent e){
			new TestDatabaseGUI(2, null);
		}
	}
}


