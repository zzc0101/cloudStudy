package com.zzc.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zzc.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zzc0101
 * @date : 2022-09-10 20:59:45
 * @description : OrderHystrix
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        log.info("123");
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        log.info("456");
        return "我是消费者80，对方支付系统繁忙，请10秒钟以后再试或者自己运行错误请检查自己，😫";
    }

    // 下面是全局 Fallback 方法
    public String payment_Global_FallbackMethod(Integer id) {
        return "Global 异常处理信息，请稍后再试，😫";
    }

}
