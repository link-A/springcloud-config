package org.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    public String SERVICE_URL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(SERVICE_URL+"/payment/nacos/"+id,String.class);
    }

}
