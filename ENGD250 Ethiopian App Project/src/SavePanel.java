import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SavePanel extends JPanel { //created to extend JPanel so it can be easily added and interacted with
	JPanel panel = new JPanel();

	//A panel of buttons for file management in the app
	
	public SavePanel(P2Viewer viewer, P2Component workSpace) {
		super();
		
		JButton loadButton = new JButton("Load file");
		JButton saveButton = new JButton("Save file");
		JButton clearButton = new JButton("Clear file");
		JButton homeButton = new JButton("Homepage"); //a defunct button in hibernation
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(clearButton);
//		this.add(homeButton);
		
		class loadSensor implements ActionListener { // what to do when pressed
			public void actionPerformed(ActionEvent e) {
				System.out.println("load here");
				String fileNameInput = JOptionPane.showInputDialog("Which file do you want to load?"); //prompts the user to input a name for the file and saves that name to a variable
				workSpace.loadAdams(fileNameInput); //loads file
			}
		}
		
		class saveSensor implements ActionListener { // what to do when pressed
			public void actionPerformed(ActionEvent e) {
				System.out.println("save here");
				String fileNameInput = JOptionPane.showInputDialog("Enter File Name:"); //prompts the user to input a name for the file and saves that name to a variable
				workSpace.saveAdams(fileNameInput); //saves file
			}
		}
		
		class clearSensor implements ActionListener { // what to do when pressed
			public void actionPerformed(ActionEvent e) {
				System.out.println("clear here");
				String fileNameInput = JOptionPane.showInputDialog("Which file do you want to clear?"); //prompts the user to input a name for the file and saves that name to a variable
				workSpace.clearSave(fileNameInput); //clears file
			}
		}
		
//		class homeSensor implements ActionListener {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("home here");
//				viewer.getFrame.dispose();
//				Window_Chameleon.returnHome();
//			}
//		}
		
		loadButton.addActionListener(new loadSensor());
		saveButton.addActionListener(new saveSensor());
		clearButton.addActionListener(new clearSensor());
//		homeButton.addActionListener(new homeSensor());
	}
	
	
}
