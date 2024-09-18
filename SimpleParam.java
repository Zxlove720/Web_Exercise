package com.wzb;

import com.wzb.pojo.Student;
import com.wzb.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// RestController注解必须要
@RestController
public class SimpleParam {
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + ": " + age);
//        return "OK";
//    }

    // 简化写法
    /* 成功与否和函数名无关，主要是@RequestMapping("/getMessage")要写正确 */
    /* 但是如果要简化写法，则函数参数名字必须和请求的名字一样，否则将出现null */
    @RequestMapping("/simpleParam")
    public String A(String name, int age) {
        System.out.println(name + ": " + age);
        return "OK";
    }

    /* 不推荐写法：参数名字和请求的名字不一样，但是可以用@RequestParam完成映射(建议别这么写) */
//    public String simpleParam(@RequestParam(name = "name")String userName, Integer age) {
//        System.out.println(userName + ": " + age);
//        return "OK";
//    }

    /* 传递实体对象 */
    /* 但是请求的名字也必须和类中的属性保持一致 */
    @RequestMapping("/simplePojo")
    public String simpleParam(User user) {
        System.out.println(user);
        return "OK";
    }

    /* 传递复杂的实体对象 */
    /* 请求参数名和形参对象属性相同，按照对象层次结构关系可接收嵌套的POJO属性参数 */
    /* 如：name=tom&age=18&address.province=chongqing&address.city=chongqing */
    @RequestMapping("/complexPojo")
    public String simplePojo(Student student) {
        System.out.println(student);
        return "OK";
    }

    /* 数组集合参数 */
    /* 数组参数 */
    // 假如有多个一样的请求参数，那么可以用数组来接收，数组名字必须和请求参数相同
    @RequestMapping("/arrayParam")
    /* 假设传递hobby，有多个hobby，那么就可以用数组接收 */
    public String arrayParam(String[] hobby) {
        // 使用Arrays中的toString方法将数组的内容输出
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    /* 集合参数 */
    // 1.因为Spring默认是用数组来接收类似的请求参数，所以说想要用List集合，前面必须加上@RequestParam注解
    // 不加@RequestParam则会严重报错500
    // 2.和数组一样，集合的名字也必须和请求参数一致
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    /* 日期时间参数 */
    // 1.用LocalDateTime类作为参数
    // 2.用@DateTimeFormat中的pattern限定时间的格式
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println("现在的时间是： " + updateTime);
        return "OK";
    }

    /* json参数 */
    // 1.json请求参数必须用post发送
    // 2.用实例对象接收json参数，实例对象中的属性必须和json的key值一一对应
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody Student student) {
        System.out.println(student);
        return "OK";
    }
}
