<%--@elvariable id="usuario" type="model.Usuario"--%>
<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 01/12/2019
  Time: 4:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

Bienvenido Usuario ${usuario.email}<br>
Encuesta:
<c:choose>
    <c:when test="${empty usuario.encuesta}">No Realizada"</c:when>
    <c:otherwise>Finalizada </c:otherwise>
</c:choose>
<br><a href="/encuesta"> Encuesta </a><br>


<form action="/logout" method="get"><input type="submit" value="Log Out"></form>

</body>
</html>
