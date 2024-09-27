package com.wzb.service;

import com.wzb.mapper.DeptMapper;
import com.wzb.pojo.Dept;
import com.wzb.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DeptServiceImplement implements DeptService{
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.getDeptList();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
    }

    @Override
    public void insertDept(Dept dept) {
        // 正常的前端是不可能传递dept的创建时间和dept的修改时间的，
        // 但是数据库中有这两个字段，所以说需要在后端补齐这些前端缺少的数据
        // 注：dept的id是自己生成的，所以说前端无需传递，后端也不需要补全
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        // 修改一个部门，前端会传递id和姓名到后端，后端只需要为其补齐Update_Time的数据
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
    }
}
