package com.wzb.service20241009;

import com.wzb.pojo20241009.Emp;

public interface EmpService {

    public Emp selectEmp(Integer id);

    public void update(Emp emp);
}
