package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UserLoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private UserLoginDAO userLoginDAO;

    // Initialize the DAO in the servlet's init() method
    public void init() throws ServletException {
        userLoginDAO = new UserLoginDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username and password using the DAO method
        if (userLoginDAO.isValidUser(username, password)) {
        	
        	// Retrieve userId from the DAO method
            int userId = 0;
			try {
				userId = userLoginDAO.getUserId(username);
				 // Create session for the user
	            HttpSession session = request.getSession();
	            session.setAttribute("userid", userId);
	            session.setAttribute("username", username);
	            if ("superadmin".equals(username) && "superadmin123".equals(password)) {
	                // If credentials are correct, create a session attribute to indicate admin login
	                request.getSession().setAttribute("adminLoggedIn", true);
	                // Redirect admin to the dashboard
	                response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
	            } else {
	            	// Redirect to dashboard or main page
		            response.sendRedirect("dashboard.jsp");
	            }
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        } else {
        	// Set error message attribute and forward to error.jsp
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
	}

}
