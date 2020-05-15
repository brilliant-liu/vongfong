package com.icop.vongfong.services;

import com.icop.vongfong.dao.PaymentDao;
import com.icop.vongfong.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: liukj
 * @date: 2020/5/14
 * @description：
 */
@Service
public class PaymentServicesImpl implements PaymentServices {

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
