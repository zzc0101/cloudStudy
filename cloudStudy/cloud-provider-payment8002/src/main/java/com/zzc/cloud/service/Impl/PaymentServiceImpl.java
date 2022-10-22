package com.zzc.cloud.service.Impl;

import com.zzc.cloud.dao.PaymentDao;
import com.zzc.cloud.service.PaymentService;
import com.zzc.cloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zzc0101
 * @date : 2022-06-30 09:36:26
 * @description : PaymentService 实现类
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
