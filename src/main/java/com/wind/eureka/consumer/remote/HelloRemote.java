package com.wind.eureka.consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.CallableMethodReturnValueHandler;

/**
 * HelloRemote
 *
 * @author qianchun 17/10/9
 **/
@FeignClient(value= "WIND-EUREKA-PROVIDER")
public interface HelloRemote {
    @RequestMapping(value = "/provider")
    String hello();
}
