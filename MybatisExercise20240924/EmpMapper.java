package com.wzb.MybatisExercise20240924;

import com.wzb.Pojo20240924.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    // 根据id查询数据
    @Select("select * from emp where id=#{id}")
    public void getEmp(Integer id);

    // 增加新的数据
    // 设置主键返回
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, " +
            "update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, " +
            "#{deptId}, #{createTime}, #{updateTime})")
    public void insertEmp(Emp emp);

    // 修改表中数据
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    public void updateEmp(Emp emp);

    // 按照id删除表中数据
    @Delete("delete from emp where id = #{id}")
    public void deleteEmp(Integer id);

}
