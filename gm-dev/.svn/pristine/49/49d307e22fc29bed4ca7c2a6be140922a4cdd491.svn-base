-- admin 初始密码为 123
insert into T_SYS_USER (ID, ACCOUNT, PASSWORD, STATUS, SALT) 
values ('a9fa43ea002a441d948d7e495d2faf43', 'admin', '93e06f583c7133b025caaae85d69ffab', '1', 'e1158bb5f76840f84859d58104246334');


-- 初始化操作权限
insert into T_SYS_PERMISSION (ID, NAME, PERMISSION, DESCRIPTION, ENABLED)
values (1, '查看', 'view', '查看权限', '1');

insert into T_SYS_PERMISSION (ID, NAME, PERMISSION, DESCRIPTION, ENABLED)
values (2, '创建', 'create', '创建权限', '1');

insert into T_SYS_PERMISSION (ID, NAME, PERMISSION, DESCRIPTION, ENABLED)
values (3, '编辑', 'edit', '编辑权限', '1');

insert into T_SYS_PERMISSION (ID, NAME, PERMISSION, DESCRIPTION, ENABLED)
values (4, '删除', 'delete', '删除权限', '1');

insert into T_SYS_PERMISSION (ID, NAME, PERMISSION, DESCRIPTION, ENABLED)
values (5, '审核', 'audit', '审核权限', '1');


-- 初始化权限菜单
insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (1, '权限管理', '权限管理', null, 0, '0/', 'icon-edit', '1', 'auth', 1);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (2, '用户列表', '用户列表', 'auth/user/sysUser/list', 1, '0/1/', 'icon-user', '1', 'auth:user', 1);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (3, '组列表', '组列表', 'auth/group/sysGroup/list', 1, '0/1/', null, '1', 'auth:group', 2);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (4, '角色列表', '角色列表', 'auth/role/sysRole/list', 1, '0/1/', null, '1', 'auth:role', 3);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (5, '组成员列表', '组成员列表', 'auth/group/sysGroup/groupMemberList', 1, '0/1/', null, '1', 'auth:group:user', 4);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (6, '组角色列表', '组角色列表', 'auth/group/sysGroup/groupRoleList', 1, '0/1/', null, '1', 'auth:group:role', 5);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (7, '资源列表', '资源列表', 'auth/resource/sysResource/list', 1, '0/1/', null, '1', 'auth:resource', 6);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (8, '权限列表', '权限列表', 'auth/permission/sysPermission/list', 1, '0/1/', null, '1', 'auth:permission', 7);

insert into T_SYS_RESOURCE (ID, NAME, MENU_NAME, URL, PARENT_ID, PARENT_IDS, ICON, SHOW_AS_MENU, IDENTIFER, WEIGHT)
values (9, '角色权限列表', '角色权限列表', 'auth/role/sysRole/roleAuthorizationList', 1, '0/1/', null, '1', 'auth:role:access', 8);