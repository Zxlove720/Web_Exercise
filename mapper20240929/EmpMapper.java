package com.wzb.mapper20240929;

import com.wzb.pojo20240929.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    public Long getTotal();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> getList(Integer start, Integer pageSize);


    // 使用分页插件pageHelper便捷地进行分页查询

    // 获取当前页的查询结果
    @Select("select * from emp")
    List<Emp> pageAllSelect();

    List<Emp> pageSelect(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmp(List<Integer> ids);

    void insertEmp(Emp emp);

}
