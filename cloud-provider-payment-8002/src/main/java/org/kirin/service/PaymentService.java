package org.kirin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.kirin.pojo.Payment;

/**
* @author kirin
* @description 针对表【payment】的数据库操作Service
* @createDate 2023-10-21 00:18:00
*/
public interface PaymentService extends IService<Payment> {

//    Payment getPaymentById(Integer id);

    Payment getPaymentById(Long id);

    Integer addPayment(Payment payment);
}
