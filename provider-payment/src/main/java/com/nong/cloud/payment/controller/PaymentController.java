package com.nong.cloud.payment.controller;

import com.nong.cloud.payment.service.PaymentService;
import com.nong.cloud.starter.entities.Payment;
import com.nong.cloud.starter.web.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhengbing
 * @date: 2020/9/19
 * @email: mydreambing@126.com
 */
@RestController
public class PaymentController {

  @Autowired private PaymentService paymentService;

  @GetMapping("payment/{id}")
  public RestResult getById(@PathVariable long id) {
    return RestResult.success(paymentService.getByPrimaryKey(id));
  }

  @PostMapping("payment/add")
  public RestResult addPayment(@RequestBody Payment payment) {
    int add = paymentService.save(payment);
    if (add > 0) {
      return RestResult.success(add);
    } else {
      return RestResult.fail(100, "新增失败");
    }
  }
}
