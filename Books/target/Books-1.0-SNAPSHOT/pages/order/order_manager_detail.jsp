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

	<div>
		<a href="pages/manager/order_manager.jsp">返回订单管理</a>
		<a href="index.jsp">返回商城</a>
	</div>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单编号</td>
				<td>商品名称</td>
				<td>单价</td>
				<td>数量</td>
				<td>总价</td>

			</tr>
			<c:forEach items="${sessionScope.orderItems}" var="orderItem">
			<tr>
				<td>${orderItem.order_id}</td>
				<td>${orderItem.name}</td>
				<td>${orderItem.price}</td>
				<td>${orderItem.count}</td>
				<td>${orderItem.total_Price}</td>
			</tr>
			</c:forEach>
		</table>
	</div>


	<%--静态包含，页脚信息	--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>