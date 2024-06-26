package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.ClaimDAO;
import model.Claim;

/**
 * Servlet implementation class ClaimSubmissionServlet
 */
@WebServlet("/ClaimSubmissionServlet")
public class ClaimSubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimSubmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userid");
        ClaimDAO claimDAO = new ClaimDAO();
        try {
            // Retrieve all claims for the user
            List<Claim> claims = claimDAO.getClaimsByUserId(userId);
            // Set claims attribute in request
            request.setAttribute("claims", claims);
            // Forward to claim success page
            request.getRequestDispatcher("claimSuccess.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
            // Redirect to error page
            response.sendRedirect("error.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userid");
        String dateOfClaim = request.getParameter("dateOfClaim");
        String description = request.getParameter("description");
        String productSerialNo = request.getParameter("productSerialNo");

        Claim claim = new Claim();
        claim.setDateOfClaim(dateOfClaim);
        claim.setDescription(description);
        claim.setStatus("Pending");
        claim.setProductSerialNo(productSerialNo);
        claim.setUserid(userId);

        ClaimDAO claimDAO = new ClaimDAO();
        try {
            claimDAO.addClaim(claim);
            
            List<Claim> claims = claimDAO.getClaimsByUserId(userId);
            // Set claims attribute in request
            request.setAttribute("claims", claims);
            // Forward to claim success page
            request.getRequestDispatcher("claimSuccess.jsp").forward(request, response);
           
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception as needed
            // Redirect to error page
            response.sendRedirect("error.jsp");
        }
	}

}
