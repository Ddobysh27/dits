Use `managementsystem`;
unlock tables;

DROP DATABASE `managementsystem`;
CREATE DATABASE `managementsystem`;
USE `managementsystem`;	
SET GLOBAL time_zone = '+3:00';

CREATE TABLE `topic`(
  `topicId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `description` varchar(100),
  `name` varchar(20)
);

CREATE TABLE `test`(
  `testId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `name` varchar(20),
  `description` varchar(100),
  `topicId` integer(10) NOT NULL,
  FOREIGN KEY (`topicId`) REFERENCES `topic` (`topicId`) ON DELETE CASCADE
);

CREATE TABLE `question`(
  `questionId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `description` varchar(100),
  `testId` integer(10)
  );

CREATE TABLE `answer`(
  `answerId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `description` varchar(100),
  `correct` tinyint(1),
  `questionId` integer(10) NOT NULL,
  FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE
);

CREATE TABLE `role`(
  `roleId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `user` binary(1) DEFAULT 0,
  `tutor` binary(1) DEFAULT 0,
  `admin` binary(1) DEFAULT 0
);

CREATE TABLE `user`(
  `userId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20),
  `lastName` varchar(20),
  `login` varchar(20),
  `password` integer(10),
  `roleId` integer(10) NOT NULL,
  FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE
);

#tiniint
CREATE TABLE `statistic`(
  `statisticId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `date` date,
  `correct` boolean,
  `questionId` integer(10),
  `userId` integer(10),
  FOREIGN KEY (`questionId`)  REFERENCES `question` (`questionId`) ON DELETE CASCADE,
  FOREIGN KEY (`userId`)  REFERENCES `user` (`userId`) ON DELETE CASCADE
);

CREATE TABLE `literature`(
  `literatureId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  `description` varchar(100),
  `questionId` integer(10) NOT NULL,
   FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE
);

CREATE TABLE `link`(
  `linkId` integer(10) PRIMARY KEY  NOT NULL AUTO_INCREMENT,
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
(3, 'Third Test', 'For topic 2', 2),
(4, 'Forth Test', 'For topic 1', 1);
UNLOCK TABLES;

LOCK TABLES `question` WRITE;
INSERT INTO `question` VALUES
(1,'First question','1'),
(2,'Second question','2'),
(3,'Third question','1'),
(4,'Forth question','2');
UNLOCK TABLES;

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES
(1,1,0,0),(2,0,1,0),(3,0,0,1);
UNLOCK TABLES;

lock tables user write;
insert into user values
(1, 'Gavin', 'Belson', 'GavinBelson', 101, 1),
(2, 'Peter', 'Gregory', 'PeetGreg', 102, 3),
(3, 'Richard', 'Hendrics', 'RichHen', 103, 2),
(4, 'Gilfoy', 'Canadian', 'Canadaonelove', 104, 1),
(5, 'Denesh', 'Pakistan', 'Pakistani', 105, 3);
unlock tables;

LOCK TABLES `answer` WRITE;
INSERT INTO `answer` VALUES
(1,'1 true answer on first question','1','1'),
(2,'2 false answer on first question','0','1'),
(3,'3 true answer on second question','1','2'),
(4,'4 false answer on second question','0','2');
UNLOCK TABLES;

lock tables literature write;
insert into literature values
(1, 'First lit', 1),
(2, 'Second lit', 4),
(3, 'Third lit', 2),
(4, 'Forth lit', 3);
unlock tables;

lock tables link write;
insert into link values 
(1, 'firstLink', 4),
(2, 'secondLink', 3),
(3, 'thirdLink', 2),
(4, 'forthLink', 1);
unlock tables;

LOCK tables `statistic` WRITE;
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
(11, '2001-12-20', 0, 1, 5),
(12, '2001-12-21', 1, 2, 3);
UNLOCK TABLES;

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
order by question.questionId;

DELIMITER //

CREATE FUNCTION testdifficulty(x1 int) RETURNS decimal(10, 2) DETERMINISTIC
BEGIN
DECLARE x2, x3 integer;
declare x4 float;
select sum(count) into x2 from teststatistic where testId = x1 and correct = 1 limit 1;
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

