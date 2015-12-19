package gui;

import java.sql.Connection;
import java.sql.SQLException;

import gui.MenuItem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DatabaseStatement;

public class BiWeeklyMenu {
	
	private static final JFrame myFrame = new JFrame();
	private static String[] dayList = {"Saturday:", "Sunday:", "Monday:", "Tuesday:", "Wednesday:", "Thursday:", "Friday:"};
	private static String[] optionList = {"", "Out of Town", "Manual Entry", "Manual Select", "By Category", "Shopping Day", "Special Event"};
	private static ResultSet rs;
	private static String[] categories;
	private static Vector<Integer> vecSelectedOptions;
	@SuppressWarnings("rawtypes")
	private static JComboBox[] cboDayOption = new JComboBox[14];
	private static JLabel[] lblDay = new JLabel[14];
	private static JLabel[] lblDailyMeal = new JLabel[14];
	private static JTextField[] txtDailyMeal = new JTextField[14];
	private static JTextField[] txtSpecialMealName = new JTextField[14];
	private static JTextField[] txtSpecialMealDesc = new JTextField[14];
	@SuppressWarnings({ "rawtypes" })
	private static JComboBox[] cboMealChoice = new JComboBox[14];
	@SuppressWarnings({ "rawtypes" })
	private static JComboBox[] cboCategoryChoice = new JComboBox[14];
	private static String[] recipeList;
	private static Connection conn;
	private static Container cont;
	private static int curDayCatSelection;
	
	private static MenuItem[] curMenuItem = new MenuItem[14];
	
	private static ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
	
	private static int counter = 0;

	public static void buildGui(Connection inConn) throws SQLException {
		conn = inConn;
		categories = loadCategories(conn);
		myFrame.setBounds(100, 100, 800, 500);
		myFrame.setTitle("Menu Maker 1.0");
		myFrame.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, myFrame.getWidth(), myFrame.getHeight());
		cont = new Container();
		cont.setBounds(0, 400, 600, 100);
		cont.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(cont, BorderLayout.SOUTH);
		
		rs = DatabaseStatement.executeQuery(conn, "SELECT recname FROM recipes");
		while (rs.next()) {
			counter = rs.getRow();
		}
		recipeList = new String[counter];
		int recIndex = 0;
		rs = DatabaseStatement.executeQuery(conn, "SELECT recname FROM recipes");
		while (rs.next()) {
			recipeList[recIndex] = rs.getString("recname");
			recIndex++;
		}
		JLabel lblDayHeader = new JLabel("Day:", JLabel.RIGHT);
		lblDayHeader.setBounds(0, 10, 120, 20);
		JLabel lblOptionHeader = new JLabel("Options:", JLabel.CENTER);
		lblOptionHeader.setBounds(140, 10, 120, 20);
		JLabel lblMealHeader = new JLabel("Meal:", JLabel.CENTER);
		lblMealHeader.setBounds(280, 10, 120, 20);
		
		for (int j = 0; j < 14; j++) {
			lblDay[j] = new JLabel(dayList[((j > 6) ? (j-7) : j)], JLabel.RIGHT);
			lblDay[j].setBounds(0, (40 + (20 * j)), 120, 20);
			panel.add(lblDay[j]);
		}
		
		for (int i = 0; i < 14; i++) {
			final int j = i;
			cboDayOption[i] = new JComboBox<String>(optionList);
			cboDayOption[i].setBounds(140, (40 + (20 * i)), 120, 20);
			panel.add(cboDayOption[i]);
			cboMealChoice[i] = new JComboBox<String>(recipeList);
			cboMealChoice[i].setBounds(280, (40 + (20 * i)), 200, 20);
			cboMealChoice[i].setVisible(false);
			panel.add(cboMealChoice[i]);
			txtDailyMeal[i] = new JTextField();
			txtDailyMeal[i].setBounds(280, (40 + (20 * i)), 200, 20);
			txtDailyMeal[i].setVisible(false);
			panel.add(txtDailyMeal[i]);
			lblDailyMeal[i] = new JLabel();
			lblDailyMeal[i].setBounds(280, (40 + (20 * i)), 200, 20);
			panel.add(lblDailyMeal[i]);
			cboCategoryChoice[i] = new JComboBox<String>(categories);
			cboCategoryChoice[i].setBounds(480, (40 + (20 * i)), 200, 20);
			cboCategoryChoice[i].setVisible(false);
			cboCategoryChoice[i].setSelectedIndex(0);
			panel.add(cboCategoryChoice[i]);
			txtSpecialMealName[i] = new JTextField();
			txtSpecialMealName[i].setBounds(280, (40 + (20 * i)), 200, 20);
			txtSpecialMealName[i].setText("* Special Event Name");
			txtSpecialMealName[i].setVisible(false);
			panel.add(txtSpecialMealName[i]);
			txtSpecialMealDesc[i] = new JTextField();
			txtSpecialMealDesc[i].setBounds(480, (40 + (20 * i)), 200, 20);
			txtSpecialMealDesc[i].setText("* Special Event Description");
			txtSpecialMealDesc[i].setVisible(false);
			panel.add(txtSpecialMealDesc[i]);
		}
			
		JButton btnGenerateMenu = new JButton("Generate");
		
		JButton btnSaveMenu = new JButton("Save");
		
		JButton btnLoadCurMenu = new JButton("Load Current");
		
		JButton btnClear = new JButton("Clear Menu");
		
		JButton btnSaveToFile = new JButton("Save to File");
		
		JButton btnClose = new JButton("Close Window");
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myFrame.dispose();
				try {
					LaunchPad.buildGui();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(lblDayHeader);
		panel.add(lblOptionHeader);
		panel.add(lblMealHeader);
		
		cont.add(btnGenerateMenu);
		cont.add(btnSaveMenu);
		cont.add(btnLoadCurMenu);
		cont.add(btnClear);
		cont.add(btnSaveToFile);
		cont.add(btnClose);
		
		myFrame.getContentPane().add(panel);
		myFrame.setVisible(true);
		panel.setVisible(true);
		cont.setVisible(true);
	}
	
	private static String[] loadCategories(Connection conn) throws SQLException {
		String[] cats;
		rs = DatabaseStatement.executeQuery(conn, "select catname from categories");
		int counter = 0;
		while (rs.next()) {
			counter = rs.getRow();
		}
		cats = new String[counter];
		int catIndex = 0;
		rs = DatabaseStatement.executeQuery(conn, "select catname from categories");
		while (rs.next()) {
			cats[catIndex] = rs.getString(1);
			catIndex++;
		}
		return cats;
	}
}
