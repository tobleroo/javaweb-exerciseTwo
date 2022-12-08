<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

    <c:if test="${sessionScope.userActive != null}">
        <c:redirect url = "/loguser"/>
    </c:if>

    <c:if test="${wronglog == true}">
        <p>username or password incorrect!</p>
    </c:if>
    <form action="loguser" method="post">
        <input type="text" placeholder="username" name="username">
        <input type="password" placeholder="password" name="password">
        <input type="submit" value="login">
    </form>
</body>
</html>
