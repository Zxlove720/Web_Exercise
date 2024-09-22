package com.wzb.Pojo20240922;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 为实体类按需求添加对应注解
@Data // 提供get/set方法、ToString方法、Equals、HashCode方法
@AllArgsConstructor // 提供无参构造
@NoArgsConstructor // 提供全参构造
public class Student {
    // Lombok
    // Lombok可以通过注解的方式简化和消除一些必要但臃肿的Java代码
    // 可以通过Lombok注解自动生成构造器、get/set方法、equals、toString等重复方法，并可以自动化生成日志变量

    // 1.@Getter/@Setter 为类中的所有属性提供get/set方法
    // 2.@ToString 为类自动生成人类易读的toString方法
    // 3.@EqualsAndHashCode 根据类中所有的非静态字段重写equals方法和HashCode方法

    // 前三个注解可以用@Data注解完全替代，@Data注解中包含了前三个注解的用途

    // 4.@NoArgsConstructor 为类生成无参构造器
    // 5.@AllArgsConstructor 为类生成除了static修饰外的其他所有参数的构造方法


    // 使用Lombok
    // 1.在pom.xml文件中引入依赖
    // 2.在想要使用的实体类上添加对应的注解

    // 添加的注解将会在编译阶段在类中生成对应的方法

    private String name;
    private Integer number;
    private String gender;
    private String address;
}

class test{
    public static void main(String[] args) {
        Student s = new Student("张三", 1, "男", "重庆");
        System.out.println(s);
    }
}
