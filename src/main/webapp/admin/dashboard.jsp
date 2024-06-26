<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Claim" %>
<%@ page import="dbHelpers.ClaimDAO" %>

<div class="container mt-4">
    <h2>All Claims</h2>
    <table class="table mt-4">
        <thead>
            <tr>
                <th>Date of Claim</th>
                <th>Description</th>
                <th>User ID</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="claim" items="${claims}">
                <tr>
                    <td>${claim.dateOfClaim}</td>
                    <td>${claim.description}</td>
                    <td>${claim.userId}</td>
                    <td>${claim.status}</td>
                    <td>
                        <form action="AdminClaimActionServlet" method="post">
                            <input type="hidden" name="claimId" value="${claim.claimId}">
                            <button type="submit" name="action" value="accept" class="btn btn-success">Accept</button>
                            <button type="submit" name="action" value="reject" class="btn btn-danger">Reject</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/footer.jsp" %>
