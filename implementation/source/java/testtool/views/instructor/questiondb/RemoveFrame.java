import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class RemoveFrame extends JFrame {

	public RemoveFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Warning!");
		setLayout(new BorderLayout());
		
		getContentPane().add(new JLabel("Are you sure you want to remove the selected question(s)?"), BorderLayout.NORTH);
		JPanel bPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bPanel.add(new JButton("Remove"));
		bPanel.add(new JButton("Cancel"));
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
