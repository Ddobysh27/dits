<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreateTest</title>
    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>--%>
</head>
<body>

<%--<c:forEach items="${topics}" var="topic">--%>

<%--    <p>${topic}</p>--%>

<%--</c:forEach>--%>
<form>
    <p>
        <input list="topics">
        <datalist id="topics">
            <c:forEach items="${topics}" var="topic">

            <option value="${topic}">

                </c:forEach>
        </datalist>
    </p>

    <p>
        <input list="tests">
        <datalist id="tests">
            <c:forEach items="${tests}" var="test">

            <option value="${test}">

                </c:forEach>
        </datalist>
    </p>

    <p>
        <input list="questions">
        <datalist id="questions">
            <c:forEach items="${questions}" var="question">

            <option value="${question}">

                </c:forEach>
        </datalist>
    </p>

    <input type="submit" value="Отправить"></p>

</form>



<form action="/goHomeAdmin">
    <input type="submit" value="Назад">
</form>
</body>
</html>
