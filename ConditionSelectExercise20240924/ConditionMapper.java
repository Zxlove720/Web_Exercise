package com.wzb.ConditionSelectExercise20240924;

import com.wzb.Pojo20240924.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;


@Mapper
public interface ConditionMapper {

    // 完成条件查询

    @Select("select * from emp " +
            // 在通配符中，不能直接使用#{name}这样的#{}占位符，需要在concat方法中使用，这样才可以避免SQL注入的问题
            // 生成的SQL语句都是预编译的SQL语句，性能更高（只需要编译一次），更加安全（解决了SQL注入的问题）
            "where name like concat('%',#{name},'%') " +
            "and gender = #{gender} " +
            "and entrydate between #{begin} and #{end} " +
            "order by update_time desc")

    public List<Emp> conditionSelect(String name, Short gender, LocalDate begin, LocalDate end);
    // 特别注意！方法中的形参名，必须严格和占位符的参数名相等
}

