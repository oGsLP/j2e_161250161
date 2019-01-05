<%@ page import="classes.models.ShopResult" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/28
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ShopResult</title>
    <link rel="stylesheet" href="css/global.css" media="all" type="text/css">
    <link rel="stylesheet" href="css/shopResult.css" media="all" type="text/css">
</head>
<body>
<%
    ShopResult shopResult= (ShopResult) request.getAttribute("shop_result");
%>
<jsp:include page="header.jsp"/>
<div class="shop-result-div">
    <h1>购物结果</h1>
    <strong>Result : <%=shopResult.getMessage()%></strong>
    <ul>
        <li>
            <label for="shop_username">购买用户</label>
            <span id="shop_username"><%=shopResult.getUsername()%></span>
        </li>
        <li>
            <label for="before_account">购买前账户余额</label>
            <span id="before_account"><%=shopResult.getBefore_account()%></span>
        </li>
        <li>
            <label for="after_account">购买后账户余额</label>
            <span id="after_account"><%=shopResult.getAfter_account()%></span>
        </li>
        <li>
            <label for="before_discount">商品总价</label>
            <span id="before_discount"><%=shopResult.getBefore_discount()%></span>
        </li>
        <li>
            <label for="after_discount">折后价</label>
            <span id="after_discount"><%=shopResult.getAfter_discount()%></span>
        </li>
    </ul>
    <a onclick="window.location.href='/app/listLayout'">back</a>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
