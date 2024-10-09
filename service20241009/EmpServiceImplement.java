package com.wzb.service20241009;

import com.wzb.mapper20241009.EmpMapper;
import com.wzb.pojo20241009.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpServiceImplement implements EmpService{
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp selectEmp(Integer id) {
        return empMapper.selectEmp(id);
    }

    @Override
    public void update(Emp emp) {
        // 为emp补全信息————将员工的修改时间更新为当前的时间
        emp.setUpdateTime(LocalDateTime.now());
        // 调用Mapper层的方法操作数据库完成更新
        empMapper.updateEmp(emp);

    }
}
