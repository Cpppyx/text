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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>运动员参赛信息</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css" />

</head>
<body>

<div id="div1">
    <div>
        <c:if test="${sessionScope.userbool}">
            <div style="float: left;">
                <a class="btn-primary"
                   href="${pageContext.request.contextPath}/athlete_event/toAdd">新增信息</a>
            </div>
        </c:if>
        <div class="right" style="float:right;">
            <form  action="${pageContext.request.contextPath}/athlete_event/query" method="post">
                <span style="color: red;font-weight: bold" >${error}</span>
                <input type="text" name="queryName"  placeholder="请输入运动员编号" required>
                <input type="submit" value="查询" class="btn1">
            </form>
        </div>
    </div>
    <table>

        <thead>
        <tr>
            <th>运动员编号</th>
            <th>运动项目编号</th>
            <th>比赛项目成绩</th>
            <th>比赛得分</th>
            <th>排名</th>
            <c:if test="${sessionScope.userbool}">
                <th>操作</th>
                <th>操作</th>
            </c:if>
        </tr>

        </thead>
        <tbody>
        <c:forEach var="athlete_event" items="${requestScope.get('athlete_eventlist')}" >
            <tr>
                <td>${athlete_event.getAthlete_id()}</td>
                <td>${athlete_event.event_id}</td>
                <td>${athlete_event.score}</td>
                <td>${athlete_event.endowment_score}</td>
                <td>${athlete_event.ranking}</td>
                <c:if test="${sessionScope.userbool}">
                    <td><a href="${pageContext.request.contextPath}/athlete_event/modifyview?id=${athlete_event.athlete_id}">修改</a></td>
                    <td><a href="${pageContext.request.contextPath}/athlete_event/delete?id=${athlete_event.athlete_id}" onclick="deleteById()">删除</a></td>
                </c:if>
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
