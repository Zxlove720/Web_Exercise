package com.wzb.service20241001;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.mapper20241001.EmpMapper;
import com.wzb.pojo20241001.Emp;
import com.wzb.pojo20241001.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImplement implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean pageSelect(Integer page, Integer pageSize, String name, Short gender,
                               LocalDate begin, LocalDate end) {
        // 使用分页插件
        PageHelper.startPage(page, pageSize);
        // 调用mapper中的方法查询并返回
        List<Emp> empList = empMapper.pageSelect(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(), p.getResult());
    }

}
