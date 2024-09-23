package com.wzb.MybatisExercise20240923;

import com.wzb.Pojo20240923.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    // 通过Mybatis对数据库内容进行更新
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, " +
            "entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void updateEmp(Emp emp);

    // 根据不同的字段对数据库进行查询
    // 注！@Select必须要有返回值，通常是返回对应属性封装的实例类
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time" +
//            " from emp where id=#{id}")
//    public Emp selectEmp(Integer id);

    // 发现查询的结果：deptId、createTime、updateTime是没有值的，其全部都是null
    // 原因：因为实体类的属性和数据库表查询返回的字段名不一致，无法自动封装（若一致才可以自动封装）

    // 解决方案：

    // 1.起别名
    // 在SQL语句中，对不同的列名起别名，别名和实体类属性名一样
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id as deptId, " +
//            "create_time as createTime, update_time as updateTime from emp where id = #{id}")
//    public Emp selectEmp(Integer id);

    // 2.结果映射
    // 通过@Results和@Result进行手动结果映射
//    @Results({@Result(column = "dept_id", property = "deptId"),
//              @Result(column = "create_time", property = "createTime"),
//              @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
//            "from emp where id = #{id}")
//    public Emp selectEmp(Integer id);


    // 3.开启驼峰命名
    // 如果字段名与属性名符合驼峰命名规则，mybatis会自动通过驼峰命名规则映射
    // 但是，非常需要注意的一点：要使用驼峰命名前提是：实体类的属性与数据库表中的字段名严格遵守驼峰命名。
    // 在application.properties中添加：mybatis.configuration.map-underscore-to-camel-case=true
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time" +
            " from emp where id=#{id}")
    public Emp selectEmp(Integer id);

}
