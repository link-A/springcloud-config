package org.example.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall paymentInfo_OK错误";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall paymentInfo_TimeOut错误";
    }
}
