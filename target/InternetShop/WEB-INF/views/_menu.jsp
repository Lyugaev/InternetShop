<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>

<div class="menu-container">

    <a href="<c:url value='/list' />">Home</a>
    |
    <a href="<c:url value='/goCart' />">Cart</a>
    |
    <a href="<c:url value='/login' />">Login</a>

</div>