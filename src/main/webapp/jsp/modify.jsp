<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/2
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改个人信息</title>
    <style>
        body{
            background: url(../img/11.jpg) ;
            /* 设置背景铺满 */
            background-repeat:no-repeat;
            background-size:100%;

        }
        form{
            /* 设置form大小 */
            width: 400px;
            height: 350px;

            /* 加个背景颜色 */
            background-color: #E1E9EF;

            /* 设置透明度 */
            opacity: 70%;

            text-align: center;
            /* 再设置内边距 使得内容更偏向于中央位置 */
            /* 上方，下方内边距为120px 与 左边与右边均为100px 按照逆时针 */
            /* 但是会撑大盒子 */
            padding: 20px 80px;
            padding-bottom: 120px;

            /* 设置文本文字的大小 */
            font-size: 18px;

            /* 添加圆角边框 */
            border-radius: 10px;

            /* 增加外边距 */
            /* 上下120px 然后左右居中 */
            margin: 35px auto;

        }

        .textinput{
            /* 设置宽高 */
            height: 40px;
            width: 280px;

            /* 设置内边距 */
            padding-left: 20px;

            /* 去除边框 */
            border: none;

            /* 设置背景颜色 */
            background: #F8F9F9;

            /* 设置字体大小 */
            font-size: 15px;


            /* 给文本框加上阴影 */
            box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.7), inset 0px 2px 5px #aaaaaa;

            /* 给文本框加上圆角边框 */
            border-radius: 5px;

            /* 给文本框中输入文字加上颜色 */
            color: saddlebrown;
        }

        /* 筛选input标签中 type为"submit"的 进行渲染*/
        input[type="submit"]{
            /* 设置宽高 */
            width: 90%;
            height: 40px;

            /* 内部文本居中 */
            text-align: center;

            /* 圆角边框 */
            border-radius: 5px;

            /* 设置字体 */
            font:16px "黑体";

            /* 设置背景颜色 */
            background-color: #3278da;

            margin-top: 20px;
            color: white;
            border: 1px solid #adadad;
            letter-spacing: 4px;
        }
        a {
            /* 去除下划线 */
            text-decoration: none;

        }

        a:hover {
            /* 悬空的时候有被选中的样子 出现下划线*/
            text-decoration: underline;
        }
        h2{
            color: rgb(29, 72, 146);
            letter-spacing: 4px;
        }
    </style>
</head>

<body>
<form action="${pageContext.request.contextPath}/user/update" method="post">
    <h2>修改个人信息</h2>
    <input type="hidden" name="uid" value="${user.id }"/>
    <p><span style="margin-right: 20px;">用户名:</span>
        <input id="userInput" name="userName" type="text" class="textinput" placeholder="请输入用户名" value="${user.username}" />
    </p>
    <p><span style="margin-right: 45px;">密码:</span><input id="pwdInput" name="password" placeholder="请输入密码" type="text" class="textinput" value="${user.password}" />
    </p>
    <p><span style="margin-right: 5px;">真实姓名:</span>
        <input id="nameInput" name="name" type="text" class="textinput" placeholder="请输入真实姓名" value="${user.name} "/>
    </p>
    <p><span style="margin-right: 45px;">邮箱:</span>
        <input id="emailInput" name="email" type="text" class="textinput" placeholder="请输入邮箱" value="${user.email} "/>
    </p>
    <p>
        <input type="submit" id="submitBtn" value="修改" />
    </p>


</form>
</body>
</html>