package com.wzb.Pojo20240923;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entrydate;     //LocalDate类型对应数据表中的date类型
    private Integer deptId;
    private LocalDateTime createTime;//LocalDateTime类型对应数据表中的datetime类型
    private LocalDateTime updateTime;
}
