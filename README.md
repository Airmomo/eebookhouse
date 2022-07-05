# eebookhouse — 鹅鹅书屋
Simple book store for studying Java Web — 鹅鹅书屋
# 项目介绍
鹅鹅书屋是一个简单的图书管理网站，开发的主要目的是为了巩固和实践学习的JavaWeb知识。
## 网站功能
- 基础功能：用户注册、用户登录、个人中心、查看个人信息、修改个人信息
- 用户权限：查阅图书、购买图书、管理购物车、结算购物车、查看订单
- 管理员权限：添加图书信息、修改图书信息、删除图书信息
## 项目技术栈
- 前端：JSP+jstl、HTML+CSS、JavaScript
- 后端：Tomcat+Mybatis
## 项目成员及
- Airmomo：本人，主要负责后端开发，JSP中jstl的编写，数据库存储设计和项目测试。
- Kyn：我心上人，主要负责前端开发，页面布局、内容，项目需求设计，概念设计和项目测试。
# 部署项目（本地部署）
## 环境准备
本项目基于Maven进行构建，所以大多数依赖都不需要自己导入，可以通过文件pom.xml来查看和管理本项目所用到的依赖，项目启动后Maven会自动下载和添加配置的依赖。
你需要准备的只有：
- IntelliJ IDEA 2021.2.4
- Navicat for MySQL 11.1.13
- Tomcat 10.0.21
- MySQL 5.7.36
对于上述环境的下载和安装在这里不加以赘述，请自行下载和查阅相关教程文档。
## 导入数据库
- 打开Navicat for MySQL
```
    创建数据库ee_book_store
    导入数据库文件ee_book_store.sql
```
## 导入项目
- 在IDEA中导入并打开本项目
- 为使得访问该项目的URL为http://localhost:8080/eebookhouse/
- 需要在IDEA中添加安装好的Tomcat，并配置Tomcat中Deployment菜单下的Application context为
```
    /eebookhouse
```
## 配置数据库链接
- 本项目已经利用Mybatis完成了对JDBC的相关实现
- 所以只需要通过修改文件/resources/mybatis-config.xml来更改为本地的数据库信息即可
```xml
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/ee_book_store?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false"/>
                <property name="username" value="{MySQL.user}"/>
                <property name="password" value="{MySQL.password}"/>
            </dataSource>
        </environment>
    </environments>
```
## 启动项目
- 安装并配置好Tomcat、Maven和Mybatis之后，直接Run启动，成功启动后访问：
```
    http://localhost:8080/eebookhouse/
```
