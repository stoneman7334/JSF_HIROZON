# Host: localhost  (Version 5.7.19-log)
# Date: 2017-10-04 15:10:23
# Generator: MySQL-Front 6.0  (Build 1.124)


#
# Structure for table "buyhistory"
#

DROP TABLE IF EXISTS `buyhistory`;
CREATE TABLE `buyhistory` (
  `ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "buyhistory"
#


#
# Structure for table "cart"
#

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "cart"
#


#
# Structure for table "category"
#

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "category"
#


#
# Structure for table "m_category"
#

DROP TABLE IF EXISTS `m_category`;
CREATE TABLE `m_category` (
  `c_id` varchar(10) NOT NULL DEFAULT '',
  `c_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "m_category"
#

INSERT INTO `m_category` VALUES ('0002','食品'),('0003','お酒'),('0004','車'),('0005','おもちゃ'),('0006','薬'),('0007','パソコン'),('0008','ホーム＆キッチン'),('0009','本'),('0010','ビデオ'),('0011','家電');

#
# Structure for table "m_product"
#

DROP TABLE IF EXISTS `m_product`;
CREATE TABLE `m_product` (
  `p_id` varchar(10) NOT NULL DEFAULT '',
  `p_name` varchar(100) DEFAULT NULL,
  `p_count` int(3) DEFAULT NULL,
  `p_price` int(10) DEFAULT NULL,
  `p_img` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "m_product"
#

INSERT INTO `m_product` VALUES ('0002','単機能レンジ22L',100,15000,NULL),('0003','炊飯器マイコン式',100,7000,NULL),('0004','電気ケトル1.2L',100,5000,NULL),('0005','焼肉グリルやきまる',100,8000,NULL),('0006','オーストラリア産牛もも（1kg）',100,2000,NULL),('0007','おまかせ野菜＆果物セット',100,3000,NULL),('0008','レッドチェダー約1kg',100,4500,NULL),('0009','塩ふき昆布',100,1000,NULL),('0010','伯方の塩',100,400,NULL),('0011','純米ひやおろし',100,1400,NULL),('0012','秋あがり',100,1300,NULL),('0013','こんにちは料理酒',100,1300,NULL),('0014','発泡にごり酒',100,1700,NULL),('0015','南部美人',100,3000,NULL),('0016','タントカスタム',100,1600000,NULL),('0017','ヴェルファイア',100,3300000,NULL),('0018','FJクルーザー',100,4000000,NULL),('0019','ムーヴパイオニア製',100,1200000,NULL),('0020','キャストスポーツ',100,1700000,NULL),('0021','ナインタイル',100,4000,NULL),('0022','ブロックス',100,2000,NULL),('0023','カタン　スタンダード',100,3000,NULL),('0024','ダンジョンオブマンダム',100,2500,NULL),('0025','ワイナリーの四季',100,6500,NULL),('0026','アネロン',100,2500,NULL),('0027','命の母ホワイト',100,6000,NULL),('0028','イブクイック',100,700,NULL),('0029','バファリンプレミアム',100,1300,NULL),('0030','パブロンゴールドA',100,1400,NULL),('0031','ゲーミングPC',100,135000,NULL),('0032','Dellノートパソコン',100,240000,NULL),('0033','Dellデスクトップパソコン',100,130000,NULL),('0034','AceｒPredator',100,240000,NULL),('0035','ALIENWARE',100,600000,NULL),('0036','ティファール鍋９点セット',100,3000,NULL),('0037','マイヤーグルメセット',100,12000,NULL),('0038','チタンコーティング包丁セット',100,4000,NULL),('0039','おしゃれなスライス石',100,800,NULL),('0040','マーベルカレー皿セット',100,3000,NULL),('0041','日本の給料＆職業図鑑',100,1100,NULL),('0042','道は開ける　文庫版',100,800,NULL),('0043','マッチョ社長が教える完全無欠の時間管理術',100,1300,NULL),('0044','シンプルに結果を出す人の5W1H思考',100,2000,NULL),('0045','明日クビになっても大丈夫！',100,1600,NULL),('0046','ラ・ラ・ランド',100,2500,NULL),('0047','モアナと伝説の海',100,2500,NULL),('0048','ミニオンズ',100,1000,NULL),('0049','プロメテウス',100,900,NULL),('0050','グレートウォール',100,2500,NULL);

#
# Structure for table "m_user"
#

DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `u_Id` varchar(10) NOT NULL DEFAULT '',
  `u_name` varchar(20) DEFAULT NULL,
  `u_mailaddr` varchar(20) DEFAULT NULL,
  `u_pass` varchar(256) DEFAULT NULL,
  `u_post` varchar(20) DEFAULT NULL,
  `u_address` varchar(20) DEFAULT NULL,
  `u_tel` varchar(20) DEFAULT NULL,
  `u_birth_day` varchar(20) DEFAULT NULL,
  `u_sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`u_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "m_user"
#

INSERT INTO `m_user` VALUES ('0002','吉本直人','xxxxyyyy@gmail.co.jp','123131213','7330001','広島県','12345678','1990/8/14','1'),('0003','国貞正樹','xxxxyyyy@gmail.co.jp','123131213','7330001','広島県','12345678','1990/8/14','1'),('0004','森口有機','xxxxyyyy@gmail.co.jp','123131213','7330001','広島県','12345678','1990/8/14','1'),('0005','石山大樹','xxxxyyyy@gmail.co.jp','d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1','7330001','広島県','12345678','1990/8/14','1'),('0006','西川あんこ','xxxxyyyy@gmail.co.jp','123131213','7330001','広島県','12345678','1990/8/14','1');

#
# Structure for table "procate"
#

DROP TABLE IF EXISTS `procate`;
CREATE TABLE `procate` (
  `ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "procate"
#


#
# Structure for table "product"
#

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "product"
#


#
# Structure for table "sequence"
#

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sequence"
#

INSERT INTO `sequence` VALUES ('SEQ_GEN',0);

#
# Structure for table "t_buy_history"
#

DROP TABLE IF EXISTS `t_buy_history`;
CREATE TABLE `t_buy_history` (
  `buy_id` varchar(10) NOT NULL DEFAULT '',
  `u_id` varchar(10) DEFAULT NULL,
  `datetime` datetime(1) DEFAULT NULL,
  `count` varchar(3) DEFAULT NULL,
  `price` varchar(3) DEFAULT NULL,
  `p_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`buy_id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `t_buy_history_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `m_user` (`u_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_buy_history"
#


#
# Structure for table "t_caｒt"
#

DROP TABLE IF EXISTS `t_caｒt`;
CREATE TABLE `t_caｒt` (
  `u_id` varchar(10) NOT NULL DEFAULT '',
  `p_id` varchar(10) DEFAULT NULL,
  `count` int(3) DEFAULT NULL,
  `price` int(1) DEFAULT NULL,
  `datetime` datetime(1) DEFAULT NULL,
  `expiration` datetime(1) DEFAULT NULL COMMENT '有効期限',
  PRIMARY KEY (`u_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `t_caｒt_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `m_product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_caｒt"
#


#
# Structure for table "t_pro_cate"
#

DROP TABLE IF EXISTS `t_pro_cate`;
CREATE TABLE `t_pro_cate` (
  `p_id` varchar(10) NOT NULL DEFAULT '',
  `c_id` varchar(10) NOT NULL,
  PRIMARY KEY (`p_id`,`c_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `t_pro_cate_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `m_category` (`c_id`),
  CONSTRAINT `t_pro_cate_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `m_product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_pro_cate"
#

INSERT INTO `t_pro_cate` VALUES ('0003','0011'),('0004','0011'),('0005','0011'),('0006','0002'),('0007','0002'),('0008','0002'),('0009','0002'),('0010','0002'),('0011','0003'),('0012','0003'),('0013','0003'),('0014','0003'),('0015','0003'),('0016','0004'),('0017','0004'),('0018','0004'),('0019','0004'),('0020','0004'),('0021','0005'),('0022','0005'),('0023','0005'),('0024','0005'),('0025','0005'),('0026','0006'),('0027','0006'),('0028','0006'),('0029','0006'),('0030','0006'),('0031','0007'),('0032','0007'),('0033','0007'),('0034','0007'),('0035','0007'),('0036','0008'),('0037','0008'),('0038','0008'),('0039','0008'),('0040','0008'),('0041','0009'),('0042','0009'),('0043','0009'),('0044','0009'),('0045','0009'),('0046','0010'),('0047','0010'),('0048','0010'),('0049','0010'),('0050','0010');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` varchar(255) NOT NULL,
  `PASS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

#
#	カテゴリマスタと、商品マスタの結合したビュー
#
create view v_pro_cate as

select 
y.c_id,
y.c_name,
z.p_id,
z.p_name,
z.p_count,
z.p_price,
z.p_img,
z.p_img2,
z.p_img3

 from        


t_pro_cate x inner join m_category y on x.c_id = y.c_id

inner join m_product z on x.p_id = z.p_id

