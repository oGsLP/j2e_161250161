<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String cp = request.getContextPath(); %>
    <title>index</title>
    <link rel="stylesheet" href="app/css/global.css" media="all" type="text/css">

</head>
<body>
<jsp:include page="app/header.jsp"/>

<div class="login-box">
    <h3>Login</h3>
    <form method="post" action="login">
        <label for="login-username">用户名 </label>
        <input id="login-username" name="username" type="text">
        <label for="login-password">密码   </label>
        <input id="login-password" name="password" type="password">
        <button type="submit">登录</button>
    </form>
</div>


<jsp:include page="app/footer.jsp"/>
</body>
</html>