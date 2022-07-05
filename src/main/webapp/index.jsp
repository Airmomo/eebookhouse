<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="鹅鹅书屋官网，致力于打造全球最全的书籍、正版图书购物平台">
    <meta name="keywords" content="鹅鹅书屋,文学,历史,管理,科技,哲学,热销">
    <title>鹅鹅书屋-正版、优质、速达！</title>
    <link rel="shortcut" href="favicon.ico" type="image/x-icon">
    <!-- 外链式样式表后写的生效。index生效 -->
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/index.css">
</head>

<body>
<!-- 快捷导航 -->
<div class="shortcut">
    <div class="wrapper">
        <ul>
            <!-- 未登录状态下 -->
            <c:if test="${user == null}">
                <li><a href="/eebookhouse/login">请先登录</a></li>
                <li><a href="/eebookhouse/register">免费注册</a></li>
            </c:if>
            <!-- 已登录状态下 -->
            <c:if test="${user != null}">
                <li><a href="/eebookhouse/userinfo">个人资料</a></li>
                <li><a href="/eebookhouse/logout">注销</a></li>
                <c:if test="${user.power eq 1}">
                    <li><a href="/eebookhouse/book_manage">添加图书</a></li>
                </c:if>
                <c:if test="${user.power eq 0}">
                    <li><a href="/eebookhouse/order">我的订单</a></li>
                </c:if>
            </c:if>
            <!-- <li><a href="#">会员中心</a></li>
            <li><a href="#">帮助中心</a></li>
            <li><a href="#">在线客服</a></li>
            <li><a href="#"><span></span>手机版</a></li> -->
        </ul>
    </div>
</div>

<!-- 头部 -->
<div class="header wrapper">
    <!-- 快捷创建div： .logo+.nav+.search+.car -->
    <div class="logo">
        <!-- h1>a 回车 -->
        <h1>
            <a href="/eebookhouse/index">鹅鹅书屋</a>
        </h1>
    </div>
    <div class="nav">
        <!-- ul>a 回车 -->
        <ul>
            <li><a href="/eebookhouse/index">首页</a></li>
            <li><a href="/eebookhouse/book_list?type=文学">文学</a></li>
            <li><a href="/eebookhouse/book_list?type=历史">历史</a></li>
            <li><a href="/eebookhouse/book_list?type=管理">管理</a></li>
            <li><a href="/eebookhouse/book_list?type=科技">科技</a></li>
            <li><a href="/eebookhouse/book_list?type=哲学">哲学</a></li>
            <li><a href="/eebookhouse/book_list?type=法律">法律</a></li>
            <li><a href="/eebookhouse/book_list?type=经济">经济</a></li>
            <li><a href="/eebookhouse/book_list?type=医学">医学</a></li>
        </ul>
    </div>
    <div class="search">
        <form action="book_list" method="post">
            <input type="text" name="search" placeholder="搜一搜">
        </form>
        <!-- 定位 放大镜 -->
        <span></span>
    </div>
    <div class="car">
        <!-- <span>2</span> -->
    </div>
</div>

<!-- banner -->
<div class="banner">
    <div class="wrapper">
        <!-- li加图 -->
        <ul>
            <li>
                <a href="/eebookhouse/index"><img src="static/uploads/banner_1%20.png" alt=""></a>
            </li>
        </ul>

        <!--侧导航 -->
        <div class="aside">
            <ul>
                <li><a href="/eebookhouse/index">推荐<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=文学">文学<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=历史">历史<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=管理">管理<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=科技">科技<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=哲学">哲学<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=法律">法律<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=经济">经济<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/book_list?type=医学">医学<span>热销 书籍</span></a></li>
                <li><a href="/eebookhouse/index">热销<span>热销 书籍</span></a></li>
            </ul>
        </div>

        <!-- 箭头 -->
        <!-- prev ：上一页 -->
        <a href="#" class="prev"></a>
        <!-- prev ：下一页 -->
        <a href="#" class="next"></a>

        <!-- 圆点：当前状态：current / active -->
        <ol>
            <li></li>
            <li></li>
            <li class="current"></li>
            <li></li>
            <li></li>
        </ol>

    </div>
</div>

<!-- 版权区域 -->
<div class="footer">
    <div class="wrapper">
        <div class="top">
            <ul>
                <li>
                    <!-- 通过伪元素添加标签实现精灵图 -->
                    <span>价格亲民</span>
                </li>
                <li>
                    <span>书质精美</span>
                </li>
                <li>
                    <span>物流快捷</span>
                </li>
            </ul>
        </div>
        <!-- bottom注意不能写成关键字buttom -->
        <div class="bottom">
            <p>
                <a href="#">关于我们</a> |
                <a href="#">帮助中心</a> |
                <a href="#">售后服务</a> |
                <a href="#">配送与验收</a>
            </p>
            <p>
                Airmomo&Kyn@鹅鹅书屋
            </p>
        </div>
    </div>
</div>
</body>

</html>