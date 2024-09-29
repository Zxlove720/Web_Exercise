package com.wzb.service20240929;

import com.wzb.pojo20240929.Emp;
import com.wzb.pojo20240929.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean pageAllSelect(Integer page, Integer pageSize);

    PageBean pageSelect(Integer page, Integer pageSize, String name, Short gender,
                        LocalDate begin, LocalDate end);

    void deleteEmp(List<Integer> ids);

    void insertEmp(Emp emp);

}
