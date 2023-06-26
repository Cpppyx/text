<%--
  Created by IntelliJ IDEA.
  User: 陈健怡
  Date: 2023/6/6
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Vue模版语法应用</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-4.4/css/bootstrap.min.css" />
    <script type="text/javascript" src="bootstrap-4.4/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-4.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/com.css" />
    <link rel="stylesheet" href="iconfont/iconfont.css" />
    <style type="text/css">
        #carInfoDetails img {

        }
        .fi{
            display: block;
        }
    </style>
</head>

<body>

<div class="container mt-5">
    <!--BootStrap table start-->
    <table class="table table-bordered table-hover table-striped">
        <thead class="bg-primary text-white text-center">
        <tr>
            <th scope="col">编号</th>
            <th scope="col">品牌</th>
            <th scope="col">型号</th>
            <th scope="col">价格</th>
            <th scope="col-auto">销售门店</th>
            <th scope="col">管理</th>
        </tr>
        </thead>
        <tbody id="carslist">
        <tr v-for="m in carsdata" onclick="show()"  >
            <model :showModel="showModel"></model>
            <th scope="row" class="text-center">{{m.id}}</th>
            <td class="text-center" v-html="m.brand"></td>
            <td v-html="m.model"></td>
            <td v-html="m.price"></td>
            <td class="col-auto">{{m.seller}}</td>
            <td class="text-center">
						<span v-bind:carinfo="JSON.stringify(m)" class="badge badge-primary pr-2 iconfont icon-shezhi"
                              style="cursor: pointer;" data-toggle="modal" data-target="#carInfoDetails">&nbsp;&nbsp;编辑</span>
                <span :carinfo="JSON.stringify(m)" class="ml-3 badge badge-danger pr-2 iconfont icon-shanchu"
                      style="cursor: pointer;">&nbsp;&nbsp;删除</span>
            </td>
        </tr>
        </tbody>
    </table>



    <!--BootStrap table end-->
</div>

<!-- 汽车信息模态框 -->
<div class="modal fade" id="carInfoDetails" tabindex="-1" aria-labelledby="carInfoDetailsLabel" aria-hidden="true" v-show="showModel" >
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header bg-primary">
                <h5 class="modal-title text-white" id="carInfoDetailsLabel">汽车详细信息预览</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row" id="carinfo">
                    <div class="col-7">
                        <img class="img-fluid" :src="c.img">
                    </div>
                    <div class="col-5">
                        <ul>
                            <li class="mt-2" v-for="(value,key,index) in c">
                                {{key}}:{{value}}
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">加入购物车</button>
            </div>
        </div>
    </div>
</div>

<!--汽车信息数据-->
<script type="text/javascript">
    var cars = [{
        id: 1,
        brand: '奔驰',
        model: 'GLC260',
        price: 9.90,
        seller: '平安车管家汽车专营店',
        img: '../examp/imgCars/glc260.jpg'
    },
        {
            id: 2,
            brand: '奔驰',
            model: 'GLB200',
            price: 9.90,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/glb200.jpg'
        },
        {
            id: 3,
            brand: '奔驰',
            model: '威霆7座精英版',
            price: 990,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/weiting7.jpg'
        },
        {
            id: 4,
            brand: '奔驰',
            model: 'A200L运动版',
            price: 9.90,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/a200.png'
        },
        {
            id: 5,
            brand: '奔驰',
            model: 'GLE450',
            price: 880,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/gle450.jpg'
        },
        {
            id: 6,
            brand: '奔驰',
            model: 'C200L时尚型运动版',
            price: 9.90,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/c200l.png'
        },
        {
            id: 7,
            brand: '奔驰',
            model: 'C260L运动版',
            price: 9.90,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/c260.jpg'
        },
        {
            id: 8,
            brand: '奔驰',
            model: 'G63美规2021款',
            price: 5000,
            seller: '平安车管家汽车专营店',
            img: '../examp/imgCars/g63.jpg'
        },
        {
            id: 9,
            brand: '宝马',
            model: '创新X1/X2',
            price: 5000,
            seller: 'BMW官方旗舰店',
            img: '../examp/imgCars/bmwx1.jpg'
        },
        {
            id: 10,
            brand: '宝马',
            model: '全新BMW5系',
            price: 4239,
            seller: 'BMW官方旗舰店',
            img: '../examp/imgCars/bmw5.jpg'
        },
        {
            id: 11,
            brand: '宝马',
            model: '全新BMW6系GT',
            price: 5000,
            seller: 'BMW官方旗舰店',
            img: '../examp/imgCars/bmwx6.jpg'
        },
        {
            id: 12,
            brand: '宝马',
            model: '全新BMW4系敞篷轿跑车',
            price: 4688,
            seller: 'BMW官方旗舰店',
            img: '../examp/imgCars/bmwjp4.jpg'
        }
    ];
</script>

<!--引用vue.js-->
<script src="js/vue.global.prod.js"></script>

<script type="text/javascript">
    // function show() {

    //             var obj1 = document.getElementById("carInfoDetails");
    //             //显示对象用 obj.style.display = "block";
    //             //隐藏对象用 obj.style.display = "none"
    //             obj1.style.display="none";

    // alert("1");

    //         }

    //单个汽车的数据
    let car = {};
    const vmcar = Vue.createApp({
        data() { return { c: car } }
    }).mount("#carInfoDetails");

    //创建vue实例并挂载
    const vm = Vue.createApp({
        data() { return { carsdata: cars} },
        methods: {
            editorCar() {
                car = JSON.parse(event.target.getAttribute("carinfo"));

                vmcar.$data.c = car;

                $("#carInfoDetails").model("show");

            },


        }



    }).mount("#carslist");


</script>


<!--************以下两行代码切勿删除或修改**********-->
<link rel="stylesheet" type="text/css" href="../task/task.css" />
<script type="text/javascript" src="../task/lesson.js"></script>

</body>

</html>
