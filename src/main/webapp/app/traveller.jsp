<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/24
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Traveller</title>
    <link rel="stylesheet" href="css/global.css" media="all" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>

<p>You are a traveller</p>
<p>Click here to <a onclick="window.location.href='/app/logout'">log out</a></p>

<jsp:include page="footer.jsp"/>

</body>
</html>
