package com.wzb.service20240928;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.mapper20240928.EmpMapper;
import com.wzb.pojo20240928.Emp;
import com.wzb.pojo20240928.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImplement implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean pageSelect(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.countItem();
//
//        // 获取分页查询的结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.pageSelect(start, pageSize);
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.pageSelect(start, pageSize);
        // 获取分页结果
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }
}
