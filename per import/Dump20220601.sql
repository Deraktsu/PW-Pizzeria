-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pizzeria
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL AUTO_INCREMENT,
  `data_ordine` date NOT NULL,
  `orario_ritiro` varchar(45) NOT NULL,
  `prezzo_totale` double NOT NULL,
  `id_utente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`),
  KEY `id_utente` (`id_utente`),
  CONSTRAINT `id_utente` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id_utente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini_prodotti`
--

DROP TABLE IF EXISTS `ordini_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordini_prodotti` (
  `id_ordine` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  KEY `id_ordine` (`id_ordine`),
  KEY `id_prodotto` (`id_prodotto`),
  CONSTRAINT `id_ordine` FOREIGN KEY (`id_ordine`) REFERENCES `ordini` (`id_ordine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini_prodotti`
--

LOCK TABLES `ordini_prodotti` WRITE;
/*!40000 ALTER TABLE `ordini_prodotti` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordini_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `prezzo` double NOT NULL,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,'Margherita','pomodoro, mozzarella',5,'Pizza'),(2,'Marinara','pomodoro, aglio, olio',5.5,'Pizza'),(3,'Napoli','pomodoro, mozzarella, acciughe, origano',5,'Pizza'),(4,'Salame piccante','pomodoro , mozzarella e salame piccante',6,'Pizza'),(5,'4 formaggi','pomodoro , mozzarella e formaggi misti',6,'Pizza'),(6,'Calzone liscio','pomodoro, mozzarella, prosciutto cotto',5.5,'Calzone'),(7,'Calzone Farcito','pomodoro, mozzarella, prosciutto cotto, funghi, carciofi, capperi',6.5,'Calzone'),(8,'Calzone Vegetariano','pomodoro, mozzarella, zucchine, peperoni grigliati',6.5,'Calzone'),(9,'Calzone Amici','pomodoro, mozzarella, prosciutto cotto, spinaci, ricotta',6.5,'Calzone'),(10,'Calzone Formaggio','mozzarella, gorgonzola, scamorza, grana',6.5,'Calzone'),(11,'Acqua minerale 1/2 lt','Acqua',2,'Bevanda'),(12,'Acqua minerale 1 lt	','Acqua',4,'Bevanda'),(13,'Pepsi Cola','Bibita',4,'Bevanda'),(14,'Coca Cola Zero 33 cl (lattina)','coca cola',3,'Bevanda');
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id_utente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_utente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (6,'Andrea','Boffa','3123123123','andrea.boffa@hotmail.it','password'),(7,'Edgar','Acosta','3213211564','edgar.acosta@gmail.com','password'),(8,'Visone','Gabriele','123123123','visone.gabriele@gmail.com','password'),(9,'Lorenzo','Silot','1231231231','lorenzo.silot@hotmail.com','password'),(10,'Piero','Loarte','1231312123','piero.loarte@gmail.com','password');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01  9:14:07
