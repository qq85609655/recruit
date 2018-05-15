-- 初始化Demo菜单信息
insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (10, '功能示例', '功能示例', null, 0, '0/', null, '1', 'demo', 2);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (11, '基础功能', '基础功能', 'testUserController/list', 10, '0/10/', null, '1', 'demo:testuser', 1);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (12, '仅仅是资源', '仅仅是资源', null, 10, '0/10/', null, '0', 'demo:jinjin', 2);


-- 导入TestUser表的信息
insert into T_TEST_USER (ID, NAME, ADDRESS, BIRTHDAY, AGE, SALARY, WORK_PLACE)
values ('16163CD16240599FE054D8D385F64AE4', '张三', '深圳市', to_date('15-05-2015 08:00:00', 'dd-mm-yyyy hh24:mi:ss'), 24, 8000.00, '深圳华星光电');

insert into T_TEST_USER (ID, NAME, ADDRESS, BIRTHDAY, AGE, SALARY, WORK_PLACE)
values ('16163CD16241599FE054D8D385F64AE4', '李四', '广州市', to_date('15-05-2015 23:00:00', 'dd-mm-yyyy hh24:mi:ss'), 21, 7500.00, '武汉华星光电');

insert into T_TEST_USER (ID, NAME, ADDRESS, BIRTHDAY, AGE, SALARY, WORK_PLACE)
values ('e1388c46a604407ca2bd3a73375fa50c', '王五', '深圳市', to_date('27-05-2015 13:32:09', 'dd-mm-yyyy hh24:mi:ss'), 28, 12000.00, '深圳华星光电');

insert into T_TEST_USER (ID, NAME, ADDRESS, BIRTHDAY, AGE, SALARY, WORK_PLACE)
values ('16163CD16243599FE054D8D385F64AE4', '赵六', '深圳市', to_date('15-05-2015', 'dd-mm-yyyy'), 28, 11000.00, '深圳华星光电');
