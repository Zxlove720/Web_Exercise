package com.wzb.controller20241001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.wzb.pojo20241001.PageBean;
import com.wzb.pojo20241001.Result;
import com.wzb.service20241001.EmpService;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    // @RequestParam接收前端传递的想要查询的页数和每一页的记录数
    public Result pageSelect(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Short gender,
                             // 因为Http请求的路径全部都是字符串，所以说要用@DateTimeFormat注解并限定其格式将String解析为LocalDate
                             @DateTimeFormat(pattern = ("yyyy-MM-dd")) LocalDate begin,
                             @DateTimeFormat(pattern = ("yyyy-MM-dd")) LocalDate end) {
        // 日志记录
        System.out.println("进行了一次条件查询");
        // 通过Service层，操作数据库，并将查询的数据封装到PageBean中返回
        PageBean pageBean = empService.pageSelect(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }
}
