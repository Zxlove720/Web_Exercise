package com.wzb.MybatisExercise20240925;

import com.wzb.Pojo20240925.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    // 增
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insertEmp(Emp emp);

    // 删
    @Delete("delete from emp where id = #{id}")
    public void deleteEmp(Integer id);

    // 改
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    public void updateEmp(Emp emp);

    // 查
    @Select("select * from emp where id = #{id}")
    public Emp selectEmp(Integer id);



}
