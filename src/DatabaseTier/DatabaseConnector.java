package DatabaseTier;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

	private Connection connection;
	static Properties configProps;

	public static void main(String[] args) {
		
		try {
			
			configProps = new Properties();
			FileInputStream in = new FileInputStream("config.properties");
			configProps.load(in);
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new DatabaseConnector();
	}

	public DatabaseConnector() {
		
		try {
			
			System.out.println("CONNECTING");
			connection = DriverManager.getConnection(new StringBuilder().append(configProps.getProperty("jdbcHost")).append(configProps.getProperty("jdbcName")).toString(), configProps.getProperty("jdbcUsername"), configProps.getProperty("jdbcPassword"));
			System.out.println("CONNECTED");

			System.out.println(checklogin("alison", "gradprog2016@07"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checklogin(String user, String password) {
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE user_id = ? AND user_pwd = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userResult = rs.getString("user_id");
				if (userResult != null && !userResult.equals("")) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean registerUser(String user, String password) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO userSecure (user_id, user_pwd) VALUES (?, ?)");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userResult = rs.getString("user_id");
				if (userResult != null && !userResult.equals("")) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
