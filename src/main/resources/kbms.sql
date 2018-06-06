/*
Navicat MySQL Data Transfer

Source Server         : o2o
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : kbms

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-06-06 21:19:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `summary` varchar(500) DEFAULT NULL,
  `releasedate` datetime NOT NULL,
  `clickhit` int(11) DEFAULT NULL,
  `replyhit` int(11) DEFAULT NULL,
  `content` text NOT NULL,
  `keyword` varchar(100) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('39', '111', '111', '2018-05-22 23:15:16', '6', '0', '<p>111<br/></p>', '111', '12', '1');
INSERT INTO `t_article` VALUES ('40', '222测试', '222测试', '2018-05-22 23:18:27', '9', '0', '<p>222测试</p>', '222 测试', '40', '1');
INSERT INTO `t_article` VALUES ('41', '333测试', '测试', '2018-01-23 09:18:05', '5', '0', '<p>测试</p>', '333', '19', '1');
INSERT INTO `t_article` VALUES ('42', '444摘要', '444摘要', '2018-03-20 09:19:13', '4', '0', '<p>444摘要</p>', '444', '15', '1');
INSERT INTO `t_article` VALUES ('43', '555摘要', '555摘要内容', '2018-05-23 09:20:53', '1', '0', '<p>555摘要</p><p>内容</p>', '555', '22', '1');
INSERT INTO `t_article` VALUES ('44', '666测试摘要', '杀毒软件移动存储', '2018-04-21 09:21:57', '5', '0', '<p>杀毒软件</p><p>移动存储</p>', '杀毒', '25', '1');
INSERT INTO `t_article` VALUES ('45', '777', '777数字', '2018-05-23 09:25:39', '1', '0', '<p>777</p><p>数字</p>', '777', '26', '1');
INSERT INTO `t_article` VALUES ('46', '888', '当', '2018-04-23 09:26:36', '3', '0', '<p>当</p>', ' 888', '23', '1');
INSERT INTO `t_article` VALUES ('47', '999', '公安', '2018-03-23 09:27:00', '6', '0', '<p>公安</p>', '88', '20', '1');
INSERT INTO `t_article` VALUES ('48', '101010', '11111332', '2018-02-23 09:28:01', '1', '0', '<p>11111332</p>', '101010', '30', '1');
INSERT INTO `t_article` VALUES ('49', '测试', '测试测试', '2018-05-23 09:29:19', '6', '0', '<p>测试测试</p>', '测试', '37', '1');
INSERT INTO `t_article` VALUES ('50', '测试呢', '内容', '2018-05-23 10:30:30', '6', '0', '<p>内容</p>', '呢', '12', '1');
INSERT INTO `t_article` VALUES ('51', 'neig s', 'dg df ', '2018-05-23 10:55:45', '5', '0', '<p>dg df&nbsp;</p>', '3 32 ', '12', '1');
INSERT INTO `t_article` VALUES ('52', '重要', '个', '2018-05-23 10:59:45', '5', '0', '<p>个</p>', ' 枫', '40', '1');
INSERT INTO `t_article` VALUES ('53', '当过兵的海景房当过兵的海景房当过兵的海景房', '鬼地方个', '2018-05-23 11:02:35', '17', '1', '<p>鬼地方个</p>', '枫', '12', '1');
INSERT INTO `t_article` VALUES ('54', 'ege ', 'dfg ', '2018-05-23 11:07:16', '6', '1', '<p>dfg&nbsp;</p>', 'df ', '40', '1');
INSERT INTO `t_article` VALUES ('55', 'spring', '      Spring是一个开放源代码的设计层面框架，他解决的是业务逻辑层和其他各层的松耦合问题，因此它将面向接口的编程思想贯穿整个系统应用。Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EE full-sta', '2018-05-23 22:22:20', '25', '4', '<p>&nbsp; &nbsp; &nbsp;&nbsp;Spring是一个开放源代码的设计层面框架，他解决的是业务逻辑层和其他各层的松耦合问题，因此它将面向接口的编程思想贯穿整个系统应用。Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson创建。简单来说，Spring是一个分层的JavaSE/EE&nbsp;full-stack(一站式)&nbsp;轻量级开源框架。</p><p>&nbsp; &nbsp; &nbsp; &nbsp;你可能正在想“Spring不过是另外一个的framework”。当已经有许多开放源代码（和专有）J2EEframework时，我们为什么还需要Spring Framework？</p><p>Spring是独特的，因为若干个原因：</p><p>它定位的领域是许多其他流行的framework没有的。Spring致力于提供一种方法管理你的业务对象。</p><p>Spring是全面的和模块化的。Spring有分层的体系结构，这意味着你能选择使用它孤立的任何部分，它的架构仍然是内在稳定的。因此从你的学习中，你可得到最大的价值。例如，你可能选择仅仅使用Spring来简单化JDBC的使用，或用来管理所有的业务对象。</p><p>它的设计从底部帮助你编写易于测试的代码。Spring是用于测试驱动工程的理想的framework。</p><p>Spring对你的工程来说，它不需要一个以上的framework。Spring是潜在地一站式解决方案，定位于与典型应用相关的大部分基础结构。它也涉及到其他framework没有考虑到的内容。</p><p><span style=\"color: rgb(51, 51, 51); font-family: arial, 宋体, sans-serif; font-size: 14px; text-indent: 28px; background-color: rgb(255, 255, 255);\"></span></p><p>&nbsp; &nbsp; &nbsp; &nbsp; Rod Johnson在2002年编著的《Expert one on one J2EE design and development》一书中，对Java EE 系统框架臃肿、低效、脱离现实的种种现状提出了质疑，并积极寻求探索革新之道。以此书为指导思想，他编写了interface21框架，这是一个力图冲破J2EE传统开发的困境，从实际需求出发，着眼于轻便、灵巧，易于开发、测试和部署的轻量级开发框架。Spring框架即以interface21框架为基础，经过重新设计，并不断丰富其内涵，于2004年3月24日，发布了1.0正式版。同年他又推出了一部堪称经典的力作《Expert one-on-one J2EE Development without EJB》，该书在Java世界掀起了轩然大波，不断改变着Java开发者程序设计和开发的思考方式。在该书中，作者根据自己多年丰富的实践经验，对EJB的各种笨重臃肿的结构进行了逐一的分析和否定，并分别以简洁实用的方式替换之。至此一战功成，Rod Johnson成为一个改变Java世界的大师级人物。</p><p>传统J2EE应用的开发效率低，应用服务器厂商对各种技术的支持并没有真正统一，导致J2EE的应用没有真正实现Write Once及Run Anywhere的承诺。Spring作为开源的中间件，独立于各种应用服务器，甚至无须应用服务器的支持，也能提供应用服务器的功能，如声明式事务、事务处理等。</p><p>Spring致力于J2EE应用的各层的解决方案，而不是仅仅专注于某一层的方案。可以说Spring是企业应用开发的“一站式”选择，并贯穿表现层、业务层及持久层。然而，Spring并不想取代那些已有的框架，而是与它们无缝地整合。</p><p><br/></p>', 'spring', '14', '1');
INSERT INTO `t_article` VALUES ('56', 'mybatis', '       MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。iBATIS一词来源于“internet”和“abatis”的组', '2018-05-23 22:28:44', '48', '14', '<p>&nbsp; &nbsp; &nbsp; &nbsp;MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github。</p><p>iBATIS一词来源于“internet”和“abatis”的组合，是一个基于Java的持久层框架。iBATIS提供的持久层框架包括SQL Maps和Data Access Objects（DAOs）</p><ul class=\"basicInfo-block basicInfo-left list-paddingleft-2\" style=\"margin: 0px; padding: 0px; width: 395px; float: left;\"></ul><p>&nbsp; &nbsp; &nbsp; &nbsp;MyBatis&nbsp;[2]<a>&nbsp;</a>&nbsp;是支持普通 SQL查询，存储过程和高级映射的优秀持久层框架。MyBatis 消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索。MyBatis 使用简单的 XML或注解用于配置和原始映射，将接口和 Java 的POJOs（Plain Ordinary Java Objects，普通的 Java对象）映射成数据库中的记录。</p><p>每个MyBatis应用程序主要都是使用SqlSessionFactory实例的，一个SqlSessionFactory实例可以通过SqlSessionFactoryBuilder获得。SqlSessionFactoryBuilder可以从一个xml配置文件或者一个预定义的配置类的实例获得。</p><p>&nbsp; &nbsp; &nbsp; &nbsp; 用xml文件构建SqlSessionFactory实例是非常简单的事情。推荐在这个配置中使用类路径资源（classpath resource)，但你可以使用任何Reader实例，包括用文件路径或file://开头的url创建的实例。MyBatis有一个实用类----Resources，它有很多方法，可以方便地从类路径及其它位置加载资源。</p><p><a class=\"lemma-anchor para-title\" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a><a class=\"lemma-anchor \" style=\"color: rgb(19, 110, 194); position: absolute; top: -50px;\"></a></p><p><br/></p>', 'mybatis', '30', '1');
INSERT INTO `t_article` VALUES ('57', 'fdgsigfs ', 'df df', '2018-05-26 06:02:39', '0', '0', '<p>df df<img src=\"/kbms/images/6cf389b1-9b60-4a73-b46b-9660f911c8df.jpg\" alt=\"realName\"/></p>', 'fg ', '24', '1');
INSERT INTO `t_article` VALUES ('58', 'fdbb ', 'efg  ', '2018-05-26 06:12:34', '0', '0', '<p>efg&nbsp;&nbsp;<img src=\"/kbms/images/c6404178-939b-442b-bc09-a023d58deb0c.jpg\" title=\"\" alt=\"realName\"/></p>', 'df ', '12', '2');
INSERT INTO `t_article` VALUES ('62', 'fghr ', '新建 Microsoft Office Word 文档', '2018-05-26 20:12:27', '13', '0', '<p><img src=\"/kbms/images/39641c68-4fd5-4add-9638-5f6d6b706ec6.jpg\" title=\"\" alt=\"realName\"/></p><p style=\"line-height: 16px;\"><img src=\"/kbms/static/ueditor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/kbms/images/063e7d21-c250-4a10-bc70-e3bec4e3fff0.docx\" title=\"新建 Microsoft Office Word 文档\">新建 Microsoft Office Word 文档</a></p><p><br/></p>', 'regeg ', '12', '1');
INSERT INTO `t_article` VALUES ('63', 'hgfh ', 'realName', '2018-05-26 21:39:46', '9', '1', '<p style=\"line-height: 16px;\"><img src=\"/kbms/static/ueditor/dialogs/attachment/fileTypeImages/icon_ppt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/kbms/images/674cd25d-c267-4375-a02a-ece7f0e8bc36.pptx\" title=\"realName\">realName</a></p><p><br/></p>', 'fg ', '15', '1');
INSERT INTO `t_article` VALUES ('64', '测试题目', '测试摘要', '2018-06-02 10:27:49', '3', '0', '测试内容', '测试关键字', '12', '2');
INSERT INTO `t_article` VALUES ('65', '测试题目', '测试摘要', '2018-06-02 10:31:39', '1', '0', '测试内容', '测试关键字', '12', '2');
INSERT INTO `t_article` VALUES ('66', '测试题目23222', '测试内容324244', '2018-06-02 10:32:43', '7', '1', '<p>测试内容324244</p>', '测试关键字', '12', '2');
INSERT INTO `t_article` VALUES ('67', 'f fb f ', 'gdf d ', '2018-06-05 11:05:39', '3', '0', '<p>gdf d&nbsp;</p>', 'f f', '14', '1');

-- ----------------------------
-- Table structure for t_article_type
-- ----------------------------
DROP TABLE IF EXISTS `t_article_type`;
CREATE TABLE `t_article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  `articlecount` int(11) DEFAULT '0',
  `level` int(11) DEFAULT '0',
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_type
-- ----------------------------
INSERT INTO `t_article_type` VALUES ('1', '日常工作', '1', '0', '0', null);
INSERT INTO `t_article_type` VALUES ('4', '立项工作', '2', '0', '0', null);
INSERT INTO `t_article_type` VALUES ('7', '运维工作', '1', '0', '1', '1');
INSERT INTO `t_article_type` VALUES ('8', '软件开发', '2', '0', '1', '1');
INSERT INTO `t_article_type` VALUES ('9', '基础工作', '3', '0', '1', '1');
INSERT INTO `t_article_type` VALUES ('10', '网络管理', '4', '0', '1', '1');
INSERT INTO `t_article_type` VALUES ('11', '安全管理', '5', '0', '1', '1');
INSERT INTO `t_article_type` VALUES ('12', '基础运维', '1', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('14', '实时同步数据监控', '3', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('15', '数据库管理', '4', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('16', '服务器管理', '5', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('17', '虚拟化平台管理', '6', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('18', 'DNS管理', '7', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('19', '互联网站（网上办事大厅）', '8', '0', '2', '7');
INSERT INTO `t_article_type` VALUES ('20', '公安信息专网', '1', '0', '2', '10');
INSERT INTO `t_article_type` VALUES ('21', '内外网接入平台管理', '2', '0', '2', '10');
INSERT INTO `t_article_type` VALUES ('22', '党政内网管理', '3', '0', '2', '10');
INSERT INTO `t_article_type` VALUES ('23', '党政外网管理', '4', '0', '2', '10');
INSERT INTO `t_article_type` VALUES ('24', '“一机两用”管理', '1', '0', '2', '11');
INSERT INTO `t_article_type` VALUES ('25', '杀毒软件、移动存储介质管理', '2', '0', '2', '11');
INSERT INTO `t_article_type` VALUES ('26', '数字证书管理', '3', '0', '2', '11');
INSERT INTO `t_article_type` VALUES ('27', '信息系统共享查询核实工作', '4', '0', '2', '11');
INSERT INTO `t_article_type` VALUES ('28', '机房管理', '1', '0', '2', '9');
INSERT INTO `t_article_type` VALUES ('29', '系统文档管理', '2', '0', '2', '9');
INSERT INTO `t_article_type` VALUES ('30', '固定资产管理', '3', '0', '2', '9');
INSERT INTO `t_article_type` VALUES ('31', '2018立项工作', '1', '0', '1', '4');
INSERT INTO `t_article_type` VALUES ('32', '数据中心项目', '1', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('33', '移动警务项目', '2', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('34', '建用机制项目', '3', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('35', '信息化应用竞赛', '4', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('36', '重点人员管控', '5', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('37', '最多跑一次', '6', '0', '2', '31');
INSERT INTO `t_article_type` VALUES ('40', '重要信息系统运维', '2', '0', '2', '7');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userip` varchar(50) DEFAULT NULL,
  `content` text,
  `articleid` int(11) DEFAULT NULL,
  `commentdate` datetime DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '127.0.0.1', '测试', '56', '2018-05-25 10:21:56', '1');
INSERT INTO `t_comment` VALUES ('2', '127.0.0.1', '换手机', '56', '2018-05-25 10:39:19', '1');
INSERT INTO `t_comment` VALUES ('4', '127.0.0.1', '按时素很多hi大幅度破大家绝对 ', '56', '2018-05-25 10:39:54', '1');
INSERT INTO `t_comment` VALUES ('5', '127.0.0.1', '得分的的', '56', '2018-05-25 10:40:06', '1');
INSERT INTO `t_comment` VALUES ('6', '127.0.0.1', '大乱斗读后感u', '56', '2018-05-25 10:40:20', '1');
INSERT INTO `t_comment` VALUES ('7', '127.0.0.1', '电饭锅都会给对方给', '56', '2018-05-25 10:40:28', '1');
INSERT INTO `t_comment` VALUES ('8', '127.0.0.1', '八神疾风的个', '56', '2018-05-25 10:40:41', '1');
INSERT INTO `t_comment` VALUES ('9', '127.0.0.1', '一通百通', '56', '2018-05-25 10:42:03', '1');
INSERT INTO `t_comment` VALUES ('10', '127.0.0.1', '而而', '56', '2018-05-25 10:42:12', '1');
INSERT INTO `t_comment` VALUES ('11', '127.0.0.1', '固定电饭锅大概大概', '56', '2018-05-25 10:42:20', '1');
INSERT INTO `t_comment` VALUES ('15', '127.0.0.1', 'fh f ', '56', '2018-05-25 20:36:02', '1');
INSERT INTO `t_comment` VALUES ('16', '127.0.0.1', 'gj ', '53', '2018-05-25 20:37:08', '1');
INSERT INTO `t_comment` VALUES ('17', '127.0.0.1', 'sggd dd', '55', '2018-05-25 21:10:45', '1');
INSERT INTO `t_comment` VALUES ('18', '127.0.0.1', 'dfh d', '56', '2018-05-25 21:12:37', '1');
INSERT INTO `t_comment` VALUES ('19', '127.0.0.1', '的深V的', '55', '2018-05-25 21:46:03', '1');
INSERT INTO `t_comment` VALUES ('20', '127.0.0.1', 'bf ', '54', '2018-05-26 04:55:29', '1');
INSERT INTO `t_comment` VALUES ('21', '127.0.0.1', 'v ', '59', '2018-05-26 06:14:08', '1');
INSERT INTO `t_comment` VALUES ('22', '127.0.0.1', 'dgd f', '63', '2018-05-27 10:10:27', '1');
INSERT INTO `t_comment` VALUES ('23', '127.0.0.1', 'fgefe ', '66', '2018-06-05 11:03:58', '1');

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkname` varchar(50) DEFAULT NULL,
  `linkurl` varchar(200) DEFAULT NULL,
  `orderno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_link
-- ----------------------------
INSERT INTO `t_link` VALUES ('4', '百度', 'https://www.baidu.com/', '1');
INSERT INTO `t_link` VALUES ('5', '新浪', 'http://www.sina.com.cn/', '2');
INSERT INTO `t_link` VALUES ('6', '优酷', 'http://www.youku.com/', '3');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `profile` text,
  `nickname` varchar(50) DEFAULT NULL,
  `imagename` varchar(100) DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `manage` int(1) DEFAULT '0',
  `role` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zsga', '123', null, null, null, null, '1', '12,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,32,33,34,35,36,37,40');
INSERT INTO `t_user` VALUES ('2', 'kxc', '321', null, null, null, null, '0', '12,14');
INSERT INTO `t_user` VALUES ('3', 'admin', '123', null, null, null, null, '0', '14,15,16,17,18');
