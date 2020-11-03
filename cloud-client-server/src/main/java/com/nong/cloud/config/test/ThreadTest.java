package com.nong.cloud.config.test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: zhengbing
 * @date: 2020/10/23
 * @email: mydreambing@126.com
 */
public class ThreadTest {

  public static void main(String[] args) {
    Callable<Object> callable = new Ticket<>();
    FutureTask<Object> task = new FutureTask<>(callable);
    Thread thread = new Thread(task);
    System.out.println(Thread.currentThread().getName());
    thread.start();
  }
}

class Ticket<Object> implements Callable<Object> {
  @Override
  public Object call() throws Exception {
    System.out.println(Thread.currentThread().getName() + " 通过Callable 实现线程");
    return (Object) new Date();
  }
}
