/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author monster
 */
@Slf4j
@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private FanoutExchange fanout;

	AtomicInteger dots = new AtomicInteger(0);

	AtomicInteger count = new AtomicInteger(0);

	public void pay(String message) throws InterruptedException {
		log.info("支付订单:"+message);
		template.convertAndSend(fanout.getName(), "", message);
		//Boolean reduce=restTemplate.getForObject("http://localhost:8090/reduce?orderId="+message,Boolean.class);
		//log.info("减库存:"+(Boolean.TRUE.equals(reduce)?"成功":"失败"));
	}

}
