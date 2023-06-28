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

    <div class="right" style="float:right;">
      <form  action="${pageContext.request.contextPath}/dormitoryinfo/query" method="post"
      >
        <span style="color: red;font-weight: bold" >${error}</span>
        <input type="text" name="queryName"  placeholder="请输入您的编号" required>
        <input type="submit" value="查询" class="btn1">
      </form>
    </div>
  </div>
  <table>

    <thead>
    <tr>
      <th>运动员编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>比赛项目</th>
      <th>院系号</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="dormitoryinfo" items="${requestScope.get('List')}" >
      <tr>
        <td>${dormitoryinfo.getId()}</td>
        <td>${dormitoryinfo.roomid}</td>
        <td>${dormitoryinfo.dormitoryname}</td>
        <td>${dormitoryinfo.bedid}</td>
        <td>${dormitoryinfo.username}</td>
        <td>${dormitoryinfo.userid}</td>
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
