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
public class ReduceController {

    @Autowired
    ReduceService reduceService;

    @RequestMapping(value="reduce",method= RequestMethod.GET)
    public Boolean reduce(@RequestParam(name="orderId")String orderId) throws InterruptedException {
        reduceService.reduce(orderId);
        return true;
    }
}
