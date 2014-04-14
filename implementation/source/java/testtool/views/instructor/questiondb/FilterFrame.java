import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class FilterFrame extends JDialog {
	
	public FilterFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add a Filter");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		getContentPane().add(new JComboBox<Object>(new String[]{"Class", "Topic", "Type", "Difficulty", "Time", "Last Used", "Author"}));
		getContentPane().add(new JTextField(15));
		getContentPane().add(new JButton("Filter"));
		
		pack();
		GraphicsConfiguration gc = getGraphicsConfiguration();  
		Rectangle bounds = gc.getBounds(); 
		Dimension size = getPreferredSize();  
		setLocation((int) ((bounds.width / 2) - (size.getWidth() / 2)),  
					(int) ((bounds.height / 2) - (size.getHeight() / 2)));  
		setVisible(true);
	}
	
}
