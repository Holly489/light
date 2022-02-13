/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - qwer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qwer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qwer`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(20) DEFAULT NULL,
  `article_date` date DEFAULT NULL,
  `article_author` varchar(30) DEFAULT NULL,
  `article_content` varchar(2000) DEFAULT NULL,
  `article_img_uri` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`article_id`,`article_title`,`article_date`,`article_author`,`article_content`,`article_img_uri`) values (15,'《罗马假日》','2020-11-01','木鱼水心','罗马假日是奥黛丽赫本主演的影片，上映于1953年，由威廉会的执导。威廉慧勒是非常知名的电影导演，他曾经三次获得奥斯卡最佳导演，分别是《忠勇之家》《黄金时代》和《宾虚》，其中并没有包括这部经典的《罗马假日》，不过奥黛丽赫本却凭借此片获得了奥斯卡最佳女主角。诚然，奥黛丽赫本在此片中的魅力实在是太耀眼了，她的举手投足，一颦一笑让人一看就难以忘怀。优雅与俏皮，安静与活泼，这些完全相对甚至相反的属性，在她的身上结合得如此完美，真的难怪她成为了千百万人心中的女神，也成为了电影银幕上永远的公主。 罗马假日这样的偶遇发生爱情最后分离的故事有很多，不过此片将爱情的对象设定在一个想要寻找自由，但最后还是忠实于责任的公主，却在当时是一个很突破常规的事件，影片也从此成为了一代经典。','https://gitee.com/l1031652416wo/img-bed/raw/master/%E7%BD%97%E9%A9%AC%E5%81%87%E6%97%A5aaa.jpg'),(16,'《麦兜故事》','2020-11-01','袁建滔','只是这一次，所有的梦都没能实现。没有鱼丸，也没有粗面。没有马尔代夫，更没有奥运奖牌。有的只是平常到再也平常不过的人生。正因为如此，成年后的麦兜才会说他不聪明，没有办法为这个故事加点教训或者锦囊。因为就算拼命努力，也并没有必然实现梦想之路。如果努力可能无法实现梦想，那努力做什么呢？','https://gitee.com/l1031652416wo/img-bed/raw/master/%E9%BA%A6%E5%85%9C%E6%95%85%E4%BA%8B%E5%B0%81%E9%9D%A2.webp'),(17,'《从零开始的异世界生活》','2020-11-01','长月达平','在异世界陷入迷茫的普通高中生菜月昴，邂逅了一位银发的美少女。但想助她一臂之力的昴，却一次次地遭遇敌袭，背叛、暴力，甚至是死亡……“死亡重置”——无力的少年拥有的唯一能力，能将死后时间倒转回一开始。使用了这般力量，便会失去过去的回忆，可为了守护最重要的人们，昴必须抗争到底。“即使你忘却了我，我也不会遗忘你。”','https://i0.hdslb.com/bfs/bangumi/7c1f3ca60da441ffbc2425409ee2a5c379264568.jpg@282w_375h.webp'),(18,'《傲慢与偏见》影评','2020-11-01','小丸子','《傲慢与偏见》的影评','https://gitee.com/holly489/imagbed/raw/master/%E5%B0%81%E9%9D%A2.webp'),(19,'《朝花夕誓：于离别之朝束起约定之花》','2020-11-01','冈田麿里，篠原俊哉',' 在世界的尽头，住着一群被称为“离别一族”的古老民族：他们拥有着长寿之血和永生不老的面容。 在一场外族入侵的战役中，离别一族惨遭灭族，15岁的玛奇亚虽然侥幸逃生，却彻底和朋友失去了联系。孤身一人的她在残骸中拾到了一个普通人家的遗孤，并决定收养他。然而随着时间的流逝，玛奇亚必须要学会如何做一个母亲，经历人间的生离死别，并在朝代的更迭中守护“离别一族”最后的信仰…','https://i0.hdslb.com/bfs/bangumi/a69ff3a007491415d2a6f00e753c657761bc2e3f.jpg@282w_375h.webp');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_title` varchar(80) DEFAULT NULL,
  `book_img_uri` varchar(2000) DEFAULT NULL,
  `book_content` varchar(1000) DEFAULT NULL,
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_author` varchar(20) DEFAULT NULL,
  `book_date` date DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`book_title`,`book_img_uri`,`book_content`,`book_id`,`book_author`,`book_date`) values ('《草房子》','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%8D%89%E6%88%BF%E5%AD%90%E5%B0%81%E9%9D%A2%E5%B0%81%E9%9D%A2.jpg','《草房子》是一部讲究品位的少年长篇小说。作品写了男孩桑桑刻骨铭心，终身难忘的六年小学生活。六年中，他亲眼目睹或直接参与了一连串看似寻常但又催人泪下、撼动人心的故事：少男少女之间毫无瑕疵的纯情，不幸少年与厄运相拼时的悲怆与优雅，残疾男孩对尊严的执著坚守，垂暮老人在最后一瞬所闪耀的人格光彩，在死亡体验中对生命的深切而优美的领悟，大人们之间扑朔迷离且又充满诗情画意的情感纠葛……这一切，既清楚又朦胧地展现在少年桑桑的世界里。这六年，是他接受人生启蒙教育的六年。',12,'曹文轩','2020-11-01'),('《No Game No Life 游戏人生 零》','https://gitee.com/l1031652416wo/img-bed/raw/master/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201101114142.jpg','这是一个禁止一切争端、一切皆由游戏决定的“盘上世界”被创造出来以前的故事。\n围绕着一统世界的唯一神的宝座，看不到尽头的大战延续的时代。 天地割裂，甚至连繁星都被毁灭殆尽的凄惨战争， 毫无还手之力的人类在战争中一个个死去。\n被拥有强大力量的各个种族逼入绝境， 人类濒临存亡，此时率领着人类的年轻领袖名叫里克。 他为了即使再多一人能够迎来明天而呕心沥血，日渐憔悴， 就在这样的某一天，里克在被弃置的森精种的都城遇到了机凯种少女休比。\n对于机械所不该拥有的心产生兴趣而发生故障， 被同伴抛弃的休比，为了修复故障，而拜托里克把“人类的心”告诉自己，然而……\n这是在距今超过六千年的远古时代所编织而成的通往“最新神话”的“最初神话”。未曾留下记录亦或是记忆，没有对任何人诉说过的故事，现在开幕——',13,'榎宫祐','2020-11-01'),('《老人与海》','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%80%81%E4%BA%BA%E4%B8%8E%E6%B5%B72.jpg','人可以被毁灭，但不能被打败。”一位老人孤身在海上捕鱼，八十四天一无所获，等终于钓到大鱼，用了两天两夜才将其刺死。返航途中突遭鲨鱼袭击，经过一天一夜的缠斗，大鱼仅存骨架。但老人并未失去希望和信心，休整之后，准备再次出海……',14,'海明威','2020-11-01'),('《小王子》','https://gitee.com/holly489/imagbed/raw/master/%E5%B0%8F%E7%8E%8B%E5%AD%90%E5%B0%81%E9%9D%A2.jpg','',15,'安东尼·德·圣-埃克苏佩里','2020-11-01');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(10) NOT NULL AUTO_INCREMENT,
  `comment_date` date DEFAULT NULL,
  `comment_content` varchar(800) DEFAULT NULL,
  `book_title` varchar(50) DEFAULT NULL,
  `article_title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `recommend` */

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
  `recommend_title` varchar(80) DEFAULT NULL,
  `recommend_uri` varchar(400) DEFAULT NULL,
  `recommend_id` int(10) NOT NULL AUTO_INCREMENT,
  `recommend_outline` varchar(1000) DEFAULT NULL,
  `recommend_time` date DEFAULT NULL,
  `recommend_content` varchar(8000) DEFAULT NULL,
  `recommend_img_outline` varchar(80) DEFAULT NULL,
  `recommend_img_uri` varchar(200) DEFAULT NULL,
  `recommend_type` varchar(10) DEFAULT NULL,
  `article_book_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`recommend_id`),
  KEY `article_book_id` (`article_book_id`),
  CONSTRAINT `recommend_ibfk_1` FOREIGN KEY (`article_book_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `recommend` */

insert  into `recommend`(`recommend_title`,`recommend_uri`,`recommend_id`,`recommend_outline`,`recommend_time`,`recommend_content`,`recommend_img_outline`,`recommend_img_uri`,`recommend_type`,`article_book_id`) values ('《谁的青春不迷茫》','https://baike.baidu.com/item/%E8%B0%81%E7%9A%84%E9%9D%92%E6%98%A5%E4%B8%8D%E8%BF%B7%E8%8C%AB/16777450?fr=aladdin',1,'  你觉得孤独就对了,那是让你认识自己的机会,你觉得不被理解就对了,那是让你认清朋友的机会,你觉得黑dao暗就对了,那是让你发现光芒的机会,你觉得无助就对了,那样你才能知道谁是你的贵人,你觉得迷茫就对了,谁的青春不迷茫。','2020-10-28','我有的时候又非常羡慕别人的剧本，但是没有谁的剧本值得羡慕，你只能把你自己的剧本给演好，如果在你的一生中真的遭遇到这些挫折，那对不起，这就是你的剧本。你有两种选择，一种选择是弃演，一种选择就是把既定的剧本给选好、给演好。——罗翔','作者：刘同/导演：姚婷婷','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%B0%81%E7%9A%84%E9%9D%92%E6%98%A5%E4%B8%8D%E8%BF%B7%E8%8C%AB.jpg','2',NULL),('《草房子》','https://baike.baidu.com/item/%E8%8D%89%E6%88%BF%E5%AD%90/2163',2,'  太阳暖融融的，满地的紫云英，正蓬蓬勃勃地生长，在大地上堆起厚厚的绒绒的绿色。其间，开放着的一串串淡紫色的小花，正向四下里散发着甜丝丝的气味，引得许多蜜蜂在田野上嗡嗡欢叫。 ','2020-11-01','太阳暖融融的，满地的紫云英，正蓬蓬勃勃地生长，在大地上堆起厚厚的绒绒的绿色。其间，开放着的一串串淡紫色的小花，正向四下里散发着甜丝丝的气味，引得许多蜜蜂在田野上嗡嗡欢叫。','作者：曹文轩','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%8D%89%E6%88%BF%E5%AD%90.jpg','1',NULL),('《老人与海》','https://baike.baidu.com/item/%E8%80%81%E4%BA%BA%E4%B8%8E%E6%B5%B7/1065',3,'  他是个独自在湾流中一条小船上钓鱼的老人,至今已去了八十四天,一条鱼也没逮住。 2.他身上的每一部分都显得老迈,除了那一双眼睛。那双眼啊,跟海水一样蓝,是愉快的,毫不沮丧的。','2020-11-01','他是个独自在湾流中一条小船上钓鱼的老人,至今已去了八十四天,一条鱼也没逮住。 2.他身上的每一部分都显得老迈,除了那一双眼睛。那双眼啊,跟海水一样蓝,是愉快的,毫不沮丧的。','作者：欧内斯特·米勒尔·海明威','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%80%81%E4%BA%BA%E4%B8%8E%E6%B5%B7.jpg','1',NULL),('《芳华》','https://baike.baidu.com/item/%E8%8A%B3%E5%8D%8E/19926594',4,'  哪怕没有轰轰烈烈，但有个人时刻在你身边相依为命，那种长相厮守才是让人羡慕的神仙眷侣。我也相信，这才是真正的爱情','2020-11-01','哪怕没有轰轰烈烈，但有个人时刻在你身边相依为命，那种长相厮守才是让人羡慕的神仙眷侣。我也相信，这才是真正的爱情','作者：严歌苓/导演：冯小刚','https://gitee.com/l1031652416wo/img-bed/raw/master/%E8%8A%B3%E5%8D%8E.jpg','2',NULL),('《紫罗兰永恒花园》','https://baike.baidu.com/item/%E8%96%87%E5%B0%94%E8%8E%89%E7%89%B9%C2%B7%E4%BC%8A%E8%8A%99%E5%8A%A0%E7%99%BB/23425458?fromtitle=%E7%B4%AB%E7%BD%97%E5%85%B0%E6%B0%B8%E6%81%92%E8%8A%B1%E5%9B%AD&fromid=19695842#viewPageContent',5,'亲口说出「自己不懂感情」的她，现在正很高兴的点著头。仅此而已，但学者的心中升起的无比眷恋与令人发狂的苦闷却满溢而出。「薇尔莉特，我说你啊。」里昂伸出食指，指向天空。沙漠的夜空中，正挥洒著与这场再会再相称不过的辉煌宝石。 ――我现在仍旧喜欢著你，这种话先放在一边。现在应该说的是。「你要是有空的话，不如陪陪我。」我想与你一起，细数万千繁星。','2020-11-02','亲口说出「自己不懂感情」的她，现在正很高兴的点著头。仅此而已，但学者的心中升起的无比眷恋与令人发狂的苦闷却满溢而出。「薇尔莉特，我说你啊。」里昂伸出食指，指向天空。沙漠的夜空中，正挥洒著与这场再会再相称不过的辉煌宝石。 ――我现在仍旧喜欢著你，这种话先放在一边。现在应该说的是。「你要是有空的话，不如陪陪我。」我想与你一起，细数万千繁星。','作者：晓佳奈/插画：高濑亚贵子/导演：石立太一','https://gitee.com/l1031652416wo/img-bed/raw/master/%E7%B4%AB%E7%BD%97%E5%85%B0.jpg','2',NULL),('《红楼梦》','https://baike.baidu.com/item/%E7%BA%A2%E6%A5%BC%E6%A2%A6/15311?fr=aladdin',6,'一个是阆苑仙葩，一个是美玉无暇。若说没奇缘，今生偏又遇着他;若说有奇缘，如何心事终虚化?','2020-10-29','一个是阆苑仙葩，一个是美玉无暇。若说没奇缘，今生偏又遇着他;若说有奇缘，如何心事终虚化?','作者：曹雪芹/导演：王扶林','https://gitee.com/l1031652416wo/img-bed/raw/master/%E7%BA%A2%E6%A5%BC%E6%A2%A6.jpg','1',NULL),('《半泽直树》','https://baike.baidu.com/item/%E5%8D%8A%E6%B3%BD%E7%9B%B4%E6%A0%91/5882798',7,'像你一样就算得了不愿得的病，周围的人也不会说一句抱歉，他们甚至觉得错在会得病的人自己，遭受有去无回的流放。不管是谁，要想活下去，都得要钱和梦想。','2020-10-29','像你一样就算得了不愿得的病，周围的人也不会说一句抱歉，他们甚至觉得错在会得病的人自己，遭受有去无回的流放。不管是谁，要想活下去，都得要钱和梦想。','作者：池井户润/导演：福泽克雄 / 棚泽孝义 / 田中健太','https://gitee.com/l1031652416wo/img-bed/raw/master/%E5%8D%8A%E6%B3%BD%E7%9B%B4%E6%A0%91.jpg','2',NULL),('《麦兜故事》','https://baike.baidu.com/item/%E9%BA%A6%E5%85%9C%E6%95%85%E4%BA%8B/7396850?fr=aladdin',8,'只是这一次，所有的梦都没能实现。没有鱼丸，也没有粗面。没有马尔代夫，更没有奥运奖牌。有的只是平常到再也平常不过的人生。正因为如此，成年后的麦兜才会说他不聪明，没有办法为这个故事加点教训或者锦囊。因为就算拼命努力，也并没有必然实现梦想之路。如果努力可能无法实现梦想，那努力做什么呢？','2020-11-01','只是这一次，所有的梦都没能实现。没有鱼丸，也没有粗面。没有马尔代夫，更没有奥运奖牌。有的只是平常到再也平常不过的人生。正因为如此，成年后的麦兜才会说他不聪明，没有办法为这个故事加点教训或者锦囊。因为就算拼命努力，也并没有必然实现梦想之路。如果努力可能无法实现梦想，那努力做什么呢？','作者：谢立文/画家：麦家碧/导演：袁建滔','https://gitee.com/l1031652416wo/img-bed/raw/master/%E9%BA%A6%E5%85%9C%E6%95%85%E4%BA%8B.jpg','2',NULL),('《罗马假日》','https://baike.baidu.com/item/%E7%BD%97%E9%A9%AC%E5%81%87%E6%97%A5/30468?fr=aladdin',9,'美丽的公主明白自己对国家和社会的责任，曾经为了钱财的记者，却最后因为对公主的爱而决定放弃那些照片。在这样独特的氛围中，那种一切似乎都美好的按部就班的发生了，但是又有属于两个人的巨大遗憾，一定要心中的二元心境，让这个故事有一种青涩与回味，正如乔最后当公主走后等待在大厅里，其实观众和角色都希望公主什么时候可以从背景中出来，但是走了许久许久都没有等到。 <br>&nbsp;&nbsp;从这种意义上来说，罗马假日里的公主正对应了许多人心中那种对求之不得梦想之物的向往，但又知道不能接近的独特心境，而这似乎让这个故事的主题变得更加宽广了起来。 ','2020-10-30','123\\r\\n美丽的公主明白自己对国家和社会的责任，曾经为了钱财的记者，却最后因为对公主的爱而决定放弃那些照片。在这样独特的氛围中，那种一切似乎都美好的按部就班的发生了，但是又有属于两个人的巨大遗憾，一定要心中的二元心境，让这个故事有一种青涩与回味，正如乔最后当公主走后等待在大厅里，其实观众和角色都希望公主什么时候可以从背景中出来，但是走了许久许久都没有等到。 <br>&nbsp;&nbsp;从这种意义上来说，罗马假日里的公主正对应了许多人心中那种对求之不得梦想之物的向往，但又知道不能接近的独特心境，而这似乎让这个故事的主题变得更加宽广了起来。 ','导演：威廉·惠勒/主演：奥黛丽·赫本，格里高利·派克','https://gitee.com/l1031652416wo/img-bed/raw/master/%E7%BD%97%E9%A9%AC%E5%81%87%E6%97%A5.jpg','2',NULL),('《火之鸟》','https://baike.baidu.com/item/%E7%81%AB%E4%B9%8B%E9%B8%9F/2650347?fr=aladdin',10,'“火鸟是传说中的不死鸟，它可以穿越时空，不死不灭，阿拉伯人叫它费利克斯，中国人则称它们为凤凰，火鸟不会死亡，它们会在火中重生……”在漫画中手冢以火鸟做为线索，探讨生命的秘密讲述生命的故事。发生在不同时空里的十二个故事，虽然主角、时代、背景各不相同，但却有着共同的主题和内在的联系。读者随着火鸟一起纵横驰骋在人类的历史和未来里，体验手冢对人类文明、生命的意义以及宇宙本源的思考。富坚义博擅长峰回路转的悬念，但与之相比仅仅是玩弄结构游戏的小聪明；高桥留美子擅长刻画生活，但一比之下也变成了毛皮。在这部作品面前《凯普》那号称鬼斧神工的奇幻想象显得平淡无奇；《暗黑破坏神》和《五星物语》也再配不上“波澜壮阔”这样的修饰。并不是说这些作品不好，仅仅是因为《火鸟》实在是太优秀了，用两个字形容就是“广博”。就像手冢自己概括的：“一定要说这部作品的主题那就是：‘在某个时间的某个地方，有某个生命在发出声音……’”是啊，武士和强盗，机械人和外星生命……它们共同演绎的是生命的主题，在时空的大河里一个生命可以渺小的连沙子都不如，但并不代表它不存在。美好的梦想可以眨眼间被打得粉碎，但整个宇宙的生命大合唱却生生不息，永无休止，就好象火中的凤凰……','2020-10-30','&nbsp;&nbsp;“火鸟是传说中的不死鸟，它可以穿越时空，不死不灭，阿拉伯人叫它费利克斯，中国人则称它们为凤凰，火鸟不会死亡，它们会在火中重生……”在漫画中手冢以火鸟做为线索，探讨生命的秘密讲述生命的故事。发生在不同时空里的十二个故事，虽然主角、时代、背景各不相同，但却有着共同的主题和内在的联系。读者随着火鸟一起纵横驰骋在人类的历史和未来里，体验手冢对人类文明、生命的意义以及宇宙本源的思考。富坚义博擅长峰回路转的悬念，但与之相比仅仅是玩弄结构游戏的小聪明；高桥留美子擅长刻画生活，但一比之下也变成了毛皮。在这部作品面前《凯普》那号称鬼斧神工的奇幻想象显得平淡无奇；《暗黑破坏神》和《五星物语》也再配不上“波澜壮阔”这样的修饰。并不是说这些作品不好，仅仅是因为《火鸟》实在是太优秀了，用两个字形容就是“广博”。就像手冢自己概括的：“一定要说这部作品的主题那就是：‘在某个时间的某个地方，有某个生命在发出声音……’”是啊，武士和强盗，机械人和外星生命……它们共同演绎的是生命的主题，在时空的大河里一个生命可以渺小的连沙子都不如，但并不代表它不存在。美好的梦想可以眨眼间被打得粉碎，但整个宇宙的生命大合唱却生生不息，永无休止，就好象火中的凤凰……','作者：手冢治虫','https://gitee.com/l1031652416wo/img-bed/raw/master/%E7%81%AB%E4%B9%8B%E9%B8%9F2.jpg','2',NULL),('《三体》','https://baike.baidu.com/item/%E4%B8%89%E4%BD%93/5739303',11,'庄颜：“我觉得它像。晚霞的眼睛” 罗辑：“你怎么不说是朝霞的眼睛”庄颜：“我更喜欢晚霞” <br>罗辑：“为什么” <br>庄颜：“晚霞消失后可以看到星星，朝霞消失以后，就只剩下····” 罗辑：“只剩下光天化日下的现实了”庄颜：“是，是啊。”','2020-10-30','庄颜：“我觉得它像。晚霞的眼睛” <br>罗辑：“你怎么不说是朝霞的眼睛” <br>庄颜：“我更喜欢晚霞” <br>罗辑：“为什么” <br>庄颜：“晚霞消失后可以看到星星，朝霞消失以后，就只剩下····” <br>罗辑：“只剩下光天化日下的现实了” <br>庄颜：“是，是啊。”','作者：刘慈欣','https://gitee.com/l1031652416wo/img-bed/raw/master/%E4%B8%89%E4%BD%93.jpg','1',NULL),('《李白》','https://baike.baidu.com/item/%E6%9D%8E%E7%99%BD/1043?fr=aladdin',12,'作者：李白,君不见，黄河之水天上来，奔流到海不复回。君不见，高堂明镜悲白发，朝如青丝暮成雪。<br>人生得意须尽欢，莫使金樽空对月。天生我材必有用，千金散尽还复来。烹羊宰牛且为乐，会须一饮三百杯。<br>岑夫子，丹丘生，将进酒，杯莫停。与君歌一曲，请君为我倾耳听。<br>钟鼓馔玉不足贵，但愿长醉不愿醒。<br>古来圣贤皆寂寞，惟有饮者留其名。<br>陈王昔时宴平乐，斗酒十千恣欢谑。<br>主人何为言少钱，径须沽取对君酌。五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。','2020-10-30','君不见，黄河之水天上来，奔流到海不复回。<br>君不见，高堂明镜悲白发，朝如青丝暮成雪。<br>人生得意须尽欢，莫使金樽空对月。<br>天生我材必有用，千金散尽还复来。<br>烹羊宰牛且为乐，会须一饮三百杯。<br>岑夫子，丹丘生，将进酒，杯莫停。<br>与君歌一曲，请君为我倾耳听。<br>钟鼓馔玉不足贵，但愿长醉不愿醒。<br>古来圣贤皆寂寞，惟有饮者留其名。<br>陈王昔时宴平乐，斗酒十千恣欢谑。<br>主人何为言少钱，径须沽取对君酌。<br>五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。','诗人：李白','https://gitee.com/l1031652416wo/img-bed/raw/master/%E6%9D%8E%E7%99%BD.jpg','2',NULL),(NULL,NULL,13,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `review_title` varchar(80) DEFAULT NULL,
  `review_img_uri` varchar(100) DEFAULT NULL,
  `review_content` varchar(200) DEFAULT NULL,
  `review_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `review` */

insert  into `review`(`review_title`,`review_img_uri`,`review_content`,`review_id`) values ('紫罗兰永恒花园外传：永远与自动手记人偶 ヴァイオレット・エヴァーガーデン 外伝 - 永遠と自動手記人形 - (2019)','https://gitee.com/l1031652416wo/img-bed/raw/master/p2580810596.webp','你可曾窥视过我的眼瞳。 若未有过，便请来窥视一下如何。 我的眼瞳虽被夜色遮蔽，夜空之中却闪耀著繁星。 还望前来默然窥视。我的眼瞳中浮现之物、映照之物，倘若你认为其美丽。那便是你爱著我的证据。',4),('天气之子 天気の子 (2019)','https://gitee.com/l1031652416wo/img-bed/raw/master/p2571789497.webp','那年夏天，在那个天空之上的我们，把这个世界的样貌，彻底的改变了',6),('哲思与海：爱、死亡与海洋的“流浪”之旅','https://gitee.com/l1031652416wo/img-bed/raw/master/sd.png','无论前途后路，不必去看  任由自己沉溺在摇篮中  如同摇曳在海上的扁舟  --荷尔德林',7),('鬼灭之刃 鬼滅の刃 (2019)','https://gitee.com/l1031652416wo/img-bed/raw/master/p2552947141.webp','再次燃烧吧！燃起斗志！心之火焰永不消散！',8);

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `password` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`password`) values ('www'),('e34a8899ef6468b74f8a1048419ccc8b');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT 'N',
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`telephone`,`email`,`status`,`code`) values (1,'Shl','123123','18319168823','2300537026@qq.com','Y','ff230a9e8e7342e8a8a584d1bb1eb4c6'),(4,'师爷','qq123456','18813443490','627527244@qq.com','Y','c65403f773514fb5abc73f49c21aacd9'),(37,'Holly','awGCsR7rbddUJMi','18122420631','928453132@qq.com','Y','c9c82279f2974c4ba5f15dfee9f7125a'),(39,'Lnatic','02d12580ccd95ee2a637d6818d8b6a35','19928199459','948634641@qq.com','Y','1880cae0bb7a41c089ca0976a98601fc'),(40,'hollyo','25f9e794323b453885f5181f1b624d0b','18122420631','928453132@qq.com','Y','d5da1ea02e0048c0b890d72032bf4d8c'),(41,'hollyoqwe','efe6398127928f1b2e9ef3207fb82663','18319168823','928453132@qq.com','Y','b6f05b349f0947b19c9ea052ba090258');

/*Table structure for table `user_history` */

DROP TABLE IF EXISTS `user_history`;

CREATE TABLE `user_history` (
  `history_article` varchar(80) NOT NULL,
  `uid` int(10) NOT NULL,
  `history_uri` varchar(80) NOT NULL,
  `history_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`uid`),
  KEY `history_id` (`history_id`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_history` */

insert  into `user_history`(`history_article`,`uid`,`history_uri`,`history_id`) values ('baidu',1,'www.baidu.com',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
