<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col">
        <img src="/WEB-INF/human.png">
    </div>
    <div class="col">
        <h1> Hello ${user}</h1>
        <a href="<c:url value="/chooseTest" />">Выбор темы и теста</a> <br>
        <a href="<c:url value="/personalStatistic" />">Личная статистика</a> <br>
        <a href="<c:url value="/logout" />">выйти</a>
    </div>
</div>
<div class="mycont">


</div>
</body>
</html>