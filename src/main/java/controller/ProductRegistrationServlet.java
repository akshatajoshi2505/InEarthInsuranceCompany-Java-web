package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ProductRegistrationServlet
 */
@WebServlet("/ProductRegistrationServlet")
public class ProductRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userId from session
        int userId = (int) request.getSession().getAttribute("userid");
        
        // Retrieve products for the logged-in user
        List<Product> products = null;
		try {
			products = productDAO.getProductsByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Set products attribute in request
        request.setAttribute("products", products);
        
        // Forward to ProductListing.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductListing.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters from the form
        String productName = request.getParameter("productName");
        String serialNo = request.getParameter("serialNo");
        String purchaseDate = request.getParameter("purchaseDate");
        
        // Get logged-in user ID from session
        int userId = (int) request.getSession().getAttribute("userid");
        // Create User object
        Product product = new Product(serialNo, productName, purchaseDate, userId);

        try {
            // Add product to the database
            productDAO.addProduct(product);
            
            //call get method to render the table
            doGet(request, response);
            // Redirect to a success page or dashboard
            //response.sendRedirect("ProductListing.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error, show error message or redirect to an error page
        }
	}

}
