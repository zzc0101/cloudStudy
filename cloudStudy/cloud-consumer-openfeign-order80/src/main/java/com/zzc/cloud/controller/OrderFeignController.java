package com.zzc.cloud.controller;

import com.zzc.cloud.entities.CommonResult;
import com.zzc.cloud.entities.Payment;
import com.zzc.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : zzc0101
 * @date : 2022-09-04 19:34:27
 * @description : Openfeign 控制层
 **/
@RestController
@Slf4j
public class OrderFeignController {
    

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般等待 1 秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
