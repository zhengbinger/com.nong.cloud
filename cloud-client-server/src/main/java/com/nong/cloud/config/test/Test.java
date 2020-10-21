package com.nong.cloud.config.test;

import java.util.Currency;

/**
 * @author: zhengbing
 * @date: 2020/10/22
 * @email: mydreambing@126.com
 */
public class Test {
  public static void main(String[] args) {
    Currency currency = Currency.getInstance("CNY");
    System.out.println(currency.getDisplayName());
    System.out.println(currency.getNumericCode());
  }
}
