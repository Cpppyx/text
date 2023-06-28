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
  .top {
    font-size: 24px;
    font-weight: bold;
    color: #333;
    background-color: #B3C0D1;
    padding: 10px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  }
</style>

<body>
<div id="app">
  <el-container>
    <!-- <el-header style="text-align: right; font-size: 12px"></el-header> -->
    <el-header style="background-color:rgb(149, 181, 211) ;">
      <span class="top">运动会管理系统</span>
      <el-dropdown style="margin-left: 80%;">
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item><a href="${pageContext.request.contextPath}/jsp/mine.jsp">个人中心</a></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span class="login"><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></span>
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
          <template slot="title"><i class="el-icon-message"></i>运动会项目管理</template>
          <el-menu-item-group>

            <el-menu-item index="1-1" onclick="change1()">运动会安排表</el-menu-item>
          </el-menu-item-group>

          <el-menu-item index="1-2" onclick="change4()">比赛项目规则</el-menu-item>
          </el-menu-item-group>


        </el-submenu>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-menu"></i>运动员信息管理</template>
          <el-menu-item-group>

            <el-menu-item index="2-1"  onclick="change2()">基本信息</el-menu-item>
          </el-menu-item-group>

        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-setting"></i>运动员参赛相关</template>
          <el-menu-item-group>
            <el-menu-item index="3-1" onclick="change3()">成绩录入</el-menu-item>
          </el-menu-item-group>

        </el-submenu>
      </el-menu>
    </el-aside>
    <el-main>
      <iframe id="son" src="${pageContext.request.contextPath}/jsp/mine.jsp" scrolling="auto" frameborder="0" width="1000px" height="450px"></iframe>
    </el-main>
  </el-container>

</div>
<script type="text/javascript">

  function change1() {
    var objs=document.querySelector("#son");
    objs.src="${pageContext.request.contextPath}/jsp/sports_index.jsp"
  }
  function change2() {
    var objs=document.querySelector("#son");
    objs.src="${pageContext.request.contextPath}/dormitoryinfo/list1?username=${sessionScope.user.username}";
  }
  function change3() {
    var objs=document.querySelector("#son");
    objs.src="${pageContext.request.contextPath}/dormrepair/list?username=${sessionScope.user.username}";
  }
  function change4() {
    var objs=document.querySelector("#son");
    objs.src="${pageContext.request.contextPath}/jsp/rule.jsp"
  }
</script>
<script>
  export default {
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
</script>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue@2/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
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
