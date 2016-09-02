<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Form</title>

    <style>

        .error {
            color: #ff0000;
        }
    </style>

</head>

<body>

<jsp:include page="_menu.jsp" />


<h2>Create Account</h2>

<form:form method="POST" modelAttribute="account">
    <%--<form:input type="hidden" path="userName" id="userName"/>--%>
    <table>
        <tr>
            <td><label for="userName">Login *: </label> </td>
            <td><form:input path="userName" id="userName"/></td>
            <td><form:errors path="userName" cssClass="error"/></td>
        </tr>

        <tr>
            <td><label for="password">Password *: </label> </td>
            <td><form:input path="password" id="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="3">
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>