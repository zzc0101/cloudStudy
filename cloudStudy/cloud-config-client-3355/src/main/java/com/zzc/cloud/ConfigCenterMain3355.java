package com.zzc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : zzc0101
 * @date : 2022-10-20 23:13
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigCenterMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3355.class, args);
    }
}
