package com.wzb.utils20241009;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component // 使用@Component注解将AliyunUtils加入IOC容器，便于自动注入
public class AliyunUtils {
    // 每次都从头开始写阿里云OSS的上传代码是十分麻烦的，所以说可以根据官方示例代码将其改造为工具类，便于使用

    // 定义常量，这些都是关于OSS的基础配置，包括endpoint，accessKey，bucketName，一般情况下都是不会更改的
//    private final String endpoint = "https://oss-cn-chengdu.aliyuncs.com";
//    private final String accessKeyId = "LTAI5tKr5ZzpE1BRJ4yHGEVQ";
//    private final String accessKeySecret = "DqZAfe3cXfX79J72RmcszqEX0wG3D5";
//    private final String bucketName = "wzb-study";

    // 以上关于阿里云相关的配置信息，直接被写死在了Java代码之中（硬编码），参数硬编码涉及的问题
    // 1.若参数发生了变化，那么就必须在源代码中改变这些参数，并且需要将代码重新进行编译
    // 2.真实的企业级Java项目，Java类将会很多，若将参数分散定义在各个Java类中，若修改了一个值，我们就需要在众多的Java代码中
    // 定位到对应的位置，然后再修改参数，修改后还需要再次重新编译运行（参数配置分散，不便集中管理和维护）

    // 所以说为了解决硬编码的相关问题，我们可以将参数配置在配置文件中
    // 但需要将配置文件中配置的属性读取出来，并且分别赋值给AliyunUtils工具类中的属性
    // 方法：
    // application.properties是springboot项目默认的配置文件，所以springboot程序在启动时会默认读取application.properties
    // 配置文件，可以使用@Value注解获取配置文件中的数据
    // @Value注解通常用于外部配置属性的注入， @Value("${配置文件中的key}")
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;
    // 但直接使用@Value注解注入，写起来将会比较繁琐
    // 解决方式：
    // 1.创建一个实体类，实体类的属性名和配置文件中的key名字必须一致，并且实体类中需要get/set方法
    // 2.将实体类加入IOC容器，成为IOC容器的bean对象
    // 3.使用@ConfigurationProperties注解，并且通过perfect属性指定配置参数的前缀

    @Autowired
    private AliyunProperties aliyunProperties;



    // 实现上传图片到OSS的功能
    public String upload(MultipartFile multipartFile) throws IOException {
        // 获取上传的文件的输入流
        InputStream inputStream = multipartFile.getInputStream();
        // 使用UUID修改文件名，避免重名文件覆盖
        String originalFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() +
                originalFileName.substring(originalFileName.lastIndexOf("."));
        // 上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(aliyunProperties.getEndpoint(), aliyunProperties.getAccessKeyId(),
                aliyunProperties.getAccessKeySecret());
        ossClient.putObject(aliyunProperties.getBucketName(), fileName, inputStream);

        // 获取文件的访问路径
        String url = aliyunProperties.getEndpoint().split("//")[0] +
                aliyunProperties.getBucketName() + "." + aliyunProperties.getEndpoint().split("//")[1] + "/" + fileName;

        // 关闭ossClient
        ossClient.shutdown();
        return url;
    }
}
