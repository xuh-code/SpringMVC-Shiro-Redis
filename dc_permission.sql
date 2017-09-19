/*
Navicat MySQL Data Transfer

Source Server         : 设计中国
Source Server Version : 50717
Source Host           : 47.88.35.65:3306
Source Database       : digestchina

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-19 10:20:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dc_permission
-- ----------------------------
DROP TABLE IF EXISTS `dc_permission`;
CREATE TABLE `dc_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  `perDesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dc_permission
-- ----------------------------
INSERT INTO `dc_permission` VALUES ('1', 'article:search', '查找文章');
INSERT INTO `dc_permission` VALUES ('2', 'article:publish', '创建文章');
INSERT INTO `dc_permission` VALUES ('3', 'article:edit', '编辑文章');
INSERT INTO `dc_permission` VALUES ('4', 'article:delete', '删除文章');
INSERT INTO `dc_permission` VALUES ('5', 'article:audit', '文章操作审核');
