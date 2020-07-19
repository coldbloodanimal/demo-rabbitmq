package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditService {
    public void reduce(String orderId) throws InterruptedException {
        Thread.sleep(10000L);
        log.info("信用线程id:"+Thread.currentThread().getId()+"的线程为你服务");
        log.info("订单"+orderId+"信用增加成功");
    }
}
