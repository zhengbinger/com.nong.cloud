package com.nong.cloud.payment.repository;

import com.nong.cloud.starter.entities.Payment;
import org.springframework.stereotype.Repository;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@Repository
public interface PaymentRepository {

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
