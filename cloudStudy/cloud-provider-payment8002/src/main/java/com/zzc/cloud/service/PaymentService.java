package com.zzc.cloud.service;

import com.zzc.cloud.entities.Payment;
/**
 * @author : zzc0101
 * @date : 2022-06-30 09:36:09
 * @description : PaymentService 接口
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
