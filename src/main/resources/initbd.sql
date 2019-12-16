/*Use `managementsystem`;
unlock tables;

DROP DATABASE `managementsystem`;
CREATE DATABASE `managementsystem`;
USE `managementsystem`;
SET GLOBAL time_zone = '+3:00';

CREATE TABLE `topic`(
`topicId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` varchar(100),
`name` varchar(20)
);

CREATE TABLE `test`(
`testId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` varchar(20),
`description` varchar(100),
`topicId` integer(10) NOT NULL,
FOREIGN KEY (`topicId`) REFERENCES `topic` (`topicId`) ON DELETE CASCADE
);

CREATE TABLE `question`(
`questionId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` varchar(100),
`testId` integer(10),
FOREIGN KEY (`testId`) REFERENCES `test` (`testId`) ON DELETE CASCADE
);

CREATE TABLE `answer`(
`answerId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` varchar(100),
`correct` tinyint(1),
`questionId` integer(10) NOT NULL,
FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE
);

CREATE TABLE `role`(
`roleId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`user` binary(1) DEFAULT 0,
`tutor` binary(1) DEFAULT 0,
`admin` binary(1) DEFAULT 0
);

CREATE TABLE `user`(
`userId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`firstName` varchar(20),
`lastName` varchar(20),
`login` varchar(20),
`password` integer(10),
`roleId` integer(10) NOT NULL,
FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE
);

#tiniint
CREATE TABLE `statistic`(
`statisticId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`date` datetime,
`correct` boolean,
`questionId` integer(10),
`userId` integer(10),
FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE,
FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE
);

CREATE TABLE `literature`(
`literatureId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`description` varchar(100),
`questionId` integer(10) NOT NULL,
FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE
);

CREATE TABLE `link`(
`linkId` integer(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
`link` varchar(100),
`literatureId` integer(10) NOT NULL,
FOREIGN KEY (`literatureId`) REFERENCES `literature` (`literatureId`) ON DELETE CASCADE
);

LOCK TABLES `topic` WRITE;
INSERT INTO `topic` VALUES
(1,'First topic','First topic'),
(2,'Second topic','Second topic');
UNLOCK TABLES;

LOCK TABLES `test` WRITE;
INSERT INTO `test` VALUES
(1,'First test','For topic 1','1'),
(2,'Second test','For topic 2','2'),
(3, "Third Test", "For topic 2", 2),
(4, "Forth Test", "For topic 1", 1);
UNLOCK TABLES;

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES
(1,1,0,0),(2,0,1,0),(3,0,0,1);
UNLOCK TABLES;

lock tables user write;
insert into user values
(1, "Gavin", "Belson", "GavinBelson", 101, 1),
(2, "Peter", "Gregory", "PeetGreg", 102, 3),
(3, "Richard", "Hendrics", "RichHen", 103, 2),
(4, "Gilfoy", "Canadian", "Canadaonelove", 104, 1),
(5, "Denesh", "Pakistan", "Pakistani", 105, 3);
unlock tables;

LOCK TABLES `question` WRITE;
INSERT INTO `question` VALUES
(1,'Question 1','1'),
(2,'Question 2','1'),
(3,'Question 3','1'),
(4,'Question 4','1'),
(5,'Question 1','2'),
(6,'Question 2','2'),
(7,'Question 3','2'),
(8,'Question 4','2'),
(9,'Question 1','3'),
(10,'Question 2','3'),
(11,'Question 3','3'),
(12,'Question 4','3'),
(13,'Question 1','4'),
(14,'Question 2','4'),
(15,'Question 3','4'),
(16,'Question 4','4');
UNLOCK TABLES;

LOCK TABLE `statistic` WRITE;
INSERT INTO `statistic` VALUES
(1, '2001-12-10', 1, 1, 1),
(2, '2001-12-11', 0, 2, 2),
(3, '2001-12-12', 0, 1, 3),
(4, '2001-12-13', 0, 2, 4),
(5, '2001-12-14', 1, 1, 5),
(6, '2001-12-15', 1, 2, 4),
(7, '2001-12-16', 1, 1, 3),
(8, '2001-12-17', 0, 2, 2),
(9, '2001-12-18', 1, 1, 1),
(10, '2001-12-19', 1, 2, 4),
(11, '2001-12-20', 0, 1, 1),
(12, '2001-12-21', 1, 2, 1),
(13, '2001-12-21', 1, 2, 1),
(14, '2001-12-21', 1, 2, 1),
(15, '2001-12-21', 1, 2, 1),
(16, '2001-12-21', 1, 2, 3);
UNLOCK TABLES;

lock tables literature write;
insert into literature values
(1,
 
"Literature 1", 1),
(2, "Literature 2", 2),
(3, "Literature 3", 3),
(4, "Literature 4", 4),
(5, "Literature 5", 5),
(6, "Literature 6", 6),
(7, "Literature 7", 7),
(8, "Literature 8", 8),
(9, "Literature 9", 9),
(10, "Literature 10", 10),
(11, "Literature 11", 11),
(12, "Literature 12", 12),
(13, "Literature 13", 13),
(14, "Literature 14", 14),
(15, "Literature 15", 15),
(16, "Literature 16", 16);
unlock tables;

lock tables link write;
insert into link values
(1, "Link 1", 1),
(2, "Link 2", 2),
(3, "Link 3", 3),
(4, "Link 4", 4),
(5, "Link 5", 5),
(6, "Link 6", 6),
(7, "Link 7", 7),
(8, "Link 8", 8),
(9, "Link 9", 9),
(10, "Link 10", 10),
(11, "Link 11", 11),
(12, "Link 12", 12),
(13, "Link 13", 13),
(14, "Link 14", 14),
(15, "Link 15", 15),
(16, "Link 16", 16);
unlock tables;

LOCK TABLES `answer` WRITE;
INSERT INTO `answer` VALUES
(1,'Answer 1 (true)','1','1'),
(2,'Answer 2 (false)','0','1'),
(3,'Answer 3 (false)','0','1'),
(4,'Answer 4 (false)','0','1'),

(5,'Answer 1 (true)','1','2'),
(6,'Answer 2 (false)','0','2'),
(7,'Answer 3 (false)','0','2'),
(8,'Answer 4 (false)','0','2'),

(9,'Answer 1 (true)','1','3'),
(10,'Answer 2 (false)','0','3'),
(11,'Answer 3 (false)','0','3'),
(12,'Answer 4 (false)','0','3'),

(13,'Answer 1 (true)','1','4'),
(14,'Answer 2 (false)','0','4'),
(15,'Answer 3 (false)','0','4'),
(16,'Answer 4 (false)','0','4'),

(17,'Answer 1 (true)','1','5'),
(18,'Answer 2 (false)','0','5'),
(19,'Answer 3 (false)','0','5'),
(20,'Answer 4 (false)','0','5'),

(21,'Answer 1 (true)','1','6'),
(22,'Answer 2 (false)','0','6'),
(23,'Answer 3 (false)','0','6'),
(24,'Answer 4 (false)','0','6'),

(25,'Answer 1 (true)','1','7'),
(26,'Answer 2 (false)','0','7'),
(27,'Answer 3 (false)','0','7'),
(28,'Answer 4 (false)','0','7'),

(29,'Answer 1 (true)','1','8'),
(30,'Answer 2 (false)','0','8'),
(31,'Answer 3 (false)','0','8'),
(32,'Answer 4 (false)','0','8'),

(33,'Answer 1 (true)','1','9'),
(34,'Answer 2 (false)','0','9'),
(35,'Answer 3 (false)','0','9'),
(36,'Answer 4 (false)','0','9'),

(37,'Answer 1 (true)','1','10'),
(38,'Answer 2 (false)','0','10'),
(39,'Answer 3 (false)','0','10'),
(40,'Answer 4 (false)','0','10'),

(41,'Answer 1 (true)','1','11'),
(42,'Answer 2 (false)','0','11'),
(43,'Answer 3 (false)','0','11'),
(44,'Answer 4 (false)','0','11'),

(45,'Answer 1 (true)','1','12'),
(46,'Answer 2 (false)','0','12'),
(47,'Answer 3 (false)','0','12'),
(48,'Answer 4 (false)','0','12'),

(49,'Answer 1 (true)','1','13'),
(50,'Answer 2 (false)','0','13'),
(51,'Answer 3 (false)','0','13'),
(52,'Answer 4 (false)','0','13'),

(53,'Answer 1 (true)','1','14'),
(54,'Answer 2 (false)','0','14'),
(55,'Answer 3 (false)','0','14'),
(56,'Answer 4 (false)','0','14'),

(57,'Answer 1 (true)','1','15'),
(58,'Answer 2 (false)','0','15'),
(59,'Answer 3 (false)','0','15'),
(60,'Answer 4 (false)','0','15'),

(61,'Answer 1 (true)','1','16'),
(62,'Answer 2 (false)','0','16'),
(63,'Answer 3 (false)','0','16'),
(64,'Answer 4 (false)','0','16');
UNLOCK TABLES;

create procedure personalUserTestStatistic(unreservedUserId int, unreserverStart datetime, unreservedEnd datetime)
SELECT * FROM statistic where userId=unreservedUserId and date between unreserverStart and unreservedEnd;

create procedure personalUserStatistic(unreservedId int)
select count(questionId) as somecount, correct, questionId from statistic where userId=unreservedId group by questionId, correct;

create view questionstatistic as
select count(statistic.correct) as count, correct, statistic.questionId
from statistic join question on statistic.questionId = question.questionId
group by statistic.questionId, statistic.correct
order by questionId;

create view teststatistic as
select count(statistic.correct) as count, correct, test.testId
from statistic
join question on statistic.questionId = question.questionId
join test on test.testId = question.testId
group by test.testId, statistic.correct
order by statistic.questionId;

DELIMITER //

CREATE FUNCTION testdifficulty(x1 int) RETURNS decimal(10, 2) DETERMINISTIC
BEGIN
DECLARE x2, x3 integer;
declare x4 float;
select
 
sum(count) into x2 from teststatistic where testId = x1 and correct = 1 limit 1;
select sum(count) into x3 from teststatistic where testId = x1 limit 1;
set x4 = x2 / x3;
RETURN (x4);
END
//

DELIMITER ;

DELIMITER //

CREATE FUNCTION questiondifficulty(x1 int) RETURNS decimal(10, 2) DETERMINISTIC
BEGIN
DECLARE x2, x3 integer;
declare x4 float;
select sum(count) into x2 from questionstatistic where questionId = x1 and correct = 1 limit 1;
select sum(count) into x3 from questionstatistic where questionId = x1 limit 1;
set x4 = x2 / x3;
RETURN (x4);
END
//

DELIMITER ;

DELIMITER //

CREATE FUNCTION rightRare(correct int, total int) RETURNS decimal(10, 2) DETERMINISTIC
BEGIN
DECLARE x2, x3 integer;
declare x4 float;
set x4 = correct / total;
RETURN (x4);
END
//

DELIMITER ;*/