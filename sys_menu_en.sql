/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.36 : Database - bootdo_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bootdo_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bootdo_db`;

/*Table structure for table `sys_menu_en` */

DROP TABLE IF EXISTS `sys_menu_en`;

CREATE TABLE `sys_menu_en` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu_en` */

LOCK TABLES `sys_menu_en` WRITE;

insert  into `sys_menu_en`(`menu_id`,`parent_id`,`name`,`url`,`perms`,`type`,`icon`,`order_num`,`gmt_create`,`gmt_modified`) values (1,0,'base management','','',0,'fa fa-bars',0,'2017-08-09 22:49:47',NULL),(2,3,'system menu','sys/menu/','sys:menu:menu',1,'fa fa-th-list',2,'2017-08-09 22:55:15',NULL),(3,0,'system management',NULL,NULL,0,'fa fa-desktop',1,'2017-08-09 23:06:55','2017-08-14 14:13:43'),(6,3,'user management','sys/user/','sys:user:user',1,'fa fa-user',0,'2017-08-10 14:12:11',NULL),(7,3,'role management','sys/role','sys:role:role',1,'fa fa-paw',1,'2017-08-10 14:13:19',NULL),(12,6,'add','','sys:user:add',2,'',0,'2017-08-14 10:51:35',NULL),(13,6,'edit','','sys:user:edit',2,'',0,'2017-08-14 10:52:06',NULL),(14,6,'delete',NULL,'sys:user:remove',2,NULL,0,'2017-08-14 10:52:24',NULL),(15,7,'add','','sys:role:add',2,'',0,'2017-08-14 10:56:37',NULL),(20,2,'add','','sys:menu:add',2,'',0,'2017-08-14 10:59:32',NULL),(21,2,'edit','','sys:menu:edit',2,'',0,'2017-08-14 10:59:56',NULL),(22,2,'delete','','sys:menu:remove',2,'',0,'2017-08-14 11:00:26',NULL),(24,6,'batch delete','','sys:user:batchRemove',2,'',0,'2017-08-14 17:27:18',NULL),(25,6,'disable',NULL,'sys:user:disable',2,NULL,0,'2017-08-14 17:27:43',NULL),(26,6,'reset password','','sys:user:resetPwd',2,'',0,'2017-08-14 17:28:34',NULL),(27,91,'sysrem log','common/log','common:log',1,'fa fa-warning',0,'2017-08-14 22:11:53',NULL),(28,27,'refresh',NULL,'sys:log:list',2,NULL,0,'2017-08-14 22:30:22',NULL),(29,27,'delete',NULL,'sys:log:remove',2,NULL,0,'2017-08-14 22:30:43',NULL),(30,27,'clear',NULL,'sys:log:clear',2,NULL,0,'2017-08-14 22:31:02',NULL),(48,77,'generate code','common/generator','common:generator',1,'fa fa-code',3,NULL,NULL),(49,0,'blog management','','',0,'fa fa-rss',6,NULL,NULL),(50,49,'article list','blog/bContent','blog:bContent:bContent',1,'fa fa-file-image-o',1,NULL,NULL),(51,50,'add','','blog:bContent:add',2,'',NULL,NULL,NULL),(55,7,'edit','','sys:role:edit',2,'',NULL,NULL,NULL),(56,7,'delete','','sys:role:remove',2,NULL,NULL,NULL,NULL),(57,91,'monitor','/druid/index.html','',1,'fa fa-caret-square-o-right',1,NULL,NULL),(58,50,'edit','','blog:bContent:edit',2,NULL,NULL,NULL,NULL),(59,50,'delete','','blog:bContent:remove',2,NULL,NULL,NULL,NULL),(60,50,'batch delete','','blog:bContent:batchRemove',2,NULL,NULL,NULL,NULL),(61,2,'batch delete','','sys:menu:batchRemove',2,NULL,NULL,NULL,NULL),(62,7,'batch delete','','sys:role:batchRemove',2,NULL,NULL,NULL,NULL),(68,49,'publish article','/blog/bContent/add','blog:bContent:add',1,'fa fa-edit',0,NULL,NULL),(71,1,'file management','/common/sysFile','common:sysFile:sysFile',1,'fa fa-folder-open',2,NULL,NULL),(72,77,'assignment','common/job','common:taskScheduleJob',1,'fa fa-hourglass-1',4,NULL,NULL),(73,3,'section management','/system/sysDept','system:sysDept:sysDept',1,'fa fa-users',3,NULL,NULL),(74,73,'add','/system/sysDept/add','system:sysDept:add',2,NULL,1,NULL,NULL),(75,73,'delete','system/sysDept/remove','system:sysDept:remove',2,NULL,2,NULL,NULL),(76,73,'edit','/system/sysDept/edit','system:sysDept:edit',2,NULL,3,NULL,NULL),(77,0,'system kit','','',0,'fa fa-gear',4,NULL,NULL),(78,1,'data dictionary','/common/dict','common:dict:dict',1,'fa fa-book',1,NULL,NULL),(79,78,'add','/common/dict/add','common:dict:add',2,NULL,2,NULL,NULL),(80,78,'edit','/common/dict/edit','common:dict:edit',2,NULL,2,NULL,NULL),(81,78,'delete','/common/dict/remove','common:dict:remove',2,'',3,NULL,NULL),(83,78,'batch delete','/common/dict/batchRemove','common:dict:batchRemove',2,'',4,NULL,NULL),(84,0,'office management','','',0,'fa fa-laptop',5,NULL,NULL),(85,84,'notification','oa/notify','oa:notify:notify',1,'fa fa-pencil-square',NULL,NULL,NULL),(86,85,'add','oa/notify/add','oa:notify:add',2,'fa fa-plus',1,NULL,NULL),(87,85,'edit','oa/notify/edit','oa:notify:edit',2,'fa fa-pencil-square-o',2,NULL,NULL),(88,85,'delete','oa/notify/remove','oa:notify:remove',2,'fa fa-minus',NULL,NULL,NULL),(89,85,'batch delete','oa/notify/batchRemove','oa:notify:batchRemove',2,'',NULL,NULL,NULL),(90,84,'notes','oa/notify/selfNotify','',1,'fa fa-envelope-square',NULL,NULL,NULL),(91,0,'monitor','','',0,'fa fa-video-camera',5,NULL,NULL),(92,91,'online users','sys/online','',1,'fa fa-user',NULL,NULL,NULL),(93,0,'workflow','','',0,'fa fa-print',6,NULL,NULL),(94,93,'module management','activiti/model','',1,'fa fa-sort-amount-asc',NULL,NULL,NULL),(95,94,'authority','','activiti:model',2,'',NULL,NULL,NULL),(96,93,'process management','activiti/process','',1,'fa fa-flag',NULL,NULL,NULL),(97,0,'charts management','','',0,'fa fa-bar-chart',7,NULL,NULL),(98,97,'baidu chart','/chart/graph_echarts.html','',1,'fa fa-area-chart',NULL,NULL,NULL),(99,96,'authority','','act:process',2,'',NULL,NULL,NULL),(101,93,'to do list','activiti/task/todo','',1,'',NULL,NULL,NULL),(104,77,'swagger','/swagger-ui.html','',1,'',NULL,NULL,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
