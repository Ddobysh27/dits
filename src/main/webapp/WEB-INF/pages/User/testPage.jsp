<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<form action="/nextTestPage" method="get">

    <div> ${question} </div>
    <br>
    <c:forEach items="${answers}" var="answer">
        <input type="radio" name="choosenAns" value="${answer}"> ${answer}<br>
    </c:forEach>
    <br>
    <input type="submit" value="Следующий">
</form>

<a href="<c:url value="/logout" />">Выйти</a>
</body>
</html>