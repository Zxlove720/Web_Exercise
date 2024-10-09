package com.wzb.mapper20241009;

import com.wzb.pojo20241009.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmpMapper {

    @Select("select * from emp where id = #{id}")
    public Emp selectEmp(Integer id);

    // 因为更新员工数据的SQL语句相对比较复杂，所以说需要使用xml动态SQL
    public void updateEmp(Emp emp);
}
