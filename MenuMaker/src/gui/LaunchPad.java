package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import database.DatabaseConnection;
import database.DatabaseStatement;
import database.LoadDefaultDB;

public class LaunchPad {
	
	private static final JFrame myFrame = new JFrame();
	private static Connection conn;
	private static String[] menuLength = {"", "Weekly", "Bi-weekly", "Monthly"};
	private static int intMenuLength = 0;
	private static JComboBox<String> cboMenuOptions;
	
	public static final class ActionTryToCloseWindow extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent w0) { 
			int exit = JOptionPane.showConfirmDialog(myFrame, "Do you want to exit?", 
					"Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	/**
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	public static void buildGui() throws SQLException {
		myFrame.setBounds(100, 100, 400, 300);
//		myFrame.setIconImage(imgIcon.getImage());	
		myFrame.setTitle("Menu Maker 1.0");
		myFrame.addWindowListener(new ActionTryToCloseWindow());
		myFrame.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, myFrame.getWidth(), myFrame.getHeight());
		
		if (conn == null) {
			conn = DatabaseConnection.run();
			if (conn == null) {
				JOptionPane.showMessageDialog(null, "ERROR: Could not connect to the database.");
			}
		}
		
		ResultSet rs = null;
		try {
			rs = DatabaseStatement.executeQuery(conn, "select recid from recipes");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		if (rs != null) {
			rs.close();
		} else {
			try {
				LoadDefaultDB.loadDB();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		JButton btnLoadDefaultDB = new JButton("Default DB");
		btnLoadDefaultDB.setBounds(280, 40, 100, 20);
		btnLoadDefaultDB.setVisible(true);
		panel.add(btnLoadDefaultDB);
		btnLoadDefaultDB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LoadDefaultDB.loadDB();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton btnEditDatabase = new JButton("Edit DB");
		btnEditDatabase.setBounds(280, 70, 100, 20);
		btnEditDatabase.setVisible(true);
		panel.add(btnEditDatabase);
		btnEditDatabase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBEditor.buildGui();
				myFrame.dispose();
			}
		});
		
		JLabel lblOptions = new JLabel("Please select a menu length:", SwingConstants.RIGHT);
		lblOptions.setBounds(180, 130, 200, 20);
		panel.add(lblOptions);
		JLabel lblOptions1 = new JLabel("(default chioce is 1 week)", SwingConstants.RIGHT);
		lblOptions1.setBounds(180, 150, 200, 20);
		panel.add(lblOptions1);
		cboMenuOptions = new JComboBox<String>(menuLength);
		cboMenuOptions.setBounds(280, 180, 100, 20);
		cboMenuOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				intMenuLength = cboMenuOptions.getSelectedIndex();
			}
			
		});
		
		panel.add(cboMenuOptions);
		
		JButton btnOpenMenu = new JButton("Open Menu");
		btnOpenMenu.setBounds(280, 100, 100, 20);
		btnOpenMenu.setVisible(true);		
		panel.add(btnOpenMenu);
		btnOpenMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cboMenuOptions.getSelectedIndex() < 1) {
					JOptionPane.showMessageDialog(null, "You must select a menu length.");
				} else {
					intMenuLength = cboMenuOptions.getSelectedIndex();	
					switch (intMenuLength) {
					case 0:
						try {
							WeeklyMenu.buildGui(conn);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						break;
					case 1:
						try {
							WeeklyMenu.buildGui(conn);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						break;
					case 2:
						try {
							BiWeeklyMenu.buildGui(conn);
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						break;
					case 3:
						try {
							MonthlyMenu.buildGui(conn);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						break;
					}
					myFrame.dispose();
				}
			}
		});
		
		myFrame.getContentPane().add(panel);
		myFrame.setVisible(true);
		panel.setVisible(true);
		myFrame.validate();
		myFrame.repaint();
		panel.validate();
		panel.repaint();
		
	}
}
