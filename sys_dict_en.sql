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

/*Table structure for table `sys_dict_en` */

DROP TABLE IF EXISTS `sys_dict_en`;

CREATE TABLE `sys_dict_en` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标签名',
  `value` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '数据值',
  `type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  `parent_id` bigint(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` int(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`name`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

/*Data for the table `sys_dict_en` */

LOCK TABLES `sys_dict_en` WRITE;

insert  into `sys_dict_en`(`id`,`name`,`value`,`type`,`description`,`sort`,`parent_id`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values (1,'normal','0','del_flag','delete tag','10',0,1,NULL,1,NULL,NULL,'0'),(3,'show','1','show_hide','show/hide','10',0,1,NULL,1,NULL,NULL,'0'),(4,'hide','0','show_hide','show/hide','20',0,1,NULL,1,NULL,NULL,'0'),(5,'yes','1','yes_no','yes/no','10',0,1,NULL,1,NULL,NULL,'0'),(6,'no','0','yes_no','yes/no','20',0,1,NULL,1,NULL,NULL,'0'),(7,'red','red','color','colour','10',0,1,NULL,1,NULL,NULL,'0'),(8,'green','green','color','colour','20',0,1,NULL,1,NULL,NULL,'0'),(9,'blue','blue','color','colour','30',0,1,NULL,1,NULL,NULL,'0'),(10,'yellow','yellow','color','colour','40',0,1,NULL,1,NULL,NULL,'0'),(11,'orange','orange','color','colour','50',0,1,NULL,1,NULL,NULL,'0'),(12,'default theme','default','theme','theme scheme','10',0,1,NULL,1,NULL,NULL,'0'),(13,'azure theme','cerulean','theme','theme scheme','20',0,1,NULL,1,NULL,NULL,'0'),(14,'orange theme','readable','theme','theme scheme','30',0,1,NULL,1,NULL,NULL,'0'),(15,'red theme','united','theme','theme scheme','40',0,1,NULL,1,NULL,NULL,'0'),(16,'Flat theme','flat','theme','theme scheme','60',0,1,NULL,1,NULL,NULL,'0'),(17,'country','1','sys_area_type','district type','10',0,1,NULL,1,NULL,NULL,'0'),(18,'province、city','2','sys_area_type','district type','20',0,1,NULL,1,NULL,NULL,'0'),(19,'city','3','sys_area_type','district type','30',0,1,NULL,1,NULL,NULL,'0'),(20,'county','4','sys_area_type','district type','40',0,1,NULL,1,NULL,NULL,'0'),(21,'company','1','sys_office_type','org type','60',0,1,NULL,1,NULL,NULL,'0'),(22,'department','2','sys_office_type','org type','70',0,1,NULL,1,NULL,NULL,'0'),(23,'group','3','sys_office_type','org type','80',0,1,NULL,1,NULL,NULL,'0'),(24,'others','4','sys_office_type','org type','90',0,1,NULL,1,NULL,NULL,'0'),(25,'general department','1','sys_office_common','general department','30',0,1,NULL,1,NULL,NULL,'0'),(26,'R&D department','2','sys_office_common','general department','40',0,1,NULL,1,NULL,NULL,'0'),(27,'HR department','3','sys_office_common','general department','50',0,1,NULL,1,NULL,NULL,'0'),(28,'first level','1','sys_office_grade','org rank','10',0,1,NULL,1,NULL,NULL,'0'),(29,'second level','2','sys_office_grade','org rank','20',0,1,NULL,1,NULL,NULL,'0'),(30,'third level','3','sys_office_grade','org rank','30',0,1,NULL,1,NULL,NULL,'0'),(31,'fourth level','4','sys_office_grade','org rank','40',0,1,NULL,1,NULL,NULL,'0'),(32,'all data','1','sys_data_scope','data scope','10',0,1,NULL,1,NULL,NULL,'0'),(33,'company and company data','2','sys_data_scope','data scope','20',0,1,NULL,1,NULL,NULL,'0'),(34,'company data','3','sys_data_scope','data scope','30',0,1,NULL,1,NULL,NULL,'0'),(35,'department and department data','4','sys_data_scope','data scope','40',0,1,NULL,1,NULL,NULL,'0'),(36,'department data','5','sys_data_scope','data scope','50',0,1,NULL,1,NULL,NULL,'0'),(37,'personal data only','8','sys_data_scope','data scope','90',0,1,NULL,1,NULL,NULL,'0'),(38,'set as specification','9','sys_data_scope','data scope','100',0,1,NULL,1,NULL,NULL,'0'),(39,'system management','1','sys_user_type','user type','10',0,1,NULL,1,NULL,NULL,'0'),(40,'department manager','2','sys_user_type','user type','20',0,1,NULL,1,NULL,NULL,'0'),(41,'ordinary user','3','sys_user_type','user type','30',0,1,NULL,1,NULL,NULL,'0'),(42,'base theme','basic','cms_theme','site theme','10',0,1,NULL,1,NULL,NULL,'0'),(43,'blue theme','blue','cms_theme','site theme','20',0,1,NULL,1,NULL,NULL,'1'),(44,'red theme','red','cms_theme','site theme','30',0,1,NULL,1,NULL,NULL,'1'),(45,'article model','article','cms_module','part model','10',0,1,NULL,1,NULL,NULL,'0'),(46,'picture model','picture','cms_module','part model','20',0,1,NULL,1,NULL,NULL,'1'),(47,'download model','download','cms_module','part model','30',0,1,NULL,1,NULL,NULL,'1'),(48,'link model','link','cms_module','part model','40',0,1,NULL,1,NULL,NULL,'0'),(49,'subject model','special','cms_module','part model','50',0,1,NULL,1,NULL,NULL,'1'),(50,'edefault exhibition','0','cms_show_modes','display mode','10',0,1,NULL,1,NULL,NULL,'0'),(51,'first part cotent','1','cms_show_modes','display mode','20',0,1,NULL,1,NULL,NULL,'0'),(52,'first part first cotent','2','cms_show_modes','display mode','30',0,1,NULL,1,NULL,NULL,'0'),(53,'publish','0','cms_del_flag','content state','10',0,1,NULL,1,NULL,NULL,'0'),(54,'delete','1','cms_del_flag','content state','20',0,1,NULL,1,NULL,NULL,'0'),(55,'check','2','cms_del_flag','content state','15',0,1,NULL,1,NULL,NULL,'0'),(56,'home page pix','1','cms_posid','recommended position','10',0,1,NULL,1,NULL,NULL,'0'),(57,'home page articles','2','cms_posid','recommended position','20',0,1,NULL,1,NULL,NULL,'0'),(58,'consult','1','cms_guestbook','msg type','10',0,1,NULL,1,NULL,NULL,'0'),(59,'suggest','2','cms_guestbook','msg type','20',0,1,NULL,1,NULL,NULL,'0'),(60,'complain','3','cms_guestbook','msg type','30',0,1,NULL,1,NULL,NULL,'0'),(61,'others','4','cms_guestbook','msg type','40',0,1,NULL,1,NULL,NULL,'0'),(62,'general holiday','1','oa_leave_type','leave type','10',0,1,NULL,1,NULL,NULL,'0'),(63,'sick leave','2','oa_leave_type','leave type','20',0,1,NULL,1,NULL,NULL,'0'),(64,'casual leave','3','oa_leave_type','leave type','30',0,1,NULL,1,NULL,NULL,'0'),(65,'shift leave','4','oa_leave_type','leave type','40',0,1,NULL,1,NULL,NULL,'0'),(66,'wedding day','5','oa_leave_type','leave type','60',0,1,NULL,1,NULL,NULL,'0'),(67,'access logs','1','sys_log_type','log type','30',0,1,NULL,1,NULL,NULL,'0'),(68,'exception logs','2','sys_log_type','log type','40',0,1,NULL,1,NULL,NULL,'0'),(69,'process for a leave','leave','act_type','process type','10',0,1,NULL,1,NULL,NULL,'0'),(70,'process for testing process','test_audit','act_type','process type','20',0,1,NULL,1,NULL,NULL,'0'),(71,'classification1','1','act_category','process classification','10',0,1,NULL,1,NULL,NULL,'0'),(72,'classification2','2','act_category','process classification','20',0,1,NULL,1,NULL,NULL,'0'),(73,'manipulate','crud','gen_category','code generating classification','10',0,1,NULL,1,NULL,NULL,'1'),(74,'manipulate（accessory tables）','crud_many','gen_category','code generating classification','20',0,1,NULL,1,NULL,NULL,'1'),(75,'tree structure','tree','gen_category','code generating classification','30',0,1,NULL,1,NULL,NULL,'1'),(76,'=','=','gen_query_type','query mode','10',0,1,NULL,1,NULL,NULL,'1'),(77,'!=','!=','gen_query_type','query mode','20',0,1,NULL,1,NULL,NULL,'1'),(78,'&gt;','&gt;','gen_query_type','query mode','30',0,1,NULL,1,NULL,NULL,'1'),(79,'&lt;','&lt;','gen_query_type','query mode','40',0,1,NULL,1,NULL,NULL,'1'),(80,'Between','between','gen_query_type','query mode','50',0,1,NULL,1,NULL,NULL,'1'),(81,'Like','like','gen_query_type','query mode','60',0,1,NULL,1,NULL,NULL,'1'),(82,'Left Like','left_like','gen_query_type','query mode','70',0,1,NULL,1,NULL,NULL,'1'),(83,'Right Like','right_like','gen_query_type','query mode','80',0,1,NULL,1,NULL,NULL,'1'),(84,'textbox','input','gen_show_type','fields generating scheme','10',0,1,NULL,1,NULL,NULL,'1'),(85,'text area','textarea','gen_show_type','fields generating scheme','20',0,1,NULL,1,NULL,NULL,'1'),(86,'combobox','select','gen_show_type','fields generating scheme','30',0,1,NULL,1,NULL,NULL,'1'),(87,'checkbox','checkbox','gen_show_type','fields generating scheme','40',0,1,NULL,1,NULL,NULL,'1'),(88,'radio','radiobox','gen_show_type','fields generating scheme','50',0,1,NULL,1,NULL,NULL,'1'),(89,'date choosing','dateselect','gen_show_type','fields generating scheme','60',0,1,NULL,1,NULL,NULL,'1'),(90,'staff choosing','userselect','gen_show_type','fields generating scheme','70',0,1,NULL,1,NULL,NULL,'1'),(91,'department choosing','officeselect','gen_show_type','fields generating scheme','80',0,1,NULL,1,NULL,NULL,'1'),(92,'area choosing','areaselect','gen_show_type','fields generating scheme','90',0,1,NULL,1,NULL,NULL,'1'),(93,'String','String','gen_java_type','Java type','10',0,1,NULL,1,NULL,NULL,'1'),(94,'Long','Long','gen_java_type','Java type','20',0,1,NULL,1,NULL,NULL,'1'),(95,'persistence only','dao','gen_category','code generating classification','40',0,1,NULL,1,NULL,NULL,'1'),(96,'male','1','sex','gender','10',0,1,NULL,1,NULL,NULL,'0'),(97,'female','2','sex','gender','20',0,1,NULL,1,NULL,NULL,'0'),(98,'Integer','Integer','gen_java_type','Java type','30',0,1,NULL,1,NULL,NULL,'1'),(99,'Double','Double','gen_java_type','Java type','40',0,1,NULL,1,NULL,NULL,'1'),(100,'Date','java.util.Date','gen_java_type','Java type','50',0,1,NULL,1,NULL,NULL,'1'),(104,'Custom','Custom','gen_java_type','Java type','90',0,1,NULL,1,NULL,NULL,'1'),(105,'meeting notification','1','oa_notify_type','notification type','10',0,1,NULL,1,NULL,NULL,'0'),(106,'rewards and punishment notification','2','oa_notify_type','notification type','20',0,1,NULL,1,NULL,NULL,'0'),(107,'activities notification','3','oa_notify_type','notification type','30',0,1,NULL,1,NULL,NULL,'0'),(108,'draft','0','oa_notify_status','notification state','10',0,1,NULL,1,NULL,NULL,'0'),(109,'publish','1','oa_notify_status','notification state','20',0,1,NULL,1,NULL,NULL,'0'),(110,'unread','0','oa_notify_read','notification state','10',0,1,NULL,1,NULL,NULL,'0'),(111,'read','1','oa_notify_read','notification state','20',0,1,NULL,1,NULL,NULL,'0'),(112,'draft','0','oa_notify_status','notification state','10',0,1,NULL,1,NULL,'','0'),(113,'delete','0','del_flag','delete tag',NULL,NULL,NULL,NULL,NULL,NULL,'',''),(118,'about','about','blog_type','blog type',NULL,NULL,NULL,NULL,NULL,NULL,'全urlyes:/blog/open/page/about',''),(119,'communicate','communication','blog_type','blog type',NULL,NULL,NULL,NULL,NULL,NULL,'',''),(120,'articles','article','blog_type','blog type',NULL,NULL,NULL,NULL,NULL,NULL,'',''),(121,'coding','code','hobby','hobbies',NULL,NULL,NULL,NULL,NULL,NULL,'',''),(122,'painting','painting','hobby','hobbies',NULL,NULL,NULL,NULL,NULL,NULL,'','');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;