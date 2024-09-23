package com.wzb.ConditionSelectExercise20240923;

import com.wzb.Pojo20240923.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ConditionEmpMapper {
    // 条件查询，在实际开发中，常常需要根据不同的条件查询员工的信息
    // 姓名：要求实现模糊匹配
    // 性别：要求实现精确匹配
    // 入职时间：要求进行范围查询
    // 根据最后修改时间进行排序

    // SQL语句
    /* select id, username, password, name, gender, image, job, entrydate, dept_id,
       create_time, update_time
       from emp
       where name like '%张%'
             and gender = 1
             and entrydate between '2010-01-01' and '2020-01-01'
       order by update_time desc;
     */

    // 接口方法实现

    // 1.
//    @Select("select * from emp " +
//            "where name like '%${name}%' " +   // 注意，使用通配符就不能直接使用#{}进行占位了
//            "and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} " +
//            "order by update_time desc")
//    public List<Emp> selectEmp(String name, short gender, LocalDate begin, LocalDate end);
    // 虽然上述方法看似能够实现业务逻辑，但用了${}占位符，会导致SQL注入的问题

    // 2.使用concat字符串拼接函数解决SQL注入风险
    @Select("select * from emp " +
            "where name like concat('%', #{name}, '%') " +   // 使用concat函数实现拼接，可以使用#{}
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")
    public List<Emp> selectEmp(String name, short gender, LocalDate begin, LocalDate end);

    // 特别注意：保证接口中的@Select中的SQL语句的占位符参数名必须和方法中的形参名字相同，不然会出现找不到参数的错误

    // 在Springboot 1.X的版本，还需要用@Param注解来指定SQL语句中的参数名

    // 但是在Springboot 2.X以上的版本，只需要保证SQL中的参数和方法中的参数名相同即可
    // 因为Springboot父工程对compiler编译插件进行了默认的参数parameter配置，在编译时，会生成字节码文件中保留原方法
    // 形参的名字，所以说需要保证SQL语句中参数名字和方法形参名相同，才能保证#{}可以正确获得方法形参的值


}
