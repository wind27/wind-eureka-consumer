package com.wind.eureka.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wind.eureka.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * HelloController
 *
 * @author qianchun 17/10/9
 **/
@RestController
public class HelloController {
    @Autowired
    HelloRemote helloRemote;

    @HystrixCommand(fallbackMethod = "helloFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
    @RequestMapping("consumer")
    public String hello(HttpServletRequest request) {
        System.out.println(request.getLocalAddr().toString() + ":" + request.getLocalPort());
        return helloRemote.hello();
    }


    public String helloFallback(HttpServletRequest request) {
        return "订单查找失败！";
    }
}
