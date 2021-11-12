use mybatis_plus;
Drop table if exists user;
Create table user (
id BIGINT(20)  not null comment '主键ID', 
name varchar(30) null default null comment '姓名', 
age int(11) null default null comment '年龄',
email varchar(50) null default null comment '邮箱',
PRIMARY Key (id)
);
