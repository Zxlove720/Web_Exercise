package com.wzb.service20240928;

import com.wzb.mapper20240928.DeptMapper;
import com.wzb.pojo20240928.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImplement implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    // 增
    @Override
    public void insertDept(Dept dept) {
        // 前端发送的数据一般只有名字，id由数据库自动生成；后端需要补全create_time和update_time
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 使用Mapper对象操作数据库
        deptMapper.insertDept(dept);
    }

    // 删
    @Override
    public void deleteDept(Integer id) {
        // 前端会发送id来指定要删除的部门，只需要直接调用deptMapper传递id即可
        deptMapper.deleteDept(id);
    }

    // 改
    public void updateDept(Dept dept) {
        // 前端在修改部门时，会传递修改后的名字和选择修改的部门的id，后端需要补全的是update_time
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }

    // 查
    public List<Dept> selectDept() {
        // 查询所有的部门信息，然后封装到List中返回
        return deptMapper.selectDept();
    }
}
