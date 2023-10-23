package org.kirin.controller;

//import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.kirin.pojo.Payment;
import org.kirin.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import utils.CommonResult;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private Integer serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("服务名：" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            }
        }

        return discoveryClient;
    }
}
