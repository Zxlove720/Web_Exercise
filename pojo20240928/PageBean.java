package com.wzb.pojo20240928;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; // 总记录数
    private List<Emp> rows; // 当前页数据列表

}
