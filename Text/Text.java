package com.wzb.Text;

public class Text {
    // 综合案例：SpringBootWeb
    // 请求响应 + 三层架构 + Mybatis操作数据库 + 前后端联合开发

    // 基本的环境准备好：
    // 1.准备数据库表
    // 2.创建SpringBoot工程，引入对应的起步依赖(web、mybatis、mysql驱动、lombok)
    // 3.配置文件application.properties中引入mybatis的配置信息、准备对应的实体类
    // 4.准备对应的Mapper、Service（接口、实现类）、Controller基础结构（三层架构）

    // 开发规范：

    // 此案例基于主流的前后端分离模式开发
    // 前后端分离开发模式中，前后端开发人员都需要根据提前定义好的接口文档，然后进行前后端功能的开发
    // 后端开发：必须严格遵循提供好的接口文档进行后端功能开发（接口文档十分的重要），保证开发功能成功和前端对接
    // 前后端交互时，需要基于主流的REST风格的API接口进行交互

    // 传统的URL风格：
    // http://localhost:8080/user/getById?id=1     GET：查询id为1的用户
    // http://localhost:8080/user/insertUser         POST：新增用户
    // http://localhost:8080/user/updateUser       POST：修改用户
    // http://localhost:8080/user/deleteUser?id=1  GET：删除id为1的用户
    // 弊端：
    // 1.定义复杂：每个操作都需要一个独立的URL，增加了维护的复杂性
    // 2.安全性问题：将资源的访问行为直接暴露在URL中，可能会带来安全隐患

    // REST风格（Representational State Transfer）：表述性状态转换，是一种软件架构的风格
    // http://localhost:8080/users/1  GET：查询id为1的用户
    // http://localhost:8080/users    POST：新增用户
    // http://localhost:8080/users    PUT：修改用户
    // http://localhost:8080/users/1  DELETE：删除id为1的用户
    // REST风格通过URL定位需要操作的资源，通过HTTP动词（请求方法）来描述具体的操作
    // REST风格的URL中通过四种请求方式，来操作数据的增删改查：
    // 1.增：POST     2.删：DELETE      3.改：PUT     4.查：GET
    // 好处：基于REST风格定义URL，URL会更加的简洁规范、更加优雅、更加安全

    // REST风格是约定方式，并非是硬性规定
    // 描述模块的功能时，通常使用复数，也就是加s的格式来描述，表示此类资源并非是单个资源。如：users、emps、books




}
