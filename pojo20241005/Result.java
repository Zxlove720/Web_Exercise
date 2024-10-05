package com.wzb.pojo20241005;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code; // 响应码，1是响应成功，2是响应失败
    private String message; // 响应信息，描述响应结果的字符串
    private Object data; // 响应返回的数据

    // 响应成功，但不返回数据的方法
    public static Result success() {
        return new Result(1, "success", null);
    }
    // 响应成功，并且返回数据的方法
    public static Result success(Object data) {
        return new Result(1,"success", data);
    }
    // 响应失败的方法
    public static Result fail(String message) {
        return new Result(0, message, null);
    }

}
