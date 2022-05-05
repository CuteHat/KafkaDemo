package com.example.kafkademo.kafka;

import com.example.kafkademo.TransactionDetails;
import com.example.kafkademo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TransactionConsumer {

    private final TransactionService transactionService;

    @KafkaListener(
            topics = "transaction-events",
            groupId = "CoolConsumers"
//            containerFactory = "listenerContainerFactor"
    )
    public void consume(
            @Payload TransactionDetails message
//            @Header(KafkaHeaders.) int partition
    ) {
        log.info("***[CONSUMER] Message: {}", message);
        transactionService.processTransaction(message);
    }
}
