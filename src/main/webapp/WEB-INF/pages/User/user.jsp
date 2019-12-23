<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<h1> Hello ${user}</h1>
<a href="<c:url value="/chooseTest" />">Выбор темы и теста</a> <br>
<a href="<c:url value="/personalStatistic" />">Личная статистика</a> <br>

<a href="<c:url value="/logout" />">выйти</a>
</body>
</html>