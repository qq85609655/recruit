-- 注意自行修改tablespace name
drop table T_TEST_USER;
drop table T_TEST_BOOK;
drop sequence SEQ_TEST_BOOK_ID;



-- Create 测试用户 table
create table T_TEST_USER
(
  id         CHAR(32) default SYS_GUID() not null,
  name       VARCHAR2(50),
  address    VARCHAR2(100),
  birthday   DATE,
  age        NUMBER(6),
  salary     NUMBER(12,2),
  work_place VARCHAR2(100)
)
tablespace IDATA
  pctfree 1
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_TEST_USER
  add constraint PK_T_TEST_USER primary key (ID)
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

-- Create 测试书籍 table
create table T_TEST_BOOK
(
  id   NUMBER not null,
  name VARCHAR2(60)
)
tablespace IDATA
  pctfree 1
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
comment on column T_TEST_BOOK.id
  is 'ID';
comment on column T_TEST_BOOK.name
  is '名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_TEST_BOOK
  add constraint PK_T_TEST_BOOK primary key (ID)
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

  
  
-- Create 测试书籍表 sequence 
create sequence SEQ_TEST_BOOK_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 100
increment by 1
cache 20;
