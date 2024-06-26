package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		// Get username and password from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the username and password match the admin credentials
        if ("superadmin".equals(username) && "superadmin123".equals(password)) {
            // If credentials are correct, create a session attribute to indicate admin login
            request.getSession().setAttribute("adminLoggedIn", true);
            // Redirect admin to the dashboard
            response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
        } else {
            // If credentials are incorrect, set an error message and forward back to the login page
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
	}

}
