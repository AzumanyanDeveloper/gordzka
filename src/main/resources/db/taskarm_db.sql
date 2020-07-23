/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.18-log : Database - taskarm_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`taskarm_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `taskarm_db`;

/*Table structure for table `blog` */


CREATE TABLE IF NOT EXISTS `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `author_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `blog` */

/*Table structure for table `category` */


CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;


/*Table structure for table `comments` */


CREATE TABLE  IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `comments` */

/*Table structure for table `location` */

CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `location_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `location` */

/*Table structure for table `task` */


CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` text NOT NULL,
  `deadline` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `type` enum('TOP','URGENTLY','DEFAULT') NOT NULL DEFAULT 'DEFAULT',
  `status` enum('NEW','IN_PROGRESS','FINISHED') NOT NULL DEFAULT 'NEW',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `task_ibfk_3` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `task` */

/*Table structure for table `user` */

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `gender` enum('MALE','FEMALE') DEFAULT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) NOT NULL,
  `type` enum('EXECUTOR','CUSTOMER','ADMIN') DEFAULT NULL,
  `location_id` int(11) NOT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `aboutme` text,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `location` */

insert  into `location`(`id`,`name`,`parent_id`) values
(1,'Երևան',NULL),
(2,'Աջափնյակ',1),
(3,'Արաբկիր',1),
(4,'Ավան',1),
(5,'Դավիթաշեն',1),
(6,'Էրեբունի',1),
(7,'Քանաքեռ Զեյթուն',1),
(8,'Կենտրոն',1),
(9,'Մալաթիա Սեբաստիա',1),
(10,'Նոր Նորք',1),
(11,'Նորք Մարաշ',1),
(12,'Նուբարաշեն',1),
(13,'Շենգավիթ',1),
(14,'Արագածոտն',NULL),
(15,'Ապարան',14),
(16,'Արագած',14),
(17,'Արուճ',14),
(18,'Աշտարակ',14),
(19,'Բյուրական',14),
(20,'Կոշ',14),
(21,'Մուղնի',14),
(22,'Օշական',14),
(23,'Թալին',14),
(24,'Ծաղկահովիտ',14),
(25,'Ուջան',14),
(26,'Ոսկեվազ',14),
(27,'Արարատ',NULL),
(28,'Արարատ',27),
(29,'Արգավանդ',27),
(30,'Արտաշատ',27),
(31,'Այնթապ',27),
(32,'Գեղանիստ',27),
(33,'Գետափնյա',27),
(34,'Հայանիստ',27),
(35,'Մասիս',27),
(36,'Նոր Խարբերդ',27),
(37,'Վեդի',27),
(38,'Արմավիր',NULL),
(39,'Արմավիր',38),
(40,'Էջմիածին',38),
(41,'Մեծամոր',38),
(42,'Մուսալեռ',38),
(43,'Փարաքար',38),
(44,'Թաիրով',38),
(45,'Արցախ',NULL),
(46,'Ասկերան',45),
(47,'Հադրութ',45),
(48,'Քաշաթաղ',45),
(49,'Լաչին',45),
(50,'Մարտակերտ',45),
(51,'Մարտունի',45),
(52,'Շուշի',45),
(53,'Ստեփանակերտ',45),
(54,'Գեղարքունիք',NULL),
(55,'Ճամբարակ',54),
(56,'Գավառ',54),
(57,'Մարտունի ',54),
(58,'Սևան',54),
(59,'Վարդենիս',54),
(60,'Կոտայք',NULL),
(61,'Աբովյան',60),
(62,'Աղվերան',60),
(63,'Արգել',60),
(64,'Առինջ',60),
(65,'Արզնի',60),
(66,'Բջնի',60),
(67,'Բյուրեղավան',60),
(68,'Չարենցավան',60),
(69,'Ձորաղբյուր',60),
(70,'Գառնի',60),
(71,'Գետամեջ',60),
(72,'Գողթ',60),
(73,'Հրազդան',60),
(74,'Ջրվեժ',60),
(75,'Քանաքեռավան',60),
(76,'Քասախ',60),
(77,'Մայակովսկի',60),
(78,'Մրգաշեն',60),
(79,'Նոր Հաճըն',60),
(80,'Նուռնուս',60),
(81,'Պռոշյան',60),
(82,'Պտղնի',60),
(83,'Ծաղկաձոր',60),
(84,'Եղվարդ',60),
(85,'Զովունի',60),
(86,'Լոռի',NULL),
(87,'Ալավերդի',86),
(88,'Դսեղ',86),
(89,'Սպիտակ',86),
(90,'Ստեփանավան',86),
(91,'Տաշիր',86),
(92,'Վանաձոր',86),
(93,'Շիրակ',NULL),
(94,'Արթիկ',93),
(95,'Գյումրի',93),
(96,'Մարալիկ',93),
(97,'Սյունիք',NULL),
(98,'Գորիս',97),
(99,'Քաջարան',97),
(100,'Կապան',97),
(101,'Մեղրի',97),
(102,'Սիսիան',97),
(103,'Տավուշ',NULL),
(104,'Բերդ',103),
(105,'Դիլիջան',103),
(106,'Իջևան',103),
(107,'Նոյեմբերյան',103),
(108,'Վայոց Ձոր',NULL),
(109,'Ջերմուկ',108),
(110,'Վայք',108),
(111,'Եղեգնաձոր',108);

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
