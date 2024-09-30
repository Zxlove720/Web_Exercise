package com.wzb.service;

import com.wzb.pojo20240930.Emp;
import com.wzb.pojo20240930.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean pageSelect(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
