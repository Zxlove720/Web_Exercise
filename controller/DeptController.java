package com.wzb.controller;

import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import com.wzb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;


    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    // 可以使用GetMapping简化@RequestMapping注解，相当于就是将请求的模式（方法）融合到了Mapping中
    @GetMapping
    public Result getLists() {
        System.out.println("查询所有部门的信息");
        List<Dept> deptList = deptService.getDeptList();
        return Result.success(deptList);
    }

    // 可以通过{parameter}在请求路径中请求参数，然后在下面的函数中用@PathVariable注解接收请求的参数
    // 可以通过@DeleteMapping注解限定请求方式是delete，可以用于简化@RequeatMapping的注解
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        System.out.println("根据id删除部门");
        deptService.deleteDept(id);
        return Result.success();
    }

    // 要新增的部门的信息是前端页面传来的，不需要后端自己定义
    // 但是需要用@RequestBody注解将前端的json数据填充到实体类中
    @PostMapping
    public Result insertDept(@RequestBody Dept dept) {
        System.out.println("新增一个部门");
        deptService.insertDept(dept);
        return Result.success(dept);
    }

    // 前端请求数据用来更新部门，前端会发送新的部门的名字和要修改的部门的id，需要后端用一个Dept对象接收
    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        System.out.println("更新一个部门");
        deptService.updateDept(dept);
        return Result.success(dept);
    }

    // Controller层的优化：以上方法的请求，都有一个共同点：都是以/dept开头————重复了
    // 在Springboot中为了简化请求路径的定义：可以将公共的请求路径，抽取到类上，在类上加上注解@RequestMapping，
    // 并且指定请求路径"/depts"
}
