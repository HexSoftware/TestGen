package testtool.views.userdb;

/**
 * @author: Yuliya Levitskaya
 */

import java.awt.*;
import java.awt.event.*;
import java.lang.instrument.Instrumentation;

import javax.swing.*;

public class Proctor {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final String TITLE = "Test Tool";
    public static testtool.models.userdb.Proctor proctor;
   String[ ] fileItems = new String[ ] { "New", "Open", "Save", "Exit" };
   String[ ] editItems = new String[ ] { "Undo", "Cut", "Copy", "Paste" };
   char[ ] fileShortcuts = { 'N','O','S','X' };
   char[ ] editShortcuts = { 'Z','X','C','V' };

   public Proctor() {
   	  proctor = new testtool.models.userdb.Proctor();
	 JFrame frame = new JFrame("Simple Menu Example");
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle(TITLE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setJMenuBar(Menu(  ));    
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
      buttonPanel.add(Box.createVerticalGlue());
      addButtons(buttonPanel);
      buttonPanel.add(Box.createVerticalGlue());
      frame.add(buttonPanel);
      
      frame.setVisible(true);

	}
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
   private static void addButtons(JPanel panel) {
	    Font b;
	    b=new Font("TimesRoman",Font.BOLD + Font.ITALIC,20);
	 
	    JButton testsButton = new JButton("Tests    ");
	   
	    testsButton.setPreferredSize(new Dimension(1020, 100));
	    testsButton.setFont(b);
	    testsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    panel.add(testsButton);
	    testsButton.addActionListener(new testsListener());

	    JButton gradesButton = new JButton("Grades ");
	    panel.add(gradesButton);
	    
	    gradesButton.setPreferredSize(new Dimension(1400, 100));
	    gradesButton.setFont(b);
	    gradesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    gradesButton.addActionListener(new gradesListener());
	    
	    JButton optionsButton = new JButton("Options");
	    panel.add(optionsButton);
	    optionsButton.setPreferredSize(new Dimension(1000, 100));
	    optionsButton.setFont(b);
	    optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    optionsButton.addActionListener(new optionsListener());
	 }
   static class testsListener implements ActionListener {
		
		public testsListener(){
			//this.logic = logic;
		}
		public void actionPerformed(ActionEvent e){
			proctor.listOfTests();
			new ListOfTests();
		}
	}
	static class gradesListener implements ActionListener {
		
		public gradesListener(){
			
		}
		public void actionPerformed(ActionEvent e){
			proctor.grades();
		}
	}
	static class optionsListener implements ActionListener {
		
		public optionsListener(){
			
		}
		public void actionPerformed(ActionEvent e){
			proctor.options();
		}
	}
	public static void main(String s[ ]) {
		new Proctor();
	}

}
