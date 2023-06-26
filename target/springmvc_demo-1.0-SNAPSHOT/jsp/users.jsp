<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/2
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
  <title>显示所有用户</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />

</head>
<body>

<div id="div1">
  <div>
    <div style="float: left;">
      <a class="btn-primary"
         href="${pageContext.request.contextPath}/user/toAddUser">新增用户</a>
    </div>
    <div class="right" style="float:right;">
      <form  action="${pageContext.request.contextPath}/user/queryUser" method="post"
      >
        <span style="color: red;font-weight: bold" >${error}</span>
        <input type="text" name="queryName"  placeholder="输入查询用户名" required>
        <input type="submit" value="查询" class="btn1">
      </form>
    </div>
  </div>
  <table>

    <thead>
    <tr>
      <th>id</th>
      <th>用户名</th>
      <th>密码</th>
      <th>真实姓名</th>
      <th>email</th>
      <th>权限</th>
      <th>操作</th>
      <th >操作</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.get('userList')}" >
      <tr>
        <td>${user.getId()}</td>
        <td>${user. username}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.power}</td>
        <td><a href="${pageContext.request.contextPath}/user/modifyview?uid=${user.id}">修改</a></td>
        <td><a href="${pageContext.request.contextPath}/user/delete?uid=${user.id}" onclick="deleteById()">删除</a></td>
      </tr>
    </c:forEach>

    </tbody>
    <tfoot>
    <tr>
      <td colspan="9"> <h4>${message}</h4></td>

    </tr>
    </tfoot>
  </table>
</div>

</body>
<script type="text/javascript">
  function deleteById(id) {
    if (confirm("确定删除吗？")) {
      window.location.href = "${pageContext.request.contextPath}/in0.jsp?method=delete&uid=" + id;
    }
  }
</script>
</html>
