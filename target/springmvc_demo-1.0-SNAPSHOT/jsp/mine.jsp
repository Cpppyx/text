<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/2
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mine.css" />
</head>
<body>
<h1 style="margin-left: 20%;">Welcome  ${sessionScope.user.username}! </h1>
<hr>
<c:if test = "${userimg == null}" var="result" scope="session">
  <c:set var="userimg" value="/img/img1.jpg" scope="session" />
</c:if>
<div class="left">
  <h4>${uploadMessage}</h4>
  <img id="img"  src="${pageContext.request.contextPath}${userimg}"/>
  <form action="${pageContext.request.contextPath}/user/upload" method="post" enctype="multipart/form-data">
    <input type="file" id="file" name="image" accept=".jpg, .jpeg, .png">
    <input type="submit">
  </form>

</div>
<div class="right">
  <p><h3>用户名:${sessionScope.user.username}</h3></p>
  <p><h3>密码:${user.password}</h3></p>
  <p><a href="modify.jsp">修改</a></p>


</div>
</body>

</html>
