package com.wzb.mapper20241005;

import com.wzb.pojo20241005.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> pageSelect(String name, Short gender, LocalDate begin, LocalDate end);

}
