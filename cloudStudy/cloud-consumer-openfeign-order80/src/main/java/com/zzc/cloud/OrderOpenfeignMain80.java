package com.zzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : zzc0101
 * @date : 2022-09-04 19:27:43
 * @description : Openfeign 主启动类
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80.class, args);
    }
}
