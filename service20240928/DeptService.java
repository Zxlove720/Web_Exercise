package com.wzb.service20240928;

import com.wzb.mapper20240928.DeptMapper;
import com.wzb.pojo20240928.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    // 增
    public void insertDept(Dept dept);

    // 删
    public void deleteDept(Integer id);

    // 改
    public void updateDept(Dept dept);

    // 查
    public List<Dept> selectDept();
}
