import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Color;

public class Window_Chameleon {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_Chameleon window = new Window_Chameleon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window_Chameleon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 877, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 843, 596);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox btnNewButton = new JCheckBox("New button");
		btnNewButton.setBounds(660, 10, 173, 130);
		panel.add(btnNewButton);
		
		JToggleButton btnNewButton_1 = new JToggleButton("New button");
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBounds(660, 150, 173, 130);
		panel.add(btnNewButton_1);
		
		JButton thing = new JButton("thing");
		thing.setBounds(660, 299, 173, 130);
		panel.add(thing);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(670, 439, 173, 130);
		panel.add(btnNewButton_3);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
