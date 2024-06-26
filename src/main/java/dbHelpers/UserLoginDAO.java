package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserLoginDAO {
	
	private Connection connection;

    public UserLoginDAO() {
    	Properties props = new Properties();
		InputStream in;

		try {

			in = getClass().getResourceAsStream("dbConn.properties");
			props.load(in);
			in.close();
			
			String driver = props.getProperty("jdbc.driver");
			System.out.println(driver);
			
			if (driver != null) {
				Class.forName(driver);
			}

			String url = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			connection = DB.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public boolean isValidUser(String username, String password) {
    	String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if a row is found, false otherwise
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getUserId(String username) throws SQLException {
        int userId = -1; // Default value if not found
        String query = "SELECT userid FROM User WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userId = resultSet.getInt("userid");
                }
            }
        }
        return userId;
    }

    
}
