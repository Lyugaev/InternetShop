<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Product Registration Form</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<jsp:include page="_menu.jsp" />


<h2>Registration Form</h2>

<form:form method="POST" modelAttribute="product">
    <form:input type="hidden" path="id" id="id"/>
    <table>
        <tr>
            <td><label for="name">Name: </label> </td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="description">Description: </label> </td>
            <td><form:input path="description" id="description"/></td>
            <td><form:errors path="description" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="addedDate">Added Date: </label> </td>
            <td><form:input path="addedDate" id="addedDate"/></td>
            <td><form:errors path="addedDate" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="price">Price: </label> </td>
            <td><form:input path="price" id="price"/></td>
            <td><form:errors path="price" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>