<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>图书列表信息</title>
</head>
<body style="width:900px; margin:0px auto;">
<div style="width:900px; text-align:center">
    <h2>图书信息列表</h2>
</div>
<div style="width:880px; text-align:right; padding-right:20px; line-height:25px; height:25px;">
    <a href="${pageContext.request.contextPath}/pre_add.do">添加图书信息</a>
</div>
<div style="width:900px; text-align:center">
    <form id="pageForm" action="${pageContext.request.contextPath}/list.do" method="post">
        图书类型：
        <select name="typeid" id=  "typeid">
            <option value="-1">-请选择图书类型--</option>
            <c:if test="${requestScope.bookTypeList!=null}">
                <c:forEach items="${requestScope.bookTypeList}" var="bookType">
                    <option value="${bookType.typeid}" <c:if test="${requestScope.bookParam.typeid==bookType.typeid}">selected="selected"</c:if>>${bookType.typename}</option>
                </c:forEach>
            </c:if>
        </select>
        作者：
        <input name="author" type="text" id="author" size="10" value="${requestScope.bookParam.author}"/>
        价格：
        <input name="min_price" type="text" id="min_price" size="10" value="${requestScope.bookParam.min_price}"/>
        到
        <input name="max_price" type="text" id="max_price" size="10" value="${requestScope.bookParam.max_price}"/>
        <input name="pageNo" type="hidden" id="pageNo" value="1" />
        <input type="submit" name="btnSearch" id="btnSearch" value="查询图书" />
    </form>
</div>
<div style="width:900px; text-align:center">
    <table width="900" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>编号</td>
            <td>图书名称</td>
            <td>价格</td>
            <td>出版时间</td>
            <td>作者</td>
            <td>图书类型</td>
            <td>详细</td>
            <td>删除</td>
            <td>修改</td>
        </tr>
        <c:if test="${requestScope.pageUtil.list!=null}">
            <c:forEach items="${requestScope.pageUtil.list}" var="book">
                <tr>
                    <td>${book.bookid}</td>
                    <td>${book.bookname}</td>
                    <td>${book.price}</td>
                    <td><fmt:formatDate value="${book.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${book.author}</td>
                    <td>${book.typename}</td>
                    <td><a href="${pageContext.request.contextPath}/detail.do?bookid=${book.bookid}">详细</a></td>
                    <td><a href="javascript:do_delete(${book.bookid})">删除</a></td>
                    <td><a href="${pageContext.request.contextPath}/pre_update.do?bookid=${book.bookid}">修改</a></td>
                </tr>
            </c:forEach>
        </c:if>

        <tr>
            <td colspan="9" align="center" valign="middle">
                <a href="javascript:do_page(1)">首页</a>&nbsp;
                <a href="javascript:do_page(${requestScope.pageUtil.pageNo-1})">上一页</a>&nbsp;
                <a href="javascript:do_page(${requestScope.pageUtil.pageNo+1})">下一页</a>&nbsp;
                <a href="javascript:do_page(${requestScope.pageUtil.totalPage})">末页</a></a>&nbsp;
                ${requestScope.pageUtil.pageNo}/${requestScope.pageUtil.totalPage}页
            </td>
        </tr>
    </table>
</div>
</body>
<script type="application/javascript">
    function do_delete(bookid) {
        if(confirm("确认删除吗？")){
            location.href="${pageContext.request.contextPath}/delete_book.do?bookid="+bookid;
        }
    }

    function do_page(pn) {
        var pageForm=document.getElementById("pageForm");
        document.getElementById("pageNo").value=pn;
        pageForm.submit();
    }
</script>
</html>
