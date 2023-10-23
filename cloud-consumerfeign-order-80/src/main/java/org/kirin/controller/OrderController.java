package org.kirin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.kirin.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.CommonResult;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "paymentTimeOutFallbackMethod")
public class OrderController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("payment/get/{paymentId}")
    public CommonResult getPaymentById(@PathVariable("paymentId") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("payment/hystrix/ok")
    public CommonResult getPayment_ok(){
        CommonResult res = paymentService.getPayment_ok();
        return res;
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })


//    @HystrixCommand
    @GetMapping("payment/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="10000")
//    })
    public CommonResult getPayment_timeout_80(){
        CommonResult res = paymentService.getPayment_timeout_service80();
        return res;
    }

    public CommonResult paymentTimeOutFallbackMethod(){
        return CommonResult.fail("线程池：" + Thread.currentThread().getName() + " 80端统一的服务降级 o(╥﹏╥)o");
    }

}
