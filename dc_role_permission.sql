/*
Navicat MySQL Data Transfer

Source Server         : 设计中国
Source Server Version : 50717
Source Host           : 47.88.35.65:3306
Source Database       : digestchina

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-19 08:56:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dc_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `dc_role_permission`;
CREATE TABLE `dc_role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
