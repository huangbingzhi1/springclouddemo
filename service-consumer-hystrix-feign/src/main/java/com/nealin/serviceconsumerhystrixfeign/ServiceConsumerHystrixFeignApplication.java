package com.nealin.serviceconsumerhystrixfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class ServiceConsumerHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerHystrixFeignApplication.class, args);
    }
    // 下方的依赖会报错。因为这个Bean是在程序启动的时候注入的，编译器感知不到，报错，可以不用理会。
    @Autowired
    IProducer iProducer;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "ddd") String name) {
        return iProducer.hello(name);
    }

}
