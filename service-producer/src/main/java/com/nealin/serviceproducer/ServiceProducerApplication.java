package com.nealin.serviceproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceProducerApplication {
    @Value("${server.port}")
    String port;
    public static void main(String[] args) {
        SpringApplication.run(ServiceProducerApplication.class, args);
    }
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "lbj") String name) {
        return "您好 " + name + " ,端口:" + port;
    }
}
