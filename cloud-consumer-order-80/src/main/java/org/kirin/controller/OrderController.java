package org.kirin.controller;

//import org.kirin.pojo.Payment;
//import org.kirin.service.PaymentService;
//import org.kirin.utils.CommonResult;
import org.kirin.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import utils.CommonResult;

@RestController
@RequestMapping("consumer")
//@PropertySource("classpath:constant.properties")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${custom.payment_url}")
    private String PAYMENT_SERVER_URL = null;

    @GetMapping("payment/get")
    public CommonResult getPaymentById(@RequestParam("id") Long id){
        System.out.println(PAYMENT_SERVER_URL);
        CommonResult res = restTemplate.getForObject(PAYMENT_SERVER_URL + "payment?id=" + id,CommonResult.class,id);
        if (res != null) {
            return CommonResult.ok(res.getData());
        }
        return CommonResult.fail(null);
    }

    @GetMapping("payment/add")
    public CommonResult addPayment(@RequestBody Payment payment){
        CommonResult res = restTemplate.postForObject(PAYMENT_SERVER_URL + "payment",payment,CommonResult.class);
        if (res != null) {
            return CommonResult.ok(res.getData());
        }
        return CommonResult.fail(null);
    }

    @GetMapping("payment/addForEntity")
    public CommonResult addPaymentForEntity(@RequestBody Payment payment){
        CommonResult result = restTemplate.postForEntity(PAYMENT_SERVER_URL + "payment", payment, CommonResult.class).getBody();
        return result;
    }
}
