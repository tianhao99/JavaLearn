<%--
  Created by IntelliJ IDEA.
  User: kingb
  Date: 2021/11/15
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--		分页条的开始--%>
<div id="page_nav">
    <%--当前页面大于1，才显示首页和上一页操作，要不然第一页你再上一页跑哪去了？？？？			--%>
    <c:if test="${requestScope.page.pageNo >1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%--页码输出的开始--%>
    <c:choose>
        <%--情况 1： 如果总页码小于等于 5 的情况， 页码的范围是： 1-总页码--%>
        <c:when test="${ requestScope.page.pageTotal <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--情况 2： 总页码大于 5 的情况--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose><%--小情况 1： 当前页码为前面 3 个： 1， 2， 3 的情况， 页码范围是： 1-5.--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况 2： 当前页码为最后 3 个， 8， 9， 10， 页码范围是： 总页码减 4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--小情况 3： 4， 5， 6， 7， 页码范围是： 当前页码减 2 - 当前页码加 2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出的结束--%>


    <%--当前页面小于总页数，才显示末页和下一页操作，要不然最后一页你再下一页跑哪去了？？？？			--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}"	>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo == null ? 1 : param.pageNo }" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

</div>
<%--		分页条的结束--%>
