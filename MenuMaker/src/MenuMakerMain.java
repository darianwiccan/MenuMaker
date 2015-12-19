import java.sql.SQLException;

import gui.LaunchPad;

public class MenuMakerMain {

	public static void main(String[] args) {
		try {
			LaunchPad.buildGui();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}