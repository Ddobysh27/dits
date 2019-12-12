<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

<form action="/goTest">

    <select id="themes" name="themes">
        <c:forEach items="${topic}" var="topic">
            <option> ${topic.name} </option>
        </c:forEach>
    </select>

    <br>
        <select id="tests" name="test">
            <option>Выберите тему</option>
            <option></option>
        </select>
    </div>
    <br>

    <input type="submit" value="Пройти тестирование">

</form>

<script>
    $().ready(function () {
        $("#themes").change(function (event) {
            $.ajax({
                url: "/UserChoose",
                type: "GET",
                dataType: "json",
                data: {topic: $(event.target).val()},
            })
                .done(function (data) {
                    setTests(data)
                })
                .fail(function (xhr, status, error) {
                alert(xhr.responseText + '|\n' + status + '|\n' +error);
            });

        });
    });


    var setTests = function (data) {
        $('#tests').find('option').remove();
        $.each(data, function (index, value) {
            $('#tests').append(new Option(value, value));
        });
    };

</script>

</body>
</html>