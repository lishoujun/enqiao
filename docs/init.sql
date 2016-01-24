-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 10.0.16.16:3066
-- Generation Time: 2015-04-02 14:17:47
-- 服务器版本： 10.0.4-MariaDB-log
-- PHP Version: 5.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `a5516322_maria_mwup5d29`
--

-- --------------------------------------------------------

--
-- 表的结构 `links`
--

CREATE TABLE IF NOT EXISTS `links` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL COMMENT 'title',
  `url` varchar(100) NOT NULL COMMENT 'url',
  `user_id` int(11) DEFAULT '0' COMMENT 'if this link add by user',
  `isdel` varchar(1) DEFAULT '1' COMMENT 'if this link is delete 0isdelete 1isnot',
  `click` int(8) DEFAULT '0' COMMENT 'click',
  `topic` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `links_topic_FK` (`topic`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=101 ;

--
-- 转存表中的数据 `links`
--

-- --------------------------------------------------------

--
-- 表的结构 `topic`
--

CREATE TABLE IF NOT EXISTS `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `title` varchar(40) NOT NULL COMMENT '分类标题',
  `heavy` int(11) NOT NULL COMMENT '权重',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `topic`
--


--
-- 限制导出的表
--

--
-- 限制表 `links`
--
ALTER TABLE `links`
  ADD CONSTRAINT `links_topic_FK` FOREIGN KEY (`topic`) REFERENCES `topic` (`tid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



--
-- 表的结构 `jobs`
--

CREATE TABLE IF NOT EXISTS `jobs`(
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL COMMENT 'title',
  `content` varchar(100) COMMENT 'content',
  `longitude` varchar(40) NOT NULL COMMENT '经度',
  `latitude` varchar(40) NOT NULL COMMENT '纬度',
  `isOpen` varchar(2) DEFAULT '0' COMMENT 'isOpen',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO a5516322_maria_mwup5d29.jobs (id,title,content,longitude,latitude,isOpen) VALUES 
(1,'aaa','aaaaaaa','116.605381','39.9309','0')
,(2,'bbb','bbbbbbbbb','116.488022','39.950424','0')
;
