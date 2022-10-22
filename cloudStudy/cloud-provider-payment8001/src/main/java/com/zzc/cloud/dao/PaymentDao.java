package com.zzc.cloud.dao;

import com.zzc.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : zzc0101
 * @date : 2022-06-29 17:19:01
 * @description : PaymentDao 接口
 **/
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
