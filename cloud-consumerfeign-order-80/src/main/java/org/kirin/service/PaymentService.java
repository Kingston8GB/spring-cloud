package org.kirin.service;

import org.kirin.pojo.Payment;
//import org.kirin.service.impl.PaymentServiceFallback;
import org.kirin.service.impl.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utils.CommonResult;

import java.util.HashMap;
import java.util.Map;

@Service
//@FeignClient("cloud-provider-payment")
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("payment")
    CommonResult getPaymentById(@RequestParam("id") Long id);

    @GetMapping("payment/hystrix/ok")
    CommonResult getPayment_ok();

    @GetMapping("payment/hystrix/timeout")
    CommonResult getPayment_timeout_service80();

}
