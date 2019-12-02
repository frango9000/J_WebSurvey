<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 02/12/2019
  Time: 4:38 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin</h1><br><br><br>

<%--@elvariable id="usuarios" type="java.util.List"--%>
<c:forEach var="user" items="${usuarios}" varStatus="i">
    <a href="/usuario?id=${user.id}">${user.email}</a><br>
</c:forEach>

</body>
</html>
