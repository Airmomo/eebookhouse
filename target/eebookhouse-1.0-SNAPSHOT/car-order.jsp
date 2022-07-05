<%@ page import="com.eebookhouse.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="./static/css/base.css">
    <link rel="stylesheet" href="./static/css/common.css">
    <link rel="stylesheet" href="./static/css/index.css">
    <link rel="stylesheet" href="./static/css/car.css">
</head>


<body>
<!-- 快捷导航 -->
<div class="shortcut">
    <div class="wrapper">

        <span>我的购物车</span>

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
</div>


<div class="banner">
    <div class="wrapper">

        <!-- 购物车状态 -->
        <div class="cart-title">我的购物车</div>

        <!-- 订单状态 -->
        <!-- <div class="cart-title">我的订单</div> -->

        <table class="cart-table">
            <tr>
                <th width="60">
                    <span class="cart-all" onclick="checkall()">全选</span>
                </th>
                <th width="60">书籍图片</th>
                <th width="60">书籍名称</th>
                <th width="60">书籍简介</th>
                <th width="60">单价</th>
                <th width="100">数量</th>
                <th width="40">小计</th>
                <th width="40">操作</th>
            </tr>
            <form id="unchecked_form" action="order/checked" method="post">
                <!-- 遍历写入 -->
                <c:forEach items="${order_list_unchecked}" var="item" varStatus="status">
                    <tr class="cart-item">
                        <td>
                            <input type="checkbox" class="cart-check" name="order_id" value="${item.id}"/>
                        </td>
                        <td class="cart-txt-left">
                            <img src=${item.book.picture}>
                        </td>
                        <td>
                            <span class="cart-name"
                                  onclick="window.location.replace('/eebookhouse/book_detailed?book_id=${item.book.id}');"
                            >${item.book.bookname}</span>
                        </td>
                        <td>
                            <span class="cart-intro">${item.book.intro}</span>
                        </td>
                        <td>
                            <span class="cart-price" id="firstMoney">${item.book.price}</span>
                        </td>
                        <td>
                            <!--<span class="cart-reduce" id="second-delete" onclick="subNum(${item.id})">-</span>-->
                            <span id="firstNum" class="cart-num">${item.number}</span>
                            <!--<span class="cart-add" id="second-add" onclick="addNum(${item.id})">+</span>-->
                        </td>
                        <td>

                            <span class="cart-subtotal" id="firstAllMoney">
                                <fmt:formatNumber type="number" value="${item.book.price * item.number}"
                                                  maxFractionDigits="2"/>
                            </span>
                        </td>
                        <td>
                            <span class="cart-del"
                                  onclick="window.location.replace('/eebookhouse/order/delete?order_id='+${item.id});">
                                删除
                            </span>
                        </td>
                    </tr>
                </c:forEach>
                <c:forEach items="${order_list_checked}" var="item" varStatus="status">
                    <tr class="cart-item">
                        <td>
                            <span class="cart-subtotal">已结算订单</span>
                        </td>
                        <td class="cart-txt-left">
                            <img src=${item.book.picture}>
                        </td>
                        <td>
                            <span class="cart-name">${item.book.bookname}</span>
                        </td>
                        <td>
                            <span class="cart-intro">${item.book.intro}</span>
                        </td>
                        <td>
                            <span class="cart-price" id="secondMoney">${item.book.price}</span>
                        </td>
                        <td>
                            <!--<span class="cart-reduce" id="second-delete" onclick="subNum(${item.id})">-</span>-->
                            <span id="secondNum" class="cart-num">${item.number}</span>
                            <!--<span class="cart-add" id="second-add" onclick="addNum(${item.id})">+</span>-->
                        </td>
                        <td>

                            <span class="cart-subtotal" id="secondAllMoney">
                                <fmt:formatNumber type="number" value="${item.book.price * item.number}"
                                                  maxFractionDigits="2"/>
                            </span>
                        </td>
                        <td>
                            <span class="cart-del"
                                  onclick="window.location.replace('/eebookhouse/order/delete?order_id='+${item.id});">
                                删除
                            </span>
                        </td>
                    </tr>
                </c:forEach>
            </form>
        </table>
    </div>
    <div class="bottom2">
        <!--
        <div class="cart-bottom">
            <div class="d1">已确认的订单总价：<span>0</span></div>
        </div>
        -->

        <!-- 购物车状态 -->
        <input type="submit" class="d2" form="unchecked_form" value="结算订单"/>

        <!-- 订单状态 -->
        <!-- <button class="d2">提交结算</button> -->

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

<!--
<script>

    function flush() {
        window.location.replace('/eebookhouse/order');
    }

    function subNum(e) {
        let xhr = new XMLHttpRequest();
        xhr.open('PUT', '/eebookhouse/order?order_id=' + e + "&status=0");
        xhr.send();
        flush();
    }

    function addNum(e) {
        let xhr = new XMLHttpRequest();
        xhr.open('PUT', '/eebookhouse/order?order_id=' + e + "&status=1");
        xhr.send();
        flush();
    }

    function delOrder(e) {
        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', '/eebookhouse/order?order_id=' + e);
        xhr.send();
        flush();
    }

</script>
-->

</body>
</html>
