<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Account Info</title>
</head>
<body>

<jsp:include page="_menu.jsp" />
<br>
<div class="page-title">Account Info</div>

<div class="account-container">


    <ul>
        <li>User Name: ${pageContext.request.userPrincipal.name}</li>
        <li>Role:
            <ul>
                <c:forEach items="${userDetails.authorities}" var="auth">
                    <li>${auth.authority }</li>
                </c:forEach>
            </ul>
        </li>
    </ul>
</div>


</body>
</html>