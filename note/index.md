# user-center-java

- Reference

  [yupi note](https://bcdh.yuque.com/staff-wpxfif/resource/diuioo), [yupi note](https://yuyuanweb.feishu.cn/wiki/DclswHMhkiRXckkWve1ckXTonDh), [code backend](http://gitlab.code-nav.cn/root/user-center-backend), [code frontend](http://gitlab.code-nav.cn/root/user-center-frontend), [user-center-backend-public (github)](https://github.com/liyupi/user-center-backend-public), 

  [classmate note](https://www.aliyundrive.com/s/czdYe2ZZXux),

  [user center (golang)](https://articles.zsxq.com/id_tmiv1m92rndu.html), [user center (golang github)](https://github.com/open-user-center), [user center (golang)](https://wx.zsxq.com/dweb2/index/topic_detail/181485581145842), [go web Scaffolding](https://github.com/miomiora/mio-init),

  [go classmate](https://gitee.com/moxi159753/LearningNotes/tree/master/Golang/),

  [good](https://www.dsjtm.com/),

- Reference - dev

  [nodejs org](https://nodejs.org/en), [nodejs LTS (cn)](https://nodejs.cn/#google_vignette); [Ant Design Pro](https://pro.ant.design/zh-CN/docs/getting-started), [umi docs](https://umijs.org/docs/guides/getting-started), 

  [mybatisplus docs](https://baomidou.com/pages/226c21/), 





- 定位

  用户中心项目，可以成为未来许多项目的基础 (脚手架)

- 学习

  经验和方法的感知

  写代码自己解决、除了写逻辑其他不需要自己动手

  先做设计、代码实现、持续优化

  



- 企业项目流程

  需求分析 -> 概要设计详细设计 -> 技术选型

  初始化/引入需要的技术 -> 写demo -> 写代码实现业务逻辑 -> 单元测试 -> 代码提交代码评审 -> 部署发布

- 完整项目开发流程、企业级开发技术

  1. 用户中心：学完框架新手入门、完整项目开发流程
  2. 伙伴匹配系统：Redis、事务、并非编程、大数据推荐思想
  3. API开放平台：架构设计、sdk开发、API签名认证、RPC、微服务网关
  4. 聚合搜索平台：爬虫、ElasticStack、设计模式
  5. 智能BI项目：异步化、线程池、RabbitMQ、AIGC
  6. OJ在线判题系统：
  7. 定制化代码生成项目：
  8. RPC框架：

  



- IDEA 插件

  `MyBatis-X`

  `auto filling`

  



## 背景介绍

- 需求分析

  市场应用：微信、支付宝账号登录多个平台

  用户体系：登录注册、用户管理(仅管理员可见)、用户校验(仅星球用户)

  - 登录注册：对用户的增加查询
  - 用户管理：对用户的查询修改
  - 用户校验：合法性 (爬虫、excel处理、定时任务)

- 技术选型

  前端：三件套 + `React` + 组件库`AntDesign` + `Umi` + 现成管理系统`AntDesignPro`

  后端：`java` + `spring` + `springmvc` + `mybatis-plus` + `springboot` + 数据库`mysql`

  - `spring`：依赖注入框架、帮你管理java对象、集成一些内容
  - `springmvc`：web框架、提供接口访问、restful接口等能力
  - `mybatis-plus`：操作数据库、持久层框架、再封装即不用写sql
  - `springboot`：不用自己管理spring配置、不用自己整合各种框架、快速启动快速集成项目

  部署：服务器、容器(平台)

- 计划

  初始化项目：

  - 前端初始化：初始化、引入一些组件、框架介绍、项目瘦身
  - 后端初始化：准备环境(mysql)、引入框架整合框架

  登陆注册：前端、后端

  - 后端：注册和登录、service controller和接口测试
  - 前端：个性化、删代码；对接后端接口、获取用户的登录态
  - 注销功能

  用户管理：前端、后端

  - 后端：用户管理接口 (用户查询 状态更改)
  - 前端：开发；前端代码瘦身
  - 优化：注册失败返回-1不友好

  校验用户：星球用户





## 初始化环境

### 前端环境初始化

- 环境要求

  [nodejs LTS (cn)](https://nodejs.cn/#google_vignette); [Ant Design Pro](https://pro.ant.design/zh-CN/docs/getting-started), [umi docs](https://umijs.org/docs/guides/getting-started)

- 一些问题

  [Ant Design Pro的gitee仓库](https://gitee.com/ant-design/ant-design-pro/), [鱼皮的用户中心项目 前端Ant Design Pro构建](https://www.yuque.com/shayushitiande/hcq960/wigdtf?)

  [我遇到了项目启动失败的问题解决方案](https://www.cnblogs.com/codewhimsy/articles/17641636.html#:~:text=%23 ant design pro 项目启动失败 环境： node v18.17.1,npm install yarn tyarn -g npm i %40ant-design%2Fpro-c), [炎的笔记](https://wx.zsxq.com/dweb2/index/topic_detail/184522182814122)

- 初始化项目 (查官网)

  ```bash
  # 拉取脚手架代码 创建项目
  npm i @ant-design/pro-cli -g
  pro create frontend  # simple
  
  # 依赖安装  
  cd frontend && npm install
  # 安装umi ui
  npm install @umijs/preset-ui --save-dev
  npm run start
  
  
  # yarn
  yarn global add @ant-design/pro-cli
  pro create web-ts --typescript
  cd web-ts && yarn install
  
  yarn add @umijs/preset-ui -D
  yarn start
  
  ```

  



- 项目瘦身

  删除国际化：执行 `i18n-remove` 脚本、删除项目路径下 src/locales 文件夹

  删除项目路径下 src/e2e 文件夹：e2e 文件夹里面定义的是一系列测试流程

  若前面有使用 umi ui 添加页面，可把该页面删除 (注意：需要在路径为 config/routes.ts 的文件夹下，删除对应的路由规则 )

  删除项目路径下 src/services/swagger 文件夹：swagger 文件夹里面定义了一系列后台接口程序

  删除项目路径下 config/oneapi.json 文件：oneapi.json 定义了整个项目用到的一些接口

  删除项目根路径下 tests 文件夹：tests 文件夹主要是和测试相关的

  删除项目根路径下 jest.config.js 文件：jest.config.js 测试相关的配置文件

  删除项目根路径下 playwright.config.ts 文件：playwright.config.ts -> 自动化测试工具，帮你在火狐或谷歌自动测试，不用真实地打开浏览器就能测试

  ```bash
  cd 
  rm -rf src/locales 
  rm -rf src/e2e
  rm -rf src/services/swagger/  # 
  rm -rf config/oneapi.json  # 删除项目中的有关配置
  rm -rf tests 
  rm -rf jest.config.js
  rm -rf playwright.config.ts 
  
  ```

  



- 家族盘点 ant design

  ant design 组件库 (封装了react)

  [ant design procomponents](https://procomponents.ant.design/components/form) 面向业务 定制化 (封装了ant design)

  ant design pro 后台管理系统 (由ant design、react、ant design procomponents及其他库组成)

- 文件结构 ant design pro (umi框架) 

  `app.tsx` 项目全局入口文件，定义了整个项目中使用的公共数据 (如用户信息)

  首次访问页面或刷新页面，进入app.tsx执行getInitialState方法，该方法的返回值就是全局可用的状态值

  `access.ts` 控制用户的访问权限

  



### 后端环境初始化

- 集成开发工具：IDEA, webStorm (不需要其他)

- 三种方式初始化后端

  github上搜索springboot模板，拉现成的模板 (不推荐)

  SpringBoot 官方模板生成器：https://start.spring.io/

  集成开发工具IDEA (推荐✔)

- spring初始java8项目

  spring官方不再支持java8 https://start.spring.io

  用阿里云提供的脚手架 https://start.aliyun.com/

  



- 选择配置

  Spring Boot DevTools (热更新), spring configuration processor, spring web (web访问), 

  mysql, mybatis framework (数据访问层), 

  lombok (自动生成get set方法), junit (默认集成)

- 框架整合  [mybatisplus docs](https://baomidou.com/pages/226c21/)

  ```bash
  mysql -uroot -p123456
  show databases;
  
  create database user_center;
  use user_center;
  
  ```

  



## 项目核心开发

### 速查

- 规整项目目录

  `controller ` (接收请求 封装接口给前端调用), `service` (业务逻辑), `mapper` (数据库操作)
  
  `model.domain` (实体类对象), 全局变量常量, `contant` (枚举常量)

  `utils`(工具类), 配置信息, 

- Java project

  `Springboot Application` 加注解 `@MapperScan("com.time1043.campussystemjava.mapper")`
  
  `application.yml` 配置信息 

  `pom.xml` 导入依赖baomidou 整合mybatis-plus 

  MyBatisX 生成：MyBatisX-Generator -> module path -> annotation (MyBatis-Plus3) options (comment lombok actualColumn Model) template (mybatis-plus3)
  
  ```bash
  cd src/main/java/com/time1043/backendusercenter/
  mkdir controller service mapper model contant utils
  
  # mybatis-x
  # localhost:8080/api/index.html
  
  
  # pom.xml
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.5.1</version>
  </dependency>
  
  ```
  
  



### 数据库表设计

- 用户表

  id(主键)、userAccount、username、avatarUrl、gender、userPassword、phone、email、userStatus；

  createTime、updateTime、isDelete；

  数据库字段添加索引……

  表与表之间的关联……

  ```sql
  drop database user_center;
  create database user_center;
  use user_center;
  
  drop table if exists user;
  create table user
  (
      id           bigint auto_increment primary key comment '唯一ID',
      username     varchar(255) comment '用户名',
      userAccount  varchar(255) comment '登录账号',
      avatarUrl    varchar(1024) comment '用户头像URL',
      gender       tinyint comment '用户性别',
      userPassword varchar(512) not null comment '用户密码',
      phone        varchar(128) comment '用户电话号码',
      email        varchar(512) comment '用户电子邮件',
      userStatus   int       default 0 comment '用户状态0为正常',
      createTime   timestamp default current_timestamp comment '创建时间',
      updateTime   timestamp default current_timestamp on update current_timestamp comment '更新时间',
      isDelete     tinyint   default 0 comment '逻辑删除标志',
      userRole int default 0 comment '用户角色 0是普通用户 1是管理员'
  );
  
  insert into user (username, useraccount, avatarurl, gender, userpassword, phone, email, userstatus,
                    createtime, updatetime, isdelete)
  values ('AliceSmith', 'alice.smith', 'https://avatars.com/alice.jpg', 1, 'alicepass123', '+15551234567',
          'alice.smith@gmail.com', 0, current_timestamp, current_timestamp, 0),
         ('BobJohnson', 'bob.johnson', 'https://avatars.com/bob.jpg', 0, 'bobpass456', '+15551234568',
          'bob.johnson@yahoo.com', 0, current_timestamp, current_timestamp, 0),
         ('CharlieBrown', 'charlie.brown', 'https://avatars.com/charlie.jpg', 1, 'charliepass789', '+15551234569',
          'charlie.brown@outlook.com', 0, current_timestamp, current_timestamp, 0),
         ('DianaPrince', 'diana.prince', 'https://avatars.com/diana.jpg', 2, 'dianapass123', '+15551234570',
          'diana.prince@hotmail.com', 0, current_timestamp, current_timestamp, 0),
         ('EinsteinM', 'einstein.m', 'https://avatars.com/einstein.jpg', 1, 'einsteinpass456', '+15551234571',
          'einstein.m@icloud.com', 0, current_timestamp, current_timestamp, 0);
          
  ```

- 逻辑删除需要配置  [MyBatis-Plus docs](https://baomidou.com/pages/6b03c5/#使用方法)

  src\main\resources\application.yml

  ```yml
  spring:
    application:
      name: user-center-java
    datasource:
      driver-class-name: com.mysql.jdbc.Driver
      url: jdbc:mysql://localhost:3306/user_center
      username: root
      password: 123456
    session:
      timeout: 86400  # 1天的session过期时间
  server:
    port: 8080
    servlet:
      context-path: /api  # 指定接口全局api前缀
  
  mybatis-plus:
    configuration:
      map-underscore-to-camel-case: false
    global-config:
      db-config:
        logic-delete-field: isDelete  # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
        logic-delete-value: 1  # 逻辑已删除值(默认为 1)
        logic-not-delete-value: 0  # 逻辑未删除值(默认为 0)
  
  ```

- MyBatis-X ...

  



## 登录注册 后端

- 分层架构

  数据库访问层：`MyBatis-X`

  业务逻辑层：





### 数据库访问层 (mapper)

- MyBatis-X ...

- 测试 UserService

  `@SpringBootTest`; `@Resource`, `@Test`

  src\main\java\com\time1043\backendusercenter\service\UserService.java

  src\test\java\com\time1043\backendusercenter\service\UserServiceTest.java

  



### 业务逻辑层 (service)

- 注册逻辑

  用户在前端输入**账号和密码**、以及校验码 (todo)

  **校验**用户的账户、密码、检验密码是否符合要求  (非空检验、账户不小于4位、密码不小于8位、账户不能重复、账户不含特殊字符、密码和校验密码相同)

  对密码进行**加密** (千万不要明文存储数据库)

  向**数据库**插入用户数据

- Q：为什么前端校验了，后端还要校验？

  前端只能拦住正常用户，拦不住攻击，用户可以绕过前端向后端接口发请求

  

---

- 单机登录 (后续改造 redis分布式 第三方登录)

  登录接口

  接收参数：用户账户、密码

  请求类型：POST

  请求体：JSON

  返回值：用户信息 (脱敏)

- 登录逻辑

  检验用户账户和密码是否**合法** (非空、账户不小于4、密码不小于8、账户不含特殊字符)

  校验**密码**是否输入正确，要和数据库密码密文对比

  记录用户的**登录态** (session)，存到服务器上 (后端springBoot封装的服务器 tomcat)

  返回用户信息 (**脱敏**)

- Q：如何知道是哪个用户登录？

  session, cookie

  

---

- 代码实现  [apache-commons 校验 (需要导入依赖)](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3)

  src\main\java\com\time1043\backendusercenter\service\UserService.java

  src\main\java\com\time1043\backendusercenter\service\impl\UserServiceImpl.java

  src\test\java\com\time1043\backendusercenter\service\UserServiceTest.java

  



### 接口访问层 (controller)

- CRUD接口

  src\main\java\com\time1043\backendusercenter\controller\UserController.java 

  ADMIN_ROLE, USER_LOGIN_STATE

- 定义请求的数据结构 (前端JSON -> 请求对象)

- IDEA自带的http测试工具

  ```
  ###
  POST http://localhost:8080/user/login
  Content-Type: application/json
  
  {
    "userAccount": "yingzhu2",
    "userPassword": "12345678"
  }
  
  <> 2024-03-25T123653.200.json
  <> 2024-03-25T123057.200.json
  
  ```

  



### 数据模型 (model)

- 定义请求的数据结构 (前端JSON -> 请求对象)

  src\main\java\com\time1043\backendusercenter\model\domain\request\UserLoginRequest.java

  src\main\java\com\time1043\backendusercenter\model\domain\request\UserRegisterRequest.java



## 登录注册 前端





















## 项目优化







## 项目上线

























