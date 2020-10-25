/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : shuihu

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/10/2020 00:15:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint NULL DEFAULT NULL COMMENT '0：男；1：女',
  `phone_num` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vip` tinyint UNSIGNED NOT NULL COMMENT '0：普通；1：黄金；2：钻石',
  `age` int NULL DEFAULT NULL,
  `job` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `account_name`(`login_name`) USING BTREE,
  INDEX `phone_num`(`phone_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (00000000001, '李博', 'libo', '12345687', 0, '18862112950', 0, 27, '程序员');
INSERT INTO `customer` VALUES (00000000002, '零零', 'dada', '123456', 1, '18862111223', 0, 44, '其他');
INSERT INTO `customer` VALUES (00000000003, '李波', 'lala', '123456', 0, '18862112950', 0, 22, '暂无');

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`  (
  `id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '菜id',
  `dish_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜名',
  `category` enum('烧烤','凉菜','热菜','主食') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  `origin_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠前价格',
  `current_price` decimal(10, 2) NOT NULL COMMENT '当前价格',
  `unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计价单位',
  `quantity` int UNSIGNED NULL DEFAULT NULL COMMENT '当前剩余数量',
  `img_path` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `deleted` bit(1) NOT NULL COMMENT '0代表没删除',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES (00000001, '烤鸡翅', '烧烤', 10.00, 10.00, '把', 100, NULL, b'0', NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(8) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_age` int NULL DEFAULT NULL,
  `phone_num` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` bit(1) NULL DEFAULT NULL,
  `identity` enum('老板','领班','职员','boss') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '职员',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `other_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_num`(`phone_num`) USING BTREE,
  UNIQUE INDEX `login_name`(`login_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (00000001, 'libo', '李博', 27, '18862112950', '123456', b'1', 'boss', NULL, NULL);

-- ----------------------------
-- Table structure for parentorder
-- ----------------------------
DROP TABLE IF EXISTS `parentorder`;
CREATE TABLE `parentorder`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) UNSIGNED ZEROFILL NOT NULL,
  `total_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00,
  `actual_pay` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00,
  `payoff` bit(1) NOT NULL DEFAULT b'0' COMMENT '0为未还清',
  `create_at` date NOT NULL,
  `pay_at` datetime(0) NULL DEFAULT NULL,
  `cancel_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customer_id`(`customer_id`) USING BTREE,
  CONSTRAINT `parentorder_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parentorder
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
