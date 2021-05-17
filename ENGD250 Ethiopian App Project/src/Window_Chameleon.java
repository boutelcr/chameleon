import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Button;

// @Author - Sage Dooley, Caleb Boutell

public class Window_Chameleon {
	ImageIcon homePage = new ImageIcon("home_page_shoe.png");
	private JFrame frame;

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
		frame.setBounds(100, 100, 1131, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1096, 722);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel overPan = new JPanel();
		overPan.setBackground(Color.BLUE);
		overPan.setBounds(10,10,600,600);
//		frame.getContentPane().add(overPan);
//		overPan.setLayout(null);
		
		JButton newDesign = new JButton("New Design");
		newDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newDesign.setBounds(457, 238, 153, 84);
		panel.add(newDesign);
		
		newDesign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// DONE Auto-generated method stub
				String shoeCodeInput = JOptionPane.showInputDialog("Welcome to Chameleon! Please Enter Shoe Code:");
				frame.dispose();
				new P2Viewer();
			}
			
		});
		
		JButton pastDesign = new JButton("Past Design");
		pastDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pastDesign.setBounds(457, 380, 153, 84);
		panel.add(pastDesign);
		
		
		pastDesign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// DONE Auto-generated method stub
				//panel.add(overlay);
				String shoeCodeInput = JOptionPane.showInputDialog("Welcome back! Please Enter Shoe Code:");
				frame.dispose();
				new P2Viewer();
			}
			
		});
		
		JLabel welcome = new JLabel("Welcome to Chameleon");
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 40));
		welcome.setBounds(321, 48, 436, 57);
		panel.add(welcome);
		
		JLabel homeShoe = new JLabel("");
		Image img_1 = new ImageIcon(this.getClass().getResource("home_page_shoe.png")).getImage();
		homeShoe.setIcon(new ImageIcon(img_1));
		homeShoe.setBounds(126, 0, 859, 722);
		panel.add(homeShoe);
		
		JLabel leftSide = new JLabel("");
		Image img_left = new ImageIcon(this.getClass().getResource("Pattern for Window.png")).getImage();
		leftSide.setIcon(new ImageIcon(img_left));
		leftSide.setBounds(0, 0, 122, 722);
		panel.add(leftSide);
		
		JLabel rightSide = new JLabel("");
		Image img_right = new ImageIcon(this.getClass().getResource("Pattern for Window_Two.png")).getImage();
		rightSide.setIcon(new ImageIcon(img_right));
		rightSide.setBounds(972, 0, 122, 722);
		panel.add(rightSide);
		
		
//		JButton saveDesign = new JButton("Save");
//		saveDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		saveDesign.setBounds(20, 20, 87, 57);
//		panel.add(saveDesign);
//		
//		
//		saveDesign.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// DONE Auto-generated method stub
//				//panel.add(overlay);
//				String saveCodeInput = JOptionPane.showInputDialog("Are you sure you want to save the design?");
//				
//			}
//			
//		});
		
	}
	
	
}
