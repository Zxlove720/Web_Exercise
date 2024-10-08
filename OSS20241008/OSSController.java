package com.wzb.OSS20241008;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wzb.pojo20241008.Result;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class OSSController {
    // 使用阿里云对象存储OSS的步骤：
    // 1.创建bucket
    // 2.获取AccessKey（密钥）
    // 3.引入相关依赖
    // 4.案例集成OSS

    // Bucket：存储空间是用户用于存储对象（Object，也就是文件）的容器，所有的对象都必须隶属于某个存储空间
    @PostMapping("/OSSupload")
    public Result OSSUpload(String userName, Integer age, MultipartFile image) throws com.aliyuncs.exceptions.ClientException {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-chengdu.aliyuncs.com";
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "wzb-study";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
                endpoint,
                credentialsProvider.getCredentials().getAccessKeyId(),
                credentialsProvider.getCredentials().getSecretAccessKey()
        );

        try {
            // 创建存储空间。
            ossClient.createBucket(bucketName);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return Result.success();
    }
}






