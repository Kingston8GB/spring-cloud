package org.kirin.controller;

import org.kirin.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CommonResult;

import java.util.Locale;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("hystrix/ok")
    public CommonResult getPayment_ok(){
        String res = paymentService.getPayment_ok();
        return CommonResult.ok(res);
    }

    @GetMapping("hystrix/timeout")
    public CommonResult getPayment_timeout(){
        String res = paymentService.getPayment_timeout();
        return CommonResult.ok(res);
    }
}
