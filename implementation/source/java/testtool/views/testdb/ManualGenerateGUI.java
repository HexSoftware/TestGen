package testtool.views.testdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
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
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import testtool.models.testdb.ManualGeneration;
import testtool.models.testdb.TestDatabase;

public class ManualGenerateGUI {
   JButton          takeButton;
   TestDatabase     tdb;
   ManualGeneration mg;
   TableModel       dataModel = new AbstractTableModel() {
                                 private final String[][] texts = new String[][]{
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""},
         {
         "", "", "", "", "", "", "", ""}
                                                                };

                                 @Override
                                 public int getColumnCount() {
                                    return 8;
                                 }
                                 @Override
                                 public int getRowCount() {
                                    return 7;
                                 }
                                 @Override
                                 public Object getValueAt(int row, int col) {
                                    return texts[row][col];
                                 }
                              };

   public ManualGenerateGUI(TestDatabase td) {
      tdb = td;
      mg = new ManualGeneration(tdb);
      EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager
                     .getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                  | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            JMenuItem item;

            JFrame guiFrame = new JFrame();

            JPanel guiPanel = new JPanel(new GridBagLayout());

            JTable table = new JTable(dataModel);
            table.getColumnModel().getColumn(0)
                  .setHeaderValue(new String("Class"));
            table.getColumnModel().getColumn(1)
                  .setHeaderValue(new String("Topic"));
            table.getColumnModel().getColumn(2)
                  .setHeaderValue(new String("Type"));
            table.getColumnModel().getColumn(3)
                  .setHeaderValue(new String("Question Text"));
            table.getColumnModel().getColumn(4)
                  .setHeaderValue(new String("Difficulty"));
            table.getColumnModel().getColumn(5)
                  .setHeaderValue(new String("Time"));
            table.getColumnModel().getColumn(6)
                  .setHeaderValue(new String("Last Used"));
            table.getColumnModel().getColumn(7)
                  .setHeaderValue(new String("Author"));

            guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            guiFrame.setTitle("Manual Test Generation");
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

            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new removeListener());
            JButton finishButton = new JButton("Finish");
            finishButton.addActionListener(new finishListener());
            fields.add(table.getTableHeader(), BorderLayout.PAGE_START);
            fields.add(table);
            JPanel buttonPanel = new JPanel();
            BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
            buttonPanel.setLayout(boxLayout1);
            buttonPanel.add(Box.createVerticalGlue());
            buttonPanel.add(addButton);
            buttonPanel.add(editButton);
            buttonPanel.add(removeButton);

            JPanel fields3 = new JPanel(new GridBagLayout());
            fields3.add(takeButton);
            fields3.add(finishButton);
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
   String[] fileItems     = new String[]{
         "New", "Open", "Save", "Main Menu", "Exit"};
   String[] editItems     = new String[]{
         "Undo", "Cut", "Copy", "Paste"};
   char[]   fileShortcuts = {
         'N', 'O', 'S', 'M', 'X'};
   char[]   editShortcuts = {
         'Z', 'X', 'C', 'V'};

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
   class addListener implements ActionListener {

      public addListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {
         // new ChooseQuestion();
      }
   }
   class removeListener implements ActionListener {

      public removeListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {

      }
   }
   class editListener implements ActionListener {

      public editListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {

      }
   }
   class takeListener implements ActionListener {

      public takeListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {
      }
   }
   class finishListener implements ActionListener {

      public finishListener() {
      }
      @Override
      public void actionPerformed(ActionEvent e) {
         mg.generate();
         new TestCreationResultGUI(tdb);
      }
   }
}
