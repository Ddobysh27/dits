<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 07.12.2019
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateTest</title>
</head>
<body>

<form >
    <input list="browsers">
    <datalist id="browsers">
        <option value="Internet Explorer">
        <option value="Firefox">
        <option value="Chrome">
        <option value="Opera">
        <option value="Safari">
    </datalist>

    <p><select name="select" size="3" multiple>
        <option value="s1">1</option>
        <option value="s2">2</option>
        <option value="s3">3</option>
        <option value="s4">4</option>
    </select>
        <input type="submit" value="Отправить"></p>
</form>

<form action="/goHomeAdmin">
    <input type="submit" value="Назад">
</form>
</body>
</html>
