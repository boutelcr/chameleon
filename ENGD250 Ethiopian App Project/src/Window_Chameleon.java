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

public class Window_Chameleon { //created with the window builder plugin
	ImageIcon homePage = new ImageIcon("home_page_shoe.png");
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // default for window builder
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
	public void initialize() {
		
		// Creates the frame for Window_Chameleon
		frame = new JFrame();
		frame.setBounds(100, 100, 1131, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);;
		
		// Creates a panel for Window_Chameleon
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1096, 722);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// This creates the button to open P2Viewer
		JButton newDesign = new JButton("New Design");
		newDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newDesign.setBounds(457, 238, 153, 84);
		panel.add(newDesign);
		
		newDesign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // what to do when the "New Design" button is clicked
				// DONE Auto-generated method stub
				String shoeCodeInput = JOptionPane.showInputDialog("Welcome to Chameleon! Please Enter Shoe Code:"); //this feature is mostly representive since there are no real shoes; prompts the user to input a code for the shoes but doesn't do anything
				frame.dispose();
				P2Viewer viewer = new P2Viewer(); //creates a workspace
				viewer.getWorkSpace().loadAdams("newShoe"); //loads the blank file
			}
			
		});
		
		JButton pastDesign = new JButton("Past Design");
		pastDesign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pastDesign.setBounds(457, 380, 153, 84);
		panel.add(pastDesign);
		
		
		pastDesign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {// what to do when the "Past Design" button is clicked
				// DONE Auto-generated method stub
				String shoeCodeInput = JOptionPane.showInputDialog("Welcome back! Please Enter Shoe Code:"); //prompts the user to input a name for the file and saves that name to a variable
				frame.dispose();
				P2Viewer viewer = new P2Viewer(); //creates a workspace
				viewer.getWorkSpace().loadAdams(shoeCodeInput); //loads the given file
			}
			
		});
		
		//This creates a title of the Welcome Page
		JLabel welcome = new JLabel("Welcome to Chameleon"); //text for the title
		welcome.setForeground(Color.WHITE); //color of the font
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 40)); //formats the font
		welcome.setBounds(321, 48, 436, 57); //this is the location of the label
		panel.add(welcome);
		
		// This uses a label to input an image for the background of the welcome page
		JLabel homeShoe = new JLabel(""); // does not have text to ensure an empty box
		Image img_1 = new ImageIcon(this.getClass().getResource("home_page_shoe.png")).getImage(); //puts the image from the image path
		homeShoe.setIcon(new ImageIcon(img_1)); //displays the icon
		homeShoe.setBounds(126, 0, 859, 722);
		panel.add(homeShoe);
		
		// This uses a label to put a traditional Ethiopian pattern on the left side of the window
		JLabel leftSide = new JLabel("");
		Image img_left = new ImageIcon(this.getClass().getResource("Pattern for Window.png")).getImage();
		leftSide.setIcon(new ImageIcon(img_left));
		leftSide.setBounds(0, 0, 122, 722);
		panel.add(leftSide);
		
		// This uses a label to put a traditional Ethiopian pattern on the right side of the window
		JLabel rightSide = new JLabel("");
		Image img_right = new ImageIcon(this.getClass().getResource("Pattern for Window_Two.png")).getImage();
		rightSide.setIcon(new ImageIcon(img_right));
		rightSide.setBounds(972, 0, 122, 722);
		panel.add(rightSide);	
		}

}
