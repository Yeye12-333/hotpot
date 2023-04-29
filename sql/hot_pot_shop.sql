/*
 Navicat Premium Data Transfer

 Source Server         : 我的
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 1.15.137.216:3306
 Source Schema         : hot_pot_shop

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 08/06/2021 19:34:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜品名字',
  `price` decimal(10, 2) NOT NULL COMMENT '菜品价格',
  `cover` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜品图片',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '菜品添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'Fredericka Rivera', 100.00, 'https://decoration01.oss-cn-shenzhen.aliyuncs.com/0a28320ebea242c6aa1423e684fd188e', '2021-06-02 16:42:35');
INSERT INTO `goods` VALUES (2, '麻辣香锅', 50.00, 'https://decoration01.oss-cn-shenzhen.aliyuncs.com/2bc8db730d304bde914b16e180488123', '2021-06-03 13:16:44');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `goods_id` int(11) NOT NULL COMMENT '菜品id',
  `quantity` int(11) NOT NULL COMMENT '菜品数量',
  `total` decimal(10, 2) NOT NULL COMMENT '订单总价',
  `status` tinyint(1) NOT NULL COMMENT '订单状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '下单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 1, 6, 5202.00, 2, '2021-06-02 17:39:27');
INSERT INTO `order` VALUES (2, 3, 1, 1, 867.00, 2, '2021-06-02 18:53:45');
INSERT INTO `order` VALUES (4, 6, 1, 1, 867.00, 2, '2021-06-03 13:14:11');
INSERT INTO `order` VALUES (5, 6, 2, 2, 100.00, 1, '2021-06-07 22:03:54');
INSERT INTO `order` VALUES (6, 6, 2, 1, 50.00, 1, '2021-06-07 22:19:13');
INSERT INTO `order` VALUES (7, 6, 1, 1, 100.00, 2, '2021-06-07 22:19:13');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `quantity` int(11) NOT NULL COMMENT '菜品数量',
  `goods_id` int(11) NOT NULL COMMENT '菜品id',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for scar
-- ----------------------------
DROP TABLE IF EXISTS `scar`;
CREATE TABLE `scar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `goods_id` int(11) NOT NULL COMMENT '菜品id',
  `quantity` int(11) NOT NULL DEFAULT 1 COMMENT '添加数量',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scar
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `role` tinyint(1) NOT NULL COMMENT '用户角色 1|2; 1普通用户 2管理员',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$26DDtRIJEsiskDQlHQk7DOhpnwrhrecCtwNsKPugVVszAaOfJSQMO', 2, '2021-06-02 16:28:01');
INSERT INTO `user` VALUES (2, 'tikuw', '$2a$10$Qds4l/dYmAQB/BrHV5DOJufy9lbM/mholoSPz1hC.nUXJ9o6urnli', 1, '2021-06-02 18:52:26');
INSERT INTO `user` VALUES (3, 'jupize', '$2a$10$pSpKZcuQSSIEWMeG2QLbLeuL98JV7fJYWoYgXfAdLajTAl1e7rhwO', 1, '2021-06-02 18:52:35');
INSERT INTO `user` VALUES (4, 'byxybari', '$2a$10$nNU/aJp28SQt7dCaZJh.3uHdk9s8P/cPlFe3sVPtu5hfA90PC3lE6', 1, '2021-06-02 19:04:42');
INSERT INTO `user` VALUES (5, 'xelodoryty', '$2a$10$d3KECZ21.IAF6NTNAARh7OeBjzg1XVAH4DB6nOVVQJ6jUVAd1ckb.', 1, '2021-06-02 19:04:55');
INSERT INTO `user` VALUES (6, 'customer1', '$2a$10$ugp1Dl1AKZiNx4nJk0gzQOckt5vvHSnk21klRGuEjodURs.TB/Tge', 1, '2021-06-03 13:13:21');
INSERT INTO `user` VALUES (7, 'wosobapis', '$2a$10$cgLfMdpOyJLJrNDNQrVyTOAYid7qLtlwqJ5kILjG/mJ.VN0jXw8Ka', 1, '2021-06-03 19:32:30');
INSERT INTO `user` VALUES (8, '222', '$2a$10$XVqDDlHdHwer2f3uK2N2R.hubnZN/CfVRcyit9Ot7zytEAKE95iXy', 1, '2021-06-03 19:47:57');

SET FOREIGN_KEY_CHECKS = 1;
