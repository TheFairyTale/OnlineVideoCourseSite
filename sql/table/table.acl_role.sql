create table acl_role (
  id            char(19)                not null  default ''     comment '角色id',
  role_name     varchar(20)             not null  default ''     comment '角色名称',
  role_code     varchar(20)                       default null   comment '角色编码',
  remark        varchar(255)                      default null   comment '备注',
  is_deleted    tinyint(1)    unsigned  not null  default '0'    comment '逻辑删除 1(true)已删除  0(false)未删除',
  gmt_create    datetime                not null                 comment '创建时间',
  gmt_modified  datetime                not null                 comment '更新时间',
  primary key (id)
  
)
engine=InnoDB default charset=utf8mb4 comment='权限';