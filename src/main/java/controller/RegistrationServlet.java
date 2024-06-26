package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UserDAO;
import model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;

    public void init() throws ServletException {
        userDAO = new UserDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String cellphone = request.getParameter("cellphone");

        // Server-side validation
        if (username.isEmpty() || password.isEmpty() || name.isEmpty() || address.isEmpty() || email.isEmpty() || cellphone.isEmpty()) {
            // Set error message attribute and forward to registration.jsp
            request.setAttribute("errorMessage", "All fields are required");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Create User object
        User user = new User(username, password, name, address, email, cellphone);

        // Add user to database
        try {
            userDAO.addUser(user);
            // Registration successful, redirect to login page or any other page
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Set error message attribute and forward to registration.jsp
            request.setAttribute("errorMessage", "Error occurred while registering user");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }
	}

}
