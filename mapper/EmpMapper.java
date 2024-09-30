package com.wzb.mapper;

import com.wzb.pojo20240930.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> pageSelect(String name, Short gender, LocalDate begin, LocalDate end);
}
