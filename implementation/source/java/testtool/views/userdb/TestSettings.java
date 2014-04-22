package testtool.views.userdb;

/**
 * @author Yuliya Levitskaya
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import testtool.models.testdb.Test;


public class TestSettings {
	static testtool.models.userdb.TestSettings testSettings;
	public static JDialog guiFrame;
	static public Test t;
    public TestSettings() {
    	testSettings  = new testtool.models.userdb.TestSettings();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            
                String[] testTypes = { "Take Home", "Proctored", "Quiz" };
                String[] ynTypes = { "Yes", "No"};
                String[] amPm = { "AM", "PM"};
                String[] gradingTypes = { "Manual", "Automatic"};
              //Create the combo box, select item at index 4.
              //Indices start at 0, so 4 specifies the pig.
              JComboBox testTypeList = new JComboBox(testTypes);
              testTypeList.setSelectedIndex(0);
             // testTypeList.addActionListener(this);
              
              JComboBox passwordTypeList = new JComboBox(ynTypes);
              passwordTypeList.setSelectedIndex(1);
              
              JComboBox startDateTypeList = new JComboBox(amPm);
              startDateTypeList.setSelectedIndex(0);

              JComboBox endDateTypeList = new JComboBox(amPm);
              startDateTypeList.setSelectedIndex(0);
              
              JComboBox gradingTypeList = new JComboBox(gradingTypes);
              gradingTypeList.setSelectedIndex(0);
              
              
                guiFrame = new JDialog();
                guiFrame.setModal(true);
              
                JPanel guiPanel = new JPanel(new GridBagLayout());

                JLabel testTypeLabel = new JLabel("Test Type");
                
                JLabel startDateLabel = new JLabel("Start Date & Time");
                JTextField startDateField = new JTextField(15);
                startDateField.setText("January 29, 2014");
                JTextField startTimeField = new JTextField(15);
                startTimeField.setText("9:00");
                
                JLabel endDateLabel = new JLabel("End Date & Time");
                JTextField endDateField = new JTextField(15);
                endDateField.setText("January 29, 2014");
                JTextField endTimeField = new JTextField(15);
                endTimeField.setText("10:00");
                JButton publishButton = new JButton("Publish");

                JLabel passwordLabel = new JLabel("Password Required");
                JTextField passwordTextField = new JPasswordField(15);
                              
                JLabel gradingLabel = new JLabel("Grading");
                
                JLabel notesLabel = new JLabel("Notes");
                JTextField notesTextField = new JTextField(20);
                notesTextField.setText("This is Midterm 1.");
                JScrollPane scroll = new JScrollPane(notesTextField);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                
                //guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setTitle("Test Settings");
                guiFrame.setSize(700, 300);

                guiFrame.setLocationRelativeTo(null);

                JPanel fields = new JPanel(new GridBagLayout());
                
                GridBagConstraints labelGBC = new GridBagConstraints();
                labelGBC.insets = new Insets(3, 3, 3, 3);
                GridBagConstraints fieldGBC = new GridBagConstraints();
                fieldGBC.insets = new Insets(3, 3, 3, 3);
                GridBagConstraints endGBC = new GridBagConstraints();
                endGBC.insets = new Insets(3, 3, 3, 3);
                endGBC.gridwidth = GridBagConstraints.REMAINDER;
               
                fields.add(testTypeLabel, labelGBC);
                fields.add(testTypeList, endGBC);
                
                fields.add(passwordLabel, labelGBC);
                fields.add(passwordTypeList, fieldGBC);
                fields.add(passwordTextField, endGBC);
               
                fields.add(startDateLabel, labelGBC);
                fields.add(startDateField, fieldGBC);
                fields.add(startTimeField, fieldGBC);
                fields.add(startDateTypeList, endGBC);

                fields.add(endDateLabel, labelGBC);
                fields.add(endDateField, fieldGBC);
                fields.add(endTimeField, fieldGBC);
                fields.add(endDateTypeList, endGBC);
                
                fields.add(gradingLabel, labelGBC);
                fields.add(gradingTypeList, endGBC);
                
                fields.add(notesLabel, labelGBC);
                fields.add(notesTextField, endGBC);

                JPanel buttons = new JPanel(new GridBagLayout());

                GridBagConstraints publishButtonGBC = new GridBagConstraints();
                publishButtonGBC.insets = new Insets(3, 3, 3, 3);
                publishButtonGBC.gridwidth = GridBagConstraints.REMAINDER;
                buttons.add(publishButton, publishButtonGBC);
                publishButton.addActionListener(new publishListener());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                
                
                //Add Textarea in to middle panel
                //guiPanel.add(scroll);
                
                guiPanel.add(fields, gbc);
                guiPanel.add(buttons, gbc);

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
    static class publishListener implements ActionListener {
      		public publishListener(){
      			
      		}
      		public void actionPerformed(ActionEvent e){
      			//System.exit(0);
      			boolean s = testSettings.publish(t);
      			guiFrame.dispose();
      		}
      	}
}
