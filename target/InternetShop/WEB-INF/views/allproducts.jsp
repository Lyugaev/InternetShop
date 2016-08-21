<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Products</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of products</h2>
<table>
    <tr>
        <td>NAME</td><td>Added Date</td><td>Price</td><td>Description</td><td>SKU</td><td></td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.addedDate}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><a href="<c:url value='/edit-${product.sku}-product' />">${product.sku}</a></td>
            <td><a href="<c:url value='/delete-${product.sku}-product' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add new product</a>
</body>
</html>