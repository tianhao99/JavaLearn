<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--静态包含 base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
			<%--静态包含，登陆成功的页面    直接写地址，是因为上边有base标签--%>
			<%@ include file="/pages/common/login_success_page.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>
	
		</div>


		<%--静态包含，页脚信息	--%>
		<%@include file="/pages/common/footer.jsp"%>


</body>
</html>