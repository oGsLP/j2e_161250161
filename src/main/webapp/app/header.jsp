<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/22
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext context=getServletConfig().getServletContext();
    int user_counter=Integer.parseInt((String) context.getAttribute("user-counter"));
    int traveller_counter=Integer.parseInt((String) context.getAttribute("traveller-counter"));
    int sum_counter=user_counter+traveller_counter;
%>
<div class="header-div">
    <div class="header-part header-left ">
        <nav class="top-nav">
            <a onclick="window.location.href='/app/logout' ">logout</a>
        </nav>
    </div>
    <div class="header-part header-center ">
        <h1>Project</h1>
    </div>
    <div class="header-part header-right ">
        <div class="header-right-list">
            <label for="website-sum">在线用户 :</label>
            <span id="website-user"><%=user_counter%></span>
        </div>
        <div class="header-right-list">
            <label for="website-sum">在线游客 :</label>
            <span id="website-traveller"><%=traveller_counter%></span>
        </div>
        <div class="header-right-list">
            <label for="website-sum">在线人数 :</label>
            <span id="website-sum"><%=sum_counter%></span>
        </div>

    </div>

</div>
<div class="header-split">

</div>