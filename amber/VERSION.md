# Amber项目版本更新记录

**目录 (Table of Contents)**

[TOC]

## v1.6.0

### 新增功能

- 添加修改密码的功能
- 添加对新的SSO的LDAP身份验证的支持，新的LDAP验证使用的Realm为“ldapRealm”，原有的直接到AD进行LDAP验证的改为“adLdapRealm”
- 添加对CAS身份验证的支持，同时支持多域名的CAS验证。使用时需要注意以下事项：
	- 开启casRealm，并设置casServerUrlPrefix和casService属性。如果需要多域名CAS验证，则按照注释设置casService和defaultCasService两个属性
	- 修改userFilter的配置，开启casLoginUrl和casServiceBasePath属性配置。如果需要多域名CAS验证，则按照注释将casServiceBasePath改为casServiceBasePaths，并将casRealm和casFilter改为MultiCustomCasRealm和MultiAmberCasFilter
	- 修改logoutFilter的配置，开启casRedirectUrl和casServiceBasePath的属性配置。如果需要多域名CAS验证，则按照注释将casServiceBasePath改为casServiceBasePaths
	- 设置filter目录下和resources目录下的properties文件中关于Spring-Shiro config的配置项

### 修正列表

- 修正当登录用户在本地不存在用户信息时，@CurrentUser注解获取的当前登录用户为空。改为获取到只设置了用户账号信息的SysUser对象

### 功能改善

- 密码保存和验证改为**不区分大小写**。增加修改密码时清空用户相关缓存的后台实现

## v1.5.10

### 修正列表

- 去掉修改密码页面的console.log()代码，此代码在IE8及以前版本的浏览器不起作用，并且会导致JS报错

## v1.5.9

### 功能改善

- 将basePath的获取从每个网页的头部的JSP代码移到了成功登录后执行方法放到session中，每个页面获取basePath就可以从Session中获取，不需要每个网页执行一遍头部拼接basePath的Java代码。basePath尾部是包含"/"的。请参考index.jsp中的样例

## v1.5.8

### 新增功能

- 修改了框架的版本号编码规则，使用GNU软件版本号编码规则。同步修改pom.xml的version属性

### 功能改善

- 为角色权限列表的资源列表树添加“>>”标识，帮助区分是否有对此资源配置权限。因为resource的勾选（表示是否菜单显示）和权限的配置没有关联。

## v1.05g

### 功能改善

- 为角色权限列表的资源列表树添加“>>”标识，帮助区分是否有对此资源配置权限。因为resource的勾选（表示是否菜单显示）和权限的配置没有关联。

## v1.05f

### 新增功能

- 新增Excel导出动态生成列单元格功能，通过在XML中配置导出类型为3，可以将Collection类型的属性转化为多个单元格。按顺序方法Excel的row中。
	- 目前此方式导出时，由于列标题无法通过模板支持动态导出，所以需要将标题行也手动做成数据行导出（不要将标题行放在模板中）；
	- 目前此方式导出时，由于标题行也作为数据行生成，所以如果显示index，会导致index显示错乱（标题行的index为1），此index显示问题可能在以后版本改进。目前需要index请自行将index作为属性自行设置然后导出。

## v1.05e

### 新增功能

- 新增Excel导出常量配置功能，通过在XML中配置某些列导出常量值。

### 修正列表

- 修正Excel导出功能中使用xlsx作为模板会导致excel文件内容损坏的BUG：
	- 原因：XSSFWorkbook使用那个shiftRows移动行，会将所经过的行内容清空。当移动跨多行时，中间清空的行会导致文件内容损坏的问题；
	- 解决方法：将xls导出和xlsx导出分开。xls支持表头表尾和单元格样式；xlsx仅支持表头，不支持表尾和单元格样式。

## v1.05d

### 修正列表

- 修正Excel导出功能的BUG：
	- 修改Excel模板和导出数据映射文件存放的位置，从classpath中移到了webapp中。因为在excel文件在classpath中，打包的时候会被修改导致文件损坏；
	- 修改拷贝Excel模板的方法，创建workbook还是用InputStream，以防在某些环中境无法正确创建workbook。

## v1.05c

### 变更列表

- AjaxRtnJson和MiniRtn2Grid实现Serializable接口，为以后使用RPC技术做准备。

### 修正列表

- 修正Excel导出功能的BUG：
	- 现在不进行数据填充的列单元格不会为null了；
	- 修改拷贝Excel模板的方法，防止某些Excel文件使用byte流会出现获取workbook异常的问题。同时节省了拷贝模板的内存开销。

***

## v1.05b

### 修正列表

- 修正了filter和资源文件的配置方式后代码生成器读取不到properties的BUG，local-config.properties名称修改为sys-config.properties。

***

## v1.05a

### 修正列表

- 修正FindBugs找出的MyBatisCriteriaUtils.java和Excel导出的单元测试代码中的BUG：
	- 修正MyBatisCriteriaUtils.java有一个可能少判断null导致使用对象时可能为空的BUG；
	- 修正Excel导出的单元测试代码中由于除余导致正负号不正确的BUG。

***

## v1.05

### 新增功能

- 新增Excel导出功能，通过ExcelExportManager进行导出，包含以下接口，可以重新实现接口来完成不同的Excel导出功能：
	- ExcelExportManager：用于用户使用的导出接口，封装了所有导出相关的其他接口方法的调用；
	- ExcelExportService：导出Excel逻辑处理的核心接口，如果想实现不一样的Excel导出，请重新实现此接口；
	- ExcelTemplateProvider：获取Excel导出模板的接口，如果想实现从不同的地方（如文件系统，数据库等）获取Excel模板，请重新实现此接口；
	- ExcelDataMappingResolver：用于获取Excel导出数据集合映射的接口，如果想以不同的方式获取数据集合映射（如Annotation等），请重新实现此接口；
	- ExcelDataAnchorHandler：用于给Excel中设置固定值和寻找导出起始坐标的接口，在逻辑发生改变时可以重新实现此接口。
- 添加Powermock依赖，用于在单元测试中mock静态方法。
- 在main.jsp中添加了loadFramePage的JS方法，用于在IFrame中实现IFrame之间的跳转。

***

## v1.04a

### 修正列表

- 为解决Spring与Shiro依赖quartz版本冲突，修改Shiro会话验证调度器，将quartz调度器改为ExecutorServiceSessionValidationScheduler：
	- shiro-quartz用的是1.6.1版本，而Spring4集成的quartz要求是2.2.1版本以上，会产生冲突。

> Shiro会话验证调度器：Shiro提供了会话验证调度器，用于定期的验证会话是否已过期，如果过期将停止会话；出于性能考虑，一般情况下都是获取会话时来验证会话是否过期并停止会话的；但是如在web环境中，如果用户不主动退出是不知道会话是否过期的，因此需要定期的检测会话是否过期，Shiro提供了会话验证调度器SessionValidationScheduler来做这件事情。

***

## v1.04

### 新增功能

- 修改Maven构建的配置替换方式，增加sourceFolder：filters。里面存放替换用的配置文件模板，和替换值的properties文件：
	- template/webinf/classes目录中放置的文件是用于替换掉resources对应文件的模板文件；
	- config里面放的是通过Maven的filter进行key-value替换的properties配置；
	- 具体的替换和filter操作配置需要参看plm.xml中的maven-war-plugin和profiles。
- 为Page类增加equals方法和hashCode方法。
- 新增MyBatisCriteria工具类MyBatisCriteriaUtils，可以对比同类型的Criteria是否相等。并添加单元测试。
- 为前端请求菜单添加了生成树状数据结构返回值的方法，使用迭代生成菜单树，详情见SysAuthController和SysAuthService。

***

## v1.03

### 新增功能

- 引入Mockito框架（v1.10.19），Mockito是一个进行**Mock测试**的框架。
- 完成SysUserService所有方法的单元测试，SysUserService可作为参考例子
- 新建了AopTargetUtil工具类，用于通过代理对象获取实际的目标对象

> Mock测试：mock测试就是在测试过程中，对那些不容易构建的对象用一个虚拟对象来代替测试的方法就叫mock测试。

***

## v1.02

### 新增功能

- 为ajax提交添加返回登录前所请求页面的功能

***

## v1.01c

### 变更列表

- 修正了修改用户信息后，再次登录会失败的问题
	- 由于缓存的问题导致，因为缓存中的用户信息更新后没有密码。所以登录获取用户信息（含密码）不使用缓存。
	- 同时将获取用户名密码的方法从SysUserService中移到SysAuthService中，以防止误用。
***

## v1.01b

### 变更列表

- 修正org.amberframework中的技术债务

***

## v1.01a

### 变更列表

- 修改AjaxRtnJson类
	- 去除Serializable接口实现
	- 去除obj属性，及getter、setter方法
	- 修改attributes属性，将Map的Value从Object修改为String类型
- 修改MiniRtn2Grid类
	- 去除Serializable接口实现

***

## v1.0

### 代码生成器

- 可以生成Mapper.xml,Dao,Model,Service,Controller文件
- 目前只支持Oracle数据库
- 有拥GUI界面
- 不支持JSP代码生成

### 授权机制

- 使用Shiro组件进行登录验证和用户权限的支持
- 支持基于AD验证的SSO
- 实现了基于 用户 - 组 - 角色 - 菜单 - 权限 的权限配置

### 前端框架

- 使用miniUI v3.6
- 引入miniUI自定义的csot皮肤

### 缓存机制

- 使用Ehcache
- 权限和登录用户使用缓存机制