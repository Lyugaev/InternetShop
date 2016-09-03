<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Order Registration Form</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<jsp:include page="_menu.jsp" />


<h2>Order registration form</h2>
<h3>Enter customer info:</h3>

<form:form method="POST" modelAttribute="customer">
    <form:input type="hidden" path="id" id="id"/>
    <table>
        <tr>
            <td><label for="name">Name: </label> </td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="address">Address: </label> </td>
            <td><form:input path="address" id="address"/></td>
            <td><form:errors path="address" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="email">Email: </label> </td>
            <td><form:input path="email" id="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="phone">Phone: </label> </td>
            <td><form:input path="phone" id="phone"/></td>
            <td><form:errors path="phone" cssClass="error"/></td>
        </tr>

        <td><input type="submit" value="Register"/><input type="reset" value="Reset" /></td>
    </table>
</form:form>
</body>
</html>