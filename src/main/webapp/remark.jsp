<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="./static/css/remark.css">
</head>

<body>
<!-- 快捷导航 -->
<div class="shortcut">
    <div class="wrapper">
        <span>评论区</span>
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

<!-- banner -->
<div class="banner">
    <div class="wrapper">

        <form action="remark/add" method="post">
            <div class="remark_put">
                <input type="hidden" name="book_id" value="${book_id}"/>
                <textarea type="text" name="remark"></textarea>
                <button type="submit">发表评论</button>
            </div>
        </form>

        <div class="remark_show">
            <ul>
                <!-- 遍历写入 -->
                <c:forEach items="${remark_list}" var="item" varStatus="status">
                <li class="remark_one">

                    <span class="username">${item.user.username}</span>

                    <span class="remark_text">${item.remark}</span>

                    <c:if test="${item.user.id == user.id}">
                        <button onclick="window.location.replace('/eebookhouse/remark/del?book_id=${book_id}&remark_id=${item.id}&remark_user_id=${item.user.id}')">删除</button>
                    </c:if>

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
                Airmomo&Kyn@鹅鹅书屋
            </p>
        </div>
    </div>
</div>
</body>

</html>