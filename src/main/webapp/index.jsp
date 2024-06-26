<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2>Welcome to InsEarth Insurance Company</h2>
    <div class="row">
        <div class="col-md-6">
            <h3>Login</h3>
            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
        <div class="col-md-6">
            <h3>Don't have an account?</h3>
            <p>Register now to access our services:</p>
            <a href="registration.jsp" class="btn btn-success">Register</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
