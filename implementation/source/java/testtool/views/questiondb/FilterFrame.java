package testtool.views.questiondb;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox; 
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

import testtool.models.questiondb.*;

/**
 * @author Neil Nordhof (nnordhof@calpoly.edu)
 * @version 20apr14
 * 
 * View class for the creating a filter dialog.
 */

@SuppressWarnings("serial")
public class FilterFrame extends JDialog {
	
	public FilterFrame(final QuestionDatabank qdb) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add a Filter");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		final JComboBox<String> filterCategory = new JComboBox<String>(new String[]{"Class", "Topic", "Type", "Difficulty", "Time", "Last Used", "Author"});
		getContentPane().add(filterCategory);
		final JTextField filterText = new JTextField(15);
		getContentPane().add(filterText);
		JButton filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				qdb.filter(new Filter(filterText.getText(), (String)filterCategory.getSelectedItem()));
				dispose();
			}
		});
		getContentPane().add(filterButton);
		
		pack();
		GraphicsConfiguration gc = getGraphicsConfiguration();  
		Rectangle bounds = gc.getBounds(); 
		Dimension size = getPreferredSize();  
		setLocation((int) ((bounds.width / 2) - (size.getWidth() / 2)),  
					(int) ((bounds.height / 2) - (size.getHeight() / 2)));  
		setVisible(true);
	}
	
}
