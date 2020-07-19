/*
 * Copyright 2015-2018 the original author or authors.
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

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author monster
 */

@Configuration
public class OrderMessageQueueConfig {
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("pay");
	}

	@Bean
	public Queue reduceQueue() {
		return new Queue("reduce");
	}

	@Bean
	public Binding binding(FanoutExchange fanout, Queue queue) {
		return BindingBuilder.bind(queue).to(fanout);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
