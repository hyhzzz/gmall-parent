package com.atguigu.gmall.product;

import com.atguigu.gmall.common.config.Swagger2Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringCloudApplication
@Import(Swagger2Config.class)
@MapperScan("com.atguigu.gmall.product.mapper") //批量扫描就无需在每个接口上标注mapper注解
@EnableTransactionManagement //开启基于注解的自动事务管理
public class ProductMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductMainApplication.class, args);
    }
}
