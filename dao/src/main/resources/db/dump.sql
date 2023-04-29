-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `aperture`
--

DROP TABLE IF EXISTS `aperture`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aperture` (
  `id`               BIGINT(20) NOT NULL,
  `typeOfAperture`   VARCHAR(255) DEFAULT NULL,
  `width`            DOUBLE       DEFAULT NULL,
  `height`           DOUBLE       DEFAULT NULL,
  `squareOfAperture` DOUBLE       DEFAULT NULL,
  `count`            INT(11)      DEFAULT NULL,
  `roomId`           BIGINT(20)   DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s3iy3b7xwu1pcqsw5qst644a7` (`roomId`),
  CONSTRAINT `FK_s3iy3b7xwu1pcqsw5qst644a7` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aperture`
--

LOCK TABLES `aperture` WRITE;
/*!40000 ALTER TABLE `aperture`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `aperture`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building` (
  `id`                          BIGINT(20) NOT NULL,
  `nameOfBuilding`              VARCHAR(255) DEFAULT NULL,
  `selectedTemperatureOfRegion` DOUBLE       DEFAULT NULL,
  `specifyingCoefficientS5`     DOUBLE       DEFAULT NULL,
  `dateOfBuilding`              VARCHAR(255) DEFAULT NULL,
  `userId`                      BIGINT(20)   DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sa7kbcstgklex0mjp3aytuvpn` (`userId`),
  CONSTRAINT `FK_sa7kbcstgklex0mjp3aytuvpn` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `building`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changeinmeanbulktemperature`
--

DROP TABLE IF EXISTS `changeinmeanbulktemperature`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changeinmeanbulktemperature` (
  `roomId`      BIGINT(20) NOT NULL,
  `temperature` DOUBLE DEFAULT NULL,
  `minute`      INT(11)    NOT NULL,
  PRIMARY KEY (`roomId`, `minute`),
  CONSTRAINT `FK_hedl8ybl91ko56ulkbl627hmb` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changeinmeanbulktemperature`
--

LOCK TABLES `changeinmeanbulktemperature` WRITE;
/*!40000 ALTER TABLE `changeinmeanbulktemperature`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `changeinmeanbulktemperature`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changeintemperatureofslab`
--

DROP TABLE IF EXISTS `changeintemperatureofslab`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changeintemperatureofslab` (
  `roomId`      BIGINT(20) NOT NULL,
  `temperature` DOUBLE DEFAULT NULL,
  `minute`      INT(11)    NOT NULL,
  PRIMARY KEY (`roomId`, `minute`),
  CONSTRAINT `FK_d8vltkygwoqsjnbgccq4h1qy1` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changeintemperatureofslab`
--

LOCK TABLES `changeintemperatureofslab` WRITE;
/*!40000 ALTER TABLE `changeintemperatureofslab`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `changeintemperatureofslab`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changeintemperatureofwalls`
--

DROP TABLE IF EXISTS `changeintemperatureofwalls`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changeintemperatureofwalls` (
  `roomId`      BIGINT(20) NOT NULL,
  `temperature` DOUBLE DEFAULT NULL,
  `minute`      INT(11)    NOT NULL,
  PRIMARY KEY (`roomId`, `minute`),
  CONSTRAINT `FK_ra0a7ppvw22sb9158ojfgkumv` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changeintemperatureofwalls`
--

LOCK TABLES `changeintemperatureofwalls` WRITE;
/*!40000 ALTER TABLE `changeintemperatureofwalls`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `changeintemperatureofwalls`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coefficientsforbuild`
--

DROP TABLE IF EXISTS `coefficientsforbuild`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coefficientsforbuild` (
  `buildingId`  BIGINT(20) NOT NULL,
  `coefficient` DOUBLE     NOT NULL,
  `position`    INT(11)    NOT NULL,
  PRIMARY KEY (`buildingId`, `position`),
  CONSTRAINT `FK_bo2hcam6sl4atc16gy2vasacj` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coefficientsforbuild`
--

LOCK TABLES `coefficientsforbuild` WRITE;
/*!40000 ALTER TABLE `coefficientsforbuild`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `coefficientsforbuild`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coefficientsforroom`
--

DROP TABLE IF EXISTS `coefficientsforroom`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coefficientsforroom` (
  `roomId`      BIGINT(20) NOT NULL,
  `coefficient` DOUBLE DEFAULT NULL,
  `position`    INT(11)    NOT NULL,
  PRIMARY KEY (`roomId`, `position`),
  CONSTRAINT `FK_925gue0kol16rjipimevo3sse` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coefficientsforroom`
--

LOCK TABLES `coefficientsforroom` WRITE;
/*!40000 ALTER TABLE `coefficientsforroom`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `coefficientsforroom`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commonparameters`
--

DROP TABLE IF EXISTS `commonparameters`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commonparameters` (
  `id`                   BIGINT(20) NOT NULL,
  `positionOfRoom`       VARCHAR(255) DEFAULT NULL,
  `nameOfRoom`           VARCHAR(255) DEFAULT NULL,
  `square`               DOUBLE       DEFAULT NULL,
  `height`               DOUBLE       DEFAULT NULL,
  `perimeter`            DOUBLE       DEFAULT NULL,
  `volume`               DOUBLE       DEFAULT NULL,
  `squareOfConstruction` DOUBLE       DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commonparameters`
--

LOCK TABLES `commonparameters` WRITE;
/*!40000 ALTER TABLE `commonparameters`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `commonparameters`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `determinethetypeoffire`
--

DROP TABLE IF EXISTS `determinethetypeoffire`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `determinethetypeoffire` (
  `id`                               BIGINT(20) NOT NULL,
  `proemnostOfRoom`                  DOUBLE DEFAULT NULL,
  `averageAmountOfCombustionAir`     DOUBLE DEFAULT NULL,
  `specificCriticalAmountOfFireLoad` DOUBLE DEFAULT NULL,
  `specificValueOfFireLoad`          DOUBLE DEFAULT NULL,
  `prn`                              BIT(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `determinethetypeoffire`
--

LOCK TABLES `determinethetypeoffire` WRITE;
/*!40000 ALTER TABLE `determinethetypeoffire`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `determinethetypeoffire`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flammablesubstance`
--

DROP TABLE IF EXISTS `flammablesubstance`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flammablesubstance` (
  `id`                    BIGINT(20) NOT NULL,
  `nameOfSubstance`       VARCHAR(255) DEFAULT NULL,
  `amountOfCombustionAir` DOUBLE       DEFAULT NULL,
  `combustionHeat`        DOUBLE       DEFAULT NULL,
  `averageSpeedBurnout`   DOUBLE       DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flammablesubstance`
--

LOCK TABLES `flammablesubstance` WRITE;
/*!40000 ALTER TABLE `flammablesubstance`
  DISABLE KEYS */;
INSERT INTO `flammablesubstance` VALUES (1, 'Текстильные изделия', 2.12, 16, 1.44), (2, 'Древесина', 4.2, 13, 2.4),
  (3, 'Изоляция проводов, кабелей ПВХ', 13.05, 33, 3.73), (4, 'Масло', 10.5, 42, 2.1),
  (5, 'Пластмасса (Полиэтилен)', 11.42, 47, 0.62), (6, 'РТИ', 13.18, 33, 0.9), (7, 'Хлопок', 9.72, 16.4, 1.26),
  (8, 'Лен', 7.73, 15.7, 1.26), (9, 'Ковролин', 10.77, 15.4, 0.78), (10, 'Каучук СКС', 10.16, 43.89, 0.78),
  (11, 'Полистирол', 10.25, 39, 0.84), (12, 'Резина', 12.63, 33.52, 0.66), (13, 'Пенополиуретан', 6, 24.3, 0.18),
  (14, 'Полиэтилен', 11.42, 47.14, 0.6), (15, 'Полипропилен', 11.42, 45.67, 0.9),
  (16, 'Поливинилхлорид', 9.25, 20.7, 1.44), (17, 'Индустриальное масло', 6.71, 42.7, 2.58);
/*!40000 ALTER TABLE `flammablesubstance`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integratedthermalandtechnicalparameters`
--

DROP TABLE IF EXISTS `integratedthermalandtechnicalparameters`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integratedthermalandtechnicalparameters` (
  `id`                                         BIGINT(20) NOT NULL,
  `maximumMeanBulkTemperature`                 DOUBLE DEFAULT NULL,
  `durationOfFireSurround`                     DOUBLE DEFAULT NULL,
  `timeReachMaximumMeanBulkTemperature`        DOUBLE DEFAULT NULL,
  `maximumAverageTemperatureOfWallSurface`     DOUBLE DEFAULT NULL,
  `timeToReachMaximumTemperatureOfWallSurface` DOUBLE DEFAULT NULL,
  `averageMaximumTemperatureOfSlab`            DOUBLE DEFAULT NULL,
  `timeToReachMaximumTemperatureOfSlabSurface` DOUBLE DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integratedthermalandtechnicalparameters`
--

LOCK TABLES `integratedthermalandtechnicalparameters` WRITE;
/*!40000 ALTER TABLE `integratedthermalandtechnicalparameters`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `integratedthermalandtechnicalparameters`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameterscalculatedfireload`
--

DROP TABLE IF EXISTS `parameterscalculatedfireload`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameterscalculatedfireload` (
  `id`                         BIGINT(20) NOT NULL,
  `specificFireLoad`           DOUBLE DEFAULT NULL,
  `specificFireLoadZVEZDOCHKA` DOUBLE DEFAULT NULL,
  `reducedHeightOfApertures`   DOUBLE DEFAULT NULL,
  `generalSquareOfApertures`   DOUBLE DEFAULT NULL,
  `ventilationParameter`       DOUBLE DEFAULT NULL,
  `coefficientK`               DOUBLE DEFAULT NULL,
  `coefficientA`               DOUBLE DEFAULT NULL,
  `coefficientB`               DOUBLE DEFAULT NULL,
  `coefficientS`               DOUBLE DEFAULT NULL,
  `estimatedFireLoad`          DOUBLE DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameterscalculatedfireload`
--

LOCK TABLES `parameterscalculatedfireload` WRITE;
/*!40000 ALTER TABLE `parameterscalculatedfireload`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `parameterscalculatedfireload`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id`                                      BIGINT(20) NOT NULL,
  `commonParameters`                        BIGINT(20) NOT NULL,
  `determineTheTypeOfFire`                  BIGINT(20) NOT NULL,
  `integratedThermalAndTechnicalParameters` BIGINT(20) NOT NULL,
  `parametersCalculatedFireLoad`            BIGINT(20) NOT NULL,
  `buildingId`                              BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pua3ym4222w48a4e3vu4i9yr` (`commonParameters`),
  KEY `FK_9sbisdqn9genlk2dni3bfgvr2` (`determineTheTypeOfFire`),
  KEY `FK_727f2yqs4sgyl2ojup085uvgh` (`integratedThermalAndTechnicalParameters`),
  KEY `FK_p9mx0srs2slo5ug45env1fca4` (`parametersCalculatedFireLoad`),
  KEY `FK_ohxsrpvwidsvt621d0keswfmo` (`buildingId`),
  CONSTRAINT `FK_727f2yqs4sgyl2ojup085uvgh` FOREIGN KEY (`integratedThermalAndTechnicalParameters`) REFERENCES `integratedthermalandtechnicalparameters` (`id`),
  CONSTRAINT `FK_9sbisdqn9genlk2dni3bfgvr2` FOREIGN KEY (`determineTheTypeOfFire`) REFERENCES `determinethetypeoffire` (`id`),
  CONSTRAINT `FK_ohxsrpvwidsvt621d0keswfmo` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`),
  CONSTRAINT `FK_p9mx0srs2slo5ug45env1fca4` FOREIGN KEY (`parametersCalculatedFireLoad`) REFERENCES `parameterscalculatedfireload` (`id`),
  CONSTRAINT `FK_pua3ym4222w48a4e3vu4i9yr` FOREIGN KEY (`commonParameters`) REFERENCES `commonparameters` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `room`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `substanceofroom`
--

DROP TABLE IF EXISTS `substanceofroom`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `substanceofroom` (
  `id`                 BIGINT(20) NOT NULL,
  `flammableSubstance` BIGINT(20) NOT NULL,
  `weight`             DOUBLE     DEFAULT NULL,
  `roomId`             BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hiq8v9h8eihhcf22yuatcs8gk` (`flammableSubstance`),
  KEY `FK_oigbxc2g55ewty60kwn5tcw1o` (`roomId`),
  CONSTRAINT `FK_hiq8v9h8eihhcf22yuatcs8gk` FOREIGN KEY (`flammableSubstance`) REFERENCES `flammablesubstance` (`id`),
  CONSTRAINT `FK_oigbxc2g55ewty60kwn5tcw1o` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `substanceofroom`
--

LOCK TABLES `substanceofroom` WRITE;
/*!40000 ALTER TABLE `substanceofroom`
  DISABLE KEYS */;
/*!40000 ALTER TABLE `substanceofroom`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id`              BIGINT(20) NOT NULL,
  `login`           VARCHAR(255) DEFAULT NULL,
  `password`        VARCHAR(255) DEFAULT NULL,
  `accessLevelType` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user`
  DISABLE KEYS */;
INSERT INTO `user` VALUES (1, 'henk', 'guevara333', 'SUPER_ADMIN');
/*!40000 ALTER TABLE `user`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2016-08-11  0:30:07
