<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/1
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css" />
</head>
<body>
<div class="bg">
    <div class="control">
        <div class="content">

            <div style="display: block;">
                <h2>运动会管理系统</h2>
                <form action="${pageContext.request.contextPath}/user/regist" method="post">
                    <p>用户名</p>
                    <input type="text" placeholder="username" id="userInput" name="username"/>
                    <p>密码</p>
                    <input type="password" placeholder="password"  id="pwdInput" name="password"/>
                    <p>确认密码</p>
                    <input type="password" placeholder="confirmpassword"  id="confirmPwd" />
                    <br/>
                    ${message}
                    <input type="submit" id="submitBtn" value="注册"/>
                    <p> 已有账户？<a href="${pageContext.request.contextPath}/index.jsp">登入</a></p>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    window.onload = function(){
        //获取注册按钮并给它绑定单击响应函数
        var submitBtnEle = document.getElementById("submitBtn");
        submitBtnEle.onclick = function(){
            //获取用户输入的用户名
            var userInputEle = document.getElementById("userInput");
            var userText = userInputEle.value;
            if(userText == ""){
                alert("用户名不能为空！");
                return false;
            }
            //获取用户输入的密码
            var pwdInputEle = document.getElementById("pwdInput");
            var pwdText = pwdInputEle.value;
            if(pwdText == ""){
                alert("密码不能为空！");
                return false;
            }
            //获取用户输入的确认密码
            var confirmPwdEle = document.getElementById("confirmPwd");
            var confirmPwdText = confirmPwdEle.value;
            if(confirmPwdText == ""){
                alert("确认密码也不能为空！");
                return false;
            }
            if(confirmPwdText != pwdText){
                alert("两次输入的密码不一致！")
                confirmPwdEle.value = "";
                return false;
            }
        };
    };
</script>
</html>
