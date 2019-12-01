<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 01/12/2019
  Time: 6:57 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Encuesta</title>
</head>
<body>
<form method="post" action="encuesta">
    <%--@elvariable id="preguntas" type="java.util.List"--%>
    <c:forEach items="${preguntas}" var="pregunta" varStatus="i">
        <br>${i.index} - ${pregunta.pregunta}<br>
        <c:forEach items="${pregunta.opciones}" var="opcion" varStatus="j">
            <input type="radio" name="radio${i.index}" value="${j.index}" checked>${opcion}<br>
        </c:forEach>
    </c:forEach>
    <input type="submit">
</form>
</body>
</html>
