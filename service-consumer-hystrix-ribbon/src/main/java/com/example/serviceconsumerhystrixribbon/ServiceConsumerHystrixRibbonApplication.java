package com.example.serviceconsumerhystrixribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@RestController
public class ServiceConsumerHystrixRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerHystrixRibbonApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @RequestMapping("hello")
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(){
        return restTemplate.getForObject("http://service-producer/hi?name=lbj",String.class);
    }
    public String helloError(){
        return "ribbon:ERROR";
    }
}
