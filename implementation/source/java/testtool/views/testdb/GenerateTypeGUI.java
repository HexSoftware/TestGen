/**
 * @author Grant Picket
 * @version 5/13/14
 */
package testtool.views.testdb;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import testtool.models.testdb.TestDatabase;

public class GenerateTypeGUI extends JMenuBar {
   private static final int    WIDTH         = 300;
   private static final int    HEIGHT        = 300;
   private static final String TITLE         = "Create New Test";

   String[]                    fileItems     = new String[]{
         "New", "Open", "Save", "Exit"       };
   String[]                    editItems     = new String[]{
         "Undo", "Cut", "Copy", "Paste"      };
   char[]                      fileShortcuts = {
         'N', 'O', 'S', 'X'                  };
   char[]                      editShortcuts = {
         'Z', 'X', 'C', 'V'                  };
   public TestDatabase         tdb;
   public GenerateTypeGUI(TestDatabase td) {
      tdb = td;
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu viewMenu = new JMenu("View");
      JFrame frame = new JFrame("Simple Menu Example");
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle(TITLE);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setJMenuBar(Menu());

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
      buttonPanel.add(Box.createVerticalGlue());
      addButtons(buttonPanel);
      buttonPanel.add(Box.createVerticalGlue());
      frame.add(buttonPanel);

      frame.setVisible(true);

      // Insert a separator in the Edit menu in Position 1 after "Undo".
      editMenu.insertSeparator(1);

      // Assemble the submenus of the Other menu.

      // Finally, add all the menus to the menu bar.
      add(fileMenu);
      add(editMenu);
      add(viewMenu);

   }
   public JMenuBar Menu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu viewMenu = new JMenu("View");

      // Assemble the File menus with mnemonics.
      ActionListener printListener = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            System.out.println("Menu item [" + event.getActionCommand() +
                  "] was pressed.");
         }
      };
      for (int i = 0; i < fileItems.length; i++) {
         JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
         item.addActionListener(printListener);
         fileMenu.add(item);
      }

      // Assemble the File menus with keyboard accelerators.
      for (int i = 0; i < editItems.length; i++) {
         JMenuItem item = new JMenuItem(editItems[i]);
         item.setAccelerator(KeyStroke.getKeyStroke(editShortcuts[i],
               Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
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
   private void addButtons(JPanel panel) {
      JPanel guiPanel = new JPanel(new GridBagLayout());
      JButton testsButton = new JButton("Manual");

      testsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      testsButton.setPreferredSize(new Dimension(2500, 100));
      testsButton.addActionListener(new testsListener());

      JButton optionsButton = new JButton("Automatic");
      optionsButton.setPreferredSize(new Dimension(2500, 100));
      optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      optionsButton.addActionListener(new optionsListener());
      guiPanel.add(testsButton);
      guiPanel.add(optionsButton);
      panel.add(guiPanel);
   }
   class testsListener implements ActionListener {

      public testsListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {
         new ManualGenerateGUI(tdb);
      }
   }
   class optionsListener implements ActionListener {

      public optionsListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {
         new GeneratingGUI(tdb);
      }
   }
}
