<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Login</title>
</head>
<body>

<jsp:include page="_menu.jsp" />

<br>
<div class="page-title">(for demo only) Admin login (login=admin, pass=123)</div>

<div class="login-container">

    <h3>Enter username and password</h3>
    <!-- /login?error=true -->
    <c:if test="${param.error == 'true'}">
        <div style="color: red; margin: 10px 0px;">

            Login Failed!!!<br /> Reason :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

        </div>
    </c:if>

    <form method="POST"
          action="${pageContext.request.contextPath}/j_spring_security_check">
        <table>
            <tr>
                <td>Login *</td>
                <td><input name="userName" /></td>
            </tr>

            <tr>
                <td>Password *</td>
                <td><input type="password" name="password" /></td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login" /> <input type="reset"
                                                                 value="Reset" /></td>
            </tr>
        </table>
    </form>

    <span class="error-message">${error }</span>

</div>

</body>
</html>