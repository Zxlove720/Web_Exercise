package com.wzb.uploadController20241009;

import com.wzb.pojo20241009.Result;
import com.wzb.utils20241009.AliyunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private AliyunUtils aliyunUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        // 调用阿里云OSS工具类，将前端上传的文件存入阿里云
        String url = aliyunUtils.upload(image);
        // 将文件的url返回，主要用于浏览器回显
        return Result.success(url);
    }
}
