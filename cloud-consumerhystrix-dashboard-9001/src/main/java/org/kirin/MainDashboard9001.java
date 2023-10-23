package org.kirin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MainDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainDashboard9001.class,args);
    }
}