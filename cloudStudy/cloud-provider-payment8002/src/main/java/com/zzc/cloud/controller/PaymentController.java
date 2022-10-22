package com.zzc.cloud.controller;

import com.zzc.cloud.service.PaymentService;
import com.zzc.cloud.entities.CommonResult;
import com.zzc.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author : zzc0101
 * @date : 2022-06-30 09:56:30
 * @description : PaymentController 类
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：{}", result);
        return result > 0 ? new CommonResult(200, "插入数据库成功, serverPort: "+ serverPort, result) : new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：{}", payment.toString());
        return payment != null ? new CommonResult(200, "查询成功, serverPort: "+serverPort, payment) : new CommonResult(444, "没有对应记录", null);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
