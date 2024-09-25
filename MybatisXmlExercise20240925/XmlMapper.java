package com.wzb.MybatisXmlExercise20240925;

import com.wzb.Pojo20240925.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface XmlMapper {

    public List<Emp> conditionSelect(String name, short gender, LocalDate begin, LocalDate end);

}
