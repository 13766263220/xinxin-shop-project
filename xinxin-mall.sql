drop database malldb;
create database malldb;

use mallDB;

drop table role_node;
drop table role_admin;
drop table admin_info;
drop table role_info;
drop table node_info;

/*管理员信息表(用户表)*/
create table admin_info
(
    id int auto_increment primary key,#管理员id
    admin_username varchar(20) unique,#账号
    admin_password varchar(20)#密码
);
select * from admin_info;

insert into admin_info(admin_username, admin_password) values ('admin','111');
insert into admin_info(admin_username, admin_password) values ('wzl','wzl');
select * from admin_info;

/*角色信息表*/
create table role_info
(
    id int auto_increment primary key comment '角色id',
    role_name varchar(50) comment '角色名称',
    role_description varchar(100) comment '角色描述'
);
insert into role_info(role_name, role_description) values ('管理员','拥有大部分的权力');
insert into role_info(role_name, role_description) values ('超级管理员','拥有至高无上的权力');

/*角色用户表(连接管理员表和角色表)*/
create table role_admin
(
    id int auto_increment primary key,
    admin_id int comment '管理员id',
    role_id int comment '角色id',
    foreign key(admin_id) references admin_info(id),
    foreign key(role_id) references role_info(id)
);
insert into role_admin(admin_id, role_id) values (1,1);
insert into role_admin(admin_id, role_id) values (2,1);
insert into role_admin(admin_id, role_id) values (2,2);

/*节点权限表*/
create table node_info
(
    id int auto_increment primary key,
    node_name varchar(50) comment '节点名称',
    node_route varchar(50) comment '节点路由',
    node_url varchar(500) comment '后端可用地址 用,号分隔 （可删除）',
    pid int comment '父节点id'
);
select * from node_info;

insert into node_info(node_name, node_route,node_url,pid) values ('系统首页','home','',0);
insert into node_info(node_name, node_route,node_url,pid) values ('首页','index','',1);

insert into node_info(node_name, node_route,node_url,pid) values ('商品','product','',0);
insert into node_info(node_name, node_route,node_url,pid) values ('商品列表','productList','',3);
insert into node_info(node_name, node_route,node_url,pid) values ('添加商品','productAdd','',3);
insert into node_info(node_name, node_route,node_url,pid) values ('商品分类','category','',3);
insert into node_info(node_name, node_route,node_url,pid) values ('品牌管理','brand','',3);

insert into node_info(node_name, node_route,node_url,pid) values ('订单','orderForm','',0);
insert into node_info(node_name, node_route,node_url,pid) values ('订单列表','orderFormList','',8);
insert into node_info(node_name, node_route,node_url,pid) values ('订单设置','orderFormSetting','',8);
insert into node_info(node_name, node_route,node_url,pid) values ('退货申请处理','salesReturnRequest','',8);

insert into node_info(node_name, node_route,node_url,pid) values ('用户','user','',0);
insert into node_info(node_name, node_route,node_url,pid) values ('用户信息','userInfoList','',12);

insert into node_info(node_name, node_route,node_url,pid) values ('管理员','admin','',0);
insert into node_info(node_name, node_route,node_url,pid) values ('管理员信息','adminInfoList','',14);
insert into node_info(node_name, node_route,node_url,pid) values ('角色授权','userAuthorization','',14);




/*角色权限表*/
create table role_node
(
    id int auto_increment primary key,
    role_id int,
    node_id int,
    foreign key(role_id) references role_info(id),
    foreign key(node_id) references node_info(id)
);
select * from role_node;
insert into role_node(role_id, node_id) values(1,1);
insert into role_node(role_id, node_id) values(1,2);
insert into role_node(role_id, node_id) values(2,1);
insert into role_node(role_id, node_id) values(2,2);
insert into role_node(role_id, node_id) values(2,3);
insert into role_node(role_id, node_id) values(2,4);
insert into role_node(role_id, node_id) values(2,5);
insert into role_node(role_id, node_id) values(2,6);
insert into role_node(role_id, node_id) values(2,7);
insert into role_node(role_id, node_id) values(2,8);
insert into role_node(role_id, node_id) values(2,9);
insert into role_node(role_id, node_id) values(2,10);
insert into role_node(role_id, node_id) values(2,11);
insert into role_node(role_id, node_id) values(2,12);
insert into role_node(role_id, node_id) values(2,13);
insert into role_node(role_id, node_id) values(2,14);
insert into role_node(role_id, node_id) values(2,15);
insert into role_node(role_id, node_id) values(2,16);




select distinct
    ni.id,ni.node_name,ni.node_route,ni.node_url,ni.pid
from admin_info ai
    left join role_admin ra on ai.id = ra.admin_id
    left join role_info ri on ra.role_id = ri.id
    left join role_node rn on ri.id = rn.role_id
    left join node_info ni on ni.id = rn.node_id
where ai.id = 2

;
#商品分类表
drop table pms_product_category;
create table pms_product_category
(
    id                   bigint not null auto_increment,
    category_rank        int(1) comment '级别,0表示1级,1表示2级',
    parent_id            bigint comment '上级分类的编号：0表示一级分类',
    name                 varchar(64) comment '名称',
    product_count        int comment '商品数量',
    product_unit         varchar(64) comment '商品单位',
    show_status          int(1) comment '显示状态：0->不显示；1->显示',
    icon                 varchar(255) comment '图标',
    description          text comment '分类描述',
    primary key (id)
);
select * from pms_product_category;


insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(0,0,'服装',null,'件',1,'http://localhost:8080/file/download?filename=小米logo.png',null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(0,0,'手机数码',null,'个',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(0,0,'家用电器',null,'个',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(0,0,'家具家装',null,'套',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(0,0,'汽车用品',null,'个',1,null,null);

insert pms_product_category(id,category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(12,1,2,'智能手机',null,'个',1,null,null);

insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'外套',null,'件',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'T恤',null,'件',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'休闲裤',null,'条',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'牛仔裤',null,'条',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'衬衫',null,'件',1,null,null);
insert pms_product_category(category_rank,parent_id, name, product_count, product_unit, show_status, icon, description)
values(1,1,'男鞋',null,'双',1,null,null);

#商品品牌表
#drop table pms_brand;
create table pms_brand
(
    id                   bigint not null auto_increment,
    name                 varchar(64) comment '名称',
    show_status          int(1) comment '是否显示',
    product_count        int comment '产品数量',
    product_comment_count int comment '产品评论数量',
    logo                 varchar(255) comment '品牌logo',
    big_pic              varchar(255) comment '专区大图',
    brand_story          text comment '品牌故事',
    primary key (id)
);

select * from pms_brand;
delete from pms_brand where id = id;
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('三星',1,100,0,'','','三星手机品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('小米',0,100,1,'http://localhost:8080/file/download?filename=小米logo.png','http://localhost:8080/file/download?filename=小米bigPic.png','小米的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('华为',0,100,1,'http://localhost:8080/file/download?filename=华为logo.png','','华为的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('七匹狼',0,100,0,'','','七匹狼的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('海澜之家',1,100,0,'','','海蓝之家的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('格力',1,100,1,'','','格力的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('OPPO',1,100,1,'','','OPPO的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('NIKE',1,100,0,'','','NIKE的品牌故事');
insert into pms_brand(name, show_status, product_count, product_comment_count, logo, big_pic, brand_story)
values ('安踏',1,100,1,'','','安踏的品牌故事');




#商品信息表
drop table pms_product;
create table pms_product
(
    id                   bigint not null auto_increment,
    name                 varchar(64) not null comment '商品名称',
    price                decimal(10,2) comment '价格',
    pic                  varchar(255) comment '图片',
    brand_id             bigint comment '商品品牌id',
    product_category_id  bigint comment '商品分类id',
    sale                 int comment '销量',
    stock                int comment '库存',
    low_stock            int comment '库存预警值',
    unit                 varchar(16) comment '商品单位',
    publish_status       int(1) comment '上架状态：0->下架；1->上架',
    new_status           int(1) comment '新品状态:0->不是新品；1->新品',
    recommand_status     int(1) comment '推荐状态；0->不推荐；1->推荐',
    description          text comment '商品描述',
    primary key (id)
);
select * from pms_product;
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('华为 HUAWEI P20',3788,'http://localhost:8080/file/download?filename=华为pic.jpg',3,12,null,null,null,'部',1,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('华为 HUAWEI P30',3788,'http://localhost:8080/file/download?filename=华为pic.jpg',3,12,null,null,null,'部',1,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('小米8 全面屏游戏智能手机',3788,'http://localhost:8080/file/download?filename=小米pic.jpg',2,12,null,null,null,'部',0,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('小米8 全面屏游戏智能手机',3788,'http://localhost:8080/file/download?filename=小米pic.jpg',2,12,null,null,null,'部',0,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('小米8 全面屏游戏智能手机',3788,'http://localhost:8080/file/download?filename=小米pic.jpg',2,12,null,null,null,'部',1,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('华为 HUAWEI P30',3788,'http://localhost:8080/file/download?filename=华为pic.jpg',3,12,null,null,null,'部',0,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('小米8 全面屏游戏智能手机',3788,'http://localhost:8080/file/download?filename=小米pic.jpg',2,12,null,null,null,'部',1,0,1,null);
insert into pms_product
(name, price, pic, brand_id, product_category_id, sale, stock, low_stock, unit, publish_status, new_status, recommand_status, description)
values ('华为 HUAWEI P30',3788,'http://localhost:8080/file/download?filename=华为pic.jpg',3,12,null,null,null,'部',0,0,1,null);



#商品SKU表(表示商品的最小单位，如)
/*
SKU(Stock Keeping Unit)是指库存量单位，SPU(Standard Product Unit)是指标准产品单位。
举个例子：iphone xs是一个SPU，而iphone xs 公开版 64G 银色是一个SKU。*/
drop table pms_sku_stock;
create table pms_sku_stock
(
    id                   bigint not null auto_increment,
    product_id           bigint comment '商品id',
    price                decimal(10,2) comment '价格',
    stock                int default 0 comment '库存',
    low_stock            int comment '预警库存',
    pic                  varchar(255) comment '展示图片',
    sale                 int comment '销量',
    product_specs        varchar(800) comment '商品规格',
    primary key (id)
);
select * from pms_sku_stock;
# insert into pms_sku_stock(product_id, price,stock, low_stock, pic, sale, product_specs)
# values (1,3000,100,10,null,null,'{"内存":"2G","颜色":"红色"}');
# insert into pms_sku_stock(product_id, price,stock, low_stock, pic, sale, product_specs)
# values (1,3000,100,10,null,null,'{"内存":"4G","颜色":"蓝色"}');
# insert into pms_sku_stock(product_id, price,stock, low_stock, pic, sale, product_specs)
# values (1,3000,100,10,null,null,'{"内存":"8G","颜色":"灰色"}');

#属性表(如：颜色,CUP,尺寸,内存等)
#drop table pms_attr;
create table pms_attr
(
    id bigint not null auto_increment,
    attr_name varchar(64) comment '属性名称',
    category_id bigint comment '商品分类id',
    primary key (id)
);
select * from pms_attr;
insert into pms_attr(attr_name, category_id) values('颜色',13);
insert into pms_attr(attr_name, category_id) values('尺寸',13);

select * from pms_attr where id = 4;


#属性选项表(如:蓝色,红色,8G,16G等)
#drop table pms_attr_option;
create table pms_attr_option
(
    id bigint not null auto_increment,
    option_name varchar(64) comment '选项名称',
    attr_id bigint comment '属性id',
    primary key (id)
);
select * from pms_attr_option;
insert into pms_attr_option(option_name, attr_id) values('红色',1);
insert into pms_attr_option(option_name, attr_id) values('蓝色',1);
insert into pms_attr_option(option_name, attr_id) values('黄色',1);
insert into pms_attr_option(option_name, attr_id) values('绿色',1);
insert into pms_attr_option(option_name, attr_id) values('M',2);
insert into pms_attr_option(option_name, attr_id) values('L',2);
insert into pms_attr_option(option_name, attr_id) values('XL',2);


#订单表
drop table oms_order;
create table oms_order
(
    id                   bigint not null auto_increment comment '订单id',
    order_sn             varchar(64) comment '订单编号',
    create_time          datetime comment '提交时间',
    member_username      varchar(64) comment '用户帐号',
    total_amount         decimal(10,2) comment '订单总金额',
    pay_type             int(1) comment '支付方式：0->未支付；1->支付宝；2->微信',
    status               int(1) comment '订单状态：//订单状态：0->待付款；1->待发货；2->已发货；3->确认收货；4->已关闭',
    receiver_name        varchar(100) not null comment '收货人姓名',
    receiver_phone       varchar(32) not null comment '收货人电话',
    receiver_detail_address varchar(200) comment '详细地址',
    note                 varchar(500) comment '订单备注',
    confirm_status       int(1) comment '确认收货状态：0->未确认；1->已确认',
    payment_time         datetime comment '支付时间',
    delivery_time        datetime comment '发货时间',
    receive_time         datetime comment '确认收货时间',
    comment_time         datetime comment '评价时间',
    primary key (id)
);
select * from oms_order;
delete from oms_order where id = 2;
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,0,0,'吴正廉','123456','北京天安门','很不错',0,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,1,1,'吴正廉','123456','北京天安门','很不错',1,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,2,2,'吴正廉','123456','北京天安门','很不错',1,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,2,3,'吴正廉','123456','北京天安门','很不错',0,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,1,4,'吴正廉','123456','北京天安门','很不错',1,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,1,5,'吴正廉','123456','北京天安门','很不错',0,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');
insert into oms_order(order_sn, create_time, member_username, total_amount, pay_type, status, receiver_name, receiver_phone, receiver_detail_address, note, confirm_status, payment_time, delivery_time, receive_time, comment_time)
values ('201809150101000001','2018-09-15 12:24:27','test',18732,0,1,'吴正廉','123456','北京天安门','很不错',0,'2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27','2018-09-15 12:24:27');




#前台模块
#用户信息表
drop table user_info;
create table user_info
(
    id bigint not null auto_increment,
    user_phone varchar(11) unique comment '用户电话',
    pass_word varchar(20) comment '用户密码',
    user_photo varchar(255) comment '用户头像',
    registration_time datetime comment '注册时间',
    name varchar(20) comment '用户名称',
    user_sex int comment '用户性别 0->女 1->男',
    user_address varchar(100) comment '用户地址',
    user_status int comment '用户状态 0->不可用 1->可以',
    primary key (id)
);
select * from user_info;
insert into user_info(user_phone, pass_word,user_photo,registration_time, name, user_sex, user_address,user_status)
values('13766263220','111',null,'2019-12-25 12:24:27','吴正廉',1,'江西省吉安市井冈山市厦坪镇',1);
insert into user_info(user_phone, pass_word, user_photo,registration_time, name, user_sex, user_address,user_status)
values('13766263221','111','http://localhost:8080/file/download?filename=小米pic.jpg','2019-12-25 12:24:27','吴大帅',0,'江西省吉安市井冈山市厦坪镇',0);

#购物车项
drop table cart_item;
create table cart_item
(
  id bigint not null auto_increment,
  item_quantity int comment '数量',
  unit_price decimal(10,2) comment '单价',
  sku_id bigint comment 'SKU库存id',
  user_id bigint comment '用户id',
  order_id bigint comment '订单id,->0表示未添加到订单中',
  primary key (id)
);
select * from cart_item;
delete from cart_item where id = 7;
insert into cart_item(item_quantity, unit_price, sku_id, user_id ,order_id)
values (10,10,36,1,0);

