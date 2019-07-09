<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>图书详细信息</title>
</head>
<body>
<div style="width:500px; margin:0px auto">
    <div style="width:500px; margin:0px auto; text-align:center"><h2>图书详细信息</h2></div>
    <div>
        <table width="500" border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td width="145">图书编号</td>
                <td width="349">${sessionScope.book.bookid}</td>
            </tr>
            <tr>
                <td>图书名称</td>
                <td>${sessionScope.book.bookname}</td>
            </tr>
            <tr>
                <td>图书价格</td>
                <td>${sessionScope.book.price}</td>
            </tr>
            <tr>
                <td>出版时间</td>
                <td><fmt:formatDate value="${sessionScope.book.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
            </tr>
            <tr>
                <td>图书作者</td>
                <td>${sessionScope.book.author}</td>
            </tr>
            <tr>
                <td>图书类型</td>
                <td>${sessionScope.book.typename}</td>
            </tr>
            <tr>
                <td colspan="2" align="center" valign="middle">
                    <input type="button" name="btnReturn"
                           id="btnReturn" value="返回首页" onclick="history.go(-1)" />
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>