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
    <title>鹅鹅书屋-登录</title>
    <link rel="shortcut" href="favicon.ico" type="image/x-icon">
    <!-- 外链式样式表后写的生效。index生效 -->
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/login.css">
</head>

<body>
<!-- 导航 -->
<div class="shortcut">
    <div class="wrapper">
        <span>正在登录...</span>
    </div>
</div>

<!-- 头部 -->
<div class="header wrapper">
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

        <!-- left鹅鹅 -->
        <img src="static/uploads/banner_login.png" alt="">

        <!-- right登录框 -->
        <div class="login">

            <img src="static/images/loginfont.png" alt="">

            <form action="login" method="post">

                <span class="uspan"></span>
                <input type="text" name="username" class="user">

                <span class="pspan"></span>
                <input type="password" name="password" class="pwd">

                <!-- 登录按钮 -->
                <input type="submit" value="登&nbsp;&nbsp;&nbsp;录" class="butt" />
                <!-- <a href="#">登&nbsp;&nbsp;&nbsp;录</a> -->

                <!-- 记住密码 -->
                <input type="checkbox" name="remember-me" class="rem" />自动登录

                <!-- 输入错误tip -->
                <c:if test="${failure}">
                    <p class="alltip">用户名不存在或密码输入错误</p>
                </c:if>
                <!-- 用户名为空tip -->
                <p class="nametip"></p>

                <!-- 密码为空tip -->
                <p class="passwordtip"></p>
            </form>

            <!-- 转注册 -->
            <a href="/eebookhouse/register" class="go">没有账号？注册!</a>

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

<script>
    var formEle = document.querySelector('form');
    var nameinput = document.querySelector('input[name="username"]');
    var passwordinput = document.querySelector('input[name="password"]');
    var pnameTip = document.querySelector('.nametip');
    var ppasswordTip = document.querySelector('.passwordtip');

    function checkUserNameNull() {
        if (nameinput.value == '') {
            pnameTip.innerHTML = '用户名不能为空';
            return false;
        } else {
            pnameTip.innerHTML = '';
            return true;
        }
    }

    // 失去焦点判空
    nameinput.onblur = function() {
        checkUserNameNull();
    }

    function checkPasswordNull() {
        if (passwordinput.value == '') {
            ppasswordTip.innerHTML = '密码不能为空';
            return false;
        } else {
            ppasswordTip.innerHTML = '';
            return true;
        }
    }

    // 失去焦点判空
    passwordinput.onblur = function() {
        checkPasswordNull();
    }
</script>
</body>

</html>