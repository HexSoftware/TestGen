package testtool.views.testdb;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.ButtonGroup;
import javax.swing.*;


public class GeneratingGUI {
	static JButton generateButton;
  public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String petName = (String)cb.getSelectedItem();
    }

    public GeneratingGUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                       
                JFrame guiFrame = new JFrame();
              
                JPanel guiPanel = new JPanel(new GridBagLayout());
                 JPanel guiPanel2 = new JPanel(new GridBagLayout());
                String[] classStrings = { "CSC101", "CSC102", "CSC103", "CPE308", "CPE309" };
         String[] authorStrings = { "G. Fisher" };

        JComboBox classList = new JComboBox(classStrings);
        classList.setSelectedIndex(3);
         JComboBox authorList = new JComboBox(authorStrings);
        authorList.setSelectedIndex(0);

                guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setTitle("Generating A Test");
                guiFrame.setSize(400, 400);
                guiFrame.setLocationRelativeTo(null);
         JLabel classlabel = new JLabel("Class:");
         JLabel authorlabel = new JLabel("Author:");
         JLabel lastUsedlabel = new JLabel("Last Used Before:");
         JLabel difficultylabel = new JLabel("Difficulty:");
         JLabel typelabel = new JLabel("Question Types:");
         JLabel amntlabel = new JLabel("Question Amount:");
         JLabel timeSlabel = new JLabel("Start Time:");
         JLabel timeTlabel = new JLabel("Total Time:");
         JLabel titlelabel = new JLabel("Test Title:");
         JLabel keylabel = new JLabel("Keywords:");
         JLabel additionallabel = new JLabel("Extra Information:");
         JLabel pointslabel = new JLabel("Points:");
         JPanel fields = new JPanel(new BorderLayout());
      JTextField pointsField = new JTextField(20);
        JTextField diffField = new JTextField(20);
         JTextField keyField = new JTextField(20);
         JTextField typeField = new JTextField(20);
         JTextField amntField = new JTextField(20);
        JTextField startField = new JTextField(20);
        JTextField totalField = new JTextField(20);
        JTextField lastUsedField = new JTextField(20);
        JTextField additField = new JTextField(20);
        JTextField titleField = new JTextField(20);
         GridBagConstraints gbc = new GridBagConstraints();

          gbc.gridwidth = GridBagConstraints.REMAINDER;
         guiPanel.add(classlabel);
         guiPanel.add(classList, gbc);
         guiPanel.add(authorlabel);
         guiPanel.add(authorList, gbc);
         guiPanel.add(titlelabel);
         guiPanel.add(titleField, gbc);
         guiPanel.add(timeSlabel);
         guiPanel.add(startField, gbc);
         guiPanel.add(timeTlabel);
         guiPanel.add(totalField, gbc);
         guiPanel.add(typelabel);
         guiPanel.add(typeField, gbc);
         guiPanel.add(amntlabel);
         guiPanel.add(amntField, gbc);
         guiPanel.add(difficultylabel);
         guiPanel.add(diffField, gbc);
         guiPanel.add(pointslabel);
         guiPanel.add(pointsField, gbc);
         guiPanel.add(lastUsedlabel);
         guiPanel.add(lastUsedField, gbc);
         guiPanel.add(keylabel);
         guiPanel.add(keyField, gbc);
         guiPanel.add(additionallabel);
         guiPanel.add(additField, gbc);
         generateButton = new JButton("Generate");
                generateButton.addActionListener(new genListener());
                
guiPanel2.add(generateButton);
                guiPanel.add(fields);

                guiFrame.add(guiPanel, BorderLayout.NORTH);
                guiFrame.add(guiPanel2);
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
    static class genListener implements ActionListener {
   		
   		public genListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			 new TestCreationResultGUI();
   			 
   		}
   	}
}
