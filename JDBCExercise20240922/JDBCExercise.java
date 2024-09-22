package com.wzb.JDBCExercise20240922;

import com.wzb.Pojo20240922.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExercise {
    // 通过Mybatis可以便捷地操作数据库，但是Java语言操作数据库实际上只有一种方式：JDBC

    // JDBC(Java DataBase Connectivity)：其就是使用Java语言操作关系型数据库的一套API
    // Java提供官方定义的操作关系型数据库的规范（接口）
    // 各个厂商实现这个接口，提供对应的数据库驱动jar包
    // 程序员使用接口（JDBC）操作数据库，但是真正执行的代码是驱动jar包的实现类


    // 直接使用JDBC程序操作数据库
    // 1.注册驱动
    // 2.获取连接对象
    // 3.执行SQL语句，返回执行结果
    // 4.处理执行的结果
    // 5.释放资源


    public void testJdbc() throws ClassNotFoundException, SQLException {

        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/springboot";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.执行SQL语句

        // 获取操作SQL的对象
        Statement statement = connection.createStatement();
        String selectSql = "select * from user";
        // SQL查询的结果将封装到ResultSet对象中，需要在ResultSet对象中处理数据
        ResultSet rs = statement.executeQuery(selectSql);
        // 创建集合，用于存储User对象
        List<User> userList = new ArrayList<>();

        // 4.处理SQL执行的结果

        // 循环读取rs中从SQL返回的数据，只要还有数据，就继续读取
        while (rs.next()) {
            // 取出一行记录中id、name、age、gender、phone下的数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            short age = rs.getShort("age");
            short gender = rs.getShort("gender");
            String phone = rs.getString("phone");
            // 将一行记录中的数据封装到User对象中
            User user = new User(id, name, age, gender, phone);
            // 将User对象加入到集合中
            userList.add(user);
        }

        // 5.释放资源
        statement.close();
        connection.close();
        rs.close();

        // 使用集合
        for (User user : userList) {
            System.out.println(user);
        }
    }

    // 使用原始的JDBC存在的问题：
    // 1.数据库连接的驱动、连接、登录全部都硬编码在Java代码中
    // 2.查询结果的解析及其对象的封装十分繁琐
    // 3.每一次查询数据库都需要获取连接，操作完成之后需要释放连接，多次连接、释放；导致浪费资源
    
    
    // Mybatis如何解决原始JDBC的问题：
    // 1.将数据库连接的四要素（驱动、连接、用户名、密码），全部配置在springboot默认的配置文件（application.properties）
    // 2.查询结果的解析及其封装全部由Mybatis完成，无需手动编写
    // 3.Mybatis中使用了数据库的连接池技术，避免了频繁地创建连接、销毁连接带来的资源浪费

    // 在使用Mybatis时，最重要的两点：
    // 1.正确的配置application.properties数据库连接配置文件
    // 驱动类名称、数据库连接的URL、登录数据库的用户和密码

    // 2.正确的合理的Mapper接口

}
