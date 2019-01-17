create database if not exists jee_hw;
use jee_hw;
create table if not exists user(
  id int primary key auto_increment,
  username varchar(255) not null,
  password varchar(255) not null,
  account double(10,2) not null default 0
);

insert into user(username, password, account) values('ogslp','123456',500.00);

create table if not exists goods(
  id int primary key auto_increment,
  name varchar(255) not null ,
  kind varchar(255) not null default 'default',
  price double(8,2) not null default 5,
  num int not null default 0
);

insert into goods(name, kind, price, num) values('小米','手机',2500,220);
insert into goods(name, kind, price, num) values('iphoneX','手机',7500,200);
insert into goods(name, kind, price, num) values('华为','手机',4500,100);
insert into goods(name, kind, price, num) values('拯救者','电脑',5500,50);
insert into goods(name, kind, price, num) values('外星人','电脑',10500,20);
insert into goods(name, kind, price, num) values('Sony','耳机',600,150);
insert into goods(name, kind, price, num) values('格力','冰箱',3000,75);
insert into goods(name, kind, price, num) values('美的','空调',2500,200);

create table if not exists deal(
  id int primary key auto_increment,
  uid int not null,
  gid int not null,
  num int not null default 0,
  date timestamp not null ,
  foreign key(uid) references user(id),
  foreign key (gid) references goods(id)
);