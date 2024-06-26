<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <div class="alert alert-danger" role="alert">
        <strong>Error:</strong> <%= request.getAttribute("errorMessage") %>
    </div>
</div>

<%@ include file="footer.jsp" %>
