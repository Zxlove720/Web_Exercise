package com.wzb.mapper20240928;

import com.wzb.pojo20240928.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 增
    @Insert("insert into dept (name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    public void insertDept(Dept dept);

    // 删
    @Delete("delete from dept where id=#{id}")
    public void deleteDept(Integer id);

    // 改
    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    public void updateDept(Dept dept);

    // 查
    @Select("select * from dept")
    public List<Dept> selectDept();
}
