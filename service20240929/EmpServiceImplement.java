package com.wzb.service20240929;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wzb.mapper20240929.EmpMapper;
import com.wzb.pojo20240929.Emp;
import com.wzb.pojo20240929.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImplement implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean pageAllSelect(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.getTotal();
//        // 计算想要查询页码的起始索引
//        int start = (page - 1) * pageSize;
//        // 获取分页查询的查询列表
//        List<Emp> empList = empMapper.getList(start, pageSize);
//        // 给controller层返回PageBean封装对象
//        return new PageBean(count, empList);
//    }

    @Override
    public PageBean pageAllSelect(Integer page, Integer pageSize) {
        // 设置分页参数
        // 需要传递的参数：查询第……页，每一页的页面大小（条目数量）
        PageHelper.startPage(page, pageSize);
        // 通过empMapper执行分页查询
        List<Emp> empList = empMapper.pageAllSelect();
        // 获取分页查询结果
        // 通过PageHelper插件得到的查询列表，需要进行类型转换，转换成Page<查询内容的类型>才可以使用getResult等方法
        Page<Emp> p = (Page<Emp>) empList;
        // 封装pageBean
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public PageBean pageSelect(Integer page, Integer pageSize, String name,
                               Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行条件分页查询
        List<Emp> empList = empMapper.pageSelect(name, gender, begin, end);
        //获取查询结果
        Page<Emp> p = (Page<Emp>) empList;
        //封装PageBean
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmp(ids);
    }

    @Override
    public void insertEmp(Emp emp) {
        // 因为前端无法发送创建时间、更新时间等数据，所以说后端需要对数据进行补全
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // 调用mapper中的添加方法
        empMapper.insertEmp(emp);
    }
}
