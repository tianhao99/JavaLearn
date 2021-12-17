<%--
  Created by IntelliJ IDEA.
  User: kingb
  Date: 2021/11/12
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${sessionScope.user.username != null}" >
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    </c:if>
    <c:if test="${sessionScope.user.username == null}" >
        <a href="pages/user/login.jsp">去登录</a>
    </c:if>
    <a href="orderServlet?action=showMyOrders&user_id=${sessionScope.user.id}">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>

