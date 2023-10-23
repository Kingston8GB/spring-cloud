package org.kirin.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.kirin.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String getPayment_ok() {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK"+"\t"+"O(∩_∩)O";
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="800")
//    })
    @Override
    public String getPayment_timeout() {
//        int num = 20/0;
//        int timeoutSeconds = 0;
//        System.out.println("timeoutSeconds = " + timeoutSeconds);
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("timeout " + Thread.currentThread().getName());
//        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_timeout"+"\t"+",等待秒数：" + timeoutSeconds;
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_timeout 服务侧处理完成";
    }
    public String paymentInfo_TimeOutHandler(){
        return "线程池:"+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler o(╥﹏╥)o";

    }
}
