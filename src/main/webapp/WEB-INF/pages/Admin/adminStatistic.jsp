<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminStatistic</title>
</head>
<body>


<a href="<c:url value="/statisticByTest" />">Статистика по тесту </a> <br>
<a href="<c:url value="/statisticByQuestion" />">Статистика по вопросам </a> <br>
<a href="<c:url value="/statisticEveryUser" />">Статистика пользователей </a> <br>

<form action="/goHomeAdmin">
    <input type="submit" value="Назад">
</form>


</body>
</html>
