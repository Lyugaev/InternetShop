<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
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

<jsp:include page="_menu.jsp" />

<h2>List of products</h2>

<table>
    <tr>
        <td>Name</td><td>Receipt date</td><td>Price</td><td>Description</td><td></td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.addedDate}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td><a href="<c:url value='/add-${product.id}-to-cart' />">add to cart</a></td>
            <td><a href="<c:url value='/edit-${product.id}-product' />">edit</a></td>
            <td><a href="<c:url value='/delete-${product.id}-product' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add new product</a>
</body>
</html>