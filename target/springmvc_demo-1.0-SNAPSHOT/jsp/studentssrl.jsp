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
  <title>显示宿舍信息</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />

</head>
<body>

<div id="div1">
  <table>

    <thead>
    <tr>
      <th>id</th>
      <th>房间号</th>
      <th>宿舍楼名</th>
      <th>床号</th>
      <th>用户名</th>
      <th>学号</th>
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
  </table>
</div>

</body>

</html>
