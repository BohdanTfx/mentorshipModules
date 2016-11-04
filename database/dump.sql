-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.0.22-MariaDB - openSUSE package
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mentorship
CREATE DATABASE IF NOT EXISTS `mentorship` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mentorship`;

-- Dumping structure for table mentorship.hibernate_sequence
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship.hibernate_sequence: ~2 rows (approximately)
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(67),
	(67),
	(67);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table mentorship.log_entry
DROP TABLE IF EXISTS `log_entry`;
CREATE TABLE IF NOT EXISTS `log_entry` (
  `id` bigint(20) NOT NULL,
  `description` longtext,
  `logDate` datetime DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship.log_entry: ~29 rows (approximately)
DELETE FROM `log_entry`;
/*!40000 ALTER TABLE `log_entry` DISABLE KEYS */;
INSERT INTO `log_entry` (`id`, `description`, `logDate`, `title`, `type`) VALUES
	(37, '{"user":null,"result":null,"data":{"users":[{"id":1,"id":1,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465809000,"lastModifiedByUser":null,"createdByUser":null},{"id":2,"id":2,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465792000,"lastModifiedByUser":null,"createdByUser":null},{"id":3,"id":3,"firstName":"Steven","lastName":"Hawking","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466569000,"lastModified":1476466569000,"lastModifiedByUser":3,"createdByUser":3},{"id":4,"id":4,"firstName":"Sansa","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466597000,"lastModified":1476466597000,"lastModifiedByUser":4,"createdByUser":4},{"id":5,"id":5,"firstName":"Steve","lastName":"Rogers","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466624000,"lastModified":1476466624000,"lastModifiedByUser":5,"createdByUser":5},{"id":6,"id":6,"firstName":"Enekin","lastName":"Skywalker","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466683000,"lastModified":1476466683000,"lastModifiedByUser":6,"createdByUser":6},{"id":7,"id":7,"firstName":"Daniel","lastName":"Jackson","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466712000,"lastModified":1476466712000,"lastModifiedByUser":7,"createdByUser":7},{"id":8,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":8,"createdByUser":8},{"id":9,"id":9,"firstName":"Bilbo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466755000,"lastModified":1476466755000,"lastModifiedByUser":9,"createdByUser":9},{"id":10,"id":10,"firstName":"Gendalf","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466775000,"lastModified":1476466775000,"lastModifiedByUser":10,"createdByUser":10},{"id":11,"id":11,"firstName":"Sauron","lastName":"The Great","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466787000,"lastModified":1476466787000,"lastModifiedByUser":11,"createdByUser":11},{"id":12,"id":12,"firstName":"Saruman","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466805000,"lastModified":1476466805000,"lastModifiedByUser":12,"createdByUser":12},{"id":13,"id":13,"firstName":"Radagast","lastName":"The Brown","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466840000,"lastModified":1476466840000,"lastModifiedByUser":13,"createdByUser":13},{"id":14,"id":14,"firstName":"Eddard","lastName":"\'Ned\' Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466861000,"lastModified":1476466861000,"lastModifiedByUser":14,"createdByUser":14},{"id":15,"id":15,"firstName":"Daenerys","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466883000,"lastModified":1476466883000,"lastModifiedByUser":15,"createdByUser":15},{"id":16,"id":16,"firstName":"Rhaegar","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466972000,"lastModified":1476466972000,"lastModifiedByUser":16,"createdByUser":16},{"id":17,"id":17,"firstName":"Robb","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466989000,"lastModified":1476466989000,"lastModifiedByUser":17,"createdByUser":17},{"id":18,"id":26,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477220195000,"lastModified":1477220195000,"lastModifiedByUser":18,"createdByUser":18},{"id":19,"id":27,"firstName":"James","lastName":"Cook","dateOfBirth":154619484000,"jobTitle":"SENIOR","created":1477220364000,"lastModified":1477220364000,"lastModifiedByUser":19,"createdByUser":19},{"id":20,"id":33,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426788000,"lastModified":1477426788000,"lastModifiedByUser":20,"createdByUser":20},{"id":21,"id":34,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426913000,"lastModified":1477426913000,"lastModifiedByUser":21,"createdByUser":21}]}}', '2016-10-31 00:26:15', 'Activity log', 'act'),
	(38, '{"user":null,"result":null,"data":null}', '2016-10-31 00:32:20', 'Activity log', 'act'),
	(39, '{"user":null,"result":null,"data":null}', '2016-10-31 00:33:08', 'Activity log', 'act'),
	(40, '{"user":null,"result":null,"data":null}', '2016-10-31 00:34:19', 'Activity log', 'act'),
	(41, '{"user":null,"result":null,"data":null}', '2016-10-31 00:34:43', 'Activity log', 'act'),
	(42, '{"user":null,"result":null,"data":null}', '2016-10-31 00:34:49', 'Activity log', 'act'),
	(43, '{"user":null,"result":null,"data":null}', '2016-10-31 00:35:24', 'Activity log', 'act'),
	(44, '{"user":null,"result":null,"data":null}', '2016-10-31 00:36:05', 'Activity log', 'act'),
	(45, '{"user":null,"result":null,"data":null}', '2016-10-31 00:36:09', 'Activity log', 'act'),
	(46, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-10-31 00:36:11', 'Activity log', 'act'),
	(47, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-10-31 00:37:28', 'Activity log', 'act'),
	(48, '{"user":null,"result":null,"data":null}', '2016-11-04 23:33:53', 'Activity log', 'act'),
	(49, '{"user":null,"result":null,"data":null}', '2016-11-04 23:33:56', 'Activity log', 'act'),
	(50, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-04 23:43:31', 'Activity log', 'act'),
	(51, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-04 23:43:53', 'Activity log', 'act'),
	(52, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-04 23:44:04', 'Activity log', 'act'),
	(53, '{"user":null,"result":null,"data":{"authResult":true}}', '2016-11-04 23:44:58', 'Activity log', 'act'),
	(54, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-04 23:57:57', 'Activity log', 'act'),
	(55, '{"user":null,"result":null,"data":{"authResult":true}}', '2016-11-04 23:59:56', 'Activity log', 'act'),
	(57, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-05 00:05:13', 'Activity log', 'act'),
	(58, '{"user":"admin","result":true,"data":"123qwe"}', '2016-11-05 00:05:22', 'Authentication log', 'auth'),
	(59, '{"user":null,"result":null,"data":{"authResult":true}}', '2016-11-05 00:05:23', 'Activity log', 'act'),
	(60, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-05 00:05:49', 'Activity log', 'act'),
	(61, '{"user":"admin","result":true,"data":"123qwe"}', '2016-11-05 00:05:56', 'Authentication log', 'auth'),
	(62, '{"user":null,"result":null,"data":{"authResult":true}}', '2016-11-05 00:05:57', 'Activity log', 'act'),
	(63, '{"user":"admin","result":true,"data":null}', '2016-11-05 00:07:47', 'Authentication log', 'auth'),
	(64, '{"user":null,"result":null,"data":{"logoutResult":true}}', '2016-11-05 00:07:47', 'Activity log', 'act'),
	(65, '{"user":null,"result":null,"data":{"logoutResult":false}}', '2016-11-05 00:08:02', 'Activity log', 'act'),
	(66, '{"user":null,"result":null,"data":{"logoutResult":false}}', '2016-11-05 00:08:10', 'Activity log', 'act');
/*!40000 ALTER TABLE `log_entry` ENABLE KEYS */;

-- Dumping structure for table mentorship.mentorship_program
DROP TABLE IF EXISTS `mentorship_program`;
CREATE TABLE IF NOT EXISTS `mentorship_program` (
  `id` bigint(20) NOT NULL,
  `endDate` datetime DEFAULT NULL,
  `finished` bit(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `started` bit(1) DEFAULT NULL,
  `technology` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `head_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr75r6fyei03182gsfg5kwu5ko` (`head_id`),
  CONSTRAINT `FKr75r6fyei03182gsfg5kwu5ko` FOREIGN KEY (`head_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship.mentorship_program: ~0 rows (approximately)
DELETE FROM `mentorship_program`;
/*!40000 ALTER TABLE `mentorship_program` DISABLE KEYS */;
INSERT INTO `mentorship_program` (`id`, `endDate`, `finished`, `location`, `startDate`, `started`, `technology`, `title`, `head_id`) VALUES
	(18, NULL, b'0', 'KYIV', '2016-10-14 20:52:17', b'1', 'JAVA', 'Java mentorship', 16);
/*!40000 ALTER TABLE `mentorship_program` ENABLE KEYS */;

-- Dumping structure for table mentorship.participant
DROP TABLE IF EXISTS `participant`;
CREATE TABLE IF NOT EXISTS `participant` (
  `participant_type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `finished` bit(1) DEFAULT NULL,
  `mentorship_duration` int(11) DEFAULT NULL,
  `started` bit(1) DEFAULT NULL,
  `started_date` datetime DEFAULT NULL,
  `successfully_finished` bit(1) DEFAULT NULL,
  `mentorship_program_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `mentor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjwek94k9rm6jpdmrk15nvp2xo` (`mentorship_program_id`),
  KEY `FK9ijnxx3lbnx5wyt65hvcujx5u` (`user_id`),
  KEY `FKjwlru92s4mels3g8fejhlkf17` (`mentor_id`),
  CONSTRAINT `FK9ijnxx3lbnx5wyt65hvcujx5u` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FKjwek94k9rm6jpdmrk15nvp2xo` FOREIGN KEY (`mentorship_program_id`) REFERENCES `mentorship_program` (`id`),
  CONSTRAINT `FKjwlru92s4mels3g8fejhlkf17` FOREIGN KEY (`mentor_id`) REFERENCES `participant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship.participant: ~7 rows (approximately)
DELETE FROM `participant`;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` (`participant_type`, `id`, `active`, `end_date`, `finished`, `mentorship_duration`, `started`, `started_date`, `successfully_finished`, `mentorship_program_id`, `user_id`, `mentor_id`) VALUES
	('mentor', 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 14, NULL),
	('mentee', 20, b'1', NULL, b'0', 0, b'1', '2016-10-23 17:28:36', NULL, 18, 3, 19),
	('mentee', 21, b'1', NULL, b'0', 0, b'0', NULL, NULL, 18, 7, 19),
	('mentee', 22, b'0', NULL, b'0', 0, b'0', NULL, NULL, 18, 8, NULL),
	('mentor', 25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 10, NULL),
	('mentor', 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 15, NULL),
	('mentee', 32, b'0', NULL, b'0', 0, b'0', NULL, NULL, 18, 9, NULL);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;

-- Dumping structure for table mentorship.User
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `modificator_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhqmwviw3ccnua01ssp05x6nta` (`creator_id`),
  KEY `FKbim5eov4fdwmj6bm85b8h4g3q` (`modificator_id`),
  CONSTRAINT `FKbim5eov4fdwmj6bm85b8h4g3q` FOREIGN KEY (`modificator_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FKhqmwviw3ccnua01ssp05x6nta` FOREIGN KEY (`creator_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship.User: ~21 rows (approximately)
DELETE FROM `User`;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`id`, `created`, `dob`, `first_name`, `job`, `last_modified`, `last_name`, `creator_id`, `modificator_id`) VALUES
	(1, NULL, '2016-10-13 02:21:54', 'Jon', 'LEAD', '2016-10-14 20:23:29', 'Snow', NULL, NULL),
	(2, NULL, '2016-10-13 02:21:54', 'Jon', 'LEAD', '2016-10-14 20:23:12', 'Snow', NULL, NULL),
	(3, '2016-10-14 20:36:09', '2016-10-13 02:21:54', 'Steven', 'JUNIOR', '2016-10-14 20:36:09', 'Hawking', 3, 3),
	(4, '2016-10-14 20:36:37', '2016-10-13 02:21:54', 'Sansa', 'MIDDLE', '2016-10-14 20:36:37', 'Stark', 4, 4),
	(5, '2016-10-14 20:37:04', '2016-10-13 02:21:54', 'Steve', 'LEAD', '2016-10-14 20:37:04', 'Rogers', 5, 5),
	(6, '2016-10-14 20:38:03', '2016-10-13 02:21:54', 'Enekin', 'CHIEF', '2016-10-14 20:38:03', 'Skywalker', 6, 6),
	(7, '2016-10-14 20:38:32', '2016-10-13 02:21:54', 'Daniel', 'JUNIOR', '2016-10-14 20:38:32', 'Jackson', 7, 7),
	(8, '2016-10-14 20:39:03', '2016-10-13 02:21:54', 'Frodo', 'JUNIOR', '2016-10-14 20:39:03', 'Baggins', 8, 8),
	(9, '2016-10-14 20:39:15', '2016-10-13 02:21:54', 'Bilbo', 'MIDDLE', '2016-10-14 20:39:15', 'Baggins', 9, 9),
	(10, '2016-10-14 20:39:35', '2016-10-13 02:21:54', 'Gendalf', 'LEAD', '2016-10-14 20:39:35', 'The White', 10, 10),
	(11, '2016-10-14 20:39:47', '2016-10-13 02:21:54', 'Sauron', 'CHIEF', '2016-10-14 20:39:47', 'The Great', 11, 11),
	(12, '2016-10-14 20:40:05', '2016-10-13 02:21:54', 'Saruman', 'LEAD', '2016-10-14 20:40:05', 'The White', 12, 12),
	(13, '2016-10-14 20:40:40', '2016-10-13 02:21:54', 'Radagast', 'SENIOR', '2016-10-14 20:40:40', 'The Brown', 13, 13),
	(14, '2016-10-14 20:41:01', '2016-10-13 02:21:54', 'Eddard', 'SENIOR', '2016-10-14 20:41:01', '\'Ned\' Stark', 14, 14),
	(15, '2016-10-14 20:41:23', '2016-10-13 02:21:54', 'Daenerys', 'CHIEF', '2016-10-14 20:41:23', 'Targaryen', 15, 15),
	(16, '2016-10-14 20:42:52', '2016-10-13 02:21:54', 'Rhaegar', 'CHIEF', '2016-10-14 20:42:52', 'Targaryen', 16, 16),
	(17, '2016-10-14 20:43:09', '2016-10-13 02:21:54', 'Robb', 'SENIOR', '2016-10-14 20:43:09', 'Stark', 17, 17),
	(26, '2016-10-23 13:56:35', '1974-11-25 16:51:24', 'John', 'MIDDLE', '2016-10-23 13:56:35', 'Doe', 26, 26),
	(27, '2016-10-23 13:59:24', '1974-11-25 16:51:24', 'James', 'SENIOR', '2016-10-23 13:59:24', 'Cook', 27, 27),
	(33, '2016-10-25 23:19:48', '1974-11-25 16:51:24', 'John', 'MIDDLE', '2016-10-25 23:19:48', 'Doe', 33, 33),
	(34, '2016-10-25 23:21:53', '1974-11-25 16:51:24', 'John', 'MIDDLE', '2016-10-25 23:21:53', 'Doe', 34, 34);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
