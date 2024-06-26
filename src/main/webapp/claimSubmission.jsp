<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ page import="dbHelpers.ProductDAO" %>
<%@ page import="model.Product" %>

<%
	//Retrieve the product ID from the URL parameter
	int productId = 0; // Initialize productId to handle potential errors
	String productIdParam = request.getParameter("productid");
	if(productIdParam != null && !productIdParam.isEmpty()) {
	    productId = Integer.parseInt(productIdParam);
	}
	
	// Use the productId to fetch the product details from the database
	ProductDAO productDAO = new ProductDAO();
	Product product = null;
	if(productId != 0) { // Only fetch product details if productId is valid
	    product = productDAO.getProductById(productId);
	}
%>
<div class="container mt-4">
    <h2>Claim Submission Form</h2>
    <form action="ClaimSubmissionServlet" method="post" class="mt-4">
        <div class="form-group">
            <label for="dateOfClaim">Date of Claim:</label>
            <input type="date" class="form-control" id="dateOfClaim" name="dateOfClaim" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="productSerialNo">Product Serial Number:</label>
            <input type="text" class="form-control" id="productSerialNo" name="productSerialNo" value="<%= (product != null) ? product.getSerialNo() : "" %>" readonly>
        </div>
        <%-- Retrieve userId from session --%>
        <% Integer userId = (Integer) session.getAttribute("userid"); %>
        <%-- Check if user is logged in --%>
        <% if (userId != null) { %>
            <%-- Add hidden input field to pass userId --%>
            <input type="hidden" name="userid" value="<%= userId %>">
        <% } %>
        <button type="submit" class="btn btn-primary">Submit Claim</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
