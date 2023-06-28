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
  <title>显示报修信息</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />

</head>
<body>

<div id="div1">
  <div>
    <div style="float: left;">
      <a class="btn-primary"
         href="${pageContext.request.contextPath}/dormrepair/toAdd">新增信息</a>
    </div>
    <div class="right" style="float:right;">
      <form  action="${pageContext.request.contextPath}/dormrepair/query" method="post"
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
      <th>比赛项目号</th>
      <th>比赛成绩</th>
      <th>得分</th>
      <th>比赛名次</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="dormrepair" items="${requestScope.get('List')}" >
      <tr>
        <td>${dormrepair.id}</td>
        <td>${dormrepair.roomid}</td>
        <td>${dormrepair.dormitoryname}</td>
        <td>${dormrepair.username}</td>
        <td>${dormrepair.repairtime}</td>
        <td>${dormrepair.repairreason}</td>
        <td>${dormrepair.repairstatus}</td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>

</body>

</html>
