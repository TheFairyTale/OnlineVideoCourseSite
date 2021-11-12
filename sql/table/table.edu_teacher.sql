#
# Structure for table "edu_teacher"
#
drop table if exists edu_teacher;
create table edu_teacher (
  id            char(19)                not null                        comment '讲师id', 
  name          varchar(20)             not null                        comment '讲师姓名', 
  intro         varchar(500)            not null  default ''            comment '讲师简介',
  career        varchar(500)            not null  default ''            comment '讲师资历， 一句话说明讲师',
  level         int(10)       unsigned  not null                        comment '头衔 1高级讲师 2首席讲师',
  avatar        varchar(255)                      default null          comment '讲师头像',
  sort          int(10)       unsigned  not null  default '0'           comment '排序',
  is_deleted    tinyint(1)    unsigned  not null  default '0'           comment '逻辑删除 1(true) 已删除 0(false) 未删除',
  gmt_create    datetime                not null                        comment '创建时间',
  gmt_modified  datetime                not null                        comment '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_name (name)
) 
engine=InnoDB default charset=utf8mb4 comment='讲师';

#
# Data for table "edu_teacher"
# 