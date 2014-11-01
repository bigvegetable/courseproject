-- MySQL dump 10.13  Distrib 5.6.21, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `isbn` varchar(20) CHARACTER SET latin1 NOT NULL,
  `title` varchar(50) CHARACTER SET latin1 NOT NULL,
  `author` varchar(100) CHARACTER SET latin1 NOT NULL,
  `price` double(16,2) DEFAULT NULL,
  `press` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `public_date` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `cate_name` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `fk_cate_name` (`cate_name`),
  CONSTRAINT `fk_cate_name` FOREIGN KEY (`cate_name`) REFERENCES `category` (`cate_name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_return`
--

DROP TABLE IF EXISTS `borrow_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow_return` (
  `br_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) CHARACTER SET latin1 NOT NULL,
  `stu_id` varchar(10) CHARACTER SET latin1 NOT NULL,
  `stu_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `borrow_date` datetime DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL,
  `is_return` set('true','false') CHARACTER SET latin1 DEFAULT 'false',
  `op_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `uid` smallint(8) unsigned NOT NULL,
  PRIMARY KEY (`br_id`),
  UNIQUE KEY `id` (`br_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_return`
--

LOCK TABLES `borrow_return` WRITE;
/*!40000 ALTER TABLE `borrow_return` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cate_id` smallint(10) unsigned NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(30) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`cate_id`),
  UNIQUE KEY `cid` (`cate_id`),
  UNIQUE KEY `name` (`cate_name`),
  UNIQUE KEY `cate_name` (`cate_name`),
  UNIQUE KEY `cate_name_2` (`cate_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `uid` smallint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `log_in_time` datetime DEFAULT NULL,
  `log_out_time` datetime DEFAULT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `ethernet_ip_addr` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `gender` set('男','女') NOT NULL,
  `phone_number` varchar(20) CHARACTER SET latin1 NOT NULL,
  `email` varchar(40) CHARACTER SET latin1 NOT NULL,
  `wlan_ip_addr` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'admin',NULL,NULL,'admin','127.0.0.1','男','','',NULL);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operate_log` (
  `op_id` int(16) unsigned NOT NULL AUTO_INCREMENT,
  `uid` smallint(8) unsigned NOT NULL,
  `description` varchar(200) CHARACTER SET latin1 NOT NULL,
  `op_time` datetime NOT NULL,
  `op_type` set('purcharse','borrow','return','destory','modify_info','others') CHARACTER SET latin1 DEFAULT 'others',
  `op_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`op_id`),
  UNIQUE KEY `id` (`op_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistics` (
  `isbn` varchar(15) CHARACTER SET latin1 NOT NULL,
  `total` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `available` tinyint(8) unsigned NOT NULL DEFAULT '0',
  `register_date` date DEFAULT NULL,
  `frequency` int(16) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `isbn` (`isbn`),
  CONSTRAINT `fk_isbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_id` varchar(15) NOT NULL,
  `stu_name` varchar(20) CHARACTER SET latin1 NOT NULL,
  `gender` set('男','女') NOT NULL,
  `phone_number` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `academy` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `class` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `sid` (`stu_id`),
  UNIQUE KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-01 18:24:20
