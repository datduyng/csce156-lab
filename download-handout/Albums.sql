-- MySQL dump 10.13  Distrib 5.1.57, for suse-linux-gnu (x86_64)
--
-- Host: localhost    Database: cbourke
-- ------------------------------------------------------
-- Server version	5.1.57

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
-- Table structure for table `AlbumSongs`
--

DROP TABLE IF EXISTS `AlbumSongs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AlbumSongs` (
  `SongID` int(11) NOT NULL DEFAULT '0',
  `AlbumID` int(11) NOT NULL DEFAULT '0',
  `TrackNumber` int(11) DEFAULT NULL,
  `TrackLength` int(11) DEFAULT NULL,
  PRIMARY KEY (`SongID`,`AlbumID`),
  FOREIGN KEY (`SongID`) REFERENCES Songs(SongID),
  FOREIGN KEY (`AlbumID`) REFERENCES Albums(AlbumID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AlbumSongs`
--

/*--LOCK TABLES `AlbumSongs` WRITE;*/;
/*!40000 ALTER TABLE `AlbumSongs` DISABLE KEYS */;
INSERT INTO `AlbumSongs` VALUES (1,5,1,180),(2,5,2,198),(3,5,3,283),(4,5,4,357),(5,5,5,224),(6,4,11,260),(6,5,6,287),(7,5,7,208),(8,3,2,265),(8,5,8,218),(9,5,9,271),(10,4,7,282),(10,5,10,267),(11,2,10,343),(11,4,13,360),(11,5,11,279),(12,5,12,137),(13,3,1,290),(13,4,12,414),(14,3,3,260),(15,3,4,226),(16,3,5,218),(17,3,6,253),(18,3,7,337),(19,3,8,160),(20,3,9,172),(21,3,10,502),(21,4,8,542),(22,3,11,323),(22,4,14,367),(23,3,12,209),(24,2,8,235),(24,4,1,305),(25,2,2,241),(25,4,2,437),(26,4,3,264),(27,2,1,266),(27,4,4,301),(28,4,5,455),(29,4,6,206),(30,4,9,191),(31,2,3,245),(31,4,10,239),(34,2,4,228),(35,2,5,332),(36,2,6,240),(37,2,7,224),(38,2,9,304),(39,7,1,200),(40,7,2,210),(41,7,3,188),(42,7,4,211),(42,22,4,311),(43,7,5,219),(44,7,6,238),(45,7,7,263),(46,7,8,212),(47,7,9,244),(47,57,4,292),(48,7,10,202),(49,7,11,246),(50,7,12,218),(51,7,13,350),(52,7,14,327),(53,8,1,277),(54,8,2,192),(55,8,3,336),(56,8,4,287),(57,8,5,254),(58,8,6,221),(59,8,7,243),(60,8,8,226),(61,8,9,333),(62,8,10,157),(63,1,1,204),(64,1,2,213),(65,1,3,322),(66,1,4,343),(67,1,5,296),(68,9,1,277),(69,9,2,278),(70,9,3,300),(71,9,4,272),(72,9,5,259),(73,9,6,294),(74,9,7,177),(75,9,8,212),(76,9,9,323),(77,9,10,253),(78,9,11,312),(79,11,1,302),(80,11,2,255),(81,11,3,219),(82,14,1,267),(83,14,2,209),(84,14,3,185),(85,14,4,519),(86,14,5,205),(87,14,6,185),(88,14,7,299),(89,14,8,407),(89,30,8,216),(90,19,1,333),(91,22,1,342),(92,22,2,253),(93,22,3,195),(94,22,5,286),(95,22,6,573),(96,22,7,239),(97,22,8,325),(98,22,9,153),(99,24,1,236),(100,24,2,210),(101,24,3,297),(102,24,4,360),(103,24,5,327),(104,24,6,351),(105,24,7,311),(106,24,8,305),(107,24,9,246),(108,24,10,319),(109,24,11,318),(110,24,12,286),(111,24,13,252),(112,24,14,290),(113,24,15,346),(114,24,16,185),(115,24,17,236),(116,25,1,200),(117,25,2,212),(118,25,3,189),(119,25,4,223),(120,25,5,198),(121,25,6,205),(122,25,7,293),(123,25,8,233),(124,25,9,257),(125,25,10,239),(126,25,11,210),(127,25,12,277),(128,23,1,206),(129,23,2,245),(130,23,3,183),(131,23,4,233),(132,23,5,304),(133,23,6,166),(134,23,7,277),(135,23,8,192),(136,23,9,221),(137,23,10,260),(138,26,1,203),(139,26,2,229),(140,26,3,186),(141,44,9,213),(142,26,5,262),(143,26,6,195),(144,26,7,211),(145,26,8,223),(146,26,9,234),(147,26,10,195),(148,26,11,230),(149,26,12,253),(151,27,1,456),(152,27,2,234),(153,27,3,354),(154,27,4,345),(155,27,5,234),(156,27,6,423),(157,27,7,345),(158,27,8,243),(159,27,9,264),(160,27,10,287),(161,27,11,358),(162,27,12,378),(163,27,13,303),(164,27,14,345),(165,28,1,138),(166,28,2,184),(167,28,3,177),(168,28,4,184),(169,28,5,167),(170,28,6,133),(171,28,7,170),(172,28,8,240),(173,28,9,241),(174,28,10,159),(175,28,11,219),(176,28,12,98),(177,28,13,234),(178,30,1,185),(179,30,2,155),(180,30,3,212),(181,30,4,200),(182,30,5,208),(183,30,6,183),(184,30,7,189),(185,30,9,184),(186,30,10,194),(187,30,11,157),(188,30,12,191),(189,31,1,216),(190,31,2,183),(191,31,3,189),(192,31,4,240),(193,31,5,202),(194,31,6,197),(195,31,7,217),(196,31,8,235),(197,31,9,185),(198,31,10,211),(199,31,11,245),(200,32,1,193),(201,32,2,232),(202,32,3,254),(203,32,4,219),(204,32,5,251),(205,32,6,278),(206,32,7,240),(207,32,8,325),(208,32,9,152),(209,32,10,242),(210,32,11,163),(211,32,12,250),(212,32,13,289),(224,33,1,330),(225,33,2,330),(226,33,3,330),(227,33,4,330),(228,33,5,330),(229,33,6,330),(230,33,7,333),(230,63,4,120),(231,33,8,333),(231,63,5,120),(232,33,9,333),(232,63,6,120),(233,33,10,333),(233,63,7,120),(234,33,11,333),(234,63,8,120),(235,33,12,333),(235,63,9,120),(236,35,1,12156),(237,34,1,217),(238,34,2,56),(239,34,3,259),(240,26,13,243),(241,38,1,262),(242,38,2,214),(243,38,3,255),(244,38,4,197),(245,38,5,195),(246,38,6,192),(247,38,7,189),(248,38,8,248),(249,39,1,239),(249,51,1,239),(250,39,2,316),(250,51,2,376),(251,39,3,277),(252,39,4,271),(252,51,4,331),(253,39,5,244),(253,51,5,304),(254,39,6,210),(254,51,6,270),(255,39,7,284),(255,51,7,344),(256,39,8,262),(256,51,8,322),(257,39,9,336),(257,51,9,420),(258,39,10,283),(258,51,10,450),(259,39,11,263),(259,51,11,300),(260,39,12,374),(260,51,12,349),(261,42,1,222),(262,42,2,223),(263,42,3,224),(264,42,4,120),(265,42,5,150),(266,42,6,150),(267,42,7,300),(268,42,8,240),(269,42,9,180),(270,42,10,190),(271,42,11,170),(272,42,12,100),(273,42,13,100),(274,42,14,90),(275,43,1,240),(276,43,2,202),(277,43,3,245),(278,43,4,205),(279,43,5,320),(280,43,6,246),(281,43,7,255),(282,43,8,302),(283,43,9,323),(284,43,10,258),(285,44,1,225),(286,44,2,237),(287,44,3,188),(288,44,4,130),(289,44,5,246),(290,44,6,173),(291,44,7,227),(292,44,8,201),(293,44,10,217),(294,44,11,195),(295,44,12,203),(296,45,1,295),(297,45,2,273),(298,45,3,229),(299,45,4,327),(300,45,5,115),(301,45,6,287),(302,45,7,255),(303,45,8,357),(304,45,9,218),(305,45,10,238),(306,48,1,260),(307,48,2,260),(308,46,1,562),(309,46,2,586),(310,46,3,487),(311,46,4,693),(312,46,5,566),(313,46,6,572),(314,47,1,225),(315,47,2,260),(316,47,3,288),(317,47,4,212),(318,47,5,195),(319,47,6,302),(320,47,7,175),(321,47,8,194),(322,47,9,231),(323,47,10,310),(324,47,11,165),(325,47,12,248),(326,47,13,210),(327,47,14,421),(328,49,1,255),(329,49,2,200),(330,49,3,234),(331,49,4,274),(332,49,5,185),(333,49,6,197),(334,49,7,246),(335,49,8,247),(336,49,9,156),(337,49,10,182),(338,49,11,236),(339,51,3,337),(340,50,1,95),(341,50,2,264),(342,50,3,451),(343,50,4,89),(344,50,5,380),(345,50,6,426),(346,50,7,749),(347,50,8,298),(348,50,9,379),(349,50,10,522),(354,63,22,120),(360,54,1,13),(361,54,2,187),(362,54,3,175),(363,54,4,175),(364,54,5,164),(365,54,6,204),(366,54,7,162),(367,54,8,197),(368,54,9,196),(369,54,10,153),(370,54,11,178),(371,54,12,203),(372,54,13,185),(373,53,1,284),(374,53,2,383),(375,53,3,267),(376,53,4,264),(377,53,5,299),(378,53,6,261),(379,53,7,117),(380,53,8,230),(381,53,9,285),(382,53,10,228),(383,53,11,279),(384,53,12,324),(385,56,1,212),(386,56,2,209),(387,56,3,192),(388,56,4,247),(389,56,5,370),(390,56,6,276),(391,56,7,411),(392,56,8,206),(393,56,9,450),(394,57,1,336),(395,57,2,288),(396,57,3,382),(397,57,5,256),(398,57,6,219),(399,57,7,266),(400,57,8,243),(401,57,9,243),(402,60,1,223),(403,60,2,251),(404,60,3,530),(405,60,4,310),(406,60,5,190),(407,60,6,156),(408,60,7,240),(409,60,8,323),(410,60,9,321),(411,60,10,564),(412,58,1,178),(413,58,2,292),(414,58,3,223),(415,58,4,296),(416,58,5,299),(417,58,6,211),(418,58,7,324),(419,58,8,234),(420,58,9,246),(421,58,10,215),(422,58,11,213),(423,58,12,361),(424,58,13,708),(425,58,14,257),(426,61,1,234),(427,61,2,137),(428,61,3,311),(429,61,4,582),(430,61,5,143),(431,61,6,431),(432,61,7,244),(433,61,8,431),(434,61,9,238),(448,62,1,204),(449,62,2,28),(450,62,3,704),(451,63,1,162),(452,63,2,135),(453,63,3,134),(454,63,10,120),(455,63,11,120),(456,63,12,120),(457,63,13,120),(458,63,14,120),(459,63,15,120),(460,63,17,120),(461,63,18,120),(462,63,19,120),(463,63,20,120),(464,63,21,120),(465,63,23,120),(466,64,1,215),(467,64,2,203),(468,64,3,139);
/*!40000 ALTER TABLE `AlbumSongs` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;

--
-- Table structure for table `Albums`
--

DROP TABLE IF EXISTS `Albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Albums` (
  `AlbumID` int(11) NOT NULL AUTO_INCREMENT,
  `AlbumTitle` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `AlbumYear` int(11) DEFAULT NULL,
  `BandID` int(11) NOT NULL DEFAULT '0',
  `AlbumNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`AlbumID`),
  FOREIGN KEY (`BandID`) REFERENCES Bands(`BandID`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Albums`
--

/*--LOCK TABLES `Albums` WRITE;*/;
/*!40000 ALTER TABLE `Albums` DISABLE KEYS */;
INSERT INTO `Albums` VALUES (1,'Waiting For Gabe',2002,3,1),(2,'Remedy',1999,1,1),(3,'the red one',2001,1,2),(4,'A Live Album',2002,1,3),(5,'magnify',2004,1,4),(7,'Turnaround',2003,4,5),(8,'War',1983,5,6),(9,'Joshua Tree',1987,5,0),(10,'Nothing else Matters',0,6,0),(11,'Nevermind',1991,7,0),(14,'Fly By Night',1975,9,2),(15,'1999',0,1,1999),(16,'And Then Nothing Turned Itself',2000,10,11),(17,'Nothing Is Shocking',1989,0,2),(18,'as',1111,11,0),(19,'ddd',1111,12,0),(22,'Ritual de lo Habitual',1990,13,3),(23,'Sacred Love',2003,14,0),(24,'A-Sides',1997,15,6),(25,'Elvis In Person',1992,16,99),(26,'Black and Blue',2000,17,3),(27,'Look in the Mirror',2004,18,5),(28,'Shadow Zone',2003,19,0),(29,'August and Everything After',1993,20,0),(30,'Hybrid Theory',2000,21,1),(31,'Smalltown Poets',1997,22,1),(32,'Odelay',1995,23,3),(33,'Metallica',1991,24,11),(34,'Diplomatic Immunity',2003,25,1),(35,'look on you',2004,26,0),(36,'Straight Ahead',2000,27,0),(37,'b',0,12,0),(38,'200KM/H IN THE WRONG LANE',2002,28,2002),(39,'Desireless',1998,29,1),(41,'Hard Promises',1981,0,4),(42,'I Hope You Win!',2000,32,1),(43,'Pretty Hate Machine',1989,33,1),(44,'A Long Road To Nowhere',2003,34,1),(45,'Gnashed Senses And Crossfire',1989,35,9),(46,'Kind of Blue',1959,36,0),(47,'Some Devil',2003,37,1),(48,'The Wraith',2003,38,6),(49,'melt',2002,39,1),(50,'Deloused in The Comatorium',2003,40,2),(51,'Deriseless',1998,29,1),(52,'Meteo',2002,21,4),(53,'OK Computer',1997,41,4),(54,'Meteora',2003,21,3),(55,'Who We Are Instead',2003,42,8),(56,'The Days of Wine & Roses',1982,43,1),(57,'Led Zeppelin II',1969,44,2),(58,'Fight For Your Mind',1995,45,3),(59,'Kid A',2000,41,0),(60,'Kid',2000,41,0),(61,'Drive Like Jehu',1991,46,1),(62,'Homework',1996,47,1),(63,'The very Best ot the Seekers',1998,48,0),(64,'Swiss Army Romance',2003,49,10),(66,'Decline and Fall of Heavenly',1990,51,1);
/*!40000 ALTER TABLE `Albums` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;

--
-- Table structure for table `BandMusicians`
--

DROP TABLE IF EXISTS `BandMusicians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BandMusicians` (
  `MusicianID` int(11) NOT NULL DEFAULT '0',
  `BandID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`MusicianID`,`BandID`),
  FOREIGN KEY (`MusicianID`) REFERENCES Musicians(`MusicianID`),
  FOREIGN KEY (`BandID`) REFERENCES Bands(`BandID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BandMusicians`
--

/*--LOCK TABLES `BandMusicians` WRITE;*/;
/*!40000 ALTER TABLE `BandMusicians` DISABLE KEYS */;
INSERT INTO `BandMusicians` VALUES (1,1),(2,1),(3,1),(4,1),(7,3),(8,3),(9,3),(10,3),(11,4),(12,4),(13,4),(14,4),(15,4),(16,5),(17,5),(18,5),(19,5),(20,7),(21,7),(22,7),(26,9),(27,9),(28,9),(29,11),(30,11),(31,11),(32,12),(33,13),(34,13),(35,13),(36,13),(37,14),(38,15),(39,15),(40,15),(41,15),(42,16),(43,18),(44,17),(45,17),(46,17),(47,17),(48,17),(49,20),(50,20),(51,20),(52,20),(53,20),(54,21),(55,21),(56,21),(57,21),(58,21),(59,21),(60,22),(61,22),(62,22),(63,22),(64,22),(65,23),(66,24),(67,24),(68,24),(69,24),(70,25),(71,25),(72,25),(73,12),(74,12),(75,12),(76,12),(77,28),(78,28),(79,29),(80,32),(81,33),(82,34),(83,35),(84,35),(85,37),(86,37),(87,37),(88,37),(89,36),(90,36),(91,36),(92,36),(93,36),(94,36),(95,38),(96,38),(97,39),(98,39),(99,39),(100,40),(101,40),(102,40),(103,40),(104,40),(105,40),(106,41),(107,41),(108,41),(109,41),(110,44),(111,44),(112,44),(113,44),(114,43),(115,43),(116,43),(117,43),(118,42),(119,42),(120,42),(121,42),(122,45),(123,46),(124,46),(125,46),(126,46),(127,47),(128,47),(129,48),(130,48),(131,48),(132,48),(133,49),(134,50),(135,50),(136,50),(137,51),(138,51),(139,51),(140,51);
/*!40000 ALTER TABLE `BandMusicians` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;

--
-- Table structure for table `Bands`
--

DROP TABLE IF EXISTS `Bands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bands` (
  `BandID` int(11) NOT NULL AUTO_INCREMENT,
  `BandName` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`BandID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bands`
--

/*--LOCK TABLES `Bands` WRITE;*/;
/*!40000 ALTER TABLE `Bands` DISABLE KEYS */;
INSERT INTO `Bands` VALUES (1,'Remedy'),(2,'Simon and Garfunkel'),(3,'Waiting for Gabe'),(4,'Westlife'),(5,'U2'),(6,'asdf'),(7,'Nirvana'),(9,'Rush'),(10,'Yo La Tengo'),(11,'a'),(12,'b'),(13,'Janes Addiction'),(14,'Sting'),(15,'Soundgarden'),(16,'Elvis Presley'),(17,'Backstreet Boys'),(18,'Korn'),(19,'Disturbed'),(20,'Counting Crows'),(21,'Linkin Park'),(22,'Smalltown Poets'),(23,'Beck'),(24,'Metallica'),(25,'The Diplomats'),(26,'the strong heads'),(27,'Pennywise'),(28,'t.A.T.u.'),(29,'Eagle Eye Cherry'),(30,'Tom Petty and the Heartbreaker'),(31,'Tom Petty and the Heartbreaker'),(32,'Corn Mo'),(33,'Nine Inch Nails'),(34,'Doc Adams'),(35,'Front Line Assembly'),(36,'Miles Davis & Co.'),(37,'Dave Matthews'),(38,'Insane Clown Posse'),(39,'Rascale Flatts'),(40,'The Mars Volta'),(41,'Radiohead'),(42,'Jars of Clay'),(43,'Dream Syndicate'),(44,'Led Zeppelin'),(45,'Ben Harper'),(46,'Drive Like Jehu'),(47,'Daft Punk'),(48,'Seekers'),(49,'Dashboard Confessional'),(50,'chao'),(51,'Decline and Fall of Heavenly');
/*!40000 ALTER TABLE `Bands` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;

--
-- Table structure for table `Musicians`
--

DROP TABLE IF EXISTS `Musicians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Musicians` (
  `MusicianID` int(11) NOT NULL AUTO_INCREMENT,
  `MusicianFirstName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MusicianLastName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MusicianCountry` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MusicianID`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Musicians`
--

/*--LOCK TABLES `Musicians` WRITE;*/;
/*!40000 ALTER TABLE `Musicians` DISABLE KEYS */;
INSERT INTO `Musicians` VALUES (1,'Daniel','Zach','USA'),(2,'David','Zach','USA'),(3,'Phil','Zach','USA'),(4,'Paul','Zach','USA'),(5,'Paul','Simon','USA'),(6,'Art','Garfunkel','USA'),(7,'Ryan','Onstad','USA'),(8,'Gabriel','Lovelace','USA'),(9,'Mark','Hustad','USA'),(10,'Eric','Hustad','USA'),(11,'Nicky',NULL,'UK'),(12,'Shane',NULL,'UK'),(13,'Bryan',NULL,'UK'),(14,'Kian',NULL,'UK'),(15,'Mark',NULL,'UK'),(16,'Bono',NULL,'Ireland'),(17,'Adam','Clayton','Ireland'),(18,'The','Edge','Ireland'),(19,'Larry','Mullen','Ireland'),(20,'Kurt','Cobain','USA'),(21,'Chad','Channing','USA'),(22,'Pat','Smear','USA'),(26,'Neil','Peart','Canada'),(27,'Geddy','Lee','Canada'),(28,'Alex','Lifeson','Canada'),(29,'asdf','asdf',''),(30,'fgds','sdfg',''),(31,'qwre','qret',''),(32,'aasfas','asdff',''),(33,'Perry','Farrell','USA'),(34,'Dave','Navarro','USA'),(35,'Stephen','Perkins','USA'),(36,'Eric','Avery','USA'),(37,'Gordon','Sumner','England'),(38,'Chris','Cornell','USA'),(39,'Kim','Thayil','USA'),(40,'Ben','Shepherd','USA'),(41,'Matt','Cameron','USA'),(42,'Elvis','Presley','USA'),(43,'Jon','','Davis'),(44,'Nick','Carter','USA'),(45,'Howard Dwaine','Dorough','USA'),(46,'Brian','Littrell','USA'),(47,'A.J.','McLean','USA'),(48,'Kevin','Richardson','USA'),(49,'Matt','Malley','USA'),(50,'Charlie','Gillingham','USA'),(51,'Adam','Duritz','USA'),(52,'Steve','Bowman','USA'),(53,'David','Bryson','USA'),(54,'Brad','A','USA'),(55,'Rob','B','USA'),(56,'Mike','C','USA'),(57,'Chester','D','USA'),(58,'Joe','E','USA'),(59,'Phoenix','F','USA'),(60,'Michael','Johnson','USA'),(61,'Danny','Stephens','USA'),(62,'Byron','Goggin','USA'),(63,'Miguel','Dejesus','USA'),(64,'Kevin','Breuner','USA'),(65,'Beck','Hansen','USA'),(66,'James','Hetfield','USA'),(67,'Lars','Ulrich','USA'),(68,'Jason','Newsted','USA'),(69,'Cliff','Burton','USA'),(70,'Davis','','USA'),(71,'Jimmy','','USA'),(72,'Andrew','','USA'),(73,'bob','bobberson','Chicago'),(74,'d','bre','bd'),(75,'f','',''),(76,'','',''),(77,'Lina','Katina','Russia'),(78,'Julia','Volkova','Russia'),(79,'Eagle Eye','Cherry','USA'),(80,'Jon','Cunningham','USA'),(81,'Trent','Reznor','USA'),(82,'Mark','Adams','USA'),(83,'Bill','Leeb','USA'),(84,'Michael','Balch','USA'),(85,'Dave','Matthews','South Africa'),(86,'Tre','Anastasio','USA'),(87,'Tim','Reynolds','USA'),(88,'Adam','Smith','USA'),(89,'Miles','Davis','USA'),(90,'John','Coltrane','USA'),(91,'Bill','Evans','USA'),(92,'Cannonball','Adderley','USA'),(93,'Jimmy','Cobb','USA'),(94,'Wynton','Kelly','USA'),(95,'Violent','J','USA'),(96,'Shaggy','2Dope','USA'),(97,'Jeffrey','Steele','USA'),(98,'Danny','Wells','USA'),(99,'Steve','Robson','USA'),(100,'Omar','Rodriguez-Lopez','USA'),(101,'Cedric','Bixler Zavala','USA'),(102,'Jon','Theodore','USA'),(103,'Jeremy Michael','Ward','USA'),(104,'Flea','','USA'),(105,'Ikey Isaiah','Owens','USA'),(106,'Thom','Yorke','Britain'),(107,'Jonny','Greenwood','Britain'),(108,'Colin','Greenwood','Britain'),(109,'Phil','Selway','Britain'),(110,'Jimmy','Page','England'),(111,'Robert','Plant','England'),(112,'John Paul','Jones','England'),(113,'John','Bonham','England'),(114,'Steve','Wynn','USA'),(115,'Karl','Precoda','USA'),(116,'Dennis','Duck','USA'),(117,'Kendra','Smith','USA'),(118,'Dan','Haseltine','USA'),(119,'Matt','Odmark','USA'),(120,'Steve','Mason','USA'),(121,'Charlie','Lowell','USA'),(122,'Ben','Harper','USA'),(123,'John','Reis','USA'),(124,'Rick','Farr','USA'),(125,'Mike','Kennedy','USA'),(126,'Mark','Trombino','USA'),(127,'Thomas','Bangalter','France'),(128,'Guy-Manuel','Homem-Christo','France'),(129,'Judith','Durham','Australia'),(130,'Athol','Guy','Australia'),(131,'Bruce','Woodley','Australia'),(132,'Keith','Potger','Australia'),(133,'Chris','Carrabba','USA'),(134,'chao','er','er'),(135,'cga','er','er'),(136,'er','er','er'),(137,'A','B','C'),(138,'A','D','C'),(139,'D','D','C'),(140,'E','A','C');
/*!40000 ALTER TABLE `Musicians` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;

--
-- Table structure for table `Songs`
--

DROP TABLE IF EXISTS `Songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Songs` (
  `SongID` int(11) NOT NULL AUTO_INCREMENT,
  `SongTitle` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`SongID`)
) ENGINE=InnoDB AUTO_INCREMENT=481 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Songs`
--

/*--LOCK TABLES `Songs` WRITE;*/;
/*!40000 ALTER TABLE `Songs` DISABLE KEYS */;
INSERT INTO `Songs` VALUES (1,'maginfiy'),(2,'ancient of days'),(3,'colors'),(4,'clive staples'),(5,'enthroned'),(6,'still cloud\'s shadow'),(7,'hold the line'),(8,'fire eyes'),(9,'echoes'),(10,'daystar'),(11,'in a moment'),(12,'smile upon me'),(13,'perfect place'),(14,'cleft'),(15,'balm'),(16,'desert flood'),(17,'behind the skies'),(18,'martyr song'),(19,'westwood terrace'),(20,'deep center rest'),(21,'sapphire'),(22,'the calling'),(23,'destiny'),(24,'fog'),(25,'lay aside'),(26,'picture in my mind'),(27,'thorn'),(28,'starr street'),(29,'the day'),(30,'where you belong'),(31,'one remedy'),(34,'purple jam'),(35,'glitter'),(36,'no shadow of a doubt'),(37,'westonhill drive'),(38,'priceless'),(39,'Mandy'),(40,'Hey Whatever'),(41,'Heal'),(42,'Obvious'),(43,'When a Woman Loves a Man'),(44,'On My Shoulder'),(45,'Turn Around'),(46,'I Did It For You'),(47,'Thank You'),(48,'To Be With You'),(49,'Home'),(50,'Lost In You'),(51,'What Do They Know'),(52,'DATA'),(53,'Sunday Bloody Sunday'),(54,'Seconds'),(55,'New Year\'s Day'),(56,'Like a Song'),(57,'Drowning Man'),(58,'The Refugee'),(59,'Two Hearts Beat as One'),(60,'Red Light'),(61,'Surrender'),(62,'\"40\"'),(63,'Walking The Line'),(64,'Fine'),(65,'Insane'),(66,'For Love Forever'),(67,'Fervor'),(68,'Where the streets have no name'),(69,'I still haven\'t found what I\'m looking for'),(70,'With or without you'),(71,'Bullet the blue sky'),(72,'Running to stand still'),(73,'Red Hill Mining Town'),(74,'In God\'s Country'),(75,'Trip through your wires'),(76,'One tree hill'),(77,'Exit'),(78,'Mothers of the disappeared'),(79,'Smells Like Teen Spirit'),(80,'In Bloom'),(81,'Come As You Are'),(82,'Anthem'),(83,'Best I Can'),(84,'Beneath, Between, Behind'),(85,'By-Tor And The Snow Dog'),(86,'Fly By Night'),(87,'Making Memories'),(88,'Rivendell'),(89,'In The End'),(90,'sadf'),(91,'Stop'),(92,'No One\'s Leaving'),(93,'Ain\'t No Right'),(94,'Been Caught Stealing'),(95,'Three Days'),(96,'Then She Did'),(97,'Of Course'),(98,'Classic Girl'),(99,'Nothing to say'),(100,'Flower'),(101,'Loud Love'),(102,'Hands All Over'),(103,'Get On the Snake'),(104,'Pose'),(105,'Outshined'),(106,'Rusty Cage'),(107,'Spoonman'),(108,'The Day I Tried To Live'),(109,'Black Hole Sun'),(110,'Fell On Black Days'),(111,'Pretty Noose'),(112,'Burden In My Hand'),(113,'Blow Up The Outside World'),(114,'Ty Cobb'),(115,'Bleed Together'),(116,'Blue Suede Shoes'),(117,'Johnny B. Goode'),(118,'All Shook Up'),(119,'Are You Lonesome Tonight?'),(120,'Hound Dog'),(121,'I Can\'t Stop Loving You'),(122,'My Babe'),(123,'Medley: Myster Train/Tiger Man'),(124,'Words'),(125,'In The Ghetto'),(126,'Suspicious'),(127,'Can\'t Help Falling in Love'),(128,'Inside'),(129,'Send Your Love'),(130,'Whenever I Say Your Name (with Mary J. Blige)'),(131,'Dead Man\'s Rope'),(132,'Never Coming Home'),(133,'Like a Beautiful Smile'),(134,'Let\'s Forget About the Future'),(135,'This War'),(136,'The Book of My Life'),(137,'Sacred Love'),(138,'The Call'),(139,'Shape Of My Heart'),(140,'Get Another Boyfriend'),(141,'Shining Star'),(142,'I Promise You'),(143,'The Answer To Our Life'),(144,'Everyone'),(145,'More Than That'),(146,'Time'),(147,'Not For Me'),(148,'Yes I Will'),(149,'It\'s True'),(150,'How Did I Fall In Love With You'),(151,'1. Right Now - Dirty Version'),(152,'Break Some Off'),(153,'Counting On Me'),(154,'Here It Comes Again'),(155,'Deep Inside'),(156,'Did My Time'),(157,'Everything I\'ve Known'),(158,'Play Me (featuring Nas)'),(159,'Alive'),(160,'Let\'s Do This Now'),(161,'I\'m Done'),(162,'Ya\'ll Want A Single'),(163,'When Will This End'),(164,'One'),(165,'Destroy'),(166,'Control It'),(167,'New Pain'),(168,'Shadow Zone'),(169,'Dead World'),(170,'Monster World'),(171,'The Only'),(172,'Kill your Idols'),(173,'All in Wait'),(174,'Otsegolectric'),(175,'So'),(176,'Transmission'),(177,'Invincible'),(178,'Papercut'),(179,'One Step Closer'),(180,'With You'),(181,'Points of Authority'),(182,'Crawling'),(183,'Runaway'),(184,'By Myself'),(185,'Place For My Head'),(186,'Forgotten'),(187,'Mr. Hahn'),(188,'Pushing Me Away'),(189,'Prophet, Priest and King'),(190,'If You\'ll Let Me Love You'),(191,'Everything I Hate'),(192,'I\'ll Give'),(193,'Anymore'),(194,'Who You Are'),(195,'Scenario'),(196,'There\'s A Day'),(197,'Monkey\'s Paw'),(198,'Trust'),(199,'Inside The Bubble'),(200,'Devils Haircut'),(201,'Hot Wax'),(202,'Lord Only Knows'),(203,'The New Polution'),(204,'Derelict'),(205,'Novacaine'),(206,'Jack-Ass'),(207,'Where it\'s At'),(208,'Minus'),(209,'Sissyneck'),(210,'Ready Made'),(211,'High 5'),(212,'Ramshackle'),(213,'Round Here'),(214,'Omaha'),(215,'Mr. Jones'),(216,'Perfect Blue Buildings'),(217,'Anna Begins'),(218,'Time and Time Again'),(219,'Rain King'),(220,'Sullivan Street'),(221,'Ghost Train'),(222,'Raining in Baltimore'),(223,'A Murder of One'),(224,'Enter Sandman'),(225,'Sad but True'),(226,'Holier Than Thou'),(227,'Unforgiven'),(228,'Whereever I May Roam'),(229,'Dont Tread On Me'),(230,'a'),(231,'b'),(232,'c'),(233,'d'),(234,'e'),(235,'f'),(236,'hello i am cool'),(237,'Un Casa'),(238,'Julez Santana'),(239,'Who am I'),(240,'How Did I Fall In Love With Your'),(241,'Not Gonna Get Us'),(242,'All The Things She Said'),(243,'Show Me Love'),(244,'30 Minutes'),(245,'How Soon Is Now?'),(246,'Clowns(can you see me now?)'),(247,'Malchik Gay'),(248,'Stars'),(249,'Save Tonight'),(250,'Indecision'),(251,'Comatose'),(252,'Worried Eyes'),(253,'Rainbow Wings'),(254,'Falling In Love Again'),(255,'Conversation'),(256,'When Mermaids Cry'),(257,'Shooting Up In Vain'),(258,'Permanent Tears'),(259,'Death Defied By Will'),(260,'Desireless'),(261,'Junior High'),(262,'Goodbye For Now'),(263,'Hersey\'s Miniatures'),(264,'Plucky'),(265,'Wet Dog'),(266,'Game On'),(267,'Bummer'),(268,'My Epilady'),(269,'Bony Fishsteaks'),(270,'Just Some Kid on A Bike'),(271,'Lunch, Desert & Mail'),(272,'Shine On, Golden Warrior'),(273,'Puttin\'up'),(274,'Eeyore'),(275,'Head Like A Hole'),(276,'Terrible Lie'),(277,'Down In It'),(278,'Sanctified'),(279,'Something I Can Never Have'),(280,'Kinda I Want To'),(281,'Sin'),(282,'That\'s What I Get'),(283,'The Only Time'),(284,'Ringfinger'),(285,'Platypus'),(286,'One And Only'),(287,'I\'m Alright'),(288,'Bobbylicious(LIVE)'),(289,'Grass on The Other Side'),(290,'At First Sight'),(291,'Sending You'),(292,'Border Line'),(293,'A Long Road To Nowhere'),(294,'Crazy'),(295,'Stationary(LIVE)'),(296,'no limit'),(297,'antisocial'),(298,'hypocrisy'),(299,'shutdown'),(300,'prayer'),(301,'digital tension dementia'),(302,'big money'),(303,'bloodsport'),(304,'foolsgame'),(305,'sedation'),(306,'Juggalo Homies'),(307,'The Unvailing'),(308,'So What'),(309,'Freddie Freeloader'),(310,'Blue In Green'),(311,'All Blues'),(312,'Flamenco Sketches'),(313,'Flamenco Sketches (alt. take)'),(314,'Dodo'),(315,'So Damn Lucky'),(316,'Gravedigger'),(317,'Some Devil'),(318,'Grey Blue Eyes'),(319,'Trouble'),(320,'Save Me'),(321,'Stay Or Leave'),(322,'An\' Another Thing'),(323,'Oh'),(324,'Baby'),(325,'Up and Away'),(326,'Too High'),(327,'Gravedigger (acoustic)'),(328,'THESE DAYS'),(329,'TOO GOOD IS TRUE'),(330,'I MELT'),(331,'MAYBERRY'),(332,'LOVE YOU OUT LOUD'),(333,'DRY COUNTRY GIRL'),(334,'LIKE I AM'),(335,'YOU'),(336,'FALLIN UPSIDE DOWN'),(337,'SHINE ON'),(338,'MY WORST FEAR'),(339,'Comatose (In the arm of Slumber)'),(340,'Son Et Lumiere'),(341,'Inertiatic ESP'),(342,'Roulette Dares(The Haunt of)'),(343,'Tira Me a Las Aranas'),(344,'Drunkenship of Lanterns'),(345,'Eriatarka'),(346,'Cicatriz ESP'),(347,'This Apparatus Must Be Unearthed'),(348,'Televators'),(349,'Take the Veil Cerpin Taxt'),(350,'asdfsa'),(351,'adsf'),(352,'asdfff'),(353,'sdfddf'),(354,'s'),(355,'sd'),(356,'fa'),(357,'asss'),(358,'aa'),(359,'dfff'),(360,'Foreward'),(361,'Don\'t Stay'),(362,'Somewhere I Belong'),(363,'Lying From You'),(364,'Hit the Floor'),(365,'Easier to Run'),(366,'Faint'),(367,'Figure .09'),(368,'Breaking the Habit'),(369,'From the Inside'),(370,'Nobody\'s Listening'),(371,'Session'),(372,'Numb'),(373,'Airbag'),(374,'Paranoid Android'),(375,'Subterranean Homesick Alien'),(376,'Exit Music (For a Film)'),(377,'Let Down'),(378,'Karma Police'),(379,'Fitter Happier'),(380,'Electioneering'),(381,'Climbing up the Walls'),(382,'No Surprises'),(383,'Lucky'),(384,'The Tourist'),(385,'Tell Me When It\'s Over'),(386,'Definitely Clean'),(387,'That\'s What You Always Say'),(388,'Then She Remembers'),(389,'Halloween'),(390,'When You Smile'),(391,'Until Lately'),(392,'Too Little, Too Late'),(393,'Days of Wine and Roses'),(394,'Whole Lotta Love'),(395,'What Is and What Should Never Be'),(396,'The Lemon Song'),(397,'Heartbreaker'),(398,'Living Loving Maid'),(399,'Ramble On'),(400,'Moby Dick'),(401,'Bring It On Home'),(402,'everything in its right place'),(403,'kid a'),(404,'national anthem'),(405,'how to disappear'),(406,'treefingers'),(407,'optimistic'),(408,'in limbo'),(409,'idioteque'),(410,'morning bell'),(411,'motion picture soundtrack'),(412,'Opression'),(413,'Ground On Down'),(414,'Another Lonely Day'),(415,'Please Me Like You Want To'),(416,'Gold To Me'),(417,'Burn One Down'),(418,'Excuse Me Mr.'),(419,'People Lead'),(420,'Fight For Your Mind'),(421,'Give A Man A Home'),(422,'By My Side'),(423,'Power Of The Gospel'),(424,'God Fearing Man'),(425,'One Road To Freedom'),(426,'Caress'),(427,'Spikes to You'),(428,'Step On Chameleon'),(429,'O Pencil Sharp'),(430,'Atom Jack'),(431,'If It Kills You'),(432,'Good Luck In Jail'),(433,'Turn it Off'),(434,'Future Home of Stucco Monstrosity'),(435,'Sunny Days'),(436,'Amazing Grace'),(437,'Lonely People'),(438,'Only Alive'),(439,'Trouble Is'),(440,'Faith Enough'),(441,'Show You Love'),(442,'Lesser Things'),(443,'I\'m In The Way'),(444,'Jesus Blood Never Failed'),(445,'Jealous Kind'),(446,'Sing'),(447,'My Heavenly'),(448,'Daftendirekt'),(449,'WDPK 83.7 FM'),(450,'Revolution 909'),(451,'I\'ll never find another you'),(452,'Open up them Pearly Gates'),(453,'This little light'),(454,'g'),(455,'h'),(456,'i'),(457,'j'),(458,'k'),(459,'l'),(460,'m'),(461,'o'),(462,'p'),(463,'q'),(464,'r'),(465,'t'),(466,'Screaming Infidelities'),(467,'The Sharp Hint Of New Tears'),(468,'Living In Your Letters'),(469,''),(470,'er'),(471,'re'),(472,'De'),(473,'AD'),(474,'DASE'),(475,'ESA'),(476,'ESAA'),(477,'ESAE'),(478,'FGG'),(479,'HGE'),(480,'EEEE');
/*!40000 ALTER TABLE `Songs` ENABLE KEYS */;
/*--UNLOCK TABLES;*/;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-12-13 12:40:46
