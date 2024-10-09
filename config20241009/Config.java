package com.wzb.config20241009;

public class Config {
    public static void main(String[] args) {
        // 前期一直使用springboot项目中自带的application.properties进行属性的配置，但事实上，springboot项目中
        // 支持多种配置方式，常见的有三种：.properties、.yml、.yaml————yml格式的配置文件后缀有两种：yml、yaml
        // 推荐使用.yml配置文件进行对springboot项目进行配置

        // 常见配置文件格式对比：
        // xml配置文件：标签语言，十分的臃肿
        // properties配置文件：层次结构不清晰，配置文件中过多的重复层次
        // yml/yaml配置文件：简洁、以数据为中心，而并非以层次为中心

        // yml/yaml的配置文件的特点：
        // 1.层次清晰，简洁、以数据为中心     2.易与脚本文件交互      3.以数据为核心，注重数据而并非层次格式

        // yml配置文件的基本语法
        // 1.大小写敏感
        // 2.数值前边必须有空格，作为分隔符
        // 3.用缩进表示层级关系，缩进时应该使用空格缩进而不是使用tab键（idea会自动将tab转换为空格）
        // 4.缩进的空格数目不定，只要同一层级的元素左侧对齐即可

        // yml文件中常见的数据格式：
        // 1.定义对象或者Map集合
        /*
        user:
            name: zhangsan
            age: 18
            password: 123456
        */

        // 2.定义数组/List/Set集合
        /*
        hobby:
            - java
            - game
            - sport
         */
    }
}
