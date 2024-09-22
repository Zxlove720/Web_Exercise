package com.wzb.MybatisImprove20240922;

import com.wzb.Pojo20240922.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EmpMapper {
    // 用Mybatis操作数据库完成增、删、改、查

    // 写死的写法————一般不用

//    @Delete("delete from emp where id = 17")
//    public void deleteEmp();

    /* 以上的delete操作的SQL语句的id写死成17了，所以说只能删除id=17的用户数据，但往往SQL语句中的id值是动态变化的 */
    // 解决方案：在delete方法和SQL语句中添加一个参数（用户id），将方法中的参数传递给SQL语句使用

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    // 在Mybatis中，可以借助日志，查看SQL语句的执行、执行传递的参数和执行的结果
    // 操作：在application.properties文件中开启Mybatis日志，并指定其输出在控制台
    // mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl


    // 使用#{}的方式传递参数，其实是一种占位的操作，而这种SQL语句称为预编译SQL
    // 预编译SQL的优势：
    // 1.性能更高
    // 预编译SQL在编译一次之后，就会将编译后的SQL语句缓存起来，若后面再次执行到该语句时，无需再次编译，直接使用缓存的语句，只是参数不同

    // 2.更加安全（防止SQL注入）
    // 能够将敏感的语句进行转义，防止SQL注入

    // SQL注入：通过操作输入的数据来修改事先定义好的SQL语句，达到执行代码对服务器进行攻击的目的
    // SQL又是拼接而成，在用户输入参数时，在参数中添加一些SQL关键字，达到改变SQL运行结果的目的，也可以完成恶意攻击。


    // 通过Mybatis在数据库中增加数据
//    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
//            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
//    // #{...}中填的内容是对象的属性名
//    public void insert(Emp emp);

    // 主键返回：在数据成功添加之后，需要获取插入数据库数据的主键
    // 因为两张表若是多对多的关系，那么势必会有另一张表维护他们之间的关系，需要在一张表插入之后，返回其主键供第二步使用
    // 但是默认是不会返回主键的，若想返回主键，需要在Mapper接口中的方法加上@Options注解，并且在注解中指定属性：useGenerateKeys=true
    // 并且KeyProperty="实体类属性名"

    //会自动将生成的主键值，赋值给emp对象的id属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
