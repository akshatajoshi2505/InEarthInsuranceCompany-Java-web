package dbHelpers;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Claim;

public class ClaimDAO {
	
	static Connection connection;
	ResultSet rs;
	PreparedStatement preparedStatement;

    public ClaimDAO() {
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

    public void addClaim(Claim claim) throws SQLException {
        String query = "INSERT INTO Claim (dateOfClaim, description, status, productSerialNo, userid) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, claim.getDateOfClaim());
            statement.setString(2, claim.getDescription());
            statement.setString(3, claim.getStatus());
            statement.setString(4, claim.getProductSerialNo());
            statement.setInt(5, claim.getUserid());
            statement.executeUpdate();
        }
    }
    
    // Method to retrieve claims for a specific user
    public List<Claim> getClaimsByUserId(int userId) throws SQLException {
        List<Claim> claims = new ArrayList<>();
        String query = "SELECT * FROM Claim WHERE userid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Claim claim = new Claim();
                    claim.setClaimid(resultSet.getInt("claimId"));
                    claim.setDateOfClaim(resultSet.getString("dateOfClaim"));
                    claim.setDescription(resultSet.getString("description"));
                    claim.setProductSerialNo(resultSet.getString("productSerialNo"));
                    claim.setStatus(resultSet.getString("status"));
                    // Add the claim to the list
                    claims.add(claim);
                }
            }
        }
        return claims;
    }
    
    // Method to fetch all claims
    public List<Claim> getAllClaims() {
        List<Claim> claims = new ArrayList<>();
        String query = "SELECT * FROM claims";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Claim claim = new Claim();
                claim.setClaimid(resultSet.getInt("claimId"));
                claim.setDateOfClaim(resultSet.getString("dateOfClaim"));
                claim.setDescription(resultSet.getString("description"));
                claim.setUserid(resultSet.getInt("userId"));
                claim.setStatus(resultSet.getString("status"));
                claims.add(claim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }
    
    // Method to update claim status
    public void updateClaimStatus(int claimId, String status) {
        String query = "UPDATE claims SET status = ? WHERE claimid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, claimId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
