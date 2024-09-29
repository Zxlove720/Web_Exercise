package com.wzb.controller20240929;


import com.wzb.pojo20240929.Emp;
import com.wzb.pojo20240929.PageBean;
import com.wzb.pojo20240929.Result;
import com.wzb.service20240929.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // 没有条件、查询全部的分页查询
    @GetMapping("/emps")
    // 请求路径中没有参数，前端请求的参数被@RequestParam注解所接收了，并且若不传参则使用@RequestParam设置的默认参数
    public Result pageSelect(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.printf("分页查询，参数：查的%d页，这一页有%d条", page, pageSize);
        PageBean pageBean = empService.pageAllSelect(page, pageSize);
        return Result.success(pageBean);
    }

//     上述分页查询只是查询表中所有的数据，并进行分页，不能自定义查询内容，所以说要通过动态SQL来改进分页查询
//     需求：可以通过指定姓名、性别、入职时间来自定义分页查询条件

    // 为什么要用@DateTimeFormat注解？
    // 因为Http请求都是String类型，但是需要的是LocalDate的对象，使用@DateTimeFormat注解并限定其模式，可以自动转换为LocalDate类型
    // GET /your-endpoint?begin=2024-01-01&end=2024-12-31
    // @DateTimeFormat自动解析：begin解析为LocalDate.of(2024, 1, 1)，end解析为LocalDate.of(2024, 12, 31)
    @GetMapping("/condition")
    public Result pageSelect(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Short gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        // 记录日志
        System.out.println("条件分页查询");
        // 通过Service层操作数据库并得到返回的PageBean对象
        PageBean pageBean = empService.pageSelect(page, pageSize, name, gender, begin, end);
        // 响应
        return Result.success(pageBean);
    }

    // 删除员工
    // 当勾选前端页面的复选框，然后点击批量删除，就可以将这一批次的员工信息删除了
    // 同时也可以只勾选一个复选框，仅删除一个员工信息

    // 不需要开发多个功能接口————因为删除多个员工这个功能接口包含了只删除一个员工的功能

    // 如何在controller中接收到请求路径中的路径参数？
    // --使用@PathVariable注解，写在方法的参数前面

    // 如何限定请求的方式是delete？
    // --使用@DeleteMapping注解，写在方法上面

    // 在Mapper接口中，执行delete操作SQL语句时，如何实现动态SQL？
    // --使用Mybatis中的forEach实现
    @DeleteMapping("/emps/{ids}")
    public Result deleteEmp(@PathVariable List<Integer> ids){
        empService.deleteEmp(ids);
        return Result.success();
    }


    // 新增员工
    // 在新增员工时，需要保存用户的基本信息，并且需要上传员工的图片（上传文件）

    // 保存文件的基本信息
    // 思路：
    // Controller层接收并封装参数，然后调用Service方法保存数据，最后响应前端
    // service层对实体类的属性进行补充，然后调用mapper接口进行保存数据操作（数据库）
    // mapper层中用SQL语句操作数据库保存员工，完成新增
    @PostMapping("/emps")
    public Result insertEmp(@RequestBody Emp emp) {
        // 记录日志
        System.out.println("新增了一个员工");
        // 调用业务层新增功能
        empService.insertEmp(emp);
        // 响应
        return Result.success();
    }



}
