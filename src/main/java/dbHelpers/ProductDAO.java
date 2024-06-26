package dbHelpers;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Product;

public class ProductDAO {
    
	Connection connection;
	ResultSet rs;
	PreparedStatement preparedStatement;

    public ProductDAO() {
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

    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (serialNo, productName, purchaseDate, userid) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getSerialNo());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getPurchaseDate());
            statement.setInt(4, product.getUserId());
            statement.executeUpdate();
        }
    }

    public List<Product> getProductsByUserId(int userId) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE userid = ?";
        System.out.println(query);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setProductid(resultSet.getInt("productid"));
                    product.setSerialNo(resultSet.getString("serialNo"));
                    product.setProductName(resultSet.getString("productName"));
                    product.setPurchaseDate(resultSet.getString("purchaseDate"));
                    product.setUserId(resultSet.getInt("userid"));
                    products.add(product);
                }
            }
        }
        return products;
    }
    
    public Product getProductById(int productId) throws SQLException {
        Product product = null;
        String query = "SELECT * FROM Product WHERE productid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();
                    product.setProductid(resultSet.getInt("productId"));
                    product.setSerialNo(resultSet.getString("serialNo"));
                    product.setProductName(resultSet.getString("productName"));
                    product.setPurchaseDate(resultSet.getString("purchaseDate"));
                    product.setUserId(resultSet.getInt("userId"));
                }
            }
        }
        return product;
    }

}
