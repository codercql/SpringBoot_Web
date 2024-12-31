/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : jdbc

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 30/12/2024 22:23:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `r_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`r_id`, `p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 3);
INSERT INTO `role_permission` VALUES (1, 4);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (1, 6);
INSERT INTO `role_permission` VALUES (1, 7);
INSERT INTO `role_permission` VALUES (1, 8);
INSERT INTO `role_permission` VALUES (1, 9);
INSERT INTO `role_permission` VALUES (1, 10);
INSERT INTO `role_permission` VALUES (1, 11);
INSERT INTO `role_permission` VALUES (1, 12);
INSERT INTO `role_permission` VALUES (5, 1);
INSERT INTO `role_permission` VALUES (5, 2);
INSERT INTO `role_permission` VALUES (5, 3);
INSERT INTO `role_permission` VALUES (5, 4);
INSERT INTO `role_permission` VALUES (5, 7);
INSERT INTO `role_permission` VALUES (6, 3);
INSERT INTO `role_permission` VALUES (6, 8);
INSERT INTO `role_permission` VALUES (6, 9);
INSERT INTO `role_permission` VALUES (6, 10);
INSERT INTO `role_permission` VALUES (6, 12);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_num` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `student_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生的名',
  `gender` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别 0:男 1:女 2:保密',
  `age` int(11) NOT NULL COMMENT '年龄',
  `date_of_birth` datetime NULL DEFAULT NULL COMMENT '出生日期',
  `class_id` int(11) NULL DEFAULT NULL COMMENT '班级编号',
  `hostel_id` int(11) NULL DEFAULT NULL COMMENT '宿舍编号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件地址',
  `home_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `emergency_contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人姓名',
  `emergency_contact_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '紧急联系人联系电话',
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业',
  `status` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生状态0:在读 1:毕业',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (1, '202220165101', '张三0', '女', 19, '2004-11-02 00:00:00', 1, 301, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (2, '202220165102', '张三1', '女', 19, '2004-11-03 00:00:00', 1, 301, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (3, '202220165103', '张三3', '男', 19, '2004-11-03 00:00:00', 1, 301, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (5, '202220165105', '李四1', '男', 20, '2004-07-29 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (6, '202220165105', '李四1', '男', 20, '2004-07-29 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (7, '202220165105', '李四2', '男', 20, '2004-07-22 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (8, '202220165105', '李四3', '男', 20, '2004-07-24 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (9, '202220165106', '李四4', '男', 20, '2004-07-29 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (10, '202220165107', '李四5', '男', 19, '2024-11-05 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (11, '202220165108', '李四6', '男', 20, '2004-07-24 00:00:00', 1, 304, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);
INSERT INTO `student_info` VALUES (12, '202220165110', '王五', '女', 17, '2005-02-01 00:00:00', 2, 345, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '', NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_banji
-- ----------------------------
DROP TABLE IF EXISTS `sys_banji`;
CREATE TABLE `sys_banji`  (
  `banji_id` int(11) NOT NULL AUTO_INCREMENT,
  `banji_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `grade_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`banji_id`) USING BTREE,
  INDEX `grade`(`grade_id` ASC) USING BTREE,
  CONSTRAINT `grade` FOREIGN KEY (`grade_id`) REFERENCES `sys_grade` (`grade_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_banji
-- ----------------------------
INSERT INTO `sys_banji` VALUES (1, '一（1）班', 1);
INSERT INTO `sys_banji` VALUES (2, '一（2）班', 1);
INSERT INTO `sys_banji` VALUES (3, '二（1）班', 2);
INSERT INTO `sys_banji` VALUES (4, '三（1）班', 3);
INSERT INTO `sys_banji` VALUES (5, '四（1）班', 4);
INSERT INTO `sys_banji` VALUES (6, '五（1）班', 5);
INSERT INTO `sys_banji` VALUES (7, '五（2）班', NULL);
INSERT INTO `sys_banji` VALUES (8, '四', 2);
INSERT INTO `sys_banji` VALUES (9, '三（6）班', 3);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '检验');
INSERT INTO `sys_dept` VALUES (2, '取样');
INSERT INTO `sys_dept` VALUES (4, 'aaaa');
INSERT INTO `sys_dept` VALUES (5, '口腔');

-- ----------------------------
-- Table structure for sys_dorm
-- ----------------------------
DROP TABLE IF EXISTS `sys_dorm`;
CREATE TABLE `sys_dorm`  (
  `dorm_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dorm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dorm
-- ----------------------------
INSERT INTO `sys_dorm` VALUES (1, '一号宿舍');
INSERT INTO `sys_dorm` VALUES (2, '二号宿舍');
INSERT INTO `sys_dorm` VALUES (3, '三号宿舍');
INSERT INTO `sys_dorm` VALUES (4, '四号宿舍');

-- ----------------------------
-- Table structure for sys_grade
-- ----------------------------
DROP TABLE IF EXISTS `sys_grade`;
CREATE TABLE `sys_grade`  (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`grade_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_grade
-- ----------------------------
INSERT INTO `sys_grade` VALUES (1, '一年级');
INSERT INTO `sys_grade` VALUES (2, '二年级');
INSERT INTO `sys_grade` VALUES (3, '三年级');
INSERT INTO `sys_grade` VALUES (4, '四年级');
INSERT INTO `sys_grade` VALUES (5, '五年级');
INSERT INTO `sys_grade` VALUES (6, '六年级');
INSERT INTO `sys_grade` VALUES (7, '初一');
INSERT INTO `sys_grade` VALUES (8, '初二');

-- ----------------------------
-- Table structure for sys_major
-- ----------------------------
DROP TABLE IF EXISTS `sys_major`;
CREATE TABLE `sys_major`  (
  `major_id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_major
-- ----------------------------
INSERT INTO `sys_major` VALUES (1, '软件工程');
INSERT INTO `sys_major` VALUES (2, '大数据与科学');
INSERT INTO `sys_major` VALUES (3, '计算机科学技术');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `menu_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单类型（M 目录 C 菜单 F 按钮）',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `url` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '首页', 'M', 0, '#', 'index');
INSERT INTO `sys_permission` VALUES (2, '示例代码', 'M', 0, '#', 'demo');
INSERT INTO `sys_permission` VALUES (3, '基本信息管理', 'M', 0, '#', 'basic');
INSERT INTO `sys_permission` VALUES (4, '用户管理', 'C', 2, '/user/tolist', 'user:view');
INSERT INTO `sys_permission` VALUES (5, '角色管理', 'C', 2, '/role/tolist', 'role:view');
INSERT INTO `sys_permission` VALUES (7, '用户查询', 'F', 4, 'user/list', 'user:list');
INSERT INTO `sys_permission` VALUES (8, '学生管理', 'C', 3, '/student/tolist', 'student:view');
INSERT INTO `sys_permission` VALUES (9, '班级管理', 'C', 3, '/cla/tolist', 'cla:view');
INSERT INTO `sys_permission` VALUES (10, '年级管理', 'C', 3, '/grade/tolist', 'grade:view');
INSERT INTO `sys_permission` VALUES (11, '专业管理', 'C', 3, '/major/tolist', 'major:view');
INSERT INTO `sys_permission` VALUES (12, '宿舍管理', 'C', 3, 'hostel/tolist', 'hostel:view');
INSERT INTO `sys_permission` VALUES (14, '测试新增1209', 'F', 11, '/major/addSave', 'major:addSave');
INSERT INTO `sys_permission` VALUES (15, '部门管理', 'C', 2, '/dept/tolist', 'dept:view');
INSERT INTO `sys_permission` VALUES (16, '权限管理', 'C', 2, '/permission/tolist', 'permission:view');
INSERT INTO `sys_permission` VALUES (17, '用户管理(My-plus)', 'C', 2, '/userex/tolist', 'userex:view');
INSERT INTO `sys_permission` VALUES (18, '部门管理(My-plus)', 'C', 2, '/deptex/tolist', 'deptex:view');
INSERT INTO `sys_permission` VALUES (19, '权限管理(树形表格)', 'C', 2, '/permission/totreelist', 'permission:view');
INSERT INTO `sys_permission` VALUES (20, '用户新增', 'F', 4, '#', 'user:add');
INSERT INTO `sys_permission` VALUES (21, '用户更新', 'F', 4, '#', 'user:update');
INSERT INTO `sys_permission` VALUES (22, '用户删除', 'F', 4, '#', 'user:delete');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员');
INSERT INTO `sys_role` VALUES (2, '游客');
INSERT INTO `sys_role` VALUES (3, '老师');
INSERT INTO `sys_role` VALUES (4, '学生');

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student`  (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `student_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `student_gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `student_age` int(11) NULL DEFAULT NULL,
  `banji_id` int(11) NULL DEFAULT NULL,
  `grade_id` int(11) NULL DEFAULT NULL,
  `dorm_id` int(11) NULL DEFAULT NULL,
  `major_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `banjiId`(`banji_id` ASC) USING BTREE,
  INDEX `gradeId`(`grade_id` ASC) USING BTREE,
  INDEX `dormId`(`dorm_id` ASC) USING BTREE,
  INDEX `majorId`(`major_id` ASC) USING BTREE,
  CONSTRAINT `banjiId` FOREIGN KEY (`banji_id`) REFERENCES `sys_banji` (`banji_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dormId` FOREIGN KEY (`dorm_id`) REFERENCES `sys_dorm` (`dorm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `gradeId` FOREIGN KEY (`grade_id`) REFERENCES `sys_grade` (`grade_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `majorId` FOREIGN KEY (`major_id`) REFERENCES `sys_major` (`major_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES (1, '张三', '123', '男', 15, 1, 1, 1, 1);
INSERT INTO `sys_student` VALUES (2, '张三2', '123', '男', 16, 1, 1, 1, 1);
INSERT INTO `sys_student` VALUES (3, '张三3', '123', '男', 17, 5, 1, 1, 1);
INSERT INTO `sys_student` VALUES (4, '李四', '123', '男', 15, 2, 1, 2, 1);
INSERT INTO `sys_student` VALUES (6, 'qq', '123', '男', 17, 1, 3, 2, 2);
INSERT INTO `sys_student` VALUES (7, '刘洋', '123', '女', 17, 3, 3, 4, 1);
INSERT INTO `sys_student` VALUES (8, '刘洋2', '123', '女', 17, 3, 3, 3, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (2, 'root', '456', '2024-11-20', 1);
INSERT INTO `sys_user` VALUES (5, 'admin222', '123', '2024-11-05', 2);
INSERT INTO `sys_user` VALUES (9, '111', '223', '2024-11-01', 2);
INSERT INTO `sys_user` VALUES (15, '张三5', '123', '2024-11-04', 1);
INSERT INTO `sys_user` VALUES (18, '张三8', '123', '2024-11-07', 2);
INSERT INTO `sys_user` VALUES (19, '张三9', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (20, '张三10', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (21, '张三11', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (22, '张三12', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (23, '张三13', '123', '2024-12-03', 5);
INSERT INTO `sys_user` VALUES (24, '张三14', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (25, '张三15', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (26, '张三16', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (27, '张三17', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (28, '张三18', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (42, '666', '666', NULL, NULL);
INSERT INTO `sys_user` VALUES (43, 'root1', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (44, 'root2', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (45, 'root3', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (46, 'root6', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (47, 'root8', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (48, 'admin', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (49, 'adnib3', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (50, '777', '111', NULL, NULL);
INSERT INTO `sys_user` VALUES (51, '1', '1', NULL, NULL);
INSERT INTO `sys_user` VALUES (53, '44', '4', NULL, NULL);
INSERT INTO `sys_user` VALUES (54, '999', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (55, '与与', '123', NULL, NULL);
INSERT INTO `sys_user` VALUES (56, '米', '123', NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `u_id` int(11) NOT NULL,
  `r_id` int(11) NOT NULL,
  PRIMARY KEY (`u_id`, `r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (23, 2);
INSERT INTO `user_role` VALUES (58, 2);
INSERT INTO `user_role` VALUES (59, 3);

SET FOREIGN_KEY_CHECKS = 1;
