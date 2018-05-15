-- 注意自行修改tablespace name
drop table T_SYS_USER_GROUP;
drop table T_SYS_GROUP_ROLE;
drop table T_SYS_ROLE_RESOURCE;
drop table T_SYS_RESOURCE_PERMISSION;
drop table T_SYS_USER;
drop table T_SYS_GROUP;
drop table T_SYS_ROLE;
drop table T_SYS_RESOURCE;
drop table T_SYS_PERMISSION;

drop sequence SEQ_SYS_GROUP_ID;
drop sequence SEQ_SYS_GROUP_ROLE_ID;
drop sequence SEQ_SYS_PERMISSION_ID;
drop sequence SEQ_SYS_RESOURCE_ID;
drop sequence SEQ_SYS_RESOURCE_PERMISSION_ID;
drop sequence SEQ_SYS_ROLE_ID;
drop sequence SEQ_SYS_ROLE_RESOURCE_ID;
drop sequence SEQ_SYS_USER_GROUP_ID;


-- Create 用户 table
create table T_SYS_USER
(
  id       CHAR(32 CHAR) not null,
  account  VARCHAR2(100 CHAR),
  password VARCHAR2(100 CHAR),
  status   CHAR(1 CHAR) default '1',
  salt     VARCHAR2(32 CHAR)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_SYS_USER.account
  is '用户名';
comment on column T_SYS_USER.password
  is '密码';
comment on column T_SYS_USER.status
  is '状态，1-启用，0-停用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_USER
  add constraint PK_T_SYS_USER primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create 组 table
create table T_SYS_GROUP
(
  id         NUMBER(18) not null,
  name       VARCHAR2(100 CHAR),
  parent_id  NUMBER(18),
  parent_ids VARCHAR2(190 CHAR),
  enabled    CHAR(1 CHAR) default '1'
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_GROUP
  is '用户组，组会有父子关系';
-- Add comments to the columns 
comment on column T_SYS_GROUP.id
  is '主键';
comment on column T_SYS_GROUP.name
  is '组名称';
comment on column T_SYS_GROUP.parent_id
  is '上级组';
comment on column T_SYS_GROUP.enabled
  is '是否启用: 1 - 可用; 0 - 不可用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_GROUP
  add constraint PK_T_SYS_GROUP primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create 角色 table
create table T_SYS_ROLE
(
  id          NUMBER(18) not null,
  name        VARCHAR2(100 CHAR),
  role        VARCHAR2(100 CHAR),
  description VARCHAR2(255 CHAR),
  enabled     CHAR(1 CHAR) default '1'
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_ROLE
  is '角色表';
-- Add comments to the columns 
comment on column T_SYS_ROLE.id
  is '主键';
comment on column T_SYS_ROLE.name
  is '角色名称';
comment on column T_SYS_ROLE.role
  is '角色，实际用于后台匹配角色的字段';
comment on column T_SYS_ROLE.description
  is '角色说明';
comment on column T_SYS_ROLE.enabled
  is '是否可用: 1 - 可用; 0 - 不可用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_ROLE
  add constraint PK_T_SYS_ROLE primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create 资源(菜单) table
create table T_SYS_RESOURCE
(
  id           NUMBER(18) not null,
  name         VARCHAR2(100 CHAR),
  menu_name    VARCHAR2(200 CHAR),
  url          VARCHAR2(255 CHAR),
  parent_id    NUMBER(18),
  parent_ids   VARCHAR2(190 CHAR),
  icon         VARCHAR2(200 CHAR),
  show_as_menu CHAR(1 CHAR) default '1',
  identifer    VARCHAR2(255),
  weight       NUMBER(9)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_RESOURCE
  is '资源表，也是菜单表';
-- Add comments to the columns 
comment on column T_SYS_RESOURCE.id
  is '主键';
comment on column T_SYS_RESOURCE.name
  is '资源名称';
comment on column T_SYS_RESOURCE.menu_name
  is '菜单显示名称';
comment on column T_SYS_RESOURCE.url
  is '资源URL';
comment on column T_SYS_RESOURCE.parent_id
  is '上级资源ID';
comment on column T_SYS_RESOURCE.icon
  is '菜单图标';
comment on column T_SYS_RESOURCE.show_as_menu
  is '是否在菜单中显示: 1 - 显示; 0 - 不显示';
comment on column T_SYS_RESOURCE.identifer
  is '权限标识符';
comment on column T_SYS_RESOURCE.weight
  is '菜单显示顺序';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_RESOURCE
  add constraint PK_T_SYS_RESOURCE primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create 权限 table
create table T_SYS_PERMISSION
(
  id          NUMBER(18) not null,
  name        VARCHAR2(100 CHAR),
  permission  VARCHAR2(100 CHAR),
  description VARCHAR2(255 CHAR),
  enabled     CHAR(1 CHAR) default '1'
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_PERMISSION
  is '权限表, 定义全局使用的基本操作权限';
-- Add comments to the columns 
comment on column T_SYS_PERMISSION.id
  is '主键';
comment on column T_SYS_PERMISSION.name
  is '权限名称';
comment on column T_SYS_PERMISSION.permission
  is '权限';
comment on column T_SYS_PERMISSION.description
  is '权限描述';
comment on column T_SYS_PERMISSION.enabled
  is '是否可用: 1 - 可用; 0 - 不可用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_PERMISSION
  add constraint PK_T_SYS_PERMISSION primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create 用户-组关系表 table
create table T_SYS_USER_GROUP
(
  id       NUMBER not null,
  user_id  CHAR(32 CHAR),
  group_id NUMBER(18)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_USER_GROUP
  is '用户和组多对多关系表';
-- Add comments to the columns 
comment on column T_SYS_USER_GROUP.id
  is '主键';
comment on column T_SYS_USER_GROUP.user_id
  is '用户外键';
comment on column T_SYS_USER_GROUP.group_id
  is '组外键';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_USER_GROUP
  add constraint PK_T_SYS_USER_GROUP primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_SYS_USER_GROUP
  add constraint FK_UG_GROUP foreign key (GROUP_ID)
  references T_SYS_GROUP (ID);
alter table T_SYS_USER_GROUP
  add constraint FK_UG_USER foreign key (USER_ID)
  references T_SYS_USER (ID);


-- Create 组-角色关系表 table
create table T_SYS_GROUP_ROLE
(
  id       NUMBER not null,
  group_id NUMBER(18),
  role_id  NUMBER(18),
  extended CHAR(1 CHAR)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_GROUP_ROLE
  is '组和角色多对多关系表';
-- Add comments to the columns 
comment on column T_SYS_GROUP_ROLE.id
  is '主键';
comment on column T_SYS_GROUP_ROLE.group_id
  is '组外键';
comment on column T_SYS_GROUP_ROLE.role_id
  is '角色外键';
comment on column T_SYS_GROUP_ROLE.extended
  is '角色是否可被该组的子组继承: 1 - 可以; 2 - 不可以';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_GROUP_ROLE
  add constraint PK_T_SYS_GROUP_ROLE primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_SYS_GROUP_ROLE
  add constraint FK_GR_GROUP foreign key (GROUP_ID)
  references T_SYS_GROUP (ID);
alter table T_SYS_GROUP_ROLE
  add constraint FK_GR_ROLE foreign key (ROLE_ID)
  references T_SYS_ROLE (ID);


-- Create 角色-资源关系表 table
-- Create table
create table T_SYS_ROLE_RESOURCE
(
  id          NUMBER not null,
  role_id     NUMBER(18),
  resource_id NUMBER(18)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_ROLE_RESOURCE
  is '角色和资源多对多关系表';
-- Add comments to the columns 
comment on column T_SYS_ROLE_RESOURCE.id
  is '主键';
comment on column T_SYS_ROLE_RESOURCE.role_id
  is '角色外键';
comment on column T_SYS_ROLE_RESOURCE.resource_id
  is '资源外键';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_ROLE_RESOURCE
  add constraint PK_T_SYS_ROLE_RESOURCE primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_SYS_ROLE_RESOURCE
  add constraint FK_RR_RESOURCE foreign key (RESOURCE_ID)
  references T_SYS_RESOURCE (ID);
alter table T_SYS_ROLE_RESOURCE
  add constraint FK_RR_ROLE foreign key (ROLE_ID)
  references T_SYS_ROLE (ID);


-- Create 角色-资源-权限关系表 table
-- Create table
create table T_SYS_ROLE_RESOURCE_PERMISSION
(
  id            NUMBER not null,
  role_id       NUMBER(18),
  resource_id   NUMBER(18),
  permission_id NUMBER(18)
)
tablespace IDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table T_SYS_ROLE_RESOURCE_PERMISSION
  is '角色对应的资源权限表';
-- Add comments to the columns 
comment on column T_SYS_ROLE_RESOURCE_PERMISSION.id
  is '主键';
comment on column T_SYS_ROLE_RESOURCE_PERMISSION.role_id
  is '角色外键';
comment on column T_SYS_ROLE_RESOURCE_PERMISSION.resource_id
  is '资源外键';
comment on column T_SYS_ROLE_RESOURCE_PERMISSION.permission_id
  is '权限操作外键';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_ROLE_RESOURCE_PERMISSION
  add constraint PK_T_SYS_ROLE_RES_PERM primary key (ID)
  using index 
  tablespace IDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_SYS_ROLE_RESOURCE_PERMISSION
  add constraint FK_RRP_PERMISSION foreign key (PERMISSION_ID)
  references T_SYS_PERMISSION (ID);
alter table T_SYS_ROLE_RESOURCE_PERMISSION
  add constraint FK_RRP_RESOURCE foreign key (RESOURCE_ID)
  references T_SYS_RESOURCE (ID);
alter table T_SYS_ROLE_RESOURCE_PERMISSION
  add constraint FK_RRP_ROLE foreign key (ROLE_ID)
  references T_SYS_ROLE (ID);

  
  
-- Create 组表 sequence 
create sequence SEQ_SYS_GROUP_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

-- Create 组-角色关系表 sequence 
create sequence SEQ_SYS_GROUP_ROLE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 20;

-- Create 权限表 sequence 
create sequence SEQ_SYS_PERMISSION_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

-- Create 资源(菜单)表 sequence 
create sequence SEQ_SYS_RESOURCE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

-- Create 角色-资源-权限表 sequence 
create sequence SEQ_SYS_ROLE_RES_PERM_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 20;

-- Create 角色表 sequence 
create sequence SEQ_SYS_ROLE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;

-- Create 角色-资源关系表 sequence 
create sequence SEQ_SYS_ROLE_RESOURCE_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 20;

-- Create 用户-组关系表 sequence 
create sequence SEQ_SYS_USER_GROUP_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 20;
