package com.icop.vongfong.dao;

import com.icop.vongfong.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
