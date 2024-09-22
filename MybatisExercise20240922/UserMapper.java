package com.wzb.MybatisExercise20240922;


import com.wzb.Pojo20240922.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 在Mybatis的规范中，一般将接口写成“XxxMapper”
@Mapper
// 虽然在测试类中使用了@AutoWired注解，自动注入UserMapper接口，但并不需要@Component注解，因为@Mapper会自动将
// UserMapper类注册为bean类，无需多余的注解，可以理解为@Mapper包含了@Component的功能
public interface UserMapper {
    @Select("select * from springboot.user")
    public List<User> getList();
}
