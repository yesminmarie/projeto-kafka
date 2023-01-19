package io.github.yesminmarie.paymentservice.service.impl;

import io.github.yesminmarie.paymentservice.model.Payment;
import io.github.yesminmarie.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento da requisição {}", payment);
        Thread.sleep(1000);

        log.info("Enviando pagamento para o tópico...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
