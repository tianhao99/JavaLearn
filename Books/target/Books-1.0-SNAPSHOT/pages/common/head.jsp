<%--
  Created by IntelliJ IDEA.
  User: kingb
  Date: 2021/11/12
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme() //http
    + "://"                               //://
    + request.getServerName()             //IP地址
    + ":"                                 // :
    + request.getServerPort()             // 端口
    + request.getContextPath()            // 路径Books
    + "/";                                // 最后别忘了斜杠/
    pageContext.setAttribute("basePath",basePath);

%>
<!--写 base 标签， 永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>