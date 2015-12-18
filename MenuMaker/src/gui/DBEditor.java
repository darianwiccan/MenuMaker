package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DBEditor {
	private static final JFrame myFrame = new JFrame();
	
	public static final class ActionTryToCloseWindow extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent w0) { 
			int exit = JOptionPane.showConfirmDialog(myFrame, "Exit Database Editor?", 
					"Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION) {
				myFrame.dispose();
				try {
					LaunchPad.buildGui();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void buildGui() {
		myFrame.setBounds(100, 100, 600, 400);
		myFrame.setTitle("Menu Maker 1.0");
		myFrame.addWindowListener(new ActionTryToCloseWindow());
		myFrame.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, myFrame.getWidth(), myFrame.getHeight());
		
		myFrame.getContentPane().add(panel);
		myFrame.setVisible(true);
		panel.setVisible(true);
	}
}
