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
    <link rel="stylesheet" href="./static/css/base.css">
    <link rel="stylesheet" href="./static/css/common.css">
    <link rel="stylesheet" href="./static/css/index.css">
    <link rel="stylesheet" href="./static/css/book_detailed.css">
</head>

<body>
<!-- 快捷导航 -->
<div class="shortcut">
    <div class="wrapper">
        <ul>
        <c:if test="${user.power eq 1}">
            <li><a href="/eebookhouse/book_manage">添加图书</a></li>
        </c:if>

        <c:if test="${user.power eq 0}">
            <li><span>书本详情</span></li>
        </c:if>
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
</div>

<!-- banner -->
<div class="banner">
    <div class="wrapper">

        <div class="toplink"></div>
        <div class="downlink"></div>

        <c:if test="${!fn:contains(book.picture,'static/uploads/book/')}">
            <img src="./static/uploads/book/default.png" alt="">
        </c:if>
        <c:if test="${fn:contains(book.picture,'static/uploads/book/')}">
            <img src="${book.picture}" alt="">
        </c:if>

        <div class="leftfont">
            <h1>《${book.bookname}》</h1>
            <p>￥${book.price}</p>
            <p>库存：${book.remaining}</p>
        </div>

        <div class="rightfont">
            <div class="item">
                <div>类型：</div>
                <div>isbn：</div>
                <div>作者：</div>
                <div>出版社：</div>
            </div>
            <p>${book.type}</p>
            <p>${book.isbn}</p>
            <p>${book.writer}</p>
            <p>${book.publisher}</p>
            <p>
                ${book.intro}
            </p>
            <p>${book.date}</p>
        </div>

        <c:if test="${user.power eq 0}">
            <button class="toremark_upbook"
                    onclick="window.location.replace('/eebookhouse/remark?book_id=${book.id}')"
            >发表评论</button>
        </c:if>
        <c:if test="${user.power eq 1}">
            <button class="toremark_upbook"
                    onclick="window.location.replace('/eebookhouse/book_manage?book_id=${book.id}')"
            >修改图书</button>
        </c:if>

        <c:if test="${user.power eq 0}">
            <form action="order/add" method="post">
                <input type="submit" class="tocar_debook" value="加入购物车">
                <p class="amounttip">请输入购买数量：</p>
                <input type="hidden" name="book_id" value="${book.id}">
                <input type="text" name="buy_num" class="amount" value="1">
            </form>
        </c:if>
        <c:if test="${user.power eq 1}">
            <button class="tocar_debook"
                    onclick="deleteBook(${book.id});window.location.replace('/eebookhouse/book_list?type=${book.type}');"
            >删除图书</button>
        </c:if>
        <div class="booklogo"></div>

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
                <a href="#">配送与验收</a> |
                <a href="#">柯彦年</a> |
                <a href="#">庄盈</a> |
                <a href="#">19软件15班</a>
            </p>
            <p>
                zykyn@鹅鹅书屋
            </p>
        </div>
    </div>
</div>
</body>

<script>

    function deleteBook(id){
        let xhr = new XMLHttpRequest();
        xhr.open("GET","/eebookhouse/book/manage/delete?book_id=" + id);
        xhr.send();
    }

</script>

</html>
