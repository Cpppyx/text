<%--
  Created by IntelliJ IDEA.
  User: happyboy
  Date: 2022/1/19
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="user" class="com.example.webmvc.pojo.User" scope="session">--%>
<%--    <jsp:setProperty name="user" property="*"/>--%>
<%--</jsp:useBean>--%>
<html>
<head>
    <title>显示用户信息</title>

</head>
<body>
<center>
    <h2>用户信息</h2>
    <%-- <c:if>标签 --%>
    <c:if test = "${sessionScope.userimg == null}" var="result" scope="session">
        <c:set var="userimg" value="/img/img1.jpg" scope="session" />
    </c:if><br>
    <img id="img" style="border-radius:30%" src="${pageContext.request.contextPath}${userimg}"/>
    <br>
    <form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>用户名:</td>
                <%-- EL表达式 --%>
                <td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>Email地址:</td>
                <td>${user.email}</td>
            </tr>


        </table>
    </form>
    <div>
    <a href="${pageContext.request.contextPath}/WEB-INF/jsp/usermodify.jsp">修改用户信息</a>
    <br>
    <a href="${pageContext.request.contextPath}/index.jsp">回首页</a>
    <br>
    <a href="${pageContext.request.contextPath}/user/list">查询所有用户信息</a>
    </div>
</center>
<script src="${pageContext.request.contextPath}/js/fileupload.js"></script>
</body>
</html>
