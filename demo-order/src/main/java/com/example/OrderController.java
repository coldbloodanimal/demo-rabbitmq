package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: Monster
 * @date: 2019-05-07 13:41
 **/
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value="pay",method= RequestMethod.GET)
    public void pay(@RequestParam(name="orderId",required = false)String orderId) throws InterruptedException {
        if(StringUtils.isEmpty(orderId)){
            orderId=UUID.randomUUID().toString();
        }
        orderService.pay(orderId);
    }
}
