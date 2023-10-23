package org.kirin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class OrderController {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("payment")
    public Object payment(){
        ServiceInstance instance = discoveryClient.getInstances("consul-provider-payment").get(0);
        String host = instance.getUri().getHost();
        int port = instance.getPort();

//        String res = restTemplate.getForObject("http://" + host + ":" + port + "/payment/consul", String.class);

        String serviceId = instance.getServiceId();
        String res = restTemplate.getForObject("http://" + serviceId + "/payment/consul", String.class);


        return res;
    }
}
