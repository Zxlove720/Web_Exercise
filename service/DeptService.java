package com.wzb.service;


import com.wzb.pojo.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> getDeptList();

    public void deleteDept(Integer id);

    public void insertDept(Dept dept);

    public void updateDept(Dept dept);

}
