<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="./static/css/admin.css">
</head>

<body>
<!-- 快捷导航 -->
<div class="shortcut">
    <div class="wrapper">
        <span>添加图书</span>
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

        <!-- 表头 -->
        <div class="left_item">
            <div>图书名称：</div>
            <div>图书作者：</div>
            <div>图书类型：</div>
            <div>图书isbn：</div>
            <div>图书出版社：</div>
        </div>

        <div class="right_item">
            <div>图书简介：</div>
            <div>图书价格：</div>
            <div>图书库存：</div>
            <div>图书图片：</div>
            <div>出版日期：</div>
        </div>

        <!-- 内容 -->

        <form action="book/manage/add" method="post">
            <div class="left_textbox">
                <input type="hidden" disabled="disabled" name="book_id" value="自动生成">
                <input type="text" placeholder="请输入图书名称" name="bookname" value="">
                <br>
                <input type="text" placeholder="请输入图书作者" name="writer" value="${book.writer}">
                <br>
                <select name="type" required>
                    <option value="文学">文学</option>
                    <option value="历史">历史</option>
                    <option value="管理">管理</option>
                    <option value="科技">科技</option>
                    <option value="哲学">哲学</option>
                    <option value="法律">法律</option>
                    <option value="经济">经济</option>
                    <option value="医学">医学</option>
                </select>
                <br>
                <input type="text" placeholder="请输入图书isbn" name="isbn" value="">
                <br>
                <input type="text" placeholder="请输入图书出版社" name="publisher" value="">
            </div>

            <div class="right_textbox">
                <input type="text" placeholder="请输入图书简介" name="intro" value="">
                <br>
                <input type="text" placeholder="请输入图书价格" name="price" value="">
                <br>
                <input type="text" placeholder="请输入图书库存" name="remaining" value="">
                <br>
                <input type="text" placeholder="请输入图书图片" name="picture" value="">
                <br>
                <input type="date" name="date" value="">

            </div>

            <input type="submit" class="toadd" value="添加图书">

        </form>

        <c:if test="${failure}">
            <p class="addtip">添加失败|图书可能已存在|请检查数据格式且不能为空</p>
        </c:if>

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
