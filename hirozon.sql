# Host: localhost  (Version 5.7.19-log)
# Date: 2017-10-20 14:35:13
# Generator: MySQL-Front 6.0  (Build 1.124)


#
# Structure for table "t_cart"
#

DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `u_id` varchar(10) NOT NULL DEFAULT '',
  `p_id` varchar(10) NOT NULL,
  `count` int(3) DEFAULT NULL,
  `price` int(1) DEFAULT NULL,
  `datetime` datetime(1) DEFAULT NULL,
  `expiration` datetime(1) DEFAULT NULL COMMENT '有効期限',
  PRIMARY KEY (`id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `t_cart_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `m_product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_cart"
#

INSERT INTO `t_cart` VALUES ('1','0002','0002',1,1,X'323031312D31312D31312030303A30303A30302E30',X'323031312D31312D31312030303A30303A30302E30'),('2','0005','0041',0,1100,X'323031372D31302D31372031363A34333A35382E33',X'323031372D31302D31372031363A34333A35382E33');
