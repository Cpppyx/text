<%--
  Created by IntelliJ IDEA.
  User: happyboy
  Date: 2022/4/13
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有用户</title>
</head>
<body>
<center>
    <h4>${message}</h4>
    <table border="1" >
        <tr>
            <td>id</td><td>用户名</td><td>密码</td><td>Email</td><td>操作</td><td>操作</td>
        </tr>
        <c:forEach var="user" items="${userList}" >
            <tr><td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td><a href="${pageContext.request.contextPath}/user/delete?uid=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <td colspan="5" align="center"><a href="${pageContext.request.contextPath}/WEB-INF/jsp/success.jsp">返回</a></td>
</center>

</body>
<script type="text/javascript">
function deleteById(id) {
        if (confirm("确定删除吗？")) {
            window.location.href = "${pageContext.request.contextPath}/UserServlet?method=delete&uid=" + id;
        }
    }
</script>
</html>
