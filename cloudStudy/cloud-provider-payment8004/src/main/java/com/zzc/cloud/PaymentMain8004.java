package com.zzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : zzc0101
 * @date : 2022-07-24 17:01:59
 * @description : payment 主启动
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 该注册用于向 consul 或者 zookeeper 作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
