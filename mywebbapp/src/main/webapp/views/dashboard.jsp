<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    
    <c:choose>
        <c:when test="${sessionScope.userActive != null}">
            
            <h1>this is dashboard</h1>
            <p>welcome <c:out value="${sessionScope.user.username}"/>!</p>

            <c:if test="${not empty sessionScope.user.favObj}">
                <p>favorite item: <c:out value="${sessionScope.user.favObj}"/></p>
            </c:if>

            <form action="loguser" method="post">
                <input type="text" name="favoriteItem" placeholder="favorite item">
                <input type="hidden" name="username" value="${sessionScope.user.username}">
                <input type="hidden" name="password" value="${sessionScope.user.password}">
                <input type="submit" value="add">
            </form>

    
            <form action="signout" method="post">
                <input type="submit" value="sign out">
            </form>

        </c:when>
        <c:otherwise>
           <c:redirect url = "/"/>
        </c:otherwise>
    </c:choose>
</body>
</html>