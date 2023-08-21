package org.example.springcloud.controller;

import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String testTimeOut(){
        return paymentFeignService.testTimeOut();
    }
}
