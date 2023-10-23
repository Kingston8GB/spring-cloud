package org.kirin.service;


public interface PaymentService {
    String getPayment_ok();

    String getPayment_timeout();

    public String paymentInfo_TimeOutHandler();
}
