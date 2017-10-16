package com.wind.eureka.consumer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients(basePackages = ("com.wind.eureka.consumer.remote"))
@SpringBootApplication(scanBasePackages = "com.wind.eureka.consumer.controller")
public class WindEurekaConsumerApplication {

	//使用RestTemplate方式调用时需要，定义这个bean
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(WindEurekaConsumerApplication.class, args);
	}
}
