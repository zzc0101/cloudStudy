package com.zzc.cloud.service.impl;

import com.zzc.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author : zzc0101
 * @date : 2022-09-26 20:28:31
 * @description : PaymentFallbackService 实现类
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "==========PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "==========PaymentFallbackService fall back-paymentInfo_Timeout";
    }
}
