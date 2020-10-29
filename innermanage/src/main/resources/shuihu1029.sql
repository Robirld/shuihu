/*
 Navicat MySQL Data Transfer

 Source Server         : mysql-connect-01
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : shuihu

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 29/10/2020 20:19:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `login_name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT '0：男；1：女',
  `phone_num` varchar(14) DEFAULT NULL,
  `vip` tinyint(3) unsigned NOT NULL COMMENT '0：普通；1：黄金；2：钻石',
  `age` int(11) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `account_name` (`login_name`) USING BTREE,
  KEY `phone_num` (`phone_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES (00000000001, '李博', 'libo', '12345687', 0, '18862112950', 0, 27, '程序员');
INSERT INTO `customer` VALUES (00000000002, '零零', 'dada', '123456', 1, '18862111223', 0, 44, '其他');
INSERT INTO `customer` VALUES (00000000003, '李波', 'lala', '123456', 0, '18862112950', 0, 22, '暂无');
COMMIT;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `id` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '菜id',
  `dish_name` varchar(50) NOT NULL COMMENT '菜名',
  `category` tinyint(3) unsigned DEFAULT NULL COMMENT '类别',
  `origin_price` decimal(10,2) DEFAULT NULL COMMENT '优惠前价格',
  `current_price` decimal(10,2) NOT NULL COMMENT '当前价格',
  `unit` varchar(10) DEFAULT NULL COMMENT '计价单位',
  `quantity` int(10) unsigned DEFAULT NULL COMMENT '当前剩余数量',
  `img_path` varchar(150) DEFAULT NULL COMMENT '图片路径',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` bit(1) NOT NULL COMMENT '0代表没删除',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `create_at` (`create_at`) USING BTREE,
  KEY `current_price` (`current_price`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dish
-- ----------------------------
BEGIN;
INSERT INTO `dish` VALUES (00000001, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img1.jpg', '2020-10-27 18:23:23', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000002, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img2.jpg', '2020-10-27 18:23:29', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000003, '烤鸡翅', 2, 20.00, 10.00, '把', 100, '/img/img3.jpg', '2020-10-28 16:44:36', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000004, '烤鸡翅', 2, 20.00, 10.00, '把', 100, '/img/img4.jpg', '2020-10-28 16:44:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000005, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img5.jpg', '2020-10-27 18:23:38', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000006, '烤鸡翅', 3, 20.00, 10.00, '把', 100, '/img/img6.jpg', '2020-10-28 16:44:42', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000007, '烤鸡翅', 3, 20.00, 10.00, '把', 100, '/img/img7.jpg', '2020-10-28 16:44:44', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000008, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img1.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000009, '烤鸡翅', 3, 20.00, 10.00, '把', 100, '/img/img2.jpg', '2020-10-28 16:44:45', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000010, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img3.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000011, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img4.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000012, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img5.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000013, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img6.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
INSERT INTO `dish` VALUES (00000014, '烤鸡翅', 1, 20.00, 10.00, '把', 100, '/img/img7.jpg', '2020-10-27 20:26:40', b'0', '撒白色的空间和反馈就是v考虑分手了看见了广阔的肌肤老顾客都反馈靓女开朗的女看到你发v尽可能的房间看v就开始对女款蓝色奈拉蒂考了加夫里什加夫里什浪费');
COMMIT;

-- ----------------------------
-- Table structure for parentorder
-- ----------------------------
DROP TABLE IF EXISTS `parentorder`;
CREATE TABLE `parentorder` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned zerofill NOT NULL,
  `total_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `actual_pay` decimal(10,2) unsigned DEFAULT '0.00',
  `payoff` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为未还清',
  `create_at` date NOT NULL,
  `pay_at` datetime DEFAULT NULL,
  `cancel_cause` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `customer_id` (`customer_id`) USING BTREE,
  CONSTRAINT `parentorder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES (00000000001, 'sys:edit:role', '添加角色', '/sys/role/edit', NULL);
INSERT INTO `sys_permission` VALUES (00000000002, 'sys:edit:permission', '添加权限', '/sys/permission/edit', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (00000000001, 'admin');
INSERT INTO `sys_role` VALUES (00000000002, 'common');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) unsigned zerofill NOT NULL,
  `permission_id` int(11) unsigned zerofill NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE,
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_permission` VALUES (00000000001, 00000000001);
INSERT INTO `sys_role_permission` VALUES (00000000001, 00000000002);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `real_name` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(14) NOT NULL,
  `gender` bit(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `add_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `login_name` (`user_name`) USING HASH,
  UNIQUE KEY `phone_num` (`phone`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (00000002, 'admin', '$2a$10$CRq9Bn7hMGZFa1ttobXb.uOXWOz1xmgnBQ/8kVbuhEy6BupIZK7hi', '管理员', 20, '13345679876', b'0', 'asdadsfdsfs', '2020-10-29 18:55:30');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) unsigned zerofill NOT NULL,
  `role_id` int(11) unsigned zerofill NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (00000000002, 00000000001);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
