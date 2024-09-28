package com.wzb.controller20240928;

import com.wzb.pojo20240928.PageBean;
import com.wzb.pojo20240928.Result;
import com.wzb.service20240928.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    // 分页查询
    // 之前的查询部门，是直接将查询的结果全部查询出来并且直接展示到页面上，但若当数据库中的数据有很多的时候，就需要分页查询
    // 每页只展示一页数据：比如一页只展示10条数据，若还想看其他数据，那么通过点击页码进行查询

    // 分页查询格式：在select后使用limit关键字
    // limit 开始索引 每页显示的数据条数：若每页10条，
    // 查询第一页的语句：select * from emp limit 0, 10; (索引是从0开始的)
    // 查询第二页的语句：select * from emp limit 10, 10;
    // 观察规律可知，每一页的开始索引一直在改变，但是每页显示的条数是固定的————索引计算公式：开始索引=(当前页码 - 1) * 每页显示的条数

    // 前端在请求分页查询的时候，应该传递的参数：1.当前页码：page      2.每页的显示条数：pageSize

    // 后端应该给前端响应的数据：1.查询到的数据列表（存储在List集合中）      2.总记录数
    // 后端响应的这两部分通常会封装到PageBean对象中，并将该对象转换为json格式的数据返回给浏览器


    // 阅读接口文档：
    // 1.请求路径：/emps
    // 2.请求方式：GET
    // 3.请求参数：跟随在请求路径后的参数字符串。如：/emps?page=1&pageSize=10
    // 4.响应数据的格式：json


    // 条件分页查询
    @GetMapping
    // 指定查询的页数（默认是第1页）、每一页的条数（默认每一页10条）
    public Result pageSelect (@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize) {
        // “记录日志”
        System.out.printf("分页查询，参数：查的%d页，这一页有%d条", page, pageSize);
        // 调用业务层（Service）分页查询功能
        PageBean pageBean = empService.pageSelect(page, pageSize);
        // 响应
        return Result.success(pageBean);

        // 直接写分页查询的代码弊端：1.过于繁琐      2.安全性不高（SQL注入）

        // 可以使用Mybatis中的PageHelper分页插件完成分页查询的操作
        // 在执行empMapper.pageSelect方法时，只需要执行select * from emp，就可以完成分页查询

        // 分页查询帮我们完成了以下操作：
        // 1.先将SQL语句的：select * from emp中的字段列表变成：count(*)
        // 2.执行：select count(*) from emp 获取到总记录数
        // 3.然后再对：select * from emp改造，在末尾添加limit
        // 4.然后执行改造后的SQL：select * from emp limit……

        // 使用PageHelper分页插件进行分页查询，无需再对Mapper中进行手动分页，在Mapper中只需要正常的列表查询即可
        // 在Service层中，调用Mapper方法之前设置分页参数，在调用Mapper方法执行查询之后，解析分页结果，并封装到PageBean对象中返回


    }
}
