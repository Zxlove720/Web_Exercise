package com.wzb.mapper;

import com.wzb.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    public List<Dept> getDeptList();

    @Delete("delete from dept where id=#{id}")
    public void deleteDept(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    public void insertDept(Dept dept);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    public void updateDept(Dept dept);
}
