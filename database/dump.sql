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


-- Dumping database structure for mentorship_boot
CREATE DATABASE IF NOT EXISTS `mentorship_boot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mentorship_boot`;

-- Dumping structure for table mentorship_boot.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship_boot.hibernate_sequence: ~3 rows (approximately)
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(20),
	(20),
	(20),
	(20);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table mentorship_boot.LogEntry
CREATE TABLE IF NOT EXISTS `LogEntry` (
  `id` bigint(20) NOT NULL,
  `description` longtext,
  `logDate` datetime DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship_boot.LogEntry: ~17 rows (approximately)
DELETE FROM `LogEntry`;
/*!40000 ALTER TABLE `LogEntry` DISABLE KEYS */;
INSERT INTO `LogEntry` (`id`, `description`, `logDate`, `title`, `type`) VALUES
	(1, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 21:06:45', 'Activity log', 'act'),
	(2, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 21:06:50', 'Activity log', 'act'),
	(3, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 21:06:53', 'Activity log', 'act'),
	(4, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 22:46:23', 'Activity log', 'act'),
	(5, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 22:46:30', 'Activity log', 'act'),
	(6, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 22:46:35', 'Activity log', 'act'),
	(7, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 22:47:07', 'Activity log', 'act'),
	(8, '{"user":null,"result":null,"data":{"users":[{"id":1,"id":1,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465809000,"lastModifiedByUser":null,"createdByUser":null},{"id":2,"id":2,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465792000,"lastModifiedByUser":null,"createdByUser":null},{"id":3,"id":3,"firstName":"Steven","lastName":"Hawking","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466569000,"lastModified":1476466569000,"lastModifiedByUser":3,"createdByUser":3},{"id":4,"id":4,"firstName":"Sansa","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466597000,"lastModified":1476466597000,"lastModifiedByUser":4,"createdByUser":4},{"id":5,"id":5,"firstName":"Steve","lastName":"Rogers","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466624000,"lastModified":1476466624000,"lastModifiedByUser":5,"createdByUser":5},{"id":6,"id":6,"firstName":"Enekin","lastName":"Skywalker","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466683000,"lastModified":1476466683000,"lastModifiedByUser":6,"createdByUser":6},{"id":7,"id":7,"firstName":"Daniel","lastName":"Jackson","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466712000,"lastModified":1476466712000,"lastModifiedByUser":7,"createdByUser":7},{"id":8,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":8,"createdByUser":8},{"id":9,"id":9,"firstName":"Bilbo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466755000,"lastModified":1476466755000,"lastModifiedByUser":9,"createdByUser":9},{"id":10,"id":10,"firstName":"Gendalf","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466775000,"lastModified":1476466775000,"lastModifiedByUser":10,"createdByUser":10},{"id":11,"id":11,"firstName":"Sauron","lastName":"The Great","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466787000,"lastModified":1476466787000,"lastModifiedByUser":11,"createdByUser":11},{"id":12,"id":12,"firstName":"Saruman","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466805000,"lastModified":1476466805000,"lastModifiedByUser":12,"createdByUser":12},{"id":13,"id":13,"firstName":"Radagast","lastName":"The Brown","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466840000,"lastModified":1476466840000,"lastModifiedByUser":13,"createdByUser":13},{"id":14,"id":14,"firstName":"Eddard","lastName":"\'Ned\' Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466861000,"lastModified":1476466861000,"lastModifiedByUser":14,"createdByUser":14},{"id":15,"id":15,"firstName":"Daenerys","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466883000,"lastModified":1476466883000,"lastModifiedByUser":15,"createdByUser":15},{"id":16,"id":16,"firstName":"Rhaegar","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466972000,"lastModified":1476466972000,"lastModifiedByUser":16,"createdByUser":16},{"id":17,"id":17,"firstName":"Robb","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466989000,"lastModified":1476466989000,"lastModifiedByUser":17,"createdByUser":17},{"id":18,"id":26,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477220195000,"lastModified":1477220195000,"lastModifiedByUser":18,"createdByUser":18},{"id":19,"id":27,"firstName":"James","lastName":"Cook","dateOfBirth":154619484000,"jobTitle":"SENIOR","created":1477220364000,"lastModified":1477220364000,"lastModifiedByUser":19,"createdByUser":19},{"id":20,"id":33,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426788000,"lastModified":1477426788000,"lastModifiedByUser":20,"createdByUser":20},{"id":21,"id":34,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426913000,"lastModified":1477426913000,"lastModifiedByUser":21,"createdByUser":21}]}}', '2016-11-06 23:54:55', 'Activity log', 'act'),
	(9, '{"user":null,"result":null,"data":null}', '2016-11-06 23:55:06', 'Activity log', 'act'),
	(10, '{"user":null,"result":null,"data":null}', '2016-11-06 23:55:09', 'Activity log', 'act'),
	(11, '{"user":null,"result":null,"data":null}', '2016-11-06 23:55:46', 'Activity log', 'act'),
	(12, '{"user":null,"result":null,"data":null}', '2016-11-06 23:55:51', 'Activity log', 'act'),
	(13, '{"user":null,"result":null,"data":null}', '2016-11-06 23:55:52', 'Activity log', 'act'),
	(14, '{"user":null,"result":null,"data":{"authResult":false}}', '2016-11-06 23:55:54', 'Activity log', 'act'),
	(15, '{"user":null,"result":null,"data":{"users":[{"id":1,"id":1,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465809000,"lastModifiedByUser":null,"createdByUser":null},{"id":2,"id":2,"firstName":"Jon","lastName":"Snow","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":null,"lastModified":1476465792000,"lastModifiedByUser":null,"createdByUser":null},{"id":3,"id":3,"firstName":"Steven","lastName":"Hawking","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466569000,"lastModified":1476466569000,"lastModifiedByUser":3,"createdByUser":3},{"id":4,"id":4,"firstName":"Sansa","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466597000,"lastModified":1476466597000,"lastModifiedByUser":4,"createdByUser":4},{"id":5,"id":5,"firstName":"Steve","lastName":"Rogers","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466624000,"lastModified":1476466624000,"lastModifiedByUser":5,"createdByUser":5},{"id":6,"id":6,"firstName":"Enekin","lastName":"Skywalker","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466683000,"lastModified":1476466683000,"lastModifiedByUser":6,"createdByUser":6},{"id":7,"id":7,"firstName":"Daniel","lastName":"Jackson","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466712000,"lastModified":1476466712000,"lastModifiedByUser":7,"createdByUser":7},{"id":8,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":8,"createdByUser":8},{"id":9,"id":9,"firstName":"Bilbo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"MIDDLE","created":1476466755000,"lastModified":1476466755000,"lastModifiedByUser":9,"createdByUser":9},{"id":10,"id":10,"firstName":"Gendalf","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466775000,"lastModified":1476466775000,"lastModifiedByUser":10,"createdByUser":10},{"id":11,"id":11,"firstName":"Sauron","lastName":"The Great","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466787000,"lastModified":1476466787000,"lastModifiedByUser":11,"createdByUser":11},{"id":12,"id":12,"firstName":"Saruman","lastName":"The White","dateOfBirth":1476314514000,"jobTitle":"LEAD","created":1476466805000,"lastModified":1476466805000,"lastModifiedByUser":12,"createdByUser":12},{"id":13,"id":13,"firstName":"Radagast","lastName":"The Brown","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466840000,"lastModified":1476466840000,"lastModifiedByUser":13,"createdByUser":13},{"id":14,"id":14,"firstName":"Eddard","lastName":"\'Ned\' Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466861000,"lastModified":1476466861000,"lastModifiedByUser":14,"createdByUser":14},{"id":15,"id":15,"firstName":"Daenerys","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466883000,"lastModified":1476466883000,"lastModifiedByUser":15,"createdByUser":15},{"id":16,"id":16,"firstName":"Rhaegar","lastName":"Targaryen","dateOfBirth":1476314514000,"jobTitle":"CHIEF","created":1476466972000,"lastModified":1476466972000,"lastModifiedByUser":16,"createdByUser":16},{"id":17,"id":17,"firstName":"Robb","lastName":"Stark","dateOfBirth":1476314514000,"jobTitle":"SENIOR","created":1476466989000,"lastModified":1476466989000,"lastModifiedByUser":17,"createdByUser":17},{"id":18,"id":26,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477220195000,"lastModified":1477220195000,"lastModifiedByUser":18,"createdByUser":18},{"id":19,"id":27,"firstName":"James","lastName":"Cook","dateOfBirth":154619484000,"jobTitle":"SENIOR","created":1477220364000,"lastModified":1477220364000,"lastModifiedByUser":19,"createdByUser":19},{"id":20,"id":33,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426788000,"lastModified":1477426788000,"lastModifiedByUser":20,"createdByUser":20},{"id":21,"id":34,"firstName":"John","lastName":"Doe","dateOfBirth":154619484000,"jobTitle":"MIDDLE","created":1477426913000,"lastModified":1477426913000,"lastModifiedByUser":21,"createdByUser":21}]}}', '2016-11-06 23:56:05', 'Activity log', 'act'),
	(16, '{"user":null,"result":null,"data":null}', '2016-11-06 23:56:08', 'Activity log', 'act'),
	(17, '{"user":null,"result":null,"data":{"mentee":{"id":22,"user":{"id":1,"id":8,"firstName":"Frodo","lastName":"Baggins","dateOfBirth":1476314514000,"jobTitle":"JUNIOR","created":1476466743000,"lastModified":1476466743000,"lastModifiedByUser":1,"createdByUser":1},"active":false,"startedDate":null,"endDate":null,"started":false,"finished":false,"successfullyFinished":null,"mentorshipDuration":0}}}', '2016-11-06 23:56:11', 'Activity log', 'act');
/*!40000 ALTER TABLE `LogEntry` ENABLE KEYS */;

-- Dumping structure for table mentorship_boot.MentorshipProgram
CREATE TABLE IF NOT EXISTS `MentorshipProgram` (
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
  KEY `FKma5sqp20wm1cf4pk1gdkt90pv` (`head_id`),
  CONSTRAINT `FKma5sqp20wm1cf4pk1gdkt90pv` FOREIGN KEY (`head_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship_boot.MentorshipProgram: ~0 rows (approximately)
DELETE FROM `MentorshipProgram`;
/*!40000 ALTER TABLE `MentorshipProgram` DISABLE KEYS */;
INSERT INTO `MentorshipProgram` (`id`, `endDate`, `finished`, `location`, `startDate`, `started`, `technology`, `title`, `head_id`) VALUES
	(18, NULL, b'0', 'KYIV', '2016-10-14 20:52:17', b'1', 'JAVA', 'Java mentorship', 16);
/*!40000 ALTER TABLE `MentorshipProgram` ENABLE KEYS */;

-- Dumping structure for table mentorship_boot.Participant
CREATE TABLE IF NOT EXISTS `Participant` (
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
  KEY `FKqjo7t68756re31bjrkusq633o` (`mentorship_program_id`),
  KEY `FK2qncscailopii1ckdxeuxxnfc` (`user_id`),
  KEY `FKkpehufw525c0717bp2l4dd7mt` (`mentor_id`),
  CONSTRAINT `FK2qncscailopii1ckdxeuxxnfc` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FKkpehufw525c0717bp2l4dd7mt` FOREIGN KEY (`mentor_id`) REFERENCES `Participant` (`id`),
  CONSTRAINT `FKqjo7t68756re31bjrkusq633o` FOREIGN KEY (`mentorship_program_id`) REFERENCES `MentorshipProgram` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table mentorship_boot.Participant: ~7 rows (approximately)
DELETE FROM `Participant`;
/*!40000 ALTER TABLE `Participant` DISABLE KEYS */;
INSERT INTO `Participant` (`participant_type`, `id`, `active`, `end_date`, `finished`, `mentorship_duration`, `started`, `started_date`, `successfully_finished`, `mentorship_program_id`, `user_id`, `mentor_id`) VALUES
	('mentor', 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 14, NULL),
	('mentee', 20, b'1', NULL, b'0', 0, b'1', '2016-10-23 17:28:36', NULL, 18, 3, 19),
	('mentee', 21, b'1', NULL, b'0', 0, b'0', NULL, NULL, 18, 7, 19),
	('mentee', 22, b'0', NULL, b'0', 0, b'0', NULL, NULL, 18, 8, NULL),
	('mentor', 25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 10, NULL),
	('mentor', 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 18, 15, NULL),
	('mentee', 32, b'0', NULL, b'0', 0, b'0', NULL, NULL, 18, 9, NULL);
/*!40000 ALTER TABLE `Participant` ENABLE KEYS */;

-- Dumping structure for table mentorship_boot.User
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

-- Dumping data for table mentorship_boot.User: ~21 rows (approximately)
DELETE FROM `User`;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`id`, `created`, `dob`, `first_name`, `job`, `last_modified`, `last_name`, `creator_id`, `modificator_id`) VALUES
	(1, '2016-10-14 20:36:09', '2016-10-13 02:21:54', 'Jon', 'LEAD', '2016-10-14 20:23:29', 'Snow', 1, 1),
	(2, '2016-11-26 22:50:05', '2004-07-09 02:21:54', 'Jon', 'SENIOR', '2016-11-26 22:50:50', 'Snow', 2, 2),
	(3, '2016-10-14 20:36:09', '2016-10-13 02:21:54', 'Steven', 'JUNIOR', '2016-10-14 20:36:09', 'Hawking', 3, 3),
	(4, '2016-10-14 20:36:37', '2016-10-13 02:21:54', 'Sansa', 'MIDDLE', '2016-10-14 20:36:37', 'Stark', 4, 4),
	(5, '2016-10-14 20:37:04', '2016-10-13 02:21:54', 'Steve', 'LEAD', '2016-10-14 20:37:04', 'Rogers', 5, 5),
	(6, '2016-10-14 20:38:03', '2016-10-13 02:21:54', 'Enekin', 'CHIEF', '2016-10-14 20:38:03', 'Skywalker', 6, 6),
	(7, '2016-10-14 20:38:32', '2016-10-13 02:21:54', 'Daniel', 'JUNIOR', '2016-10-14 20:38:32', 'Jackson', 7, 7),
	(8, '2016-10-14 20:39:03', '2016-10-13 02:21:54', 'Frodo', 'JUNIOR', '2016-10-14 20:39:03', 'Baggins', 8, 8),
	(9, '2016-10-14 20:39:15', '2016-10-13 02:21:54', 'Bilbo', 'MIDDLE', '2016-10-14 20:39:15', 'Baggins', 9, 9),
	(10, '2016-10-14 20:39:35', '2016-10-13 02:21:54', 'Gendalf', 'LEAD', '2016-11-26 22:43:16', 'The White', 10, 10),
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
