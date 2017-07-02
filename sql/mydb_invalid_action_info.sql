-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `invalid_action_info`
--

DROP TABLE IF EXISTS `invalid_action_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invalid_action_info` (
  `id_invalid_action_info` int(11) NOT NULL AUTO_INCREMENT,
  `invalid_stu_name` varchar(45) DEFAULT NULL,
  `invalid_action` varchar(45) DEFAULT NULL,
  `invalid_year` int(4) DEFAULT NULL,
  `invalid_action_if_baokao` int(1) DEFAULT '0',
  `invalid_add_person` varchar(45) DEFAULT NULL,
  `invalid_add_time` varchar(45) DEFAULT NULL,
  `invalid_id` varchar(45) DEFAULT NULL,
  `stu_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_invalid_action_info`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invalid_action_info`
--

LOCK TABLES `invalid_action_info` WRITE;
/*!40000 ALTER TABLE `invalid_action_info` DISABLE KEYS */;
INSERT INTO `invalid_action_info` VALUES (1,'闻子淳','作弊',2016,1,'admin','2016-12-1',NULL,'wzc'),(2,'史子昂','抄袭',2016,0,'admin','2016-12-1',NULL,'sza'),(3,'苏若晗','携带违规物品',2016,1,'admin','2016-12-1',NULL,'srh'),(4,'季聪','作弊',2017,0,'admin','2017-12-1',NULL,'jc'),(7,'季聪','作弊',2017,0,'admin','2017-4-31',NULL,'jc'),(8,'许一佳','作弊',2017,0,'a','2017-4-31',NULL,'xyj'),(9,'姜御景','作弊',2017,0,'admin','2017-6-1',NULL,'jyj');
/*!40000 ALTER TABLE `invalid_action_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-02 22:14:20
