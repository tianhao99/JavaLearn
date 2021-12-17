<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--静态包含 base标签、css样式、jQuery文件--%>
	<%@ include file="/pages/common/head.jsp"%>

	<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>

	<script type="text/javascript">
		// 重中之重！！！页面加载之后
		$(function (){


			// 给用户名输入框绑定失去焦点事件
			$("#username").blur(function () {
				// 1、获取用户名
				var username = this.value;
				// $.getJSON(url,data,callback);
				$.getJSON("http://localhost:8080/Books/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
					if (data.isExists){
						$("span.errorMsg").text("用户名已存在！");
					}else{
						$("span.errorMsg").text("用户名可用！");
					}
				});
			});


			// 给注册绑定单击事件
			$("#sub_btn").click(function (){

				var username = $("#username").val();
				var password = $("#password").val();
				var repwd = $("#repwd").val();
				var email = $("#email").val();
				var code = $("#code").val();
				// 用户名、密码正则表达式：字母、数字、下划线、5~12位
				var regUser = /^\w{5,12}$/;
				// 邮箱正则表达式：xxxx@xxx.com
				var regEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/
				if(!regUser.test(username)){
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}
				if(!regUser.test(password)){
					$("span.errorMsg").text("密码不合法！");
					return false;
				}
				if(repwd != password){
					$("span.errorMsg").text("两次密码不一致！");
					return false;
				}
				if(!regEmail.test(email)){
					$("span.errorMsg").text("邮箱不合法！");
					return false;
				}

				//先对验证码去除前后空格，然后判断不空就可以了
				var trimCode = $.trim(code);
				if(trimCode == null || trimCode == ""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}

				// 提示处内容置为空，当运行到这里时，表示所有都合法了，就不应该有非法提示了
				$("span.errorMsg").text("");
			});

			// 给验证码图片绑定单击事件，实现点击刷新验证码操作
			$("#code_img").click(function (){
				// 在事件响应的 function 函数中有一个 this 对象。
				// 这个 this 对象， 是当前正在响应事件的 dom 对象【这里就是验证码的那个img标签】
				// src 属性表示验证码 img 标签的 图片路径。 它可读， 可写

				// this.src = "${basePath}/kaptcha.jpg"【本来这样就可以实现了】
				// 但是除了谷歌浏览器外，其他浏览器将数据缓存在浏览器，每次点击实际访问地址一样，
				// 就不会实现更新，在后边加一个参数并赋随机的值，让每次参数都不一样
				// 最好的方法就是加一个时间，因为时间永远不会相同
				this.src = "${basePath}/kaptcha.jpg?d=" + new Date();

			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									<%--使用下边el表达式替换上边 --%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
<%--										   value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											<%--使用下边el表达式替换上边 --%>
											value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
<%--										   value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
										   value="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 100px;" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 130px;height: 40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%--静态包含，页脚信息	--%>
		<%@include file="/pages/common/footer.jsp"%>


</body>
</html>