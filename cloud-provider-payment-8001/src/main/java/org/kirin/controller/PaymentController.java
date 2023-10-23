package org.kirin.controller;

import org.kirin.pojo.Payment;
import org.kirin.service.PaymentService;
//import org.kirin.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import utils.CommonResult;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping
    public CommonResult getPaymentById(@RequestParam("id") Long id){
        Payment res = paymentService.getPaymentById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("res",res);
        map.put("port",serverPort);
        return CommonResult.ok(map);
    }

    @PostMapping
    public CommonResult addPayment(@RequestBody Payment payment){
        Integer rows = paymentService.addPayment(payment);
        if(rows > 0){
            Map<String, Object> res = new HashMap<>();
            res.put("rows",rows);
            System.out.println("插入数据成功！serverPort："+serverPort);
            return CommonResult.ok(res);
        }
        return CommonResult.fail(null);
    }
}
