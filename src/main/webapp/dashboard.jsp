<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2>Welcome to Your Dashboard, <%= session.getAttribute("username") %>!</h2>
    <!-- Add content specific to the dashboard -->
</div>

<%@ include file="footer.jsp" %>
