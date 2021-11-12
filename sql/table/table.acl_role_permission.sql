#
# Structure for table "acl_role_permission"
#

create table acl_role_permission (
  id              char(19)              not null    default '',
  role_id         char(19)              not null    default '',
  permission_id   char(19)              not null    default '',
  is_deleted      tinyint(1)  unsigned  not null    default '0' comment '逻辑删除 0 (false)未删除  1(true)已删除',
  gmt_create      datetime              not null                comment '创建时间',
  gmt_mdified     datetime              not null                comment '更新时间',
  primary key(id),
  key idx_role_id (role_id),
  key idx_permission_id (permission_id)
)
engine=InnoDB default charset=utf8mb4 comment='角色权限';