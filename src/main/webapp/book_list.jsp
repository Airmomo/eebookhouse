<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <link rel="stylesheet" href="static/css/temp.css">
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
                <li><a href="/eebookhouse/user">个人资料</a></li>
                <li><a href="/eebookhouse/logout">注销</a></li>
                <li><a href="/eebookhouse/order">我的订单</a></li>
            </c:if>
            <li><a href="/eebookhouse/index">返回首页</a></li>
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

    <div class="search">
        <form action="book_list" method="post">
            <input type="text" name="search" placeholder="搜一搜">
        </form>
        <!-- 定位 放大镜 -->
        <span></span>
    </div>

    <div class="car"></div>

</div>

<!-- banner -->
<div class="banner">
    <div class="wrapper">
        <div class="show">
            <ul>
                <!-- 遍历填入 -->
                <c:forEach items="${book_list}" var="item" varStatus="status">
                    <li>
                        <a href="/eebookhouse/book_detailed?book_id=${item.id}">
                            <c:if test="${item.remaining <= 20}">
                                <img src="static/uploads/book/hot.png" class="hot">
                            </c:if>
                            <c:if test="${!fn:contains(item.picture,'static/uploads/book/')}">
                                <img src="./static/uploads/book/default.png" alt="">
                            </c:if>
                            <c:if test="${fn:contains(item.picture,'static/uploads/book/')}">
                                <img src="${item.picture}" alt="">
                            </c:if>
                            <h3 class="name_h">《${item.bookname}》</h3>
                            <p class="price_p">￥${item.price}</p>
                            <p class="remain_p">库存：${item.remaining}</p>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>


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
                Airmomo@鹅鹅书屋
            </p>
        </div>
    </div>
</div>
</body>

</html>
