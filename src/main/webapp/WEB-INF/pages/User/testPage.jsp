<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<h1> Hello ${user}</h1>

<form action="/nextTestPage1">


<input type="text" placeholder="Вопрос">
<br> <br>
<input type="text" placeholder="1.Ответ"><br>
<input type="text" placeholder="2.Ответ"><br>
<input type="text" placeholder="3.Ответ"><br>
<input type="text" placeholder="4.Ответ"><br> <br>
    <input type="submit" value="Следующий">
</form>

<a href="<c:url value="/logout" />">выйти</a>
</body>
</html>