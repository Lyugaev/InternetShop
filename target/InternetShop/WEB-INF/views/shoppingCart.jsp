<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>

    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>

<jsp:include page="_menu.jsp" />

<h2>My Cart</h2>

<c:if test="${empty cartForm or empty cartForm.cartLines}">
    Your Shopping Cart is empty.
</c:if>

<c:if test="${not empty cartForm and not empty cartForm.cartLines}">

    <table>
        <tr>
            <td>Name</td><td>Price</td><td>Quantity</td><td></td>
        </tr>
        <c:forEach items="${cartForm.cartLines}" var="cartLineInfo">
            <tr>
                <td>${cartLineInfo.productInfo.name}</td>
                <td>${cartLineInfo.productInfo.price}</td>
                <td align="right">${cartLineInfo.quantity}</td>
                <td><a href="<c:url value='/shoppingCartRemoveProduct${cartLineInfo.productInfo.id}' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="<c:url value='/shoppingCartUpdateQuantity' />">Update quantity</a>

</c:if>


</body>
</html>