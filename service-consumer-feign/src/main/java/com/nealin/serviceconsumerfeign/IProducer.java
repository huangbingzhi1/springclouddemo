package com.nealin.serviceconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Huang.bingzhi
 * @Date 2019/6/4 14:38
 * @Version 1.0
 */
@FeignClient(value = "service-producer")
public interface IProducer {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}

