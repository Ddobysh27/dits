<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<table border="2">
    <tr>
        <th>Ф.И.О.</th>
        <th>Название теста</th>
        <th>Формулировка вопроса</th>
        <th>Пройдено всего</th>
        <th>Процент правильно пройденных вопросов</th>
    </tr>
    <c:forEach items="${statistic}" var="item">
        <tr>
            <td> ${item.user.getFIO(item.user)} </td>
            <td> ${item.question.test.name} </td>
            <td> ${item.question.description} </td>
            <td> Пройдено всего? </td>
            <td> Процент правильно пройденных вопросов? </td>
        </tr>
    </c:forEach>
</table>

<br>
<form action="/goUserHome">
    <input type="submit" value="Home page">
</form>

</body>
</html>