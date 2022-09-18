package com.atguigu.gmall.product.config.minio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author coderhyh
 * @create 2022-09-18 8:22
 */


//和配置文件绑定的
//自动把配置文件中 app.minio 下配置的每个属性全部和这个JavaBean的属性一一对应
@Component
@ConfigurationProperties(prefix = "app.minio")
@Data
public class MinioProperties {

    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}

