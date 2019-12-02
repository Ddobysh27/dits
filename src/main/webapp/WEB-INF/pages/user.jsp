<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<body>
    <a href="<c:url value="/logout" />">выйти</a>
    <h1> Hello ${user}</h1>
	</body>
</html>