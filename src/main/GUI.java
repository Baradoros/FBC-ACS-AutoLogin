package main;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	public GUI() {
		setTitle("FBC ACS Auto-Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(300, 300));
		add(new JLabel("This is a placeholder", SwingConstants.CENTER));

		setVisible(true);
		
	}
	
	public File showExplorerWindow() {
		JFileChooser browser = new JFileChooser();
		if (browser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			return browser.getSelectedFile();
		} else {
			return null;
		}
	}
	
	public void showErrorMessage(ErrorCode e) {
		
	}
}
