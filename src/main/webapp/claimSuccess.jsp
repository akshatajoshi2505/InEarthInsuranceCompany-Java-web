<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="container mt-4">
    <h2>Claim History</h2>
    <table class="table mt-4">
        <thead>
            <tr>
                <th>Date of Claim</th>
                <th>Product Serial No</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the claims attribute to display claims --%>
            <c:forEach var="claim" items="${claims}">
                <tr>
                    <td>${claim.dateOfClaim}</td>
                    <td>${claim.productSerialNo}</td>
                    <td>${claim.description}</td>
                    <td>${claim.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="footer.jsp" %>
