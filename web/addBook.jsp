<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加图书</title>
</head>
<body>
<div style="width:500px; margin:0px auto">
    <div style="width:500px; margin:0px auto; text-align:center">
        <h2>添加图书信息</h2></div>
    <div>
        <form action="${pageContext.request.contextPath}/add_book.do" method="post">
            <table width="500" border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="145">图书名称</td>
                    <td width="349"><label for="bookname"></label>
                        <input type="text" name="bookname" id="bookname" /></td>
                </tr>
                <tr>
                    <td>图书价格</td>
                    <td><input type="text" name="price" id="price" /></td>
                </tr>
                <tr>
                    <td>出版时间</td>
                    <td><input type="date" name="pubtime" id="pubtime" /></td>
                </tr>
                <tr>
                    <td>图书作者</td>
                    <td><input type="text" name="author" id="author" /></td>
                </tr>
                <tr>
                    <td>图书类型</td>
                    <td>
                        <select name="typeid" id="typeid">
                            <option value="-1">--请选择图书类型--</option>
                            <c:if test="${sessionScope.bookTypeList!=null}">
                                <c:forEach items="${sessionScope.bookTypeList}" var="bookType">
                                    <option value="${bookType.typeid}">${bookType.typename}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" valign="middle"><input type="submit" name="btnAdd" id="btnAdd" value="添加图书" />
                        &nbsp;<input type="reset" name="btnReset" id="btnReset" value="重置图书" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>