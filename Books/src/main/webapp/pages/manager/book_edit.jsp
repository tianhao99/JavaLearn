<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
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
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>

			<%--静态包含 引入管理页面的菜单			--%>
			<%@include file="/pages/common/manager_menu.jsp"%>

		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
<%--				实现动态调整隐藏域的value值，判断是添加操作，还是修改操作--%>
<%--				方式一：在添加或修改提交按钮处，增加一个参数&method=update/add--%>
<%--				在隐藏域中获取该值--%>
<%--				<input type="hidden" name="action" value="${param.method}"/>--%>
<%--				方式二：通过判断是否有id这个参数，因为修改要用到查询带了个id参数，但是添加没有--%>
<%--				若空：则表示添加，--%>
<%--				不空：则表示修改。--%>
				<input type="hidden" name="action" value="${empty param.id ? "add":"update"}"/>
<%--				因为修改操作需要查询，所以需要原id--%>
				<input type="hidden" name="id" value="${requestScope.book.id}"/>
<%--				因为传回去的图书信息，没有id，但是update要查询修改的图书通过id，所以这里封装一个--%>
<%--				因为request.getParameterMap()会获取所有的键值对，所以这里弄一个隐藏域键值，那边不用管，自动就能获取到--%>
<%--				但是名字一定要对，要不然没办法封装--%>

				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>


		<%--静态包含，页脚信息	--%>
		<%@include file="/pages/common/footer.jsp"%>


</body>
</html>