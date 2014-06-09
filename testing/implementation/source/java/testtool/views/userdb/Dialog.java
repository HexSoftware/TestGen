package testtool.views.userdb;

/**
 * @author Yuliya Levitskaya
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Dialog {
	static JButton noButton, yesButton;
	static JDialog guiFrame;
	static int button = 3;
    public Dialog(final String t) {
       
           
                       
                guiFrame = new JDialog();
                guiFrame.setModal(true);
                JPanel guiPanel = new JPanel(new GridBagLayout());
         
                //guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setTitle("");
                guiFrame.setSize(300, 200);

                guiFrame.setLocationRelativeTo(null);

                JPanel fields = new JPanel(new GridBagLayout());
                                
                JLabel text = new JLabel();
                text.setText("Are you sure you want to " + t + "?");
                yesButton = new JButton("Yes");
                yesButton.setSize(30, 10);
                yesButton.addActionListener(new yesListener());
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                
                noButton = new JButton("No");
                noButton.addActionListener(new noListener());
                fields.add(text, gbc);
                fields.add(yesButton, gbc);
                fields.add(noButton);
          
                guiPanel.add(fields);               

                guiFrame.add(guiPanel, BorderLayout.NORTH);
                guiFrame.setVisible(true);
            
    }
    public int getButton(){
    	return button;
    }
     class yesListener implements ActionListener {
   		
   		public yesListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			button = 1;
   			guiFrame.dispose();
   		}
   	}
     class noListener implements ActionListener {
   		
   		public noListener(){
   		}
   		public void actionPerformed(ActionEvent e){
   			button = 0;
   			guiFrame.dispose();	
   		}
   	}
}
