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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Window_Chameleon {
	ImageIcon homePage = new ImageIcon("home_page_shoe.png");
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
		frame.setBounds(100, 100, 942, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);;
		panel.setBounds(10, 10, 910, 744);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton newDesign = new JButton("New Design");
		newDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newDesign.setBounds(377, 239, 153, 84);
		panel.add(newDesign);
		
		JButton pastDesign = new JButton("Past Design");
		pastDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pastDesign.setBounds(377, 381, 153, 84);
		panel.add(pastDesign);
		
		JLabel welcome = new JLabel("Welcome to Chameleon");
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		welcome.setBounds(227, 57, 436, 57);
		panel.add(welcome);
		
		JLabel homeShoe = new JLabel("");
		Image img_1 = new ImageIcon(this.getClass().getResource("home_page_shoe.png")).getImage();
		homeShoe.setIcon(new ImageIcon(img_1));
		homeShoe.setBounds(10, 0, 885, 744);
		panel.add(homeShoe);
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
