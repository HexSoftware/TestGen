package testtool.views.questiondb;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import testtool.models.questiondb.QuestionDatabank;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * View class for the remove confirmation dialog.
 */

@SuppressWarnings("serial")
public class RemoveFrame extends JFrame {

	public RemoveFrame(final QuestionDatabank qdb) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Warning!");
		setLayout(new BorderLayout());
		
		getContentPane().add(new JLabel("Are you sure you want to remove the selected question(s)?"), BorderLayout.NORTH);
		JPanel bPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.remove();
				dispose();
			}
		});
		bPanel.add(removeButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bPanel.add(cancelButton);
		getContentPane().add(bPanel, BorderLayout.SOUTH);
		

		pack();
		GraphicsConfiguration gc = getGraphicsConfiguration();  
		Rectangle bounds = gc.getBounds(); 
		Dimension size = getPreferredSize();  
		setLocation((int) ((bounds.width / 2) - (size.getWidth() / 2)),  
					(int) ((bounds.height / 2) - (size.getHeight() / 2)));  
		setVisible(true);
	}
}
