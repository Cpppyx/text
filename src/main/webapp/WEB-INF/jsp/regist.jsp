<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/2
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
                var emailInputEle = document.getElementById("emailInput");
                var emilText = emailInputEle.value;
                if(emilText == ""){
                    alert("邮箱不能为空！");
                    return false;
                }
            };
        };
    </script>
    <style>
        .registDiv{
            text-align: center;
            margin: 0px auto;
        }
    </style>
</head>
<body>
<div class="registDiv">
    <center>
        <h3>注册页面</h3>
        <img id="img" src="${pageContext.request.contextPath}/img/img1.jpg"/> <br>
        ${message}<br>
        <form action="${pageContext.request.contextPath}/UserServlet" method="post">
            <input type="hidden" name="method" value="add">
            <table border="1">

                <tr>
                    <td>用户名</td>
                    <td><input  type="text" id="userInput" name="userName" /></td>
                </tr>

                <tr>
                    <td>密码</td>
                    <td><input  type="password" id="pwdInput" name="password" /></td>
                </tr>

                <tr>
                    <td>确认密码</td>
                    <td><input  type="password" id="confirmPwd" name="passwordConfirm" /></td>
                </tr>

                <tr>
                    <td>邮箱</td>
                    <td><input  type="email" id="emailInput" name="email" /></td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td><input  type="date" id="birthdayInput" name="birthday" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input  type="submit" id="submitBtn" value="注册" /> <a href="${pageContext.request.contextPath}/index.jsp">返回登录</a></td>
                </tr>

            </table>

        </form>
    </center>
</div>
</body>
</html>
