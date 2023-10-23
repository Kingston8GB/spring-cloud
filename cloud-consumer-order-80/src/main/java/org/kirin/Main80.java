package org.kirin;

import org.kirinrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@MapperScan("org.kirin.mapper")
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-payment",configuration = MyRule.class)
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class,args);
    }

//    restTemplate实现基于http的服务调用
//    必须要有@loadBalanced注解，才能根据服务名调用服务
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}