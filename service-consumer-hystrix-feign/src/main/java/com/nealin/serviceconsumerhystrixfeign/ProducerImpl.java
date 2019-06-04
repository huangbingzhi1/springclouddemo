package com.nealin.serviceconsumerhystrixfeign;

import org.springframework.stereotype.Component;

/**
 * @Author Huang.bingzhi
 * @Date 2019/6/4 16:46
 * @Version 1.0
 */
@Component
public class ProducerImpl implements IProducer {
    @Override
    public String hello(String name) {
        return "feign: producer:hello:Error";
    }
}
