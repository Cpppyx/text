<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--记得清除浏览器缓存 CTRL+F5--%>
<%--浏览器缓存机制问题,它是直接从磁盘上读取样式，并没有从服务器上获取新的样式--%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login"  name="actionForm" id="actionForm"  method="post" >
    <h2>运动会管理系统</h2>
    <div class="info">${message }</div>
    <p><label for="userCode">用户名：</label><br /><br />
        <input type="text" class="textinput"  id="userCode" name="userName" placeholder="请输入用户名"  required/>
    </p>
    <p> <label for="userPassword">密码：</label><br /><br />
        <input type="password" class="textinput" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
    </p>
    <p>
        <input type="submit" value="登录" />
    </p>
    <p class="smtxt">还没有账户？<a href="${pageContext.request.contextPath}/user/registview">注册</a>
    </p>
</form>
</body>
</html>

</html>
