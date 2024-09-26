package com.wzb.MybatisExercise20240926;

import com.wzb.Pojo20240926.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MybatisMapper {

    // 增
    public void insertEmp(Emp emp);

    // 删
    public void deleteEmp(List<Integer> ids);

    // 改
    public void updateEmp(Emp emp);

    // 查
    public List<Emp> selectEmp(String name, short gender, LocalDate begin, LocalDate end);


}
