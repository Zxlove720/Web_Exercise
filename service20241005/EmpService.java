package com.wzb.service20241005;

import com.wzb.pojo20241005.PageBean;

import java.time.LocalDate;

public interface EmpService {
    PageBean pageSelect(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

}
