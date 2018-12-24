<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/24
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/global.css" media="all" type="text/css">
    <link rel="stylesheet" href="css/login.css" media="all" type="text/css">

</head>
<body>
<jsp:include page="header.jsp"/>

<div class="login-box">
    <h2>Login</h2>
    <form method="post" class="login-form" action="login">
        <div class="login-line-div">
            <label for="login-username">用户名 </label>
            <input id="login-username" name="username" type="text">
        </div>
        <div class="login-line-div">
            <label for="login-password">密码   </label>
            <input id="login-password" name="password" type="password">
        </div>
        <div class="login-line-div">
            <button type="submit">登录</button>
            <button type="button" onclick="window.location.href='/app/traveller';">游客登录</button>
        </div>
    </form>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>