CREATE DATABASE  IF NOT EXISTS `radio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `radio`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: radio
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cargos` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cargo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'Presentador'),(2,'Director'),(3,'Productor');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compania`
--

DROP TABLE IF EXISTS `compania`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `compania` (
  `id_compania` int(11) NOT NULL AUTO_INCREMENT,
  `registrofc` varchar(50) NOT NULL,
  `nombre_compania` varchar(80) NOT NULL,
  PRIMARY KEY (`id_compania`),
  UNIQUE KEY `nombre_compania` (`nombre_compania`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compania`
--

LOCK TABLES `compania` WRITE;
/*!40000 ALTER TABLE `compania` DISABLE KEYS */;
INSERT INTO `compania` VALUES (1,'5151','Hola'),(2,'49-54554-54545-0','La Campana');
/*!40000 ALTER TABLE `compania` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consorcios`
--

DROP TABLE IF EXISTS `consorcios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consorcios` (
  `id_consorcio` int(11) NOT NULL AUTO_INCREMENT,
  `radio_consorcio` int(11) NOT NULL,
  `programa_consorcio` int(11) NOT NULL,
  `compania_consorcio` int(11) NOT NULL,
  PRIMARY KEY (`id_consorcio`),
  KEY `consorcio_radio` (`radio_consorcio`),
  KEY `consorcio_programa` (`programa_consorcio`),
  KEY `consorcio_compania` (`compania_consorcio`),
  CONSTRAINT `consorcio_compania` FOREIGN KEY (`compania_consorcio`) REFERENCES `compania` (`id_compania`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `consorcio_programa` FOREIGN KEY (`programa_consorcio`) REFERENCES `programas` (`id_programa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `consorcio_radio` FOREIGN KEY (`radio_consorcio`) REFERENCES `radio` (`id_radio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consorcios`
--

LOCK TABLES `consorcios` WRITE;
/*!40000 ALTER TABLE `consorcios` DISABLE KEYS */;
INSERT INTO `consorcios` VALUES (1,6,1,1),(3,7,1,1),(4,6,1,2);
/*!40000 ALTER TABLE `consorcios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emisiones`
--

DROP TABLE IF EXISTS `emisiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `emisiones` (
  `id_emisiones` int(11) NOT NULL AUTO_INCREMENT,
  `emision` varchar(25) NOT NULL,
  PRIMARY KEY (`id_emisiones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emisiones`
--

LOCK TABLES `emisiones` WRITE;
/*!40000 ALTER TABLE `emisiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `emisiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuentas`
--

DROP TABLE IF EXISTS `encuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `encuentas` (
  `id_encuestas` int(11) NOT NULL AUTO_INCREMENT,
  `total_encuestados` int(11) NOT NULL,
  `aprobaciones` int(11) NOT NULL,
  `rechazos` int(11) NOT NULL,
  `indiferencias` int(11) NOT NULL,
  `programa` int(11) NOT NULL,
  PRIMARY KEY (`id_encuestas`),
  KEY `programa_encuesta` (`programa`),
  CONSTRAINT `programa_encuesta` FOREIGN KEY (`programa`) REFERENCES `programas` (`id_programa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuentas`
--

LOCK TABLES `encuentas` WRITE;
/*!40000 ALTER TABLE `encuentas` DISABLE KEYS */;
INSERT INTO `encuentas` VALUES (1,100,50,25,25,2);
/*!40000 ALTER TABLE `encuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_genero` varchar(50) NOT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Deportes');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programa_radio`
--

DROP TABLE IF EXISTS `programa_radio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `programa_radio` (
  `id_programaradio` int(11) NOT NULL AUTO_INCREMENT,
  `programa` int(11) NOT NULL,
  `radio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `duracion` int(11) NOT NULL,
  `repeticion` tinyint(1) NOT NULL,
  `emisiones` int(11) NOT NULL,
  PRIMARY KEY (`id_programaradio`),
  KEY `programa_ra` (`programa`),
  KEY `radio_ra` (`radio`),
  KEY `programa_emisiones` (`emisiones`),
  CONSTRAINT `programa_emisiones` FOREIGN KEY (`emisiones`) REFERENCES `emisiones` (`id_emisiones`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `programa_ra` FOREIGN KEY (`programa`) REFERENCES `programas` (`id_programa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `radio_ra` FOREIGN KEY (`radio`) REFERENCES `radio` (`id_radio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programa_radio`
--

LOCK TABLES `programa_radio` WRITE;
/*!40000 ALTER TABLE `programa_radio` DISABLE KEYS */;
/*!40000 ALTER TABLE `programa_radio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programas`
--

DROP TABLE IF EXISTS `programas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `programas` (
  `id_programa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_programa` varchar(250) NOT NULL,
  `genero` int(11) NOT NULL,
  PRIMARY KEY (`id_programa`),
  KEY `genero_programas` (`genero`),
  CONSTRAINT `genero_programas` FOREIGN KEY (`genero`) REFERENCES `genero` (`id_genero`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programas`
--

LOCK TABLES `programas` WRITE;
/*!40000 ALTER TABLE `programas` DISABLE KEYS */;
INSERT INTO `programas` VALUES (1,'dsfdsf',1),(2,'sas',1);
/*!40000 ALTER TABLE `programas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radio`
--

DROP TABLE IF EXISTS `radio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `radio` (
  `id_radio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_radio` varchar(50) NOT NULL,
  `frecuencia` varchar(5) NOT NULL,
  `transmision` int(11) NOT NULL,
  `programa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_radio`),
  KEY `transmision_radio` (`transmision`),
  KEY `programa_radio` (`programa`),
  CONSTRAINT `programa_radio` FOREIGN KEY (`programa`) REFERENCES `programas` (`id_programa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transmision_radio` FOREIGN KEY (`transmision`) REFERENCES `tipo_transmision` (`id_transmision`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radio`
--

LOCK TABLES `radio` WRITE;
/*!40000 ALTER TABLE `radio` DISABLE KEYS */;
INSERT INTO `radio` VALUES (1,'YXY','105.7',2,1),(6,'COOL ','89.3',2,NULL),(7,'Scan','96.1',2,NULL),(8,'s','105.7',2,NULL),(9,'radiohh','51.3',1,NULL);
/*!40000 ALTER TABLE `radio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `telefonos` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `telefono1` varchar(9) NOT NULL,
  `compania` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono`),
  KEY `compania_telefono` (`compania`),
  CONSTRAINT `compania_telefono` FOREIGN KEY (`compania`) REFERENCES `compania` (`id_compania`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_transmision`
--

DROP TABLE IF EXISTS `tipo_transmision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_transmision` (
  `id_transmision` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_transmision` varchar(2) NOT NULL,
  PRIMARY KEY (`id_transmision`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_transmision`
--

LOCK TABLES `tipo_transmision` WRITE;
/*!40000 ALTER TABLE `tipo_transmision` DISABLE KEYS */;
INSERT INTO `tipo_transmision` VALUES (1,'AM'),(2,'FM');
/*!40000 ALTER TABLE `tipo_transmision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trabajadores` (
  `id_trabajadores` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_trbajador` varchar(50) NOT NULL,
  `apellido_trabajador` varchar(50) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `cargo` int(11) NOT NULL,
  `programa_trabajador` int(11) NOT NULL,
  PRIMARY KEY (`id_trabajadores`),
  KEY `cargo_trabajador` (`cargo`),
  KEY `trabajador_programa` (`programa_trabajador`),
  CONSTRAINT `cargo_trabajador` FOREIGN KEY (`cargo`) REFERENCES `cargos` (`id_cargo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trabajador_programa` FOREIGN KEY (`programa_trabajador`) REFERENCES `programas` (`id_programa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (1,'5','5','5',1,1),(2,'OO','oiu','515',1,1),(3,'666','666','65166',1,1),(4,'H','h','h',2,1);
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-16  8:46:11
