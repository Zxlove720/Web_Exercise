package com.wzb.mapper20240928;

import com.wzb.pojo20240928.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    // 获取总记录数
//    @Select("select count(*) from emp")
//    public Long countItem();
//
//    // 获取当前页的查询列表结果
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> pageSelect(Integer start, Integer pageSize);

    @Select("select * from emp")
    public List<Emp> pageSelect(Integer start, Integer pageSize);

}
