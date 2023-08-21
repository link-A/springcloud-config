package org.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    private static final String INVOKE_URL="http://consul-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("consumer/payment/consul")
    public String getServerPort(){
        String mess = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return "返回结果为:"+mess;
    }
}
