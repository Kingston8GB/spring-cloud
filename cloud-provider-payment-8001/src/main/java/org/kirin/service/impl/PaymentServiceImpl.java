package org.kirin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.kirin.pojo.Payment;
import org.kirin.service.PaymentService;
import org.kirin.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author kirin
* @description 针对表【payment】的数据库操作Service实现
* @createDate 2023-10-21 00:18:00
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

    @Autowired
    PaymentMapper paymentMapper;
    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = paymentMapper.selectById(id);
        return payment;
    }

    @Override
    public Integer addPayment(Payment payment) {
        int rows = paymentMapper.insert(payment);
        return rows;
    }
}




