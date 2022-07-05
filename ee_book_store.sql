/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50736
Source Host           : localhost:3306
Source Database       : ee_book_store

Target Server Type    : MYSQL
Target Server Version : 50736
File Encoding         : 65001

Date: 2022-06-15 20:09:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `isbn` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `writer` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `publisher` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `intro` text CHARACTER SET utf8,
  `price` decimal(10,2) DEFAULT NULL,
  `remaining` int(6) DEFAULT NULL,
  `picture` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bookname` (`bookname`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('1', '法律职业的选择', '法律', '9787302564546', '刘哲', '清华大学出版社', '本书是职业选择指南；本书不只是职业选择指南。本书极具实操性以及工具性，能够为广大法学专人士提供极具价值的职业参考信息。', '37.00', '45', 'static/uploads/book/law/1.png', '2018-03-15');
INSERT INTO `bookinfo` VALUES ('2', '法律常识一本通', '法律', '9787516225165', '法律常识一本通编写组', '中国民主法制出版社', '懂你的维权小宝典，近200个真实案例，涵盖近千个法律小常识，搭配百姓法治宝典APP，免费分享海量普法资源，保障每个人的合法权益不受侵犯。', '9.80', '34', 'static/uploads/book/law/2.png', '2020-03-20');
INSERT INTO `bookinfo` VALUES ('3', '民法典与日常生活', '法律', '9787208163386', '彭诚信', '上海人民出版社', '新老版本随机发货，新荣获“2020年度中国好书” ，崔建远、季卫东、沈国明、刘士国联合推荐，新老版本随机发货。', '34.00', '56', 'static/uploads/book/law/3.png', '2021-04-18');
INSERT INTO `bookinfo` VALUES ('4', '刑法学讲义', '法律', '9787222193727', '罗翔', '云南人民出版社', '高能案例+法理思考，性骚扰、考试作弊、网络诽谤，掌握基本法律常识，冷静解决复杂问题，守护生命、身体和财产。', '34.00', '50', 'static/uploads/book/law/4.png', '2021-09-29');
INSERT INTO `bookinfo` VALUES ('5', '领导力21法则', '管理', '9787549620197', '约翰C.马克斯维尔 ', '文汇出版社', '《福布斯》《纽约时报》《商业周刊》《华尔街日报》、美国Amazon经典畅销书！一切组织和个人的荣耀与衰落，都源自领导力！读客熊猫君出品。', '22.50', '33', 'static/uploads/book/manage/5.png', '2017-04-13');
INSERT INTO `bookinfo` VALUES ('6', '极简市场营销', '管理', '9787559646590', '胡超', '北京联合出版有限公司', '做好市场营销，这本就够了！源于世界经典理论的完整体系、经过市场实战锤炼的落地打法，实战派市场营销专家20多年超50亿元的理论积累与实践心得。', '34.00', '50', 'static/uploads/book/manage/6.png', '2020-12-16');
INSERT INTO `bookinfo` VALUES ('7', '良性增长', '管理', '9787111599203', '拉姆查兰', '机械工业出版社', '经济下行，企业如何实现2位数的增长？如何探寻第二曲线？全球管理咨询大师拉姆?查兰写给所有企业的增长指南。陈春花、樊登、茅忠群、秦玉峰、王赛联袂推荐。', '37.40', '34', 'static/uploads/book/manage/7.png', '2020-09-25');
INSERT INTO `bookinfo` VALUES ('8', '格局', '管理', '9787521708554', '吴军', '中信出版社', '硅谷投资人、国家文津图书奖得主吴军博士自《见识》《态度》之后人生进阶的第三部作品；5步方法论、7大方面快速提升格局，让你获重复的成功和可叠加式的进步。', '29.50', '34', 'static/uploads/book/manage/8.png', '2021-04-17');
INSERT INTO `bookinfo` VALUES ('9', '分析与思考', '经济', '9787208164321', '黄奇帆', '上海人民出版社', '一部解读中国经济的著作：从资本市场到货币制度，从房地产开发到对外开放……重大问题都可以在这里获得新知。', '62.60', '50', 'static/uploads/book/economy/9.png', '2019-06-11');
INSERT INTO `bookinfo` VALUES ('10', '贫穷的本质', '经济', '9787508687216', '阿比吉特.班纳吉', '中信出版社', '奇葩说席瑞推荐。探究穷人为什么无法摆脱贫穷的颠覆之作，诺贝尔经济学奖得主罗伯特.默顿·索洛、阿马蒂亚.森、《魔鬼经济学》作者列维特，《金融时报》《经济学人》《福布斯》等推荐。', '27.50', '45', 'static/uploads/book/economy/10.png', '2020-03-11');
INSERT INTO `bookinfo` VALUES ('11', '非对称风险', '经济', '9787508698472', '纳西姆·尼古拉斯·塔勒布', '中信出版社', '黑天鹅遍布的世界中，反脆弱的关键是认清非对称风险；坚持风险共担，是应对不确定性的核心原则。', '32.20', '34', 'static/uploads/book/economy/11.png', '2021-05-18');
INSERT INTO `bookinfo` VALUES ('12', '随机漫步的傻瓜', '经济', '9787521700589', '纳西姆·尼古拉斯·塔勒布', '中信出版社', '《随机漫步的傻瓜》是塔勒布不确定系列中的一本，此书主要讨论随机性对于人们生活的巨大影响，许多看上去合理的解释在随机性面前不堪一击。', '33.80', '50', 'static/uploads/book/economy/12.png', '2020-07-16');
INSERT INTO `bookinfo` VALUES ('13', '视觉SLAM十四讲', '科技', '9787121369421', '高翔', '电子工业出版社', '高博个性签名限量！SLAM华语原创首著升级版！彩色插图|更多实例|更深内容|更完善的工程项目|更易懂的表达。余凯谭平等业内大咖力荐。', '81.00', '55', 'static/uploads/book/science/13.png', '2020-03-20');
INSERT INTO `bookinfo` VALUES ('14', '机器学习实战', '科技', '9787111665977', '奥雷利安', '机械工业出版社', '“美亚”AI+神经网络+CV三大畅销榜首图书，基于TensorFlow 2和新版Scikit-Learn全面升级，内容增加近一倍！Keras之父推荐，从实践出发，手把手教你从零开始搭建起一个神经网络。', '73.00', '33', 'static/uploads/book/science/14.png', '2021-07-01');
INSERT INTO `bookinfo` VALUES ('15', '强化学习', '科技', '9787121295164', '理查德·桑顿', '电子工业出版社', '强化学习领域奠基性经典著作。人工智能行业的强化学习圣经。', '126.00', '45', 'static/uploads/book/science/15.png', '2021-06-30');
INSERT INTO `bookinfo` VALUES ('16', '神经网络与深度学习', '科技', '9787111649687', '邱锡鹏 ', '机械工业出版社', '系统整理深度学习的知识体系，由浅入深地阐述深度学习的原理、模型以及方法。更适合中文读者的深度学习图书。', '70.60', '50', 'static/uploads/book/science/16.png', '2020-05-20');
INSERT INTO `bookinfo` VALUES ('17', '埃及四千年', '历史', '9787533954482', '乔安·弗莱彻', '浙江文艺出版社', '上市7天即告售罄！当当4.23书香节读者*爱的人文社科类榜首图书！BBC古埃及历史纪录片原著主宰世界历史进程的宏大史诗《出版人周刊》《科克斯书评》2016年度图书《华盛顿邮报》等30家知名媒体联名推荐', '59.00', '32', 'static/uploads/book/history/17.png', '2020-02-08');
INSERT INTO `bookinfo` VALUES ('18', '史记', '历史', '9787807616412', '韩兆琦 ', '岳麓书社', '陈寅恪先生再传弟子、中国《史记》研究会名誉会长、中国《史记》研究大家韩兆琦先生潜心注释，精装全本。', '63.90', '55', 'static/uploads/book/history/18.png', '2020-06-18');
INSERT INTO `bookinfo` VALUES ('19', '秦俑两千年', '历史', '9787550034723', '爱德华 · 伯曼 白马时光 ', '百花洲文艺出版社', '一带一路重要文化输出成果，陕西省文物局和秦始皇帝陵博物馆严谨审定，珍贵照片及研究新发现首次对外公布。', '44.00', '20', 'static/uploads/book/history/19.png', '2019-06-06');
INSERT INTO `bookinfo` VALUES ('20', '考古通史', '历史', '9787201164151', '保罗·巴恩 ', '天津人民出版社', '15位全球一线考古学家联袂编写，陈星灿、许宏等国内一线考古工作者倾情推荐。领略400万年人类历史，见证世界考古学伟大成就。', '215.20', '45', 'static/uploads/book/history/20.png', '2021-05-21');
INSERT INTO `bookinfo` VALUES ('21', '狂人笔记', '文学', '9787114173042', '苏见祈', '人民交通出版社', '代作家宁芩的传世巨著。全书共30万字，创作时间跨度长达二十年，其深刻的思想及狂人的呐喊震惊世人，让人过目难忘。', '31.20', '56', 'static/uploads/book/literature/21.png', '2021-12-02');
INSERT INTO `bookinfo` VALUES ('22', '觅食记', '文学', '9787301324561', '谢冕', '北京大学出版社', '一场与美食的精彩人生邂逅，一位九十岁学者的美食告白。', '54.20', '20', 'static/uploads/book/literature/22.png', '2021-07-27');
INSERT INTO `bookinfo` VALUES ('23', '想念地坛', '文学', '9787545566512', '史铁生', '天地出版社', '如果觉得人生太难，就读一读史铁生。', '29.90', '32', 'static/uploads/book/literature/23.png', '2020-08-26');
INSERT INTO `bookinfo` VALUES ('24', '忽有山河大地', '文学', '9787570224135', '胡烟', '长江文艺出版社', '中国文人画二十六家，一百多幅古画，全方位呈现文人画家的精神世界。', '28.40', '33', 'static/uploads/book/literature/24.png', '2019-03-29');
INSERT INTO `bookinfo` VALUES ('25', '影像读片从入门到精通系列', '医学', '9787122161345', '王书轩 ', '化学工业出版社', '中国医科大学一附院放射科教授执笔，病种齐全、病例典型，高清图片呈现，强化读片思路和技巧。', '55.20', '45', 'static/uploads/book/medical/25.png', '2018-08-05');
INSERT INTO `bookinfo` VALUES ('26', '生命的反转', '医学', '9787557689452', '李文丰', '天津科学技术出版社', '一本书讲透35种急重症常识。惊心动魄的生死反转，催人泪下的医者仁心。一线重症科医生亲述：这里是你从未接触的生死场。丁香园、知乎签约医学科普作者@李鸿政医生作品。', '26.10', '45', 'static/uploads/book/medical/26.png', '2020-08-01');
INSERT INTO `bookinfo` VALUES ('27', '黄帝内针讲义', '医学', '9787513255585', '刘力红', '中国中医药出版社', '黄帝内针 （简称内针）是源自《内经》的针法，其传承绵密久远，至真海杨师，始公之于众。内针之法不离阴阳，其理则直系于中，故而其方针或上或下、或左或右，每每皆逢其原。', '24.50', '50', 'static/uploads/book/medical/27.png', '2020-06-25');
INSERT INTO `bookinfo` VALUES ('28', '心超笔记', '医学', '9787030537737', '杨好意', '科学出版社', '为心脏超声医师、心内外科医师同仁奉献二十年心得之作，解读心超世界的精彩，从这本笔记开始。《心超笔记》随书附赠336段视频，读文读图读视频，全彩印刷。', '74.50', '34', 'static/uploads/book/medical/28.png', '2018-05-22');
INSERT INTO `bookinfo` VALUES ('29', '五百年来王阳明', '哲学', '9787208146792', '郦波', '上海人民出版社', '百家讲坛主讲人郦波新作，阳明心学入门，就读这一本。', '30.40', '35', 'static/uploads/book/philosophy/29.png', '2017-07-26');
INSERT INTO `bookinfo` VALUES ('30', '诗人哲学家', '哲学', '9787208163768', '周国平', '上海人民出版社', '周国平主编，刘东杜小真等12位名家导读，影响一代人的经典。', '39.90', '36', 'static/uploads/book/philosophy/30.png', '2020-06-23');
INSERT INTO `bookinfo` VALUES ('31', '庄子的世界', '哲学', '9787101139341', '王景琳', '中华书局', '2019年度中国好书。扫清文本的语义迷雾，探索先贤的精神世界，追寻经典的思想道路。中华书局出版。', '57.40', '43', 'static/uploads/book/philosophy/31.png', '2020-02-04');
INSERT INTO `bookinfo` VALUES ('32', '存在与时间', '哲学', '9787100186445', '海德格尔', '商务印书馆', '历经几次修改完善，当代著名哲学家陈嘉映、王庆节精心打磨。哲学家海德格尔代表作、成名作。基本思想——存在就是时间，此书的主要任务在于追问并解答两千年西方哲学史上遗忘了的根本问题——“存在”问题。', '44.00', '34', 'static/uploads/book/philosophy/32.png', '2020-07-22');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `number` int(20) DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `postcode` varchar(25) CHARACTER SET utf8 DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_book_id_foreign_key` (`bookid`),
  KEY `order_user_id_foreign_key` (`userid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `bookinfo` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for rebate
-- ----------------------------
DROP TABLE IF EXISTS `rebate`;
CREATE TABLE `rebate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(10) DEFAULT NULL,
  `rebateRate` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rebate
-- ----------------------------

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(10) NOT NULL,
  `userid` int(10) NOT NULL,
  `grade` tinyint(5) DEFAULT NULL,
  `remark` text CHARACTER SET utf8,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `remark_book_id_foreign_key` (`bookid`),
  KEY `remark_user_id_foreign_key` (`userid`),
  CONSTRAINT `remark_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `bookinfo` (`id`),
  CONSTRAINT `remark_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of remark
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8 NOT NULL,
  `userpass` varchar(32) CHARACTER SET utf8 NOT NULL,
  `email` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `postcode` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `level` int(10) DEFAULT NULL,
  `power` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_unique` (`username`) USING HASH,
  UNIQUE KEY `email_unique` (`email`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', '123456', 'admin@qq.com', 'adminHome', '123456', '0', '1');
