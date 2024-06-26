<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="model.User" %>
<%@ page import="dbHelpers.UserDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    String usernameAdminCorrect = "superadmin";
    // Check if the user is logged in and determine if they are an admin
    boolean isAdmin = false; // Assuming default is not admin
    HttpSession session2 = request.getSession(false);
    if (session2 != null && session2.getAttribute("username") != null) {
        String username = (String) session2.getAttribute("username");
        if (username.equals(usernameAdminCorrect)) {
            isAdmin = true;
        }
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InsEarth Insurance Company</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-brand">
                <a class="navbar-brand" href="<%= session.getAttribute("username") != null ? "dashboard.jsp" : "index.jsp" %>">
                    <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="InsEarth Insurance Logo" class="logo">
                </a>
            </div>
            <!-- Add a collapse button for mobile -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <%-- Conditionally display links based on session status and user role --%>
                    <c:choose>
                        <c:when test="${not empty sessionScope.username}">
                            <c:choose>
                                <c:when test="${isAdmin}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="AllUsersServlet">All Users</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="ProductRegistrationServlet" class="nav-link">All Products</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="DashboardServlet" class="nav-link">Dashboard</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="LogoutServlet">Logout</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="nav-item">
                                        <a class="nav-link" href="productRegistration.jsp">Register Product</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="ProductRegistrationServlet" class="nav-link">All Products</a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="ClaimSubmissionServlet" class="nav-link">Claims</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="LogoutServlet">Logout</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
    
    <!-- Main Content -->
    <div class="container mt-4">
