package com.wzb.controller20241009;


import com.wzb.pojo20241009.Emp;
import com.wzb.pojo20241009.Result;
import com.wzb.service20241009.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
    // 该接口用于修改员工的数据信息

    @Autowired
    private EmpService empService;

    @PutMapping("/update/emps")
    public Result updateEmp(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
