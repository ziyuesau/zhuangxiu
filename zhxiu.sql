/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : 127.0.0.1:3306
Source Database       : zhxiu

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2018-05-14 15:30:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `user_type` tinyint(4) DEFAULT '0' COMMENT '用户类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `realname` varchar(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'admin@qq.com1', '13612345671', '1', '1', '2018-01-11 11:11:11', 'admin', null);
INSERT INTO `sys_user` VALUES ('2', '11', 'df024c73b442d2139c90c12129a5755e3b90ba60fa239412e4826cd365941afe', 'I1z1JvBLdBslg1kEYPUe', 'ww@q.com', '1345678901', '1', '3', '2018-05-12 01:32:18', '用户', '40');
INSERT INTO `sys_user` VALUES ('3', '12', '23c10c22aef33a76570c110113d0e14fb9e62dc4035ca1e74fe3dc02984065b8', 'C7IefAbBmeUMaIuJFp6n', '22@qq.com', '1345678902', '1', '2', '2018-05-12 01:39:36', '公司', '39');
INSERT INTO `sys_user` VALUES ('4', 'tt', '6473c5a908601dc84567e68f132f7b7b2fa414676b1b318e059a9fa4633ac226', 'N1ZrM5PfHzZtUPYZsXi8', '333@qq.com', '13456789095', '1', '2', '2018-05-14 12:31:32', '张三', null);
INSERT INTO `sys_user` VALUES ('5', 'uu', '21db5612c61592d45dc2b90fff1d6b433c45cc3d71e3a04a0d52559e1a85304e', 'txQ7WSSVPEs0UvXOB2v1', 'ed@qq.com', '13456789062', '1', '3', '2018-05-14 12:32:39', '装潢公司', null);
INSERT INTO `sys_user` VALUES ('6', 'ee', '0edbcf3e843c44e5ca73f298ebe6c6851e54895e35f13791251fa47c3f3f7a5c', '3T6Apg0mwaPjZtqcxyJX', 'ee@qq.com', '1345678908', '1', '3', '2018-05-14 12:38:08', 'lisi', null);
INSERT INTO `sys_user` VALUES ('7', 'jj', 'd4d6be761340f1300476d14e5399e38dd468380e604763ba7f395c5756cfc550', 'GkoHf58ESPHCBwfCC3zt', '33@qq.com', '1345678909', '1', '3', '2018-05-14 13:39:23', '李四', null);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='材料种类';

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('40', '瓷砖');
INSERT INTO `t_category` VALUES ('41', '地板');
INSERT INTO `t_category` VALUES ('42', '壁纸');
INSERT INTO `t_category` VALUES ('43', '门');
INSERT INTO `t_category` VALUES ('44', '卫浴');

-- ----------------------------
-- Table structure for t_geju
-- ----------------------------
DROP TABLE IF EXISTS `t_geju`;
CREATE TABLE `t_geju` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '格局',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='格局';

-- ----------------------------
-- Records of t_geju
-- ----------------------------
INSERT INTO `t_geju` VALUES ('1', '一厅一卫一厨');
INSERT INTO `t_geju` VALUES ('2', '两厅一卫一厨');

-- ----------------------------
-- Table structure for t_material
-- ----------------------------
DROP TABLE IF EXISTS `t_material`;
CREATE TABLE `t_material` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '材料名称',
  `type_id` int(11) DEFAULT NULL COMMENT '材料种类',
  `brand` varchar(255) DEFAULT NULL COMMENT '材料品牌',
  `spec` varchar(255) DEFAULT NULL COMMENT '材料规格',
  `description` varchar(255) DEFAULT NULL COMMENT '材料介绍',
  `price` varchar(20) DEFAULT NULL COMMENT '单价',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='材料';

-- ----------------------------
-- Records of t_material
-- ----------------------------
INSERT INTO `t_material` VALUES ('40', '瓷砖', '40', '品牌1', '22*30', '介绍', '5', '平方');
INSERT INTO `t_material` VALUES ('41', '地板2', '41', '品牌2', '2*4', '介绍地板2', '3', '平方');
INSERT INTO `t_material` VALUES ('42', '壁纸', '42', '品牌2', '2*4', '介绍地板2', '3', '平方');
INSERT INTO `t_material` VALUES ('43', '门', '43', '品牌2', '2*4', '介绍地板2', '3', '平方');
INSERT INTO `t_material` VALUES ('44', '卫浴', '44', '品牌2', '2*4', '介绍地板2', '3', '平方');
INSERT INTO `t_material` VALUES ('45', '瓷砖55', '40', '品牌1', '33', '444', '12', '平方');
INSERT INTO `t_material` VALUES ('46', 'ees', '44', '品牌3', 'ds', 'yyyyyu', '2', '根');

-- ----------------------------
-- Table structure for t_people
-- ----------------------------
DROP TABLE IF EXISTS `t_people`;
CREATE TABLE `t_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '种类',
  `price` varchar(20) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='人工成本';

-- ----------------------------
-- Records of t_people
-- ----------------------------
INSERT INTO `t_people` VALUES ('40', '水工', '20');
INSERT INTO `t_people` VALUES ('41', '电工', '10');
INSERT INTO `t_people` VALUES ('42', '油工', '10');
INSERT INTO `t_people` VALUES ('43', '木工', '10');
INSERT INTO `t_people` VALUES ('44', '瓦工', '10');

-- ----------------------------
-- Table structure for t_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE `t_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `size` varchar(255) DEFAULT NULL COMMENT '面积',
  `geju` int(11) DEFAULT NULL COMMENT '格局',
  `dangci` int(11) DEFAULT NULL COMMENT '档次',
  `style` int(11) DEFAULT NULL COMMENT '风格',
  `description` text COMMENT '方案介绍',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `price` varchar(20) DEFAULT NULL COMMENT '预计费用',
  `yongshi` varchar(20) DEFAULT NULL COMMENT '预计用时',
  `user_id` int(11) DEFAULT NULL COMMENT '公司',
  `size_begin` int(11) DEFAULT NULL,
  `size_end` int(11) DEFAULT NULL,
  `cizhuan` int(11) DEFAULT NULL COMMENT '瓷砖',
  `diban` int(11) DEFAULT NULL COMMENT '地板',
  `bizhi` int(11) DEFAULT NULL COMMENT '壁纸',
  `men` int(11) DEFAULT NULL COMMENT '门',
  `weiyu` int(11) DEFAULT NULL COMMENT '卫浴',
  `people1` varchar(11) DEFAULT NULL COMMENT '水工',
  `people2` varchar(11) DEFAULT NULL COMMENT '电工',
  `people3` varchar(11) DEFAULT NULL COMMENT '油工',
  `people4` varchar(11) DEFAULT NULL COMMENT '木工',
  `people5` varchar(11) DEFAULT NULL COMMENT '水工',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='装修方案';

-- ----------------------------
-- Records of t_plan
-- ----------------------------
INSERT INTO `t_plan` VALUES ('1', '80-90', '1', '2', '1', '基本配置:瓷砖:瓷砖地板:地板2壁纸:壁纸门:门卫浴:卫浴', null, '300', '8-9', '3', '80', '90', '40', '41', '42', '43', '44', '1', '2', '3', '4', '5');
INSERT INTO `t_plan` VALUES ('2', '90-100', '1', '3', '2', '基本配置:瓷砖:瓷砖地板:地板2壁纸:壁纸门:门卫浴:卫浴', null, '500', '9-10', '3', '90', '100', '40', '41', '42', '43', '44', '1', '1', '1', '1', '1');
INSERT INTO `t_plan` VALUES ('3', '100-120', '2', '3', '2', '基本配置:瓷砖:瓷砖地板:地板2壁纸:壁纸门:门卫浴:卫浴', null, '600', '9-10', '3', '100', '120', '40', '41', '42', '43', '44', '2', '2', '2', '2', '2');
