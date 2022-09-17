package com.atguigu.gmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author coderhyh
 * @create 2022-09-17 19:13
 */

//@SpringBootApplication
//@EnableDiscoveryClient //开启注册发现功能   请求交给网关，网关得转发给后面的微服务，所以得注册到注册中心上去 进行服务发现
//@EnableCircuitBreaker //熔断
//@RefreshScope //自动配置刷新 生产不推荐这里开启
@SpringCloudApplication // 三合一 @EnableCircuitBreaker+@EnableDiscoveryClient +@SpringBootApplication
public class GateWayMainApplication {

    public static void main(String[] args) {

        SpringApplication.run(GateWayMainApplication.class, args);
    }
}
