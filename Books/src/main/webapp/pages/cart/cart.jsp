<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含 base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			// 给删除绑定单击事件，删除前确认一下
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除《" + $(this).parent().parent().find("td:first").text() + "》吗？？？");
			});
			// 给清空购物车绑定单击事件，清空之前确认一下
			$("a.clear").click(function () {
				return confirm("你确定要清空购物车的所有商品吗？？？");
			});
			// 给修改购物车商品数量绑定【onchange事件】【内容发生变化，触发，省去了判断是否更改了】
			$("input.updateCount").change(function () {
				// 1、获取商品名称及id
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr("bookId");
				// 2、获取商品修改后的数量
				var count = this.value;
				// 3、根据用户选择是否确认修改，产生不同结果
				if( confirm("你确定要将《" + name + "》的数量修改为：" + count + "吗?")){
					// 同意修改，跳转到CartServlet进行修改操作
					location.href = "http://localhost:8080/Books/cartServlet?action=updateCount&count=" + count +"&id=" + id;
				}else{
					// 放弃修改，恢复默认值
					this.value = this.defaultValue;
				}
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--静态包含，登陆成功的页面    直接写地址，是因为上边有base标签--%>
		<%@ include file="/pages/common/login_success_page.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<%--购物车为空--%>
				<tr>
					<td colspan="5"><a href="index.jsp">亲！当前购物车是空的，快去逛逛吧！</a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
				<%--购物车不空--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCount" style="width: 50px;" type="text" bookId="${entry.value.id}" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
<%--		购物车空的时候就不显示下面的金额之类的--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clear" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>


	<%--静态包含，页脚信息	--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>