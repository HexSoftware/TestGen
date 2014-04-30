package testtool.views.grader;
import testtool.models.grader.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;



/**
 * @author Kevin Pham (kpham11@calpoly.edu)
 * @version 26apr14
 * 
 * View class for the Release Option User Interface
 */

public class ReleaseOptionsUI extends JFrame {

	private JPanel contentPane;
	ArrayList<JCheckBox> checkboxes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseOptionsUI frame = new ReleaseOptionsUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReleaseOptionsUI() {
		
		checkboxes = new ArrayList<JCheckBox>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px][]", "[23px][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Test: Midterm 1");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Student Options");
		contentPane.add(lblNewLabel_1, "cell 0 2");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Student Grade");
		contentPane.add(chckbxNewCheckBox, "flowx,cell 0 3");
		checkboxes.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Lowest Score");
		contentPane.add(chckbxNewCheckBox_3, "cell 1 3");
		checkboxes.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Overall Grade");
		contentPane.add(chckbxNewCheckBox_4, "flowx,cell 0 4");
		checkboxes.add(chckbxNewCheckBox_4);
		
		JButton btnNewButton = new JButton("Cancel");
		contentPane.add(btnNewButton, "cell 0 8,alignx left,aligny top");
		
		JButton btnNewButton_1 = new JButton("Submit");
		contentPane.add(btnNewButton_1, "cell 1 8");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Class Average");
		contentPane.add(chckbxNewCheckBox_1, "cell 0 3");
		checkboxes.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Top Score");
		contentPane.add(chckbxNewCheckBox_2, "cell 0 3");
		checkboxes.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Test Breakdown");
		contentPane.add(chckbxNewCheckBox_5, "cell 0 4");
		checkboxes.add(chckbxNewCheckBox_5);
		
		btnNewButton_1.addActionListener(new submitListener());
		btnNewButton.addActionListener(new cancelListener());
	}
	
	public class submitListener implements ActionListener {
		
		public submitListener(){
		}
		public void actionPerformed(ActionEvent e){
			ReleaseOptions options = new ReleaseOptions();
	
			for(int i = 0; i < checkboxes.size(); i++) {
				if(checkboxes.get(i).isSelected()) {
					options.addOption(checkboxes.get(i).getText());
				}
			}
			options.submitOptions();
			Window w = SwingUtilities.getWindowAncestor(contentPane);
			w.setVisible(false);
		}
	}
	
	public class cancelListener implements ActionListener {
		
		public cancelListener(){
		}
		public void actionPerformed(ActionEvent e){
			Window w = SwingUtilities.getWindowAncestor(contentPane);
			w.setVisible(false);
		}
	}

}
