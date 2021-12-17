<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
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
			<span class="wel_word">结算</span>
			<%--静态包含，登陆成功的页面    直接写地址，是因为上边有base标签--%>
			<%@ include file="/pages/common/login_success_page.jsp"%>
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.order_id}</h1>
		
	
	</div>


	<%--静态包含，页脚信息	--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>