package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ClaimDAO;

/**
 * Servlet implementation class AdminClaimManagementServlet
 */
@WebServlet("/AdminClaimManagementServlet")
public class AdminClaimManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminClaimManagementServlet() {
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
		// Get the action (accept or reject) and claim ID from the form
        String action = request.getParameter("action");
        int claimId = Integer.parseInt(request.getParameter("claimId"));

        // Update the claim status based on the action
        ClaimDAO claimDAO = new ClaimDAO();
        if ("accept".equals(action)) {
            claimDAO.updateClaimStatus(claimId, "Accepted");
        } else if ("reject".equals(action)) {
            claimDAO.updateClaimStatus(claimId, "Rejected");
        }

        // Redirect back to the dashboard after processing the action
        response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
	}

}
