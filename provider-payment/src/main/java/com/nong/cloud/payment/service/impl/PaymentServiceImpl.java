package com.nong.cloud.payment.service.impl;

import com.nong.cloud.payment.repository.PaymentRepository;
import com.nong.cloud.payment.service.PaymentService;
import com.nong.cloud.starter.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getByPrimaryKey(long serializable) {
        return paymentRepository.getByPrimaryKey(serializable);
    }

    public int save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
