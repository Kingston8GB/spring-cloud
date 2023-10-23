package org.kirin.service.impl;

import org.kirin.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import utils.CommonResult;

/**
 * 消费端service层的服务降级实现类
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return CommonResult.fail("服务调用失败，提示来自：80service层服务降级");
    }

    @Override
    public CommonResult getPayment_ok() {
        return CommonResult.fail("服务调用失败，提示来自：80service层服务降级");
    }

    @Override
    public CommonResult getPayment_timeout_service80() {
        return CommonResult.fail("服务调用失败，提示来自：80service层服务降级");
    }
}
