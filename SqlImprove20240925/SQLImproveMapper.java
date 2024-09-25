package com.wzb.SqlImprove20240925;

import com.wzb.Pojo20240925.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SQLImproveMapper {

    // 在以前的SQL语句中，可以发现是用and将其连接的，相当于我们虽然没有限定其参数内容；但是我们仍然限定了其参数个数，若传递
    // 的参数小于限定的参数个数，则会查询失败，无法实现“动态”查询的效果

    // 实际真正的需求：若传递了参数，那么就根据这个参数，组装查询条件；若没有传递这个参数，那么就不会组装这个查询条件

//    比如：
//    如果姓名输入了"张", 对应的SQL为:
//    select *  from emp where name like '%张%' order by update_time desc;
//
//    如果姓名输入了"张",，性别选择了"男"，则对应的SQL为:
//    select *  from emp where name like '%张%' and gender = 1 order by update_time desc;

    // 达到根据我们真实传递的参数完成查询的效果，这是一种“动态”的查询，也可以称为动态SQL
    // 在Mybatis中提供了大量的实现动态SQL的标签，通过在XML中操作这些标签，就可以完成动态SQL

    // 需求：实现员工信息的动态查询，若传递了查找的参数，那么就将查找的条件拼接到SQL语句中；若没有参数，那么就不会拼接，可以有效防止
    // 参数不全查找失败的问题
    public List<Emp> sqlImprove(String name, short gender, LocalDate begin, LocalDate end);


    // 需求：需要动态的修改员工的信息：若更新员工信息时，传递了值，那么就更新；若没有传递值，就不更新
    public void updateImprove(Emp emp);

    // 需求：删除员工信息，既支持删除单条记录，又之支持批量删除多条记录
    // SQL语句：delete from emp where id in (1, 2, 3)   这条语句就可以完成批量删除三条语句
    // 可以使用<foreach>标签遍历delete方法中传递的id集合，从而达到删除多条语句的效果
    public void deleteImprove(List<Integer> ids);
}
