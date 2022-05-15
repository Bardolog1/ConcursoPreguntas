-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: concursopreguntas
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `dificil`
--

DROP TABLE IF EXISTS `dificil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dificil` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `numPregunta` int DEFAULT NULL,
  `pregunta` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `respuestas` mediumtext CHARACTER SET cp1256 COLLATE cp1256_general_ci,
  `correcta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dificil`
--

LOCK TABLES `dificil` WRITE;
/*!40000 ALTER TABLE `dificil` DISABLE KEYS */;
INSERT INTO `dificil` VALUES (1,1,'¿Que rama de la Biología se encarga del estudio de los animales?','zoologia,Animalogia,Paleontologia,Arqueologia','zoologia'),(2,2,'¿A cuanto equivale el numero pi?','3,1416,1.2435,3.14,3.15','3,1416'),(3,3,'¿Cual es tercer planeta del sistema solar?','Tierra,Marte,Venus,Luna','Tierra'),(4,4,'¿Donde se encuentra la famosa Casa Blanca?','Washington D.C,New York,Boston,San Fransico','Washington D.C'),(5,5,'¿Según la Biblia, quien traiciono a Jesus?','Judas,Pedro,Marlo,Pilatos','Judas');
/*!40000 ALTER TABLE `dificil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facil`
--

DROP TABLE IF EXISTS `facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facil` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `numPregunta` int DEFAULT NULL,
  `pregunta` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `respuestas` mediumtext CHARACTER SET cp1256 COLLATE cp1256_general_ci,
  `correcta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facil`
--

LOCK TABLES `facil` WRITE;
/*!40000 ALTER TABLE `facil` DISABLE KEYS */;
INSERT INTO `facil` VALUES (1,1,'¿Que rama de la Biología se encarga del estudio de los animales?','zoologia,Animalogia,Paleontologia,Arqueologia','zoologia'),(2,2,'¿A cuanto equivale el numero pi?','3,1416,1.2435,3.14,3.15','3,1416'),(3,3,'¿Cual es tercer planeta del sistema solar?','Tierra,Marte,Venus,Luna','Tierra'),(4,4,'¿Donde se encuentra la famosa Casa Blanca?','Washington D.C,New York,Boston,San Fransico','Washington D.C'),(5,5,'¿Según la Biblia, quien traiciono a Jesus?','Judas,Pedro,Marlo,Pilatos','Judas');
/*!40000 ALTER TABLE `facil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leyenda`
--

DROP TABLE IF EXISTS `leyenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leyenda` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `numPregunta` int DEFAULT NULL,
  `pregunta` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `respuestas` mediumtext CHARACTER SET cp1256 COLLATE cp1256_general_ci,
  `correcta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leyenda`
--

LOCK TABLES `leyenda` WRITE;
/*!40000 ALTER TABLE `leyenda` DISABLE KEYS */;
INSERT INTO `leyenda` VALUES (1,1,'¿Que rama de la Biología se encarga del estudio de los animales?','zoologia,Animalogia,Paleontologia,Arqueologia','zoologia'),(2,2,'¿A cuanto equivale el numero pi?','3,1416,1.2435,3.14,3.15','3,1416'),(3,3,'¿Cual es tercer planeta del sistema solar?','Tierra,Marte,Venus,Luna','Tierra'),(4,4,'¿Donde se encuentra la famosa Casa Blanca?','Washington D.C,New York,Boston,San Fransico','Washington D.C'),(5,5,'¿Según la Biblia, quien traiciono a Jesus?','Judas,Pedro,Marlo,Pilatos','Judas');
/*!40000 ALTER TABLE `leyenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio`
--

DROP TABLE IF EXISTS `medio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medio` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `numPregunta` int DEFAULT NULL,
  `pregunta` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `respuestas` mediumtext CHARACTER SET cp1256 COLLATE cp1256_general_ci,
  `correcta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio`
--

LOCK TABLES `medio` WRITE;
/*!40000 ALTER TABLE `medio` DISABLE KEYS */;
INSERT INTO `medio` VALUES (1,1,'¿Que rama de la Biología se encarga del estudio de los animales?','zoologia,Animalogia,Paleontologia,Arqueologia','zoologia'),(2,2,'¿A cuanto equivale el numero pi?','3,1416,1.2435,3.14,3.15','3,1416'),(3,3,'¿Cual es tercer planeta del sistema solar?','Tierra,Marte,Venus,Luna','Tierra'),(4,4,'¿Donde se encuentra la famosa Casa Blanca?','Washington D.C,New York,Boston,San Fransico','Washington D.C'),(5,5,'¿Según la Biblia, quien traiciono a Jesus?','Judas,Pedro,Marlo,Pilatos','Judas');
/*!40000 ALTER TABLE `medio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muyfacil`
--

DROP TABLE IF EXISTS `muyfacil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muyfacil` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `numPregunta` int NOT NULL,
  `pregunta` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `respuestas` mediumtext CHARACTER SET cp1256 COLLATE cp1256_general_ci,
  `correcta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPregunta`),
  UNIQUE KEY `numPregunta_UNIQUE` (`numPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muyfacil`
--

LOCK TABLES `muyfacil` WRITE;
/*!40000 ALTER TABLE `muyfacil` DISABLE KEYS */;
INSERT INTO `muyfacil` VALUES (1,1,' ¿Cuál es la capital de Venezuela?','Caracas,Maracaibo,Buenos Aires,La Paz','Caracas'),(2,2,'¿Quién es el autor de el Don Quijote de la Mancha?','Miguel de Cervantes ,Sancho Panza,Don Quijote,William Shakespeare','Miguel de Cervantes '),(3,3,'¿Quién fue el primer hombre en pisar la luna?','Neil Armstrong,Bladimir Putin,Thomas Edison,Nikola Tesla','Neil Armstrong'),(4,4,'¿Cuándo acabó la Segunda Guerra Mundial?','1945,1918,1993,1905','1945'),(5,5,'¿Dónde se encuentra la emblemática Torre Eiffel?','Francia,Belgica,Rumania,Alemania','Francia');
/*!40000 ALTER TABLE `muyfacil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntajes`
--

DROP TABLE IF EXISTS `puntajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntajes` (
  `idPuntaje` int NOT NULL AUTO_INCREMENT,
  `participante` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `puntaje` int NOT NULL,
  `premio` int NOT NULL,
  PRIMARY KEY (`idPuntaje`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntajes`
--

LOCK TABLES `puntajes` WRITE;
/*!40000 ALTER TABLE `puntajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15  3:04:09
