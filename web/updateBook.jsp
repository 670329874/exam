<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修改图书信息</title>
</head>
<body>
<div style="width:500px; margin:0px auto">
    <div style="width:500px; margin:0px auto; text-align:center">
        <h2>修改图书信息</h2></div>
    <div>
        <form action="${pageContext.request.contextPath}/update_book.do" method="post">
            <table width="500" border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="145">图书名称</td>
                    <td width="349">
                        <input type="hidden" name="bookid" id="bookid" value="${sessionScope.book.bookid}"/>
                        <input type="text" name="bookname" id="bookname" value="${sessionScope.book.bookname}"/>
                    </td>
                </tr>
                <tr>
                    <td>图书价格</td>
                    <td><input type="text" name="price" id="price" value="${sessionScope.book.price}"/></td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td><input type="date" name="pubtime" id="pubtime" value='<fmt:formatDate value="${sessionScope.book.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate>'/></td>
                </tr>
                <tr>
                    <td>图书作者</td>
                    <td><input type="text" name="author" id="author" value="${sessionScope.book.author}"/></td>
                </tr>
                <tr>
                    <td>图书类型</td>
                    <td>
                        <select name="typeid" id="typeid">
                            <c:if test="${sessionScope.bookTypeList!=null}">
                                <c:forEach items="${sessionScope.bookTypeList}" var="bookType">
                                    <option value="${bookType.typeid}" <c:if test="${sessionScope.book.typeid==bookType.typeid}">selected="selected"</c:if>>${bookType.typename}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="middle"><input type="submit" name="btnUpdate" id="btnUpdate" value="修改图书" />
                        &nbsp;<input type="reset" name="btnReset" id="btnReset" value="重置图书" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>