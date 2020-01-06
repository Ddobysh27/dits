<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="/res/user/mycont.css" rel="stylesheet" type="text/css">
    <link href="/res/user/input.css" rel="stylesheet" type="text/css">
    <link href="/res/user/button.css" rel="stylesheet" type="text/css">
    <link href="/res/user/link.css" rel="stylesheet" type="text/css">
    <title>
        Select
    </title>
</head>
<body>

<div class="mycont">
    <div class="margin-top8">

        <div class="row">

            <div class="col">
                <div class="mycont">
                    <img src="/resources/images/human.png">
                </div>
            </div>

            <div class="col">
                <div class="margin-top8">
                    <div class="mycont somefont">

                        <form action="/goTest">

                            <select class="css-input" id="themes" name="themes">
                                <c:forEach items="${topic}" var="topic">
                                    <option selected="selected"> ${topic.name} </option>
                                </c:forEach>
                            </select>

                            <br>
                            <select class="css-input" id="tests" name="testName">
                                <option>Second test</option>
                                <option>Third test</option>
                            </select>
                    </div>
                    <br>

                    <input class="myButton" type="submit" value="Пройти тестирование">

                    </form>

                </div>
            </div>
        </div>

    </div>

</div>
</div>

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
                    alert(xhr.responseText + '|\n' + status + '|\n' + error);
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