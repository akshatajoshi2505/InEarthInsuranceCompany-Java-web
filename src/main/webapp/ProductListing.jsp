<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2>Products</h2>
    <table class="table table-striped">
        <thead>
            <tr>
            	
                <th>Product Name</th>
                <th>Serial Number</th>
                <th>Purchase Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%-- Loop through products and display --%>
            <c:forEach var="product" items="${products}">
                <tr>
                	
                	<td>${product.serialNo}</td>
                    <td>${product.productName}</td>                    
                    <td>${product.purchaseDate}</td>
                    <td>
                        <a href="claimSubmission.jsp?productid=${product.productid}" class="btn btn-primary">Add a Claim</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>
