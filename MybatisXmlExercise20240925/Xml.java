package com.wzb.MybatisXmlExercise20240925;

public class Xml {

    public static void main(String[] args) {
        System.out.println("Hello XML");
    }
    // XML配置文件规范

    // 使用Mybatis注解的方式的确可以操作数据库，但大多只能完成增删改查等简单的功能，若需要实现复杂的SQL功能，则需要
    // 使用XML配置文件映射语句————也就是将SQL语句写在XML配置文件中

    // 在Mybatis中使用XML映射文件开发，需要符合特定规范：
    // 1.XML映射文件名必须和Mapper接口严格相等，并且将XML映射文件和Mapper接口放置在相同的包下面（同包同名，必须严格相同）
    // XML文件一般都是放在resource目录之下的，需要在resource目录中创建和Mapper接口包同包同名的目录用于存放XML文件
    // 切记：因为在resource目录中无法直接创建软件包，所以说要创建目录，并用/分隔其层级关系

    // 2.XML映射文件的namespace属性必须和Mapper接口的全限定名完全一致
    // 3.XML映射文件中的SQL语句的id必须和Mapper接口的方法名一致，返回值也需要一致；都需要严格相等


    // XML配置文件和注解需要合理使用，在日常开发中，若没有特别要求，那么用注解完成一些简单的增删改查；用XML配置文件完成复杂的SQL功能

}
