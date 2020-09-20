package com.nong.cloud.payment.service;

import com.nong.cloud.starter.entities.Payment;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
public interface PaymentService {

    /**
     * 根据主键获取Payment信息
     *
     * @param serializable 主键
     * @return Payment
     */
    Payment getByPrimaryKey(long serializable);

    /**
     * 新增payment
     *
     * @param payment 支付对象
     * @return int
     */
    int save(Payment payment);
}
