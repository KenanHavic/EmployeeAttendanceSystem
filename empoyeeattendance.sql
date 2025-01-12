-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: employeeattendance
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `pozicija` varchar(255) NOT NULL,
  `datum_zaposlenja` date NOT NULL,
  `korisnicko_ime` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL DEFAULT 'User',
  `prijava_vrijeme` timestamp NULL DEFAULT NULL,
  `odjava_vrijeme` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `korisnicko_ime` (`korisnicko_ime`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Amir Hasanović','Software Engineer','2024-01-15','amir.h','amir123','Employee','2025-01-09 19:46:46',NULL),(2,'Selma Dedić','HR Manager','2024-02-20','selma.d','selma456','Employee',NULL,NULL),(3,'Nedim Kovačević','Accountant','2024-03-10','nedim.k','nedim789','Employee',NULL,NULL),(4,'Azra Mulic','Product Manager','2020-05-20','lejla.h','azra','Employee',NULL,NULL),(7,'Adnan Mujagić','Graphic Designer','2024-07-05','adnan.m','adnan404','Employee','2025-01-12 11:55:03',NULL),(8,'Amra Begić','Operations Manager','2024-08-12','amra.b','amra505','Employee',NULL,NULL),(9,'Ibrahim Čengić','System Administrator','2024-09-02','ibrahim.c','ibrahim606','Employee',NULL,NULL),(10,'Sabina Mešić','Project Coordinator','2024-10-25','sabina.m','sabina707','Employee',NULL,NULL),(11,'Mirsad Zukić','Legal Advisor','2024-11-15','mirsad.z','mirsad808','Employee',NULL,NULL),(12,'Amina Mekić','Public Relations Officer','2024-12-01','amina.m','amina909','Employee',NULL,NULL),(13,'Jasmin Latić','Financial Analyst','2024-01-20','jasmin.l','jasmin010','Employee',NULL,NULL),(14,'Emina Salkić','Marketing Director','2024-02-10','emina.s','emina111','Employee',NULL,NULL),(15,'Faruk Karamustafić','Data Scientist','2024-03-30','faruk.k','faruk212','Employee',NULL,NULL),(16,'Maja Salihović','UX/UI Designer','2024-04-15','maja.s','maja313','Employee',NULL,NULL),(17,'Haris Biric','Software Architect','2018-05-20','haris.b','haris414','Employee','2025-01-11 18:32:00','2025-01-11 18:32:08'),(18,'Dženita Kalac','HR Assistant','2024-06-01','dzenita.k','dzenita515','Employee',NULL,NULL),(19,'Muhamed Omerović','Business Development Manager','2024-07-25','muhamed.o','muhamed616','Employee',NULL,NULL),(20,'Elma Salkić','Senior Developer','2024-08-10','elma.s','elma717','Employee',NULL,NULL),(21,'Kenan Havic','Manager','2024-01-01','kenan.h','kenan202','Manager','2025-01-12 11:52:47',NULL),(22,'Admin','SuperAdmin','2024-01-01','admin','admin123','SuperAdmin','2025-01-12 15:04:02',NULL),(23,'Kenan Saric','QA','2020-07-20','kenoo.s','keno123','Employee',NULL,NULL),(26,'Ahmet Hadziaganovic','Software developer','2018-01-20','ahmet','ahmet','Employee',NULL,NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-12 16:07:30
