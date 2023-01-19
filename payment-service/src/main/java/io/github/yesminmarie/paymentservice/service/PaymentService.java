package io.github.yesminmarie.paymentservice.service;

import io.github.yesminmarie.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
