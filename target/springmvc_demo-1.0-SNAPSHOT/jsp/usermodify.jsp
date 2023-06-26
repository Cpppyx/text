<%--
  Created by IntelliJ IDEA.
  User: happyboy
  Date: 2022/4/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.example.springmvc_demo.pojo.User" scope="session">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>用户修改</title>

</head>
<body>
<center>
<div class="location">
    <strong>你现在所在的位置是:</strong>
    <span>用户管理页面 >> 用户修改页面</span>
</div>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <input type="hidden" name="method" value="modifyuser">
        <input type="hidden" name="uid" value="${user.id }"/>
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input  type="text" id="userInput" name="userName" value="${user.name}"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input  type="password" id="pwdInput" name="password" value="${user.password}"/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input  type="email" id="emailInput" name="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input  type="submit" id="submitBtn" value="确定" />
            </tr>

        </table>

    </form>
</center>
</body>
</html>
