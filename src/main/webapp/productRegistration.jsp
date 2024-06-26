<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2>Product Registration Form</h2>
    <form action="ProductRegistrationServlet" method="post" class="mt-4">
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" class="form-control" id="productName" name="productName" placeholder="Enter Product Name" required>
        </div>
        <div class="form-group">
            <label for="serialNo">Serial Number:</label>
            <input type="text" class="form-control" id="serialNo" name="serialNo" placeholder="Enter Serial Number" required>
        </div>
        <div class="form-group">
            <label for="purchaseDate">Purchase Date:</label>
            <input type="date" class="form-control" id="purchaseDate" name="purchaseDate" required>
        </div>
        <%-- Retrieve userId from session --%>
        <% Integer userId = (Integer) session.getAttribute("userid"); %>
        <%-- Check if user is logged in --%>
        <% if (userId != null) { %>
            <%-- Add hidden input field to pass userId --%>
            <input type="hidden" name="userid" value="<%= userId %>">
        <% } %>
        <button type="submit" class="btn btn-primary">Register Product</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
