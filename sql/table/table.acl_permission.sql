#
# Structure for table "acl_permission"
#
drop table if exists acl_permission;
create table acl_permission (
  id                char(19)                not null  default ''    comment '编号', 
  pid               char(19)                not null  default ''    comment '所属上级',
  name              varchar(20)             not null  default ''    comment '名称', 
  type              tinyint(3)              not null  default '0'   comment '类型(1菜单 2按钮)',
  permission_value  varchar(50)                       default null  comment '权限值',
  path              varchar(100)                      default null  comment '访问路径',
  component         varchar(100)                      default null  comment '组件路径',
  icon              varchar(50)                       default null  comment '图标',
  status            tinyint(4)                        default null  comment '状态(0禁止 1正常)',
  is_deleted        tinyint(1)    unsigned  not null  default '0'   comment '逻辑删除1 (true)已删除  0 (false)未删除',
  gmt_create        datetime                          default null  comment '创建时间',
  gmt_modified      datetime                          default null  comment '更新时间',
  
  PRIMARY KEY (id),
  KEY idx_pid (pid)
) 
engine=InnoDB default charset=utf8mb4 comment='权限';
