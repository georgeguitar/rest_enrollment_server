-- Adminer 4.7.2 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `DATABASECHANGELOG` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('00000000000001',	'jhipster',	'config/liquibase/changelog/00000000000000_initial_schema.xml',	'2019-08-08 22:50:39',	1,	'EXECUTED',	'8:8e21c5375c87ff644820529f195ee600',	'createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; addForeignKeyConstraint baseTableName=jhi_user_authority, constraintName=fk_authority_name, ...',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024621-1',	'jhipster',	'config/liquibase/changelog/20190809024621_added_entity_Student.xml',	'2019-08-08 22:50:39',	2,	'EXECUTED',	'8:3f131f762f57da62fc7bb2bdbc6c92ab',	'createTable tableName=student',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024621-1-relations',	'jhipster',	'config/liquibase/changelog/20190809024621_added_entity_Student.xml',	'2019-08-08 22:50:39',	3,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024621-1-data',	'jhipster',	'config/liquibase/changelog/20190809024621_added_entity_Student.xml',	'2019-08-08 22:50:39',	4,	'EXECUTED',	'8:a5e4bb820bebc9160d8d7ecd21a676a5',	'loadData tableName=student',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5319039714'),
('20190809024622-1',	'jhipster',	'config/liquibase/changelog/20190809024622_added_entity_Enrollment.xml',	'2019-08-08 22:50:39',	5,	'EXECUTED',	'8:b392d9f34f67fcb6cf4843a6b940a3a6',	'createTable tableName=enrollment',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024622-1-relations',	'jhipster',	'config/liquibase/changelog/20190809024622_added_entity_Enrollment.xml',	'2019-08-08 22:50:39',	6,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024622-1-data',	'jhipster',	'config/liquibase/changelog/20190809024622_added_entity_Enrollment.xml',	'2019-08-08 22:50:39',	7,	'EXECUTED',	'8:5add1aabd2e63f63ac1119b103c0c78c',	'loadData tableName=enrollment',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5319039714'),
('20190809024623-1',	'jhipster',	'config/liquibase/changelog/20190809024623_added_entity_Program.xml',	'2019-08-08 22:50:39',	8,	'EXECUTED',	'8:32d56b034ecc41464d44983fef38801c',	'createTable tableName=program',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024623-1-relations',	'jhipster',	'config/liquibase/changelog/20190809024623_added_entity_Program.xml',	'2019-08-08 22:50:39',	9,	'EXECUTED',	'8:d41d8cd98f00b204e9800998ecf8427e',	'empty',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714'),
('20190809024623-1-data',	'jhipster',	'config/liquibase/changelog/20190809024623_added_entity_Program.xml',	'2019-08-08 22:50:39',	10,	'EXECUTED',	'8:cd427deb95c5f6f9cb2a9324584b3d78',	'loadData tableName=program',	'',	NULL,	'3.6.3',	'faker',	NULL,	'5319039714'),
('20190809024622-2',	'jhipster',	'config/liquibase/changelog/20190809024622_added_entity_constraints_Enrollment.xml',	'2019-08-08 22:50:40',	11,	'EXECUTED',	'8:2e0502817917c567a687ecb3f903071c',	'addForeignKeyConstraint baseTableName=enrollment, constraintName=fk_enrollment_student_id, referencedTableName=student; addForeignKeyConstraint baseTableName=enrollment, constraintName=fk_enrollment_program_id, referencedTableName=program',	'',	NULL,	'3.6.3',	NULL,	NULL,	'5319039714');

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1,	CONV('0', 2, 10) + 0,	NULL,	NULL);

DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `year` varchar(60) NOT NULL,
  `period` varchar(60) NOT NULL,
  `level` varchar(60) NOT NULL,
  `date_enrollment` date NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `program_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_enrollment_student_id` (`student_id`),
  KEY `fk_enrollment_program_id` (`program_id`),
  CONSTRAINT `fk_enrollment_program_id` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`),
  CONSTRAINT `fk_enrollment_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `enrollment` (`id`, `year`, `period`, `level`, `date_enrollment`, `student_id`, `program_id`) VALUES
(1,	'Quality-focused777777',	'card Plastic',	'Computers Personal Loan Account Berkshire',	'2019-08-07',	11,	3),
(2,	'Investor Public-key',	'Lebanon',	'Designer Persistent',	'2019-08-08',	1,	8),
(3,	'Ergonomic transmitter',	'Point Orchestrator',	'Solomon Islands Licensed',	'2019-08-08',	2,	4),
(4,	'magenta Refined Rubber Gloves',	'red firewall open-source',	'deposit Sausages',	'2019-08-08',	4,	4),
(5,	'Creative Metal',	'bandwidth azure',	'SMS Enhanced',	'2019-08-08',	2,	9),
(6,	'Macao Equatorial Guinea Vision-oriented',	'Agent',	'Human deposit',	'2019-08-08',	3,	4),
(7,	'bus Internal AI',	'THX bypassing Marketing',	'Dynamic Home Loan Account Tools',	'2019-08-09',	10,	7),
(8,	'Home Gloves Latvia',	'Ports Manager Fish',	'Networked',	'2019-08-08',	2,	8),
(9,	'payment calculating',	'local area network Benin',	'turn-key dedicated',	'2019-08-08',	6,	10),
(10,	'target Human withdrawal',	'dot-com payment Libyan Dinar',	'white sensor local',	'2019-08-09',	8,	7),
(11,	'1998',	'2',	'4',	'2019-08-08',	11,	9),
(12,	'1999',	'3',	'6',	'2019-08-11',	10,	10);

DROP TABLE IF EXISTS `jhi_authority`;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_authority` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_persistent_audit_event` (`event_id`, `principal`, `event_date`, `event_type`) VALUES
(1,	'admin',	'2019-08-09 06:50:54',	'AUTHENTICATION_SUCCESS'),
(2,	'admin',	'2019-08-09 07:57:51',	'AUTHENTICATION_SUCCESS'),
(3,	'admin',	'2019-08-11 00:32:30',	'AUTHENTICATION_SUCCESS'),
(4,	'admin',	'2019-08-11 00:45:00',	'AUTHENTICATION_SUCCESS'),
(5,	'admin',	'2019-08-11 03:55:58',	'AUTHENTICATION_SUCCESS'),
(6,	'admin',	'2019-08-11 04:14:09',	'AUTHENTICATION_SUCCESS'),
(7,	'admin',	'2019-08-11 04:15:02',	'AUTHENTICATION_SUCCESS'),
(8,	'admin',	'2019-08-11 04:29:20',	'AUTHENTICATION_SUCCESS'),
(9,	'admin',	'2019-08-11 04:50:10',	'AUTHENTICATION_SUCCESS'),
(10,	'admin',	'2019-08-11 04:55:20',	'AUTHENTICATION_SUCCESS'),
(11,	'admin',	'2019-08-11 05:06:57',	'AUTHENTICATION_SUCCESS'),
(12,	'admin',	'2019-08-11 05:26:32',	'AUTHENTICATION_SUCCESS'),
(13,	'admin',	'2019-08-11 05:27:26',	'AUTHENTICATION_SUCCESS'),
(14,	'admin',	'2019-08-11 05:29:18',	'AUTHENTICATION_SUCCESS'),
(15,	'admin',	'2019-08-11 05:31:31',	'AUTHENTICATION_SUCCESS'),
(16,	'admin',	'2019-08-11 05:35:58',	'AUTHENTICATION_SUCCESS'),
(17,	'admin',	'2019-08-11 07:44:33',	'AUTHENTICATION_SUCCESS'),
(18,	'admin',	'2019-08-11 16:41:48',	'AUTHENTICATION_SUCCESS'),
(19,	'admin',	'2019-08-11 18:05:49',	'AUTHENTICATION_SUCCESS');

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `jhi_user`;
CREATE TABLE `jhi_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(191) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_user_login` (`login`),
  UNIQUE KEY `ux_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_user` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `email`, `image_url`, `activated`, `lang_key`, `activation_key`, `reset_key`, `created_by`, `created_date`, `reset_date`, `last_modified_by`, `last_modified_date`) VALUES
(1,	'system',	'$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG',	'System',	'System',	'system@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(2,	'anonymoususer',	'$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO',	'Anonymous',	'User',	'anonymous@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(3,	'admin',	'$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC',	'Administrator',	'Administrator',	'admin@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL),
(4,	'user',	'$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K',	'User',	'User',	'user@localhost',	'',	CONV('1', 2, 10) + 0,	'es',	NULL,	NULL,	'system',	NULL,	NULL,	'system',	NULL);

DROP TABLE IF EXISTS `jhi_user_authority`;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `jhi_user_authority` (`user_id`, `authority_name`) VALUES
(1,	'ROLE_ADMIN'),
(1,	'ROLE_USER'),
(3,	'ROLE_ADMIN'),
(3,	'ROLE_USER'),
(4,	'ROLE_USER');

DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `semesters` varchar(255) NOT NULL,
  `title` varchar(60) NOT NULL,
  `credits` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `program` (`id`, `name`, `semesters`, `title`, `credits`) VALUES
(1,	'Chips',	'FIFTH',	'Automotive Tactics architectures',	96665),
(2,	'Strategist SDD',	'TENTH',	'compressing',	31692),
(3,	'Pants Maryland',	'SECOND',	'Director Concrete Bedfordshire',	87737),
(4,	'program',	'SEVENTH',	'redundant',	81011),
(5,	'HDD',	'SECOND',	'deposit',	70196),
(6,	'auxiliary Human',	'EIGHTH',	'North Dakota Garden',	46559),
(7,	'Wallis and Futuna',	'EIGHTH',	'Computers Small Fresh Gloves back-end',	12706),
(8,	'South Georgia and the South Sandwich Islands',	'TENTH',	'Intelligent Granite Shirt Peru deposit',	72609),
(9,	'Strategist',	'SIXTH',	'mindshare Gorgeous',	2535),
(10,	'Brand777777',	'NINTH',	'Enterprise-wide Benin',	71459);

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `surname` varchar(60) NOT NULL,
  `address` varchar(60) NOT NULL,
  `telephone` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `student` (`id`, `name`, `surname`, `address`, `telephone`) VALUES
(1,	'Juan',	'PalotesXYZ',	'Mar 12',	'646545'),
(2,	'Electronics111',	'Soap methodology Albania',	'Home Namibia2222',	'102.932.4076'),
(3,	'syndicate77777',	'Mississippi Refined Rubber Chicken Table',	'Automotive',	'1-958-330-0262 x46164'),
(4,	'Games Regional Digitized',	'copy convergence',	'Mayotte',	'098.749.3895'),
(5,	'National Awesome sky blue',	'Tactics',	'scale interactive generating',	'926.521.2810'),
(6,	'Administrator',	'reinvent 24 hour Jewelery',	'monitor',	'1-776-093-6198 x8643'),
(7,	'Fantastic Plastic Chicken',	'payment',	'withdrawal COM',	'(319) 787-7527 x240'),
(8,	'system Small',	'Intelligent Outdoors',	'Harbor Montana',	'(912) 645-7229 x0526'),
(9,	'JSON',	'virtual deposit',	'Squares mint green e-business',	'(538) 183-3912 x26408'),
(10,	'SQL Games',	'Iraq Bedfordshire',	'Concrete 24/7 Directives',	'1-255-743-0929'),
(11,	'Cachupin',	'Espada',	'Roble 10',	'465464'),
(12,	'Carlosssss',	'Paleta',	'XXX 345',	'sdsdsd'),
(13,	'hdhdhdhdh',	'udhduhduh',	'hiusdhuih',	'09090909');

-- 2019-08-11 14:22:15
