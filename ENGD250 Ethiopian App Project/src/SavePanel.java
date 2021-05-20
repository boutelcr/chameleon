import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SavePanel extends JPanel {
	JPanel panel = new JPanel();

	public SavePanel(P2Viewer viewer, P2Component workSpace) {
		super();
//		hi sage   :)
		
		JButton loadButton = new JButton("Load file");
		JButton saveButton = new JButton("Save file");
		JButton clearButton = new JButton("Clear file");
		JButton homeButton = new JButton("Homepage");
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(clearButton);
//		this.add(homeButton);
		
		class loadSensor implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("load here");
				String fileNameInput = JOptionPane.showInputDialog("Which file do you want to load?");
				workSpace.loadAdams(fileNameInput);
			}
		}
		
		class saveSensor implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("save here");
				String fileNameInput = JOptionPane.showInputDialog("Enter File Name:");
				workSpace.saveAdams(fileNameInput);
			}
		}
		
		class clearSensor implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clear here");
				String fileNameInput = JOptionPane.showInputDialog("Which file do you want to clear?");
				workSpace.clearSave(fileNameInput);
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
