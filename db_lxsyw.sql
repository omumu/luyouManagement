/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_lxsyw
Target Host: localhost
Target Database: db_lxsyw
Date: 2015/4/11 21:02:35
*/
create database db_lxsyw;
use db_lxsyw;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) default NULL,
  `userPw` varchar(50) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_baoming
-- ----------------------------
CREATE TABLE `t_baoming` (
  `id` int(11) NOT NULL auto_increment,
  `xianluId` int(11) default NULL,
  `userId` int(255) default NULL,
  `lianxifangshi` varchar(255) default NULL,
  `beizhu` varchar(255) default NULL,
  `baomingshi` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_binguan
-- ----------------------------
CREATE TABLE `t_binguan` (
  `id` int(11) NOT NULL,
  `mingcheng` varchar(50) default NULL,
  `dizhi` varchar(50) default NULL,
  `dianhua` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_dingcai
-- ----------------------------
CREATE TABLE `t_dingcai` (
  `id` int(11) NOT NULL default '0',
  `goodsId` int(255) default NULL,
  `shuliang` varchar(255) default NULL,
  `xingming` varchar(500) default NULL,
  `lianxi` varchar(255) default NULL,
  `dizhi` varchar(255) default NULL,
  `userId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
CREATE TABLE `t_goods` (
  `goods_id` int(11) NOT NULL,
  `jiudian_id` int(11) default NULL,
  `goods_name` varchar(200) default NULL,
  `goods_miaoshu` varchar(2000) default NULL,
  `fujian` varchar(50) default NULL,
  `goods_shichangjia` int(11) default NULL,
  `goods_tejia` int(11) default NULL,
  `goods_isnottejia` varchar(50) default NULL,
  `goods_Del` varchar(50) default NULL,
  PRIMARY KEY  (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_jingdian
-- ----------------------------
CREATE TABLE `t_jingdian` (
  `id` int(11) NOT NULL,
  `name` varchar(500) default NULL,
  `dizhi` varchar(66) default NULL,
  `menpiao` int(11) default NULL,
  `jieshao` varchar(8000) default NULL,
  `fujian` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_jiudian
-- ----------------------------
CREATE TABLE `t_jiudian` (
  `id` int(11) NOT NULL,
  `mingcheng` varchar(50) default NULL,
  `dizhi` varchar(50) default NULL,
  `dianhua` varchar(50) default NULL,
  `jieshao` varchar(8000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_kefang
-- ----------------------------
CREATE TABLE `t_kefang` (
  `id` int(11) NOT NULL,
  `kefangleixing` varchar(77) default NULL,
  `fangjianhao` varchar(88) default NULL,
  `area` varchar(77) default NULL,
  `jieshao` varchar(50) default NULL,
  `fujian` varchar(50) default NULL,
  `qianshu` int(11) default NULL,
  `del` varchar(50) default NULL,
  `binguanId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_liuyan
-- ----------------------------
CREATE TABLE `t_liuyan` (
  `id` int(11) NOT NULL,
  `neirong` varchar(4000) default NULL,
  `liuyanshi` varchar(55) default NULL,
  `userId` int(11) default NULL,
  `huifu` varchar(4000) default NULL,
  `huifushi` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) default NULL,
  `user_pw` varchar(50) default NULL,
  `user_realname` varchar(50) default NULL,
  `user_sex` varchar(50) default NULL,
  `user_age` varchar(50) default NULL,
  `user_address` varchar(255) default NULL,
  `user_tel` varchar(50) default NULL,
  `user_email` varchar(50) default NULL,
  `user_del` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xianlu
-- ----------------------------
CREATE TABLE `t_xianlu` (
  `id` int(11) NOT NULL,
  `xianlumincheng` varchar(200) default NULL,
  `fatuandidian` varchar(50) default NULL,
  `fatuanshiian` varchar(50) default NULL,
  `xianlujiage` varchar(50) default NULL,
  `lianxidianhua` varchar(50) default NULL,
  `lianxiren` varchar(66) default NULL,
  `fabushijian` varchar(50) default NULL,
  `del` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_xinwen
-- ----------------------------
CREATE TABLE `t_xinwen` (
  `id` int(11) NOT NULL auto_increment,
  `biaoti` varchar(50) default NULL,
  `neirong` varchar(5000) default NULL,
  `shijian` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_youji
-- ----------------------------
CREATE TABLE `t_youji` (
  `id` int(11) NOT NULL default '0',
  `biaoti` varchar(500) default NULL,
  `neirong` varchar(3000) default NULL,
  `fabushi` varchar(500) default NULL,
  `userId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yuding
-- ----------------------------
CREATE TABLE `t_yuding` (
  `id` int(11) NOT NULL,
  `kefangId` int(11) default NULL,
  `riqi` varchar(88) default NULL,
  `kehuming` varchar(55) default NULL,
  `dianhua` varchar(55) default NULL,
  `beizhu` varchar(55) default NULL,
  `userId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_yuyue
-- ----------------------------
CREATE TABLE `t_yuyue` (
  `id` int(11) NOT NULL default '0',
  `jiudianId` int(255) default NULL,
  `riqi` varchar(255) default NULL,
  `kehuming` varchar(500) default NULL,
  `dianhua` varchar(255) default NULL,
  `beizhu` varchar(255) default NULL,
  `userId` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_baoming` VALUES ('1', '1', '7', '13555555555', '我要去旅游', '2015-04-04 09:50');
INSERT INTO `t_baoming` VALUES ('2', '1', '9', '137776688', '111', '2015-04-11 17:34');
INSERT INTO `t_binguan` VALUES ('2', '庐山天街客栈', '庐山风景区电厂路25号', '0792-2249988、2249966');
INSERT INTO `t_binguan` VALUES ('3', '庐山太极宾馆', '庐山芦林路11号（芦林湖畔）', '0792-8568921,8568541');
INSERT INTO `t_dingcai` VALUES ('1', '2', '1', '刘三', '13555555555', '青岛路25#', '7');
INSERT INTO `t_goods` VALUES ('2', '1', '可乐鸡翅', '材料：鸡翅中、可乐一听、八角、姜、葱段、料酒', '/upload/1391927739600.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('3', '1', '糖醋排骨', '如何外酥里嫩&mdash;&mdash;煮30分钟，这样再大火热油炸到外面焦黄，就外酥里嫩了。如果用生排骨直接炸，容易老<br />\r\n<br />', '/upload/1391927815737.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('4', '1', '鱼香肉丝', '原料：猪里脊肉、青椒、水发木耳；葱、姜、蒜、蚝油、生抽、醋、糖、豆瓣酱、干辣椒。', '/upload/1391927887276.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('5', '1', '红烧茄子', '原料：长茄子、香菇、西红柿、青椒、葱花、姜末、蒜末、料酒、酱油、白砂糖、醋、水淀粉、干淀粉、食用油。', '/upload/1391927917370.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('6', '2', '糖醋鲤鱼', '原料：鲤鱼、葱、姜、蒜、料酒、酱油、糖、醋、清水、番茄酱、盐、淀粉、面粉。', '/upload/1391927997194.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('7', '2', '油焖大虾', '原料：熟对虾、葱花、姜丝、白酒、盐、糖、鸡精、香醋、高汤、香油。', '/upload/1391928027606.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('8', '2', '锅贴羊肉', '原料：羊肉馅、冬笋末、油豆皮、葱末、姜末、花椒粉、盐、鸡粉、黄酒、美极鲜酱油、香油、烹调油、面粉。', '/upload/1391928060412.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_goods` VALUES ('9', '2', '芫爆肚丝', '原料：猪肚、香菜、葱、姜、料酒、八角、葱姜蒜、料酒、盐、胡椒粉、醋。', '/upload/1391928086360.jpg', '20', '20', 'no', 'no');
INSERT INTO `t_jingdian` VALUES ('1', '庐山风景区', '江西省九江市庐山区境内', '100', '中国名山&mdash;&mdash;庐山，坐落于江西北部，总面积302平方公里，山体面积282平方公里，东西两侧为大断裂，雄伟壮观。庐山又称匡山、匡庐，耸峙于长江中下游平原与鄱阳湖畔，余邵诗云：&ldquo;长江南岸鄱湖畔，拔地庐山风景妍；峭壁陡崖飞瀑布，奇峰秀岭绕云烟&rdquo;，庐山多峭壁悬崖，瀑布飞泻，云雾缭绕。险峻与柔丽相济，大山、大江、大湖浑然一体，以&ldquo;雄&rdquo;、&ldquo;奇&rdquo;、&ldquo;险&rdquo;、&ldquo;秀&rdquo;闻名于世，自古享有&ldquo;匡庐奇秀甲庐山天下&rdquo;之盛誉。北濒长江，东临鄱阳湖，是一座地垒式断块山，整个山体南北长29公里，东西宽约16公里，山体面积302平方公里，自古命名的山峰有171座，主峰大汉阳峰海拔1474米。 庐山&ldquo;春如梦、夏如滴、秋如醉、冬如玉&rdquo;，更构成一幅充满魅力的立体天然山水画。宋代诗人苏轼曾发出&ldquo;不识庐山真面目，只缘身在此山中&rdquo;的感慨。庐山拥有12个景区、474处景点，四季可游，唐代诗人白居易以&ldquo;匡庐奇秀甲天下&rdquo;八个字道出庐山的秀美和品位。庐山年平均降水1917毫米，年平均雾日191天，每年7月&mdash;9月平均气温16.9度，良好的气候条件和优美的自然环境，使庐山在十九世纪末就成为世界著名的避暑胜地。 <br />', '/upload/1388475335150.jpg', 'no');
INSERT INTO `t_jingdian` VALUES ('2', '天沐温泉度假村', '庐山山南景区温泉镇', '100', '天沐&bull;江西庐山温泉度假村，是由<a hidefocus=\"hidefocus\" class=\"black\" title=\"珠海\" href=\"http://www.lvmama.com/dest/guangdong_zhuhai\" target=\"_blank\">珠海</a>百富辰投资有限公司在江西开发的首家大型集温泉、餐饮、客房、会议、娱乐于一体的四星级度假村，位于江西九江庐山山南景区温泉镇，临环庐山公路、昌九高速、京九铁路、昌北机场，105国道，交通便捷。<br />\r\n　　度假村在原江西省庐山温泉工人疗养院基础上整合了庐山地理位置资源、庐山温泉历史文化资源、独特的水质资源以及现代理疗保健资源，设计和开发了系列产品。2002年9月开工建设，2003年9月28日全面营业，度假村引进国际先进的经营管理模式和超前理念，为宾客提供个性化的健康亲情式服务，已成为宾客养生保健、旅游度假、餐饮美食、商务会议和娱乐的理想胜地。<br />\r\n天沐温泉景区是晋代诗人陶渊明的栗里故居所在地。区内有陶渊明故里和温泉度假村两个游览区，分布于星德公路南北两侧。<br />\r\n<br />', '/upload/1388475472352.gif', 'no');
INSERT INTO `t_jingdian` VALUES ('3', '东林大峡谷(剪刀峡)', '庐山北部的深山之中，距离九江市区11公里', '100', '<p><span>庐山东林大峡谷</span>是生态文化旅游休闲度假区是世界文化遗产、世界地质公园、世界唯一优秀生态景区、国家5A级风景区庐山的主要构成部分。（南）昌----九（江）高速公路及105国道均贴景区西侧经过。距九江市区10公里。是峡谷型自然景区。<span style=\"line-height: 1.5\">东林大峡谷景区由生态自然景区剪刀峡和传统文化景区卧云垄两大景段组成，呈条状。上起牯岭街心公园，下止于105国道旁东林寺。全长近10公里，高差千米，植被率达95%以上，植物近3000种。空气清新，负氧离子浓度极高。主生态景段剪刀峡呈弯曲状槽谷，两侧山仪重叠夹峙，宛如把把剪刀。谷地由石英砂岩等构成，是罕见的第四纪冰川U型套谷。大U型谷底的小U型谷既深又陡，一段段曲折跳跌，几百个瀑潭递叠喷泻，终年不断，是庐山最大的瀑布群。东林大峡谷的水量为庐山众峡谷之最，是唯一的一年四季可赏瀑布的庐山景区。谷内藤树虬生，景致幽秀雄奇而神秘；卧云垄景段为缓坡冰碛遗迹，泉流纵横，跌水处处，主要景点有三叠飞瀑、水帘泉瀑布、剪刀峡瀑布、龙须泉瀑布、龙椅石瀑布、冰臼群、东晋慧远和尚祭龙宝潭----乌龙潭双瀑、天湖瀑布、陶渊明故里西庐隐居遗址、道教第三十六福地 东林祖庙----龙泉精舍遗址、虎溪园等。</span></p>', '/upload/1388475665374.jpg', 'no');
INSERT INTO `t_jingdian` VALUES ('4', '武陵岩漂流', '江西省九江市武宁东南部', '100', '<p>武陵岩峡谷位于庐山以西，地处国家生态示范区&mdash;&mdash;江西武宁东南部，紧毗历史名山吴王峰，上挨驰名中外的弥陀寺，绵延数十公里，贯穿武陵岩国家森林公园，南倚赣北第一高峰&mdash;&mdash;武陵岩神雾山，北入亚洲第一大土坝人工千岛湖&mdash;&mdash;柘林湖重点风景名胜区杨洲湖区，与永修柘林湖景区紧密相连。&nbsp;武陵岩峡谷漂流景区是目前江西省接待量最大的漂流景区，分上下两段，为赣北唯一的峡谷漂流，九曲十八弯的河道水急、石怪、洞幽、林奇、山秀，峡谷幽深、原始古朴、云雾缭绕、清新宜人，两岸犹如一幅美丽的画廊充满诗意，没有污染；一深一潭，错落有致。下&ldquo;险&rdquo;滩、飞流激浪，有惊无险；过深潭、随波逐流，听鸟观鱼；身临其境即可领略旖旎的自然风光，又可感觉拥抱大自然的无限乐趣。身临此胜地，如在画中游。&nbsp;沿途胜境，美妙神奇：&ldquo;凤凰池&rdquo;风姿绰约，&ldquo;龙王庙&rdquo;动魄惊心，&ldquo;玉女潭&rdquo;令人神往，&ldquo;双龟岩&rdquo;鬼斧神工，&ldquo;仙人潭&rdquo;神秘莫测，&ldquo;蟾蜍石&rdquo;栩栩如生&hellip;&hellip;近闻弥陀寺磬声鼓韵，仰观吴王峰峭壁凌云，峡谷间猿啼鸟语，群山中飞瀑流泉，柘林湖千岛棋布；好一个武陵仙境，真乃世外桃源。古老而美丽的传说，让人遐想；刺激又安全的漂流，使人流连&hellip;&hellip;</p>', '/upload/1388475752945.jpg', 'no');
INSERT INTO `t_jiudian` VALUES ('1', '盛世鑫缔餐馆', '庐山牯岭镇环山路1号', '13666666666', '1998年开业&nbsp;&nbsp;2012年装修&nbsp;&nbsp;170间房&nbsp;&nbsp;电话0792-8288858 传真0792-8285708<span id=\"ctl00_MainContentPlaceHolder_hotelDetailInfo_lbDesc\" itemprop=\"description\">庐山鑫缔宾馆是中央电视台大型专题片《人文圣山》中的焦点镜头而且被首选推荐，紧邻繁华的牯岭正街。宾馆环境幽雅，绿阴环抱、欧式别墅建筑风格给人以时尚、高雅和回归自然的感觉。<br />\r\n</span>');
INSERT INTO `t_jiudian` VALUES ('2', '锦绣盛世酒店', '牯岭镇牯岭正街500号', '0792-2244888', '2013年开业&nbsp;&nbsp;45间房&nbsp;&nbsp;电话0792-2244888 传真0792-7063666<span id=\"ctl00_MainContentPlaceHolder_hotelDetailInfo_lbDesc\" itemprop=\"description\">庐山锦绣盛世酒店位于庐山牯岭正街，环境优美，交通便利，2013年全新装修，全面改造，打造成为庐山休闲式的酒店。锦绣盛世内设有各式高级、舒适的客房，店内设有按摩房、足浴室、桑拿房等。一楼设有西餐厅、咖啡厅等。酒店奉着：&ldquo;高档消费，超值享受&rdquo;的经营理</span>');
INSERT INTO `t_kefang` VALUES ('2', '单人房', '101', '20', '干净卫生，环境优雅', '/upload/1346402572599.jpg', '100', 'no', '2');
INSERT INTO `t_kefang` VALUES ('3', '双人房', '102', '30', '干净卫生，环境优雅', '/upload/1346402572599.jpg', '100', 'no', '2');
INSERT INTO `t_kefang` VALUES ('4', '标准房', '103', '30', '干净卫生，环境优雅', '/upload/1346402572599.jpg', '100', 'no', '2');
INSERT INTO `t_kefang` VALUES ('5', '商务房', '104', '50', '干净卫生，环境优雅', '/upload/1346402572599.jpg', '100', 'no', '2');
INSERT INTO `t_liuyan` VALUES ('1', '1111111111111111111111111111111111111', '2015-04-04 09:50', '7', '11', '2015-04-11 17:36');
INSERT INTO `t_liuyan` VALUES ('2', '哇哇哇哇哇哇哇哇哇哇哇', '2015-04-04 09:50', '7', '', '');
INSERT INTO `t_liuyan` VALUES ('3', 'ddddddddd', '2015-04-04 09:50', '7', '', '');
INSERT INTO `t_liuyan` VALUES ('4', '1111', '2015-04-11 17:35', '9', '', '');
INSERT INTO `t_user` VALUES ('7', 'liusan', '000000', '刘三', '女', '22', '北京路', '13555555554', 'liusan@yahoo.cn', 'no');
INSERT INTO `t_user` VALUES ('8', '1', '1', '', '男', '20', '', '', '', 'no');
INSERT INTO `t_user` VALUES ('9', '123456', '123456', '刘强', '男', '20', '123456', '123456', '123456', 'no');
INSERT INTO `t_xianlu` VALUES ('1', '柘林湖一日游', '上海路22#', '2015-04-04 09:50', '200', '13555555555', '刘长军', '2015-01-03 08:00:26', 'no');
INSERT INTO `t_xianlu` VALUES ('2', '庐山三叠泉一日游', '上海路22#', '2015-04-04 09:50', '200', '13555555555', '刘长军', '2015-01-03 08:00:26', 'no');
INSERT INTO `t_xinwen` VALUES ('4', '谁是全球“最差游客”？美国人自评“最糟糕”', '<p>最近，美国在线旅游网站Triposo对数千名用户进行了一项调查访问，让受访者回答&ldquo;你认为哪国游客最糟糕&rdquo;这个问题。调查结果显示，游客名声最堪忧的10个国家分别是：美国、英国、俄罗斯、中国、澳大利亚、德国、印度、法国、意大利和巴西。而就在一年前，美国第二大团购网站&ldquo;生活社交&rdquo;也有过类似的评选，当时的&ldquo;冠军&rdquo;同样是美国，&ldquo;亚军&rdquo;则是中国。美国游客自称&ldquo;最糟糕&rdquo;</p>\r\n<p>人们对美国游客的印象常常是吵闹、粗野、肥胖，穿着稀奇古怪的衣服。Triposo对62个国家的700多名游客进行了访谈，结果显示，33%的受访者认为美国是最糟糕的游客。要知道，这个比例</p>\r\n<p>几乎是得票第二的英国的3倍。有意思的是，其实美国人大多都同意，自己是世界上素质最差游客&mdash;&mdash;44%的美国受访者给出了这个答案。游客究竟会在旅途中做出哪些令人&ldquo;嫌弃&rdquo;的糟糕举动呢?Triposo的访谈让受访者讲述自己在旅行中做出的不当行为，或者看到其他游客做过的糟糕举动，结果清单上列出了&ldquo;小偷小摸&rdquo;、</p>\r\n<p>&ldquo;在公众场合小便&rdquo;等等，还有高达六成的受访游客承认曾借着酒兴干了一些&ldquo;冒险&rdquo;的事情。</p>', '2015-04-04 09:50');
INSERT INTO `t_xinwen` VALUES ('5', '2015春节旅游：出境游人数继续增长 秩序明显好转', '<p>人民网北京2月7日电 （李政杰）据国家旅游局消息，2014年春节假日圆满落幕。在党中央、国务院的正确领导下，各地政府认真部署，相关部门密切协作，各级旅游部门充分保障，春节假日旅游市场秩序进一步好转，旅游公共服务水平不断提高，实现了&ldquo;安全、秩序、质量、效益&rdquo;四统一的工作目标，马年春节假日旅游充满了欢乐祥和的气氛。2014年春节假日旅游市场呈现以下特点：</p>\r\n<p>各地结合春节旅游市场特点，积极组织推出了文化内涵丰富、群众参与性强的旅游活动，开发了形式多样的旅游产品，营造了喜庆祥和的节日氛围。北京推出的各类庙会吸引了大量游客，其中地坛庙会共接待游客114万人次，同比增长11.4%。龙潭庙会共接待75.7万人次，比去年同期增长3.2%。圆明园庙会接待41.6万人次，同比增长13.2%。天津推出&ldquo;金马迎春旅游活动&rdquo;；</p>\r\n<p>上海市推出&ldquo;民俗迎新&rdquo;、&ldquo;都市观光&rdquo;、&ldquo;亲近自然&rdquo;、&ldquo;乐游农家&rdquo;四大类50余项主题旅游活动；山东整合推出&ldquo;迎新年第一缕曙光&rdquo;、&ldquo;来山东过大年&rdquo;、&ldquo;祈福贺年民俗文化&rdquo;、&ldquo;激情滑雪&rdquo;、&ldquo;温泉泡汤暖冬&rdquo;等十大类主题产品；辽宁推出以第十七届中国沈阳国际冰雪节、中国大连国际温泉滑雪节等系列节庆活动，吸引了大量市民和游客参与；新疆推出&ldquo;爱新疆?游家乡&rdquo;淡季旅游活动；广州市各区县继续举办了传统迎春花市。</p>', '2015-04-04 09:50');
INSERT INTO `t_youji` VALUES ('2', '两周2800元的云南深度游', '季节不同、审美不同，值得去的地方不同。云南是旅游大省，自然人文资源都很丰富，不同地区更是有不同的旅行季节。比如说位于海拔3000+的<a href=\"http://www.lvping.com/tourism-d106-diqing.html\">香格里拉</a>，最佳旅游季便是7月-8月草长莺飞之时；而大理的最佳旅游季又是阳春三月，那时除了能体会到春暖花开的美好，还能感受到浓郁的白族风情。对于<a href=\"http://www.lvping.com/tourism-d105-luguhu.html\">泸沽湖</a>，不同的人又有不同的看法，有人觉得是5-7月山杜鹃花开的时候，有人觉得是8-9月向日葵绚丽的时候，有人觉得只要风轻云淡，一切皆好', '2015-04-04 09:50', '7');
INSERT INTO `t_youji` VALUES ('3', '吃到荼靡——史上最全最啰嗦之台湾自由行攻略', '台湾通行证和入台证：和港澳通行证不同，入台需要两本证，不用觉得麻烦，确实现在去台湾并没有那么方便。首先得先去出入境管理局办理台湾通行证，大约10个工作日。办理好了以后才可以申办入台证，目前入台证必须通过旅行社办理，春秋、锦江、携程等都有代办功能，据说春秋的办理时间最长。咨询过春秋和携程，对比下来携程办理所需的资料更简便，可以以夫妻关系申请随同，也可以使用信用卡白金卡彩色复印件作为担保', '2015-04-04 09:50', '7');
INSERT INTO `t_youji` VALUES ('4', 'dddddddddddddddddddddd', 'dddddddddddddddddddd', '2015-04-04 09:50', '7');
INSERT INTO `t_youji` VALUES ('5', '1111', '&nbsp;11111', '2015-04-11 17:35', '9');
INSERT INTO `t_yuding` VALUES ('4', '2', '2015-04-09', '刘三', '13666666666', '无', '7');
