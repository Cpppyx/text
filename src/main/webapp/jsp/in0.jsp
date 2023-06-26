<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/2
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!--引入 element-ui 的样式，-->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 必须先引入vue，  后使用element-ui -->
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
    <!-- 引入element 的组件库-->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>

    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>



<body>
<div id="app">
    <el-container>
        <!-- <el-header style="text-align: right; font-size: 12px"></el-header> -->
        <el-header style="background-color:rgb(149, 181, 211) ;">
            <span>嘉庚宿舍管理系统</span>
            <el-dropdown style="margin-left: 80%;">
                <i class="el-icon-setting" style="margin-right: 15px"></i>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item onclick="exit()"><a href="${pageContext.request.contextPath}/index.jsp">退出</a></el-dropdown-item>

                </el-dropdown-menu>
            </el-dropdown>
            <span>${sessionScope.user.username}</span>
        </el-header>
    </el-container>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu
                    default-active="1-1"
                    class="el-menu-vertical-demo"
                    @open="handleOpen"
                    @close="handleClose"
                    :collapse="isCollapse"
                    :router="true">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>用户信息管理</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="1-1" onclick="change1()">个人信息管理 </el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                        <el-menu-item  onclick="change2()">系统用户管理</el-menu-item>
                    </el-menu-item-group>

                </el-submenu>
                <el-submenu index="2">
                    <template slot="title"><i class="el-icon-menu"></i>宿舍信息管理</template>
                    <el-menu-item-group>
                        <template slot="title">分组一</template>
                        <el-menu-item index="2-1" onclick="change3()">宿舍人员管理</el-menu-item>
                    </el-menu-item-group>
                    <el-menu-item-group title="分组2">
                    </el-menu-item-group>
                    <el-submenu index="2-4">
                        <template slot="title" >宿舍信息</template>
                        <el-menu-item index="2-4-1"  onclick="change4()">全部宿舍信息</el-menu-item>
                        <el-menu-item index="2-4-2">北区宿舍信息</el-menu-item>
                        <el-menu-item index="2-4-3">中区宿舍信息</el-menu-item>
                        <el-menu-item index="2-4-4">南区宿舍信息</el-menu-item>
                    </el-submenu>
                </el-submenu>
<%--                <el-submenu index="3">--%>
<%--                    <template slot="title"><i class="el-icon-setting"></i>日常信息管理</template>--%>
<%--                    <el-menu-item-group>--%>
<%--                        <el-menu-item index="3-1">公告</el-menu-item>--%>
<%--                    </el-menu-item-group>--%>

<%--                </el-submenu>--%>
            </el-menu>
        </el-aside>
        <el-main id="main">

            <iframe id="son" src="${pageContext.request.contextPath}/jsp/mine.jsp" scrolling="auto" frameborder="0" width="1000px" height="450px"></iframe>
        </el-main>
    </el-container>

</div>

</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue@2/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script type="text/javascript">

    function change1() {
        var objs=document.querySelector("#son");
        objs.src="${pageContext.request.contextPath}/jsp/mine.jsp"
    }
    function change2() {
        var objs=document.querySelector("#son");
        objs.src="${pageContext.request.contextPath}/user/list";

    }
    function change3() {
        var objs=document.querySelector("#son");
        objs.src="${pageContext.request.contextPath}/dormitoryinfo/list";

    }
    function change4() {
        var objs=document.querySelector("#son");
        objs.src="${pageContext.request.contextPath}/dormitory/list";

    }
    function exit(){
        if(confirm("您确定要退出吗？")){
            //删除前端浏览器存储的用户信息
            window.sessionStorage.removeItem("user");
            //向服务器发送请求，销毁session
            $.get("index",function(res){
                //跳转到登录页面
                window.location.href="index.jsp";
            });
        }
    }
</script>
<script>
    var Main = {
        data() {
            const item = {
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            };
            return {
                tableData: Array(20).fill(item)
            }
        }
    };
    var Ctor = Vue.extend(Main)
    new Ctor().$mount('#app')
</script>
</html>
