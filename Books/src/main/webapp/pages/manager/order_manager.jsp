<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%--静态包含 base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>

			<%--静态包含 引入管理页面的菜单			--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>
			<c:forEach items="${sessionScope.orders}" var="order">
			<tr>
				<td>${order.create_time}</td>
				<td>${order.price}</td>
				<td><a href="orderServlet?action=showOrderDetail&order_id=${order.order_id}">查看详情</a></td>
				<c:choose>
					<c:when test="${order.status == 0}">
						<td><a href="orderServlet?action=sendOrder&order_id=${order.order_id}">点击发货</a></td>
					</c:when>
					<c:when test="${order.status == 1}">
						<td>已发货----【<span><a href="orderServlet?action=receiverOrder&order_id=${order.order_id}">确认收货</a></span>】</td>
					</c:when>
					<c:when test="${order.status == 2}">
						<td>已收货</td>
					</c:when>
				</c:choose>
			</tr>
			</c:forEach>
		</table>
	</div>


	<%--静态包含，页脚信息	--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>