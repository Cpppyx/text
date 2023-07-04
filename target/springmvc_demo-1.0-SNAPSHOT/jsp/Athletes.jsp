<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/30
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>运动员信息</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />

</head>
<body>

<div id="div1">
    <div>
        <div style="float: left;">
            <a class="btn-primary"
               href="${pageContext.request.contextPath}/athlete/toAdd">新增信息</a>
        </div>
        <div class="right" style="float:right;">
            <form  action="${pageContext.request.contextPath}/athlete/query" method="post"
            >
                <span style="color: red;font-weight: bold" >${error}</span>
                <input type="text" name="queryName"  placeholder="请输入运动员名称" required>
                <input type="submit" value="查询" class="btn1">
            </form>
        </div>
    </div>
    <table>

        <thead>
        <tr>
            <th>运动员编号</th>
            <th>运动员姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>比赛项目</th>
            <th>操作</th>
            <th>操作</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach var="athlete" items="${requestScope.get('athletesList')}" >
            <tr>
                <td>${athlete.getAthlete_id()}</td>
                <td>${athlete.athlete_name}</td>
                <td>${athlete.gender}</td>
                <td>${athlete.age}</td>
                <td>${athlete.event_type}</td>
                <td><a href="${pageContext.request.contextPath}/athlete/athlete?id=${athlete.athlete_id}">修改</a></td>
                <td><a href="${pageContext.request.contextPath}/athlete/athlete?id=${athlete.athlete_id}" onclick="deleteById()">删除</a></td>
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
