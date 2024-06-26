package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.User;

public class UserDAO {
	
	Connection connection;
	ResultSet rs;
	PreparedStatement preparedStatement;

    public UserDAO() {
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

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO User (username, password, name, address, email, cellphone) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getCellphone());
            statement.executeUpdate();
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User"; // Assuming your table name is "User"

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the result set and create User objects
            while (resultSet.next()) {
                int userId = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String cellphone = resultSet.getString("cellphone");
                
                // Create a new User object and add it to the list
                User user = new User(userId, username, password, name, address, email, cellphone);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
