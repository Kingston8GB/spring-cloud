package org.kirin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Main7001 {
    public static void main(String[] args) {
        SpringApplication.run(Main7001.class,args);
    }
}