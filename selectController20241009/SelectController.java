package com.wzb.selectController20241009;

import com.wzb.pojo20241009.Emp;
import com.wzb.pojo20241009.Result;
import com.wzb.service20241009.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectController {

    // 查询回显
    // 将员工上传的图片查询之后回显到前端页面中（返回的是url，会自动下载）

    @Autowired
    private EmpService empService;

    // 根据id查询
    @GetMapping("/select/{id}")
    public Result selectEmp(@PathVariable Integer id) {
        Emp emp = empService.selectEmp(id);
        return Result.success(emp);
    }



}
