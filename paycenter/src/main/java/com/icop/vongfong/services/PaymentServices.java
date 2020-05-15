package com.icop.vongfong.services;

import com.icop.vongfong.entities.Payment;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
public interface PaymentServices {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
