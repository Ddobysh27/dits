<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 23.12.2019
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Every user Statistic</title>
</head>
<body>

<table border="2">
    <tr>
        <th>Ф.И.О.</th>
        <th>Название теста</th>
        <th>Пройдено всего раз</th>
        <th>Процент правильных ответов на все вопросы</th>
    </tr>
    <c:forEach items="${statistic}" var="item">
        <tr>
            <td> ${item.FIO} </td>
            <td> ${item.name} </td>
            <td> ${item.countCompleted} </td>
            <td> ${item.percent} </td>
        </tr>
    </c:forEach>
</table>


<form action="/goHomeAdmin">
    <input type="submit" value="Home page">
</form>

</body>
</html>
