<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-11-26
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<a href="<c:url value="/logout" />">выйти</a>
<h1> Hello ${user}</h1>
</body>
</html>
