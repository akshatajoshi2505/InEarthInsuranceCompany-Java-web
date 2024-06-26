<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
	<%-- Display error message if present --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= request.getAttribute("errorMessage") %>
        </div>
    <% } %>
    <h2>User Registration</h2>
    <form action="RegistrationServlet" method="post" class="mt-4">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
        </div>
        <div class="form-group">
            <label for="cellphone">Cellphone:</label>
            <input type="tel" class="form-control" id="cellphone" name="cellphone" placeholder="Enter Cellphone" required>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</div>

<%@ include file="footer.jsp" %>
