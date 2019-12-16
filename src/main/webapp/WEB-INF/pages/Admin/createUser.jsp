<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>CreateUser</title>

</head>
<body>

<div class="CreateUser">
    <form:form method="post" action="/createUser" modelAttribute="user">

        <table>

            <tr>
                <td><form:select path="nameRole"> <form:options items="${allRoles}"/> </form:select></td>
            </tr>

            <tr>
                <td><form:input path="lastName" placeholder="Фамилия" required="true"/></td>
            </tr>
            <tr>
                <td><form:input path="firstName" placeholder="Имя" required="true"/></td>
            </tr>
            <tr>
                <td><input placeholder="Отчество"/></td>
            </tr>
            <tr>
                <td><form:password path="password" placeholder="Пароль" required="true"/></td>
            </tr>
            <tr>
                <td><form:input path="login" placeholder="Логин" required="true"/></td>
            </tr>
            <tr>
                <td><input placeholder="Почта"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Сохранить пользователя"/></td>
            </tr>

        </table>
    </form:form>
    <p id="success"><a style="color: green; font-size: 120%;">${success}</a></p>
</div>

<script>
    setTimeout(function () {
        document.getElementById("success").style.display = 'none';
    }, 4000)
</script>

<form action="/goHomeAdmin">
    <input type="submit" value="Назад">
</form>

</body>
</html>
