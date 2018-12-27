<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/22
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WrongPasswd</title>
    <link rel="stylesheet" href="css/global.css" media="all" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>

<h2>Wrong Passwd</h2>
<h3><%=request.getSession(false).getAttribute("unreachable")%></h3>
<a href="/app/login">Back to login</a>
<jsp:include page="footer.jsp"/>
</body>
</html>
