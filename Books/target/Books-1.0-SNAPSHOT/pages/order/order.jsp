<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%--静态包含 base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%--静态包含，登陆成功的页面    直接写地址，是因为上边有base标签--%>
		<%@ include file="/pages/common/login_success_page.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${sessionScope.myOrders}" var="myOrder">
			<tr>
				<td>${myOrder.create_time}</td>
				<td>${myOrder.price}</td>

				<c:choose>
					<c:when test="${myOrder.status == 0}">
						<td><a href="orderServlet?action=sendOrder&order_id=${order.order_id}">点击发货</a></td>
					</c:when>
					<c:when test="${myOrder.status == 1}">
						<td>已发货----【<span><a href="orderServlet?action=receiverOrder&order_id=${order.order_id}">确认收货</a></span>】</td>
					</c:when>
					<c:when test="${myOrder.status == 2}">
						<td>已收货</td>
					</c:when>
				</c:choose>
				<td><a href="orderServlet?action=showOrderDetail&order_id=${myOrder.order_id}">查看详情</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>


	<%--静态包含，页脚信息	--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>