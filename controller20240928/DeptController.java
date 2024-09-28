package com.wzb.controller20240928;

import com.wzb.pojo20240928.Dept;
import com.wzb.pojo20240928.Result;
import com.wzb.service20240928.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 此注解是控制层的注解
@RestController
// 此注解是为了简化请求路径，将重复的请求路径抽取到RequestMapping中
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    // 增
    @PostMapping
    public Result insertDept(@RequestBody Dept dept) {
        System.out.println("新增一个部门");
        deptService.insertDept(dept);
        return Result.success(dept);
    }

    // 删
    // 前端会在请求路径上加入id，需要在@DeleteMapping中使用{id}来接收这个id，并且用@PathVariable注解将路径变量绑定到方法参数上
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        System.out.println("删除一个部门");
        deptService.deleteDept(id);
        return Result.success();
    }

    // 改
    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        System.out.println("修改一个部门");
        deptService.updateDept(dept);
        return Result.success();
    }

    // 查
    @GetMapping
    public Result selectDept() {
        System.out.println("所有部门信息");
        List<Dept> deptList = deptService.selectDept();
        return Result.success(deptList);
    }

}
