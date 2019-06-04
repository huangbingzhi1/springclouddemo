package com.nealin.serviceconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceConsumerApplication {

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }
    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name",defaultValue = "詹姆斯") String name){
        return restTemplate.getForObject("http://service-producer/hi?name="+name,String.class);
    }
}
