package com.zzc.cloud.controller;

import com.zzc.cloud.entities.CommonResult;
import com.zzc.cloud.entities.Payment;
import com.zzc.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：{}", result);
        return result > 0 ? new CommonResult(200, "插入数据库成功, serverPort: "+serverPort, result) : new CommonResult(444, "插入数据库失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果：{}", payment.toString());
        return payment != null ? new CommonResult(200, "查询成功, serverPort: "+serverPort, payment) : new CommonResult(444, "没有对应记录", null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object dicovery() {
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("*****element: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
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

    @GetMapping("/payment/zipkin")
    public String paymentZipKin() {
        return "hi, i'am paymentzikpin server fall back, welcome to zzc, o(n_n) 哈哈哈";
    }

}
