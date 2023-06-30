
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
    }
    h1 {
        color: #333;
        text-align: center;
        margin-top: 30px;
    }
    form {
        width: 70%;
        margin: 30px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .top1 {
        margin-bottom: 20px;
    }
    .top2 {
        margin-bottom: 10px;
    }
    label {
        font-weight: bold;
    }
    .tt {
        margin-bottom: 15px;
    }
    .t {
        margin-bottom: 10px;
    }
    .d {
        font-weight: normal;
    }
    .dd {
        width: 100%;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }
    .jie {
        width: 100%;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 3px;
        background-color: #fff;
    }
    .ee {
        margin-right: 5px;
    }
    button {
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:disabled {
        background-color: #ccc;
    }
    .bottom {
        align-items: center;
    }
    .look {
        background-color: #f6d962; /* 设置背景颜色 */
        color: #030303; /* 设置文本颜色 */
        padding: 10px 20px; /* 设置内边距 */
        font-size: 16px; /* 设置字体大小 */
        border: none; /* 去除边框 */
        border-radius: 5px; /* 设置圆角 */
        cursor: pointer; /* 鼠标悬停时显示手型光标 */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
        width: 150px;
        height: 50px;
    }
    .look:hover {
        background-color: #ef8252; /* 鼠标悬停时的背景颜色 */
    }
</style>
<body>
    <h1>运动会日程安排</h1>
    <form>
        <div class="top1">
            <div class="top2">
                <label>基本信息</label>
            </div>
            <div class="tt">
                <label class="t">运动会名称<span class="d">：</span></label>
                <div class="ttt">
                    <input id="name" type="text" class="dd" placeholder="请输入运动会名称" value="厦门大学嘉庚学院秋季运动会" disabled/>
                </div>
                <label class="t">地点<span class="d">：</span></label>
                <div class="ttt">
                    <input id="place" type="text" class="dd" placeholder="请输入地点" value="厦门大学嘉庚学院北区田径场" disabled/>
                </div>
            </div>

            <div class="tt">
                <label class="t">持续时间：</label>
                <div class="dd">
                    <span>从</span>
                    <span><input id="starttime" type="date" class="" placeholder="请选择运动会开始日期" value="2023-09-10" disabled/></span>
                    <span>开始，</span>
                </div>
                <div class="dd">
                    <span>持续到</span>
                    <span><input id="endtime" type="date" class="" placeholder="请选择运动会结束日期" value="2023-09-13" disabled/></span>
                    <span>结束</span>
                </div>
                <label class="t">届数</label>
                <div class="dd">
                    <select id="jie" class="jie" disabled>
                        <option value="2022届">2022届</option>
                        <option value="2023届">2023届</option>
                        <option selected value="2024届">2024届</option>
                    </select>
                </div>
            </div>
            <div class="tt">
                <label class="t">参赛单位<span class="d">：</span></label>
                <div class="ttt">
                    <input id="post" type="text" class="dd" placeholder="请输入参赛单位" value="各学院、各研究院" disabled/>
                </div>
                <label class="">报名方法<span class="">：</span></label>
                <div class="ttt">
                    <input id="methon" type="text" class="dd" placeholder="请输入报名方法" value="各单位从体育教学部网页上（http://tyjxb.xmu.edu.cn）体育赛事一栏下载各单位的报名软件报名，请先认真阅读报名软件使用说明，报名后的报名软件请在2022年10月17日（星期一）17:00以前发到体育部邮箱内（tyjs@xmu.edu.cn），10月19日（周三）17:00后可上网下载并校对各单位报名情况，若有误请于10月21日(周五)上午11:00前发Email：tyjs@xmu.edu.cn注明需修改内容（单位名称、组别、性别、所报项目、联系人、联系电话等）。咨询电话：2187193付老师" disabled/>
                </div>
            </div>
            <div class="t">
                <label class="tt">注意事项<span class="d">：</span></label>
                <div class="ttt">
                    <input id="iii" type="text" class="dd" placeholder="请输入注意事项" value="略" disabled/>
                </div>
            </div>
            <div class="t">
                <label class="tt">比赛项目<span class="d">：</span></label>
                <div class="ttt">
                    <div class="e">
                        <input type="checkbox" id="tt1" name="title" value="男子100米" class="ee" checked disabled>
                        <label class="" for="tt1">男子100米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt2" name="title" value="男子400米" class="ee" checked disabled>
                        <label class="" for="tt2">男子400米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt3" name="title" value="男子1000米" class="ee" checked disabled>
                        <label class="" for="tt3">男子1000米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt4" name="title" value="女子100米" class="ee" checked disabled>
                        <label class="" for="tt4">女子100米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt5" name="title" value="女子400米" class="ee" checked disabled>
                        <label class="" for="tt5">女子400米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt6" name="title" value="女子800米" class="ee" checked disabled>
                        <label class="" for="tt6">女子800米</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt7" name="title" value="跳高" class="ee" checked disabled>
                        <label class="" for="tt7">跳高</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt8" name="title" value="跳远" class="ee" checked disabled>
                        <label class="" for="tt8">跳远</label>
                    </div>
                    <div class="e">
                        <input type="checkbox" id="tt9" name="title" value="三级跳" class="ee" checked disabled>
                        <label class="" for="tt9">三级跳</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="bottom" style="width: 20%;">
            <button id="submit" onclick="submitResume()" type="button" class="look">查看完整信息</button>
        </div>
    </form>
</body>
</html>
