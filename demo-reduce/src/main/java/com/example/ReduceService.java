package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReduceService {
    public void reduce(String orderId) throws InterruptedException {
        Thread.sleep(10000L);
        log.info("减库存线程id:"+Thread.currentThread().getId()+"的线程为你服务");
        log.info("订单"+orderId+"减库存成功");
    }
}
