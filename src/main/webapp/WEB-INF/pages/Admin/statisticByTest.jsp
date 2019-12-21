<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 21.12.2019
  Time: 6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Test Statistic</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Имя теста</th>
        <th>Пройдено всего</th>
        <th>Процент правильно пройденных вопросов</th>
    </tr>
    <c:forEach items="${statisticList}" var="item">
        <tr>
            <td> ${item.name} </td>
            <td> ${item.countCompleted} </td>
            <td> ${item.percent} </td>
        </tr>
    </c:forEach>
</table>

<br>

<form action="/goHomeAdmin">
    <input type="submit" value="Home page">
</form>

</body>
</html>
