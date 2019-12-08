<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<table border="2">
    <tr>
        <th>Название вопроса</th>
        <th>Правильно</th>
        <th>Рекомендуемая литература</th>
        <th>Рекомендуемые ссылки на литературу</th>
    </tr>
    <c:forEach items="${statistic}" var="item">
        <tr>
            <td> ${item.question.description} </td>
            <td> ${item.correct} </td>
            <td> ${item.question.literatures} </td>
            <td>
                <c:forEach items="${item.question.literatureList}" var="lit">
                    ${lit.casualLinks}
                </c:forEach>
            </td>


        </tr>
    </c:forEach>
</table>

<br>
<form action="/goUserHome">
    <input type="submit" value="Home page">
</form>

</body>
</html>