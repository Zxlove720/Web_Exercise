package com.wzb.UploadController20241008;

import com.wzb.pojo20241008.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

//    @PostMapping("/upload")
//    public Result upload(String userName, Integer age, MultipartFile image) {
//        // Spring提供的上传文件的API：MultipartFile必须在方法参数中声明，并且实体类名必须和表单名相同
//        System.out.println("文件上传");
//        return Result.success();
//
//    }

    // 文件若只是单纯的上传，不做处理，那么在文件上传之后，会将表单提交的数据分别存储在不同的临时文件中（.tmp），当
    // 程序运行完毕之后，.tmp临时文件将自动删除，这不符合文件上传的需求，也许需要将文件本地存储

//     将前端页面上传的文件在服务器本地存储
//     1.在服务器本地磁盘中创建一个目录，用于存储上传的文件
//     2.使用MultipartFile中的方法，将临时文件转存到本地磁盘的目录下
//     -- MultipartFile的常见方法
//          String getOriginalFilename() 获取原始的文件名
//          void transferTo(File dest) 将接收的文件转存到本地磁盘的指定位置
//          long getSize() 获取文件的大小 单位：字节
//          byte[] getBytes() 获取文件内容的字节数组
//          InputStream getInputStream() 获取接收到的文件内容的输入流

//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        System.out.println("文件上传测试");
//        // 获取原始的文件名
//        String originalFileName = image.getOriginalFilename();
//        // 将文件存储在服务器的本地磁盘目录
//        image.transferTo(new File("E:/images/" + originalFileName));
//        // 响应结果
//        return Result.success();
//    }
    // 发现成功上传了一个文件，并且能够成功的保存在服务器的本地，但是存在一个问题————上传单个文件是没有问题的，但是
    // 若上传了多个文件，存在同名的文件，那么后上传的文件就会将本地已经存在的文件覆盖掉，这不符合需求


    // 解决上传同名文件的文件覆盖问题：保证每次上传文件时，文件名都是唯一的（使用UUID获取随机的文件名）
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        System.out.println("文件上传");
        // 获取原始文件名————此处获取原始文件名只是为了获得文件的类型
        String originalFileName = image.getOriginalFilename();
        // 通过UUID构建新的文件名：随机的UUID作为文件名，通过原始文件名得到文件类型，二者拼接可以得到新的文件名
        String externalName = ".txt"; // 默认是文本文档
        if (originalFileName != null) {
            externalName = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 这个substring截取的意思是，从最后一个.开始截取，所以说这就是文件扩展名
        }
        String newFileName = UUID.randomUUID().toString() + externalName;
        // 将UUID为文件名的文件存储到服务器的磁盘目录
        image.transferTo(new File("E:/images/" + newFileName));
        // 响应
        return Result.success();
    }
    // 使用UUID改造文件名可以成功解决文件名重复替代的问题，但是发现上传一个较大的文件时（超过1M），后端程序报错
    // 原因：SpringBoot中，配置了文件上传时单个文件最大大小是1M
    // 想要上传大文件，需要在application.properties中进行配置

    // 本地存储到此处就完成了，但是将上传的文件存储到服务器本地是不会使用的
    // 1.在服务器本地存储的资源不能直接访问
    // 2.服务器磁盘资源珍贵，不适合存储大量无用的文件
    // 3.服务器集群方式，不方便扩容，磁盘满了难以扩容
    // 4.磁盘坏了就直接寄

    // 所以说为了解决文件本地存储的问题，可以使用云存储
}
